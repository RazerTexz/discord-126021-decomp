package com.discord.widgets.guilds.list;

import com.discord.stores.StoreGuildsSorted;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.guilds.list.WidgetGuildsListViewModel$handleStoreState$$inlined$filterIsInstance$1, reason: use source file name */
/* JADX INFO: compiled from: _Sequences.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class _Sequences extends Lambda implements Function1<Object, Boolean> {
    public static final _Sequences INSTANCE = new _Sequences();

    public _Sequences() {
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
