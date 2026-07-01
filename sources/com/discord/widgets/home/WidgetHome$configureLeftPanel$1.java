package com.discord.widgets.home;

import com.discord.panels.OverlappingPanelsLayout$LockState;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetHome.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHome$configureLeftPanel$1 extends o implements Function1<OverlappingPanelsLayout$LockState, Unit> {
    public final /* synthetic */ WidgetHome this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetHome$configureLeftPanel$1(WidgetHome widgetHome) {
        super(1);
        this.this$0 = widgetHome;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(OverlappingPanelsLayout$LockState overlappingPanelsLayout$LockState) {
        invoke2(overlappingPanelsLayout$LockState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(OverlappingPanelsLayout$LockState overlappingPanelsLayout$LockState) {
        m.checkNotNullParameter(overlappingPanelsLayout$LockState, "lockState");
        WidgetHome.access$getBinding$p(this.this$0).c.setStartPanelUseFullPortraitWidth(overlappingPanelsLayout$LockState == OverlappingPanelsLayout$LockState.OPEN);
        WidgetHome.access$getBinding$p(this.this$0).c.setStartPanelLockState(overlappingPanelsLayout$LockState);
    }
}
