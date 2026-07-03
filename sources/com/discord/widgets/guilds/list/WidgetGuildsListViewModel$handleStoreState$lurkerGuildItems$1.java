package com.discord.widgets.guilds.list;

import com.discord.stores.StoreGuildsSorted;
import com.discord.widgets.guilds.list.WidgetGuildsListViewModel;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetGuildsListViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildsListViewModel$handleStoreState$lurkerGuildItems$1 extends AbstractC12240o implements Function1<StoreGuildsSorted.Entry.SingletonGuild, Boolean> {
    public final /* synthetic */ WidgetGuildsListViewModel.StoreState $storeState;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildsListViewModel$handleStoreState$lurkerGuildItems$1(WidgetGuildsListViewModel.StoreState storeState) {
        super(1);
        this.$storeState = storeState;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(StoreGuildsSorted.Entry.SingletonGuild singletonGuild) {
        return Boolean.valueOf(invoke2(singletonGuild));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(StoreGuildsSorted.Entry.SingletonGuild singletonGuild) {
        C12238m.checkNotNullParameter(singletonGuild, "it");
        return this.$storeState.getLurkingGuildIds().contains(Long.valueOf(singletonGuild.getGuild().getId()));
    }
}
