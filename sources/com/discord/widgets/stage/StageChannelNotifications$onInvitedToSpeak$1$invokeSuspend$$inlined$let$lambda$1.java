package com.discord.widgets.stage;

import android.graphics.Bitmap;
import com.discord.utilities.images.MGImagesBitmap;
import com.discord.utilities.rx.RxCoroutineUtilsKt;
import d0.l;
import d0.w.h.c;
import d0.w.i.a.e;
import d0.w.i.a.k;
import d0.z.d.m;
import j0.l.a.f1;
import j0.l.a.r;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import rx.Observable;

/* JADX INFO: compiled from: StageChannelNotifications.kt */
/* JADX INFO: loaded from: classes2.dex */
@e(c = "com.discord.widgets.stage.StageChannelNotifications$onInvitedToSpeak$1$bitmap$1$1", f = "StageChannelNotifications.kt", l = {51}, m = "invokeSuspend")
public final class StageChannelNotifications$onInvitedToSpeak$1$invokeSuspend$$inlined$let$lambda$1 extends k implements Function2<CoroutineScope, Continuation<? super Bitmap>, Object> {
    public final /* synthetic */ String $iconUrl$inlined;
    public int label;
    public final /* synthetic */ StageChannelNotifications$onInvitedToSpeak$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StageChannelNotifications$onInvitedToSpeak$1$invokeSuspend$$inlined$let$lambda$1(Continuation continuation, StageChannelNotifications$onInvitedToSpeak$1 stageChannelNotifications$onInvitedToSpeak$1, String str) {
        super(2, continuation);
        this.this$0 = stageChannelNotifications$onInvitedToSpeak$1;
        this.$iconUrl$inlined = str;
    }

    @Override // d0.w.i.a.a
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        m.checkNotNullParameter(continuation, "completion");
        return new StageChannelNotifications$onInvitedToSpeak$1$invokeSuspend$$inlined$let$lambda$1(continuation, this.this$0, this.$iconUrl$inlined);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Bitmap> continuation) {
        return ((StageChannelNotifications$onInvitedToSpeak$1$invokeSuspend$$inlined$let$lambda$1) create(coroutineScope, continuation)).invokeSuspend(Unit.a);
    }

    @Override // d0.w.i.a.a
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = c.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            l.throwOnFailure(obj);
            Observable<Bitmap> bitmap = MGImagesBitmap.INSTANCE.getBitmap(this.$iconUrl$inlined, true);
            Observable observableH0 = Observable.h0(new r(bitmap.j, new f1(StageChannelNotifications$onInvitedToSpeak$1$bitmap$1$1$1.INSTANCE)));
            m.checkNotNullExpressionValue(observableH0, "MGImagesBitmap.getBitmap…nErrorResumeNext { null }");
            this.label = 1;
            obj = RxCoroutineUtilsKt.awaitSingle(observableH0, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            l.throwOnFailure(obj);
        }
        return obj;
    }
}
