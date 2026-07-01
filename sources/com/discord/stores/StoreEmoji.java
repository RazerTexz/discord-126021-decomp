package com.discord.stores;

import android.content.Context;
import com.adjust.sdk.Constants;
import com.discord.models.domain.Model;
import com.discord.models.domain.Model$JsonReader;
import com.discord.models.domain.emoji.Emoji;
import com.discord.models.domain.emoji.EmojiCategory;
import com.discord.models.domain.emoji.EmojiSet;
import com.discord.models.domain.emoji.ModelEmojiCustom;
import com.discord.models.domain.emoji.ModelEmojiUnicode;
import com.discord.models.domain.emoji.ModelEmojiUnicode$Bundle;
import com.discord.utilities.collections.ShallowPartitionMap;
import com.discord.utilities.collections.ShallowPartitionMap$Companion;
import com.discord.utilities.frecency.FrecencyTracker;
import com.discord.utilities.media.MediaFrecencyTracker;
import com.discord.utilities.persister.Persister;
import com.discord.utilities.textprocessing.Rules$EmojiDataProvider;
import d0.f0.q;
import d0.t.n;
import d0.t.u;
import d0.z.d.m;
import j0.l.e.k;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map$Entry;
import java.util.Set;
import java.util.regex.Pattern;
import rx.Observable;

