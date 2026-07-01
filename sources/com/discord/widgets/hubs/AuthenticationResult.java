package com.discord.widgets.hubs;

import a0.a.a.b;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetHubAuthenticationlViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class AuthenticationResult implements MultipleDomainResult {
    public static final Parcelable$Creator<AuthenticationResult> CREATOR = new AuthenticationResult$Creator();
    private final long guildId;

    public AuthenticationResult(long j) {
        this.guildId = j;
    }

    public static /* synthetic */ AuthenticationResult copy$default(AuthenticationResult authenticationResult, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = authenticationResult.guildId;
        }
        return authenticationResult.copy(j);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getGuildId() {
        return this.guildId;
    }

    public final AuthenticationResult copy(long guildId) {
        return new AuthenticationResult(guildId);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof AuthenticationResult) && this.guildId == ((AuthenticationResult) other).guildId;
        }
        return true;
    }

    public final long getGuildId() {
        return this.guildId;
    }

    public int hashCode() {
        return b.a(this.guildId);
    }

    public String toString() {
        return a.C(a.U("AuthenticationResult(guildId="), this.guildId, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        m.checkNotNullParameter(parcel, "parcel");
        parcel.writeLong(this.guildId);
    }
}
