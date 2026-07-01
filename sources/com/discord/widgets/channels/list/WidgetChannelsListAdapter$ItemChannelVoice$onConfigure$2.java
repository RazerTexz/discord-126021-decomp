package com.discord.widgets.channels.list;

import android.view.View;
import com.discord.api.channel.Channel;
import com.discord.widgets.channels.list.WidgetChannelsListAdapter;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChannelsListAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelsListAdapter$ItemChannelVoice$onConfigure$2 extends Lambda implements Function1<View, Unit> {
    public final /* synthetic */ Channel $channel;
    public final /* synthetic */ WidgetChannelsListAdapter.ItemChannelVoice this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelsListAdapter$ItemChannelVoice$onConfigure$2(WidgetChannelsListAdapter.ItemChannelVoice itemChannelVoice, Channel channel) {
        super(1);
        this.this$0 = itemChannelVoice;
        this.$channel = channel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke2(view);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "it");
        WidgetChannelsListAdapter.ItemChannelVoice.access$getAdapter$p(this.this$0).getOnSelectChannelOptions().invoke(this.$channel);
    }
}
