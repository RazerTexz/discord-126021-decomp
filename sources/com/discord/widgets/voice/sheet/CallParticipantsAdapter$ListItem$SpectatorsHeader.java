package com.discord.widgets.voice.sheet;

import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: CallParticipantsAdapter.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class CallParticipantsAdapter$ListItem$SpectatorsHeader extends CallParticipantsAdapter$ListItem {
    private final String key;
    private final String streamerName;
    private final int type;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CallParticipantsAdapter$ListItem$SpectatorsHeader(String str) {
        super(null);
        m.checkNotNullParameter(str, "streamerName");
        this.streamerName = str;
        this.type = 2;
        this.key = "SpectatorsHeader";
    }

    public static /* synthetic */ CallParticipantsAdapter$ListItem$SpectatorsHeader copy$default(CallParticipantsAdapter$ListItem$SpectatorsHeader callParticipantsAdapter$ListItem$SpectatorsHeader, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = callParticipantsAdapter$ListItem$SpectatorsHeader.streamerName;
        }
        return callParticipantsAdapter$ListItem$SpectatorsHeader.copy(str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getStreamerName() {
        return this.streamerName;
    }

    public final CallParticipantsAdapter$ListItem$SpectatorsHeader copy(String streamerName) {
        m.checkNotNullParameter(streamerName, "streamerName");
        return new CallParticipantsAdapter$ListItem$SpectatorsHeader(streamerName);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof CallParticipantsAdapter$ListItem$SpectatorsHeader) && m.areEqual(this.streamerName, ((CallParticipantsAdapter$ListItem$SpectatorsHeader) other).streamerName);
        }
        return true;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    public final String getStreamerName() {
        return this.streamerName;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    public int hashCode() {
        String str = this.streamerName;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return a.J(a.U("SpectatorsHeader(streamerName="), this.streamerName, ")");
    }
}
