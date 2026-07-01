package com.discord.views.calls;

import d0.w.i.a.d;
import d0.w.i.a.e;
import kotlin.coroutines.Continuation;
import org.objectweb.asm.Opcodes;

/* JADX INFO: compiled from: SpeakerPulseView.kt */
/* JADX INFO: loaded from: classes2.dex */
@e(c = "com.discord.views.calls.SpeakerPulseView", f = "SpeakerPulseView.kt", l = {Opcodes.LOR, Opcodes.I2D}, m = "animatePulse")
public final class SpeakerPulseView$b extends d {
    public long J$0;
    public Object L$0;
    public Object L$1;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ SpeakerPulseView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpeakerPulseView$b(SpeakerPulseView speakerPulseView, Continuation continuation) {
        super(continuation);
        this.this$0 = speakerPulseView;
    }

    @Override // d0.w.i.a.a
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.d(null, 0L, 0L, this);
    }
}
