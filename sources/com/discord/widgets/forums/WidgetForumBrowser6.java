package com.discord.widgets.forums;

import com.discord.widgets.forums.WidgetForumBrowserViewModel;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.forums.WidgetForumBrowser$configureListState$$inlined$apply$lambda$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetForumBrowser.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetForumBrowser6 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ WidgetForumBrowserViewModel.ViewState.Loaded $viewState$inlined;
    public final /* synthetic */ WidgetForumBrowser this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetForumBrowser6(WidgetForumBrowser widgetForumBrowser, WidgetForumBrowserViewModel.ViewState.Loaded loaded) {
        super(0);
        this.this$0 = widgetForumBrowser;
        this.$viewState$inlined = loaded;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        this.this$0.enqueueForumPostFirstMessageFetches(this.$viewState$inlined.getChannelId(), this.$viewState$inlined.getGuildId());
    }
}
