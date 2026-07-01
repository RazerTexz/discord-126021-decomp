package com.discord.stores;

import d0.e0.c;
import java.util.Set;
import kotlin.Lazy;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: StoreMediaFavorites.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreMediaFavorites$Favorite$Companion {
    private StoreMediaFavorites$Favorite$Companion() {
    }

    public final Set<c<? extends StoreMediaFavorites$Favorite>> getAllTypes() {
        Lazy lazyAccess$getAllTypes$cp = StoreMediaFavorites$Favorite.access$getAllTypes$cp();
        StoreMediaFavorites$Favorite$Companion storeMediaFavorites$Favorite$Companion = StoreMediaFavorites$Favorite.Companion;
        return (Set) lazyAccess$getAllTypes$cp.getValue();
    }

    public final Set<c<? extends StoreMediaFavorites$Favorite>> getEmojiTypes() {
        return StoreMediaFavorites$Favorite.access$getEmojiTypes$cp();
    }

    public /* synthetic */ StoreMediaFavorites$Favorite$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
