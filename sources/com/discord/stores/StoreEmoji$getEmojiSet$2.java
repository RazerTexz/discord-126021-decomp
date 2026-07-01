package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.models.guild.Guild;
import d0.t.u;
import d0.z.d.m;
import j0.k.b;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: StoreEmoji.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreEmoji$getEmojiSet$2<T, R> implements b<LinkedHashMap<Long, Guild>, List<? extends Long>> {
    public static final StoreEmoji$getEmojiSet$2 INSTANCE = new StoreEmoji$getEmojiSet$2();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ List<? extends Long> call(LinkedHashMap<Long, Guild> linkedHashMap) {
        return call2(linkedHashMap);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final List<Long> call2(LinkedHashMap<Long, Guild> linkedHashMap) {
        Set<Long> setKeySet = linkedHashMap.keySet();
        m.checkNotNullExpressionValue(setKeySet, "it.keys");
        return u.toList(setKeySet);
    }
}
