package com.discord.stores;

import d0.e0.c;
import d0.t.u;
import d0.z.d.a0;
import d0.z.d.o;
import java.util.Set;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreMediaFavorites.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreMediaFavorites$Favorite$Companion$AllTypes$2 extends o implements Function0<Set<? extends c<? extends StoreMediaFavorites$Favorite>>> {
    public static final StoreMediaFavorites$Favorite$Companion$AllTypes$2 INSTANCE = new StoreMediaFavorites$Favorite$Companion$AllTypes$2();

    public StoreMediaFavorites$Favorite$Companion$AllTypes$2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Set<? extends c<? extends StoreMediaFavorites$Favorite>> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Set<? extends c<? extends StoreMediaFavorites$Favorite>> invoke2() {
        return u.toSet(a0.getOrCreateKotlinClass(StoreMediaFavorites$Favorite.class).getSealedSubclasses());
    }
}
