package com.discord.widgets.channels;

import android.content.Context;
import b.a.d.AppToast;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.channels.WidgetChannelTopicViewModel$handleClosePrivateChannel$$inlined$let$lambda$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetChannelTopicViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelTopicViewModel8 extends Lambda implements Function1<Channel, Unit> {
    public final /* synthetic */ Context $context$inlined;
    public final /* synthetic */ WidgetChannelTopicViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelTopicViewModel8(WidgetChannelTopicViewModel widgetChannelTopicViewModel, Context context) {
        super(1);
        this.this$0 = widgetChannelTopicViewModel;
        this.$context$inlined = context;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
        invoke2(channel);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Channel channel) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        Integer numB = ChannelUtils.b(channel);
        if (numB != null) {
            AppToast.g(this.$context$inlined, numB.intValue(), 0, null, 12);
        }
    }
}
