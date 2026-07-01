package com.discord.widgets.chat.input.sticker;

import androidx.core.app.NotificationCompat;
import com.discord.models.guild.Guild;
import d0.z.d.m;
import j0.k.b;
import java.util.LinkedHashMap;
import java.util.Map$Entry;

/* JADX INFO: compiled from: StickerPickerViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StickerPickerViewModel$Companion$observeStoreState$1$1<T, R> implements b<LinkedHashMap<Long, Guild>, LinkedHashMap<Long, Guild>> {
    public final /* synthetic */ Guild $currentGuild;

    public StickerPickerViewModel$Companion$observeStoreState$1$1(Guild guild) {
        this.$currentGuild = guild;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ LinkedHashMap<Long, Guild> call(LinkedHashMap<Long, Guild> linkedHashMap) {
        return call2(linkedHashMap);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final LinkedHashMap<Long, Guild> call2(LinkedHashMap<Long, Guild> linkedHashMap) {
        LinkedHashMap<Long, Guild> linkedHashMap2 = new LinkedHashMap<>();
        Guild guild = this.$currentGuild;
        if (guild != null) {
            linkedHashMap2.put(Long.valueOf(guild.getId()), this.$currentGuild);
        }
        m.checkNotNullExpressionValue(linkedHashMap, "allGuilds");
        LinkedHashMap linkedHashMap3 = new LinkedHashMap();
        for (Map$Entry<Long, Guild> map$Entry : linkedHashMap.entrySet()) {
            Long key = map$Entry.getKey();
            Guild guild2 = this.$currentGuild;
            if (!m.areEqual(key, guild2 != null ? Long.valueOf(guild2.getId()) : null)) {
                linkedHashMap3.put(map$Entry.getKey(), map$Entry.getValue());
            }
        }
        linkedHashMap2.putAll(linkedHashMap3);
        return linkedHashMap2;
    }
}
