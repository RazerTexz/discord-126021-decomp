package com.discord.widgets.settings.guildboost;

import b.d.b.a.a;
import com.discord.models.guild.Guild;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetSettingsGuildBoostSubscriptionAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetSettingsGuildBoostSubscriptionAdapter$Item$GuildItem extends WidgetSettingsGuildBoostSubscriptionAdapter$Item {
    private final int boostCount;
    private final Guild guild;
    private final String key;
    private final int type;

    public WidgetSettingsGuildBoostSubscriptionAdapter$Item$GuildItem(Guild guild, int i) {
        super(null);
        this.guild = guild;
        this.boostCount = i;
        this.key = String.valueOf(guild != null ? Long.valueOf(guild.getId()) : null);
    }

    public static /* synthetic */ WidgetSettingsGuildBoostSubscriptionAdapter$Item$GuildItem copy$default(WidgetSettingsGuildBoostSubscriptionAdapter$Item$GuildItem widgetSettingsGuildBoostSubscriptionAdapter$Item$GuildItem, Guild guild, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            guild = widgetSettingsGuildBoostSubscriptionAdapter$Item$GuildItem.guild;
        }
        if ((i2 & 2) != 0) {
            i = widgetSettingsGuildBoostSubscriptionAdapter$Item$GuildItem.boostCount;
        }
        return widgetSettingsGuildBoostSubscriptionAdapter$Item$GuildItem.copy(guild, i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Guild getGuild() {
        return this.guild;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getBoostCount() {
        return this.boostCount;
    }

    public final WidgetSettingsGuildBoostSubscriptionAdapter$Item$GuildItem copy(Guild guild, int boostCount) {
        return new WidgetSettingsGuildBoostSubscriptionAdapter$Item$GuildItem(guild, boostCount);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetSettingsGuildBoostSubscriptionAdapter$Item$GuildItem)) {
            return false;
        }
        WidgetSettingsGuildBoostSubscriptionAdapter$Item$GuildItem widgetSettingsGuildBoostSubscriptionAdapter$Item$GuildItem = (WidgetSettingsGuildBoostSubscriptionAdapter$Item$GuildItem) other;
        return m.areEqual(this.guild, widgetSettingsGuildBoostSubscriptionAdapter$Item$GuildItem.guild) && this.boostCount == widgetSettingsGuildBoostSubscriptionAdapter$Item$GuildItem.boostCount;
    }

    public final int getBoostCount() {
        return this.boostCount;
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
        return ((guild != null ? guild.hashCode() : 0) * 31) + this.boostCount;
    }

    public String toString() {
        StringBuilder sbU = a.U("GuildItem(guild=");
        sbU.append(this.guild);
        sbU.append(", boostCount=");
        return a.B(sbU, this.boostCount, ")");
    }
}
