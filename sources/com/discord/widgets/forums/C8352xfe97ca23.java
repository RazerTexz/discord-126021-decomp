package com.discord.widgets.forums;

import com.discord.api.channel.Channel;
import com.discord.widgets.forums.ForumBrowserItem;
import com.discord.widgets.forums.WidgetForumBrowserViewModel;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: com.discord.widgets.forums.WidgetForumBrowserViewModel$setupListViewState$archivedPostItems$1 */
/* JADX INFO: compiled from: WidgetForumBrowserViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C8352xfe97ca23 extends AbstractC12240o implements Function1<Channel, ForumBrowserItem.PostItem> {
    public final /* synthetic */ WidgetForumBrowserViewModel.C83511 $convertChannelToPostItem$1;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C8352xfe97ca23(WidgetForumBrowserViewModel.C83511 c83511) {
        super(1);
        this.$convertChannelToPostItem$1 = c83511;
    }

    @Override // kotlin.jvm.functions.Function1
    public final ForumBrowserItem.PostItem invoke(Channel channel) {
        C12238m.checkNotNullParameter(channel, "channel");
        return this.$convertChannelToPostItem$1.invoke(channel);
    }
}
