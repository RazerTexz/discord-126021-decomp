package com.discord.widgets.forums;

import com.discord.api.channel.Channel;
import d0.z.d.m;
import d0.z.d.o;
import java.util.Set;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetForumBrowserViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetForumBrowserViewModel$setupListViewState$1 extends o implements Function1<Channel, ForumBrowserItem$PostItem> {
    public final /* synthetic */ Set $seenChannelIds;
    public final /* synthetic */ WidgetForumBrowserViewModel$StoreState$Loaded $storeState;
    public final /* synthetic */ WidgetForumBrowserViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetForumBrowserViewModel$setupListViewState$1(WidgetForumBrowserViewModel widgetForumBrowserViewModel, Set set, WidgetForumBrowserViewModel$StoreState$Loaded widgetForumBrowserViewModel$StoreState$Loaded) {
        super(1);
        this.this$0 = widgetForumBrowserViewModel;
        this.$seenChannelIds = set;
        this.$storeState = widgetForumBrowserViewModel$StoreState$Loaded;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ ForumBrowserItem$PostItem invoke(Channel channel) {
        return invoke2(channel);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final ForumBrowserItem$PostItem invoke2(Channel channel) {
        m.checkNotNullParameter(channel, "channel");
        if (this.$seenChannelIds.contains(Long.valueOf(channel.getId()))) {
            return null;
        }
        this.$seenChannelIds.add(Long.valueOf(channel.getId()));
        WidgetForumBrowserViewModel.access$getGuildMemberRequester$p(this.this$0).queueRequest(channel.getGuildId(), channel.getOwnerId());
        return WidgetForumBrowserViewModel.access$createPostItem(this.this$0, this.$storeState, channel);
    }
}
