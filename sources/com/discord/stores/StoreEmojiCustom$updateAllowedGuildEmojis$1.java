package com.discord.stores;

import com.discord.models.domain.emoji.ModelEmojiCustom;
import d0.z.d.m;
import d0.z.d.o;
import java.util.HashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: StoreEmojiCustom.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreEmojiCustom$updateAllowedGuildEmojis$1 extends o implements Function2<Long, ModelEmojiCustom, Unit> {
    public final /* synthetic */ Map $allowed;
    public final /* synthetic */ StoreEmojiCustom this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreEmojiCustom$updateAllowedGuildEmojis$1(StoreEmojiCustom storeEmojiCustom, Map map) {
        super(2);
        this.this$0 = storeEmojiCustom;
        this.$allowed = map;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Long l, ModelEmojiCustom modelEmojiCustom) {
        invoke(l.longValue(), modelEmojiCustom);
        return Unit.a;
    }

    public final void invoke(long j, ModelEmojiCustom modelEmojiCustom) {
        m.checkNotNullParameter(modelEmojiCustom, "emoji");
        Map map = this.$allowed;
        Long lValueOf = Long.valueOf(j);
        Object map2 = map.get(lValueOf);
        if (map2 == null) {
            map2 = new HashMap();
            map.put(lValueOf, map2);
        }
        Map map3 = (Map) map2;
        long id2 = modelEmojiCustom.getId();
        if (!m.areEqual(modelEmojiCustom, (ModelEmojiCustom) map3.get(Long.valueOf(id2)))) {
            map3.put(Long.valueOf(id2), modelEmojiCustom);
            this.this$0.markChanged();
        }
    }
}
