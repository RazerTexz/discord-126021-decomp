package com.discord.widgets.guilds.list;

import com.discord.stores.StoreGuildsSorted$Entry;
import com.discord.stores.StoreGuildsSorted$Entry$SingletonGuild;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGuildsListViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildsListViewModel$handleStoreState$2 extends o implements Function1<StoreGuildsSorted$Entry, Boolean> {
    public final /* synthetic */ WidgetGuildsListViewModel$StoreState $storeState;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildsListViewModel$handleStoreState$2(WidgetGuildsListViewModel$StoreState widgetGuildsListViewModel$StoreState) {
        super(1);
        this.$storeState = widgetGuildsListViewModel$StoreState;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(StoreGuildsSorted$Entry storeGuildsSorted$Entry) {
        return Boolean.valueOf(invoke2(storeGuildsSorted$Entry));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(StoreGuildsSorted$Entry storeGuildsSorted$Entry) {
        m.checkNotNullParameter(storeGuildsSorted$Entry, "it");
        return ((storeGuildsSorted$Entry instanceof StoreGuildsSorted$Entry$SingletonGuild) && this.$storeState.getLurkingGuildIds().contains(Long.valueOf(((StoreGuildsSorted$Entry$SingletonGuild) storeGuildsSorted$Entry).getGuild().getId()))) ? false : true;
    }
}
