package com.discord.widgets.auth;

import b.i.a.f.e.o.f;
import com.discord.models.domain.ModelRemoteAuthHandshake;
import d0.l;
import d0.w.h.c;
import d0.w.i.a.e;
import d0.w.i.a.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import rx.subjects.BehaviorSubject;

/* JADX INFO: compiled from: WidgetRemoteAuthViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
@e(c = "com.discord.widgets.auth.WidgetRemoteAuthViewModel$1$1", f = "WidgetRemoteAuthViewModel.kt", l = {54}, m = "invokeSuspend")
public final class WidgetRemoteAuthViewModel$1$1 extends k implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ ModelRemoteAuthHandshake $handshakeData;
    public int label;
    public final /* synthetic */ WidgetRemoteAuthViewModel$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetRemoteAuthViewModel$1$1(WidgetRemoteAuthViewModel$1 widgetRemoteAuthViewModel$1, ModelRemoteAuthHandshake modelRemoteAuthHandshake, Continuation continuation) {
        super(2, continuation);
        this.this$0 = widgetRemoteAuthViewModel$1;
        this.$handshakeData = modelRemoteAuthHandshake;
    }

    @Override // d0.w.i.a.a
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        m.checkNotNullParameter(continuation, "completion");
        return new WidgetRemoteAuthViewModel$1$1(this.this$0, this.$handshakeData, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((WidgetRemoteAuthViewModel$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.a);
    }

    @Override // d0.w.i.a.a
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = c.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            l.throwOnFailure(obj);
            this.label = 1;
            if (f.P(1000L, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            l.throwOnFailure(obj);
        }
        WidgetRemoteAuthViewModel widgetRemoteAuthViewModel = this.this$0.this$0;
        String handshakeToken = this.$handshakeData.getHandshakeToken();
        BehaviorSubject behaviorSubjectAccess$getTemporaryBehaviorSubject$p = WidgetRemoteAuthViewModel.access$getTemporaryBehaviorSubject$p(this.this$0.this$0);
        m.checkNotNullExpressionValue(behaviorSubjectAccess$getTemporaryBehaviorSubject$p, "temporaryBehaviorSubject");
        Object objN0 = behaviorSubjectAccess$getTemporaryBehaviorSubject$p.n0();
        m.checkNotNullExpressionValue(objN0, "temporaryBehaviorSubject.value");
        WidgetRemoteAuthViewModel.access$updateViewState(widgetRemoteAuthViewModel, new WidgetRemoteAuthViewModel$ViewState$Loaded(handshakeToken, ((Boolean) objN0).booleanValue(), true));
        return Unit.a;
    }
}
