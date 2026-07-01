package com.discord.stores;

import d0.z.d.o;
import java.util.Set;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreMediaFavorites.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreMediaFavorites$observeFavorites$1 extends o implements Function0<Set<? extends StoreMediaFavorites$Favorite>> {
    public final /* synthetic */ Set $types;
    public final /* synthetic */ StoreMediaFavorites this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreMediaFavorites$observeFavorites$1(StoreMediaFavorites storeMediaFavorites, Set set) {
        super(0);
        this.this$0 = storeMediaFavorites;
        this.$types = set;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Set<? extends StoreMediaFavorites$Favorite> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Set<? extends StoreMediaFavorites$Favorite> invoke2() {
        return this.this$0.getFavorites(this.$types);
    }
}
