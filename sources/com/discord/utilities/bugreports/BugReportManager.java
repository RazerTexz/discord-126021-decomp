package com.discord.utilities.bugreports;

import android.content.Context;
import android.content.SharedPreferences;
import com.discord.models.user.MeUser;
import com.discord.screenshot_detection.ScreenshotDetector;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.cache.SharedPreferencesProvider;
import com.discord.utilities.error.Error;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.user.UserUtils;
import com.discord.widgets.bugreports.WidgetBugReport;
import d0.LazyJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Subscription;

/* JADX INFO: compiled from: BugReportManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class BugReportManager {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String PREFS_SS_BUG_REPORTING_SETTINGS_ENABLED = "prefs_ss_bug_reporting_enabled";
    private static BugReportManager bugReportManager;
    private final SharedPreferences cache;
    private boolean isStaff;

    /* JADX INFO: renamed from: screenshotDetector$delegate, reason: from kotlin metadata */
    private final Lazy screenshotDetector;
    private boolean settingsEnabled;
    private final StoreUser storeUser;

    /* JADX INFO: compiled from: BugReportManager.kt */
    public static final class Companion {
        private Companion() {
        }

        public final BugReportManager get() {
            BugReportManager bugReportManager = BugReportManager.bugReportManager;
            if (bugReportManager == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("bugReportManager");
            }
            return bugReportManager;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void init() {
            BugReportManager.bugReportManager = new BugReportManager(SharedPreferencesProvider.INSTANCE.get(), null, 2, 0 == true ? 1 : 0);
            BugReportManager bugReportManager = BugReportManager.bugReportManager;
            if (bugReportManager == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("bugReportManager");
            }
            bugReportManager.setupSubscriptions();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.bugreports.BugReportManager$setupSubscriptions$2, reason: invalid class name */
    /* JADX INFO: compiled from: BugReportManager.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<Boolean, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke2(bool);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Boolean bool) {
            BugReportManager bugReportManager = BugReportManager.this;
            Intrinsics3.checkNotNullExpressionValue(bool, "isStaff");
            bugReportManager.setUserIsStaff(bool.booleanValue());
        }
    }

    public BugReportManager(SharedPreferences sharedPreferences, StoreUser storeUser) {
        Intrinsics3.checkNotNullParameter(sharedPreferences, "cache");
        Intrinsics3.checkNotNullParameter(storeUser, "storeUser");
        this.cache = sharedPreferences;
        this.storeUser = storeUser;
        this.settingsEnabled = true;
        this.screenshotDetector = LazyJVM.lazy(BugReportManager2.INSTANCE);
        this.settingsEnabled = sharedPreferences.getBoolean(PREFS_SS_BUG_REPORTING_SETTINGS_ENABLED, true);
    }

    private final ScreenshotDetector getScreenshotDetector() {
        return (ScreenshotDetector) this.screenshotDetector.getValue();
    }

    public final SharedPreferences getCache() {
        return this.cache;
    }

    public final StoreUser getStoreUser() {
        return this.storeUser;
    }

    /* JADX INFO: renamed from: isBugReportSettingEnabled, reason: from getter */
    public final boolean getSettingsEnabled() {
        return this.settingsEnabled;
    }

    public final boolean isEnabled() {
        return this.isStaff && this.settingsEnabled;
    }

    public final void onScreenshot(Context context, ScreenshotDetector.Screenshot screenshot) {
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(screenshot, "screenshot");
        if (isEnabled()) {
            WidgetBugReport.INSTANCE.launch(context, screenshot);
        }
    }

    public final void setBugReportingSettingEnabled(boolean enabled) {
        SharedPreferences.Editor editorEdit = this.cache.edit();
        Intrinsics3.checkNotNullExpressionValue(editorEdit, "editor");
        editorEdit.putBoolean(PREFS_SS_BUG_REPORTING_SETTINGS_ENABLED, enabled);
        editorEdit.apply();
        this.settingsEnabled = enabled;
        getScreenshotDetector().a(isEnabled());
    }

    public final void setUserIsStaff(boolean isStaff) {
        this.isStaff = isStaff;
        getScreenshotDetector().a(isEnabled());
    }

    public final void setupSubscriptions() {
        Observable observableR = this.storeUser.observeMe(true).G(new Func1<MeUser, Boolean>() { // from class: com.discord.utilities.bugreports.BugReportManager.setupSubscriptions.1
            @Override // j0.k.Func1
            public final Boolean call(MeUser meUser) {
                UserUtils userUtils = UserUtils.INSTANCE;
                Intrinsics3.checkNotNullExpressionValue(meUser, "it");
                return Boolean.valueOf(userUtils.isStaff(meUser));
            }
        }).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "storeUser.observeMe(emit… }.distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe(observableR, (Class<?>) BugReportManager.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass2());
    }

    public /* synthetic */ BugReportManager(SharedPreferences sharedPreferences, StoreUser storeUser, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(sharedPreferences, (i & 2) != 0 ? StoreStream.INSTANCE.getUsers() : storeUser);
    }
}
