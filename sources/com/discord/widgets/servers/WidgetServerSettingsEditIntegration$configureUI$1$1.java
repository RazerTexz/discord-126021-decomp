package com.discord.widgets.servers;

import com.discord.utilities.dimmer.DimmerView;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetServerSettingsEditIntegration.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsEditIntegration$configureUI$1$1 extends o implements Function1<Void, Unit> {
    public final /* synthetic */ WidgetServerSettingsEditIntegration$configureUI$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsEditIntegration$configureUI$1$1(WidgetServerSettingsEditIntegration$configureUI$1 widgetServerSettingsEditIntegration$configureUI$1) {
        super(1);
        this.this$0 = widgetServerSettingsEditIntegration$configureUI$1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
        invoke2(r1);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Void r5) {
        DimmerView.setDimmed$default(WidgetServerSettingsEditIntegration.access$getBinding$p(this.this$0.this$0).f2560b, true, false, 2, null);
    }
}
