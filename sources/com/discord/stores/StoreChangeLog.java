package com.discord.stores;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences$Editor;
import b.i.a.f.e.o.f;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.SnowflakeUtils;
import com.discord.utilities.string.StringUtilsKt;
import com.discord.utilities.time.Clock;
import com.discord.widgets.changelog.WidgetChangeLog;
import com.discord.widgets.changelog.WidgetChangeLog$Companion;
import com.discord.widgets.changelog.WidgetChangeLogSpecial;
import com.discord.widgets.changelog.WidgetChangeLogSpecial$Companion$ExitStyle;
import d0.g0.t;
import d0.g0.w;
import d0.z.d.m;
import s.a.k0;
import s.a.x0;

/* JADX INFO: compiled from: StoreChangeLog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreChangeLog extends Store {
    public Application app;
    private final Clock clock;
    private final Dispatcher dispatcher;
    private final StoreExperiments experiments;
    private final StoreNotices notices;
    private final StoreUserSettingsSystem userSettingsSystem;
    private final StoreUser users;

    public StoreChangeLog(Clock clock, StoreNotices storeNotices, StoreUser storeUser, StoreUserSettingsSystem storeUserSettingsSystem, StoreExperiments storeExperiments, Dispatcher dispatcher) {
        m.checkNotNullParameter(clock, "clock");
        m.checkNotNullParameter(storeNotices, "notices");
        m.checkNotNullParameter(storeUser, "users");
        m.checkNotNullParameter(storeUserSettingsSystem, "userSettingsSystem");
        m.checkNotNullParameter(storeExperiments, "experiments");
        m.checkNotNullParameter(dispatcher, "dispatcher");
        this.clock = clock;
        this.notices = storeNotices;
        this.users = storeUser;
        this.userSettingsSystem = storeUserSettingsSystem;
        this.experiments = storeExperiments;
        this.dispatcher = dispatcher;
    }

    public static final /* synthetic */ Dispatcher access$getDispatcher$p(StoreChangeLog storeChangeLog) {
        return storeChangeLog.dispatcher;
    }

    private final StoreNotices$Notice createChangeLogNotice() {
        return new StoreNotices$Notice("CHANGE_LOG", null, 1337L, 0, true, null, 0L, false, 604800000L, new StoreChangeLog$createChangeLogNotice$1(this), 226, null);
    }

    private final String getChangelogExperimentString(Context context, String name, String fallback) {
        int identifier = context.getResources().getIdentifier(name, "string", context.getPackageName());
        if (identifier <= 0) {
            return fallback;
        }
        String string = context.getString(identifier);
        m.checkNotNullExpressionValue(string, "context.getString(id)");
        return string;
    }

    private final String getLastSeenChangeLogVersion() {
        return getPrefs().getString("CACHE_KEY_VIEWED_CHANGE_LOG_VERSION", "");
    }

    private final boolean isTooYoung(long userId) {
        long j = (userId >>> 22) + SnowflakeUtils.DISCORD_EPOCH + 432000000;
        long firstUseTimestamp = this.notices.getFirstUseTimestamp() + 432000000;
        long jCurrentTimeMillis = this.clock.currentTimeMillis();
        return jCurrentTimeMillis < j || jCurrentTimeMillis < firstUseTimestamp;
    }

    public static /* synthetic */ void openChangeLog$default(StoreChangeLog storeChangeLog, Context context, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = false;
        }
        storeChangeLog.openChangeLog(context, z2);
    }

    private final void setLastSeenChangeLogVersion(String str) {
        SharedPreferences$Editor sharedPreferences$EditorEdit = getPrefs().edit();
        m.checkNotNullExpressionValue(sharedPreferences$EditorEdit, "editor");
        sharedPreferences$EditorEdit.putString("CACHE_KEY_VIEWED_CHANGE_LOG_VERSION", str);
        sharedPreferences$EditorEdit.apply();
    }

    private final boolean shouldShowChangelog(Context context, long userId, String targetLanguage, Integer experimentBucket) {
        String string;
        int identifier = (experimentBucket != null && experimentBucket.intValue() == 1) ? context.getResources().getIdentifier("change_log_md_experiment_body", "string", context.getPackageName()) : 2131887517;
        CharSequence stringByLocale = StringUtilsKt.getStringByLocale(context, identifier, "en");
        CharSequence stringByLocale2 = StringUtilsKt.getStringByLocale(context, identifier, targetLanguage);
        if ((!m.areEqual(targetLanguage, "en")) && m.areEqual(stringByLocale, stringByLocale2)) {
            return false;
        }
        if (experimentBucket != null && experimentBucket.intValue() == 1) {
            String string2 = context.getString(2131887518);
            m.checkNotNullExpressionValue(string2, "context.getString(R.string.change_log_md_date)");
            string = getChangelogExperimentString(context, "change_log_md_experiment_date", string2);
        } else {
            string = context.getString(2131887518);
            m.checkNotNullExpressionValue(string, "context.getString(R.string.change_log_md_date)");
        }
        String lastSeenChangeLogVersion = getLastSeenChangeLogVersion();
        if (!(lastSeenChangeLogVersion == null || t.isBlank(lastSeenChangeLogVersion)) && !isTooYoung(userId)) {
            return !m.areEqual(string, getLastSeenChangeLogVersion());
        }
        markSeen(string);
        return false;
    }

    public final Application getApp() {
        Application application = this.app;
        if (application == null) {
            m.throwUninitializedPropertyAccessException("app");
        }
        return application;
    }

    @StoreThread
    public final void handleConnectionOpen() {
        f.H0(x0.j, k0.a, null, new StoreChangeLog$handleConnectionOpen$1(this, null), 2, null);
    }

    @StoreThread
    public final void handlePostConnectionOpen() {
        String str = (String) w.split$default((CharSequence) this.userSettingsSystem.getLocale(), new String[]{"-"}, false, 0, 6, (Object) null).get(0);
        long id2 = this.users.getMeSnapshot().getId();
        Application application = this.app;
        if (application == null) {
            m.throwUninitializedPropertyAccessException("app");
        }
        if (shouldShowChangelog(application, id2, str, null)) {
            this.notices.requestToShow(createChangeLogNotice());
        }
    }

    @StoreThread
    public final void init(Application app) {
        m.checkNotNullParameter(app, "app");
        init((Context) app);
        this.app = app;
    }

    public final void markSeen(String currentVersion) {
        m.checkNotNullParameter(currentVersion, "currentVersion");
        setLastSeenChangeLogVersion(currentVersion);
        StoreNotices.markSeen$default(this.notices, "CHANGE_LOG", 0L, 2, null);
    }

    public final void openChangeLog(Context context, boolean fromSettings) {
        m.checkNotNullParameter(context, "context");
        String string = context.getString(2131887518);
        m.checkNotNullExpressionValue(string, "context.getString(R.string.change_log_md_date)");
        String changelogExperimentString = getChangelogExperimentString(context, "change_log_md_experiment_date", string);
        String string2 = context.getString(2131887520);
        m.checkNotNullExpressionValue(string2, "context.getString(R.string.change_log_md_revision)");
        String changelogExperimentString2 = getChangelogExperimentString(context, "change_log_md_revision", string2);
        String string3 = context.getString(2131887521);
        m.checkNotNullExpressionValue(string3, "context.getString(R.string.change_log_md_video)");
        String changelogExperimentString3 = getChangelogExperimentString(context, "change_log_md_experiment_video", string3);
        String string4 = context.getString(2131887517);
        m.checkNotNullExpressionValue(string4, "context.getString(R.string.change_log_md_body)");
        String changelogExperimentString4 = getChangelogExperimentString(context, "change_log_md_experiment_body", string4);
        String string5 = context.getString(2131886994);
        m.checkNotNullExpressionValue(string5, "context.getString(R.string.back)");
        String changelogExperimentString5 = getChangelogExperimentString(context, "change_log_md_experiment_template", string5);
        WidgetChangeLogSpecial$Companion$ExitStyle widgetChangeLogSpecial$Companion$ExitStyle = fromSettings ? WidgetChangeLogSpecial$Companion$ExitStyle.BACK : WidgetChangeLogSpecial$Companion$ExitStyle.CLOSE;
        if (m.areEqual(changelogExperimentString5, "special") && m.areEqual((Object) null, (Object) 1)) {
            WidgetChangeLogSpecial.Companion.launch(context, changelogExperimentString, changelogExperimentString2, changelogExperimentString3, changelogExperimentString4, widgetChangeLogSpecial$Companion$ExitStyle, true);
            return;
        }
        if (m.areEqual((Object) null, (Object) 1)) {
            WidgetChangeLog.Companion.launch(context, changelogExperimentString, changelogExperimentString2, changelogExperimentString3, changelogExperimentString4);
            return;
        }
        WidgetChangeLog$Companion widgetChangeLog$Companion = WidgetChangeLog.Companion;
        String string6 = context.getString(2131887518);
        m.checkNotNullExpressionValue(string6, "context.getString(R.string.change_log_md_date)");
        String string7 = context.getString(2131887520);
        m.checkNotNullExpressionValue(string7, "context.getString(R.string.change_log_md_revision)");
        String string8 = context.getString(2131887521);
        m.checkNotNullExpressionValue(string8, "context.getString(R.string.change_log_md_video)");
        String string9 = context.getString(2131887517);
        m.checkNotNullExpressionValue(string9, "context.getString(R.string.change_log_md_body)");
        widgetChangeLog$Companion.launch(context, string6, string7, string8, string9);
    }

    public final void setApp(Application application) {
        m.checkNotNullParameter(application, "<set-?>");
        this.app = application;
    }
}
