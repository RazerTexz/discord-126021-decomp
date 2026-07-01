package com.discord.restapi;

import b.d.b.a.a;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: RestAPIParams.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class RestAPIParams$ConnectedAccountNameOnly {
    private final String name;

    public RestAPIParams$ConnectedAccountNameOnly() {
        this(null, 1, null);
    }

    public RestAPIParams$ConnectedAccountNameOnly(String str) {
        this.name = str;
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    private final String getName() {
        return this.name;
    }

    public static /* synthetic */ RestAPIParams$ConnectedAccountNameOnly copy$default(RestAPIParams$ConnectedAccountNameOnly restAPIParams$ConnectedAccountNameOnly, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = restAPIParams$ConnectedAccountNameOnly.name;
        }
        return restAPIParams$ConnectedAccountNameOnly.copy(str);
    }

    public final RestAPIParams$ConnectedAccountNameOnly copy(String name) {
        return new RestAPIParams$ConnectedAccountNameOnly(name);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof RestAPIParams$ConnectedAccountNameOnly) && m.areEqual(this.name, ((RestAPIParams$ConnectedAccountNameOnly) other).name);
        }
        return true;
    }

    public int hashCode() {
        String str = this.name;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return a.J(a.U("ConnectedAccountNameOnly(name="), this.name, ")");
    }

    public /* synthetic */ RestAPIParams$ConnectedAccountNameOnly(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str);
    }
}
