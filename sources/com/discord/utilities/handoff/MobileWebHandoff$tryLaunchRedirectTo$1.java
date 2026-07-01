package com.discord.utilities.handoff;

import d0.l;
import d0.w.h.c;
import d0.w.i.a.e;
import d0.w.i.a.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: MobileWebHandoff.kt */
/* JADX INFO: loaded from: classes2.dex */
@e(c = "com.discord.utilities.handoff.MobileWebHandoff$tryLaunchRedirectTo$1", f = "MobileWebHandoff.kt", l = {36}, m = "invokeSuspend")
public final class MobileWebHandoff$tryLaunchRedirectTo$1 extends k implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ boolean $preventCustomTab;
    public final /* synthetic */ boolean $skipLoginRedirect;
    public final /* synthetic */ String $url;
    public int label;
    public final /* synthetic */ MobileWebHandoff this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MobileWebHandoff$tryLaunchRedirectTo$1(MobileWebHandoff mobileWebHandoff, String str, boolean z2, boolean z3, Continuation continuation) {
        super(2, continuation);
        this.this$0 = mobileWebHandoff;
        this.$url = str;
        this.$skipLoginRedirect = z2;
        this.$preventCustomTab = z3;
    }

    @Override // d0.w.i.a.a
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        m.checkNotNullParameter(continuation, "completion");
        return new MobileWebHandoff$tryLaunchRedirectTo$1(this.this$0, this.$url, this.$skipLoginRedirect, this.$preventCustomTab, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MobileWebHandoff$tryLaunchRedirectTo$1) create(coroutineScope, continuation)).invokeSuspend(Unit.a);
    }

    @Override // d0.w.i.a.a
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = c.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            l.throwOnFailure(obj);
            MobileWebHandoff mobileWebHandoff = this.this$0;
            String str = this.$url;
            boolean z2 = this.$skipLoginRedirect;
            boolean z3 = this.$preventCustomTab;
            this.label = 1;
            if (mobileWebHandoff.redirectWithHandoffToken(str, z2, z3, this) == coroutine_suspended) {
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
