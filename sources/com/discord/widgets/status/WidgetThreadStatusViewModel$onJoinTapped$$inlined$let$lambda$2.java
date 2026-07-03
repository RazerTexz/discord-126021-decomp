package com.discord.widgets.status;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: compiled from: WidgetThreadStatusViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetThreadStatusViewModel$onJoinTapped$$inlined$let$lambda$2 extends AbstractC12240o implements Function0<Unit> {
    public final /* synthetic */ WidgetThreadStatusViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetThreadStatusViewModel$onJoinTapped$$inlined$let$lambda$2(WidgetThreadStatusViewModel widgetThreadStatusViewModel) {
        super(0);
        this.this$0 = widgetThreadStatusViewModel;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        this.this$0.updateViewLoading(false);
    }
}
