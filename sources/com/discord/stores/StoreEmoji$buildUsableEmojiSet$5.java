package com.discord.stores;

import android.annotation.SuppressLint;
import com.discord.models.domain.emoji.ModelEmojiCustom;
import com.discord.utilities.collections.ShallowPartitionMap;
import d0.t.u;
import d0.z.d.m;
import d0.z.d.o;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreEmoji.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreEmoji$buildUsableEmojiSet$5 extends o implements Function1<Long, Unit> {
    public final /* synthetic */ Map $allCustomEmojis;
    public final /* synthetic */ StoreEmoji$EmojiContext $emojiContext;
    public final /* synthetic */ ShallowPartitionMap $emojiIdsMap;
    public final /* synthetic */ ShallowPartitionMap $emojiNameCounts;
    public final /* synthetic */ boolean $includeUnavailableEmojis;
    public final /* synthetic */ boolean $includeUnusableEmojis;
    public final /* synthetic */ StoreEmoji$buildUsableEmojiSet$1 $isExternalEmoji$1;
    public final /* synthetic */ StoreEmoji$buildUsableEmojiSet$2 $isExternalEmojiRestricted$2;
    public final /* synthetic */ boolean $isMePremium;
    public final /* synthetic */ HashMap $usableCustomEmojis;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreEmoji$buildUsableEmojiSet$5(Map map, StoreEmoji$buildUsableEmojiSet$1 storeEmoji$buildUsableEmojiSet$1, StoreEmoji$buildUsableEmojiSet$2 storeEmoji$buildUsableEmojiSet$2, boolean z2, StoreEmoji$EmojiContext storeEmoji$EmojiContext, boolean z3, boolean z4, ShallowPartitionMap shallowPartitionMap, ShallowPartitionMap shallowPartitionMap2, HashMap map2) {
        super(1);
        this.$allCustomEmojis = map;
        this.$isExternalEmoji$1 = storeEmoji$buildUsableEmojiSet$1;
        this.$isExternalEmojiRestricted$2 = storeEmoji$buildUsableEmojiSet$2;
        this.$includeUnavailableEmojis = z2;
        this.$emojiContext = storeEmoji$EmojiContext;
        this.$isMePremium = z3;
        this.$includeUnusableEmojis = z4;
        this.$emojiNameCounts = shallowPartitionMap;
        this.$emojiIdsMap = shallowPartitionMap2;
        this.$usableCustomEmojis = map2;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Long l) {
        invoke(l.longValue());
        return Unit.a;
    }

    @SuppressLint({"DefaultLocale"})
    public final void invoke(long j) {
        ModelEmojiCustom modelEmojiCustom;
        Map map = (Map) this.$allCustomEmojis.get(Long.valueOf(j));
        if (map != null) {
            boolean zInvoke = this.$isExternalEmoji$1.invoke(j);
            if (this.$isExternalEmojiRestricted$2.invoke(zInvoke)) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            Iterator it = map.values().iterator();
            while (true) {
                boolean z2 = true;
                if (!it.hasNext()) {
                    break;
                }
                ModelEmojiCustom modelEmojiCustom2 = (ModelEmojiCustom) it.next();
                if (this.$includeUnavailableEmojis || modelEmojiCustom2.isAvailable()) {
                    boolean z3 = modelEmojiCustom2.isManaged() && ((this.$emojiContext instanceof StoreEmoji$EmojiContext$Global) ^ true);
                    if (!this.$isMePremium && (modelEmojiCustom2.isAnimated() || (zInvoke && !z3))) {
                        z2 = false;
                    }
                    if (this.$includeUnusableEmojis || z2) {
                        Integer num = (Integer) this.$emojiNameCounts.get(modelEmojiCustom2.getName());
                        if (num == null && z2) {
                            modelEmojiCustom = modelEmojiCustom2;
                        } else {
                            modelEmojiCustom = new ModelEmojiCustom(modelEmojiCustom2, num != null ? num.intValue() : 0, z2);
                        }
                        arrayList.add(modelEmojiCustom);
                        StoreEmoji$buildUsableEmojiSet$4 storeEmoji$buildUsableEmojiSet$4 = StoreEmoji$buildUsableEmojiSet$4.INSTANCE;
                        ShallowPartitionMap shallowPartitionMap = this.$emojiNameCounts;
                        String name = modelEmojiCustom2.getName();
                        m.checkNotNullExpressionValue(name, "emoji.name");
                        storeEmoji$buildUsableEmojiSet$4.invoke((Map<String, Integer>) shallowPartitionMap, name);
                        ShallowPartitionMap shallowPartitionMap2 = this.$emojiIdsMap;
                        String uniqueId = modelEmojiCustom2.getUniqueId();
                        m.checkNotNullExpressionValue(uniqueId, "emoji.uniqueId");
                        shallowPartitionMap2.put(uniqueId, modelEmojiCustom);
                    }
                }
            }
            if (!arrayList.isEmpty()) {
                this.$usableCustomEmojis.put(Long.valueOf(j), u.sortedWith(arrayList, new StoreEmoji$buildUsableEmojiSet$5$processGuildEmojis$$inlined$sortedByDescending$1()));
            }
        }
    }
}
