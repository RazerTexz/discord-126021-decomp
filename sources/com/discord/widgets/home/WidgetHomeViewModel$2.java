package com.discord.widgets.home;

import com.discord.stores.StoreNavigation$PanelAction;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetHomeViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHomeViewModel$2 extends o implements Function1<StoreNavigation$PanelAction, Unit> {
    public final /* synthetic */ WidgetHomeViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetHomeViewModel$2(WidgetHomeViewModel widgetHomeViewModel) {
        super(1);
        this.this$0 = widgetHomeViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(StoreNavigation$PanelAction storeNavigation$PanelAction) {
        invoke2(storeNavigation$PanelAction);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(StoreNavigation$PanelAction storeNavigation$PanelAction) {
        m.checkNotNullParameter(storeNavigation$PanelAction, "panelAction");
        WidgetHomeViewModel.access$handleNavDrawerAction(this.this$0, storeNavigation$PanelAction);
    }
}
