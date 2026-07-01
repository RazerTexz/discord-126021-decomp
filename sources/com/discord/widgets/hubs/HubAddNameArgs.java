package com.discord.widgets.hubs;

import a0.a.a.b;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable$Creator;
import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetHubAddNameViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class HubAddNameArgs implements Parcelable {
    public static final Parcelable$Creator<HubAddNameArgs> CREATOR = new HubAddNameArgs$Creator();
    private final long guildId;

    public HubAddNameArgs(long j) {
        this.guildId = j;
    }

    public static /* synthetic */ HubAddNameArgs copy$default(HubAddNameArgs hubAddNameArgs, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = hubAddNameArgs.guildId;
        }
        return hubAddNameArgs.copy(j);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getGuildId() {
        return this.guildId;
    }

    public final HubAddNameArgs copy(long guildId) {
        return new HubAddNameArgs(guildId);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof HubAddNameArgs) && this.guildId == ((HubAddNameArgs) other).guildId;
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
        return a.C(a.U("HubAddNameArgs(guildId="), this.guildId, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        m.checkNotNullParameter(parcel, "parcel");
        parcel.writeLong(this.guildId);
    }
}
