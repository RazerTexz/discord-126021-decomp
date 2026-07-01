package com.discord.utilities.view.rounded;

import android.graphics.Canvas;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: RoundedRelativeLayout.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class RoundedRelativeLayout$draw$1 extends o implements Function1<Canvas, Unit> {
    public final /* synthetic */ RoundedRelativeLayout this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoundedRelativeLayout$draw$1(RoundedRelativeLayout roundedRelativeLayout) {
        super(1);
        this.this$0 = roundedRelativeLayout;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Canvas canvas) {
        invoke2(canvas);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Canvas canvas) {
        m.checkNotNullParameter(canvas, "it");
        RoundedRelativeLayout.access$draw$s1843631363(this.this$0, canvas);
    }
}
