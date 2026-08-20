package com.discord.widgets.user.search;

import com.discord.api.channel.Channel;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetGlobalSearchModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetGlobalSearchModel$Companion$create$filteredResults$7 extends AbstractC12240o implements Function1<Channel, WidgetGlobalSearchModel.ItemDataPayload> {
    public final /* synthetic */ String $sanitizedFilter;
    public final /* synthetic */ WidgetGlobalSearchModel$Companion$create$4 $toItemChannel$4;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGlobalSearchModel$Companion$create$filteredResults$7(WidgetGlobalSearchModel$Companion$create$4 widgetGlobalSearchModel$Companion$create$4, String str) {
        super(1);
        this.$toItemChannel$4 = widgetGlobalSearchModel$Companion$create$4;
        this.$sanitizedFilter = str;
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetGlobalSearchModel.ItemDataPayload invoke(Channel channel) {
        C12238m.checkNotNullParameter(channel, "it");
        return this.$toItemChannel$4.invoke(channel, this.$sanitizedFilter);
    }
}
