package com.discord.widgets.channels;

import android.content.Context;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p007b.p008a.p018d.C0876m;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: com.discord.widgets.channels.WidgetChannelTopicViewModel$handleClosePrivateChannel$$inlined$let$lambda$1 */
/* JADX INFO: compiled from: WidgetChannelTopicViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C7369xa83263b6 extends AbstractC12240o implements Function1<Channel, Unit> {
    public final /* synthetic */ Context $context$inlined;
    public final /* synthetic */ WidgetChannelTopicViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C7369xa83263b6(WidgetChannelTopicViewModel widgetChannelTopicViewModel, Context context) {
        super(1);
        this.this$0 = widgetChannelTopicViewModel;
        this.$context$inlined = context;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
        invoke2(channel);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Channel channel) {
        C12238m.checkNotNullParameter(channel, "channel");
        Integer numM7678b = ChannelUtils.m7678b(channel);
        if (numM7678b != null) {
            C0876m.m169g(this.$context$inlined, numM7678b.intValue(), 0, null, 12);
        }
    }
}
