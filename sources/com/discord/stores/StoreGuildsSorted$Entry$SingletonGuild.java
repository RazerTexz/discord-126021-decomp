package com.discord.stores;

import b.d.b.a.a;
import com.discord.models.domain.ModelGuildFolder;
import com.discord.models.guild.Guild;
import d0.z.d.m;

/* JADX INFO: compiled from: StoreGuildsSorted.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class StoreGuildsSorted$Entry$SingletonGuild extends StoreGuildsSorted$Entry {
    private final Guild guild;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreGuildsSorted$Entry$SingletonGuild(Guild guild) {
        super(null);
        m.checkNotNullParameter(guild, "guild");
        this.guild = guild;
    }

    public static /* synthetic */ StoreGuildsSorted$Entry$SingletonGuild copy$default(StoreGuildsSorted$Entry$SingletonGuild storeGuildsSorted$Entry$SingletonGuild, Guild guild, int i, Object obj) {
        if ((i & 1) != 0) {
            guild = storeGuildsSorted$Entry$SingletonGuild.guild;
        }
        return storeGuildsSorted$Entry$SingletonGuild.copy(guild);
    }

    @Override // com.discord.stores.StoreGuildsSorted$Entry
    public ModelGuildFolder asModelGuildFolder() {
        return new ModelGuildFolder(null, d0.t.m.listOf(Long.valueOf(this.guild.getId())), null, null, 8, null);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Guild getGuild() {
        return this.guild;
    }

    public final StoreGuildsSorted$Entry$SingletonGuild copy(Guild guild) {
        m.checkNotNullParameter(guild, "guild");
        return new StoreGuildsSorted$Entry$SingletonGuild(guild);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof StoreGuildsSorted$Entry$SingletonGuild) && m.areEqual(this.guild, ((StoreGuildsSorted$Entry$SingletonGuild) other).guild);
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
        StringBuilder sbU = a.U("SingletonGuild(guild=");
        sbU.append(this.guild);
        sbU.append(")");
        return sbU.toString();
    }
}
