package com.discord.stores;

import d0.e0.c;
import d0.g;
import d0.t.n0;
import d0.z.d.a0;
import java.util.Set;
import kotlin.Lazy;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: StoreMediaFavorites.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class StoreMediaFavorites$Favorite {
    public static final StoreMediaFavorites$Favorite$Companion Companion = new StoreMediaFavorites$Favorite$Companion(null);
    private static final Lazy AllTypes$delegate = g.lazy(StoreMediaFavorites$Favorite$Companion$AllTypes$2.INSTANCE);
    private static final Set<c<? extends StoreMediaFavorites$Favorite>> EmojiTypes = n0.setOf((Object[]) new c[]{a0.getOrCreateKotlinClass(StoreMediaFavorites$Favorite$FavCustomEmoji.class), a0.getOrCreateKotlinClass(StoreMediaFavorites$Favorite$FavUnicodeEmoji.class)});

    private StoreMediaFavorites$Favorite() {
    }

    public static final /* synthetic */ Lazy access$getAllTypes$cp() {
        return AllTypes$delegate;
    }

    public static final /* synthetic */ Set access$getEmojiTypes$cp() {
        return EmojiTypes;
    }

    public /* synthetic */ StoreMediaFavorites$Favorite(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
