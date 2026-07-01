package com.discord.widgets.forums;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetForumBrowserViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetForumBrowserViewModel$1 extends o implements Function1<WidgetForumBrowserViewModel$StoreState, Unit> {
    public final /* synthetic */ WidgetForumBrowserViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetForumBrowserViewModel$1(WidgetForumBrowserViewModel widgetForumBrowserViewModel) {
        super(1);
        this.this$0 = widgetForumBrowserViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetForumBrowserViewModel$StoreState widgetForumBrowserViewModel$StoreState) {
        invoke2(widgetForumBrowserViewModel$StoreState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetForumBrowserViewModel$StoreState widgetForumBrowserViewModel$StoreState) {
        WidgetForumBrowserViewModel widgetForumBrowserViewModel = this.this$0;
        m.checkNotNullExpressionValue(widgetForumBrowserViewModel$StoreState, "storeState");
        WidgetForumBrowserViewModel.access$handleStoreState(widgetForumBrowserViewModel, widgetForumBrowserViewModel$StoreState);
    }
}
