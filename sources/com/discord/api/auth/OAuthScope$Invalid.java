package com.discord.api.auth;

import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: OAuthScope.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class OAuthScope$Invalid extends OAuthScope {
    private final String rawValue;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OAuthScope$Invalid(String str) {
        super("invalid", null);
        m.checkNotNullParameter(str, "rawValue");
        this.rawValue = str;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final String getRawValue() {
        return this.rawValue;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof OAuthScope$Invalid) && m.areEqual(this.rawValue, ((OAuthScope$Invalid) other).rawValue);
        }
        return true;
    }

    public int hashCode() {
        String str = this.rawValue;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return a.J(a.U("Invalid(rawValue="), this.rawValue, ")");
    }
}
