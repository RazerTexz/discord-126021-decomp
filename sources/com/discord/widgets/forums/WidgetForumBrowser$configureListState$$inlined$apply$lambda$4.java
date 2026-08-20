package com.discord.widgets.forums;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: compiled from: WidgetForumBrowser.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetForumBrowser$configureListState$$inlined$apply$lambda$4 extends AbstractC12240o implements Function1<Integer, Unit> {
    public final /* synthetic */ WidgetForumBrowserViewModel.ViewState.Loaded $viewState$inlined;
    public final /* synthetic */ WidgetForumBrowser this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetForumBrowser$configureListState$$inlined$apply$lambda$4(WidgetForumBrowser widgetForumBrowser, WidgetForumBrowserViewModel.ViewState.Loaded loaded) {
        super(1);
        this.this$0 = widgetForumBrowser;
        this.$viewState$inlined = loaded;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
        invoke(num.intValue());
        return Unit.f27425a;
    }

    public final void invoke(int i) {
        this.this$0.enqueueForumPostFirstMessageFetches(this.$viewState$inlined.getChannelId(), this.$viewState$inlined.getGuildId());
        if (i == 0) {
            this.this$0.getViewModel().maybeFetchForumPostFirstMessages(this.$viewState$inlined.getChannelId(), this.$viewState$inlined.getGuildId(), (4 & 4) != 0 ? false : false);
        }
    }
}
