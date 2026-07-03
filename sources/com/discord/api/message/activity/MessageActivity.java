package com.discord.api.message.activity;

import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: MessageActivity.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class MessageActivity {
    private final String partyId;
    private final MessageActivityType type;

    public MessageActivity(MessageActivityType messageActivityType, String str) {
        C12238m.checkNotNullParameter(messageActivityType, "type");
        C12238m.checkNotNullParameter(str, "partyId");
        this.type = messageActivityType;
        this.partyId = str;
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final String getPartyId() {
        return this.partyId;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final MessageActivityType getType() {
        return this.type;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MessageActivity)) {
            return false;
        }
        MessageActivity messageActivity = (MessageActivity) other;
        return C12238m.areEqual(this.type, messageActivity.type) && C12238m.areEqual(this.partyId, messageActivity.partyId);
    }

    public int hashCode() {
        MessageActivityType messageActivityType = this.type;
        int iHashCode = (messageActivityType != null ? messageActivityType.hashCode() : 0) * 31;
        String str = this.partyId;
        return iHashCode + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("MessageActivity(type=");
        sbM833U.append(this.type);
        sbM833U.append(", partyId=");
        return C1643a.m822J(sbM833U, this.partyId, ")");
    }
}
