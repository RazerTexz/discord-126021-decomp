package com.discord.widgets.hubs;

import android.os.Parcel;
import android.os.Parcelable;
import p001a0.p002a.p003a.C0002b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetHubAuthenticationlViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class AuthenticationResult implements MultipleDomainResult {
    public static final Parcelable.Creator<AuthenticationResult> CREATOR = new Creator();
    private final long guildId;

    public static class Creator implements Parcelable.Creator<AuthenticationResult> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AuthenticationResult createFromParcel(Parcel parcel) {
            C12238m.checkNotNullParameter(parcel, "in");
            return new AuthenticationResult(parcel.readLong());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AuthenticationResult[] newArray(int i) {
            return new AuthenticationResult[i];
        }
    }

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
        return C0002b.m3a(this.guildId);
    }

    public String toString() {
        return C1643a.m815C(C1643a.m833U("AuthenticationResult(guildId="), this.guildId, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        C12238m.checkNotNullParameter(parcel, "parcel");
        parcel.writeLong(this.guildId);
    }
}
