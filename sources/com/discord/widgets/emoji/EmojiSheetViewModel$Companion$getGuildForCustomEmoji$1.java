package com.discord.widgets.emoji;

import androidx.core.app.NotificationCompat;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreEmojiCustom;
import com.discord.stores.StoreGuilds;
import com.discord.utilities.textprocessing.node.EmojiNode$EmojiIdAndType$Custom;
import java.util.Iterator;
import java.util.Map;
import java.util.Map$Entry;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: EmojiSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class EmojiSheetViewModel$Companion$getGuildForCustomEmoji$1<V> implements Callable<Guild> {
    public final /* synthetic */ EmojiNode$EmojiIdAndType$Custom $emoji;
    public final /* synthetic */ StoreEmojiCustom $storeEmojiCustom;
    public final /* synthetic */ StoreGuilds $storeGuilds;

    public EmojiSheetViewModel$Companion$getGuildForCustomEmoji$1(StoreEmojiCustom storeEmojiCustom, EmojiNode$EmojiIdAndType$Custom emojiNode$EmojiIdAndType$Custom, StoreGuilds storeGuilds) {
        this.$storeEmojiCustom = storeEmojiCustom;
        this.$emoji = emojiNode$EmojiIdAndType$Custom;
        this.$storeGuilds = storeGuilds;
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Guild call() {
        return call();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.concurrent.Callable
    public final Guild call() {
        Object next;
        Map$Entry map$Entry;
        Iterator<T> it = this.$storeEmojiCustom.getAllGuildEmoji().entrySet().iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            map$Entry = (Map$Entry) next;
            ((Number) map$Entry.getKey()).longValue();
        } while (!((Map) map$Entry.getValue()).keySet().contains(Long.valueOf(this.$emoji.getId())));
        Map$Entry map$Entry2 = (Map$Entry) next;
        if (map$Entry2 == null) {
            return null;
        }
        long jLongValue = ((Number) map$Entry2.getKey()).longValue();
        return this.$storeGuilds.getGuilds().get(Long.valueOf(jLongValue));
    }
}
