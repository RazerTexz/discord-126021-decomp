package com.discord.utilities.bugreports;

import android.content.Context;
import android.content.SharedPreferences;
import com.discord.models.user.MeUser;
import com.discord.screenshot_detection.ScreenshotDetector;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.cache.SharedPreferencesProvider;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.user.UserUtils;
import com.discord.widgets.bugreports.WidgetBugReport;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.C12083g;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p658rx.Observable;
import p658rx.Subscription;

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
                C12238m.throwUninitializedPropertyAccessException("bugReportManager");
            }
            return bugReportManager;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void init() {
            BugReportManager.bugReportManager = new BugReportManager(SharedPreferencesProvider.INSTANCE.get(), null, 2, 0 == true ? 1 : 0);
            BugReportManager bugReportManager = BugReportManager.bugReportManager;
            if (bugReportManager == null) {
                C12238m.throwUninitializedPropertyAccessException("bugReportManager");
            }
            bugReportManager.setupSubscriptions();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.bugreports.BugReportManager$setupSubscriptions$2 */
    /* JADX INFO: compiled from: BugReportManager.kt */
    public static final class C67112 extends AbstractC12240o implements Function1<Boolean, Unit> {
        public C67112() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke2(bool);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Boolean bool) {
            BugReportManager bugReportManager = BugReportManager.this;
            C12238m.checkNotNullExpressionValue(bool, "isStaff");
            bugReportManager.setUserIsStaff(bool.booleanValue());
        }
    }

    public BugReportManager(SharedPreferences sharedPreferences, StoreUser storeUser) {
        C12238m.checkNotNullParameter(sharedPreferences, "cache");
        C12238m.checkNotNullParameter(storeUser, "storeUser");
        this.cache = sharedPreferences;
        this.storeUser = storeUser;
        this.settingsEnabled = true;
        this.screenshotDetector = C12083g.lazy(BugReportManager$screenshotDetector$2.INSTANCE);
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
        C12238m.checkNotNullParameter(context, "context");
        C12238m.checkNotNullParameter(screenshot, "screenshot");
        if (isEnabled()) {
            WidgetBugReport.INSTANCE.launch(context, screenshot);
        }
    }

    public final void setBugReportingSettingEnabled(boolean enabled) {
        SharedPreferences.Editor editorEdit = this.cache.edit();
        C12238m.checkNotNullExpressionValue(editorEdit, "editor");
        editorEdit.putBoolean(PREFS_SS_BUG_REPORTING_SETTINGS_ENABLED, enabled);
        editorEdit.apply();
        this.settingsEnabled = enabled;
        getScreenshotDetector().m8505a(isEnabled());
    }

    public final void setUserIsStaff(boolean isStaff) {
        this.isStaff = isStaff;
        getScreenshotDetector().m8505a(isEnabled());
    }

    public final void setupSubscriptions() {
        Observable observableM11112r = this.storeUser.observeMe(true).m11083G(new InterfaceC12589b<MeUser, Boolean>() { // from class: com.discord.utilities.bugreports.BugReportManager.setupSubscriptions.1
            @Override // p637j0.p641k.InterfaceC12589b
            public final Boolean call(MeUser meUser) {
                UserUtils userUtils = UserUtils.INSTANCE;
                C12238m.checkNotNullExpressionValue(meUser, "it");
                return Boolean.valueOf(userUtils.isStaff(meUser));
            }
        }).m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "storeUser.observeMe(emit… }.distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe(observableM11112r, (Class<?>) BugReportManager.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C67112());
    }

    public /* synthetic */ BugReportManager(SharedPreferences sharedPreferences, StoreUser storeUser, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(sharedPreferences, (i & 2) != 0 ? StoreStream.INSTANCE.getUsers() : storeUser);
    }
}
