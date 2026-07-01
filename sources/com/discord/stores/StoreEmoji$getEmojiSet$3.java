package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.utilities.Quad;
import java.util.List;
import java.util.Set;
import rx.functions.Func4;

/* JADX INFO: compiled from: StoreEmoji.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreEmoji$getEmojiSet$3<T1, T2, T3, T4, R> implements Func4<Boolean, Boolean, List<? extends Long>, Set<? extends StoreMediaFavorites$Favorite>, Quad<? extends Boolean, ? extends Boolean, ? extends List<? extends Long>, ? extends Set<? extends StoreMediaFavorites$Favorite>>> {
    public static final StoreEmoji$getEmojiSet$3 INSTANCE = new StoreEmoji$getEmojiSet$3();

    @Override // rx.functions.Func4
    public /* bridge */ /* synthetic */ Quad<? extends Boolean, ? extends Boolean, ? extends List<? extends Long>, ? extends Set<? extends StoreMediaFavorites$Favorite>> call(Boolean bool, Boolean bool2, List<? extends Long> list, Set<? extends StoreMediaFavorites$Favorite> set) {
        return call2(bool, bool2, (List<Long>) list, set);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Quad<Boolean, Boolean, List<Long>, Set<StoreMediaFavorites$Favorite>> call2(Boolean bool, Boolean bool2, List<Long> list, Set<? extends StoreMediaFavorites$Favorite> set) {
        return new Quad<>(bool, bool2, list, set);
    }
}
