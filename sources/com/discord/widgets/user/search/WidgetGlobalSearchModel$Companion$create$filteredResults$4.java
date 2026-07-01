package com.discord.widgets.user.search;

import com.discord.api.channel.Channel;
import com.discord.widgets.user.search.WidgetGlobalSearchModel;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGlobalSearchModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetGlobalSearchModel$Companion$create$filteredResults$4 extends Lambda implements Function1<Channel, WidgetGlobalSearchModel.ItemDataPayload> {
    public final /* synthetic */ String $sanitizedFilter;
    public final /* synthetic */ WidgetGlobalSearchModel$Companion$create$4 $toItemChannel$4;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGlobalSearchModel$Companion$create$filteredResults$4(WidgetGlobalSearchModel$Companion$create$4 widgetGlobalSearchModel$Companion$create$4, String str) {
        super(1);
        this.$toItemChannel$4 = widgetGlobalSearchModel$Companion$create$4;
        this.$sanitizedFilter = str;
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetGlobalSearchModel.ItemDataPayload invoke(Channel channel) {
        Intrinsics3.checkNotNullParameter(channel, "it");
        return this.$toItemChannel$4.invoke(channel, this.$sanitizedFilter);
    }
}
