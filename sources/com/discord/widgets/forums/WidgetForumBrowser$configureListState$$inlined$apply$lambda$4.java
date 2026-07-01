package com.discord.widgets.forums;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetForumBrowser.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetForumBrowser$configureListState$$inlined$apply$lambda$4 extends o implements Function1<Integer, Unit> {
    public final /* synthetic */ WidgetForumBrowserViewModel$ViewState$Loaded $viewState$inlined;
    public final /* synthetic */ WidgetForumBrowser this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetForumBrowser$configureListState$$inlined$apply$lambda$4(WidgetForumBrowser widgetForumBrowser, WidgetForumBrowserViewModel$ViewState$Loaded widgetForumBrowserViewModel$ViewState$Loaded) {
        super(1);
        this.this$0 = widgetForumBrowser;
        this.$viewState$inlined = widgetForumBrowserViewModel$ViewState$Loaded;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
        invoke(num.intValue());
        return Unit.a;
    }

    public final void invoke(int i) {
        WidgetForumBrowser.access$enqueueForumPostFirstMessageFetches(this.this$0, this.$viewState$inlined.getChannelId(), this.$viewState$inlined.getGuildId());
        if (i == 0) {
            WidgetForumBrowserViewModel.maybeFetchForumPostFirstMessages$default(WidgetForumBrowser.access$getViewModel$p(this.this$0), this.$viewState$inlined.getChannelId(), this.$viewState$inlined.getGuildId(), false, 4, null);
        }
    }
}
