package com.discord.widgets.user.search;

import com.discord.api.channel.Channel;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGlobalSearchModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetGlobalSearchModel$Companion$create$results$1 extends o implements Function1<WidgetGlobalSearchModel$ItemDataPayload, Boolean> {
    public final /* synthetic */ Channel $lastChannel;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGlobalSearchModel$Companion$create$results$1(Channel channel) {
        super(1);
        this.$lastChannel = channel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(WidgetGlobalSearchModel$ItemDataPayload widgetGlobalSearchModel$ItemDataPayload) {
        return Boolean.valueOf(invoke2(widgetGlobalSearchModel$ItemDataPayload));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(WidgetGlobalSearchModel$ItemDataPayload widgetGlobalSearchModel$ItemDataPayload) {
        m.checkNotNullParameter(widgetGlobalSearchModel$ItemDataPayload, "it");
        long id2 = this.$lastChannel.getId();
        Channel channel = widgetGlobalSearchModel$ItemDataPayload.getChannel();
        return channel != null && id2 == channel.getId();
    }
}
