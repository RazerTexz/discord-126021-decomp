package com.discord.stores;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreMediaFavorites.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreMediaFavorites$addFavorite$1 extends o implements Function0<Unit> {
    public final /* synthetic */ StoreMediaFavorites$Favorite $favorite;
    public final /* synthetic */ StoreMediaFavorites this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreMediaFavorites$addFavorite$1(StoreMediaFavorites storeMediaFavorites, StoreMediaFavorites$Favorite storeMediaFavorites$Favorite) {
        super(0);
        this.this$0 = storeMediaFavorites;
        this.$favorite = storeMediaFavorites$Favorite;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        if (StoreMediaFavorites.access$getFavorites$p(this.this$0).add(this.$favorite)) {
            this.this$0.markChanged();
        }
    }
}
