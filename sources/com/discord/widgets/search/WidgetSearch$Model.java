package com.discord.widgets.search;

import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreSearch$DisplayState;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetSearch.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetSearch$Model {
    public static final WidgetSearch$Model$Companion Companion = new WidgetSearch$Model$Companion(null);
    private final Channel channel;
    private final StoreSearch$DisplayState displayState;
    private final Guild guild;
    private final boolean isQueryValid;

    public WidgetSearch$Model(Guild guild, Channel channel, StoreSearch$DisplayState storeSearch$DisplayState, boolean z2) {
        this.guild = guild;
        this.channel = channel;
        this.displayState = storeSearch$DisplayState;
        this.isQueryValid = z2;
    }

    public static /* synthetic */ WidgetSearch$Model copy$default(WidgetSearch$Model widgetSearch$Model, Guild guild, Channel channel, StoreSearch$DisplayState storeSearch$DisplayState, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            guild = widgetSearch$Model.guild;
        }
        if ((i & 2) != 0) {
            channel = widgetSearch$Model.channel;
        }
        if ((i & 4) != 0) {
            storeSearch$DisplayState = widgetSearch$Model.displayState;
        }
        if ((i & 8) != 0) {
            z2 = widgetSearch$Model.isQueryValid;
        }
        return widgetSearch$Model.copy(guild, channel, storeSearch$DisplayState, z2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Guild getGuild() {
        return this.guild;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Channel getChannel() {
        return this.channel;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final StoreSearch$DisplayState getDisplayState() {
        return this.displayState;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getIsQueryValid() {
        return this.isQueryValid;
    }

    public final WidgetSearch$Model copy(Guild guild, Channel channel, StoreSearch$DisplayState displayState, boolean isQueryValid) {
        return new WidgetSearch$Model(guild, channel, displayState, isQueryValid);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetSearch$Model)) {
            return false;
        }
        WidgetSearch$Model widgetSearch$Model = (WidgetSearch$Model) other;
        return m.areEqual(this.guild, widgetSearch$Model.guild) && m.areEqual(this.channel, widgetSearch$Model.channel) && m.areEqual(this.displayState, widgetSearch$Model.displayState) && this.isQueryValid == widgetSearch$Model.isQueryValid;
    }

    public final Channel getChannel() {
        return this.channel;
    }

    public final StoreSearch$DisplayState getDisplayState() {
        return this.displayState;
    }

    public final Guild getGuild() {
        return this.guild;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public int hashCode() {
        Guild guild = this.guild;
        int iHashCode = (guild != null ? guild.hashCode() : 0) * 31;
        Channel channel = this.channel;
        int iHashCode2 = (iHashCode + (channel != null ? channel.hashCode() : 0)) * 31;
        StoreSearch$DisplayState storeSearch$DisplayState = this.displayState;
        int iHashCode3 = (iHashCode2 + (storeSearch$DisplayState != null ? storeSearch$DisplayState.hashCode() : 0)) * 31;
        boolean z2 = this.isQueryValid;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        return iHashCode3 + r1;
    }

    public final boolean isQueryValid() {
        return this.isQueryValid;
    }

    public String toString() {
        StringBuilder sbU = a.U("Model(guild=");
        sbU.append(this.guild);
        sbU.append(", channel=");
        sbU.append(this.channel);
        sbU.append(", displayState=");
        sbU.append(this.displayState);
        sbU.append(", isQueryValid=");
        return a.O(sbU, this.isQueryValid, ")");
    }
}
