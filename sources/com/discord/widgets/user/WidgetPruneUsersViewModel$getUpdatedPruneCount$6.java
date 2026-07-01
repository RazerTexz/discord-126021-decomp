package com.discord.widgets.user;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetPruneUsersViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class WidgetPruneUsersViewModel$getUpdatedPruneCount$6 extends k implements Function1<WidgetPruneUsersViewModel$ViewState, Unit> {
    public WidgetPruneUsersViewModel$getUpdatedPruneCount$6(WidgetPruneUsersViewModel widgetPruneUsersViewModel) {
        super(1, widgetPruneUsersViewModel, WidgetPruneUsersViewModel.class, "updateViewState", "updateViewState(Ljava/lang/Object;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetPruneUsersViewModel$ViewState widgetPruneUsersViewModel$ViewState) {
        invoke2(widgetPruneUsersViewModel$ViewState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetPruneUsersViewModel$ViewState widgetPruneUsersViewModel$ViewState) {
        m.checkNotNullParameter(widgetPruneUsersViewModel$ViewState, "p1");
        WidgetPruneUsersViewModel.access$updateViewState((WidgetPruneUsersViewModel) this.receiver, widgetPruneUsersViewModel$ViewState);
    }
}
