package com.discord.api.handoff;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: CreateHandoffTokenRequest.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class CreateHandoffTokenRequest {
    private final String key;

    public CreateHandoffTokenRequest(String str) {
        Intrinsics3.checkNotNullParameter(str, "key");
        this.key = str;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof CreateHandoffTokenRequest) && Intrinsics3.areEqual(this.key, ((CreateHandoffTokenRequest) other).key);
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
        return outline.J(outline.U("CreateHandoffTokenRequest(key="), this.key, ")");
    }
}
