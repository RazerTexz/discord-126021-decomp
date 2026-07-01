package com.discord.widgets.forums;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetForumBrowserViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetForumBrowserViewModel$maybeFetchOlderPosts$1 extends o implements Function0<Unit> {
    public final /* synthetic */ WidgetForumBrowserViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetForumBrowserViewModel$maybeFetchOlderPosts$1(WidgetForumBrowserViewModel widgetForumBrowserViewModel) {
        super(0);
        this.this$0 = widgetForumBrowserViewModel;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        WidgetForumBrowserViewModel.access$setFetchingMoreOlderPosts$p(this.this$0, false);
    }
}
