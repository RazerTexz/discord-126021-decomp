package com.discord.widgets.user.search;

import android.annotation.SuppressLint;
import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.models.guild.Guild;
import com.discord.models.user.User;
import com.discord.utilities.search.SearchUtils;
import com.discord.widgets.user.search.WidgetGlobalSearchModel;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Locale;
import java.util.Objects;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: WidgetGlobalSearchModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetGlobalSearchModel$Companion$create$4 extends Lambda implements Function2<Channel, String, WidgetGlobalSearchModel.ItemDataPayload> {
    public final /* synthetic */ WidgetGlobalSearchModel.ChannelContext $channelContext;
    public final /* synthetic */ WidgetGlobalSearchModel.SearchContext $searchContext;
    public final /* synthetic */ WidgetGlobalSearchModel$Companion$create$2 $toItemUser$2;

    /* JADX INFO: renamed from: com.discord.widgets.user.search.WidgetGlobalSearchModel$Companion$create$4$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetGlobalSearchModel.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<WidgetGlobalSearchModel.MatchedResult> {
        public final /* synthetic */ String $channelFilter;
        public final /* synthetic */ Channel $this_toItemChannel;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Channel channel, String str) {
            super(0);
            this.$this_toItemChannel = channel;
            this.$channelFilter = str;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @SuppressLint({"DefaultLocale"})
        public final WidgetGlobalSearchModel.MatchedResult invoke() {
            String name;
            Guild guild = (Guild) outline.c(this.$this_toItemChannel, WidgetGlobalSearchModel$Companion$create$4.this.$channelContext.getGuilds());
            if (guild == null || (name = guild.getName()) == null) {
                name = "";
            }
            Channel channel = WidgetGlobalSearchModel$Companion$create$4.this.$channelContext.getChannels().get(Long.valueOf(this.$this_toItemChannel.getParentId()));
            String strC = channel != null ? ChannelUtils.c(channel) : "";
            SearchUtils searchUtils = SearchUtils.INSTANCE;
            String str = this.$channelFilter;
            Locale locale = Locale.ROOT;
            Intrinsics3.checkNotNullExpressionValue(locale, "Locale.ROOT");
            Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
            String lowerCase = str.toLowerCase(locale);
            Intrinsics3.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
            String str2 = ChannelUtils.c(this.$this_toItemChannel) + ' ' + strC + ' ' + name;
            Intrinsics3.checkNotNullExpressionValue(locale, "Locale.ROOT");
            Objects.requireNonNull(str2, "null cannot be cast to non-null type java.lang.String");
            String lowerCase2 = str2.toLowerCase(locale);
            Intrinsics3.checkNotNullExpressionValue(lowerCase2, "(this as java.lang.String).toLowerCase(locale)");
            if (searchUtils.fuzzyMatch(lowerCase, lowerCase2)) {
                return new WidgetGlobalSearchModel.MatchedResult(ChannelUtils.c(this.$this_toItemChannel), -1, this.$channelFilter.length());
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
        Intrinsics3.checkNotNullParameter(channel, "$this$toItemChannel");
        Intrinsics3.checkNotNullParameter(str, "channelFilter");
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(channel, str);
        if (channel.getType() == 1) {
            User userA = ChannelUtils.a(channel);
            if (userA != null) {
                return this.$toItemUser$2.invoke(userA, str, channel);
            }
            return null;
        }
        WidgetGlobalSearchModel.MatchedResult matchedResult = WidgetGlobalSearchModel.INSTANCE.toMatchedResult(ChannelUtils.c(channel), str);
        if (matchedResult == null) {
            matchedResult = anonymousClass1.invoke();
        }
        WidgetGlobalSearchModel.MatchedResult matchedResult2 = matchedResult;
        if (matchedResult2 == null) {
            return null;
        }
        Channel channel2 = this.$channelContext.getChannels().get(Long.valueOf(channel.getParentId()));
        Guild guild = (Guild) outline.c(channel, this.$channelContext.getGuilds());
        Integer num = (Integer) outline.d(channel, this.$searchContext.getMentionCounts());
        return new WidgetGlobalSearchModel.ItemChannel(matchedResult2, channel, channel2, guild, num != null ? num.intValue() : 0, this.$channelContext.getUnreadChannelIds().contains(Long.valueOf(channel.getId())));
    }
}
