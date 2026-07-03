package com.discord.widgets.channels.list;

import android.view.View;
import com.discord.widgets.channels.list.WidgetChannelsListAdapter;
import com.discord.widgets.channels.list.items.ChannelListItem;
import com.discord.widgets.channels.list.items.ChannelListItemCategory;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetChannelsListAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelsListAdapter$ItemChannelCategory$onConfigure$1 extends AbstractC12240o implements Function1<View, Unit> {
    public final /* synthetic */ ChannelListItem $data;
    public final /* synthetic */ WidgetChannelsListAdapter.ItemChannelCategory this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelsListAdapter$ItemChannelCategory$onConfigure$1(WidgetChannelsListAdapter.ItemChannelCategory itemChannelCategory, ChannelListItem channelListItem) {
        super(1);
        this.this$0 = itemChannelCategory;
        this.$data = channelListItem;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke2(view);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view) {
        C12238m.checkNotNullParameter(view, "it");
        WidgetChannelsListAdapter.ItemChannelCategory.access$getAdapter$p(this.this$0).getOnSelectChannelOptions().invoke(((ChannelListItemCategory) this.$data).getChannel());
    }
}
