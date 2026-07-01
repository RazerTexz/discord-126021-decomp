package com.discord.stores;

import a0.a.a.b;
import android.annotation.SuppressLint;
import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import b.d.b.a.outline;
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
import com.discord.stores.StoreMediaFavorites;
import com.discord.utilities.Quad;
import com.discord.utilities.collections.ShallowPartitionMap;
import com.discord.utilities.frecency.FrecencyTracker;
import com.discord.utilities.media.MediaFrecencyTracker;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.persister.Persister;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.textprocessing.Rules;
import com.discord.utilities.user.UserUtils;
import d0.f0._Sequences2;
import d0.f0.n;
import d0.g0.Strings4;
import d0.g0.StringsJVM;
import d0.t.Collections2;
import d0.t._Collections;
import d0.u.a;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
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
import rx.Observable;
import rx.functions.Func4;

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
                return b.a(this.channelId) + (b.a(this.guildId) * 31);
            }

            public String toString() {
                StringBuilder sbU = outline.U("Chat(guildId=");
                sbU.append(this.guildId);
                sbU.append(", channelId=");
                return outline.C(sbU, this.channelId, ")");
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
                return b.a(this.guildId);
            }

            public String toString() {
                return outline.C(outline.U("Guild(guildId="), this.guildId, ")");
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
                return b.a(this.guildId);
            }

            public String toString() {
                return outline.C(outline.U("GuildProfile(guildId="), this.guildId, ")");
            }
        }

        private EmojiContext() {
        }

        public /* synthetic */ EmojiContext(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreEmoji$buildUsableEmojiSet$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreEmoji.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Long, Boolean> {
        public final /* synthetic */ EmojiContext $emojiContext;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(EmojiContext emojiContext) {
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

    /* JADX INFO: renamed from: com.discord.stores.StoreEmoji$buildUsableEmojiSet$2, reason: invalid class name */
    /* JADX INFO: compiled from: StoreEmoji.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<Boolean, Boolean> {
        public final /* synthetic */ EmojiContext $emojiContext;
        public final /* synthetic */ boolean $hasExternalEmojiPermission;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(boolean z2, EmojiContext emojiContext) {
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
    /* JADX INFO: renamed from: com.discord.stores.StoreEmoji$buildUsableEmojiSet$4, reason: invalid class name */
    /* JADX INFO: compiled from: StoreEmoji.kt */
    public static final class AnonymousClass4<T> extends Lambda implements Function2<Map<T, Integer>, T, Unit> {
        public static final AnonymousClass4 INSTANCE = new AnonymousClass4();

        public AnonymousClass4() {
            super(2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Object obj, Object obj2) {
            invoke((Map<Object, Integer>) obj, obj2);
            return Unit.a;
        }

        public final <T> void invoke(Map<T, Integer> map, T t) {
            Intrinsics3.checkNotNullParameter(map, "$this$increment");
            Integer num = map.get(t);
            map.put(t, Integer.valueOf(num != null ? 1 + num.intValue() : 1));
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreEmoji$buildUsableEmojiSet$5, reason: invalid class name */
    /* JADX INFO: compiled from: StoreEmoji.kt */
    public static final class AnonymousClass5 extends Lambda implements Function1<Long, Unit> {
        public final /* synthetic */ Map $allCustomEmojis;
        public final /* synthetic */ EmojiContext $emojiContext;
        public final /* synthetic */ ShallowPartitionMap $emojiIdsMap;
        public final /* synthetic */ ShallowPartitionMap $emojiNameCounts;
        public final /* synthetic */ boolean $includeUnavailableEmojis;
        public final /* synthetic */ boolean $includeUnusableEmojis;
        public final /* synthetic */ AnonymousClass1 $isExternalEmoji$1;
        public final /* synthetic */ AnonymousClass2 $isExternalEmojiRestricted$2;
        public final /* synthetic */ boolean $isMePremium;
        public final /* synthetic */ HashMap $usableCustomEmojis;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass5(Map map, AnonymousClass1 anonymousClass1, AnonymousClass2 anonymousClass2, boolean z2, EmojiContext emojiContext, boolean z3, boolean z4, ShallowPartitionMap shallowPartitionMap, ShallowPartitionMap shallowPartitionMap2, HashMap map2) {
            super(1);
            this.$allCustomEmojis = map;
            this.$isExternalEmoji$1 = anonymousClass1;
            this.$isExternalEmojiRestricted$2 = anonymousClass2;
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
                            AnonymousClass4 anonymousClass4 = AnonymousClass4.INSTANCE;
                            ShallowPartitionMap shallowPartitionMap = this.$emojiNameCounts;
                            String name = modelEmojiCustom2.getName();
                            Intrinsics3.checkNotNullExpressionValue(name, "emoji.name");
                            anonymousClass4.invoke((Map<String, Integer>) shallowPartitionMap, name);
                            ShallowPartitionMap shallowPartitionMap2 = this.$emojiIdsMap;
                            String uniqueId = modelEmojiCustom2.getUniqueId();
                            Intrinsics3.checkNotNullExpressionValue(uniqueId, "emoji.uniqueId");
                            shallowPartitionMap2.put(uniqueId, modelEmojiCustom);
                        }
                    }
                }
                if (!arrayList.isEmpty()) {
                    this.$usableCustomEmojis.put(Long.valueOf(j), _Collections.sortedWith(arrayList, new Comparator() { // from class: com.discord.stores.StoreEmoji$buildUsableEmojiSet$5$processGuildEmojis$$inlined$sortedByDescending$1
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // java.util.Comparator
                        public final int compare(T t, T t2) {
                            String name2 = ((ModelEmojiCustom) t2).getName();
                            Intrinsics3.checkNotNullExpressionValue(name2, "it.name");
                            Locale locale = Locale.ROOT;
                            Intrinsics3.checkNotNullExpressionValue(locale, "Locale.ROOT");
                            Objects.requireNonNull(name2, "null cannot be cast to non-null type java.lang.String");
                            String lowerCase = name2.toLowerCase(locale);
                            Intrinsics3.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                            String name3 = ((ModelEmojiCustom) t).getName();
                            Intrinsics3.checkNotNullExpressionValue(name3, "it.name");
                            Intrinsics3.checkNotNullExpressionValue(locale, "Locale.ROOT");
                            Objects.requireNonNull(name3, "null cannot be cast to non-null type java.lang.String");
                            String lowerCase2 = name3.toLowerCase(locale);
                            Intrinsics3.checkNotNullExpressionValue(lowerCase2, "(this as java.lang.String).toLowerCase(locale)");
                            return a.compareValues(lowerCase, lowerCase2);
                        }
                    }));
                }
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreEmoji$handleLoadedUnicodeEmojis$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreEmoji.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<ModelEmojiUnicode, Unit> {
        public final /* synthetic */ HashMap $unicodeEmojiSurrogateMap;
        public final /* synthetic */ HashMap $unicodeEmojisNamesMap;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(HashMap map, HashMap map2) {
            super(1);
            this.$unicodeEmojiSurrogateMap = map;
            this.$unicodeEmojisNamesMap = map2;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelEmojiUnicode modelEmojiUnicode) {
            invoke2(modelEmojiUnicode);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelEmojiUnicode modelEmojiUnicode) {
            Intrinsics3.checkNotNullParameter(modelEmojiUnicode, "emoji");
            HashMap map = this.$unicodeEmojiSurrogateMap;
            String surrogates = modelEmojiUnicode.getSurrogates();
            Intrinsics3.checkNotNullExpressionValue(surrogates, "emoji.surrogates");
            map.put(surrogates, modelEmojiUnicode);
            List<String> names = modelEmojiUnicode.getNames();
            Intrinsics3.checkNotNullExpressionValue(names, "emoji\n          .names");
            for (String str : names) {
                HashMap map2 = this.$unicodeEmojisNamesMap;
                Intrinsics3.checkNotNullExpressionValue(str, "emojiName");
                map2.put(str, modelEmojiUnicode);
            }
            String surrogates2 = modelEmojiUnicode.getSurrogates();
            Intrinsics3.checkNotNullExpressionValue(surrogates2, "emoji.surrogates");
            if (Strings4.indexOf$default((CharSequence) surrogates2, (char) 8205, 0, false, 6, (Object) null) < 0) {
                String surrogates3 = modelEmojiUnicode.getSurrogates();
                Intrinsics3.checkNotNullExpressionValue(surrogates3, "emoji.surrogates");
                String strReplace$default = StringsJVM.replace$default(surrogates3, "️", "", false, 4, (Object) null);
                if (!Intrinsics3.areEqual(strReplace$default, modelEmojiUnicode.getSurrogates())) {
                    this.$unicodeEmojiSurrogateMap.put(strReplace$default, modelEmojiUnicode);
                }
            }
        }
    }

    public StoreEmoji(StoreEmojiCustom storeEmojiCustom, StoreUser storeUser, StorePermissions storePermissions, StoreGuildsSorted storeGuildsSorted, StoreMediaFavorites storeMediaFavorites) {
        Intrinsics3.checkNotNullParameter(storeEmojiCustom, "customEmojiStore");
        Intrinsics3.checkNotNullParameter(storeUser, "userStore");
        Intrinsics3.checkNotNullParameter(storePermissions, "permissionsStore");
        Intrinsics3.checkNotNullParameter(storeGuildsSorted, "sortedGuildsStore");
        Intrinsics3.checkNotNullParameter(storeMediaFavorites, "mediaFavoritesStore");
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
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(emojiContext);
        AnonymousClass2 anonymousClass2 = new AnonymousClass2(hasExternalEmojiPermission, emojiContext);
        Set<Long> setKeySet = allCustomEmojis.keySet();
        ArrayList arrayList = new ArrayList();
        for (Object obj : setKeySet) {
            if (!sortedGuildIds.contains(Long.valueOf(((Number) obj).longValue()))) {
                arrayList.add(obj);
            }
        }
        int size = sortedGuildIds.size() + arrayList.size();
        Iterator it = Collections2.listOf((Object[]) new List[]{sortedGuildIds, arrayList}).iterator();
        int i = 0;
        while (it.hasNext()) {
            Iterator it2 = ((List) it.next()).iterator();
            int size2 = 0;
            while (it2.hasNext()) {
                long jLongValue = ((Number) it2.next()).longValue();
                Map<Long, ? extends ModelEmojiCustom> map = allCustomEmojis.get(Long.valueOf(jLongValue));
                size2 += (map == null || anonymousClass2.invoke(anonymousClass1.invoke(jLongValue))) ? 0 : map.size();
            }
            i += size2;
        }
        Map<String, ? extends ModelEmojiUnicode> map2 = this.unicodeEmojisNamesMap;
        if (map2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("unicodeEmojisNamesMap");
        }
        int size3 = map2.size();
        Map<EmojiCategory, ? extends List<? extends Emoji>> map3 = this.unicodeEmojis;
        if (map3 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("unicodeEmojis");
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
                Intrinsics3.throwUninitializedPropertyAccessException("unicodeEmojis");
            }
            Iterator<T> it4 = map5.values().iterator();
            while (it4.hasNext()) {
                for (Emoji emoji : (List) it4.next()) {
                    String uniqueId = emoji.getUniqueId();
                    Intrinsics3.checkNotNullExpressionValue(uniqueId, "emoji.uniqueId");
                    shallowPartitionMapCreate$default2.put(uniqueId, emoji);
                }
            }
        }
        AnonymousClass4 anonymousClass4 = AnonymousClass4.INSTANCE;
        ShallowPartitionMap shallowPartitionMap = shallowPartitionMapCreate$default2;
        AnonymousClass5 anonymousClass5 = new AnonymousClass5(allCustomEmojis, anonymousClass1, anonymousClass2, includeUnavailableEmojis, emojiContext, isMePremium, includeUnusableEmojis, shallowPartitionMapCreate$default, shallowPartitionMap, map4);
        Map<String, ? extends ModelEmojiUnicode> map6 = this.unicodeEmojisNamesMap;
        if (map6 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("unicodeEmojisNamesMap");
        }
        Iterator<T> it5 = map6.keySet().iterator();
        while (it5.hasNext()) {
            AnonymousClass4.INSTANCE.invoke((Map<String, Integer>) shallowPartitionMapCreate$default, (String) it5.next());
        }
        long guildId = emojiContext instanceof EmojiContext.Chat ? ((EmojiContext.Chat) emojiContext).getGuildId() : 0L;
        anonymousClass5.invoke(guildId);
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : sortedGuildIds) {
            if (((Number) obj2).longValue() != guildId) {
                arrayList2.add(obj2);
            }
        }
        Iterator it6 = arrayList2.iterator();
        while (it6.hasNext()) {
            anonymousClass5.invoke(((Number) it6.next()).longValue());
        }
        Iterator it7 = arrayList.iterator();
        while (it7.hasNext()) {
            anonymousClass5.invoke(((Number) it7.next()).longValue());
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
        Set set = _Collections.toSet(arrayList4);
        Map<EmojiCategory, ? extends List<? extends Emoji>> map8 = this.unicodeEmojis;
        if (map8 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("unicodeEmojis");
        }
        return new EmojiSet(map8, map4, map7, getFrequentlyUsedEmojis(map7), set);
    }

    private final Pattern compileSurrogatesPattern() {
        Map<String, ? extends ModelEmojiUnicode> map = this.unicodeEmojiSurrogateMap;
        if (map == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("unicodeEmojiSurrogateMap");
        }
        Pattern patternCompile = Pattern.compile(_Collections.joinToString$default(_Collections.sortedWith(map.keySet(), new Comparator() { // from class: com.discord.stores.StoreEmoji$compileSurrogatesPattern$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return a.compareValues(Integer.valueOf(-((String) t).length()), Integer.valueOf(-((String) t2).length()));
            }
        }), "|", null, null, 0, null, StoreEmoji2.INSTANCE, 30, null));
        Intrinsics3.checkNotNullExpressionValue(patternCompile, "Pattern.compile(emojiSurrogatesPattern)");
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
        List<Emoji> listTake = _Collections.take(arrayList, 40);
        if (listTake.size() >= 40) {
            return listTake;
        }
        String[] strArr = DEFAULT_FREQUENT_EMOJIS;
        ArrayList arrayList2 = new ArrayList();
        for (String str : strArr) {
            Map<String, ? extends ModelEmojiUnicode> map = this.unicodeEmojisNamesMap;
            if (map == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("unicodeEmojisNamesMap");
            }
            ModelEmojiUnicode modelEmojiUnicode = map.get(str);
            if (modelEmojiUnicode != null) {
                arrayList2.add(modelEmojiUnicode);
            }
        }
        return _Collections.distinct(_Sequences2.toList(n.flattenSequenceOfIterable(n.sequenceOf(listTake, _Collections.take(arrayList2, 40 - listTake.size())))));
    }

    private final void handleLoadedUnicodeEmojis(ModelEmojiUnicode.Bundle unicodeEmojisBundle) {
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        HashMap map3 = new HashMap();
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(map3, map2);
        Map<EmojiCategory, List<ModelEmojiUnicode>> emojis = unicodeEmojisBundle.getEmojis();
        Intrinsics3.checkNotNullExpressionValue(emojis, "unicodeEmojisBundle.emojis");
        for (Map.Entry<EmojiCategory, List<ModelEmojiUnicode>> entry : emojis.entrySet()) {
            EmojiCategory key = entry.getKey();
            List<ModelEmojiUnicode> value = entry.getValue();
            Intrinsics3.checkNotNullExpressionValue(key, "category");
            Intrinsics3.checkNotNullExpressionValue(value, "categoryEmojis");
            map.put(key, value);
            for (ModelEmojiUnicode modelEmojiUnicode : value) {
                Intrinsics3.checkNotNullExpressionValue(modelEmojiUnicode, "unicodeEmoji");
                anonymousClass1.invoke2(modelEmojiUnicode);
                List<ModelEmojiUnicode> asDiverse = modelEmojiUnicode.getAsDiverse();
                Intrinsics3.checkNotNullExpressionValue(asDiverse, "unicodeEmoji\n                .asDiverse");
                for (ModelEmojiUnicode modelEmojiUnicode2 : asDiverse) {
                    Intrinsics3.checkNotNullExpressionValue(modelEmojiUnicode2, "diverseEmoji");
                    anonymousClass1.invoke2(modelEmojiUnicode2);
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
        Intrinsics3.checkNotNullExpressionValue(model, "jsonReader.parse(ModelEmojiUnicode.Bundle())");
        return (ModelEmojiUnicode.Bundle) model;
    }

    @Store3
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
            Intrinsics3.throwUninitializedPropertyAccessException("unicodeEmojiSurrogateMap");
        }
        return map;
    }

    @Override // com.discord.utilities.textprocessing.Rules.EmojiDataProvider
    public Map<String, ModelEmojiUnicode> getUnicodeEmojisNamesMap() {
        Map map = this.unicodeEmojisNamesMap;
        if (map == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("unicodeEmojisNamesMap");
        }
        return map;
    }

    @Override // com.discord.utilities.textprocessing.Rules.EmojiDataProvider
    public Pattern getUnicodeEmojisPattern() {
        Pattern pattern = this.unicodeEmojisPattern;
        if (pattern == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("unicodeEmojisPattern");
        }
        return pattern;
    }

    @Store3
    public final void handlePreLogout() {
        Persister.clear$default(this.frecencyCache, false, 1, null);
    }

    public final void initBlocking(Context context) {
        Intrinsics3.checkNotNullParameter(context, "context");
        handleLoadedUnicodeEmojis(loadUnicodeEmojisFromDisk(context));
    }

    public final void onEmojiUsed(Emoji emoji) {
        Intrinsics3.checkNotNullParameter(emoji, "emoji");
        String uniqueId = emoji.getUniqueId();
        Intrinsics3.checkNotNullExpressionValue(uniqueId, "emoji.uniqueId");
        onEmojiUsed(uniqueId);
    }

    public final void onEmojiUsed(String emojiKey) {
        Intrinsics3.checkNotNullParameter(emojiKey, "emojiKey");
        FrecencyTracker.track$default(this.frecency, emojiKey, 0L, 2, null);
        Persister.set$default(this.frecencyCache, this.frecency, false, 2, null);
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0033  */
    /* JADX WARN: Code duplicated, block: B:7:0x0027  */
    /* JADX WARN: Code duplicated, block: B:9:0x002b  */
    public final Observable<EmojiSet> getEmojiSet(final EmojiContext emojiContext, final boolean includeUnusableEmojis, final boolean includeUnavailableEmojis) {
        ScalarSynchronousObservable scalarSynchronousObservable;
        Observable observableG;
        Intrinsics3.checkNotNullParameter(emojiContext, "emojiContext");
        if (emojiContext instanceof EmojiContext.Chat) {
            EmojiContext.Chat chat = (EmojiContext.Chat) emojiContext;
            if (chat.getGuildId() != 0) {
                observableG = this.permissionsStore.observePermissionsForChannel(chat.getChannelId()).G(new Func1<Long, Boolean>() { // from class: com.discord.stores.StoreEmoji$getEmojiSet$hasExternalEmojiPermissionObservable$1
                    @Override // j0.k.Func1
                    public final Boolean call(Long l) {
                        return Boolean.valueOf(PermissionUtils.can(Permission.USE_EXTERNAL_EMOJIS, l));
                    }
                });
            } else {
                if (emojiContext instanceof EmojiContext.Guild) {
                    scalarSynchronousObservable = new ScalarSynchronousObservable(Boolean.FALSE);
                } else {
                    scalarSynchronousObservable = new ScalarSynchronousObservable(Boolean.TRUE);
                }
                observableG = scalarSynchronousObservable;
            }
        } else {
            if (emojiContext instanceof EmojiContext.Guild) {
                scalarSynchronousObservable = new ScalarSynchronousObservable(Boolean.FALSE);
            } else {
                scalarSynchronousObservable = new ScalarSynchronousObservable(Boolean.TRUE);
            }
            observableG = scalarSynchronousObservable;
        }
        Observable<EmojiSet> observableY = Observable.h(StoreUser.observeMe$default(this.userStore, false, 1, null).G(new Func1<MeUser, Boolean>() { // from class: com.discord.stores.StoreEmoji.getEmojiSet.1
            @Override // j0.k.Func1
            public final Boolean call(MeUser meUser) {
                UserUtils userUtils = UserUtils.INSTANCE;
                Intrinsics3.checkNotNullExpressionValue(meUser, "it");
                return Boolean.valueOf(userUtils.isPremium(meUser));
            }
        }), observableG, this.sortedGuildsStore.observeOrderedGuilds().G(new Func1<LinkedHashMap<Long, Guild>, List<? extends Long>>() { // from class: com.discord.stores.StoreEmoji.getEmojiSet.2
            @Override // j0.k.Func1
            public final List<Long> call(LinkedHashMap<Long, Guild> linkedHashMap) {
                Set<Long> setKeySet = linkedHashMap.keySet();
                Intrinsics3.checkNotNullExpressionValue(setKeySet, "it.keys");
                return _Collections.toList(setKeySet);
            }
        }), this.mediaFavoritesStore.observeFavorites(StoreMediaFavorites.Favorite.INSTANCE.getEmojiTypes()), new Func4<Boolean, Boolean, List<? extends Long>, Set<? extends StoreMediaFavorites.Favorite>, Quad<? extends Boolean, ? extends Boolean, ? extends List<? extends Long>, ? extends Set<? extends StoreMediaFavorites.Favorite>>>() { // from class: com.discord.stores.StoreEmoji.getEmojiSet.3
            @Override // rx.functions.Func4
            public /* bridge */ /* synthetic */ Quad<? extends Boolean, ? extends Boolean, ? extends List<? extends Long>, ? extends Set<? extends StoreMediaFavorites.Favorite>> call(Boolean bool, Boolean bool2, List<? extends Long> list, Set<? extends StoreMediaFavorites.Favorite> set) {
                return call2(bool, bool2, (List<Long>) list, set);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final Quad<Boolean, Boolean, List<Long>, Set<StoreMediaFavorites.Favorite>> call2(Boolean bool, Boolean bool2, List<Long> list, Set<? extends StoreMediaFavorites.Favorite> set) {
                return new Quad<>(bool, bool2, list, set);
            }
        }).r().Y(new Func1<Quad<? extends Boolean, ? extends Boolean, ? extends List<? extends Long>, ? extends Set<? extends StoreMediaFavorites.Favorite>>, Observable<? extends EmojiSet>>() { // from class: com.discord.stores.StoreEmoji.getEmojiSet.4
            @Override // j0.k.Func1
            public /* bridge */ /* synthetic */ Observable<? extends EmojiSet> call(Quad<? extends Boolean, ? extends Boolean, ? extends List<? extends Long>, ? extends Set<? extends StoreMediaFavorites.Favorite>> quad) {
                return call2((Quad<Boolean, Boolean, ? extends List<Long>, ? extends Set<? extends StoreMediaFavorites.Favorite>>) quad);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final Observable<? extends EmojiSet> call2(Quad<Boolean, Boolean, ? extends List<Long>, ? extends Set<? extends StoreMediaFavorites.Favorite>> quad) {
                final Boolean boolComponent1 = quad.component1();
                final Boolean boolComponent2 = quad.component2();
                final List<Long> listComponent3 = quad.component3();
                final Set<? extends StoreMediaFavorites.Favorite> setComponent4 = quad.component4();
                return ObservableExtensionsKt.computationLatest(StoreEmoji.this.customEmojiStore.observeAllowedGuildEmoji()).G(new Func1<Map<Long, ? extends Map<Long, ? extends ModelEmojiCustom>>, EmojiSet>() { // from class: com.discord.stores.StoreEmoji.getEmojiSet.4.1
                    @Override // j0.k.Func1
                    public final EmojiSet call(Map<Long, ? extends Map<Long, ? extends ModelEmojiCustom>> map) {
                        StoreEmoji storeEmoji = StoreEmoji.this;
                        Intrinsics3.checkNotNullExpressionValue(map, "allowedCustomEmoji");
                        EmojiContext emojiContext2 = emojiContext;
                        List list = listComponent3;
                        Intrinsics3.checkNotNullExpressionValue(list, "sortedGuildIds");
                        Boolean bool = boolComponent1;
                        Intrinsics3.checkNotNullExpressionValue(bool, "isPremium");
                        boolean zBooleanValue = bool.booleanValue();
                        AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                        boolean z2 = includeUnavailableEmojis;
                        boolean z3 = includeUnusableEmojis;
                        Boolean bool2 = boolComponent2;
                        Intrinsics3.checkNotNullExpressionValue(bool2, "hasExternalEmojiPermission");
                        boolean zBooleanValue2 = bool2.booleanValue();
                        Set set = setComponent4;
                        Intrinsics3.checkNotNullExpressionValue(set, "favorites");
                        return storeEmoji.buildUsableEmojiSet(map, emojiContext2, list, zBooleanValue, z3, z2, zBooleanValue2, set);
                    }
                });
            }
        });
        Intrinsics3.checkNotNullExpressionValue(observableY, "Observable\n        .comb…              }\n        }");
        return observableY;
    }
}
