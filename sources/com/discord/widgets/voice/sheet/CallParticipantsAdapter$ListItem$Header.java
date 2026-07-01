package com.discord.widgets.voice.sheet;

import androidx.annotation.StringRes;
import b.d.b.a.a;

/* JADX INFO: compiled from: CallParticipantsAdapter.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class CallParticipantsAdapter$ListItem$Header extends CallParticipantsAdapter$ListItem {
    private final String key;
    private final int stringResId;
    private final int type;

    public CallParticipantsAdapter$ListItem$Header(@StringRes int i) {
        super(null);
        this.stringResId = i;
        this.type = 1;
        this.key = String.valueOf(i);
    }

    public static /* synthetic */ CallParticipantsAdapter$ListItem$Header copy$default(CallParticipantsAdapter$ListItem$Header callParticipantsAdapter$ListItem$Header, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = callParticipantsAdapter$ListItem$Header.stringResId;
        }
        return callParticipantsAdapter$ListItem$Header.copy(i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getStringResId() {
        return this.stringResId;
    }

    public final CallParticipantsAdapter$ListItem$Header copy(@StringRes int stringResId) {
        return new CallParticipantsAdapter$ListItem$Header(stringResId);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof CallParticipantsAdapter$ListItem$Header) && this.stringResId == ((CallParticipantsAdapter$ListItem$Header) other).stringResId;
        }
        return true;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    public final int getStringResId() {
        return this.stringResId;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    public int hashCode() {
        return this.stringResId;
    }

    public String toString() {
        return a.B(a.U("Header(stringResId="), this.stringResId, ")");
    }
}
