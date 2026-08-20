package com.discord.stores;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.core.app.FrameMetricsAggregator;
import com.discord.api.channel.Channel;
import com.discord.api.permission.Permission;
import com.discord.api.presence.ClientStatus;
import com.discord.app.AppActivity;
import com.discord.models.guild.Guild;
import com.discord.models.message.Message;
import com.discord.restapi.RestAPIParams;
import com.discord.utilities.SnowflakeUtils;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.error.Error;
import com.discord.utilities.fcm.NotificationClient;
import com.discord.utilities.intent.IntentUtils;
import com.discord.utilities.p501rx.ActivityLifecycleCallbacks;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.persister.Persister;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.time.Clock;
import com.discord.widgets.notice.NoticePopupChannel;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import p007b.p008a.p018d.C0879o;
import p007b.p008a.p020e.C0894d;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p507d0.C12113l;
import p507d0.C12116o;
import p507d0.p580t.C12163u;
import p507d0.p584w.p585h.C12183c;
import p507d0.p584w.p586i.p587a.AbstractC12194k;
import p507d0.p584w.p586i.p587a.InterfaceC12188e;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.functions.Func2;
import p658rx.functions.Func4;
import p659s.p660a.C13124k0;

/* JADX INFO: compiled from: StoreNotifications.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreNotifications extends Store {
    private static final long INAPP_MESSAGE_WINDOW_MS = 10000;
    private String authToken;
    private final Clock clock;
    private Context context;
    private final Persister<NotificationClient.SettingsV2> notificationSettings;
    private String pushToken;
    private String pushTokenPersisted;
    private final StoreStream stream;

    /* JADX INFO: renamed from: com.discord.stores.StoreNotifications$configureNotificationClient$1 */
    /* JADX INFO: compiled from: StoreNotifications.kt */
    public static final /* synthetic */ class C62941 extends C12236k implements Function1<String, Unit> {
        public C62941(StoreNotifications storeNotifications) {
            super(1, storeNotifications, StoreNotifications.class, "handleRegistrationToken", "handleRegistrationToken(Ljava/lang/String;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            ((StoreNotifications) this.receiver).handleRegistrationToken(str);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreNotifications$configureNotificationClient$3 */
    /* JADX INFO: compiled from: StoreNotifications.kt */
    public static final class C62963 extends AbstractC12240o implements Function1<Pair<? extends NotificationClient.SettingsV2, ? extends Boolean>, Unit> {
        public static final C62963 INSTANCE = new C62963();

        public C62963() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Pair<? extends NotificationClient.SettingsV2, ? extends Boolean> pair) {
            invoke2((Pair<NotificationClient.SettingsV2, Boolean>) pair);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Pair<NotificationClient.SettingsV2, Boolean> pair) {
            NotificationClient.SettingsV2 settingsV2Component1 = pair.component1();
            Boolean boolComponent2 = pair.component2();
            NotificationClient notificationClient = NotificationClient.INSTANCE;
            C12238m.checkNotNullExpressionValue(settingsV2Component1, "settings");
            C12238m.checkNotNullExpressionValue(boolComponent2, "isBackgrounded");
            notificationClient.updateSettings$app_productionGoogleRelease(settingsV2Component1, boolComponent2.booleanValue());
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreNotifications$displayPopup$1 */
    /* JADX INFO: compiled from: StoreNotifications.kt */
    public static final class C62991 extends AbstractC12240o implements Function1<View, Unit> {
        public final /* synthetic */ Channel $channel;
        public final /* synthetic */ Message $message;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C62991(Channel channel, Message message) {
            super(1);
            this.$channel = channel;
            this.$message = message;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            C12238m.checkNotNullParameter(view, "view");
            Intent intentSelectChannel = IntentUtils.RouteBuilders.selectChannel(this.$channel.getId(), this.$channel.getGuildId(), Long.valueOf(this.$message.getId()));
            intentSelectChannel.putExtra("com.discord.intent.ORIGIN_SOURCE", "com.discord.intent.ORIGIN_NOTIF_INAPP");
            IntentUtils intentUtils = IntentUtils.INSTANCE;
            Context context = view.getContext();
            C12238m.checkNotNullExpressionValue(context, "view.context");
            intentUtils.consumeExternalRoutingIntent(intentSelectChannel, context);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreNotifications$handleChannelSelected$1 */
    /* JADX INFO: compiled from: StoreNotifications.kt */
    @InterfaceC12188e(m10084c = "com.discord.stores.StoreNotifications$handleChannelSelected$1", m10085f = "StoreNotifications.kt", m10086l = {}, m10087m = "invokeSuspend")
    public static final class C63001 extends AbstractC12194k implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public final /* synthetic */ long $channelId;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C63001(long j, Continuation continuation) {
            super(2, continuation);
            this.$channelId = j;
        }

        @Override // p507d0.p584w.p586i.p587a.AbstractC12184a
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C12238m.checkNotNullParameter(continuation, "completion");
            return new C63001(this.$channelId, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C63001) create(coroutineScope, continuation)).invokeSuspend(Unit.f27425a);
        }

        @Override // p507d0.p584w.p586i.p587a.AbstractC12184a
        public final Object invokeSuspend(Object obj) {
            C12183c.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C12113l.throwOnFailure(obj);
            NotificationClient.clear$default(NotificationClient.INSTANCE, this.$channelId, null, false, 6, null);
            return Unit.f27425a;
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreNotifications$setEnabled$1 */
    /* JADX INFO: compiled from: StoreNotifications.kt */
    public static final class C63011 extends AbstractC12240o implements Function1<NotificationClient.SettingsV2, NotificationClient.SettingsV2> {
        public final /* synthetic */ boolean $enabled;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C63011(boolean z2) {
            super(1);
            this.$enabled = z2;
        }

        @Override // kotlin.jvm.functions.Function1
        public final NotificationClient.SettingsV2 invoke(NotificationClient.SettingsV2 settingsV2) {
            C12238m.checkNotNullParameter(settingsV2, "it");
            return settingsV2.copy((509 & 1) != 0 ? settingsV2.isEnabled : this.$enabled, (509 & 2) != 0 ? settingsV2.isEnabledInApp : false, (509 & 4) != 0 ? settingsV2.isWake : false, (509 & 8) != 0 ? settingsV2.isDisableBlink : false, (509 & 16) != 0 ? settingsV2.isDisableSound : false, (509 & 32) != 0 ? settingsV2.isDisableVibrate : false, (509 & 64) != 0 ? settingsV2.token : null, (509 & 128) != 0 ? settingsV2.locale : null, (509 & 256) != 0 ? settingsV2.sendBlockedChannels : null);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreNotifications$setNotificationLightDisabled$1 */
    /* JADX INFO: compiled from: StoreNotifications.kt */
    public static final class C63021 extends AbstractC12240o implements Function1<NotificationClient.SettingsV2, NotificationClient.SettingsV2> {
        public final /* synthetic */ boolean $notificationLightDisabled;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C63021(boolean z2) {
            super(1);
            this.$notificationLightDisabled = z2;
        }

        @Override // kotlin.jvm.functions.Function1
        public final NotificationClient.SettingsV2 invoke(NotificationClient.SettingsV2 settingsV2) {
            C12238m.checkNotNullParameter(settingsV2, "it");
            return settingsV2.copy((509 & 1) != 0 ? settingsV2.isEnabled : false, (509 & 2) != 0 ? settingsV2.isEnabledInApp : false, (509 & 4) != 0 ? settingsV2.isWake : false, (509 & 8) != 0 ? settingsV2.isDisableBlink : this.$notificationLightDisabled, (509 & 16) != 0 ? settingsV2.isDisableSound : false, (509 & 32) != 0 ? settingsV2.isDisableVibrate : false, (509 & 64) != 0 ? settingsV2.token : null, (509 & 128) != 0 ? settingsV2.locale : null, (509 & 256) != 0 ? settingsV2.sendBlockedChannels : null);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreNotifications$setNotificationSoundDisabled$1 */
    /* JADX INFO: compiled from: StoreNotifications.kt */
    public static final class C63031 extends AbstractC12240o implements Function1<NotificationClient.SettingsV2, NotificationClient.SettingsV2> {
        public final /* synthetic */ boolean $notificationSoundDisabled;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C63031(boolean z2) {
            super(1);
            this.$notificationSoundDisabled = z2;
        }

        @Override // kotlin.jvm.functions.Function1
        public final NotificationClient.SettingsV2 invoke(NotificationClient.SettingsV2 settingsV2) {
            C12238m.checkNotNullParameter(settingsV2, "it");
            return settingsV2.copy((509 & 1) != 0 ? settingsV2.isEnabled : false, (509 & 2) != 0 ? settingsV2.isEnabledInApp : false, (509 & 4) != 0 ? settingsV2.isWake : false, (509 & 8) != 0 ? settingsV2.isDisableBlink : false, (509 & 16) != 0 ? settingsV2.isDisableSound : this.$notificationSoundDisabled, (509 & 32) != 0 ? settingsV2.isDisableVibrate : false, (509 & 64) != 0 ? settingsV2.token : null, (509 & 128) != 0 ? settingsV2.locale : null, (509 & 256) != 0 ? settingsV2.sendBlockedChannels : null);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreNotifications$setNotificationsVibrateDisabled$1 */
    /* JADX INFO: compiled from: StoreNotifications.kt */
    public static final class C63041 extends AbstractC12240o implements Function1<NotificationClient.SettingsV2, NotificationClient.SettingsV2> {
        public final /* synthetic */ boolean $notificationsVibrateDisabled;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C63041(boolean z2) {
            super(1);
            this.$notificationsVibrateDisabled = z2;
        }

        @Override // kotlin.jvm.functions.Function1
        public final NotificationClient.SettingsV2 invoke(NotificationClient.SettingsV2 settingsV2) {
            C12238m.checkNotNullParameter(settingsV2, "it");
            return settingsV2.copy((509 & 1) != 0 ? settingsV2.isEnabled : false, (509 & 2) != 0 ? settingsV2.isEnabledInApp : false, (509 & 4) != 0 ? settingsV2.isWake : false, (509 & 8) != 0 ? settingsV2.isDisableBlink : false, (509 & 16) != 0 ? settingsV2.isDisableSound : false, (509 & 32) != 0 ? settingsV2.isDisableVibrate : this.$notificationsVibrateDisabled, (509 & 64) != 0 ? settingsV2.token : null, (509 & 128) != 0 ? settingsV2.locale : null, (509 & 256) != 0 ? settingsV2.sendBlockedChannels : null);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreNotifications$tryTokenPersist$1 */
    /* JADX INFO: compiled from: StoreNotifications.kt */
    public static final class C63051 extends AbstractC12240o implements Function1<Void, Unit> {
        public C63051() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r2) {
            StoreNotifications storeNotifications = StoreNotifications.this;
            storeNotifications.handleRegistrationTokenPersisted(storeNotifications.pushToken);
        }
    }

    public StoreNotifications(Clock clock, StoreStream storeStream) {
        C12238m.checkNotNullParameter(clock, "clock");
        C12238m.checkNotNullParameter(storeStream, "stream");
        this.clock = clock;
        this.stream = storeStream;
        this.notificationSettings = new Persister<>("STORE_NOTIFICATIONS_SETTINGS_V2", new NotificationClient.SettingsV2(false, false, false, false, false, false, null, null, null, FrameMetricsAggregator.EVERY_DURATION, null));
    }

    private final void configureContextSetter(Application application) {
        application.registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() { // from class: com.discord.stores.StoreNotifications.configureContextSetter.1
            @Override // com.discord.utilities.p501rx.ActivityLifecycleCallbacks
            public void onActivityCreatedOrResumed(AppActivity activity) {
                C12238m.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
                super.onActivityCreatedOrResumed(activity);
                StoreNotifications.this.context = activity;
            }

            @Override // com.discord.utilities.p501rx.ActivityLifecycleCallbacks
            public void onActivityDestroyed(AppActivity activity) {
                C12238m.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
                super.onActivityDestroyed(activity);
                StoreNotifications.this.context = null;
            }
        });
    }

    private final void configureNotificationClient() {
        NotificationClient.INSTANCE.setRegistrationIdReceived(new C62941(this));
        Observable<NotificationClient.SettingsV2> settings = getSettings();
        StoreStream.Companion companion = StoreStream.INSTANCE;
        Observable observableM11076j = Observable.m11076j(Observable.m11073h(settings, companion.getAuthentication().getAuthedToken$app_productionGoogleRelease(), companion.getUserSettingsSystem().observeSettings(false), ObservableExtensionsKt.leadingEdgeThrottle(companion.getPermissions().observePermissionsForAllChannels(), 1L, TimeUnit.SECONDS).m11083G(new InterfaceC12589b<Map<Long, ? extends Long>, HashSet<Long>>() { // from class: com.discord.stores.StoreNotifications$configureNotificationClient$completedSettings$1
            @Override // p637j0.p641k.InterfaceC12589b
            public /* bridge */ /* synthetic */ HashSet<Long> call(Map<Long, ? extends Long> map) {
                return call2((Map<Long, Long>) map);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final HashSet<Long> call2(Map<Long, Long> map) {
                C12238m.checkNotNullExpressionValue(map, "channelPermissions");
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (Map.Entry<Long, Long> entry : map.entrySet()) {
                    if (!PermissionUtils.can(Permission.SEND_MESSAGES, Long.valueOf(entry.getValue().longValue()))) {
                        linkedHashMap.put(entry.getKey(), entry.getValue());
                    }
                }
                return C12163u.toHashSet(linkedHashMap.keySet());
            }
        }), new Func4<NotificationClient.SettingsV2, String, StoreUserSettingsSystem.Settings, HashSet<Long>, NotificationClient.SettingsV2>() { // from class: com.discord.stores.StoreNotifications$configureNotificationClient$completedSettings$2
            @Override // p658rx.functions.Func4
            public final NotificationClient.SettingsV2 call(NotificationClient.SettingsV2 settingsV2, String str, StoreUserSettingsSystem.Settings settings2, HashSet<Long> hashSet) {
                String locale = settings2.getLocale();
                C12238m.checkNotNullExpressionValue(hashSet, "nonSendableChannelIds");
                return settingsV2.copy((509 & 1) != 0 ? settingsV2.isEnabled : false, (509 & 2) != 0 ? settingsV2.isEnabledInApp : false, (509 & 4) != 0 ? settingsV2.isWake : false, (509 & 8) != 0 ? settingsV2.isDisableBlink : false, (509 & 16) != 0 ? settingsV2.isDisableSound : false, (509 & 32) != 0 ? settingsV2.isDisableVibrate : false, (509 & 64) != 0 ? settingsV2.token : str, (509 & 128) != 0 ? settingsV2.locale : locale, (509 & 256) != 0 ? settingsV2.sendBlockedChannels : hashSet);
            }
        }).m11112r(), C0894d.f600d.m185a(), new Func2<NotificationClient.SettingsV2, Boolean, Pair<? extends NotificationClient.SettingsV2, ? extends Boolean>>() { // from class: com.discord.stores.StoreNotifications.configureNotificationClient.2
            @Override // p658rx.functions.Func2
            public final Pair<NotificationClient.SettingsV2, Boolean> call(NotificationClient.SettingsV2 settingsV2, Boolean bool) {
                return C12116o.m10073to(settingsV2, bool);
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11076j, "Observable\n        .comb… isBackgrounded\n        }");
        Observable observableM11112r = ObservableExtensionsKt.computationBuffered(observableM11076j).m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "Observable\n        .comb…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe(observableM11112r, (117 & 1) != 0 ? null : null, "nsClient", (Function1<? super Subscription, Unit>) ((117 & 4) != 0 ? null : null), C62963.INSTANCE, (Function1<? super Error, Unit>) ((117 & 16) != 0 ? null : null), (Function0<Unit>) ((117 & 32) != 0 ? ObservableExtensionsKt.C68813.INSTANCE : null), (Function0<Unit>) ((117 & 64) != 0 ? ObservableExtensionsKt.C68824.INSTANCE : null));
    }

    private final void displayPopup(Message message, Channel channel) {
        Context context;
        if ((message.getId() >>> 22) + SnowflakeUtils.DISCORD_EPOCH + 10000 <= this.clock.currentTimeMillis() || (context = this.context) == null) {
            return;
        }
        NoticePopupChannel noticePopupChannel = NoticePopupChannel.INSTANCE;
        StringBuilder sbM833U = C1643a.m833U("{InAppNotif}#");
        sbM833U.append(message.getChannelId());
        noticePopupChannel.enqueue(context, sbM833U.toString(), message, new C62991(channel, message));
    }

    private final synchronized void handleRegistrationToken(String pushToken) {
        this.pushToken = pushToken;
        tryTokenPersist();
    }

    private final synchronized void handleRegistrationTokenPersisted(String pushToken) {
        this.pushTokenPersisted = pushToken;
    }

    public static /* synthetic */ void setEnabledInApp$default(StoreNotifications storeNotifications, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 2) != 0) {
            z3 = true;
        }
        storeNotifications.setEnabledInApp(z2, z3);
    }

    private final void tryTokenPersist() {
        String str = this.authToken;
        if (str == null) {
            this.pushTokenPersisted = null;
        }
        if (str == null || C12238m.areEqual(this.pushToken, this.pushTokenPersisted)) {
            return;
        }
        ObservableExtensionsKt.computationBuffered(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().userCreateDevice(new RestAPIParams.UserDevices(this.pushToken)), false, 1, null)).m11108k(C0879o.f566a.m184g(null, new C63051(), null));
    }

    public final synchronized String getPushToken() {
        return this.pushToken;
    }

    public final Observable<NotificationClient.SettingsV2> getSettings() {
        return ObservableExtensionsKt.computationBuffered(this.notificationSettings.getObservable());
    }

    public final synchronized void handleAuthToken(String authToken) {
        this.authToken = authToken;
        tryTokenPersist();
    }

    @StoreThread
    public final void handleChannelSelected(long channelId) {
        C3404f.m4211H0(C3404f.m4275c(C13124k0.f27866a), null, null, new C63001(channelId, null), 3, null);
    }

    @StoreThread
    public final void handleMessageCreate(com.discord.api.message.Message message) {
        Channel channel;
        C12238m.checkNotNullParameter(message, "message");
        if (this.notificationSettings.get().isEnabledInApp() && this.stream.getPresences().getLocalPresence().getStatus() != ClientStatus.DND) {
            Map<Long, Integer> relationships = this.stream.getUserRelationships().getRelationships();
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry<Long, Integer> entry : relationships.entrySet()) {
                if (entry.getValue().intValue() == 2) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
            if (message.getChannelId() == this.stream.getChannelsSelected().getId()) {
                return;
            }
            Map<Long, Map<Long, Channel>> channelsByGuildInternal$app_productionGoogleRelease = this.stream.getChannels().getChannelsByGuildInternal$app_productionGoogleRelease();
            Long guildId = message.getGuildId();
            Map<Long, Channel> map = channelsByGuildInternal$app_productionGoogleRelease.get(Long.valueOf(guildId != null ? guildId.longValue() : 0L));
            Channel channel2 = this.stream.getChannels().getThreadsByIdInternal$app_productionGoogleRelease().get(Long.valueOf(message.getChannelId()));
            if (channel2 != null) {
                channel = channel2;
            } else if (map != null) {
                channel2 = map.get(Long.valueOf(message.getChannelId()));
                channel = channel2;
            } else {
                channel = null;
            }
            if (channel != null) {
                if (NotificationTextUtils.INSTANCE.shouldNotifyInAppPopup(this.stream.getUsers().getMe(), message, channel, linkedHashMap, map != null ? map.get(Long.valueOf(channel.getParentId())) : null, (Guild) C1643a.m843c(channel, this.stream.getGuilds().getGuildsInternal$app_productionGoogleRelease()), this.stream.getGuilds().getGuildMembersComputedInternal$app_productionGoogleRelease(), this.stream.getGuildSettings().getGuildSettingsInternal$app_productionGoogleRelease(), this.stream.getThreadsJoined().getAllJoinedThreadsInternal$app_productionGoogleRelease(), this.stream.getVoiceChannelSelected().getSelectedVoiceChannelId(), (Long) C1643a.m845d(channel, this.stream.getPermissions().getPermissionsByChannel()))) {
                    displayPopup(new Message(message), channel);
                }
            }
        }
    }

    public final void handlePreLogout() {
        Persister.set$default(this.notificationSettings, new NotificationClient.SettingsV2(false, false, false, false, false, false, null, null, null, FrameMetricsAggregator.EVERY_DURATION, null), false, 2, null);
    }

    public final void init(Application application) {
        C12238m.checkNotNullParameter(application, "application");
        super.init((Context) application);
        configureContextSetter(application);
        configureNotificationClient();
    }

    public final void setEnabled(boolean enabled) {
        this.notificationSettings.getAndSet(true, new C63011(enabled));
        AnalyticsTracker.INSTANCE.updateNotifications(enabled);
    }

    public final void setEnabledInApp(boolean isEnabledInApp, boolean logToggle) {
        NotificationClient.SettingsV2 andSet = this.notificationSettings.getAndSet(true, new StoreNotifications$setEnabledInApp$oldValue$1(isEnabledInApp));
        if (!logToggle || andSet.isEnabledInApp() == isEnabledInApp) {
            return;
        }
        AnalyticsTracker.INSTANCE.updateNotificationsInApp(isEnabledInApp);
    }

    public final void setNotificationLightDisabled(boolean notificationLightDisabled) {
        this.notificationSettings.getAndSet(true, new C63021(notificationLightDisabled));
    }

    public final void setNotificationSoundDisabled(boolean notificationSoundDisabled) {
        this.notificationSettings.getAndSet(true, new C63031(notificationSoundDisabled));
    }

    public final void setNotificationsVibrateDisabled(boolean notificationsVibrateDisabled) {
        this.notificationSettings.getAndSet(true, new C63041(notificationsVibrateDisabled));
    }
}
