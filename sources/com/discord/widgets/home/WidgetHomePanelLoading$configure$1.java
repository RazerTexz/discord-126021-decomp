package com.discord.widgets.home;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetHomePanelLoading.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHomePanelLoading$configure$1 extends o implements Function1<Boolean, Unit> {
    public final /* synthetic */ WidgetHomePanelLoading this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetHomePanelLoading$configure$1(WidgetHomePanelLoading widgetHomePanelLoading) {
        super(1);
        this.this$0 = widgetHomePanelLoading;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
        invoke(bool.booleanValue());
        return Unit.a;
    }

    public final void invoke(boolean z2) {
        WidgetHomePanelLoading.access$setLoadingPanelVisibility(this.this$0, z2, true);
    }
}
