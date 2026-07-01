package com.discord.widgets.chat.list;

import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.utilities.rx.RxCoroutineUtilsKt;
import d0.l;
import d0.w.h.c;
import d0.w.i.a.e;
import d0.w.i.a.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import rx.Observable;
import s.a.d2.d;

/* JADX INFO: compiled from: InlineMediaView.kt */
/* JADX INFO: loaded from: classes2.dex */
@e(c = "com.discord.widgets.chat.list.InlineMediaView$onViewAttachedToWindow$1", f = "InlineMediaView.kt", l = {89, 416}, m = "invokeSuspend")
public final class InlineMediaView$onViewAttachedToWindow$1 extends k implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public int label;
    public final /* synthetic */ InlineMediaView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InlineMediaView$onViewAttachedToWindow$1(InlineMediaView inlineMediaView, Continuation continuation) {
        super(2, continuation);
        this.this$0 = inlineMediaView;
    }

    @Override // d0.w.i.a.a
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        m.checkNotNullParameter(continuation, "completion");
        return new InlineMediaView$onViewAttachedToWindow$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((InlineMediaView$onViewAttachedToWindow$1) create(coroutineScope, continuation)).invokeSuspend(Unit.a);
    }

    @Override // d0.w.i.a.a
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = c.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i == 1) {
                l.throwOnFailure(obj);
            } else {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                l.throwOnFailure(obj);
            }
            return Unit.a;
        }
        l.throwOnFailure(obj);
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        Observable observableR = Observable.j(storeStream$Companion.getNavigation().observeLeftPanelState(), storeStream$Companion.getNavigation().observeRightPanelState(), InlineMediaView$onViewAttachedToWindow$1$1.INSTANCE).r();
        m.checkNotNullExpressionValue(observableR, "Observable.combineLatest…  .distinctUntilChanged()");
        this.label = 1;
        obj = RxCoroutineUtilsKt.toFlow(observableR, this);
        if (obj == coroutine_suspended) {
            return coroutine_suspended;
        }
        InlineMediaView$onViewAttachedToWindow$1$invokeSuspend$$inlined$collect$1 inlineMediaView$onViewAttachedToWindow$1$invokeSuspend$$inlined$collect$1 = new InlineMediaView$onViewAttachedToWindow$1$invokeSuspend$$inlined$collect$1(this);
        this.label = 2;
        if (((d) obj).a(inlineMediaView$onViewAttachedToWindow$1$invokeSuspend$$inlined$collect$1, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.a;
    }
}
