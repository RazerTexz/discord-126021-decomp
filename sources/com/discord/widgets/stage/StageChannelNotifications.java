package com.discord.widgets.stage;

import android.app.Application;
import android.app.Notification;
import android.content.Context;
import androidx.core.app.NotificationCompat$Builder;
import b.a.e.d;
import b.i.a.f.e.o.f;
import com.discord.R$attr;
import com.discord.R$string;
import com.discord.api.channel.Channel;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreStream;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.fcm.NotificationClient;
import com.discord.utilities.lifecycle.ApplicationProvider;
import com.discord.utilities.voice.VoiceEngineForegroundService;
import com.discord.utilities.voice.VoiceEngineForegroundService$Companion;
import com.discord.utilities.voice.VoiceEngineNotificationBuilder;
import d0.g;
import d0.z.d.m;
import kotlin.Lazy;
import kotlin.jvm.internal.DefaultConstructorMarker;
import s.a.k0;
import s.a.x0;

/* JADX INFO: compiled from: StageChannelNotifications.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StageChannelNotifications {
    public static final StageChannelNotifications$Companion Companion = new StageChannelNotifications$Companion(null);
    private static final Lazy INSTANCE$delegate = g.lazy(StageChannelNotifications$Companion$INSTANCE$2.INSTANCE);
    private static final long NOTIFICATION_ICON_FETCH_DELAY_MS = 250;
    public static final String NOTIFICATION_TAG = "stage-channels";
    private final StoreChannels channelsStore;

    public StageChannelNotifications() {
        this(null, 1, null);
    }

    public StageChannelNotifications(StoreChannels storeChannels) {
        m.checkNotNullParameter(storeChannels, "channelsStore");
        this.channelsStore = storeChannels;
    }

    public static final /* synthetic */ Lazy access$getINSTANCE$cp() {
        return INSTANCE$delegate;
    }

    private final NotificationCompat$Builder createChannelNotificationBuilder(Context context, Channel channel) {
        NotificationCompat$Builder color = new NotificationCompat$Builder(context, NotificationClient.NOTIF_CHANNEL_CALLS).setAutoCancel(true).setOnlyAlertOnce(true).setColor(ColorCompat.getThemedColor(context, R$attr.color_brand_500));
        String topic = channel.getTopic();
        if (topic == null) {
            topic = channel.getName();
        }
        NotificationCompat$Builder contentIntent = color.setContentTitle(topic).setSmallIcon(2131231627).setContentIntent(VoiceEngineNotificationBuilder.getCallScreenNavigationIntent$default(VoiceEngineNotificationBuilder.INSTANCE, context, channel.getId(), null, null, 6, null));
        m.checkNotNullExpressionValue(contentIntent, "NotificationCompat.Build…gationIntent(channel.id))");
        return contentIntent;
    }

    public final void onInviteToSpeakRescinded() {
        StageChannelNotifications$Notifications$InvitedToSpeak.INSTANCE.cancel(ApplicationProvider.INSTANCE.get());
    }

    public final void onInvitedToSpeak(long channelId) {
        Channel channel;
        d dVar = d.d;
        if (!d.a || (channel = this.channelsStore.getChannel(channelId)) == null) {
            return;
        }
        Application application = ApplicationProvider.INSTANCE.get();
        VoiceEngineForegroundService$Companion voiceEngineForegroundService$Companion = VoiceEngineForegroundService.Companion;
        NotificationCompat$Builder notificationCompat$BuilderAddAction = createChannelNotificationBuilder(application, channel).setContentText(application.getString(2131895837)).addAction(0, application.getString(2131895834), voiceEngineForegroundService$Companion.stageInviteAckPendingIntent(application, channelId, true)).addAction(0, application.getString(2131895836), voiceEngineForegroundService$Companion.stageInviteAckPendingIntent(application, channelId, false));
        m.checkNotNullExpressionValue(notificationCompat$BuilderAddAction, "createChannelNotificatio…_decline), declineIntent)");
        f.H0(x0.j, k0.f3842b, null, new StageChannelNotifications$onInvitedToSpeak$1(channel, notificationCompat$BuilderAddAction, application, null), 2, null);
    }

    public final void onInvitedToSpeakAckFailed(long channelId) {
        Channel channel = this.channelsStore.getChannel(channelId);
        if (channel != null) {
            Application application = ApplicationProvider.INSTANCE.get();
            StageChannelNotifications$Notifications$InvitedToSpeak stageChannelNotifications$Notifications$InvitedToSpeak = StageChannelNotifications$Notifications$InvitedToSpeak.INSTANCE;
            Notification notificationBuild = createChannelNotificationBuilder(application, channel).setContentText(application.getString(R$string.error_generic_title)).build();
            m.checkNotNullExpressionValue(notificationBuild, "createChannelNotificatio…le))\n            .build()");
            stageChannelNotifications$Notifications$InvitedToSpeak.notify(application, notificationBuild);
        }
    }

    public /* synthetic */ StageChannelNotifications(StoreChannels storeChannels, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? StoreStream.Companion.getChannels() : storeChannels);
    }
}
