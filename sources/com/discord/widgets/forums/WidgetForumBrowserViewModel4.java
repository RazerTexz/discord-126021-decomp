package com.discord.widgets.forums;

import com.discord.api.channel.Channel;
import com.discord.widgets.forums.ForumBrowserItem;
import com.discord.widgets.forums.WidgetForumBrowserViewModel;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.forums.WidgetForumBrowserViewModel$setupListViewState$archivedPostItems$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetForumBrowserViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetForumBrowserViewModel4 extends Lambda implements Function1<Channel, ForumBrowserItem.PostItem> {
    public final /* synthetic */ WidgetForumBrowserViewModel.AnonymousClass1 $convertChannelToPostItem$1;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetForumBrowserViewModel4(WidgetForumBrowserViewModel.AnonymousClass1 anonymousClass1) {
        super(1);
        this.$convertChannelToPostItem$1 = anonymousClass1;
    }

    @Override // kotlin.jvm.functions.Function1
    public final ForumBrowserItem.PostItem invoke(Channel channel) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        return this.$convertChannelToPostItem$1.invoke(channel);
    }
}
