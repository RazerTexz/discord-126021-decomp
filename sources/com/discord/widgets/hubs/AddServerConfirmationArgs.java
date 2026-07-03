package com.discord.widgets.hubs;

import android.os.Parcel;
import android.os.Parcelable;
import p001a0.p002a.p003a.C0002b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetHubAddServerConfirmationDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class AddServerConfirmationArgs implements Parcelable {
    public static final Parcelable.Creator<AddServerConfirmationArgs> CREATOR = new Creator();
    private final long guildId;
    private final String hubName;

    public static class Creator implements Parcelable.Creator<AddServerConfirmationArgs> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AddServerConfirmationArgs createFromParcel(Parcel parcel) {
            C12238m.checkNotNullParameter(parcel, "in");
            return new AddServerConfirmationArgs(parcel.readLong(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AddServerConfirmationArgs[] newArray(int i) {
            return new AddServerConfirmationArgs[i];
        }
    }

    public AddServerConfirmationArgs(long j, String str) {
        C12238m.checkNotNullParameter(str, "hubName");
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
        C12238m.checkNotNullParameter(hubName, "hubName");
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
        return this.guildId == addServerConfirmationArgs.guildId && C12238m.areEqual(this.hubName, addServerConfirmationArgs.hubName);
    }

    public final long getGuildId() {
        return this.guildId;
    }

    public final String getHubName() {
        return this.hubName;
    }

    public int hashCode() {
        int iM3a = C0002b.m3a(this.guildId) * 31;
        String str = this.hubName;
        return iM3a + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("AddServerConfirmationArgs(guildId=");
        sbM833U.append(this.guildId);
        sbM833U.append(", hubName=");
        return C1643a.m822J(sbM833U, this.hubName, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        C12238m.checkNotNullParameter(parcel, "parcel");
        parcel.writeLong(this.guildId);
        parcel.writeString(this.hubName);
    }
}
