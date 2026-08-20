package com.discord.stores;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import androidx.fragment.app.FragmentActivity;
import com.discord.C5419R;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.SnowflakeUtils;
import com.discord.utilities.string.StringUtilsKt;
import com.discord.utilities.time.Clock;
import com.discord.widgets.changelog.WidgetChangeLog;
import com.discord.widgets.changelog.WidgetChangeLogSpecial;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p507d0.C12113l;
import p507d0.p579g0.C12103t;
import p507d0.p579g0.C12106w;
import p507d0.p584w.p585h.C12183c;
import p507d0.p584w.p586i.p587a.AbstractC12194k;
import p507d0.p584w.p586i.p587a.InterfaceC12188e;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p659s.p660a.C13124k0;
import p659s.p660a.C13163x0;

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

    /* JADX INFO: renamed from: com.discord.stores.StoreChangeLog$createChangeLogNotice$1 */
    /* JADX INFO: compiled from: StoreChangeLog.kt */
    public static final class C58081 extends AbstractC12240o implements Function1<FragmentActivity, Boolean> {
        public C58081() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(FragmentActivity fragmentActivity) {
            return Boolean.valueOf(invoke2(fragmentActivity));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(FragmentActivity fragmentActivity) {
            C12238m.checkNotNullParameter(fragmentActivity, "appActivity");
            StoreChangeLog.openChangeLog$default(StoreChangeLog.this, fragmentActivity, false, 2, null);
            return true;
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreChangeLog$handleConnectionOpen$1 */
    /* JADX INFO: compiled from: StoreChangeLog.kt */
    @InterfaceC12188e(m10084c = "com.discord.stores.StoreChangeLog$handleConnectionOpen$1", m10085f = "StoreChangeLog.kt", m10086l = {}, m10087m = "invokeSuspend")
    public static final class C58091 extends AbstractC12194k implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int label;

        /* JADX INFO: renamed from: com.discord.stores.StoreChangeLog$handleConnectionOpen$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: StoreChangeLog.kt */
        public static final class AnonymousClass1 extends AbstractC12240o implements Function0<Unit> {
            public AnonymousClass1() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                StoreChangeLog.this.handlePostConnectionOpen();
            }
        }

        public C58091(Continuation continuation) {
            super(2, continuation);
        }

        @Override // p507d0.p584w.p586i.p587a.AbstractC12184a
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C12238m.checkNotNullParameter(continuation, "completion");
            return StoreChangeLog.this.new C58091(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C58091) create(coroutineScope, continuation)).invokeSuspend(Unit.f27425a);
        }

        @Override // p507d0.p584w.p586i.p587a.AbstractC12184a
        public final Object invokeSuspend(Object obj) {
            C12183c.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C12113l.throwOnFailure(obj);
            StoreChangeLog.this.dispatcher.schedule(new AnonymousClass1());
            return Unit.f27425a;
        }
    }

    public StoreChangeLog(Clock clock, StoreNotices storeNotices, StoreUser storeUser, StoreUserSettingsSystem storeUserSettingsSystem, StoreExperiments storeExperiments, Dispatcher dispatcher) {
        C12238m.checkNotNullParameter(clock, "clock");
        C12238m.checkNotNullParameter(storeNotices, "notices");
        C12238m.checkNotNullParameter(storeUser, "users");
        C12238m.checkNotNullParameter(storeUserSettingsSystem, "userSettingsSystem");
        C12238m.checkNotNullParameter(storeExperiments, "experiments");
        C12238m.checkNotNullParameter(dispatcher, "dispatcher");
        this.clock = clock;
        this.notices = storeNotices;
        this.users = storeUser;
        this.userSettingsSystem = storeUserSettingsSystem;
        this.experiments = storeExperiments;
        this.dispatcher = dispatcher;
    }

    private final StoreNotices.Notice createChangeLogNotice() {
        return new StoreNotices.Notice("CHANGE_LOG", null, 1337L, 0, true, null, 0L, false, 604800000L, new C58081(), 226, null);
    }

    private final String getChangelogExperimentString(Context context, String name, String fallback) {
        int identifier = context.getResources().getIdentifier(name, "string", context.getPackageName());
        if (identifier <= 0) {
            return fallback;
        }
        String string = context.getString(identifier);
        C12238m.checkNotNullExpressionValue(string, "context.getString(id)");
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
        SharedPreferences.Editor editorEdit = getPrefs().edit();
        C12238m.checkNotNullExpressionValue(editorEdit, "editor");
        editorEdit.putString("CACHE_KEY_VIEWED_CHANGE_LOG_VERSION", str);
        editorEdit.apply();
    }

    private final boolean shouldShowChangelog(Context context, long userId, String targetLanguage, Integer experimentBucket) {
        String string;
        int identifier = (experimentBucket != null && experimentBucket.intValue() == 1) ? context.getResources().getIdentifier("change_log_md_experiment_body", "string", context.getPackageName()) : C5419R.string.change_log_md_body;
        CharSequence stringByLocale = StringUtilsKt.getStringByLocale(context, identifier, "en");
        CharSequence stringByLocale2 = StringUtilsKt.getStringByLocale(context, identifier, targetLanguage);
        if ((!C12238m.areEqual(targetLanguage, "en")) && C12238m.areEqual(stringByLocale, stringByLocale2)) {
            return false;
        }
        if (experimentBucket != null && experimentBucket.intValue() == 1) {
            String string2 = context.getString(C5419R.string.change_log_md_date);
            C12238m.checkNotNullExpressionValue(string2, "context.getString(R.string.change_log_md_date)");
            string = getChangelogExperimentString(context, "change_log_md_experiment_date", string2);
        } else {
            string = context.getString(C5419R.string.change_log_md_date);
            C12238m.checkNotNullExpressionValue(string, "context.getString(R.string.change_log_md_date)");
        }
        String lastSeenChangeLogVersion = getLastSeenChangeLogVersion();
        if (!(lastSeenChangeLogVersion == null || C12103t.isBlank(lastSeenChangeLogVersion)) && !isTooYoung(userId)) {
            return !C12238m.areEqual(string, getLastSeenChangeLogVersion());
        }
        markSeen(string);
        return false;
    }

    public final Application getApp() {
        Application application = this.app;
        if (application == null) {
            C12238m.throwUninitializedPropertyAccessException("app");
        }
        return application;
    }

    @StoreThread
    public final void handleConnectionOpen() {
        C3404f.m4211H0(C13163x0.f27919j, C13124k0.f27866a, null, new C58091(null), 2, null);
    }

    @StoreThread
    public final void handlePostConnectionOpen() {
        String str = (String) C12106w.split$default((CharSequence) this.userSettingsSystem.getLocale(), new String[]{"-"}, false, 0, 6, (Object) null).get(0);
        long id2 = this.users.getMeSnapshot().getId();
        Application application = this.app;
        if (application == null) {
            C12238m.throwUninitializedPropertyAccessException("app");
        }
        if (shouldShowChangelog(application, id2, str, null)) {
            this.notices.requestToShow(createChangeLogNotice());
        }
    }

    @StoreThread
    public final void init(Application app) {
        C12238m.checkNotNullParameter(app, "app");
        init((Context) app);
        this.app = app;
    }

    public final void markSeen(String currentVersion) {
        C12238m.checkNotNullParameter(currentVersion, "currentVersion");
        setLastSeenChangeLogVersion(currentVersion);
        StoreNotices.markSeen$default(this.notices, "CHANGE_LOG", 0L, 2, null);
    }

    public final void openChangeLog(Context context, boolean fromSettings) {
        C12238m.checkNotNullParameter(context, "context");
        String string = context.getString(C5419R.string.change_log_md_date);
        C12238m.checkNotNullExpressionValue(string, "context.getString(R.string.change_log_md_date)");
        String changelogExperimentString = getChangelogExperimentString(context, "change_log_md_experiment_date", string);
        String string2 = context.getString(C5419R.string.change_log_md_revision);
        C12238m.checkNotNullExpressionValue(string2, "context.getString(R.string.change_log_md_revision)");
        String changelogExperimentString2 = getChangelogExperimentString(context, "change_log_md_revision", string2);
        String string3 = context.getString(C5419R.string.change_log_md_video);
        C12238m.checkNotNullExpressionValue(string3, "context.getString(R.string.change_log_md_video)");
        String changelogExperimentString3 = getChangelogExperimentString(context, "change_log_md_experiment_video", string3);
        String string4 = context.getString(C5419R.string.change_log_md_body);
        C12238m.checkNotNullExpressionValue(string4, "context.getString(R.string.change_log_md_body)");
        String changelogExperimentString4 = getChangelogExperimentString(context, "change_log_md_experiment_body", string4);
        String string5 = context.getString(C5419R.string.back);
        C12238m.checkNotNullExpressionValue(string5, "context.getString(R.string.back)");
        String changelogExperimentString5 = getChangelogExperimentString(context, "change_log_md_experiment_template", string5);
        WidgetChangeLogSpecial.Companion.ExitStyle exitStyle = fromSettings ? WidgetChangeLogSpecial.Companion.ExitStyle.BACK : WidgetChangeLogSpecial.Companion.ExitStyle.CLOSE;
        if (C12238m.areEqual(changelogExperimentString5, "special") && C12238m.areEqual((Object) null, (Object) 1)) {
            WidgetChangeLogSpecial.INSTANCE.launch(context, changelogExperimentString, changelogExperimentString2, changelogExperimentString3, changelogExperimentString4, exitStyle, true);
            return;
        }
        if (C12238m.areEqual((Object) null, (Object) 1)) {
            WidgetChangeLog.INSTANCE.launch(context, changelogExperimentString, changelogExperimentString2, changelogExperimentString3, changelogExperimentString4);
            return;
        }
        WidgetChangeLog.Companion companion = WidgetChangeLog.INSTANCE;
        String string6 = context.getString(C5419R.string.change_log_md_date);
        C12238m.checkNotNullExpressionValue(string6, "context.getString(R.string.change_log_md_date)");
        String string7 = context.getString(C5419R.string.change_log_md_revision);
        C12238m.checkNotNullExpressionValue(string7, "context.getString(R.string.change_log_md_revision)");
        String string8 = context.getString(C5419R.string.change_log_md_video);
        C12238m.checkNotNullExpressionValue(string8, "context.getString(R.string.change_log_md_video)");
        String string9 = context.getString(C5419R.string.change_log_md_body);
        C12238m.checkNotNullExpressionValue(string9, "context.getString(R.string.change_log_md_body)");
        companion.launch(context, string6, string7, string8, string9);
    }

    public final void setApp(Application application) {
        C12238m.checkNotNullParameter(application, "<set-?>");
        this.app = application;
    }
}
