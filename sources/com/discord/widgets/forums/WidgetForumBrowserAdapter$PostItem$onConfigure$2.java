package com.discord.widgets.forums;

import android.view.View;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetForumBrowserAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetForumBrowserAdapter$PostItem$onConfigure$2 extends o implements Function1<View, Unit> {
    public final /* synthetic */ ForumBrowserItem$PostItem $item;
    public final /* synthetic */ WidgetForumBrowserAdapter$PostItem this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetForumBrowserAdapter$PostItem$onConfigure$2(WidgetForumBrowserAdapter$PostItem widgetForumBrowserAdapter$PostItem, ForumBrowserItem$PostItem forumBrowserItem$PostItem) {
        super(1);
        this.this$0 = widgetForumBrowserAdapter$PostItem;
        this.$item = forumBrowserItem$PostItem;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke2(view);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view) {
        m.checkNotNullParameter(view, "it");
        WidgetForumBrowserAdapter.access$getOnPostLongClick$p(WidgetForumBrowserAdapter$PostItem.access$getAdapter$p(this.this$0)).invoke(this.$item.getPost().getChannel());
    }
}
