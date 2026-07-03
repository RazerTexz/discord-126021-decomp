package com.discord.widgets.chat.list.entries;

import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.models.domain.ModelInvite;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: GuildScheduledEventInviteEntry.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class GuildScheduledEventInviteEntry extends ChatListEntry {
    private final GuildScheduledEvent guildScheduledEvent;
    private final ModelInvite invite;
    private final String inviteCode;
    private final String key;
    private final int type;

    public GuildScheduledEventInviteEntry(ModelInvite modelInvite, String str, GuildScheduledEvent guildScheduledEvent) {
        C12238m.checkNotNullParameter(modelInvite, "invite");
        C12238m.checkNotNullParameter(str, "inviteCode");
        C12238m.checkNotNullParameter(guildScheduledEvent, "guildScheduledEvent");
        this.invite = modelInvite;
        this.inviteCode = str;
        this.guildScheduledEvent = guildScheduledEvent;
        this.type = 43;
        StringBuilder sbM833U = C1643a.m833U("43 -- ");
        sbM833U.append(guildScheduledEvent.getId());
        sbM833U.append(" -- ");
        sbM833U.append(str);
        this.key = sbM833U.toString();
    }

    public static /* synthetic */ GuildScheduledEventInviteEntry copy$default(GuildScheduledEventInviteEntry guildScheduledEventInviteEntry, ModelInvite modelInvite, String str, GuildScheduledEvent guildScheduledEvent, int i, Object obj) {
        if ((i & 1) != 0) {
            modelInvite = guildScheduledEventInviteEntry.invite;
        }
        if ((i & 2) != 0) {
            str = guildScheduledEventInviteEntry.inviteCode;
        }
        if ((i & 4) != 0) {
            guildScheduledEvent = guildScheduledEventInviteEntry.guildScheduledEvent;
        }
        return guildScheduledEventInviteEntry.copy(modelInvite, str, guildScheduledEvent);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ModelInvite getInvite() {
        return this.invite;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getInviteCode() {
        return this.inviteCode;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final GuildScheduledEvent getGuildScheduledEvent() {
        return this.guildScheduledEvent;
    }

    public final GuildScheduledEventInviteEntry copy(ModelInvite invite, String inviteCode, GuildScheduledEvent guildScheduledEvent) {
        C12238m.checkNotNullParameter(invite, "invite");
        C12238m.checkNotNullParameter(inviteCode, "inviteCode");
        C12238m.checkNotNullParameter(guildScheduledEvent, "guildScheduledEvent");
        return new GuildScheduledEventInviteEntry(invite, inviteCode, guildScheduledEvent);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildScheduledEventInviteEntry)) {
            return false;
        }
        GuildScheduledEventInviteEntry guildScheduledEventInviteEntry = (GuildScheduledEventInviteEntry) other;
        return C12238m.areEqual(this.invite, guildScheduledEventInviteEntry.invite) && C12238m.areEqual(this.inviteCode, guildScheduledEventInviteEntry.inviteCode) && C12238m.areEqual(this.guildScheduledEvent, guildScheduledEventInviteEntry.guildScheduledEvent);
    }

    public final GuildScheduledEvent getGuildScheduledEvent() {
        return this.guildScheduledEvent;
    }

    public final ModelInvite getInvite() {
        return this.invite;
    }

    public final String getInviteCode() {
        return this.inviteCode;
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
        ModelInvite modelInvite = this.invite;
        int iHashCode = (modelInvite != null ? modelInvite.hashCode() : 0) * 31;
        String str = this.inviteCode;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        GuildScheduledEvent guildScheduledEvent = this.guildScheduledEvent;
        return iHashCode2 + (guildScheduledEvent != null ? guildScheduledEvent.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("GuildScheduledEventInviteEntry(invite=");
        sbM833U.append(this.invite);
        sbM833U.append(", inviteCode=");
        sbM833U.append(this.inviteCode);
        sbM833U.append(", guildScheduledEvent=");
        sbM833U.append(this.guildScheduledEvent);
        sbM833U.append(")");
        return sbM833U.toString();
    }
}
