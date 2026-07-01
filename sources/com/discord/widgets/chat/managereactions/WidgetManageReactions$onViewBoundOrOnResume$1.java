package com.discord.widgets.chat.managereactions;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetManageReactions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetManageReactions$onViewBoundOrOnResume$1 extends o implements Function1<ManageReactionsModel, Unit> {
    public final /* synthetic */ WidgetManageReactions this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetManageReactions$onViewBoundOrOnResume$1(WidgetManageReactions widgetManageReactions) {
        super(1);
        this.this$0 = widgetManageReactions;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ManageReactionsModel manageReactionsModel) {
        invoke2(manageReactionsModel);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ManageReactionsModel manageReactionsModel) {
        WidgetManageReactions.access$configureUI(this.this$0, manageReactionsModel);
    }
}
