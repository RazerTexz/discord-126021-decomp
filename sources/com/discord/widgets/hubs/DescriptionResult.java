package com.discord.widgets.hubs;

import a0.a.a.b;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable$Creator;
import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetHubDescription.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class DescriptionResult implements Parcelable {
    public static final Parcelable$Creator<DescriptionResult> CREATOR = new DescriptionResult$Creator();
    private final long guildId;
    private final String hubName;

    public DescriptionResult(long j, String str) {
        m.checkNotNullParameter(str, "hubName");
        this.guildId = j;
        this.hubName = str;
    }

    public static /* synthetic */ DescriptionResult copy$default(DescriptionResult descriptionResult, long j, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            j = descriptionResult.guildId;
        }
        if ((i & 2) != 0) {
            str = descriptionResult.hubName;
        }
        return descriptionResult.copy(j, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getGuildId() {
        return this.guildId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getHubName() {
        return this.hubName;
    }

    public final DescriptionResult copy(long guildId, String hubName) {
        m.checkNotNullParameter(hubName, "hubName");
        return new DescriptionResult(guildId, hubName);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DescriptionResult)) {
            return false;
        }
        DescriptionResult descriptionResult = (DescriptionResult) other;
        return this.guildId == descriptionResult.guildId && m.areEqual(this.hubName, descriptionResult.hubName);
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
        StringBuilder sbU = a.U("DescriptionResult(guildId=");
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
