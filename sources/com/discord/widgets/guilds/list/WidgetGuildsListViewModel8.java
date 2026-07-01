package com.discord.widgets.guilds.list;

import com.discord.stores.StoreGuildsSorted;
import com.discord.widgets.guilds.list.WidgetGuildsListViewModel;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.guilds.list.WidgetGuildsListViewModel$handleStoreState$lurkerGuildItems$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetGuildsListViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildsListViewModel8 extends Lambda implements Function1<StoreGuildsSorted.Entry.SingletonGuild, Boolean> {
    public final /* synthetic */ WidgetGuildsListViewModel.StoreState $storeState;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildsListViewModel8(WidgetGuildsListViewModel.StoreState storeState) {
        super(1);
        this.$storeState = storeState;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(StoreGuildsSorted.Entry.SingletonGuild singletonGuild) {
        return Boolean.valueOf(invoke2(singletonGuild));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(StoreGuildsSorted.Entry.SingletonGuild singletonGuild) {
        Intrinsics3.checkNotNullParameter(singletonGuild, "it");
        return this.$storeState.getLurkingGuildIds().contains(Long.valueOf(singletonGuild.getGuild().getId()));
    }
}
