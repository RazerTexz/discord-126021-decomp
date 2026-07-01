package com.discord.widgets.guilds.list;

import com.discord.stores.StoreGuildsSorted$Entry$SingletonGuild;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGuildsListViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildsListViewModel$handleStoreState$lurkerGuildItems$1 extends o implements Function1<StoreGuildsSorted$Entry$SingletonGuild, Boolean> {
    public final /* synthetic */ WidgetGuildsListViewModel$StoreState $storeState;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildsListViewModel$handleStoreState$lurkerGuildItems$1(WidgetGuildsListViewModel$StoreState widgetGuildsListViewModel$StoreState) {
        super(1);
        this.$storeState = widgetGuildsListViewModel$StoreState;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(StoreGuildsSorted$Entry$SingletonGuild storeGuildsSorted$Entry$SingletonGuild) {
        return Boolean.valueOf(invoke2(storeGuildsSorted$Entry$SingletonGuild));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(StoreGuildsSorted$Entry$SingletonGuild storeGuildsSorted$Entry$SingletonGuild) {
        m.checkNotNullParameter(storeGuildsSorted$Entry$SingletonGuild, "it");
        return this.$storeState.getLurkingGuildIds().contains(Long.valueOf(storeGuildsSorted$Entry$SingletonGuild.getGuild().getId()));
    }
}
