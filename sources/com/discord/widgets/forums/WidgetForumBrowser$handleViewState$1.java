package com.discord.widgets.forums;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetForumBrowser.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetForumBrowser$handleViewState$1 extends o implements Function1<Boolean, Unit> {
    public final /* synthetic */ WidgetForumBrowserViewModel$ViewState $viewState;
    public final /* synthetic */ WidgetForumBrowser this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetForumBrowser$handleViewState$1(WidgetForumBrowser widgetForumBrowser, WidgetForumBrowserViewModel$ViewState widgetForumBrowserViewModel$ViewState) {
        super(1);
        this.this$0 = widgetForumBrowser;
        this.$viewState = widgetForumBrowserViewModel$ViewState;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
        invoke(bool.booleanValue());
        return Unit.a;
    }

    public final void invoke(boolean z2) {
        WidgetForumBrowser.access$setPanelNsfwHidden$p(this.this$0, !z2);
        WidgetForumBrowserViewModel$ViewState widgetForumBrowserViewModel$ViewState = this.$viewState;
        if (widgetForumBrowserViewModel$ViewState instanceof WidgetForumBrowserViewModel$ViewState$Loaded) {
            WidgetForumBrowser.access$configureCreatePostButton(this.this$0, (WidgetForumBrowserViewModel$ViewState$Loaded) widgetForumBrowserViewModel$ViewState);
            WidgetForumBrowser.access$configureGuidelinesButton(this.this$0, (WidgetForumBrowserViewModel$ViewState$Loaded) this.$viewState);
        }
    }
}
