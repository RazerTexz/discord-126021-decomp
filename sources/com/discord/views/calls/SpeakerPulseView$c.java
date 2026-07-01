package com.discord.views.calls;

import d0.w.i.a.d;
import d0.w.i.a.e;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: SpeakerPulseView.kt */
/* JADX INFO: loaded from: classes2.dex */
@e(c = "com.discord.views.calls.SpeakerPulseView", f = "SpeakerPulseView.kt", l = {117}, m = "performPulseAnimation")
public final class SpeakerPulseView$c extends d {
    public Object L$0;
    public Object L$1;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ SpeakerPulseView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpeakerPulseView$c(SpeakerPulseView speakerPulseView, Continuation continuation) {
        super(continuation);
        this.this$0 = speakerPulseView;
    }

    @Override // d0.w.i.a.a
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.e(null, this);
    }
}
