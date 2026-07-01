package com.discord.utilities.view.grid;

import android.view.View;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: FrameGridLayout.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class FrameGridLayout$bindViews$1 extends o implements Function2<FrameGridLayout$Data, View, Unit> {
    public final /* synthetic */ FrameGridLayout this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrameGridLayout$bindViews$1(FrameGridLayout frameGridLayout) {
        super(2);
        this.this$0 = frameGridLayout;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(FrameGridLayout$Data frameGridLayout$Data, View view) {
        invoke2(frameGridLayout$Data, view);
        return Unit.a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(FrameGridLayout$Data frameGridLayout$Data, View view) {
        m.checkNotNullParameter(frameGridLayout$Data, "$this$bindView");
        boolean z2 = view instanceof FrameGridLayout$DataView;
        Object obj = view;
        if (!z2) {
            obj = null;
        }
        FrameGridLayout$DataView frameGridLayout$DataView = (FrameGridLayout$DataView) obj;
        if (frameGridLayout$DataView != 0) {
            frameGridLayout$DataView.onBind(frameGridLayout$Data);
            Function2 function2Access$getOnBindView$p = FrameGridLayout.access$getOnBindView$p(this.this$0);
            if (function2Access$getOnBindView$p != null) {
            }
        }
    }
}
