package com.discord.widgets.user.search;

import androidx.fragment.app.FragmentManager;
import com.discord.models.guild.Guild;
import com.discord.widgets.channels.list.WidgetChannelsListItemChannelActions;
import com.discord.widgets.channels.list.WidgetChannelsListItemChannelActions$Companion;
import com.discord.widgets.guilds.profile.WidgetGuildProfileSheet;
import com.discord.widgets.guilds.profile.WidgetGuildProfileSheet$Companion;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: WidgetGlobalSearch.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetGlobalSearch$configureUI$1 extends o implements Function3<Integer, Integer, WidgetGlobalSearchGuildsModel$Item, Unit> {
    public final /* synthetic */ WidgetGlobalSearch this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGlobalSearch$configureUI$1(WidgetGlobalSearch widgetGlobalSearch) {
        super(3);
        this.this$0 = widgetGlobalSearch;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(Integer num, Integer num2, WidgetGlobalSearchGuildsModel$Item widgetGlobalSearchGuildsModel$Item) {
        invoke(num.intValue(), num2.intValue(), widgetGlobalSearchGuildsModel$Item);
        return Unit.a;
    }

    public final void invoke(int i, int i2, WidgetGlobalSearchGuildsModel$Item widgetGlobalSearchGuildsModel$Item) {
        m.checkNotNullParameter(widgetGlobalSearchGuildsModel$Item, "data");
        if (i == 2) {
            WidgetChannelsListItemChannelActions$Companion widgetChannelsListItemChannelActions$Companion = WidgetChannelsListItemChannelActions.Companion;
            FragmentManager parentFragmentManager = this.this$0.getParentFragmentManager();
            m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            widgetChannelsListItemChannelActions$Companion.show(parentFragmentManager, widgetGlobalSearchGuildsModel$Item.getId());
            return;
        }
        if (i != 3) {
            return;
        }
        WidgetGuildProfileSheet$Companion widgetGuildProfileSheet$Companion = WidgetGuildProfileSheet.Companion;
        FragmentManager parentFragmentManager2 = this.this$0.getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager2, "parentFragmentManager");
        Guild guild = widgetGlobalSearchGuildsModel$Item.getGuild();
        WidgetGuildProfileSheet$Companion.show$default(widgetGuildProfileSheet$Companion, parentFragmentManager2, false, guild != null ? guild.getId() : 0L, 0L, false, 24, null);
    }
}
