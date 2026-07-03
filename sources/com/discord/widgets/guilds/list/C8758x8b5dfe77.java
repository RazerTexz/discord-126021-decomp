package com.discord.widgets.guilds.list;

import com.discord.stores.StoreGuildsSorted;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: renamed from: com.discord.widgets.guilds.list.WidgetGuildsListViewModel$handleStoreState$$inlined$filterIsInstance$1 */
/* JADX INFO: compiled from: _Sequences.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C8758x8b5dfe77 extends AbstractC12240o implements Function1<Object, Boolean> {
    public static final C8758x8b5dfe77 INSTANCE = new C8758x8b5dfe77();

    public C8758x8b5dfe77() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(Object obj) {
        return Boolean.valueOf(invoke2(obj));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(Object obj) {
        return obj instanceof StoreGuildsSorted.Entry.SingletonGuild;
    }
}
