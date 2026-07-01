package com.discord.widgets.channels.threads;

import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreThreadDraft$ThreadDraftState;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetThreadDraftArchiveSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetThreadDraftArchiveSheet$Model {
    public static final WidgetThreadDraftArchiveSheet$Model$Companion Companion = new WidgetThreadDraftArchiveSheet$Model$Companion(null);
    private final Channel channel;
    private final StoreThreadDraft$ThreadDraftState draftState;
    private final Guild guild;

    public WidgetThreadDraftArchiveSheet$Model(StoreThreadDraft$ThreadDraftState storeThreadDraft$ThreadDraftState, Guild guild, Channel channel) {
        m.checkNotNullParameter(storeThreadDraft$ThreadDraftState, "draftState");
        this.draftState = storeThreadDraft$ThreadDraftState;
        this.guild = guild;
        this.channel = channel;
    }

    public static /* synthetic */ WidgetThreadDraftArchiveSheet$Model copy$default(WidgetThreadDraftArchiveSheet$Model widgetThreadDraftArchiveSheet$Model, StoreThreadDraft$ThreadDraftState storeThreadDraft$ThreadDraftState, Guild guild, Channel channel, int i, Object obj) {
        if ((i & 1) != 0) {
            storeThreadDraft$ThreadDraftState = widgetThreadDraftArchiveSheet$Model.draftState;
        }
        if ((i & 2) != 0) {
            guild = widgetThreadDraftArchiveSheet$Model.guild;
        }
        if ((i & 4) != 0) {
            channel = widgetThreadDraftArchiveSheet$Model.channel;
        }
        return widgetThreadDraftArchiveSheet$Model.copy(storeThreadDraft$ThreadDraftState, guild, channel);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final StoreThreadDraft$ThreadDraftState getDraftState() {
        return this.draftState;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Guild getGuild() {
        return this.guild;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Channel getChannel() {
        return this.channel;
    }

    public final WidgetThreadDraftArchiveSheet$Model copy(StoreThreadDraft$ThreadDraftState draftState, Guild guild, Channel channel) {
        m.checkNotNullParameter(draftState, "draftState");
        return new WidgetThreadDraftArchiveSheet$Model(draftState, guild, channel);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetThreadDraftArchiveSheet$Model)) {
            return false;
        }
        WidgetThreadDraftArchiveSheet$Model widgetThreadDraftArchiveSheet$Model = (WidgetThreadDraftArchiveSheet$Model) other;
        return m.areEqual(this.draftState, widgetThreadDraftArchiveSheet$Model.draftState) && m.areEqual(this.guild, widgetThreadDraftArchiveSheet$Model.guild) && m.areEqual(this.channel, widgetThreadDraftArchiveSheet$Model.channel);
    }

    public final Channel getChannel() {
        return this.channel;
    }

    public final StoreThreadDraft$ThreadDraftState getDraftState() {
        return this.draftState;
    }

    public final Guild getGuild() {
        return this.guild;
    }

    public int hashCode() {
        StoreThreadDraft$ThreadDraftState storeThreadDraft$ThreadDraftState = this.draftState;
        int iHashCode = (storeThreadDraft$ThreadDraftState != null ? storeThreadDraft$ThreadDraftState.hashCode() : 0) * 31;
        Guild guild = this.guild;
        int iHashCode2 = (iHashCode + (guild != null ? guild.hashCode() : 0)) * 31;
        Channel channel = this.channel;
        return iHashCode2 + (channel != null ? channel.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("Model(draftState=");
        sbU.append(this.draftState);
        sbU.append(", guild=");
        sbU.append(this.guild);
        sbU.append(", channel=");
        sbU.append(this.channel);
        sbU.append(")");
        return sbU.toString();
    }
}
