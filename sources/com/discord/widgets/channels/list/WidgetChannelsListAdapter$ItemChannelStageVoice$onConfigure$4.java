package com.discord.widgets.channels.list;

import android.view.View;
import com.discord.api.channel.Channel;
import com.discord.widgets.channels.list.WidgetChannelsListAdapter;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetChannelsListAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelsListAdapter$ItemChannelStageVoice$onConfigure$4 extends AbstractC12240o implements Function1<View, Unit> {
    public final /* synthetic */ Channel $channel;
    public final /* synthetic */ WidgetChannelsListAdapter.ItemChannelStageVoice this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelsListAdapter$ItemChannelStageVoice$onConfigure$4(WidgetChannelsListAdapter.ItemChannelStageVoice itemChannelStageVoice, Channel channel) {
        super(1);
        this.this$0 = itemChannelStageVoice;
        this.$channel = channel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke2(view);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view) {
        C12238m.checkNotNullParameter(view, "it");
        WidgetChannelsListAdapter.ItemChannelStageVoice.access$getAdapter$p(this.this$0).getOnSelectChannelOptions().invoke(this.$channel);
    }
}
