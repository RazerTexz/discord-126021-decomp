package com.discord.stores;

import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.api.emoji.GuildEmoji;
import com.discord.api.guild.Guild;
import com.discord.api.role.GuildRole;
import com.discord.api.sticker.Sticker;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: ReadyPayloadUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class ReadyPayloadUtils$GuildCache {
    private final List<Channel> channels;
    private final List<GuildEmoji> emojis;
    private final Guild guild;
    private final List<GuildRole> roles;
    private final List<Sticker> stickers;

    public ReadyPayloadUtils$GuildCache(Guild guild, List<GuildEmoji> list, List<Sticker> list2, List<Channel> list3, List<GuildRole> list4) {
        m.checkNotNullParameter(guild, "guild");
        this.guild = guild;
        this.emojis = list;
        this.stickers = list2;
        this.channels = list3;
        this.roles = list4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ReadyPayloadUtils$GuildCache copy$default(ReadyPayloadUtils$GuildCache readyPayloadUtils$GuildCache, Guild guild, List list, List list2, List list3, List list4, int i, Object obj) {
        if ((i & 1) != 0) {
            guild = readyPayloadUtils$GuildCache.guild;
        }
        if ((i & 2) != 0) {
            list = readyPayloadUtils$GuildCache.emojis;
        }
        List list5 = list;
        if ((i & 4) != 0) {
            list2 = readyPayloadUtils$GuildCache.stickers;
        }
        List list6 = list2;
        if ((i & 8) != 0) {
            list3 = readyPayloadUtils$GuildCache.channels;
        }
        List list7 = list3;
        if ((i & 16) != 0) {
            list4 = readyPayloadUtils$GuildCache.roles;
        }
        return readyPayloadUtils$GuildCache.copy(guild, list5, list6, list7, list4);
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

    public final ReadyPayloadUtils$GuildCache copy(Guild guild, List<GuildEmoji> emojis, List<Sticker> stickers, List<Channel> channels, List<GuildRole> roles) {
        m.checkNotNullParameter(guild, "guild");
        return new ReadyPayloadUtils$GuildCache(guild, emojis, stickers, channels, roles);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ReadyPayloadUtils$GuildCache)) {
            return false;
        }
        ReadyPayloadUtils$GuildCache readyPayloadUtils$GuildCache = (ReadyPayloadUtils$GuildCache) other;
        return m.areEqual(this.guild, readyPayloadUtils$GuildCache.guild) && m.areEqual(this.emojis, readyPayloadUtils$GuildCache.emojis) && m.areEqual(this.stickers, readyPayloadUtils$GuildCache.stickers) && m.areEqual(this.channels, readyPayloadUtils$GuildCache.channels) && m.areEqual(this.roles, readyPayloadUtils$GuildCache.roles);
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
        StringBuilder sbU = a.U("GuildCache(guild=");
        sbU.append(this.guild);
        sbU.append(", emojis=");
        sbU.append(this.emojis);
        sbU.append(", stickers=");
        sbU.append(this.stickers);
        sbU.append(", channels=");
        sbU.append(this.channels);
        sbU.append(", roles=");
        return a.L(sbU, this.roles, ")");
    }
}
