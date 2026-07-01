package com.discord.stores;

import android.app.Application;
import android.content.Context;
import androidx.core.app.FrameMetricsAggregator;
import b.a.d.o;
import b.a.e.d;
import b.d.b.a.a;
import b.i.a.f.e.o.f;
import com.discord.api.channel.Channel;
import com.discord.api.presence.ClientStatus;
import com.discord.models.guild.Guild;
import com.discord.models.message.Message;
import com.discord.restapi.RestAPIParams$UserDevices;
import com.discord.utilities.SnowflakeUtils;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.fcm.NotificationClient;
import com.discord.utilities.fcm.NotificationClient$SettingsV2;
import com.discord.utilities.persister.Persister;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.time.Clock;
import com.discord.widgets.notice.NoticePopupChannel;
import d0.z.d.m;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map$Entry;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;
import s.a.k0;

/* JADX INFO: compiled from: StoreNotifications.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreNotifications extends Store {
    public static final StoreNotifications$Companion Companion = new StoreNotifications$Companion(null);
    private static final long INAPP_MESSAGE_WINDOW_MS = 10000;
    private String authToken;
    private final Clock clock;
    private Context context;
    private final Persister<NotificationClient$SettingsV2> notificationSettings;
    private String pushToken;
    private String pushTokenPersisted;
    private final StoreStream stream;

    public StoreNotifications(Clock clock, StoreStream storeStream) {
        m.checkNotNullParameter(clock, "clock");
        m.checkNotNullParameter(storeStream, "stream");
        this.clock = clock;
        this.stream = storeStream;
        this.notificationSettings = new Persister<>("STORE_NOTIFICATIONS_SETTINGS_V2", new NotificationClient$SettingsV2(false, false, false, false, false, false, null, null, null, FrameMetricsAggregator.EVERY_DURATION, null));
    }

    public static final /* synthetic */ Context access$getContext$p(StoreNotifications storeNotifications) {
        return storeNotifications.context;
    }

    public static final /* synthetic */ String access$getPushToken$p(StoreNotifications storeNotifications) {
        return storeNotifications.pushToken;
    }

    public static final /* synthetic */ void access$handleRegistrationToken(StoreNotifications storeNotifications, String str) {
        storeNotifications.handleRegistrationToken(str);
    }

    public static final /* synthetic */ void access$handleRegistrationTokenPersisted(StoreNotifications storeNotifications, String str) {
        storeNotifications.handleRegistrationTokenPersisted(str);
    }

    public static final /* synthetic */ void access$setContext$p(StoreNotifications storeNotifications, Context context) {
        storeNotifications.context = context;
    }

    public static final /* synthetic */ void access$setPushToken$p(StoreNotifications storeNotifications, String str) {
        storeNotifications.pushToken = str;
    }

    private final void configureContextSetter(Application application) {
        application.registerActivityLifecycleCallbacks(new StoreNotifications$configureContextSetter$1(this));
    }

    private final void configureNotificationClient() {
        NotificationClient.INSTANCE.setRegistrationIdReceived(new StoreNotifications$configureNotificationClient$1(this));
        Observable<NotificationClient$SettingsV2> settings = getSettings();
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        Observable observableJ = Observable.j(Observable.h(settings, storeStream$Companion.getAuthentication().getAuthedToken$app_productionGoogleRelease(), storeStream$Companion.getUserSettingsSystem().observeSettings(false), ObservableExtensionsKt.leadingEdgeThrottle(storeStream$Companion.getPermissions().observePermissionsForAllChannels(), 1L, TimeUnit.SECONDS).G(StoreNotifications$configureNotificationClient$completedSettings$1.INSTANCE), StoreNotifications$configureNotificationClient$completedSettings$2.INSTANCE).r(), d.d.a(), StoreNotifications$configureNotificationClient$2.INSTANCE);
        m.checkNotNullExpressionValue(observableJ, "Observable\n        .comb… isBackgrounded\n        }");
        Observable observableR = ObservableExtensionsKt.computationBuffered(observableJ).r();
        m.checkNotNullExpressionValue(observableR, "Observable\n        .comb…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(observableR, (Context) null, "nsClient", (Function1) null, StoreNotifications$configureNotificationClient$3.INSTANCE, (Function1) null, (Function0) null, (Function0) null, 117, (Object) null);
    }

    private final void displayPopup(Message message, Channel channel) {
        Context context;
        if ((message.getId() >>> 22) + SnowflakeUtils.DISCORD_EPOCH + 10000 <= this.clock.currentTimeMillis() || (context = this.context) == null) {
            return;
        }
        NoticePopupChannel noticePopupChannel = NoticePopupChannel.INSTANCE;
        StringBuilder sbU = a.U("{InAppNotif}#");
        sbU.append(message.getChannelId());
        noticePopupChannel.enqueue(context, sbU.toString(), message, new StoreNotifications$displayPopup$1(channel, message));
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
        if (str == null || m.areEqual(this.pushToken, this.pushTokenPersisted)) {
            return;
        }
        ObservableExtensionsKt.computationBuffered(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.Companion.getApi().userCreateDevice(new RestAPIParams$UserDevices(this.pushToken)), false, 1, null)).k(o.a.g(null, new StoreNotifications$tryTokenPersist$1(this), null));
    }

    public final synchronized String getPushToken() {
        return this.pushToken;
    }

    public final Observable<NotificationClient$SettingsV2> getSettings() {
        return ObservableExtensionsKt.computationBuffered(this.notificationSettings.getObservable());
    }

    public final synchronized void handleAuthToken(String authToken) {
        this.authToken = authToken;
        tryTokenPersist();
    }

    @StoreThread
    public final void handleChannelSelected(long channelId) {
        f.H0(f.c(k0.a), null, null, new StoreNotifications$handleChannelSelected$1(channelId, null), 3, null);
    }

    @StoreThread
    public final void handleMessageCreate(com.discord.api.message.Message message) {
        Channel channel;
        m.checkNotNullParameter(message, "message");
        if (this.notificationSettings.get().isEnabledInApp() && this.stream.getPresences().getLocalPresence().getStatus() != ClientStatus.DND) {
            Map<Long, Integer> relationships = this.stream.getUserRelationships().getRelationships();
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map$Entry<Long, Integer> map$Entry : relationships.entrySet()) {
                if (map$Entry.getValue().intValue() == 2) {
                    linkedHashMap.put(map$Entry.getKey(), map$Entry.getValue());
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
                if (NotificationTextUtils.INSTANCE.shouldNotifyInAppPopup(this.stream.getUsers().getMe(), message, channel, linkedHashMap, map != null ? map.get(Long.valueOf(channel.getParentId())) : null, (Guild) a.c(channel, this.stream.getGuilds().getGuildsInternal$app_productionGoogleRelease()), this.stream.getGuilds().getGuildMembersComputedInternal$app_productionGoogleRelease(), this.stream.getGuildSettings().getGuildSettingsInternal$app_productionGoogleRelease(), this.stream.getThreadsJoined().getAllJoinedThreadsInternal$app_productionGoogleRelease(), this.stream.getVoiceChannelSelected().getSelectedVoiceChannelId(), (Long) a.d(channel, this.stream.getPermissions().getPermissionsByChannel()))) {
                    displayPopup(new Message(message), channel);
                }
            }
        }
    }

    public final void handlePreLogout() {
        Persister.set$default(this.notificationSettings, new NotificationClient$SettingsV2(false, false, false, false, false, false, null, null, null, FrameMetricsAggregator.EVERY_DURATION, null), false, 2, null);
    }

    public final void init(Application application) {
        m.checkNotNullParameter(application, "application");
        super.init((Context) application);
        configureContextSetter(application);
        configureNotificationClient();
    }

    public final void setEnabled(boolean enabled) {
        this.notificationSettings.getAndSet(true, new StoreNotifications$setEnabled$1(enabled));
        AnalyticsTracker.INSTANCE.updateNotifications(enabled);
    }

    public final void setEnabledInApp(boolean isEnabledInApp, boolean logToggle) {
        NotificationClient$SettingsV2 andSet = this.notificationSettings.getAndSet(true, new StoreNotifications$setEnabledInApp$oldValue$1(isEnabledInApp));
        if (!logToggle || andSet.isEnabledInApp() == isEnabledInApp) {
            return;
        }
        AnalyticsTracker.INSTANCE.updateNotificationsInApp(isEnabledInApp);
    }

    public final void setNotificationLightDisabled(boolean notificationLightDisabled) {
        this.notificationSettings.getAndSet(true, new StoreNotifications$setNotificationLightDisabled$1(notificationLightDisabled));
    }

    public final void setNotificationSoundDisabled(boolean notificationSoundDisabled) {
        this.notificationSettings.getAndSet(true, new StoreNotifications$setNotificationSoundDisabled$1(notificationSoundDisabled));
    }

    public final void setNotificationsVibrateDisabled(boolean notificationsVibrateDisabled) {
        this.notificationSettings.getAndSet(true, new StoreNotifications$setNotificationsVibrateDisabled$1(notificationsVibrateDisabled));
    }
}
