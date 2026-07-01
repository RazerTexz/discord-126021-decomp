package com.discord.utilities.bugreports;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences$Editor;
import com.discord.screenshot_detection.ScreenshotDetector;
import com.discord.screenshot_detection.ScreenshotDetector$Screenshot;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.bugreports.WidgetBugReport;
import d0.g;
import d0.z.d.m;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: BugReportManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class BugReportManager {
    public static final BugReportManager$Companion Companion = new BugReportManager$Companion(null);
    public static final String PREFS_SS_BUG_REPORTING_SETTINGS_ENABLED = "prefs_ss_bug_reporting_enabled";
    private static BugReportManager bugReportManager;
    private final SharedPreferences cache;
    private boolean isStaff;

    /* JADX INFO: renamed from: screenshotDetector$delegate, reason: from kotlin metadata */
    private final Lazy screenshotDetector;
    private boolean settingsEnabled;
    private final StoreUser storeUser;

    public BugReportManager(SharedPreferences sharedPreferences, StoreUser storeUser) {
        m.checkNotNullParameter(sharedPreferences, "cache");
        m.checkNotNullParameter(storeUser, "storeUser");
        this.cache = sharedPreferences;
        this.storeUser = storeUser;
        this.settingsEnabled = true;
        this.screenshotDetector = g.lazy(BugReportManager$screenshotDetector$2.INSTANCE);
        this.settingsEnabled = sharedPreferences.getBoolean(PREFS_SS_BUG_REPORTING_SETTINGS_ENABLED, true);
    }

    public static final /* synthetic */ BugReportManager access$getBugReportManager$cp() {
        return bugReportManager;
    }

    public static final /* synthetic */ void access$setBugReportManager$cp(BugReportManager bugReportManager2) {
        bugReportManager = bugReportManager2;
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

    public final void onScreenshot(Context context, ScreenshotDetector$Screenshot screenshot) {
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(screenshot, "screenshot");
        if (isEnabled()) {
            WidgetBugReport.Companion.launch(context, screenshot);
        }
    }

    public final void setBugReportingSettingEnabled(boolean enabled) {
        SharedPreferences$Editor sharedPreferences$EditorEdit = this.cache.edit();
        m.checkNotNullExpressionValue(sharedPreferences$EditorEdit, "editor");
        sharedPreferences$EditorEdit.putBoolean(PREFS_SS_BUG_REPORTING_SETTINGS_ENABLED, enabled);
        sharedPreferences$EditorEdit.apply();
        this.settingsEnabled = enabled;
        getScreenshotDetector().a(isEnabled());
    }

    public final void setUserIsStaff(boolean isStaff) {
        this.isStaff = isStaff;
        getScreenshotDetector().a(isEnabled());
    }

    public final void setupSubscriptions() {
        Observable observableR = this.storeUser.observeMe(true).G(BugReportManager$setupSubscriptions$1.INSTANCE).r();
        m.checkNotNullExpressionValue(observableR, "storeUser.observeMe(emit… }.distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(observableR, BugReportManager.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new BugReportManager$setupSubscriptions$2(this), 62, (Object) null);
    }

    public /* synthetic */ BugReportManager(SharedPreferences sharedPreferences, StoreUser storeUser, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(sharedPreferences, (i & 2) != 0 ? StoreStream.Companion.getUsers() : storeUser);
    }
}
