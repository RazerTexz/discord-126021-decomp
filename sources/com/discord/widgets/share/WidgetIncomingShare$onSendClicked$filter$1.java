package com.discord.widgets.share;

import com.discord.api.channel.Channel;
import com.discord.widgets.user.search.WidgetGlobalSearchModel;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: compiled from: WidgetIncomingShare.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetIncomingShare$onSendClicked$filter$1 extends AbstractC12240o implements Function1<Channel, Boolean> {
    public final /* synthetic */ WidgetGlobalSearchModel.ItemDataPayload $receiver;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetIncomingShare$onSendClicked$filter$1(WidgetGlobalSearchModel.ItemDataPayload itemDataPayload) {
        super(1);
        this.$receiver = itemDataPayload;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(Channel channel) {
        return Boolean.valueOf(invoke2(channel));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(Channel channel) {
        return channel != null && channel.getId() == ((WidgetGlobalSearchModel.ItemChannel) this.$receiver).getChannel().getId();
    }
}
