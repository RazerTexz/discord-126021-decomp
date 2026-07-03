package com.discord.widgets.user.search;

import com.discord.models.guild.Guild;
import com.discord.widgets.user.search.WidgetGlobalSearchModel;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function2;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetGlobalSearchModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetGlobalSearchModel$Companion$create$3 extends AbstractC12240o implements Function2<Guild, String, WidgetGlobalSearchModel.ItemGuild> {
    public final /* synthetic */ WidgetGlobalSearchModel.ChannelContext $channelContext;
    public final /* synthetic */ WidgetGlobalSearchModel.SearchContext $searchContext;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGlobalSearchModel$Companion$create$3(WidgetGlobalSearchModel.ChannelContext channelContext, WidgetGlobalSearchModel.SearchContext searchContext) {
        super(2);
        this.$channelContext = channelContext;
        this.$searchContext = searchContext;
    }

    @Override // kotlin.jvm.functions.Function2
    public final WidgetGlobalSearchModel.ItemGuild invoke(Guild guild, String str) {
        int i;
        boolean z2;
        C12238m.checkNotNullParameter(guild, "$this$toItemGuild");
        C12238m.checkNotNullParameter(str, "guildFilter");
        WidgetGlobalSearchModel.MatchedResult matchedResult = WidgetGlobalSearchModel.INSTANCE.toMatchedResult(guild.getName(), str);
        if (matchedResult == null) {
            return null;
        }
        List list = (List) C1643a.m847e(guild, this.$channelContext.getGuildToChannels());
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
        return new WidgetGlobalSearchModel.ItemGuild(matchedResult, guild, null, i, z2, 4, null);
    }
}
