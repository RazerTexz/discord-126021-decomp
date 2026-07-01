package com.discord.restapi;

import com.discord.api.message.activity.MessageActivityType;
import d0.z.d.m;

/* JADX INFO: compiled from: RestAPIParams.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RestAPIParams$Message$Activity {
    private final String partyId;
    private final String sessionId;
    private final MessageActivityType type;

    public RestAPIParams$Message$Activity(MessageActivityType messageActivityType, String str, String str2) {
        m.checkNotNullParameter(messageActivityType, "type");
        m.checkNotNullParameter(str, "partyId");
        m.checkNotNullParameter(str2, "sessionId");
        this.type = messageActivityType;
        this.partyId = str;
        this.sessionId = str2;
    }

    public final String getPartyId() {
        return this.partyId;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final MessageActivityType getType() {
        return this.type;
    }
}
