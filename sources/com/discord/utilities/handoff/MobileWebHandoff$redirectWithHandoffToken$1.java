package com.discord.utilities.handoff;

import d0.w.i.a.d;
import d0.w.i.a.e;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: MobileWebHandoff.kt */
/* JADX INFO: loaded from: classes2.dex */
@e(c = "com.discord.utilities.handoff.MobileWebHandoff", f = "MobileWebHandoff.kt", l = {44}, m = "redirectWithHandoffToken")
public final class MobileWebHandoff$redirectWithHandoffToken$1 extends d {
    public Object L$0;
    public Object L$1;
    public Object L$2;
    public boolean Z$0;
    public boolean Z$1;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ MobileWebHandoff this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MobileWebHandoff$redirectWithHandoffToken$1(MobileWebHandoff mobileWebHandoff, Continuation continuation) {
        super(continuation);
        this.this$0 = mobileWebHandoff;
    }

    @Override // d0.w.i.a.a
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.redirectWithHandoffToken(null, false, false, this);
    }
}
