package com.discord.widgets.stage;

import d0.w.i.a.d;
import d0.w.i.a.e;
import kotlin.coroutines.Continuation;
import org.objectweb.asm.Opcodes;

/* JADX INFO: compiled from: StageChannelJoinHelper.kt */
/* JADX INFO: loaded from: classes2.dex */
@e(c = "com.discord.widgets.stage.StageChannelJoinHelper", f = "StageChannelJoinHelper.kt", l = {180, Opcodes.IF_ICMPEQ, Opcodes.IF_ACMPNE}, m = "lurkAndJoinStageAsync")
public final class StageChannelJoinHelper$lurkAndJoinStageAsync$1 extends d {
    public long J$0;
    public long J$1;
    public Object L$0;
    public Object L$1;
    public Object L$2;
    public Object L$3;
    public Object L$4;
    public Object L$5;
    public boolean Z$0;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ StageChannelJoinHelper this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StageChannelJoinHelper$lurkAndJoinStageAsync$1(StageChannelJoinHelper stageChannelJoinHelper, Continuation continuation) {
        super(continuation);
        this.this$0 = stageChannelJoinHelper;
    }

    @Override // d0.w.i.a.a
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.lurkAndJoinStageAsync(null, null, 0L, 0L, false, null, null, null, this);
    }
}
