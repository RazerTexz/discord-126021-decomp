package com.discord.widgets.user.search;

import com.discord.stores.StoreNavigation$PanelAction;
import com.discord.stores.StoreStream;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.channel.ChannelSelector;
import com.discord.widgets.tabs.NavigationTab;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: WidgetGlobalSearch.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetGlobalSearch$configureUI$2 extends o implements Function3<Integer, Integer, WidgetGlobalSearchGuildsModel$Item, Unit> {
    public final /* synthetic */ WidgetGlobalSearchModel $model;
    public final /* synthetic */ WidgetGlobalSearch this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGlobalSearch$configureUI$2(WidgetGlobalSearch widgetGlobalSearch, WidgetGlobalSearchModel widgetGlobalSearchModel) {
        super(3);
        this.this$0 = widgetGlobalSearch;
        this.$model = widgetGlobalSearchModel;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(Integer num, Integer num2, WidgetGlobalSearchGuildsModel$Item widgetGlobalSearchGuildsModel$Item) {
        invoke(num.intValue(), num2.intValue(), widgetGlobalSearchGuildsModel$Item);
        return Unit.a;
    }

    public final void invoke(int i, int i2, WidgetGlobalSearchGuildsModel$Item widgetGlobalSearchGuildsModel$Item) {
        m.checkNotNullParameter(widgetGlobalSearchGuildsModel$Item, "selected");
        if (i == 2) {
            ChannelSelector.selectChannel$default(ChannelSelector.Companion.getInstance(), 0L, widgetGlobalSearchGuildsModel$Item.getId(), null, null, 12, null);
        } else if (i == 3) {
            StoreStream.Companion.getGuildSelected().set(widgetGlobalSearchGuildsModel$Item.getId());
        }
        WidgetGlobalSearchModel$ItemDataPayload widgetGlobalSearchModel$ItemDataPayloadAccess$toWidgetGlobalSearchModelItem = WidgetGlobalSearch$Companion.access$toWidgetGlobalSearchModelItem(WidgetGlobalSearch.Companion, widgetGlobalSearchGuildsModel$Item);
        if (widgetGlobalSearchModel$ItemDataPayloadAccess$toWidgetGlobalSearchModelItem != null) {
            AnalyticsTracker.INSTANCE.quickSwitcherSelect(this.$model, widgetGlobalSearchModel$ItemDataPayloadAccess$toWidgetGlobalSearchModelItem, i2);
        }
        WidgetGlobalSearch.access$onSelected(this.this$0, NavigationTab.HOME, StoreNavigation$PanelAction.OPEN);
    }
}
