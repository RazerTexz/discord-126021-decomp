package com.discord.widgets.user.search;

import com.discord.models.guild.Guild;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGlobalSearchModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetGlobalSearchModel$Companion$create$filteredResults$2 extends o implements Function1<Guild, WidgetGlobalSearchModel$ItemGuild> {
    public final /* synthetic */ String $sanitizedFilter;
    public final /* synthetic */ WidgetGlobalSearchModel$Companion$create$3 $toItemGuild$3;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGlobalSearchModel$Companion$create$filteredResults$2(WidgetGlobalSearchModel$Companion$create$3 widgetGlobalSearchModel$Companion$create$3, String str) {
        super(1);
        this.$toItemGuild$3 = widgetGlobalSearchModel$Companion$create$3;
        this.$sanitizedFilter = str;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetGlobalSearchModel$ItemGuild invoke(Guild guild) {
        return invoke2(guild);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetGlobalSearchModel$ItemGuild invoke2(Guild guild) {
        m.checkNotNullParameter(guild, "it");
        return this.$toItemGuild$3.invoke2(guild, this.$sanitizedFilter);
    }
}
