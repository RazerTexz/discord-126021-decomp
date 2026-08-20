package com.discord.widgets.user.search;

import android.annotation.SuppressLint;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.models.guild.Guild;
import com.discord.models.user.User;
import com.discord.utilities.search.SearchUtils;
import java.util.Locale;
import java.util.Objects;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetGlobalSearchModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetGlobalSearchModel$Companion$create$4 extends AbstractC12240o implements Function2<Channel, String, WidgetGlobalSearchModel.ItemDataPayload> {
    public final /* synthetic */ WidgetGlobalSearchModel.ChannelContext $channelContext;
    public final /* synthetic */ WidgetGlobalSearchModel.SearchContext $searchContext;
    public final /* synthetic */ WidgetGlobalSearchModel$Companion$create$2 $toItemUser$2;

    /* JADX INFO: renamed from: com.discord.widgets.user.search.WidgetGlobalSearchModel$Companion$create$4$1 */
    /* JADX INFO: compiled from: WidgetGlobalSearchModel.kt */
    public static final class C103301 extends AbstractC12240o implements Function0<WidgetGlobalSearchModel.MatchedResult> {
        public final /* synthetic */ String $channelFilter;
        public final /* synthetic */ Channel $this_toItemChannel;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C103301(Channel channel, String str) {
            super(0);
            this.$this_toItemChannel = channel;
            this.$channelFilter = str;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @SuppressLint({"DefaultLocale"})
        public final WidgetGlobalSearchModel.MatchedResult invoke() {
            String name;
            Guild guild = (Guild) C1643a.m843c(this.$this_toItemChannel, WidgetGlobalSearchModel$Companion$create$4.this.$channelContext.getGuilds());
            if (guild == null || (name = guild.getName()) == null) {
                name = "";
            }
            Channel channel = WidgetGlobalSearchModel$Companion$create$4.this.$channelContext.getChannels().get(Long.valueOf(this.$this_toItemChannel.getParentId()));
            String strM7679c = channel != null ? ChannelUtils.m7679c(channel) : "";
            SearchUtils searchUtils = SearchUtils.INSTANCE;
            String str = this.$channelFilter;
            Locale locale = Locale.ROOT;
            C12238m.checkNotNullExpressionValue(locale, "Locale.ROOT");
            Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
            String lowerCase = str.toLowerCase(locale);
            C12238m.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
            String str2 = ChannelUtils.m7679c(this.$this_toItemChannel) + ' ' + strM7679c + ' ' + name;
            C12238m.checkNotNullExpressionValue(locale, "Locale.ROOT");
            Objects.requireNonNull(str2, "null cannot be cast to non-null type java.lang.String");
            String lowerCase2 = str2.toLowerCase(locale);
            C12238m.checkNotNullExpressionValue(lowerCase2, "(this as java.lang.String).toLowerCase(locale)");
            if (searchUtils.fuzzyMatch(lowerCase, lowerCase2)) {
                return new WidgetGlobalSearchModel.MatchedResult(ChannelUtils.m7679c(this.$this_toItemChannel), -1, this.$channelFilter.length());
            }
            return null;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGlobalSearchModel$Companion$create$4(WidgetGlobalSearchModel.ChannelContext channelContext, WidgetGlobalSearchModel$Companion$create$2 widgetGlobalSearchModel$Companion$create$2, WidgetGlobalSearchModel.SearchContext searchContext) {
        super(2);
        this.$channelContext = channelContext;
        this.$toItemUser$2 = widgetGlobalSearchModel$Companion$create$2;
        this.$searchContext = searchContext;
    }

    @Override // kotlin.jvm.functions.Function2
    public final WidgetGlobalSearchModel.ItemDataPayload invoke(Channel channel, String str) {
        C12238m.checkNotNullParameter(channel, "$this$toItemChannel");
        C12238m.checkNotNullParameter(str, "channelFilter");
        C103301 c103301 = new C103301(channel, str);
        if (channel.getType() == 1) {
            User userM7677a = ChannelUtils.m7677a(channel);
            if (userM7677a != null) {
                return this.$toItemUser$2.invoke(userM7677a, str, channel);
            }
            return null;
        }
        WidgetGlobalSearchModel.MatchedResult matchedResult = WidgetGlobalSearchModel.INSTANCE.toMatchedResult(ChannelUtils.m7679c(channel), str);
        if (matchedResult == null) {
            matchedResult = c103301.invoke();
        }
        WidgetGlobalSearchModel.MatchedResult matchedResult2 = matchedResult;
        if (matchedResult2 == null) {
            return null;
        }
        Channel channel2 = this.$channelContext.getChannels().get(Long.valueOf(channel.getParentId()));
        Guild guild = (Guild) C1643a.m843c(channel, this.$channelContext.getGuilds());
        Integer num = (Integer) C1643a.m845d(channel, this.$searchContext.getMentionCounts());
        return new WidgetGlobalSearchModel.ItemChannel(matchedResult2, channel, channel2, guild, num != null ? num.intValue() : 0, this.$channelContext.getUnreadChannelIds().contains(Long.valueOf(channel.getId())));
    }
}
