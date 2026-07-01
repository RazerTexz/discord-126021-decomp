package com.discord.utilities.rx;

import androidx.exifinterface.media.ExifInterface;
import d0.l;
import d0.w.h.c;
import d0.w.i.a.e;
import d0.w.i.a.k;
import d0.z.d.m;
import j0.g;
import j0.l.e.f;
import java.util.Objects;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.ProducerScope;
import rx.Observable;
import rx.Subscriber;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: RxCoroutineUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
@e(c = "com.discord.utilities.rx.RxCoroutineUtilsKt$toFlow$2", f = "RxCoroutineUtils.kt", l = {47}, m = "invokeSuspend")
public final class RxCoroutineUtilsKt$toFlow$2<T> extends k implements Function2<ProducerScope<? super T>, Continuation<? super Unit>, Object> {
    public final /* synthetic */ Observable $this_toFlow;
    private /* synthetic */ Object L$0;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RxCoroutineUtilsKt$toFlow$2(Observable observable, Continuation continuation) {
        super(2, continuation);
        this.$this_toFlow = observable;
    }

    @Override // d0.w.i.a.a
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        m.checkNotNullParameter(continuation, "completion");
        RxCoroutineUtilsKt$toFlow$2 rxCoroutineUtilsKt$toFlow$2 = new RxCoroutineUtilsKt$toFlow$2(this.$this_toFlow, continuation);
        rxCoroutineUtilsKt$toFlow$2.L$0 = obj;
        return rxCoroutineUtilsKt$toFlow$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Continuation<? super Unit> continuation) {
        return ((RxCoroutineUtilsKt$toFlow$2) create(obj, continuation)).invokeSuspend(Unit.a);
    }

    @Override // d0.w.i.a.a
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = c.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            l.throwOnFailure(obj);
            ProducerScope producerScope = (ProducerScope) this.L$0;
            Observable observable = this.$this_toFlow;
            g rxCoroutineUtilsKt$toFlow$2$subscription$1 = new RxCoroutineUtilsKt$toFlow$2$subscription$1(producerScope);
            Objects.requireNonNull(observable);
            RxCoroutineUtilsKt$toFlow$2$1 rxCoroutineUtilsKt$toFlow$2$1 = new RxCoroutineUtilsKt$toFlow$2$1(rxCoroutineUtilsKt$toFlow$2$subscription$1 instanceof Subscriber ? observable.U((Subscriber) rxCoroutineUtilsKt$toFlow$2$subscription$1) : observable.U(new f(rxCoroutineUtilsKt$toFlow$2$subscription$1)));
            this.label = 1;
            if (s.a.c2.l.a(producerScope, rxCoroutineUtilsKt$toFlow$2$1, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            l.throwOnFailure(obj);
        }
        return Unit.a;
    }
}
