package com.discord.widgets.forums;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetForumBrowser.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetForumBrowser$onResume$2 extends o implements Function1<WidgetForumBrowserViewModel$ViewState, Unit> {
    public final /* synthetic */ WidgetForumBrowser this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetForumBrowser$onResume$2(WidgetForumBrowser widgetForumBrowser) {
        super(1);
        this.this$0 = widgetForumBrowser;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetForumBrowserViewModel$ViewState widgetForumBrowserViewModel$ViewState) {
        invoke2(widgetForumBrowserViewModel$ViewState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetForumBrowserViewModel$ViewState widgetForumBrowserViewModel$ViewState) {
        m.checkNotNullParameter(widgetForumBrowserViewModel$ViewState, "viewState");
        WidgetForumBrowser.access$handleViewState(this.this$0, widgetForumBrowserViewModel$ViewState);
    }
}
