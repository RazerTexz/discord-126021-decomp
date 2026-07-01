package com.discord.widgets.user.search;

import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGlobalSearchModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetGlobalSearchModel$Companion$create$filteredResults$3 extends o implements Function1<Channel, Boolean> {
    public static final WidgetGlobalSearchModel$Companion$create$filteredResults$3 INSTANCE = new WidgetGlobalSearchModel$Companion$create$filteredResults$3();

    public WidgetGlobalSearchModel$Companion$create$filteredResults$3() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(Channel channel) {
        return Boolean.valueOf(invoke2(channel));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(Channel channel) {
        m.checkNotNullParameter(channel, "it");
        return ChannelUtils.v(channel);
    }
}