/* JADX INFO: compiled from: StoreEmoji.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreEmoji implements Rules$EmojiDataProvider {
    public static final StoreEmoji$Companion Companion = new StoreEmoji$Companion(null);
    private static final String[] DEFAULT_FREQUENT_EMOJIS = {"bread", "fork_and_knife", "yum", "weary", "tired_face", "poop", "thumbsup", "100"};
    private static final int MAX_FREQUENTLY_USED_EMOJIS = 40;
    private final StoreEmojiCustom customEmojiStore;
    private final MediaFrecencyTracker frecency;
    private final Persister<MediaFrecencyTracker> frecencyCache;
    private final StoreMediaFavorites mediaFavoritesStore;
    private final StorePermissions permissionsStore;
    private final StoreGuildsSorted sortedGuildsStore;
    private Map<String, ? extends ModelEmojiUnicode> unicodeEmojiSurrogateMap;
    private Map<EmojiCategory, ? extends List<? extends Emoji>> unicodeEmojis;
    private Map<String, ? extends ModelEmojiUnicode> unicodeEmojisNamesMap;
    private Pattern unicodeEmojisPattern;
    private final StoreUser userStore;

    public StoreEmoji(StoreEmojiCustom storeEmojiCustom, StoreUser storeUser, StorePermissions storePermissions, StoreGuildsSorted storeGuildsSorted, StoreMediaFavorites storeMediaFavorites) {
        m.checkNotNullParameter(storeEmojiCustom, "customEmojiStore");
        m.checkNotNullParameter(storeUser, "userStore");
        m.checkNotNullParameter(storePermissions, "permissionsStore");
        m.checkNotNullParameter(storeGuildsSorted, "sortedGuildsStore");
        m.checkNotNullParameter(storeMediaFavorites, "mediaFavoritesStore");
        this.customEmojiStore = storeEmojiCustom;
        this.userStore = storeUser;
        this.permissionsStore = storePermissions;
        this.sortedGuildsStore = storeGuildsSorted;
        this.mediaFavoritesStore = storeMediaFavorites;
        Persister<MediaFrecencyTracker> persister = new Persister<>("EMOJI_HISTORY_V4", new MediaFrecencyTracker(0, 0, 3, null));
        this.frecencyCache = persister;
        this.frecency = persister.get();
    }

    public static final /* synthetic */ EmojiSet access$buildUsableEmojiSet(StoreEmoji storeEmoji, Map map, StoreEmoji$EmojiContext storeEmoji$EmojiContext, List list, boolean z2, boolean z3, boolean z4, boolean z5, Set set) {
        return storeEmoji.buildUsableEmojiSet(map, storeEmoji$EmojiContext, list, z2, z3, z4, z5, set);
    }

    public static final /* synthetic */ StoreEmojiCustom access$getCustomEmojiStore$p(StoreEmoji storeEmoji) {
        return storeEmoji.customEmojiStore;
    }

    public static final /* synthetic */ String[] access$getDEFAULT_FREQUENT_EMOJIS$cp() {
        return DEFAULT_FREQUENT_EMOJIS;
    }

    private final EmojiSet buildUsableEmojiSet(Map<Long, ? extends Map<Long, ? extends ModelEmojiCustom>> allCustomEmojis, StoreEmoji$EmojiContext emojiContext, List<Long> sortedGuildIds, boolean isMePremium, boolean includeUnusableEmojis, boolean includeUnavailableEmojis, boolean hasExternalEmojiPermission, Set<? extends StoreMediaFavorites$Favorite> favorites) {
        StoreEmoji$buildUsableEmojiSet$1 storeEmoji$buildUsableEmojiSet$1 = new StoreEmoji$buildUsableEmojiSet$1(emojiContext);
        StoreEmoji$buildUsableEmojiSet$2 storeEmoji$buildUsableEmojiSet$2 = new StoreEmoji$buildUsableEmojiSet$2(hasExternalEmojiPermission, emojiContext);
        Set<Long> setKeySet = allCustomEmojis.keySet();
        ArrayList arrayList = new ArrayList();
        for (Object obj : setKeySet) {
            if (!sortedGuildIds.contains(Long.valueOf(((Number) obj).longValue()))) {
                arrayList.add(obj);
            }
        }
        int size = sortedGuildIds.size() + arrayList.size();
        Iterator it = n.listOf((Object[]) new List[]{sortedGuildIds, arrayList}).iterator();
        int i = 0;
        while (it.hasNext()) {
            Iterator it2 = ((List) it.next()).iterator();
            int size2 = 0;
            while (it2.hasNext()) {
                long jLongValue = ((Number) it2.next()).longValue();
                Map<Long, ? extends ModelEmojiCustom> map = allCustomEmojis.get(Long.valueOf(jLongValue));
                size2 += (map == null || storeEmoji$buildUsableEmojiSet$2.invoke(storeEmoji$buildUsableEmojiSet$1.invoke(jLongValue))) ? 0 : map.size();
            }
            i += size2;
        }
        Map<String, ? extends ModelEmojiUnicode> map2 = this.unicodeEmojisNamesMap;
        if (map2 == null) {
            m.throwUninitializedPropertyAccessException("unicodeEmojisNamesMap");
        }
        int size3 = map2.size();
        Map<EmojiCategory, ? extends List<? extends Emoji>> map3 = this.unicodeEmojis;
        if (map3 == null) {
            m.throwUninitializedPropertyAccessException("unicodeEmojis");
        }
        Iterator<T> it3 = map3.values().iterator();
        int size4 = 0;
        while (it3.hasNext()) {
            size4 += ((List) it3.next()).size();
        }
        ShallowPartitionMap$Companion shallowPartitionMap$Companion = ShallowPartitionMap.Companion;
        ShallowPartitionMap shallowPartitionMapCreate$default = ShallowPartitionMap$Companion.create$default(shallowPartitionMap$Companion, i + size3, 0, 0, null, 14, null);
        HashMap map4 = new HashMap(size);
        ShallowPartitionMap shallowPartitionMapCreate$default2 = ShallowPartitionMap$Companion.create$default(shallowPartitionMap$Companion, i + size4, 0, 0, null, 14, null);
        if (!(emojiContext instanceof StoreEmoji$EmojiContext$GuildProfile)) {
            Map<EmojiCategory, ? extends List<? extends Emoji>> map5 = this.unicodeEmojis;
            if (map5 == null) {
                m.throwUninitializedPropertyAccessException("unicodeEmojis");
            }
            Iterator<T> it4 = map5.values().iterator();
            while (it4.hasNext()) {
                for (Emoji emoji : (List) it4.next()) {
                    String uniqueId = emoji.getUniqueId();
                    m.checkNotNullExpressionValue(uniqueId, "emoji.uniqueId");
                    shallowPartitionMapCreate$default2.put(uniqueId, emoji);
                }
            }
        }
        StoreEmoji$buildUsableEmojiSet$4 storeEmoji$buildUsableEmojiSet$4 = StoreEmoji$buildUsableEmojiSet$4.INSTANCE;
        ShallowPartitionMap shallowPartitionMap = shallowPartitionMapCreate$default2;
        StoreEmoji$buildUsableEmojiSet$5 storeEmoji$buildUsableEmojiSet$5 = new StoreEmoji$buildUsableEmojiSet$5(allCustomEmojis, storeEmoji$buildUsableEmojiSet$1, storeEmoji$buildUsableEmojiSet$2, includeUnavailableEmojis, emojiContext, isMePremium, includeUnusableEmojis, shallowPartitionMapCreate$default, shallowPartitionMap, map4);
        Map<String, ? extends ModelEmojiUnicode> map6 = this.unicodeEmojisNamesMap;
        if (map6 == null) {
            m.throwUninitializedPropertyAccessException("unicodeEmojisNamesMap");
        }
        Iterator<T> it5 = map6.keySet().iterator();
        while (it5.hasNext()) {
            StoreEmoji$buildUsableEmojiSet$4.INSTANCE.invoke((Map<String, Integer>) shallowPartitionMapCreate$default, (String) it5.next());
        }
        long guildId = emojiContext instanceof StoreEmoji$EmojiContext$Chat ? ((StoreEmoji$EmojiContext$Chat) emojiContext).getGuildId() : 0L;
        storeEmoji$buildUsableEmojiSet$5.invoke(guildId);
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : sortedGuildIds) {
            if (((Number) obj2).longValue() != guildId) {
                arrayList2.add(obj2);
            }
        }
        Iterator it6 = arrayList2.iterator();
        while (it6.hasNext()) {
            storeEmoji$buildUsableEmojiSet$5.invoke(((Number) it6.next()).longValue());
        }
        Iterator it7 = arrayList.iterator();
        while (it7.hasNext()) {
            storeEmoji$buildUsableEmojiSet$5.invoke(((Number) it7.next()).longValue());
        }
        ArrayList arrayList3 = new ArrayList();
        for (Object obj3 : favorites) {
            if (obj3 instanceof StoreMediaFavorites$FavoriteEmoji) {
                arrayList3.add(obj3);
            }
        }
        ArrayList arrayList4 = new ArrayList();
        Iterator it8 = arrayList3.iterator();
        while (it8.hasNext()) {
            ShallowPartitionMap shallowPartitionMap2 = shallowPartitionMap;
            Emoji emoji2 = (Emoji) shallowPartitionMap2.get(((StoreMediaFavorites$FavoriteEmoji) it8.next()).getEmojiUniqueId());
            if (emoji2 != null) {
                arrayList4.add(emoji2);
            }
            shallowPartitionMap = shallowPartitionMap2;
        }
        Map<String, ? extends Emoji> map7 = shallowPartitionMap;
        Set set = u.toSet(arrayList4);
        Map<EmojiCategory, ? extends List<? extends Emoji>> map8 = this.unicodeEmojis;
        if (map8 == null) {
            m.throwUninitializedPropertyAccessException("unicodeEmojis");
        }
        return new EmojiSet(map8, map4, map7, getFrequentlyUsedEmojis(map7), set);
    }

    private final Pattern compileSurrogatesPattern() {
        Map<String, ? extends ModelEmojiUnicode> map = this.unicodeEmojiSurrogateMap;
        if (map == null) {
            m.throwUninitializedPropertyAccessException("unicodeEmojiSurrogateMap");
        }
        Pattern patternCompile = Pattern.compile(u.joinToString$default(u.sortedWith(map.keySet(), new StoreEmoji$compileSurrogatesPattern$$inlined$sortedBy$1()), "|", null, null, 0, null, StoreEmoji$compileSurrogatesPattern$emojiSurrogatesPattern$2.INSTANCE, 30, null));
        m.checkNotNullExpressionValue(patternCompile, "Pattern.compile(emojiSurrogatesPattern)");
        return patternCompile;
    }

    public static /* synthetic */ Observable getEmojiSet$default(StoreEmoji storeEmoji, long j, long j2, boolean z2, boolean z3, int i, Object obj) {
        return storeEmoji.getEmojiSet(j, j2, (i & 4) != 0 ? false : z2, (i & 8) != 0 ? false : z3);
    }

    private final List<Emoji> getFrequentlyUsedEmojis(Map<String, ? extends Emoji> emojiIdsMap) {
        Collection sortedKeys$default = FrecencyTracker.getSortedKeys$default(this.frecency, 0L, 1, null);
        ArrayList arrayList = new ArrayList();
        Iterator it = sortedKeys$default.iterator();
        while (it.hasNext()) {
            Emoji emoji = emojiIdsMap.get((String) it.next());
            if (emoji != null) {
                arrayList.add(emoji);
            }
        }
        List<Emoji> listTake = u.take(arrayList, 40);
        if (listTake.size() >= 40) {
            return listTake;
        }
        String[] strArr = DEFAULT_FREQUENT_EMOJIS;
        ArrayList arrayList2 = new ArrayList();
        for (String str : strArr) {
            Map<String, ? extends ModelEmojiUnicode> map = this.unicodeEmojisNamesMap;
            if (map == null) {
                m.throwUninitializedPropertyAccessException("unicodeEmojisNamesMap");
            }
            ModelEmojiUnicode modelEmojiUnicode = map.get(str);
            if (modelEmojiUnicode != null) {
                arrayList2.add(modelEmojiUnicode);
            }
        }
        return u.distinct(q.toList(d0.f0.n.flattenSequenceOfIterable(d0.f0.n.sequenceOf(listTake, u.take(arrayList2, 40 - listTake.size())))));
    }

    private final void handleLoadedUnicodeEmojis(ModelEmojiUnicode$Bundle unicodeEmojisBundle) {
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        HashMap map3 = new HashMap();
        StoreEmoji$handleLoadedUnicodeEmojis$1 storeEmoji$handleLoadedUnicodeEmojis$1 = new StoreEmoji$handleLoadedUnicodeEmojis$1(map3, map2);
        Map<EmojiCategory, List<ModelEmojiUnicode>> emojis = unicodeEmojisBundle.getEmojis();
        m.checkNotNullExpressionValue(emojis, "unicodeEmojisBundle.emojis");
        for (Map$Entry<EmojiCategory, List<ModelEmojiUnicode>> map$Entry : emojis.entrySet()) {
            EmojiCategory key = map$Entry.getKey();
            List<ModelEmojiUnicode> value = map$Entry.getValue();
            m.checkNotNullExpressionValue(key, "category");
            m.checkNotNullExpressionValue(value, "categoryEmojis");
            map.put(key, value);
            for (ModelEmojiUnicode modelEmojiUnicode : value) {
                m.checkNotNullExpressionValue(modelEmojiUnicode, "unicodeEmoji");
                storeEmoji$handleLoadedUnicodeEmojis$1.invoke2(modelEmojiUnicode);
                List<ModelEmojiUnicode> asDiverse = modelEmojiUnicode.getAsDiverse();
                m.checkNotNullExpressionValue(asDiverse, "unicodeEmoji\n                .asDiverse");
                for (ModelEmojiUnicode modelEmojiUnicode2 : asDiverse) {
                    m.checkNotNullExpressionValue(modelEmojiUnicode2, "diverseEmoji");
                    storeEmoji$handleLoadedUnicodeEmojis$1.invoke2(modelEmojiUnicode2);
                }
            }
        }
        this.unicodeEmojis = map;
        this.unicodeEmojisNamesMap = map2;
        this.unicodeEmojiSurrogateMap = map3;
        this.unicodeEmojisPattern = compileSurrogatesPattern();
    }

    private final ModelEmojiUnicode$Bundle loadUnicodeEmojisFromDisk(Context context) throws IOException {
        Model model = new Model$JsonReader(new InputStreamReader(context.getAssets().open("data/emojis.json"), Constants.ENCODING)).parse(new ModelEmojiUnicode$Bundle());
        m.checkNotNullExpressionValue(model, "jsonReader.parse(ModelEmojiUnicode.Bundle())");
        return (ModelEmojiUnicode$Bundle) model;
    }

    @StoreThread
    public final ModelEmojiCustom getCustomEmojiInternal(long emojiId) {
        Iterator<Map$Entry<Long, Map<Long, ModelEmojiCustom>>> it = this.customEmojiStore.getAllGuildEmojiInternal().entrySet().iterator();
        while (it.hasNext()) {
            ModelEmojiCustom modelEmojiCustom = it.next().getValue().get(Long.valueOf(emojiId));
            if (modelEmojiCustom != null) {
                return modelEmojiCustom;
            }
        }
        return null;
    }

    public final Observable<EmojiSet> getEmojiSet(long guildId, long channelId, boolean includeUnusableEmojis, boolean includeUnavailableEmojis) {
        return getEmojiSet(new StoreEmoji$EmojiContext$Chat(guildId, channelId), includeUnusableEmojis, includeUnavailableEmojis);
    }

    @Override // com.discord.utilities.textprocessing.Rules$EmojiDataProvider
    public Map<String, ModelEmojiUnicode> getUnicodeEmojiSurrogateMap() {
        Map map = this.unicodeEmojiSurrogateMap;
        if (map == null) {
            m.throwUninitializedPropertyAccessException("unicodeEmojiSurrogateMap");
        }
        return map;
    }

    @Override // com.discord.utilities.textprocessing.Rules$EmojiDataProvider
    public Map<String, ModelEmojiUnicode> getUnicodeEmojisNamesMap() {
        Map map = this.unicodeEmojisNamesMap;
        if (map == null) {
            m.throwUninitializedPropertyAccessException("unicodeEmojisNamesMap");
        }
        return map;
    }

    @Override // com.discord.utilities.textprocessing.Rules$EmojiDataProvider
    public Pattern getUnicodeEmojisPattern() {
        Pattern pattern = this.unicodeEmojisPattern;
        if (pattern == null) {
            m.throwUninitializedPropertyAccessException("unicodeEmojisPattern");
        }
        return pattern;
    }

    @StoreThread
    public final void handlePreLogout() {
        Persister.clear$default(this.frecencyCache, false, 1, null);
    }

    public final void initBlocking(Context context) {
        m.checkNotNullParameter(context, "context");
        handleLoadedUnicodeEmojis(loadUnicodeEmojisFromDisk(context));
    }

    public final void onEmojiUsed(Emoji emoji) {
        m.checkNotNullParameter(emoji, "emoji");
        String uniqueId = emoji.getUniqueId();
        m.checkNotNullExpressionValue(uniqueId, "emoji.uniqueId");
        onEmojiUsed(uniqueId);
    }

    public final void onEmojiUsed(String emojiKey) {
        m.checkNotNullParameter(emojiKey, "emojiKey");
        FrecencyTracker.track$default(this.frecency, emojiKey, 0L, 2, null);
        Persister.set$default(this.frecencyCache, this.frecency, false, 2, null);
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0033  */
    /* JADX WARN: Code duplicated, block: B:7:0x0027  */
    /* JADX WARN: Code duplicated, block: B:9:0x002b  */
    public final Observable<EmojiSet> getEmojiSet(StoreEmoji$EmojiContext emojiContext, boolean includeUnusableEmojis, boolean includeUnavailableEmojis) {
        k kVar;
        Observable observableG;
        m.checkNotNullParameter(emojiContext, "emojiContext");
        if (emojiContext instanceof StoreEmoji$EmojiContext$Chat) {
            StoreEmoji$EmojiContext$Chat storeEmoji$EmojiContext$Chat = (StoreEmoji$EmojiContext$Chat) emojiContext;
            if (storeEmoji$EmojiContext$Chat.getGuildId() != 0) {
                observableG = this.permissionsStore.observePermissionsForChannel(storeEmoji$EmojiContext$Chat.getChannelId()).G(StoreEmoji$getEmojiSet$hasExternalEmojiPermissionObservable$1.INSTANCE);
            } else {
                if (emojiContext instanceof StoreEmoji$EmojiContext$Guild) {
                    kVar = new k(Boolean.FALSE);
                } else {
                    kVar = new k(Boolean.TRUE);
                }
                observableG = kVar;
            }
        } else {
            if (emojiContext instanceof StoreEmoji$EmojiContext$Guild) {
                kVar = new k(Boolean.FALSE);
            } else {
                kVar = new k(Boolean.TRUE);
            }
            observableG = kVar;
        }
        Observable<EmojiSet> observableY = Observable.h(StoreUser.observeMe$default(this.userStore, false, 1, null).G(StoreEmoji$getEmojiSet$1.INSTANCE), observableG, this.sortedGuildsStore.observeOrderedGuilds().G(StoreEmoji$getEmojiSet$2.INSTANCE), this.mediaFavoritesStore.observeFavorites(StoreMediaFavorites$Favorite.Companion.getEmojiTypes()), StoreEmoji$getEmojiSet$3.INSTANCE).r().Y(new StoreEmoji$getEmojiSet$4(this, emojiContext, includeUnavailableEmojis, includeUnusableEmojis));
        m.checkNotNullExpressionValue(observableY, "Observable\n        .comb…              }\n        }");
        return observableY;
    }
}
