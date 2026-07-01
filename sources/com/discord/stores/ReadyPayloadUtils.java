package com.discord.stores;

import b.d.b.a.a;
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
import d0.d0.f;
import d0.t.g0;
import d0.t.n;
import d0.t.o;
import d0.t.u;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Triple;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: ReadyPayloadUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ReadyPayloadUtils {
    public static final ReadyPayloadUtils INSTANCE = new ReadyPayloadUtils();
    private static final HashMap<Long, ReadyPayloadUtils$GuildCache> cache = new HashMap<>();

    private ReadyPayloadUtils() {
    }

    public static final /* synthetic */ Channel access$hydrate(ReadyPayloadUtils readyPayloadUtils, Channel channel, Channel channel2) {
        return readyPayloadUtils.hydrate(channel, channel2);
    }

    private final Channel hydrate(Channel channel, Channel channel2) {
        return (channel2 == null || channel2.getLastMessageId() == 0) ? channel : Channel.a(channel, null, 0, 0L, null, channel2.getLastMessageId(), 0L, 0L, null, null, 0, null, 0, 0, null, 0L, 0L, null, false, 0L, null, 0, null, null, null, null, null, null, null, null, null, null, null, -17);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ReadyPayloadUtils$HydrateGuildResult hydrateGuild$default(ReadyPayloadUtils readyPayloadUtils, Guild guild, List list, Map map, int i, Object obj) {
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
        Long userId = presence.getUserId();
        return (userId == null || (user = users.get(userId)) == null) ? Presence.a(presence, null, null, null, null, null, null, 47) : Presence.a(presence, null, null, null, user, null, null, 39);
    }

    public final HashMap<Long, ReadyPayloadUtils$GuildCache> getCache() {
        return cache;
    }

    /* JADX WARN: Code duplicated, block: B:37:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:44:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:51:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:58:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:65:0x00e0  */
    @StoreThread
    public final ReadyPayloadUtils$HydrateGuildResult hydrateGuild(Guild guild, List<Presence> presences, Map<Long, GuildMember> members) {
        Triple triple;
        Guild guild2;
        List<GuildEmoji> emojis;
        List<Sticker> stickers;
        List<Channel> channels;
        List<GuildRole> roles;
        m.checkNotNullParameter(guild, "guild");
        GuildHashes guildHashes = guild.getGuildHashes();
        if (guildHashes == null || !GuildHashUtilsKt.isSupported(guildHashes)) {
            Boolean bool = Boolean.FALSE;
            triple = new Triple(bool, bool, bool);
        } else {
            GuildHash metadata = guildHashes.getMetadata();
            Boolean boolValueOf = Boolean.valueOf(metadata != null ? metadata.getOmitted() : false);
            GuildHash channels2 = guildHashes.getChannels();
            Boolean boolValueOf2 = Boolean.valueOf(channels2 != null ? channels2.getOmitted() : false);
            GuildHash roles2 = guildHashes.getRoles();
            triple = new Triple(boolValueOf, boolValueOf2, Boolean.valueOf(roles2 != null ? roles2.getOmitted() : false));
        }
        boolean zBooleanValue = ((Boolean) triple.component1()).booleanValue();
        boolean zBooleanValue2 = ((Boolean) triple.component2()).booleanValue();
        boolean zBooleanValue3 = ((Boolean) triple.component3()).booleanValue();
        if (guild.getUnavailable()) {
            return new ReadyPayloadUtils$HydrateGuildResult$Success(guild);
        }
        ReadyPayloadUtils$GuildCache readyPayloadUtils$GuildCacheRemove = cache.remove(Long.valueOf(guild.getId()));
        if ((zBooleanValue || zBooleanValue2 || zBooleanValue3) && readyPayloadUtils$GuildCacheRemove == null) {
            return ReadyPayloadUtils$HydrateGuildResult$Error.INSTANCE;
        }
        if (readyPayloadUtils$GuildCacheRemove == null) {
            guild2 = null;
        } else {
            ReadyPayloadUtils$GuildCache readyPayloadUtils$GuildCache = zBooleanValue ? readyPayloadUtils$GuildCacheRemove : null;
            if (readyPayloadUtils$GuildCache != null) {
                guild2 = readyPayloadUtils$GuildCache.getGuild();
            } else {
                guild2 = null;
            }
        }
        if (readyPayloadUtils$GuildCacheRemove == null) {
            emojis = null;
        } else {
            ReadyPayloadUtils$GuildCache readyPayloadUtils$GuildCache2 = zBooleanValue ? readyPayloadUtils$GuildCacheRemove : null;
            if (readyPayloadUtils$GuildCache2 != null) {
                emojis = readyPayloadUtils$GuildCache2.getEmojis();
            } else {
                emojis = null;
            }
        }
        if (readyPayloadUtils$GuildCacheRemove == null) {
            stickers = null;
        } else {
            ReadyPayloadUtils$GuildCache readyPayloadUtils$GuildCache3 = zBooleanValue ? readyPayloadUtils$GuildCacheRemove : null;
            if (readyPayloadUtils$GuildCache3 != null) {
                stickers = readyPayloadUtils$GuildCache3.getStickers();
            } else {
                stickers = null;
            }
        }
        if (readyPayloadUtils$GuildCacheRemove == null) {
            channels = null;
        } else {
            ReadyPayloadUtils$GuildCache readyPayloadUtils$GuildCache4 = zBooleanValue2 ? readyPayloadUtils$GuildCacheRemove : null;
            if (readyPayloadUtils$GuildCache4 != null) {
                channels = readyPayloadUtils$GuildCache4.getChannels();
            } else {
                channels = null;
            }
        }
        if (readyPayloadUtils$GuildCacheRemove == null) {
            roles = null;
        } else {
            if (!zBooleanValue3) {
                readyPayloadUtils$GuildCacheRemove = null;
            }
            if (readyPayloadUtils$GuildCacheRemove != null) {
                roles = readyPayloadUtils$GuildCacheRemove.getRoles();
            } else {
                roles = null;
            }
        }
        return new ReadyPayloadUtils$HydrateGuildResult$Success(hydrate(guild, guild2, emojis, stickers, channels, roles, presences, members, ReadyPayloadUtils$hydrateGuild$6.INSTANCE));
    }

    public final GuildMember hydrateGuildMember(GuildMember guildMember, Map<Long, User> users) {
        User user;
        m.checkNotNullParameter(guildMember, "guildMember");
        m.checkNotNullParameter(users, "users");
        return (guildMember.getUserId() == null || (user = users.get(guildMember.getUserId())) == null) ? guildMember : GuildMember.a(guildMember, 0L, user, null, null, null, null, false, null, null, null, null, null, null, 7933);
    }

    @StoreThread
    public final ReadyPayloadUtils$HydrateResult hydrateReadyPayload(ModelPayload payload_, StoreGuilds storeGuilds, StoreChannels storeChannels, StoreEmojiCustom storeEmojiCustom, StoreGuildStickers storeGuildStickers) {
        LinkedHashMap linkedHashMap;
        List<GuildMember> list;
        ArrayList arrayList;
        m.checkNotNullParameter(payload_, "payload_");
        m.checkNotNullParameter(storeGuilds, "storeGuilds");
        m.checkNotNullParameter(storeChannels, "storeChannels");
        m.checkNotNullParameter(storeEmojiCustom, "storeEmojiCustom");
        m.checkNotNullParameter(storeGuildStickers, "storeGuildStickers");
        ModelPayload modelPayloadHydrateUsers = hydrateUsers(payload_);
        Map<Long, Map<Long, GuildRole>> roles = storeGuilds.getRoles();
        Iterator<T> it = storeGuilds.getGuilds().values().iterator();
        while (true) {
            List list2 = null;
            if (!it.hasNext()) {
                break;
            }
            com.discord.models.guild.Guild guild = (com.discord.models.guild.Guild) it.next();
            Map map = (Map) a.e(guild, roles);
            Collection collectionValues = map != null ? map.values() : null;
            Map<Long, Channel> channelsForGuildInternal$app_productionGoogleRelease = storeChannels.getChannelsForGuildInternal$app_productionGoogleRelease(guild.getId());
            Collection<Channel> collectionValues2 = channelsForGuildInternal$app_productionGoogleRelease != null ? channelsForGuildInternal$app_productionGoogleRelease.values() : null;
            Map<Long, ModelEmojiCustom> emojiForGuildInternal = storeEmojiCustom.getEmojiForGuildInternal(guild.getId());
            Collection<ModelEmojiCustom> collectionValues3 = emojiForGuildInternal != null ? emojiForGuildInternal.values() : null;
            Collection<Sticker> collectionValues4 = storeGuildStickers.getStickersForGuild(guild.getId()).values();
            HashMap<Long, ReadyPayloadUtils$GuildCache> map2 = cache;
            Long lValueOf = Long.valueOf(guild.getId());
            Guild guildCreateApiGuild = GuildUtilsKt.createApiGuild(guild);
            if (collectionValues3 != null) {
                ArrayList arrayList2 = new ArrayList(o.collectionSizeOrDefault(collectionValues3, 10));
                Iterator<T> it2 = collectionValues3.iterator();
                while (it2.hasNext()) {
                    arrayList2.add(((ModelEmojiCustom) it2.next()).toApiEmoji());
                }
                arrayList = arrayList2;
            } else {
                arrayList = null;
            }
            List list3 = u.toList(collectionValues4);
            List list4 = collectionValues2 != null ? u.toList(collectionValues2) : null;
            if (collectionValues != null) {
                list2 = u.toList(collectionValues);
            }
            map2.put(lValueOf, new ReadyPayloadUtils$GuildCache(guildCreateApiGuild, arrayList, list3, list4, list2));
        }
        ArrayList arrayList3 = new ArrayList();
        List<Guild> guilds = modelPayloadHydrateUsers.getGuilds();
        m.checkNotNullExpressionValue(guilds, "payload.guilds");
        int i = 0;
        for (Object obj : guilds) {
            int i2 = i + 1;
            if (i < 0) {
                n.throwIndexOverflow();
            }
            Guild guild2 = (Guild) obj;
            List<List<Presence>> guildPresences = modelPayloadHydrateUsers.getGuildPresences();
            List<Presence> list5 = guildPresences != null ? guildPresences.get(i) : null;
            List<List<GuildMember>> guildMembers = modelPayloadHydrateUsers.getGuildMembers();
            if (guildMembers == null || (list = guildMembers.get(i)) == null) {
                linkedHashMap = null;
            } else {
                linkedHashMap = new LinkedHashMap(f.coerceAtLeast(g0.mapCapacity(o.collectionSizeOrDefault(list, 10)), 16));
                for (Object obj2 : list) {
                    linkedHashMap.put(Long.valueOf(((GuildMember) obj2).getUser().getId()), obj2);
                }
            }
            ReadyPayloadUtils readyPayloadUtils = INSTANCE;
            m.checkNotNullExpressionValue(guild2, "guild");
            ReadyPayloadUtils$HydrateGuildResult readyPayloadUtils$HydrateGuildResultHydrateGuild = readyPayloadUtils.hydrateGuild(guild2, list5, linkedHashMap);
            if (!(readyPayloadUtils$HydrateGuildResultHydrateGuild instanceof ReadyPayloadUtils$HydrateGuildResult$Success)) {
                return ReadyPayloadUtils$HydrateResult$Error.INSTANCE;
            }
            arrayList3.add(((ReadyPayloadUtils$HydrateGuildResult$Success) readyPayloadUtils$HydrateGuildResultHydrateGuild).getGuild());
            i = i2;
        }
        ModelPayload modelPayloadWithGuilds = modelPayloadHydrateUsers.withGuilds(arrayList3);
        m.checkNotNullExpressionValue(modelPayloadWithGuilds, "payload.withGuilds(guilds)");
        return new ReadyPayloadUtils$HydrateResult$Success(modelPayloadWithGuilds);
    }

    @StoreThread
    public final ModelPayload hydrateUsers(ModelPayload payload) {
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        ArrayList arrayList4;
        m.checkNotNullParameter(payload, "payload");
        List<User> users = payload.getUsers();
        if (users == null) {
            return payload;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(f.coerceAtLeast(g0.mapCapacity(o.collectionSizeOrDefault(users, 10)), 16));
        for (Object obj : users) {
            linkedHashMap.put(Long.valueOf(((User) obj).getId()), obj);
        }
        List<ModelUserRelationship> relationships = payload.getRelationships();
        ArrayList arrayList5 = null;
        if (relationships != null) {
            ArrayList arrayList6 = new ArrayList(o.collectionSizeOrDefault(relationships, 10));
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
            ArrayList arrayList7 = new ArrayList(o.collectionSizeOrDefault(privateChannels, 10));
            for (Channel channel : privateChannels) {
                ReadyPayloadUtils readyPayloadUtils = INSTANCE;
                m.checkNotNullExpressionValue(channel, "channel");
                arrayList7.add(readyPayloadUtils.hydrate(channel, linkedHashMap));
            }
            arrayList2 = arrayList7;
        } else {
            arrayList2 = null;
        }
        List<List<Presence>> guildPresences = payload.getGuildPresences();
        if (guildPresences != null) {
            ArrayList arrayList8 = new ArrayList(o.collectionSizeOrDefault(guildPresences, 10));
            Iterator<T> it2 = guildPresences.iterator();
            while (it2.hasNext()) {
                List<Presence> list = (List) it2.next();
                m.checkNotNullExpressionValue(list, "guildPresences");
                ArrayList arrayList9 = new ArrayList(o.collectionSizeOrDefault(list, 10));
                for (Presence presence : list) {
                    ReadyPayloadUtils readyPayloadUtils2 = INSTANCE;
                    m.checkNotNullExpressionValue(presence, "presence");
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
            ArrayList arrayList10 = new ArrayList(o.collectionSizeOrDefault(presences, 10));
            for (Presence presence2 : presences) {
                ReadyPayloadUtils readyPayloadUtils3 = INSTANCE;
                m.checkNotNullExpressionValue(presence2, "presence");
                arrayList10.add(readyPayloadUtils3.hydratePresence(presence2, linkedHashMap));
            }
            arrayList4 = arrayList10;
        } else {
            arrayList4 = null;
        }
        List<List<GuildMember>> guildMembers = payload.getGuildMembers();
        if (guildMembers != null) {
            arrayList5 = new ArrayList(o.collectionSizeOrDefault(guildMembers, 10));
            Iterator<T> it3 = guildMembers.iterator();
            while (it3.hasNext()) {
                List<GuildMember> list2 = (List) it3.next();
                m.checkNotNullExpressionValue(list2, "members");
                ArrayList arrayList11 = new ArrayList(o.collectionSizeOrDefault(list2, 10));
                for (GuildMember guildMember : list2) {
                    ReadyPayloadUtils readyPayloadUtils4 = INSTANCE;
                    m.checkNotNullExpressionValue(guildMember, "member");
                    arrayList11.add(readyPayloadUtils4.hydrateGuildMember(guildMember, linkedHashMap));
                }
                arrayList5.add(arrayList11);
            }
        }
        ModelPayload modelPayloadWithHydratedUserData = payload.withHydratedUserData(arrayList, arrayList2, arrayList3, arrayList5, arrayList4);
        m.checkNotNullExpressionValue(modelPayloadWithHydratedUserData, "payload.withHydratedUser…    friendPresences\n    )");
        return modelPayloadWithHydratedUserData;
    }

    private final Channel hydrate(Channel channel, Map<Long, User> map) {
        List<Long> listY = channel.y();
        if (listY == null) {
            return channel;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = listY.iterator();
        while (it.hasNext()) {
            User user = map.get(Long.valueOf(((Number) it.next()).longValue()));
            if (user != null) {
                arrayList.add(user);
            }
        }
        return Channel.a(channel, null, 0, 0L, null, 0L, 0L, 0L, null, arrayList, 0, null, 0, 0, null, 0L, 0L, null, false, 0L, null, 0, null, null, null, null, null, null, null, null, null, null, null, -385);
    }

    public final Guild hydrate(Guild unhydratedGuild, Guild oldGuild, List<GuildEmoji> oldCustomEmojis, List<Sticker> oldStickers, List<Channel> oldChannels, List<GuildRole> oldRoles, List<Presence> presences, Map<Long, GuildMember> members, Function2<? super Channel, ? super Channel, Channel> onHydrateChannel) {
        Guild guildA = unhydratedGuild;
        m.checkNotNullParameter(guildA, "unhydratedGuild");
        m.checkNotNullParameter(onHydrateChannel, "onHydrateChannel");
        if (oldGuild != null) {
            Long afkChannelId = oldGuild.getAfkChannelId();
            int afkTimeout = oldGuild.getAfkTimeout();
            String banner = oldGuild.getBanner();
            Integer defaultMessageNotifications = oldGuild.getDefaultMessageNotifications();
            String description = oldGuild.getDescription();
            GuildExplicitContentFilter explicitContentFilter = oldGuild.getExplicitContentFilter();
            List<GuildFeature> listM = oldGuild.m();
            String icon = oldGuild.getIcon();
            GuildMaxVideoChannelUsers maxVideoChannelUsers = oldGuild.getMaxVideoChannelUsers();
            int mfaLevel = oldGuild.getMfaLevel();
            String name = oldGuild.getName();
            long ownerId = oldGuild.getOwnerId();
            String preferredLocale = oldGuild.getPreferredLocale();
            int premiumTier = oldGuild.getPremiumTier();
            Long publicUpdatesChannelId = oldGuild.getPublicUpdatesChannelId();
            String region = oldGuild.getRegion();
            Long rulesChannelId = oldGuild.getRulesChannelId();
            guildA = Guild.a(unhydratedGuild, null, null, null, name, description, defaultMessageNotifications, 0L, region, ownerId, icon, oldGuild.getVerificationLevel(), explicitContentFilter, null, null, null, null, false, mfaLevel, afkTimeout, afkChannelId, oldGuild.getSystemChannelId(), listM, 0, banner, oldGuild.getSplash(), premiumTier, 0, oldGuild.getSystemChannelFlags(), null, rulesChannelId, publicUpdatesChannelId, preferredLocale, null, maxVideoChannelUsers, oldGuild.getVanityUrlCode(), 0, 0, null, null, null, null, false, null, null, null, null, 339865671, 16377);
        }
        if (oldCustomEmojis != null) {
            guildA = Guild.a(guildA, null, oldCustomEmojis, null, null, null, null, 0L, null, 0L, null, null, null, null, null, null, null, false, 0, 0, null, null, null, 0, null, null, 0, 0, 0, null, null, null, null, null, null, null, 0, 0, null, null, null, null, false, null, null, null, null, -3, 16383);
        }
        Guild guildA2 = guildA;
        if (oldStickers != null) {
            guildA2 = Guild.a(guildA2, null, null, oldStickers, null, null, null, 0L, null, 0L, null, null, null, null, null, null, null, false, 0, 0, null, null, null, 0, null, null, 0, 0, 0, null, null, null, null, null, null, null, 0, 0, null, null, null, null, false, null, null, null, null, -5, 16383);
        }
        Guild guildA3 = guildA2;
        if (oldChannels != null) {
            HashMap map = new HashMap();
            if (guildA3.f() != null) {
                List<Channel> listF = guildA3.f();
                m.checkNotNull(listF);
                for (Channel channel : listF) {
                    map.put(Long.valueOf(channel.getId()), channel);
                }
                guildA3 = Guild.a(guildA3, null, null, null, null, null, null, 0L, null, 0L, null, null, null, null, null, null, null, false, 0, 0, null, null, null, 0, null, null, 0, 0, 0, null, null, null, null, null, null, null, 0, 0, null, null, null, null, false, null, null, null, null, -1, 16255);
            }
            Guild guild = guildA3;
            ArrayList arrayList = new ArrayList();
            for (Channel channel2 : oldChannels) {
                Channel channel3 = (Channel) map.get(Long.valueOf(channel2.getId()));
                if (channel3 != null) {
                    arrayList.add(onHydrateChannel.invoke(channel2, channel3));
                } else {
                    arrayList.add(channel2);
                }
            }
            guildA3 = Guild.a(guild, null, null, null, null, null, null, 0L, null, 0L, null, null, null, null, arrayList, null, null, false, 0, 0, null, null, null, 0, null, null, 0, 0, 0, null, null, null, null, null, null, null, 0, 0, null, null, null, null, false, null, null, null, null, -8193, 16383);
        }
        Guild guildA4 = guildA3;
        if (oldRoles != null) {
            guildA4 = Guild.a(guildA4, oldRoles, null, null, null, null, null, 0L, null, 0L, null, null, null, null, null, null, null, false, 0, 0, null, null, null, 0, null, null, 0, 0, 0, null, null, null, null, null, null, null, 0, 0, null, null, null, null, false, null, null, null, null, -2, 16383);
        }
        Guild guildA5 = guildA4;
        if (presences != null) {
            guildA5 = Guild.a(guildA5, null, null, null, null, null, null, 0L, null, 0L, null, null, null, presences, null, null, null, false, 0, 0, null, null, null, 0, null, null, 0, 0, 0, null, null, null, null, null, null, null, 0, 0, null, null, null, null, false, null, null, null, null, -4097, 16383);
        }
        Guild guild2 = guildA5;
        return members != null ? Guild.a(guild2, null, null, null, null, null, null, 0L, null, 0L, null, null, null, null, null, u.toList(members.values()), null, false, 0, 0, null, null, null, 0, null, null, 0, 0, 0, null, null, null, null, null, null, null, 0, 0, null, null, null, null, false, null, null, null, null, -16385, 16383) : guild2;
    }
}
