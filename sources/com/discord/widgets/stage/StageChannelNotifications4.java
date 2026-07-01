package com.discord.widgets.stage;

import android.graphics.Bitmap;
import com.discord.utilities.images.MGImagesBitmap;
import com.discord.utilities.rx.RxCoroutineUtils;
import com.discord.widgets.stage.StageChannelNotifications;
import d0.Result3;
import d0.w.h.Intrinsics2;
import d0.w.i.a.ContinuationImpl6;
import d0.w.i.a.DebugMetadata;
import d0.z.d.Intrinsics3;
import j0.k.Func1;
import j0.l.a.OnSubscribeLift;
import j0.l.a.OperatorOnErrorResumeNextViaFunction4;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import rx.Observable;

/* JADX INFO: renamed from: com.discord.widgets.stage.StageChannelNotifications$onInvitedToSpeak$1$invokeSuspend$$inlined$let$lambda$1, reason: use source file name */
/* JADX INFO: compiled from: StageChannelNotifications.kt */
/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.discord.widgets.stage.StageChannelNotifications$onInvitedToSpeak$1$bitmap$1$1", f = "StageChannelNotifications.kt", l = {51}, m = "invokeSuspend")
public final class StageChannelNotifications4 extends ContinuationImpl6 implements Function2<CoroutineScope, Continuation<? super Bitmap>, Object> {
    public final /* synthetic */ String $iconUrl$inlined;
    public int label;
    public final /* synthetic */ StageChannelNotifications.AnonymousClass1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StageChannelNotifications4(Continuation continuation, StageChannelNotifications.AnonymousClass1 anonymousClass1, String str) {
        super(2, continuation);
        this.this$0 = anonymousClass1;
        this.$iconUrl$inlined = str;
    }

    @Override // d0.w.i.a.ContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics3.checkNotNullParameter(continuation, "completion");
        return new StageChannelNotifications4(continuation, this.this$0, this.$iconUrl$inlined);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Bitmap> continuation) {
        return ((StageChannelNotifications4) create(coroutineScope, continuation)).invokeSuspend(Unit.a);
    }

    @Override // d0.w.i.a.ContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = Intrinsics2.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            Result3.throwOnFailure(obj);
            Observable<Bitmap> bitmap = MGImagesBitmap.INSTANCE.getBitmap(this.$iconUrl$inlined, true);
            Observable observableH0 = Observable.h0(new OnSubscribeLift(bitmap.j, new OperatorOnErrorResumeNextViaFunction4(new Func1<Throwable, Observable<? extends Bitmap>>() { // from class: com.discord.widgets.stage.StageChannelNotifications$onInvitedToSpeak$1$bitmap$1$1$1
                @Override // j0.k.Func1
                public final Observable<? extends Bitmap> call(Throwable th) {
                    return null;
                }
            })));
            Intrinsics3.checkNotNullExpressionValue(observableH0, "MGImagesBitmap.getBitmap…nErrorResumeNext { null }");
            this.label = 1;
            obj = RxCoroutineUtils.awaitSingle(observableH0, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Result3.throwOnFailure(obj);
        }
        return obj;
    }
}
