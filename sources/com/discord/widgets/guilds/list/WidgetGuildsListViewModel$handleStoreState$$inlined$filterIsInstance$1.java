package com.discord.widgets.guilds.list;

import com.discord.stores.StoreGuildsSorted$Entry$SingletonGuild;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: _Sequences.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildsListViewModel$handleStoreState$$inlined$filterIsInstance$1 extends o implements Function1<Object, Boolean> {
    public static final WidgetGuildsListViewModel$handleStoreState$$inlined$filterIsInstance$1 INSTANCE = new WidgetGuildsListViewModel$handleStoreState$$inlined$filterIsInstance$1();

    public WidgetGuildsListViewModel$handleStoreState$$inlined$filterIsInstance$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(Object obj) {
        return Boolean.valueOf(invoke2(obj));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(Object obj) {
        return obj instanceof StoreGuildsSorted$Entry$SingletonGuild;
    }
}
