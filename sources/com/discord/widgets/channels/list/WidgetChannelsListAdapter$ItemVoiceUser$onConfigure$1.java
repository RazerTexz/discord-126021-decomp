package com.discord.widgets.channels.list;

import android.view.View;
import com.discord.widgets.channels.list.items.ChannelListItem;
import com.discord.widgets.channels.list.items.ChannelListItemVoiceUser;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChannelsListAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelsListAdapter$ItemVoiceUser$onConfigure$1 extends o implements Function1<View, Unit> {
    public final /* synthetic */ ChannelListItem $data;
    public final /* synthetic */ WidgetChannelsListAdapter$ItemVoiceUser this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelsListAdapter$ItemVoiceUser$onConfigure$1(WidgetChannelsListAdapter$ItemVoiceUser widgetChannelsListAdapter$ItemVoiceUser, ChannelListItem channelListItem) {
        super(1);
        this.this$0 = widgetChannelsListAdapter$ItemVoiceUser;
        this.$data = channelListItem;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke2(view);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view) {
        m.checkNotNullParameter(view, "it");
        WidgetChannelsListAdapter$ItemVoiceUser.access$getAdapter$p(this.this$0).getOnSelectUserOptions().invoke(((ChannelListItemVoiceUser) this.$data).getUser(), ((ChannelListItemVoiceUser) this.$data).getChannel());
    }
}
