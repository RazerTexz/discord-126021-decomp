package com.discord.stores;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import androidx.fragment.app.FragmentActivity;
import b.i.a.f.e.o.f;
import com.discord.R;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.stores.StoreNotices;
import com.discord.utilities.SnowflakeUtils;
import com.discord.utilities.string.StringUtils2;
import com.discord.utilities.time.Clock;
import com.discord.widgets.changelog.WidgetChangeLog;
import com.discord.widgets.changelog.WidgetChangeLogSpecial;
import d0.Result3;
import d0.g0.Strings4;
import d0.g0.StringsJVM;
import d0.w.h.Intrinsics2;
import d0.w.i.a.ContinuationImpl6;
import d0.w.i.a.DebugMetadata;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import s.a.CoroutineScope2;
import s.a.Dispatchers;

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

    /* JADX INFO: renamed from: com.discord.stores.StoreChangeLog$createChangeLogNotice$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreChangeLog.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<FragmentActivity, Boolean> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(FragmentActivity fragmentActivity) {
            return Boolean.valueOf(invoke2(fragmentActivity));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(FragmentActivity fragmentActivity) {
            Intrinsics3.checkNotNullParameter(fragmentActivity, "appActivity");
            StoreChangeLog.openChangeLog$default(StoreChangeLog.this, fragmentActivity, false, 2, null);
            return true;
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreChangeLog$handleConnectionOpen$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreChangeLog.kt */
    @DebugMetadata(c = "com.discord.stores.StoreChangeLog$handleConnectionOpen$1", f = "StoreChangeLog.kt", l = {}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends ContinuationImpl6 implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int label;

        /* JADX INFO: renamed from: com.discord.stores.StoreChangeLog$handleConnectionOpen$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: StoreChangeLog.kt */
        public static final class C00991 extends Lambda implements Function0<Unit> {
            public C00991() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                StoreChangeLog.this.handlePostConnectionOpen();
            }
        }

        public AnonymousClass1(Continuation continuation) {
            super(2, continuation);
        }

        @Override // d0.w.i.a.ContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Intrinsics3.checkNotNullParameter(continuation, "completion");
            return StoreChangeLog.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.a);
        }

        @Override // d0.w.i.a.ContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Intrinsics2.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Result3.throwOnFailure(obj);
            StoreChangeLog.this.dispatcher.schedule(new C00991());
            return Unit.a;
        }
    }

    public StoreChangeLog(Clock clock, StoreNotices storeNotices, StoreUser storeUser, StoreUserSettingsSystem storeUserSettingsSystem, StoreExperiments storeExperiments, Dispatcher dispatcher) {
        Intrinsics3.checkNotNullParameter(clock, "clock");
        Intrinsics3.checkNotNullParameter(storeNotices, "notices");
        Intrinsics3.checkNotNullParameter(storeUser, "users");
        Intrinsics3.checkNotNullParameter(storeUserSettingsSystem, "userSettingsSystem");
        Intrinsics3.checkNotNullParameter(storeExperiments, "experiments");
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        this.clock = clock;
        this.notices = storeNotices;
        this.users = storeUser;
        this.userSettingsSystem = storeUserSettingsSystem;
        this.experiments = storeExperiments;
        this.dispatcher = dispatcher;
    }

    private final StoreNotices.Notice createChangeLogNotice() {
        return new StoreNotices.Notice("CHANGE_LOG", null, 1337L, 0, true, null, 0L, false, 604800000L, new AnonymousClass1(), 226, null);
    }

    private final String getChangelogExperimentString(Context context, String name, String fallback) {
        int identifier = context.getResources().getIdentifier(name, "string", context.getPackageName());
        if (identifier <= 0) {
            return fallback;
        }
        String string = context.getString(identifier);
        Intrinsics3.checkNotNullExpressionValue(string, "context.getString(id)");
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
        Intrinsics3.checkNotNullExpressionValue(editorEdit, "editor");
        editorEdit.putString("CACHE_KEY_VIEWED_CHANGE_LOG_VERSION", str);
        editorEdit.apply();
    }

    private final boolean shouldShowChangelog(Context context, long userId, String targetLanguage, Integer experimentBucket) {
        String string;
        int identifier = (experimentBucket != null && experimentBucket.intValue() == 1) ? context.getResources().getIdentifier("change_log_md_experiment_body", "string", context.getPackageName()) : R.string.change_log_md_body;
        CharSequence stringByLocale = StringUtils2.getStringByLocale(context, identifier, "en");
        CharSequence stringByLocale2 = StringUtils2.getStringByLocale(context, identifier, targetLanguage);
        if ((!Intrinsics3.areEqual(targetLanguage, "en")) && Intrinsics3.areEqual(stringByLocale, stringByLocale2)) {
            return false;
        }
        if (experimentBucket != null && experimentBucket.intValue() == 1) {
            String string2 = context.getString(R.string.change_log_md_date);
            Intrinsics3.checkNotNullExpressionValue(string2, "context.getString(R.string.change_log_md_date)");
            string = getChangelogExperimentString(context, "change_log_md_experiment_date", string2);
        } else {
            string = context.getString(R.string.change_log_md_date);
            Intrinsics3.checkNotNullExpressionValue(string, "context.getString(R.string.change_log_md_date)");
        }
        String lastSeenChangeLogVersion = getLastSeenChangeLogVersion();
        if (!(lastSeenChangeLogVersion == null || StringsJVM.isBlank(lastSeenChangeLogVersion)) && !isTooYoung(userId)) {
            return !Intrinsics3.areEqual(string, getLastSeenChangeLogVersion());
        }
        markSeen(string);
        return false;
    }

    public final Application getApp() {
        Application application = this.app;
        if (application == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("app");
        }
        return application;
    }

    @Store3
    public final void handleConnectionOpen() {
        f.H0(CoroutineScope2.j, Dispatchers.a, null, new AnonymousClass1(null), 2, null);
    }

    @Store3
    public final void handlePostConnectionOpen() {
        String str = (String) Strings4.split$default((CharSequence) this.userSettingsSystem.getLocale(), new String[]{"-"}, false, 0, 6, (Object) null).get(0);
        long id2 = this.users.getMeSnapshot().getId();
        Application application = this.app;
        if (application == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("app");
        }
        if (shouldShowChangelog(application, id2, str, null)) {
            this.notices.requestToShow(createChangeLogNotice());
        }
    }

    @Store3
    public final void init(Application app) {
        Intrinsics3.checkNotNullParameter(app, "app");
        init((Context) app);
        this.app = app;
    }

    public final void markSeen(String currentVersion) {
        Intrinsics3.checkNotNullParameter(currentVersion, "currentVersion");
        setLastSeenChangeLogVersion(currentVersion);
        StoreNotices.markSeen$default(this.notices, "CHANGE_LOG", 0L, 2, null);
    }

    public final void openChangeLog(Context context, boolean fromSettings) {
        Intrinsics3.checkNotNullParameter(context, "context");
        String string = context.getString(R.string.change_log_md_date);
        Intrinsics3.checkNotNullExpressionValue(string, "context.getString(R.string.change_log_md_date)");
        String changelogExperimentString = getChangelogExperimentString(context, "change_log_md_experiment_date", string);
        String string2 = context.getString(R.string.change_log_md_revision);
        Intrinsics3.checkNotNullExpressionValue(string2, "context.getString(R.string.change_log_md_revision)");
        String changelogExperimentString2 = getChangelogExperimentString(context, "change_log_md_revision", string2);
        String string3 = context.getString(R.string.change_log_md_video);
        Intrinsics3.checkNotNullExpressionValue(string3, "context.getString(R.string.change_log_md_video)");
        String changelogExperimentString3 = getChangelogExperimentString(context, "change_log_md_experiment_video", string3);
        String string4 = context.getString(R.string.change_log_md_body);
        Intrinsics3.checkNotNullExpressionValue(string4, "context.getString(R.string.change_log_md_body)");
        String changelogExperimentString4 = getChangelogExperimentString(context, "change_log_md_experiment_body", string4);
        String string5 = context.getString(R.string.back);
        Intrinsics3.checkNotNullExpressionValue(string5, "context.getString(R.string.back)");
        String changelogExperimentString5 = getChangelogExperimentString(context, "change_log_md_experiment_template", string5);
        WidgetChangeLogSpecial.Companion.ExitStyle exitStyle = fromSettings ? WidgetChangeLogSpecial.Companion.ExitStyle.BACK : WidgetChangeLogSpecial.Companion.ExitStyle.CLOSE;
        if (Intrinsics3.areEqual(changelogExperimentString5, "special") && Intrinsics3.areEqual((Object) null, (Object) 1)) {
            WidgetChangeLogSpecial.INSTANCE.launch(context, changelogExperimentString, changelogExperimentString2, changelogExperimentString3, changelogExperimentString4, exitStyle, true);
            return;
        }
        if (Intrinsics3.areEqual((Object) null, (Object) 1)) {
            WidgetChangeLog.INSTANCE.launch(context, changelogExperimentString, changelogExperimentString2, changelogExperimentString3, changelogExperimentString4);
            return;
        }
        WidgetChangeLog.Companion companion = WidgetChangeLog.INSTANCE;
        String string6 = context.getString(R.string.change_log_md_date);
        Intrinsics3.checkNotNullExpressionValue(string6, "context.getString(R.string.change_log_md_date)");
        String string7 = context.getString(R.string.change_log_md_revision);
        Intrinsics3.checkNotNullExpressionValue(string7, "context.getString(R.string.change_log_md_revision)");
        String string8 = context.getString(R.string.change_log_md_video);
        Intrinsics3.checkNotNullExpressionValue(string8, "context.getString(R.string.change_log_md_video)");
        String string9 = context.getString(R.string.change_log_md_body);
        Intrinsics3.checkNotNullExpressionValue(string9, "context.getString(R.string.change_log_md_body)");
        companion.launch(context, string6, string7, string8, string9);
    }

    public final void setApp(Application application) {
        Intrinsics3.checkNotNullParameter(application, "<set-?>");
        this.app = application;
    }
}
