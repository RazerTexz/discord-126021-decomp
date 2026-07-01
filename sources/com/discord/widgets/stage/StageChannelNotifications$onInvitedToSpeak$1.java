package com.discord.widgets.stage;

import android.app.Application;
import android.app.Notification;
import android.graphics.Bitmap;
import androidx.core.app.NotificationCompat$Builder;
import com.discord.api.channel.Channel;
import com.discord.stores.StoreStream;
import com.discord.utilities.icon.IconUtils;
import d0.l;
import d0.w.h.c;
import d0.w.i.a.b;
import d0.w.i.a.e;
import d0.w.i.a.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import s.a.h;

/* JADX INFO: compiled from: StageChannelNotifications.kt */
/* JADX INFO: loaded from: classes2.dex */
@e(c = "com.discord.widgets.stage.StageChannelNotifications$onInvitedToSpeak$1", f = "StageChannelNotifications.kt", l = {49}, m = "invokeSuspend")
public final class StageChannelNotifications$onInvitedToSpeak$1 extends k implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ NotificationCompat$Builder $builder;
    public final /* synthetic */ Channel $channel;
    public final /* synthetic */ Application $context;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StageChannelNotifications$onInvitedToSpeak$1(Channel channel, NotificationCompat$Builder notificationCompat$Builder, Application application, Continuation continuation) {
        super(2, continuation);
        this.$channel = channel;
        this.$builder = notificationCompat$Builder;
        this.$context = application;
    }

    @Override // d0.w.i.a.a
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        m.checkNotNullParameter(continuation, "completion");
        return new StageChannelNotifications$onInvitedToSpeak$1(this.$channel, this.$builder, this.$context, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((StageChannelNotifications$onInvitedToSpeak$1) create(coroutineScope, continuation)).invokeSuspend(Unit.a);
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0061  */
    @Override // d0.w.i.a.a
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = c.getCOROUTINE_SUSPENDED();
        int i = this.label;
        Bitmap bitmap = null;
        if (i == 0) {
            l.throwOnFailure(obj);
            String forChannel$default = IconUtils.getForChannel$default(this.$channel, null, 2, null);
            if (forChannel$default == null) {
                forChannel$default = IconUtils.getForGuild$default(StoreStream.Companion.getGuilds().getGuilds().get(b.boxLong(this.$channel.getGuildId())), null, false, null, 14, null);
            }
            if (forChannel$default != null) {
                StageChannelNotifications$onInvitedToSpeak$1$invokeSuspend$$inlined$let$lambda$1 stageChannelNotifications$onInvitedToSpeak$1$invokeSuspend$$inlined$let$lambda$1 = new StageChannelNotifications$onInvitedToSpeak$1$invokeSuspend$$inlined$let$lambda$1(null, this, forChannel$default);
                this.label = 1;
                obj = h.b(250L, stageChannelNotifications$onInvitedToSpeak$1$invokeSuspend$$inlined$let$lambda$1, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            if (bitmap != null) {
                this.$builder.setLargeIcon(bitmap);
            }
            StageChannelNotifications$Notifications$InvitedToSpeak stageChannelNotifications$Notifications$InvitedToSpeak = StageChannelNotifications$Notifications$InvitedToSpeak.INSTANCE;
            Application application = this.$context;
            Notification notificationBuild = this.$builder.build();
            m.checkNotNullExpressionValue(notificationBuild, "builder.build()");
            stageChannelNotifications$Notifications$InvitedToSpeak.notify(application, notificationBuild);
            return Unit.a;
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        l.throwOnFailure(obj);
        bitmap = (Bitmap) obj;
        if (bitmap != null) {
            this.$builder.setLargeIcon(bitmap);
        }
        StageChannelNotifications$Notifications$InvitedToSpeak stageChannelNotifications$Notifications$InvitedToSpeak2 = StageChannelNotifications$Notifications$InvitedToSpeak.INSTANCE;
        Application application2 = this.$context;
        Notification notificationBuild2 = this.$builder.build();
        m.checkNotNullExpressionValue(notificationBuild2, "builder.build()");
        stageChannelNotifications$Notifications$InvitedToSpeak2.notify(application2, notificationBuild2);
        return Unit.a;
    }
}
