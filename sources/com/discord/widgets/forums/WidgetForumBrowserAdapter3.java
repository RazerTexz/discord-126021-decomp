package com.discord.widgets.forums;

import android.view.View;
import com.discord.widgets.forums.ForumBrowserItem;
import com.discord.widgets.forums.WidgetForumBrowserAdapter;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.forums.WidgetForumBrowserAdapter$PostItem$onConfigure$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetForumBrowserAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetForumBrowserAdapter3 extends Lambda implements Function1<View, Unit> {
    public final /* synthetic */ ForumBrowserItem.PostItem $item;
    public final /* synthetic */ WidgetForumBrowserAdapter.PostItem this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetForumBrowserAdapter3(WidgetForumBrowserAdapter.PostItem postItem, ForumBrowserItem.PostItem postItem2) {
        super(1);
        this.this$0 = postItem;
        this.$item = postItem2;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke2(view);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "it");
        WidgetForumBrowserAdapter.PostItem.access$getAdapter$p(this.this$0).onPostLongClick.invoke(this.$item.getPost().getChannel());
    }
}
