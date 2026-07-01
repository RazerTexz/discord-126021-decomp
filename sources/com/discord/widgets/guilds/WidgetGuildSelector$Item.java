package com.discord.widgets.guilds;

import b.d.b.a.a;
import com.discord.models.guild.Guild;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetGuildSelector.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetGuildSelector$Item implements MGRecyclerDataPayload {
    private final Guild guild;
    private final String key;
    private final int type = 1;

    public WidgetGuildSelector$Item(Guild guild) {
        String strValueOf;
        this.guild = guild;
        this.key = (guild == null || (strValueOf = String.valueOf(guild.getId())) == null) ? "" : strValueOf;
    }

    public static /* synthetic */ WidgetGuildSelector$Item copy$default(WidgetGuildSelector$Item widgetGuildSelector$Item, Guild guild, int i, Object obj) {
        if ((i & 1) != 0) {
            guild = widgetGuildSelector$Item.guild;
        }
        return widgetGuildSelector$Item.copy(guild);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Guild getGuild() {
        return this.guild;
    }

    public final WidgetGuildSelector$Item copy(Guild guild) {
        return new WidgetGuildSelector$Item(guild);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof WidgetGuildSelector$Item) && m.areEqual(this.guild, ((WidgetGuildSelector$Item) other).guild);
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
