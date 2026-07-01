package com.discord.widgets.hubs;

import a0.a.a.b;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable$Creator;
import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetHubAddServerConfirmationDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class AddServerConfirmationArgs implements Parcelable {
    public static final Parcelable$Creator<AddServerConfirmationArgs> CREATOR = new AddServerConfirmationArgs$Creator();
    private final long guildId;
    private final String hubName;

    public AddServerConfirmationArgs(long j, String str) {
        m.checkNotNullParameter(str, "hubName");
        this.guildId = j;
        this.hubName = str;
    }

    public static /* synthetic */ AddServerConfirmationArgs copy$default(AddServerConfirmationArgs addServerConfirmationArgs, long j, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            j = addServerConfirmationArgs.guildId;
        }
        if ((i & 2) != 0) {
            str = addServerConfirmationArgs.hubName;
        }
        return addServerConfirmationArgs.copy(j, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getGuildId() {
        return this.guildId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getHubName() {
        return this.hubName;
    }

    public final AddServerConfirmationArgs copy(long guildId, String hubName) {
        m.checkNotNullParameter(hubName, "hubName");
        return new AddServerConfirmationArgs(guildId, hubName);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AddServerConfirmationArgs)) {
            return false;
        }
        AddServerConfirmationArgs addServerConfirmationArgs = (AddServerConfirmationArgs) other;
        return this.guildId == addServerConfirmationArgs.guildId && m.areEqual(this.hubName, addServerConfirmationArgs.hubName);
    }

    public final long getGuildId() {
        return this.guildId;
    }

    public final String getHubName() {
        return this.hubName;
    }

    public int hashCode() {
        int iA = b.a(this.guildId) * 31;
        String str = this.hubName;
        return iA + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("AddServerConfirmationArgs(guildId=");
        sbU.append(this.guildId);
        sbU.append(", hubName=");
        return a.J(sbU, this.hubName, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        m.checkNotNullParameter(parcel, "parcel");
        parcel.writeLong(this.guildId);
        parcel.writeString(this.hubName);
    }
}
