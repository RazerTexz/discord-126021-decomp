package com.discord.stores;

import java.util.Set;
import kotlin.jvm.functions.Function0;
import p507d0.p513e0.InterfaceC11230c;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;

/* JADX INFO: compiled from: StoreMediaFavorites.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreMediaFavorites$Favorite$Companion$AllTypes$2 extends AbstractC12240o implements Function0<Set<? extends InterfaceC11230c<? extends StoreMediaFavorites.Favorite>>> {
    public static final StoreMediaFavorites$Favorite$Companion$AllTypes$2 INSTANCE = new StoreMediaFavorites$Favorite$Companion$AllTypes$2();

    public StoreMediaFavorites$Favorite$Companion$AllTypes$2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final Set<? extends InterfaceC11230c<? extends StoreMediaFavorites.Favorite>> invoke() {
        return C12163u.toSet(C12216a0.getOrCreateKotlinClass(StoreMediaFavorites.Favorite.class).getSealedSubclasses());
    }
}
