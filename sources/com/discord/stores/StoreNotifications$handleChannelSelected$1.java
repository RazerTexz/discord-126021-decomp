package com.discord.stores;

import com.discord.utilities.fcm.NotificationClient;
import d0.l;
import d0.w.h.c;
import d0.w.i.a.e;
import d0.w.i.a.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: StoreNotifications.kt */
/* JADX INFO: loaded from: classes2.dex */
@e(c = "com.discord.stores.StoreNotifications$handleChannelSelected$1", f = "StoreNotifications.kt", l = {}, m = "invokeSuspend")
public final class StoreNotifications$handleChannelSelected$1 extends k implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ long $channelId;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreNotifications$handleChannelSelected$1(long j, Continuation continuation) {
        super(2, continuation);
        this.$channelId = j;
    }

    @Override // d0.w.i.a.a
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        m.checkNotNullParameter(continuation, "completion");
        return new StoreNotifications$handleChannelSelected$1(this.$channelId, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((StoreNotifications$handleChannelSelected$1) create(coroutineScope, continuation)).invokeSuspend(Unit.a);
    }

    @Override // d0.w.i.a.a
    public final Object invokeSuspend(Object obj) {
        c.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        l.throwOnFailure(obj);
        NotificationClient.clear$default(NotificationClient.INSTANCE, this.$channelId, null, false, 6, null);
        return Unit.a;
    }
}
