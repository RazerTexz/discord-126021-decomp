package com.discord.widgets.user.search;

import com.discord.api.channel.Channel;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetGlobalSearchModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetGlobalSearchModel$Companion$create$results$1 extends AbstractC12240o implements Function1<WidgetGlobalSearchModel.ItemDataPayload, Boolean> {
    public final /* synthetic */ Channel $lastChannel;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGlobalSearchModel$Companion$create$results$1(Channel channel) {
        super(1);
        this.$lastChannel = channel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(WidgetGlobalSearchModel.ItemDataPayload itemDataPayload) {
        return Boolean.valueOf(invoke2(itemDataPayload));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(WidgetGlobalSearchModel.ItemDataPayload itemDataPayload) {
        C12238m.checkNotNullParameter(itemDataPayload, "it");
        long id2 = this.$lastChannel.getId();
        Channel channel = itemDataPayload.getChannel();
        return channel != null && id2 == channel.getId();
    }
}
