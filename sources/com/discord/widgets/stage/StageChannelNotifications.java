package com.discord.widgets.stage;

import android.app.Application;
import android.app.Notification;
import android.content.Context;
import android.graphics.Bitmap;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import com.discord.C5419R;
import com.discord.api.channel.Channel;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreStream;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.fcm.NotificationClient;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.lifecycle.ApplicationProvider;
import com.discord.utilities.voice.VoiceEngineForegroundService;
import com.discord.utilities.voice.VoiceEngineNotificationBuilder;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineScope;
import p007b.p008a.p020e.C0894d;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p507d0.C12083g;
import p507d0.C12113l;
import p507d0.p584w.p585h.C12183c;
import p507d0.p584w.p586i.p587a.AbstractC12194k;
import p507d0.p584w.p586i.p587a.C12185b;
import p507d0.p584w.p586i.p587a.InterfaceC12188e;
import p507d0.p592z.p594d.C12238m;
import p659s.p660a.C13114h;
import p659s.p660a.C13124k0;
import p659s.p660a.C13163x0;

/* JADX INFO: compiled from: StageChannelNotifications.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StageChannelNotifications {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy INSTANCE$delegate = C12083g.lazy(StageChannelNotifications$Companion$INSTANCE$2.INSTANCE);
    private static final long NOTIFICATION_ICON_FETCH_DELAY_MS = 250;
    public static final String NOTIFICATION_TAG = "stage-channels";
    private final StoreChannels channelsStore;

    /* JADX INFO: compiled from: StageChannelNotifications.kt */
    public static final class Companion {
        private Companion() {
        }

        public final StageChannelNotifications getINSTANCE() {
            Lazy lazy = StageChannelNotifications.INSTANCE$delegate;
            Companion companion = StageChannelNotifications.INSTANCE;
            return (StageChannelNotifications) lazy.getValue();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: StageChannelNotifications.kt */
    public static final class Notifications {
        public static final Notifications INSTANCE = new Notifications();

        /* JADX INFO: compiled from: StageChannelNotifications.kt */
        public static final class InvitedToSpeak {
            public static final InvitedToSpeak INSTANCE = new InvitedToSpeak();
            private static final int NOTIFICATION_ID = 102;

            private InvitedToSpeak() {
            }

            public final void cancel(Context context) {
                C12238m.checkNotNullParameter(context, "context");
                NotificationManagerCompat.from(context).cancel(StageChannelNotifications.NOTIFICATION_TAG, 102);
            }

            public final void notify(Context context, Notification notification) {
                C12238m.checkNotNullParameter(context, "context");
                C12238m.checkNotNullParameter(notification, "notification");
                NotificationManagerCompat.from(context).notify(StageChannelNotifications.NOTIFICATION_TAG, 102, notification);
            }
        }

        private Notifications() {
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.stage.StageChannelNotifications$onInvitedToSpeak$1 */
    /* JADX INFO: compiled from: StageChannelNotifications.kt */
    @InterfaceC12188e(m10084c = "com.discord.widgets.stage.StageChannelNotifications$onInvitedToSpeak$1", m10085f = "StageChannelNotifications.kt", m10086l = {49}, m10087m = "invokeSuspend")
    public static final class C100131 extends AbstractC12194k implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public final /* synthetic */ NotificationCompat.Builder $builder;
        public final /* synthetic */ Channel $channel;
        public final /* synthetic */ Application $context;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C100131(Channel channel, NotificationCompat.Builder builder, Application application, Continuation continuation) {
            super(2, continuation);
            this.$channel = channel;
            this.$builder = builder;
            this.$context = application;
        }

        @Override // p507d0.p584w.p586i.p587a.AbstractC12184a
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C12238m.checkNotNullParameter(continuation, "completion");
            return new C100131(this.$channel, this.$builder, this.$context, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C100131) create(coroutineScope, continuation)).invokeSuspend(Unit.f27425a);
        }

        /* JADX WARN: Code duplicated, block: B:18:0x0061  */
        @Override // p507d0.p584w.p586i.p587a.AbstractC12184a
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = C12183c.getCOROUTINE_SUSPENDED();
            int i = this.label;
            Bitmap bitmap = null;
            if (i == 0) {
                C12113l.throwOnFailure(obj);
                String forChannel$default = IconUtils.getForChannel$default(this.$channel, null, 2, null);
                if (forChannel$default == null) {
                    forChannel$default = IconUtils.getForGuild$default(StoreStream.INSTANCE.getGuilds().getGuilds().get(C12185b.boxLong(this.$channel.getGuildId())), null, false, null, 14, null);
                }
                if (forChannel$default != null) {
                    C10014xb1a69f5f c10014xb1a69f5f = new C10014xb1a69f5f(null, this, forChannel$default);
                    this.label = 1;
                    obj = C13114h.m11283b(StageChannelNotifications.NOTIFICATION_ICON_FETCH_DELAY_MS, c10014xb1a69f5f, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                if (bitmap != null) {
                    this.$builder.setLargeIcon(bitmap);
                }
                Notifications.InvitedToSpeak invitedToSpeak = Notifications.InvitedToSpeak.INSTANCE;
                Application application = this.$context;
                Notification notificationBuild = this.$builder.build();
                C12238m.checkNotNullExpressionValue(notificationBuild, "builder.build()");
                invitedToSpeak.notify(application, notificationBuild);
                return Unit.f27425a;
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C12113l.throwOnFailure(obj);
            bitmap = (Bitmap) obj;
            if (bitmap != null) {
                this.$builder.setLargeIcon(bitmap);
            }
            Notifications.InvitedToSpeak invitedToSpeak2 = Notifications.InvitedToSpeak.INSTANCE;
            Application application2 = this.$context;
            Notification notificationBuild2 = this.$builder.build();
            C12238m.checkNotNullExpressionValue(notificationBuild2, "builder.build()");
            invitedToSpeak2.notify(application2, notificationBuild2);
            return Unit.f27425a;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public StageChannelNotifications() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public StageChannelNotifications(StoreChannels storeChannels) {
        C12238m.checkNotNullParameter(storeChannels, "channelsStore");
        this.channelsStore = storeChannels;
    }

    private final NotificationCompat.Builder createChannelNotificationBuilder(Context context, Channel channel) {
        NotificationCompat.Builder color = new NotificationCompat.Builder(context, NotificationClient.NOTIF_CHANNEL_CALLS).setAutoCancel(true).setOnlyAlertOnce(true).setColor(ColorCompat.getThemedColor(context, C5419R.attr.color_brand_500));
        String topic = channel.getTopic();
        if (topic == null) {
            topic = channel.getName();
        }
        NotificationCompat.Builder contentIntent = color.setContentTitle(topic).setSmallIcon(C5419R.drawable.ic_channel_stage_24dp_white).setContentIntent(VoiceEngineNotificationBuilder.getCallScreenNavigationIntent$default(VoiceEngineNotificationBuilder.INSTANCE, context, channel.getId(), null, null, 6, null));
        C12238m.checkNotNullExpressionValue(contentIntent, "NotificationCompat.Build…gationIntent(channel.id))");
        return contentIntent;
    }

    public final void onInviteToSpeakRescinded() {
        Notifications.InvitedToSpeak.INSTANCE.cancel(ApplicationProvider.INSTANCE.get());
    }

    public final void onInvitedToSpeak(long channelId) {
        Channel channel;
        C0894d c0894d = C0894d.f600d;
        if (!C0894d.f597a || (channel = this.channelsStore.getChannel(channelId)) == null) {
            return;
        }
        Application application = ApplicationProvider.INSTANCE.get();
        VoiceEngineForegroundService.Companion companion = VoiceEngineForegroundService.INSTANCE;
        NotificationCompat.Builder builderAddAction = createChannelNotificationBuilder(application, channel).setContentText(application.getString(C5419R.string.stage_speak_invite_header)).addAction(0, application.getString(C5419R.string.stage_speak_invite_accept), companion.stageInviteAckPendingIntent(application, channelId, true)).addAction(0, application.getString(C5419R.string.stage_speak_invite_decline), companion.stageInviteAckPendingIntent(application, channelId, false));
        C12238m.checkNotNullExpressionValue(builderAddAction, "createChannelNotificatio…_decline), declineIntent)");
        C3404f.m4211H0(C13163x0.f27919j, C13124k0.f27867b, null, new C100131(channel, builderAddAction, application, null), 2, null);
    }

    public final void onInvitedToSpeakAckFailed(long channelId) {
        Channel channel = this.channelsStore.getChannel(channelId);
        if (channel != null) {
            Application application = ApplicationProvider.INSTANCE.get();
            Notifications.InvitedToSpeak invitedToSpeak = Notifications.InvitedToSpeak.INSTANCE;
            Notification notificationBuild = createChannelNotificationBuilder(application, channel).setContentText(application.getString(C5419R.string.error_generic_title)).build();
            C12238m.checkNotNullExpressionValue(notificationBuild, "createChannelNotificatio…le))\n            .build()");
            invitedToSpeak.notify(application, notificationBuild);
        }
    }

    public /* synthetic */ StageChannelNotifications(StoreChannels storeChannels, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? StoreStream.INSTANCE.getChannels() : storeChannels);
    }
}
