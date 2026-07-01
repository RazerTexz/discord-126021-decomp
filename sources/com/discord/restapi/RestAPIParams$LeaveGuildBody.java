package com.discord.restapi;

import b.d.b.a.a;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: RestAPIParams.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class RestAPIParams$LeaveGuildBody {
    private final boolean lurking;

    public RestAPIParams$LeaveGuildBody() {
        this(false, 1, null);
    }

    public RestAPIParams$LeaveGuildBody(boolean z2) {
        this.lurking = z2;
    }

    public static /* synthetic */ RestAPIParams$LeaveGuildBody copy$default(RestAPIParams$LeaveGuildBody restAPIParams$LeaveGuildBody, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = restAPIParams$LeaveGuildBody.lurking;
        }
        return restAPIParams$LeaveGuildBody.copy(z2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getLurking() {
        return this.lurking;
    }

    public final RestAPIParams$LeaveGuildBody copy(boolean lurking) {
        return new RestAPIParams$LeaveGuildBody(lurking);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof RestAPIParams$LeaveGuildBody) && this.lurking == ((RestAPIParams$LeaveGuildBody) other).lurking;
        }
        return true;
    }

    public final boolean getLurking() {
        return this.lurking;
    }

    public int hashCode() {
        boolean z2 = this.lurking;
        if (z2) {
            return 1;
        }
        return z2 ? 1 : 0;
    }

    public String toString() {
        return a.O(a.U("LeaveGuildBody(lurking="), this.lurking, ")");
    }

    public /* synthetic */ RestAPIParams$LeaveGuildBody(boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z2);
    }
}
