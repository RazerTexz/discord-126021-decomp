package com.discord.api.handoff;

import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: CreateHandoffTokenRequest.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class CreateHandoffTokenRequest {
    private final String key;

    public CreateHandoffTokenRequest(String str) {
        C12238m.checkNotNullParameter(str, "key");
        this.key = str;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof CreateHandoffTokenRequest) && C12238m.areEqual(this.key, ((CreateHandoffTokenRequest) other).key);
        }
        return true;
    }

    public int hashCode() {
        String str = this.key;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return C1643a.m822J(C1643a.m833U("CreateHandoffTokenRequest(key="), this.key, ")");
    }
}
