package com.discord.widgets.user.search;

import b.d.b.a.a;
import com.discord.models.guild.Guild;
import d0.z.d.m;
import d0.z.d.o;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: WidgetGlobalSearchModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetGlobalSearchModel$Companion$create$3 extends o implements Function2<Guild, String, WidgetGlobalSearchModel$ItemGuild> {
    public final /* synthetic */ WidgetGlobalSearchModel$ChannelContext $channelContext;
    public final /* synthetic */ WidgetGlobalSearchModel$SearchContext $searchContext;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGlobalSearchModel$Companion$create$3(WidgetGlobalSearchModel$ChannelContext widgetGlobalSearchModel$ChannelContext, WidgetGlobalSearchModel$SearchContext widgetGlobalSearchModel$SearchContext) {
        super(2);
        this.$channelContext = widgetGlobalSearchModel$ChannelContext;
        this.$searchContext = widgetGlobalSearchModel$SearchContext;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ WidgetGlobalSearchModel$ItemGuild invoke(Guild guild, String str) {
        return invoke2(guild, str);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetGlobalSearchModel$ItemGuild invoke2(Guild guild, String str) {
        int i;
        boolean z2;
        m.checkNotNullParameter(guild, "$this$toItemGuild");
        m.checkNotNullParameter(str, "guildFilter");
        WidgetGlobalSearchModel$MatchedResult matchedResult = WidgetGlobalSearchModel.Companion.toMatchedResult(guild.getName(), str);
        if (matchedResult == null) {
            return null;
        }
        List list = (List) a.e(guild, this.$channelContext.getGuildToChannels());
        if (list != null) {
            Iterator it = list.iterator();
            int iIntValue = 0;
            while (it.hasNext()) {
                Integer num = this.$searchContext.getMentionCounts().get(Long.valueOf(((Number) it.next()).longValue()));
                iIntValue += num != null ? num.intValue() : 0;
            }
            i = iIntValue;
        } else {
            i = 0;
        }
        if (list == null || list.isEmpty()) {
            z2 = false;
        } else {
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                if (this.$channelContext.getUnreadChannelIds().contains(Long.valueOf(((Number) it2.next()).longValue()))) {
                    z2 = true;
                }
            }
            z2 = false;
        }
        return new WidgetGlobalSearchModel$ItemGuild(matchedResult, guild, null, i, z2, 4, null);
    }
}
