package com.discord.stores;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import com.adjust.sdk.Constants;
import com.discord.api.permission.Permission;
import com.discord.models.domain.Model;
import com.discord.models.domain.emoji.Emoji;
import com.discord.models.domain.emoji.EmojiCategory;
import com.discord.models.domain.emoji.EmojiSet;
import com.discord.models.domain.emoji.ModelEmojiCustom;
import com.discord.models.domain.emoji.ModelEmojiUnicode;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.utilities.Quad;
import com.discord.utilities.collections.ShallowPartitionMap;
import com.discord.utilities.frecency.FrecencyTracker;
import com.discord.utilities.media.MediaFrecencyTracker;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.persister.Persister;
import com.discord.utilities.textprocessing.Rules;
import com.discord.utilities.user.UserUtils;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.regex.Pattern;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p001a0.p002a.p003a.C0002b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p578f0.C12075n;
import p507d0.p578f0.C12078q;
import p507d0.p579g0.C12103t;
import p507d0.p579g0.C12106w;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12163u;
import p507d0.p582u.C12169a;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p637j0.p642l.p647e.C12721k;
import p658rx.Observable;
import p658rx.functions.Func4;

/* JADX INFO: compiled from: StoreEmoji.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreEmoji implements Rules.EmojiDataProvider {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
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

    /* JADX INFO: compiled from: StoreEmoji.kt */
    public static final class Companion {
        private Companion() {
        }

        public final String[] getDEFAULT_FREQUENT_EMOJIS() {
            return StoreEmoji.DEFAULT_FREQUENT_EMOJIS;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: StoreEmoji.kt */
    public static abstract class EmojiContext {

        /* JADX INFO: compiled from: StoreEmoji.kt */
        public static final /* data */ class Chat extends EmojiContext {
            private final long channelId;
            private final long guildId;

            public Chat(long j, long j2) {
                super(null);
                this.guildId = j;
                this.channelId = j2;
            }

            public static /* synthetic */ Chat copy$default(Chat chat, long j, long j2, int i, Object obj) {
                if ((i & 1) != 0) {
                    j = chat.guildId;
                }
                if ((i & 2) != 0) {
                    j2 = chat.channelId;
                }
                return chat.copy(j, j2);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final long getGuildId() {
                return this.guildId;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final long getChannelId() {
                return this.channelId;
            }

            public final Chat copy(long guildId, long channelId) {
                return new Chat(guildId, channelId);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Chat)) {
                    return false;
                }
                Chat chat = (Chat) other;
                return this.guildId == chat.guildId && this.channelId == chat.channelId;
            }

            public final long getChannelId() {
                return this.channelId;
            }

            public final long getGuildId() {
                return this.guildId;
            }

            public int hashCode() {
                return C0002b.m3a(this.channelId) + (C0002b.m3a(this.guildId) * 31);
            }

            public String toString() {
                StringBuilder sbM833U = C1643a.m833U("Chat(guildId=");
                sbM833U.append(this.guildId);
                sbM833U.append(", channelId=");
                return C1643a.m815C(sbM833U, this.channelId, ")");
            }
        }

        /* JADX INFO: compiled from: StoreEmoji.kt */
        public static final class Global extends EmojiContext {
            public static final Global INSTANCE = new Global();

            private Global() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: StoreEmoji.kt */
        public static final /* data */ class Guild extends EmojiContext {
            private final long guildId;

            public Guild(long j) {
                super(null);
                this.guildId = j;
            }

            public static /* synthetic */ Guild copy$default(Guild guild, long j, int i, Object obj) {
                if ((i & 1) != 0) {
                    j = guild.guildId;
                }
                return guild.copy(j);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final long getGuildId() {
                return this.guildId;
            }

            public final Guild copy(long guildId) {
                return new Guild(guildId);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Guild) && this.guildId == ((Guild) other).guildId;
                }
                return true;
            }

            public final long getGuildId() {
                return this.guildId;
            }

            public int hashCode() {
                return C0002b.m3a(this.guildId);
            }

            public String toString() {
                return C1643a.m815C(C1643a.m833U("Guild(guildId="), this.guildId, ")");
            }
        }

        /* JADX INFO: compiled from: StoreEmoji.kt */
        public static final /* data */ class GuildProfile extends EmojiContext {
            private final long guildId;

            public GuildProfile(long j) {
                super(null);
                this.guildId = j;
            }

            public static /* synthetic */ GuildProfile copy$default(GuildProfile guildProfile, long j, int i, Object obj) {
                if ((i & 1) != 0) {
                    j = guildProfile.guildId;
                }
                return guildProfile.copy(j);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final long getGuildId() {
                return this.guildId;
            }

            public final GuildProfile copy(long guildId) {
                return new GuildProfile(guildId);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof GuildProfile) && this.guildId == ((GuildProfile) other).guildId;
                }
                return true;
            }

            public final long getGuildId() {
                return this.guildId;
            }

            public int hashCode() {
                return C0002b.m3a(this.guildId);
            }

            public String toString() {
                return C1643a.m815C(C1643a.m833U("GuildProfile(guildId="), this.guildId, ")");
            }
        }

        private EmojiContext() {
        }

        public /* synthetic */ EmojiContext(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreEmoji$buildUsableEmojiSet$1 */
    /* JADX INFO: compiled from: StoreEmoji.kt */
    public static final class C58881 extends AbstractC12240o implements Function1<Long, Boolean> {
        public final /* synthetic */ EmojiContext $emojiContext;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C58881(EmojiContext emojiContext) {
            super(1);
            this.$emojiContext = emojiContext;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(Long l) {
            return Boolean.valueOf(invoke(l.longValue()));
        }

        public final boolean invoke(long j) {
            EmojiContext emojiContext = this.$emojiContext;
            if (emojiContext instanceof EmojiContext.Chat) {
                if (((EmojiContext.Chat) emojiContext).getGuildId() == j) {
                    return false;
                }
            } else if (!(emojiContext instanceof EmojiContext.Global)) {
                if (emojiContext instanceof EmojiContext.GuildProfile) {
                    if (((EmojiContext.GuildProfile) emojiContext).getGuildId() == j) {
                        return false;
                    }
                } else {
                    if (!(emojiContext instanceof EmojiContext.Guild)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    if (((EmojiContext.Guild) emojiContext).getGuildId() == j) {
                        return false;
                    }
                }
            }
            return true;
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreEmoji$buildUsableEmojiSet$2 */
    /* JADX INFO: compiled from: StoreEmoji.kt */
    public static final class C58892 extends AbstractC12240o implements Function1<Boolean, Boolean> {
        public final /* synthetic */ EmojiContext $emojiContext;
        public final /* synthetic */ boolean $hasExternalEmojiPermission;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C58892(boolean z2, EmojiContext emojiContext) {
            super(1);
            this.$hasExternalEmojiPermission = z2;
            this.$emojiContext = emojiContext;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
            return Boolean.valueOf(invoke(bool.booleanValue()));
        }

        public final boolean invoke(boolean z2) {
            EmojiContext emojiContext = this.$emojiContext;
            return ((emojiContext instanceof EmojiContext.Chat) || (emojiContext instanceof EmojiContext.Guild)) && z2 && !this.$hasExternalEmojiPermission;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: com.discord.stores.StoreEmoji$buildUsableEmojiSet$4 */
    /* JADX INFO: compiled from: StoreEmoji.kt */
    public static final class C58904<T> extends AbstractC12240o implements Function2<Map<T, Integer>, T, Unit> {
        public static final C58904 INSTANCE = new C58904();

        public C58904() {
            super(2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Object obj, Object obj2) {
            invoke((Map<Object, Integer>) obj, obj2);
            return Unit.f27425a;
        }

        public final <T> void invoke(Map<T, Integer> map, T t) {
            C12238m.checkNotNullParameter(map, "$this$increment");
            Integer num = map.get(t);
            map.put(t, Integer.valueOf(num != null ? 1 + num.intValue() : 1));
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreEmoji$buildUsableEmojiSet$5 */
    /* JADX INFO: compiled from: StoreEmoji.kt */
    public static final class C58915 extends AbstractC12240o implements Function1<Long, Unit> {
        public final /* synthetic */ Map $allCustomEmojis;
        public final /* synthetic */ EmojiContext $emojiContext;
        public final /* synthetic */ ShallowPartitionMap $emojiIdsMap;
        public final /* synthetic */ ShallowPartitionMap $emojiNameCounts;
        public final /* synthetic */ boolean $includeUnavailableEmojis;
        public final /* synthetic */ boolean $includeUnusableEmojis;
        public final /* synthetic */ C58881 $isExternalEmoji$1;
        public final /* synthetic */ C58892 $isExternalEmojiRestricted$2;
        public final /* synthetic */ boolean $isMePremium;
        public final /* synthetic */ HashMap $usableCustomEmojis;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C58915(Map map, C58881 c58881, C58892 c58892, boolean z2, EmojiContext emojiContext, boolean z3, boolean z4, ShallowPartitionMap shallowPartitionMap, ShallowPartitionMap shallowPartitionMap2, HashMap map2) {
            super(1);
            this.$allCustomEmojis = map;
            this.$isExternalEmoji$1 = c58881;
            this.$isExternalEmojiRestricted$2 = c58892;
            this.$includeUnavailableEmojis = z2;
            this.$emojiContext = emojiContext;
            this.$isMePremium = z3;
            this.$includeUnusableEmojis = z4;
            this.$emojiNameCounts = shallowPartitionMap;
            this.$emojiIdsMap = shallowPartitionMap2;
            this.$usableCustomEmojis = map2;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke(l.longValue());
            return Unit.f27425a;
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
                        boolean z3 = modelEmojiCustom2.isManaged() && ((this.$emojiContext instanceof EmojiContext.Global) ^ true);
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
                            C58904 c58904 = C58904.INSTANCE;
                            ShallowPartitionMap shallowPartitionMap = this.$emojiNameCounts;
                            String name = modelEmojiCustom2.getName();
                            C12238m.checkNotNullExpressionValue(name, "emoji.name");
                            c58904.invoke((Map<String, Integer>) shallowPartitionMap, name);
                            ShallowPartitionMap shallowPartitionMap2 = this.$emojiIdsMap;
                            String uniqueId = modelEmojiCustom2.getUniqueId();
                            C12238m.checkNotNullExpressionValue(uniqueId, "emoji.uniqueId");
                            shallowPartitionMap2.put(uniqueId, modelEmojiCustom);
                        }
                    }
                }
                if (!arrayList.isEmpty()) {
                    this.$usableCustomEmojis.put(Long.valueOf(j), C12163u.sortedWith(arrayList, new Comparator() { // from class: com.discord.stores.StoreEmoji$buildUsableEmojiSet$5$processGuildEmojis$$inlined$sortedByDescending$1
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // java.util.Comparator
                        public final int compare(T t, T t2) {
                            String name2 = ((ModelEmojiCustom) t2).getName();
                            C12238m.checkNotNullExpressionValue(name2, "it.name");
                            Locale locale = Locale.ROOT;
                            C12238m.checkNotNullExpressionValue(locale, "Locale.ROOT");
                            Objects.requireNonNull(name2, "null cannot be cast to non-null type java.lang.String");
                            String lowerCase = name2.toLowerCase(locale);
                            C12238m.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                            String name3 = ((ModelEmojiCustom) t).getName();
                            C12238m.checkNotNullExpressionValue(name3, "it.name");
                            C12238m.checkNotNullExpressionValue(locale, "Locale.ROOT");
                            Objects.requireNonNull(name3, "null cannot be cast to non-null type java.lang.String");
                            String lowerCase2 = name3.toLowerCase(locale);
                            C12238m.checkNotNullExpressionValue(lowerCase2, "(this as java.lang.String).toLowerCase(locale)");
                            return C12169a.compareValues(lowerCase, lowerCase2);
                        }
                    }));
                }
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreEmoji$handleLoadedUnicodeEmojis$1 */
    /* JADX INFO: compiled from: StoreEmoji.kt */
    public static final class C58971 extends AbstractC12240o implements Function1<ModelEmojiUnicode, Unit> {
        public final /* synthetic */ HashMap $unicodeEmojiSurrogateMap;
        public final /* synthetic */ HashMap $unicodeEmojisNamesMap;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C58971(HashMap map, HashMap map2) {
            super(1);
            this.$unicodeEmojiSurrogateMap = map;
            this.$unicodeEmojisNamesMap = map2;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelEmojiUnicode modelEmojiUnicode) {
            invoke2(modelEmojiUnicode);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelEmojiUnicode modelEmojiUnicode) {
            C12238m.checkNotNullParameter(modelEmojiUnicode, "emoji");
            HashMap map = this.$unicodeEmojiSurrogateMap;
            String surrogates = modelEmojiUnicode.getSurrogates();
            C12238m.checkNotNullExpressionValue(surrogates, "emoji.surrogates");
            map.put(surrogates, modelEmojiUnicode);
            List<String> names = modelEmojiUnicode.getNames();
            C12238m.checkNotNullExpressionValue(names, "emoji\n          .names");
            for (String str : names) {
                HashMap map2 = this.$unicodeEmojisNamesMap;
                C12238m.checkNotNullExpressionValue(str, "emojiName");
                map2.put(str, modelEmojiUnicode);
            }
            String surrogates2 = modelEmojiUnicode.getSurrogates();
            C12238m.checkNotNullExpressionValue(surrogates2, "emoji.surrogates");
            if (C12106w.indexOf$default((CharSequence) surrogates2, (char) 8205, 0, false, 6, (Object) null) < 0) {
                String surrogates3 = modelEmojiUnicode.getSurrogates();
                C12238m.checkNotNullExpressionValue(surrogates3, "emoji.surrogates");
                String strReplace$default = C12103t.replace$default(surrogates3, "️", "", false, 4, (Object) null);
                if (!C12238m.areEqual(strReplace$default, modelEmojiUnicode.getSurrogates())) {
                    this.$unicodeEmojiSurrogateMap.put(strReplace$default, modelEmojiUnicode);
                }
            }
        }
    }

    public StoreEmoji(StoreEmojiCustom storeEmojiCustom, StoreUser storeUser, StorePermissions storePermissions, StoreGuildsSorted storeGuildsSorted, StoreMediaFavorites storeMediaFavorites) {
        C12238m.checkNotNullParameter(storeEmojiCustom, "customEmojiStore");
        C12238m.checkNotNullParameter(storeUser, "userStore");
        C12238m.checkNotNullParameter(storePermissions, "permissionsStore");
        C12238m.checkNotNullParameter(storeGuildsSorted, "sortedGuildsStore");
        C12238m.checkNotNullParameter(storeMediaFavorites, "mediaFavoritesStore");
        this.customEmojiStore = storeEmojiCustom;
        this.userStore = storeUser;
        this.permissionsStore = storePermissions;
        this.sortedGuildsStore = storeGuildsSorted;
        this.mediaFavoritesStore = storeMediaFavorites;
        Persister<MediaFrecencyTracker> persister = new Persister<>("EMOJI_HISTORY_V4", new MediaFrecencyTracker(0, 0, 3, null));
        this.frecencyCache = persister;
        this.frecency = persister.get();
    }

    private final EmojiSet buildUsableEmojiSet(Map<Long, ? extends Map<Long, ? extends ModelEmojiCustom>> allCustomEmojis, EmojiContext emojiContext, List<Long> sortedGuildIds, boolean isMePremium, boolean includeUnusableEmojis, boolean includeUnavailableEmojis, boolean hasExternalEmojiPermission, Set<? extends StoreMediaFavorites.Favorite> favorites) {
        C58881 c58881 = new C58881(emojiContext);
        C58892 c58892 = new C58892(hasExternalEmojiPermission, emojiContext);
        Set<Long> setKeySet = allCustomEmojis.keySet();
        ArrayList arrayList = new ArrayList();
        for (Object obj : setKeySet) {
            if (!sortedGuildIds.contains(Long.valueOf(((Number) obj).longValue()))) {
                arrayList.add(obj);
            }
        }
        int size = sortedGuildIds.size() + arrayList.size();
        Iterator it = C12147n.listOf((Object[]) new List[]{sortedGuildIds, arrayList}).iterator();
        int i = 0;
        while (it.hasNext()) {
            Iterator it2 = ((List) it.next()).iterator();
            int size2 = 0;
            while (it2.hasNext()) {
                long jLongValue = ((Number) it2.next()).longValue();
                Map<Long, ? extends ModelEmojiCustom> map = allCustomEmojis.get(Long.valueOf(jLongValue));
                size2 += (map == null || c58892.invoke(c58881.invoke(jLongValue))) ? 0 : map.size();
            }
            i += size2;
        }
        Map<String, ? extends ModelEmojiUnicode> map2 = this.unicodeEmojisNamesMap;
        if (map2 == null) {
            C12238m.throwUninitializedPropertyAccessException("unicodeEmojisNamesMap");
        }
        int size3 = map2.size();
        Map<EmojiCategory, ? extends List<? extends Emoji>> map3 = this.unicodeEmojis;
        if (map3 == null) {
            C12238m.throwUninitializedPropertyAccessException("unicodeEmojis");
        }
        Iterator<T> it3 = map3.values().iterator();
        int size4 = 0;
        while (it3.hasNext()) {
            size4 += ((List) it3.next()).size();
        }
        ShallowPartitionMap.Companion companion = ShallowPartitionMap.INSTANCE;
        ShallowPartitionMap shallowPartitionMapCreate$default = ShallowPartitionMap.Companion.create$default(companion, i + size3, 0, 0, null, 14, null);
        HashMap map4 = new HashMap(size);
        ShallowPartitionMap shallowPartitionMapCreate$default2 = ShallowPartitionMap.Companion.create$default(companion, i + size4, 0, 0, null, 14, null);
        if (!(emojiContext instanceof EmojiContext.GuildProfile)) {
            Map<EmojiCategory, ? extends List<? extends Emoji>> map5 = this.unicodeEmojis;
            if (map5 == null) {
                C12238m.throwUninitializedPropertyAccessException("unicodeEmojis");
            }
            Iterator<T> it4 = map5.values().iterator();
            while (it4.hasNext()) {
                for (Emoji emoji : (List) it4.next()) {
                    String uniqueId = emoji.getUniqueId();
                    C12238m.checkNotNullExpressionValue(uniqueId, "emoji.uniqueId");
                    shallowPartitionMapCreate$default2.put(uniqueId, emoji);
                }
            }
        }
        C58904 c58904 = C58904.INSTANCE;
        ShallowPartitionMap shallowPartitionMap = shallowPartitionMapCreate$default2;
        C58915 c58915 = new C58915(allCustomEmojis, c58881, c58892, includeUnavailableEmojis, emojiContext, isMePremium, includeUnusableEmojis, shallowPartitionMapCreate$default, shallowPartitionMap, map4);
        Map<String, ? extends ModelEmojiUnicode> map6 = this.unicodeEmojisNamesMap;
        if (map6 == null) {
            C12238m.throwUninitializedPropertyAccessException("unicodeEmojisNamesMap");
        }
        Iterator<T> it5 = map6.keySet().iterator();
        while (it5.hasNext()) {
            C58904.INSTANCE.invoke((Map<String, Integer>) shallowPartitionMapCreate$default, (String) it5.next());
        }
        long guildId = emojiContext instanceof EmojiContext.Chat ? ((EmojiContext.Chat) emojiContext).getGuildId() : 0L;
        c58915.invoke(guildId);
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : sortedGuildIds) {
            if (((Number) obj2).longValue() != guildId) {
                arrayList2.add(obj2);
            }
        }
        Iterator it6 = arrayList2.iterator();
        while (it6.hasNext()) {
            c58915.invoke(((Number) it6.next()).longValue());
        }
        Iterator it7 = arrayList.iterator();
        while (it7.hasNext()) {
            c58915.invoke(((Number) it7.next()).longValue());
        }
        ArrayList arrayList3 = new ArrayList();
        for (Object obj3 : favorites) {
            if (obj3 instanceof StoreMediaFavorites.FavoriteEmoji) {
                arrayList3.add(obj3);
            }
        }
        ArrayList arrayList4 = new ArrayList();
        Iterator it8 = arrayList3.iterator();
        while (it8.hasNext()) {
            ShallowPartitionMap shallowPartitionMap2 = shallowPartitionMap;
            Emoji emoji2 = (Emoji) shallowPartitionMap2.get(((StoreMediaFavorites.FavoriteEmoji) it8.next()).getEmojiUniqueId());
            if (emoji2 != null) {
                arrayList4.add(emoji2);
            }
            shallowPartitionMap = shallowPartitionMap2;
        }
        Map<String, ? extends Emoji> map7 = shallowPartitionMap;
        Set set = C12163u.toSet(arrayList4);
        Map<EmojiCategory, ? extends List<? extends Emoji>> map8 = this.unicodeEmojis;
        if (map8 == null) {
            C12238m.throwUninitializedPropertyAccessException("unicodeEmojis");
        }
        return new EmojiSet(map8, map4, map7, getFrequentlyUsedEmojis(map7), set);
    }

    private final Pattern compileSurrogatesPattern() {
        Map<String, ? extends ModelEmojiUnicode> map = this.unicodeEmojiSurrogateMap;
        if (map == null) {
            C12238m.throwUninitializedPropertyAccessException("unicodeEmojiSurrogateMap");
        }
        Pattern patternCompile = Pattern.compile(C12163u.joinToString$default(C12163u.sortedWith(map.keySet(), new Comparator() { // from class: com.discord.stores.StoreEmoji$compileSurrogatesPattern$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return C12169a.compareValues(Integer.valueOf(-((String) t).length()), Integer.valueOf(-((String) t2).length()));
            }
        }), "|", null, null, 0, null, StoreEmoji$compileSurrogatesPattern$emojiSurrogatesPattern$2.INSTANCE, 30, null));
        C12238m.checkNotNullExpressionValue(patternCompile, "Pattern.compile(emojiSurrogatesPattern)");
        return patternCompile;
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
        List<Emoji> listTake = C12163u.take(arrayList, 40);
        if (listTake.size() >= 40) {
            return listTake;
        }
        String[] strArr = DEFAULT_FREQUENT_EMOJIS;
        ArrayList arrayList2 = new ArrayList();
        for (String str : strArr) {
            Map<String, ? extends ModelEmojiUnicode> map = this.unicodeEmojisNamesMap;
            if (map == null) {
                C12238m.throwUninitializedPropertyAccessException("unicodeEmojisNamesMap");
            }
            ModelEmojiUnicode modelEmojiUnicode = map.get(str);
            if (modelEmojiUnicode != null) {
                arrayList2.add(modelEmojiUnicode);
            }
        }
        return C12163u.distinct(C12078q.toList(C12075n.flattenSequenceOfIterable(C12075n.sequenceOf(listTake, C12163u.take(arrayList2, 40 - listTake.size())))));
    }

    private final void handleLoadedUnicodeEmojis(ModelEmojiUnicode.Bundle unicodeEmojisBundle) {
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        HashMap map3 = new HashMap();
        C58971 c58971 = new C58971(map3, map2);
        Map<EmojiCategory, List<ModelEmojiUnicode>> emojis = unicodeEmojisBundle.getEmojis();
        C12238m.checkNotNullExpressionValue(emojis, "unicodeEmojisBundle.emojis");
        for (Map.Entry<EmojiCategory, List<ModelEmojiUnicode>> entry : emojis.entrySet()) {
            EmojiCategory key = entry.getKey();
            List<ModelEmojiUnicode> value = entry.getValue();
            C12238m.checkNotNullExpressionValue(key, "category");
            C12238m.checkNotNullExpressionValue(value, "categoryEmojis");
            map.put(key, value);
            for (ModelEmojiUnicode modelEmojiUnicode : value) {
                C12238m.checkNotNullExpressionValue(modelEmojiUnicode, "unicodeEmoji");
                c58971.invoke2(modelEmojiUnicode);
                List<ModelEmojiUnicode> asDiverse = modelEmojiUnicode.getAsDiverse();
                C12238m.checkNotNullExpressionValue(asDiverse, "unicodeEmoji\n                .asDiverse");
                for (ModelEmojiUnicode modelEmojiUnicode2 : asDiverse) {
                    C12238m.checkNotNullExpressionValue(modelEmojiUnicode2, "diverseEmoji");
                    c58971.invoke2(modelEmojiUnicode2);
                }
            }
        }
        this.unicodeEmojis = map;
        this.unicodeEmojisNamesMap = map2;
        this.unicodeEmojiSurrogateMap = map3;
        this.unicodeEmojisPattern = compileSurrogatesPattern();
    }

    private final ModelEmojiUnicode.Bundle loadUnicodeEmojisFromDisk(Context context) throws IOException {
        Model model = new Model.JsonReader(new InputStreamReader(context.getAssets().open("data/emojis.json"), Constants.ENCODING)).parse(new ModelEmojiUnicode.Bundle());
        C12238m.checkNotNullExpressionValue(model, "jsonReader.parse(ModelEmojiUnicode.Bundle())");
        return (ModelEmojiUnicode.Bundle) model;
    }

    @StoreThread
    public final ModelEmojiCustom getCustomEmojiInternal(long emojiId) {
        Iterator<Map.Entry<Long, Map<Long, ModelEmojiCustom>>> it = this.customEmojiStore.getAllGuildEmojiInternal().entrySet().iterator();
        while (it.hasNext()) {
            ModelEmojiCustom modelEmojiCustom = it.next().getValue().get(Long.valueOf(emojiId));
            if (modelEmojiCustom != null) {
                return modelEmojiCustom;
            }
        }
        return null;
    }

    public final Observable<EmojiSet> getEmojiSet(long guildId, long channelId, boolean includeUnusableEmojis, boolean includeUnavailableEmojis) {
        return getEmojiSet(new EmojiContext.Chat(guildId, channelId), includeUnusableEmojis, includeUnavailableEmojis);
    }

    @Override // com.discord.utilities.textprocessing.Rules.EmojiDataProvider
    public Map<String, ModelEmojiUnicode> getUnicodeEmojiSurrogateMap() {
        Map map = this.unicodeEmojiSurrogateMap;
        if (map == null) {
            C12238m.throwUninitializedPropertyAccessException("unicodeEmojiSurrogateMap");
        }
        return map;
    }

    @Override // com.discord.utilities.textprocessing.Rules.EmojiDataProvider
    public Map<String, ModelEmojiUnicode> getUnicodeEmojisNamesMap() {
        Map map = this.unicodeEmojisNamesMap;
        if (map == null) {
            C12238m.throwUninitializedPropertyAccessException("unicodeEmojisNamesMap");
        }
        return map;
    }

    @Override // com.discord.utilities.textprocessing.Rules.EmojiDataProvider
    public Pattern getUnicodeEmojisPattern() {
        Pattern pattern = this.unicodeEmojisPattern;
        if (pattern == null) {
            C12238m.throwUninitializedPropertyAccessException("unicodeEmojisPattern");
        }
        return pattern;
    }

    @StoreThread
    public final void handlePreLogout() {
        Persister.clear$default(this.frecencyCache, false, 1, null);
    }

    public final void initBlocking(Context context) {
        C12238m.checkNotNullParameter(context, "context");
        handleLoadedUnicodeEmojis(loadUnicodeEmojisFromDisk(context));
    }

    public final void onEmojiUsed(Emoji emoji) {
        C12238m.checkNotNullParameter(emoji, "emoji");
        String uniqueId = emoji.getUniqueId();
        C12238m.checkNotNullExpressionValue(uniqueId, "emoji.uniqueId");
        onEmojiUsed(uniqueId);
    }

    public final void onEmojiUsed(String emojiKey) {
        C12238m.checkNotNullParameter(emojiKey, "emojiKey");
        FrecencyTracker.track$default(this.frecency, emojiKey, 0L, 2, null);
        Persister.set$default(this.frecencyCache, this.frecency, false, 2, null);
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0033  */
    /* JADX WARN: Code duplicated, block: B:7:0x0027  */
    /* JADX WARN: Code duplicated, block: B:9:0x002b  */
    public final Observable<EmojiSet> getEmojiSet(final EmojiContext emojiContext, final boolean includeUnusableEmojis, final boolean includeUnavailableEmojis) {
        C12721k c12721k;
        Observable observableM11083G;
        C12238m.checkNotNullParameter(emojiContext, "emojiContext");
        if (emojiContext instanceof EmojiContext.Chat) {
            EmojiContext.Chat chat = (EmojiContext.Chat) emojiContext;
            if (chat.getGuildId() != 0) {
                observableM11083G = this.permissionsStore.observePermissionsForChannel(chat.getChannelId()).m11083G(new InterfaceC12589b<Long, Boolean>() { // from class: com.discord.stores.StoreEmoji$getEmojiSet$hasExternalEmojiPermissionObservable$1
                    @Override // p637j0.p641k.InterfaceC12589b
                    public final Boolean call(Long l) {
                        return Boolean.valueOf(PermissionUtils.can(Permission.USE_EXTERNAL_EMOJIS, l));
                    }
                });
            } else {
                if (emojiContext instanceof EmojiContext.Guild) {
                    c12721k = new C12721k(Boolean.FALSE);
                } else {
                    c12721k = new C12721k(Boolean.TRUE);
                }
                observableM11083G = c12721k;
            }
        } else {
            if (emojiContext instanceof EmojiContext.Guild) {
                c12721k = new C12721k(Boolean.FALSE);
            } else {
                c12721k = new C12721k(Boolean.TRUE);
            }
            observableM11083G = c12721k;
        }
        Observable<EmojiSet> observableM11099Y = Observable.m11073h(StoreUser.observeMe$default(this.userStore, false, 1, null).m11083G(new InterfaceC12589b<MeUser, Boolean>() { // from class: com.discord.stores.StoreEmoji.getEmojiSet.1
            @Override // p637j0.p641k.InterfaceC12589b
            public final Boolean call(MeUser meUser) {
                UserUtils userUtils = UserUtils.INSTANCE;
                C12238m.checkNotNullExpressionValue(meUser, "it");
                return Boolean.valueOf(userUtils.isPremium(meUser));
            }
        }), observableM11083G, this.sortedGuildsStore.observeOrderedGuilds().m11083G(new InterfaceC12589b<LinkedHashMap<Long, Guild>, List<? extends Long>>() { // from class: com.discord.stores.StoreEmoji.getEmojiSet.2
            @Override // p637j0.p641k.InterfaceC12589b
            public final List<Long> call(LinkedHashMap<Long, Guild> linkedHashMap) {
                Set<Long> setKeySet = linkedHashMap.keySet();
                C12238m.checkNotNullExpressionValue(setKeySet, "it.keys");
                return C12163u.toList(setKeySet);
            }
        }), this.mediaFavoritesStore.observeFavorites(StoreMediaFavorites.Favorite.INSTANCE.getEmojiTypes()), new Func4<Boolean, Boolean, List<? extends Long>, Set<? extends StoreMediaFavorites.Favorite>, Quad<? extends Boolean, ? extends Boolean, ? extends List<? extends Long>, ? extends Set<? extends StoreMediaFavorites.Favorite>>>() { // from class: com.discord.stores.StoreEmoji.getEmojiSet.3
            @Override // p658rx.functions.Func4
            public /* bridge */ /* synthetic */ Quad<? extends Boolean, ? extends Boolean, ? extends List<? extends Long>, ? extends Set<? extends StoreMediaFavorites.Favorite>> call(Boolean bool, Boolean bool2, List<? extends Long> list, Set<? extends StoreMediaFavorites.Favorite> set) {
                return call2(bool, bool2, (List<Long>) list, set);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final Quad<Boolean, Boolean, List<Long>, Set<StoreMediaFavorites.Favorite>> call2(Boolean bool, Boolean bool2, List<Long> list, Set<? extends StoreMediaFavorites.Favorite> set) {
                return new Quad<>(bool, bool2, list, set);
            }
        }).m11112r().m11099Y(new InterfaceC12589b<Quad<? extends Boolean, ? extends Boolean, ? extends List<? extends Long>, ? extends Set<? extends StoreMediaFavorites.Favorite>>, Observable<? extends EmojiSet>>() { // from class: com.discord.stores.StoreEmoji.getEmojiSet.4
            @Override // p637j0.p641k.InterfaceC12589b
            public /* bridge */ /* synthetic */ Observable<? extends EmojiSet> call(Quad<? extends Boolean, ? extends Boolean, ? extends List<? extends Long>, ? extends Set<? extends StoreMediaFavorites.Favorite>> quad) {
                return call2((Quad<Boolean, Boolean, ? extends List<Long>, ? extends Set<? extends StoreMediaFavorites.Favorite>>) quad);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final Observable<? extends EmojiSet> call2(Quad<Boolean, Boolean, ? extends List<Long>, ? extends Set<? extends StoreMediaFavorites.Favorite>> quad) {
                final Boolean boolComponent1 = quad.component1();
                final Boolean boolComponent2 = quad.component2();
                final List<Long> listComponent3 = quad.component3();
                final Set<? extends StoreMediaFavorites.Favorite> setComponent4 = quad.component4();
                return ObservableExtensionsKt.computationLatest(StoreEmoji.this.customEmojiStore.observeAllowedGuildEmoji()).m11083G(new InterfaceC12589b<Map<Long, ? extends Map<Long, ? extends ModelEmojiCustom>>, EmojiSet>() { // from class: com.discord.stores.StoreEmoji.getEmojiSet.4.1
                    @Override // p637j0.p641k.InterfaceC12589b
                    public final EmojiSet call(Map<Long, ? extends Map<Long, ? extends ModelEmojiCustom>> map) {
                        StoreEmoji storeEmoji = StoreEmoji.this;
                        C12238m.checkNotNullExpressionValue(map, "allowedCustomEmoji");
                        EmojiContext emojiContext2 = emojiContext;
                        List list = listComponent3;
                        C12238m.checkNotNullExpressionValue(list, "sortedGuildIds");
                        Boolean bool = boolComponent1;
                        C12238m.checkNotNullExpressionValue(bool, "isPremium");
                        boolean zBooleanValue = bool.booleanValue();
                        C58964 c58964 = C58964.this;
                        boolean z2 = includeUnavailableEmojis;
                        boolean z3 = includeUnusableEmojis;
                        Boolean bool2 = boolComponent2;
                        C12238m.checkNotNullExpressionValue(bool2, "hasExternalEmojiPermission");
                        boolean zBooleanValue2 = bool2.booleanValue();
                        Set set = setComponent4;
                        C12238m.checkNotNullExpressionValue(set, "favorites");
                        return storeEmoji.buildUsableEmojiSet(map, emojiContext2, list, zBooleanValue, z3, z2, zBooleanValue2, set);
                    }
                });
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11099Y, "Observable\n        .comb…              }\n        }");
        return observableM11099Y;
    }
}
