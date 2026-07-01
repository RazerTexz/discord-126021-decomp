package com.discord.widgets.status;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetForumPostStatus.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetForumPostStatus$onResume$1 extends o implements Function1<WidgetForumPostStatusViewModel$ViewState, Unit> {
    public final /* synthetic */ WidgetForumPostStatus this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetForumPostStatus$onResume$1(WidgetForumPostStatus widgetForumPostStatus) {
        super(1);
        this.this$0 = widgetForumPostStatus;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetForumPostStatusViewModel$ViewState widgetForumPostStatusViewModel$ViewState) {
        invoke2(widgetForumPostStatusViewModel$ViewState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetForumPostStatusViewModel$ViewState widgetForumPostStatusViewModel$ViewState) {
        WidgetForumPostStatus widgetForumPostStatus = this.this$0;
        m.checkNotNullExpressionValue(widgetForumPostStatusViewModel$ViewState, "viewState");
        widgetForumPostStatus.handleViewState(widgetForumPostStatusViewModel$ViewState);
    }
}
