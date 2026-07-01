package com.discord.widgets.stage;

import android.app.Application;
import android.app.Notification;
import android.content.Context;
import android.graphics.Bitmap;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import b.a.e.Backgrounded4;
import b.i.a.f.e.o.f;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreStream;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.fcm.NotificationClient;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.lifecycle.ApplicationProvider;
import com.discord.utilities.voice.VoiceEngineForegroundService;
import com.discord.utilities.voice.VoiceEngineNotificationBuilder;
import d0.LazyJVM;
import d0.Result3;
import d0.w.h.Intrinsics2;
import d0.w.i.a.ContinuationImpl6;
import d0.w.i.a.DebugMetadata;
import d0.w.i.a.boxing;
import d0.z.d.Intrinsics3;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineScope;
import s.a.Builders5;
import s.a.CoroutineScope2;
import s.a.Dispatchers;

/* JADX INFO: compiled from: StageChannelNotifications.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StageChannelNotifications {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy INSTANCE$delegate = LazyJVM.lazy(StageChannelNotifications2.INSTANCE);
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
                Intrinsics3.checkNotNullParameter(context, "context");
                NotificationManagerCompat.from(context).cancel(StageChannelNotifications.NOTIFICATION_TAG, 102);
            }

            public final void notify(Context context, Notification notification) {
                Intrinsics3.checkNotNullParameter(context, "context");
                Intrinsics3.checkNotNullParameter(notification, "notification");
                NotificationManagerCompat.from(context).notify(StageChannelNotifications.NOTIFICATION_TAG, 102, notification);
            }
        }

        private Notifications() {
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.stage.StageChannelNotifications$onInvitedToSpeak$1, reason: invalid class name */
    /* JADX INFO: compiled from: StageChannelNotifications.kt */
    @DebugMetadata(c = "com.discord.widgets.stage.StageChannelNotifications$onInvitedToSpeak$1", f = "StageChannelNotifications.kt", l = {49}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends ContinuationImpl6 implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public final /* synthetic */ NotificationCompat.Builder $builder;
        public final /* synthetic */ Channel $channel;
        public final /* synthetic */ Application $context;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Channel channel, NotificationCompat.Builder builder, Application application, Continuation continuation) {
            super(2, continuation);
            this.$channel = channel;
            this.$builder = builder;
            this.$context = application;
        }

        @Override // d0.w.i.a.ContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Intrinsics3.checkNotNullParameter(continuation, "completion");
            return new AnonymousClass1(this.$channel, this.$builder, this.$context, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.a);
        }

        /* JADX WARN: Code duplicated, block: B:18:0x0061  */
        @Override // d0.w.i.a.ContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = Intrinsics2.getCOROUTINE_SUSPENDED();
            int i = this.label;
            Bitmap bitmap = null;
            if (i == 0) {
                Result3.throwOnFailure(obj);
                String forChannel$default = IconUtils.getForChannel$default(this.$channel, null, 2, null);
                if (forChannel$default == null) {
                    forChannel$default = IconUtils.getForGuild$default(StoreStream.INSTANCE.getGuilds().getGuilds().get(boxing.boxLong(this.$channel.getGuildId())), null, false, null, 14, null);
                }
                if (forChannel$default != null) {
                    StageChannelNotifications4 stageChannelNotifications4 = new StageChannelNotifications4(null, this, forChannel$default);
                    this.label = 1;
                    obj = Builders5.b(StageChannelNotifications.NOTIFICATION_ICON_FETCH_DELAY_MS, stageChannelNotifications4, this);
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
                Intrinsics3.checkNotNullExpressionValue(notificationBuild, "builder.build()");
                invitedToSpeak.notify(application, notificationBuild);
                return Unit.a;
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Result3.throwOnFailure(obj);
            bitmap = (Bitmap) obj;
            if (bitmap != null) {
                this.$builder.setLargeIcon(bitmap);
            }
            Notifications.InvitedToSpeak invitedToSpeak2 = Notifications.InvitedToSpeak.INSTANCE;
            Application application2 = this.$context;
            Notification notificationBuild2 = this.$builder.build();
            Intrinsics3.checkNotNullExpressionValue(notificationBuild2, "builder.build()");
            invitedToSpeak2.notify(application2, notificationBuild2);
            return Unit.a;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public StageChannelNotifications() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public StageChannelNotifications(StoreChannels storeChannels) {
        Intrinsics3.checkNotNullParameter(storeChannels, "channelsStore");
        this.channelsStore = storeChannels;
    }

    private final NotificationCompat.Builder createChannelNotificationBuilder(Context context, Channel channel) {
        NotificationCompat.Builder color = new NotificationCompat.Builder(context, NotificationClient.NOTIF_CHANNEL_CALLS).setAutoCancel(true).setOnlyAlertOnce(true).setColor(ColorCompat.getThemedColor(context, R.attr.color_brand_500));
        String topic = channel.getTopic();
        if (topic == null) {
            topic = channel.getName();
        }
        NotificationCompat.Builder contentIntent = color.setContentTitle(topic).setSmallIcon(R.drawable.ic_channel_stage_24dp_white).setContentIntent(VoiceEngineNotificationBuilder.getCallScreenNavigationIntent$default(VoiceEngineNotificationBuilder.INSTANCE, context, channel.getId(), null, null, 6, null));
        Intrinsics3.checkNotNullExpressionValue(contentIntent, "NotificationCompat.Build…gationIntent(channel.id))");
        return contentIntent;
    }

    public final void onInviteToSpeakRescinded() {
        Notifications.InvitedToSpeak.INSTANCE.cancel(ApplicationProvider.INSTANCE.get());
    }

    public final void onInvitedToSpeak(long channelId) {
        Channel channel;
        Backgrounded4 backgrounded4 = Backgrounded4.d;
        if (!Backgrounded4.a || (channel = this.channelsStore.getChannel(channelId)) == null) {
            return;
        }
        Application application = ApplicationProvider.INSTANCE.get();
        VoiceEngineForegroundService.Companion companion = VoiceEngineForegroundService.INSTANCE;
        NotificationCompat.Builder builderAddAction = createChannelNotificationBuilder(application, channel).setContentText(application.getString(R.string.stage_speak_invite_header)).addAction(0, application.getString(R.string.stage_speak_invite_accept), companion.stageInviteAckPendingIntent(application, channelId, true)).addAction(0, application.getString(R.string.stage_speak_invite_decline), companion.stageInviteAckPendingIntent(application, channelId, false));
        Intrinsics3.checkNotNullExpressionValue(builderAddAction, "createChannelNotificatio…_decline), declineIntent)");
        f.H0(CoroutineScope2.j, Dispatchers.f3842b, null, new AnonymousClass1(channel, builderAddAction, application, null), 2, null);
    }

    public final void onInvitedToSpeakAckFailed(long channelId) {
        Channel channel = this.channelsStore.getChannel(channelId);
        if (channel != null) {
            Application application = ApplicationProvider.INSTANCE.get();
            Notifications.InvitedToSpeak invitedToSpeak = Notifications.InvitedToSpeak.INSTANCE;
            Notification notificationBuild = createChannelNotificationBuilder(application, channel).setContentText(application.getString(R.string.error_generic_title)).build();
            Intrinsics3.checkNotNullExpressionValue(notificationBuild, "createChannelNotificatio…le))\n            .build()");
            invitedToSpeak.notify(application, notificationBuild);
        }
    }

    public /* synthetic */ StageChannelNotifications(StoreChannels storeChannels, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? StoreStream.INSTANCE.getChannels() : storeChannels);
    }
}
