package com.discord.widgets.user.search;

import android.annotation.SuppressLint;
import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.models.guild.Guild;
import com.discord.utilities.search.SearchUtils;
import d0.z.d.m;
import d0.z.d.o;
import java.util.Locale;
import java.util.Objects;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetGlobalSearchModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetGlobalSearchModel$Companion$create$4$1 extends o implements Function0<WidgetGlobalSearchModel$MatchedResult> {
    public final /* synthetic */ String $channelFilter;
    public final /* synthetic */ Channel $this_toItemChannel;
    public final /* synthetic */ WidgetGlobalSearchModel$Companion$create$4 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGlobalSearchModel$Companion$create$4$1(WidgetGlobalSearchModel$Companion$create$4 widgetGlobalSearchModel$Companion$create$4, Channel channel, String str) {
        super(0);
        this.this$0 = widgetGlobalSearchModel$Companion$create$4;
        this.$this_toItemChannel = channel;
        this.$channelFilter = str;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ WidgetGlobalSearchModel$MatchedResult invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    @SuppressLint({"DefaultLocale"})
    public final WidgetGlobalSearchModel$MatchedResult invoke() {
        String name;
        Guild guild = (Guild) a.c(this.$this_toItemChannel, this.this$0.$channelContext.getGuilds());
        if (guild == null || (name = guild.getName()) == null) {
            name = "";
        }
        Channel channel = this.this$0.$channelContext.getChannels().get(Long.valueOf(this.$this_toItemChannel.getParentId()));
        String strC = channel != null ? ChannelUtils.c(channel) : "";
        SearchUtils searchUtils = SearchUtils.INSTANCE;
        String str = this.$channelFilter;
        Locale locale = Locale.ROOT;
        m.checkNotNullExpressionValue(locale, "Locale.ROOT");
        Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = str.toLowerCase(locale);
        m.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
        String str2 = ChannelUtils.c(this.$this_toItemChannel) + ' ' + strC + ' ' + name;
        m.checkNotNullExpressionValue(locale, "Locale.ROOT");
        Objects.requireNonNull(str2, "null cannot be cast to non-null type java.lang.String");
        String lowerCase2 = str2.toLowerCase(locale);
        m.checkNotNullExpressionValue(lowerCase2, "(this as java.lang.String).toLowerCase(locale)");
        if (searchUtils.fuzzyMatch(lowerCase, lowerCase2)) {
            return new WidgetGlobalSearchModel$MatchedResult(ChannelUtils.c(this.$this_toItemChannel), -1, this.$channelFilter.length());
        }
        return null;
    }
}
