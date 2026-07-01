package com.discord.api.message.activity;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: MessageActivity.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class MessageActivity {
    private final String partyId;
    private final MessageActivityType type;

    public MessageActivity(MessageActivityType messageActivityType, String str) {
        Intrinsics3.checkNotNullParameter(messageActivityType, "type");
        Intrinsics3.checkNotNullParameter(str, "partyId");
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
        return Intrinsics3.areEqual(this.type, messageActivity.type) && Intrinsics3.areEqual(this.partyId, messageActivity.partyId);
    }

    public int hashCode() {
        MessageActivityType messageActivityType = this.type;
        int iHashCode = (messageActivityType != null ? messageActivityType.hashCode() : 0) * 31;
        String str = this.partyId;
        return iHashCode + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("MessageActivity(type=");
        sbU.append(this.type);
        sbU.append(", partyId=");
        return outline.J(sbU, this.partyId, ")");
    }
}
