package com.discord.widgets.status;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetForumPostStatusViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetForumPostStatusViewModel$1 extends o implements Function1<WidgetForumPostStatusViewModel$StoreState, Unit> {
    public final /* synthetic */ WidgetForumPostStatusViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetForumPostStatusViewModel$1(WidgetForumPostStatusViewModel widgetForumPostStatusViewModel) {
        super(1);
        this.this$0 = widgetForumPostStatusViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetForumPostStatusViewModel$StoreState widgetForumPostStatusViewModel$StoreState) {
        invoke2(widgetForumPostStatusViewModel$StoreState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetForumPostStatusViewModel$StoreState widgetForumPostStatusViewModel$StoreState) {
        WidgetForumPostStatusViewModel widgetForumPostStatusViewModel = this.this$0;
        m.checkNotNullExpressionValue(widgetForumPostStatusViewModel$StoreState, "storeState");
        widgetForumPostStatusViewModel.handleStoreState(widgetForumPostStatusViewModel$StoreState);
    }
}
