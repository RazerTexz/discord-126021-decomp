package com.discord.widgets.user.search;

import com.discord.api.channel.Channel;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGlobalSearchModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetGlobalSearchModel$Companion$create$filteredResults$7 extends o implements Function1<Channel, WidgetGlobalSearchModel$ItemDataPayload> {
    public final /* synthetic */ String $sanitizedFilter;
    public final /* synthetic */ WidgetGlobalSearchModel$Companion$create$4 $toItemChannel$4;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGlobalSearchModel$Companion$create$filteredResults$7(WidgetGlobalSearchModel$Companion$create$4 widgetGlobalSearchModel$Companion$create$4, String str) {
        super(1);
        this.$toItemChannel$4 = widgetGlobalSearchModel$Companion$create$4;
        this.$sanitizedFilter = str;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetGlobalSearchModel$ItemDataPayload invoke(Channel channel) {
        return invoke2(channel);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetGlobalSearchModel$ItemDataPayload invoke2(Channel channel) {
        m.checkNotNullParameter(channel, "it");
        return this.$toItemChannel$4.invoke2(channel, this.$sanitizedFilter);
    }
}
