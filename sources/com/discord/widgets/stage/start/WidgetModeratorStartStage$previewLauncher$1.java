package com.discord.widgets.stage.start;

import androidx.fragment.app.FragmentActivity;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: compiled from: WidgetModeratorStartStage.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetModeratorStartStage$previewLauncher$1 extends AbstractC12240o implements Function0<Unit> {
    public final /* synthetic */ WidgetModeratorStartStage this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetModeratorStartStage$previewLauncher$1(WidgetModeratorStartStage widgetModeratorStartStage) {
        super(0);
        this.this$0 = widgetModeratorStartStage;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        FragmentActivity fragmentActivityM95e = this.this$0.m95e();
        if (fragmentActivityM95e != null) {
            fragmentActivityM95e.finish();
        }
    }
}
