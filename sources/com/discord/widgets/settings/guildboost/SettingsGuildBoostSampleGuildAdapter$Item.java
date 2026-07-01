package com.discord.widgets.settings.guildboost;

import b.d.b.a.a;
import com.discord.models.guild.Guild;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import d0.z.d.m;

/* JADX INFO: compiled from: SettingsGuildBoostSampleGuildAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class SettingsGuildBoostSampleGuildAdapter$Item implements MGRecyclerDataPayload {
    public static final SettingsGuildBoostSampleGuildAdapter$Item$Companion Companion = new SettingsGuildBoostSampleGuildAdapter$Item$Companion(null);
    public static final int TYPE_GUILD = 1;
    private final Guild guild;
    private final String key;
    private final int type;

    public SettingsGuildBoostSampleGuildAdapter$Item(Guild guild) {
        m.checkNotNullParameter(guild, "guild");
        this.guild = guild;
        this.type = 1;
        this.key = String.valueOf(guild.getId());
    }

    public static /* synthetic */ SettingsGuildBoostSampleGuildAdapter$Item copy$default(SettingsGuildBoostSampleGuildAdapter$Item settingsGuildBoostSampleGuildAdapter$Item, Guild guild, int i, Object obj) {
        if ((i & 1) != 0) {
            guild = settingsGuildBoostSampleGuildAdapter$Item.guild;
        }
        return settingsGuildBoostSampleGuildAdapter$Item.copy(guild);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Guild getGuild() {
        return this.guild;
    }

    public final SettingsGuildBoostSampleGuildAdapter$Item copy(Guild guild) {
        m.checkNotNullParameter(guild, "guild");
        return new SettingsGuildBoostSampleGuildAdapter$Item(guild);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof SettingsGuildBoostSampleGuildAdapter$Item) && m.areEqual(this.guild, ((SettingsGuildBoostSampleGuildAdapter$Item) other).guild);
        }
        return true;
    }

    public final Guild getGuild() {
        return this.guild;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    public int hashCode() {
        Guild guild = this.guild;
        if (guild != null) {
            return guild.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sbU = a.U("Item(guild=");
        sbU.append(this.guild);
        sbU.append(")");
        return sbU.toString();
    }
}
