package com.discord.stores;

import com.discord.api.channel.Channel;
import com.discord.api.emoji.GuildEmoji;
import com.discord.api.guild.Guild;
import com.discord.api.guild.GuildExplicitContentFilter;
import com.discord.api.guild.GuildFeature;
import com.discord.api.guild.GuildMaxVideoChannelUsers;
import com.discord.api.guildhash.GuildHash;
import com.discord.api.guildhash.GuildHashes;
import com.discord.api.guildmember.GuildMember;
import com.discord.api.presence.Presence;
import com.discord.api.role.GuildRole;
import com.discord.api.sticker.Sticker;
import com.discord.api.user.User;
import com.discord.models.domain.ModelPayload;
import com.discord.models.domain.ModelUserRelationship;
import com.discord.models.domain.emoji.ModelEmojiCustom;
import com.discord.utilities.guildhash.GuildHashUtilsKt;
import com.discord.utilities.guilds.GuildUtilsKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Triple;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p512d0.C11226f;
import p507d0.p580t.C12134g0;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12149o;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: ReadyPayloadUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ReadyPayloadUtils {
    public static final ReadyPayloadUtils INSTANCE = new ReadyPayloadUtils();
    private static final HashMap<Long, GuildCache> cache = new HashMap<>();

    /* JADX INFO: compiled from: ReadyPayloadUtils.kt */
    public static final /* data */ class GuildCache {
        private final List<Channel> channels;
        private final List<GuildEmoji> emojis;
        private final Guild guild;
        private final List<GuildRole> roles;
        private final List<Sticker> stickers;

        public GuildCache(Guild guild, List<GuildEmoji> list, List<Sticker> list2, List<Channel> list3, List<GuildRole> list4) {
            C12238m.checkNotNullParameter(guild, "guild");
            this.guild = guild;
            this.emojis = list;
            this.stickers = list2;
            this.channels = list3;
            this.roles = list4;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ GuildCache copy$default(GuildCache guildCache, Guild guild, List list, List list2, List list3, List list4, int i, Object obj) {
            if ((i & 1) != 0) {
                guild = guildCache.guild;
            }
            if ((i & 2) != 0) {
                list = guildCache.emojis;
            }
            List list5 = list;
            if ((i & 4) != 0) {
                list2 = guildCache.stickers;
            }
            List list6 = list2;
            if ((i & 8) != 0) {
                list3 = guildCache.channels;
            }
            List list7 = list3;
            if ((i & 16) != 0) {
                list4 = guildCache.roles;
            }
            return guildCache.copy(guild, list5, list6, list7, list4);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Guild getGuild() {
            return this.guild;
        }

        public final List<GuildEmoji> component2() {
            return this.emojis;
        }

        public final List<Sticker> component3() {
            return this.stickers;
        }

        public final List<Channel> component4() {
            return this.channels;
        }

        public final List<GuildRole> component5() {
            return this.roles;
        }

        public final GuildCache copy(Guild guild, List<GuildEmoji> emojis, List<Sticker> stickers, List<Channel> channels, List<GuildRole> roles) {
            C12238m.checkNotNullParameter(guild, "guild");
            return new GuildCache(guild, emojis, stickers, channels, roles);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof GuildCache)) {
                return false;
            }
            GuildCache guildCache = (GuildCache) other;
            return C12238m.areEqual(this.guild, guildCache.guild) && C12238m.areEqual(this.emojis, guildCache.emojis) && C12238m.areEqual(this.stickers, guildCache.stickers) && C12238m.areEqual(this.channels, guildCache.channels) && C12238m.areEqual(this.roles, guildCache.roles);
        }

        public final List<Channel> getChannels() {
            return this.channels;
        }

        public final List<GuildEmoji> getEmojis() {
            return this.emojis;
        }

        public final Guild getGuild() {
            return this.guild;
        }

        public final List<GuildRole> getRoles() {
            return this.roles;
        }

        public final List<Sticker> getStickers() {
            return this.stickers;
        }

        public int hashCode() {
            Guild guild = this.guild;
            int iHashCode = (guild != null ? guild.hashCode() : 0) * 31;
            List<GuildEmoji> list = this.emojis;
            int iHashCode2 = (iHashCode + (list != null ? list.hashCode() : 0)) * 31;
            List<Sticker> list2 = this.stickers;
            int iHashCode3 = (iHashCode2 + (list2 != null ? list2.hashCode() : 0)) * 31;
            List<Channel> list3 = this.channels;
            int iHashCode4 = (iHashCode3 + (list3 != null ? list3.hashCode() : 0)) * 31;
            List<GuildRole> list4 = this.roles;
            return iHashCode4 + (list4 != null ? list4.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("GuildCache(guild=");
            sbM833U.append(this.guild);
            sbM833U.append(", emojis=");
            sbM833U.append(this.emojis);
            sbM833U.append(", stickers=");
            sbM833U.append(this.stickers);
            sbM833U.append(", channels=");
            sbM833U.append(this.channels);
            sbM833U.append(", roles=");
            return C1643a.m824L(sbM833U, this.roles, ")");
        }
    }

    /* JADX INFO: compiled from: ReadyPayloadUtils.kt */
    public static abstract class HydrateGuildResult {

        /* JADX INFO: compiled from: ReadyPayloadUtils.kt */
        public static final class Error extends HydrateGuildResult {
            public static final Error INSTANCE = new Error();

            private Error() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: ReadyPayloadUtils.kt */
        public static final /* data */ class Success extends HydrateGuildResult {
            private final Guild guild;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Success(Guild guild) {
                super(null);
                C12238m.checkNotNullParameter(guild, "guild");
                this.guild = guild;
            }

            public static /* synthetic */ Success copy$default(Success success, Guild guild, int i, Object obj) {
                if ((i & 1) != 0) {
                    guild = success.guild;
                }
                return success.copy(guild);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final Guild getGuild() {
                return this.guild;
            }

            public final Success copy(Guild guild) {
                C12238m.checkNotNullParameter(guild, "guild");
                return new Success(guild);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Success) && C12238m.areEqual(this.guild, ((Success) other).guild);
                }
                return true;
            }

            public final Guild getGuild() {
                return this.guild;
            }

            public int hashCode() {
                Guild guild = this.guild;
                if (guild != null) {
                    return guild.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbM833U = C1643a.m833U("Success(guild=");
                sbM833U.append(this.guild);
                sbM833U.append(")");
                return sbM833U.toString();
            }
        }

        private HydrateGuildResult() {
        }

        public /* synthetic */ HydrateGuildResult(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: ReadyPayloadUtils.kt */
    public static abstract class HydrateResult {

        /* JADX INFO: compiled from: ReadyPayloadUtils.kt */
        public static final class Error extends HydrateResult {
            public static final Error INSTANCE = new Error();

            private Error() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: ReadyPayloadUtils.kt */
        public static final /* data */ class Success extends HydrateResult {
            private final ModelPayload payload;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Success(ModelPayload modelPayload) {
                super(null);
                C12238m.checkNotNullParameter(modelPayload, "payload");
                this.payload = modelPayload;
            }

            public static /* synthetic */ Success copy$default(Success success, ModelPayload modelPayload, int i, Object obj) {
                if ((i & 1) != 0) {
                    modelPayload = success.payload;
                }
                return success.copy(modelPayload);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final ModelPayload getPayload() {
                return this.payload;
            }

            public final Success copy(ModelPayload payload) {
                C12238m.checkNotNullParameter(payload, "payload");
                return new Success(payload);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Success) && C12238m.areEqual(this.payload, ((Success) other).payload);
                }
                return true;
            }

            public final ModelPayload getPayload() {
                return this.payload;
            }

            public int hashCode() {
                ModelPayload modelPayload = this.payload;
                if (modelPayload != null) {
                    return modelPayload.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbM833U = C1643a.m833U("Success(payload=");
                sbM833U.append(this.payload);
                sbM833U.append(")");
                return sbM833U.toString();
            }
        }

        private HydrateResult() {
        }

        public /* synthetic */ HydrateResult(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.ReadyPayloadUtils$hydrateGuild$6 */
    /* JADX INFO: compiled from: ReadyPayloadUtils.kt */
    public static final class C56696 extends AbstractC12240o implements Function2<Channel, Channel, Channel> {
        public static final C56696 INSTANCE = new C56696();

        public C56696() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Channel invoke(Channel channel, Channel channel2) {
            C12238m.checkNotNullParameter(channel, "channel");
            C12238m.checkNotNullParameter(channel2, "channelUpdate");
            return ReadyPayloadUtils.INSTANCE.hydrate(channel, channel2);
        }
    }

    private ReadyPayloadUtils() {
    }

    private final Channel hydrate(Channel channel, Channel channel2) {
        return (channel2 == null || channel2.getLastMessageId() == 0) ? channel : Channel.m7629a(channel, null, 0, 0L, null, channel2.getLastMessageId(), 0L, 0L, null, null, 0, null, 0, 0, null, 0L, 0L, null, false, 0L, null, 0, null, null, null, null, null, null, null, null, null, null, null, -17);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ HydrateGuildResult hydrateGuild$default(ReadyPayloadUtils readyPayloadUtils, Guild guild, List list, Map map, int i, Object obj) {
        if ((i & 2) != 0) {
            list = null;
        }
        if ((i & 4) != 0) {
            map = null;
        }
        return readyPayloadUtils.hydrateGuild(guild, list, map);
    }

    private final Presence hydratePresence(Presence presence, Map<Long, User> users) {
        User user;
        Long lM8158g = presence.getUserId();
        return (lM8158g == null || (user = users.get(lM8158g)) == null) ? Presence.m8152a(presence, null, null, null, null, null, null, 47) : Presence.m8152a(presence, null, null, null, user, null, null, 39);
    }

    public final HashMap<Long, GuildCache> getCache() {
        return cache;
    }

    /* JADX WARN: Code duplicated, block: B:37:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:44:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:51:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:58:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:65:0x00e0  */
    @StoreThread
    public final HydrateGuildResult hydrateGuild(Guild guild, List<Presence> presences, Map<Long, GuildMember> members) {
        Triple triple;
        Guild guild2;
        List<GuildEmoji> emojis;
        List<Sticker> stickers;
        List<Channel> channels;
        List<GuildRole> roles;
        C12238m.checkNotNullParameter(guild, "guild");
        GuildHashes guildHashesM7867n = guild.getGuildHashes();
        if (guildHashesM7867n == null || !GuildHashUtilsKt.isSupported(guildHashesM7867n)) {
            Boolean bool = Boolean.FALSE;
            triple = new Triple(bool, bool, bool);
        } else {
            GuildHash metadata = guildHashesM7867n.getMetadata();
            Boolean boolValueOf = Boolean.valueOf(metadata != null ? metadata.getOmitted() : false);
            GuildHash channels2 = guildHashesM7867n.getChannels();
            Boolean boolValueOf2 = Boolean.valueOf(channels2 != null ? channels2.getOmitted() : false);
            GuildHash roles2 = guildHashesM7867n.getRoles();
            triple = new Triple(boolValueOf, boolValueOf2, Boolean.valueOf(roles2 != null ? roles2.getOmitted() : false));
        }
        boolean zBooleanValue = ((Boolean) triple.component1()).booleanValue();
        boolean zBooleanValue2 = ((Boolean) triple.component2()).booleanValue();
        boolean zBooleanValue3 = ((Boolean) triple.component3()).booleanValue();
        if (guild.getUnavailable()) {
            return new HydrateGuildResult.Success(guild);
        }
        GuildCache guildCacheRemove = cache.remove(Long.valueOf(guild.getId()));
        if ((zBooleanValue || zBooleanValue2 || zBooleanValue3) && guildCacheRemove == null) {
            return HydrateGuildResult.Error.INSTANCE;
        }
        if (guildCacheRemove == null) {
            guild2 = null;
        } else {
            GuildCache guildCache = zBooleanValue ? guildCacheRemove : null;
            if (guildCache != null) {
                guild2 = guildCache.getGuild();
            } else {
                guild2 = null;
            }
        }
        if (guildCacheRemove == null) {
            emojis = null;
        } else {
            GuildCache guildCache2 = zBooleanValue ? guildCacheRemove : null;
            if (guildCache2 != null) {
                emojis = guildCache2.getEmojis();
            } else {
                emojis = null;
            }
        }
        if (guildCacheRemove == null) {
            stickers = null;
        } else {
            GuildCache guildCache3 = zBooleanValue ? guildCacheRemove : null;
            if (guildCache3 != null) {
                stickers = guildCache3.getStickers();
            } else {
                stickers = null;
            }
        }
        if (guildCacheRemove == null) {
            channels = null;
        } else {
            GuildCache guildCache4 = zBooleanValue2 ? guildCacheRemove : null;
            if (guildCache4 != null) {
                channels = guildCache4.getChannels();
            } else {
                channels = null;
            }
        }
        if (guildCacheRemove == null) {
            roles = null;
        } else {
            if (!zBooleanValue3) {
                guildCacheRemove = null;
            }
            if (guildCacheRemove != null) {
                roles = guildCacheRemove.getRoles();
            } else {
                roles = null;
            }
        }
        return new HydrateGuildResult.Success(hydrate(guild, guild2, emojis, stickers, channels, roles, presences, members, C56696.INSTANCE));
    }

    public final GuildMember hydrateGuildMember(GuildMember guildMember, Map<Long, User> users) {
        User user;
        C12238m.checkNotNullParameter(guildMember, "guildMember");
        C12238m.checkNotNullParameter(users, "users");
        return (guildMember.getUserId() == null || (user = users.get(guildMember.getUserId())) == null) ? guildMember : GuildMember.m7915a(guildMember, 0L, user, null, null, null, null, false, null, null, null, null, null, null, 7933);
    }

    @StoreThread
    public final HydrateResult hydrateReadyPayload(ModelPayload payload_, StoreGuilds storeGuilds, StoreChannels storeChannels, StoreEmojiCustom storeEmojiCustom, StoreGuildStickers storeGuildStickers) {
        LinkedHashMap linkedHashMap;
        List<GuildMember> list;
        ArrayList arrayList;
        C12238m.checkNotNullParameter(payload_, "payload_");
        C12238m.checkNotNullParameter(storeGuilds, "storeGuilds");
        C12238m.checkNotNullParameter(storeChannels, "storeChannels");
        C12238m.checkNotNullParameter(storeEmojiCustom, "storeEmojiCustom");
        C12238m.checkNotNullParameter(storeGuildStickers, "storeGuildStickers");
        ModelPayload modelPayloadHydrateUsers = hydrateUsers(payload_);
        Map<Long, Map<Long, GuildRole>> roles = storeGuilds.getRoles();
        Iterator<T> it = storeGuilds.getGuilds().values().iterator();
        while (true) {
            List list2 = null;
            if (!it.hasNext()) {
                break;
            }
            com.discord.models.guild.Guild guild = (com.discord.models.guild.Guild) it.next();
            Map map = (Map) C1643a.m847e(guild, roles);
            Collection collectionValues = map != null ? map.values() : null;
            Map<Long, Channel> channelsForGuildInternal$app_productionGoogleRelease = storeChannels.getChannelsForGuildInternal$app_productionGoogleRelease(guild.getId());
            Collection<Channel> collectionValues2 = channelsForGuildInternal$app_productionGoogleRelease != null ? channelsForGuildInternal$app_productionGoogleRelease.values() : null;
            Map<Long, ModelEmojiCustom> emojiForGuildInternal = storeEmojiCustom.getEmojiForGuildInternal(guild.getId());
            Collection<ModelEmojiCustom> collectionValues3 = emojiForGuildInternal != null ? emojiForGuildInternal.values() : null;
            Collection<Sticker> collectionValues4 = storeGuildStickers.getStickersForGuild(guild.getId()).values();
            HashMap<Long, GuildCache> map2 = cache;
            Long lValueOf = Long.valueOf(guild.getId());
            Guild guildCreateApiGuild = GuildUtilsKt.createApiGuild(guild);
            if (collectionValues3 != null) {
                ArrayList arrayList2 = new ArrayList(C12149o.collectionSizeOrDefault(collectionValues3, 10));
                Iterator<T> it2 = collectionValues3.iterator();
                while (it2.hasNext()) {
                    arrayList2.add(((ModelEmojiCustom) it2.next()).toApiEmoji());
                }
                arrayList = arrayList2;
            } else {
                arrayList = null;
            }
            List list3 = C12163u.toList(collectionValues4);
            List list4 = collectionValues2 != null ? C12163u.toList(collectionValues2) : null;
            if (collectionValues != null) {
                list2 = C12163u.toList(collectionValues);
            }
            map2.put(lValueOf, new GuildCache(guildCreateApiGuild, arrayList, list3, list4, list2));
        }
        ArrayList arrayList3 = new ArrayList();
        List<Guild> guilds = modelPayloadHydrateUsers.getGuilds();
        C12238m.checkNotNullExpressionValue(guilds, "payload.guilds");
        int i = 0;
        for (Object obj : guilds) {
            int i2 = i + 1;
            if (i < 0) {
                C12147n.throwIndexOverflow();
            }
            Guild guild2 = (Guild) obj;
            List<List<Presence>> guildPresences = modelPayloadHydrateUsers.getGuildPresences();
            List<Presence> list5 = guildPresences != null ? guildPresences.get(i) : null;
            List<List<GuildMember>> guildMembers = modelPayloadHydrateUsers.getGuildMembers();
            if (guildMembers == null || (list = guildMembers.get(i)) == null) {
                linkedHashMap = null;
            } else {
                linkedHashMap = new LinkedHashMap(C11226f.coerceAtLeast(C12134g0.mapCapacity(C12149o.collectionSizeOrDefault(list, 10)), 16));
                for (Object obj2 : list) {
                    linkedHashMap.put(Long.valueOf(((GuildMember) obj2).getUser().getId()), obj2);
                }
            }
            ReadyPayloadUtils readyPayloadUtils = INSTANCE;
            C12238m.checkNotNullExpressionValue(guild2, "guild");
            HydrateGuildResult hydrateGuildResultHydrateGuild = readyPayloadUtils.hydrateGuild(guild2, list5, linkedHashMap);
            if (!(hydrateGuildResultHydrateGuild instanceof HydrateGuildResult.Success)) {
                return HydrateResult.Error.INSTANCE;
            }
            arrayList3.add(((HydrateGuildResult.Success) hydrateGuildResultHydrateGuild).getGuild());
            i = i2;
        }
        ModelPayload modelPayloadWithGuilds = modelPayloadHydrateUsers.withGuilds(arrayList3);
        C12238m.checkNotNullExpressionValue(modelPayloadWithGuilds, "payload.withGuilds(guilds)");
        return new HydrateResult.Success(modelPayloadWithGuilds);
    }

    @StoreThread
    public final ModelPayload hydrateUsers(ModelPayload payload) {
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        ArrayList arrayList4;
        C12238m.checkNotNullParameter(payload, "payload");
        List<User> users = payload.getUsers();
        if (users == null) {
            return payload;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(C11226f.coerceAtLeast(C12134g0.mapCapacity(C12149o.collectionSizeOrDefault(users, 10)), 16));
        for (Object obj : users) {
            linkedHashMap.put(Long.valueOf(((User) obj).getId()), obj);
        }
        List<ModelUserRelationship> relationships = payload.getRelationships();
        ArrayList arrayList5 = null;
        if (relationships != null) {
            ArrayList arrayList6 = new ArrayList(C12149o.collectionSizeOrDefault(relationships, 10));
            Iterator<T> it = relationships.iterator();
            while (it.hasNext()) {
                arrayList6.add(((ModelUserRelationship) it.next()).hydrate(linkedHashMap));
            }
            arrayList = arrayList6;
        } else {
            arrayList = null;
        }
        List<Channel> privateChannels = payload.getPrivateChannels();
        if (privateChannels != null) {
            ArrayList arrayList7 = new ArrayList(C12149o.collectionSizeOrDefault(privateChannels, 10));
            for (Channel channel : privateChannels) {
                ReadyPayloadUtils readyPayloadUtils = INSTANCE;
                C12238m.checkNotNullExpressionValue(channel, "channel");
                arrayList7.add(readyPayloadUtils.hydrate(channel, linkedHashMap));
            }
            arrayList2 = arrayList7;
        } else {
            arrayList2 = null;
        }
        List<List<Presence>> guildPresences = payload.getGuildPresences();
        if (guildPresences != null) {
            ArrayList arrayList8 = new ArrayList(C12149o.collectionSizeOrDefault(guildPresences, 10));
            Iterator<T> it2 = guildPresences.iterator();
            while (it2.hasNext()) {
                List<Presence> list = (List) it2.next();
                C12238m.checkNotNullExpressionValue(list, "guildPresences");
                ArrayList arrayList9 = new ArrayList(C12149o.collectionSizeOrDefault(list, 10));
                for (Presence presence : list) {
                    ReadyPayloadUtils readyPayloadUtils2 = INSTANCE;
                    C12238m.checkNotNullExpressionValue(presence, "presence");
                    arrayList9.add(readyPayloadUtils2.hydratePresence(presence, linkedHashMap));
                }
                arrayList8.add(arrayList9);
            }
            arrayList3 = arrayList8;
        } else {
            arrayList3 = null;
        }
        List<Presence> presences = payload.getPresences();
        if (presences != null) {
            ArrayList arrayList10 = new ArrayList(C12149o.collectionSizeOrDefault(presences, 10));
            for (Presence presence2 : presences) {
                ReadyPayloadUtils readyPayloadUtils3 = INSTANCE;
                C12238m.checkNotNullExpressionValue(presence2, "presence");
                arrayList10.add(readyPayloadUtils3.hydratePresence(presence2, linkedHashMap));
            }
            arrayList4 = arrayList10;
        } else {
            arrayList4 = null;
        }
        List<List<GuildMember>> guildMembers = payload.getGuildMembers();
        if (guildMembers != null) {
            arrayList5 = new ArrayList(C12149o.collectionSizeOrDefault(guildMembers, 10));
            Iterator<T> it3 = guildMembers.iterator();
            while (it3.hasNext()) {
                List<GuildMember> list2 = (List) it3.next();
                C12238m.checkNotNullExpressionValue(list2, "members");
                ArrayList arrayList11 = new ArrayList(C12149o.collectionSizeOrDefault(list2, 10));
                for (GuildMember guildMember : list2) {
                    ReadyPayloadUtils readyPayloadUtils4 = INSTANCE;
                    C12238m.checkNotNullExpressionValue(guildMember, "member");
                    arrayList11.add(readyPayloadUtils4.hydrateGuildMember(guildMember, linkedHashMap));
                }
                arrayList5.add(arrayList11);
            }
        }
        ModelPayload modelPayloadWithHydratedUserData = payload.withHydratedUserData(arrayList, arrayList2, arrayList3, arrayList5, arrayList4);
        C12238m.checkNotNullExpressionValue(modelPayloadWithHydratedUserData, "payload.withHydratedUser…    friendPresences\n    )");
        return modelPayloadWithHydratedUserData;
    }

    private final Channel hydrate(Channel channel, Map<Long, User> map) {
        List<Long> listM7658y = channel.m7658y();
        if (listM7658y == null) {
            return channel;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = listM7658y.iterator();
        while (it.hasNext()) {
            User user = map.get(Long.valueOf(((Number) it.next()).longValue()));
            if (user != null) {
                arrayList.add(user);
            }
        }
        return Channel.m7629a(channel, null, 0, 0L, null, 0L, 0L, 0L, null, arrayList, 0, null, 0, 0, null, 0L, 0L, null, false, 0L, null, 0, null, null, null, null, null, null, null, null, null, null, null, -385);
    }

    public final Guild hydrate(Guild unhydratedGuild, Guild oldGuild, List<GuildEmoji> oldCustomEmojis, List<Sticker> oldStickers, List<Channel> oldChannels, List<GuildRole> oldRoles, List<Presence> presences, Map<Long, GuildMember> members, Function2<? super Channel, ? super Channel, Channel> onHydrateChannel) {
        Guild guildM7835a = unhydratedGuild;
        C12238m.checkNotNullParameter(guildM7835a, "unhydratedGuild");
        C12238m.checkNotNullParameter(onHydrateChannel, "onHydrateChannel");
        if (oldGuild != null) {
            Long lM7855b = oldGuild.getAfkChannelId();
            int iM7856c = oldGuild.getAfkTimeout();
            String strM7858e = oldGuild.getBanner();
            Integer numM7861h = oldGuild.getDefaultMessageNotifications();
            String strM7862i = oldGuild.getDescription();
            GuildExplicitContentFilter guildExplicitContentFilterM7865l = oldGuild.getExplicitContentFilter();
            List<GuildFeature> listM7866m = oldGuild.m7866m();
            String strM7870q = oldGuild.getIcon();
            GuildMaxVideoChannelUsers guildMaxVideoChannelUsersM7873t = oldGuild.getMaxVideoChannelUsers();
            int iM7876w = oldGuild.getMfaLevel();
            String strM7877x = oldGuild.getName();
            long jM7879z = oldGuild.getOwnerId();
            String strM7836A = oldGuild.getPreferredLocale();
            int iM7838C = oldGuild.getPremiumTier();
            Long lM7840E = oldGuild.getPublicUpdatesChannelId();
            String strM7841F = oldGuild.getRegion();
            Long lM7843H = oldGuild.getRulesChannelId();
            guildM7835a = Guild.m7835a(unhydratedGuild, null, null, null, strM7877x, strM7862i, numM7861h, 0L, strM7841F, jM7879z, strM7870q, oldGuild.getVerificationLevel(), guildExplicitContentFilterM7865l, null, null, null, null, false, iM7876w, iM7856c, lM7855b, oldGuild.getSystemChannelId(), listM7866m, 0, strM7858e, oldGuild.getSplash(), iM7838C, 0, oldGuild.getSystemChannelFlags(), null, lM7843H, lM7840E, strM7836A, null, guildMaxVideoChannelUsersM7873t, oldGuild.getVanityUrlCode(), 0, 0, null, null, null, null, false, null, null, null, null, 339865671, 16377);
        }
        if (oldCustomEmojis != null) {
            guildM7835a = Guild.m7835a(guildM7835a, null, oldCustomEmojis, null, null, null, null, 0L, null, 0L, null, null, null, null, null, null, null, false, 0, 0, null, null, null, 0, null, null, 0, 0, 0, null, null, null, null, null, null, null, 0, 0, null, null, null, null, false, null, null, null, null, -3, 16383);
        }
        Guild guildM7835a2 = guildM7835a;
        if (oldStickers != null) {
            guildM7835a2 = Guild.m7835a(guildM7835a2, null, null, oldStickers, null, null, null, 0L, null, 0L, null, null, null, null, null, null, null, false, 0, 0, null, null, null, 0, null, null, 0, 0, 0, null, null, null, null, null, null, null, 0, 0, null, null, null, null, false, null, null, null, null, -5, 16383);
        }
        Guild guildM7835a3 = guildM7835a2;
        if (oldChannels != null) {
            HashMap map = new HashMap();
            if (guildM7835a3.m7859f() != null) {
                List<Channel> listM7859f = guildM7835a3.m7859f();
                C12238m.checkNotNull(listM7859f);
                for (Channel channel : listM7859f) {
                    map.put(Long.valueOf(channel.getId()), channel);
                }
                guildM7835a3 = Guild.m7835a(guildM7835a3, null, null, null, null, null, null, 0L, null, 0L, null, null, null, null, null, null, null, false, 0, 0, null, null, null, 0, null, null, 0, 0, 0, null, null, null, null, null, null, null, 0, 0, null, null, null, null, false, null, null, null, null, -1, 16255);
            }
            Guild guild = guildM7835a3;
            ArrayList arrayList = new ArrayList();
            for (Channel channel2 : oldChannels) {
                Channel channel3 = (Channel) map.get(Long.valueOf(channel2.getId()));
                if (channel3 != null) {
                    arrayList.add(onHydrateChannel.invoke(channel2, channel3));
                } else {
                    arrayList.add(channel2);
                }
            }
            guildM7835a3 = Guild.m7835a(guild, null, null, null, null, null, null, 0L, null, 0L, null, null, null, null, arrayList, null, null, false, 0, 0, null, null, null, 0, null, null, 0, 0, 0, null, null, null, null, null, null, null, 0, 0, null, null, null, null, false, null, null, null, null, -8193, 16383);
        }
        Guild guildM7835a4 = guildM7835a3;
        if (oldRoles != null) {
            guildM7835a4 = Guild.m7835a(guildM7835a4, oldRoles, null, null, null, null, null, 0L, null, 0L, null, null, null, null, null, null, null, false, 0, 0, null, null, null, 0, null, null, 0, 0, 0, null, null, null, null, null, null, null, 0, 0, null, null, null, null, false, null, null, null, null, -2, 16383);
        }
        Guild guildM7835a5 = guildM7835a4;
        if (presences != null) {
            guildM7835a5 = Guild.m7835a(guildM7835a5, null, null, null, null, null, null, 0L, null, 0L, null, null, null, presences, null, null, null, false, 0, 0, null, null, null, 0, null, null, 0, 0, 0, null, null, null, null, null, null, null, 0, 0, null, null, null, null, false, null, null, null, null, -4097, 16383);
        }
        Guild guild2 = guildM7835a5;
        return members != null ? Guild.m7835a(guild2, null, null, null, null, null, null, 0L, null, 0L, null, null, null, null, null, C12163u.toList(members.values()), null, false, 0, 0, null, null, null, 0, null, null, 0, 0, 0, null, null, null, null, null, null, null, 0, 0, null, null, null, null, false, null, null, null, null, -16385, 16383) : guild2;
    }
}
