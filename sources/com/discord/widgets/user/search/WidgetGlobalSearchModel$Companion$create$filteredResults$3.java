package com.discord.widgets.user.search;

import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetGlobalSearchModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetGlobalSearchModel$Companion$create$filteredResults$3 extends AbstractC12240o implements Function1<Channel, Boolean> {
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
        C12238m.checkNotNullParameter(channel, "it");
        return ChannelUtils.m7698v(channel);
    }
}
