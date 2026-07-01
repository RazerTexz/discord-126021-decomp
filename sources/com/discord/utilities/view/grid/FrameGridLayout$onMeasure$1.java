package com.discord.utilities.view.grid;

import android.view.View;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: FrameGridLayout.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class FrameGridLayout$onMeasure$1 extends o implements Function2<View, FrameGridLayout$PositionSpec, Unit> {
    public final /* synthetic */ FrameGridLayout this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrameGridLayout$onMeasure$1(FrameGridLayout frameGridLayout) {
        super(2);
        this.this$0 = frameGridLayout;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(View view, FrameGridLayout$PositionSpec frameGridLayout$PositionSpec) {
        invoke2(view, frameGridLayout$PositionSpec);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view, FrameGridLayout$PositionSpec frameGridLayout$PositionSpec) {
        m.checkNotNullParameter(view, "view");
        m.checkNotNullParameter(frameGridLayout$PositionSpec, "childBounds");
        FrameGridLayout.access$measure(this.this$0, view, frameGridLayout$PositionSpec);
    }
}
