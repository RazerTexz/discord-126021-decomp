package com.discord.widgets.hubs;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable$Creator;
import b.d.b.a.a;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetHubEmailViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class HubEmailArgs implements Parcelable {
    public static final Parcelable$Creator<HubEmailArgs> CREATOR = new HubEmailArgs$Creator();
    private final HubEmailEntryPoint entryPoint;
    private final int guildMemberCount;
    private final String guildName;

    public HubEmailArgs() {
        this(null, 0, null, 7, null);
    }

    public HubEmailArgs(String str, int i, HubEmailEntryPoint hubEmailEntryPoint) {
        m.checkNotNullParameter(str, "guildName");
        m.checkNotNullParameter(hubEmailEntryPoint, "entryPoint");
        this.guildName = str;
        this.guildMemberCount = i;
        this.entryPoint = hubEmailEntryPoint;
    }

    public static /* synthetic */ HubEmailArgs copy$default(HubEmailArgs hubEmailArgs, String str, int i, HubEmailEntryPoint hubEmailEntryPoint, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = hubEmailArgs.guildName;
        }
        if ((i2 & 2) != 0) {
            i = hubEmailArgs.guildMemberCount;
        }
        if ((i2 & 4) != 0) {
            hubEmailEntryPoint = hubEmailArgs.entryPoint;
        }
        return hubEmailArgs.copy(str, i, hubEmailEntryPoint);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getGuildName() {
        return this.guildName;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getGuildMemberCount() {
        return this.guildMemberCount;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final HubEmailEntryPoint getEntryPoint() {
        return this.entryPoint;
    }

    public final HubEmailArgs copy(String guildName, int guildMemberCount, HubEmailEntryPoint entryPoint) {
        m.checkNotNullParameter(guildName, "guildName");
        m.checkNotNullParameter(entryPoint, "entryPoint");
        return new HubEmailArgs(guildName, guildMemberCount, entryPoint);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HubEmailArgs)) {
            return false;
        }
        HubEmailArgs hubEmailArgs = (HubEmailArgs) other;
        return m.areEqual(this.guildName, hubEmailArgs.guildName) && this.guildMemberCount == hubEmailArgs.guildMemberCount && m.areEqual(this.entryPoint, hubEmailArgs.entryPoint);
    }

    public final HubEmailEntryPoint getEntryPoint() {
        return this.entryPoint;
    }

    public final int getGuildMemberCount() {
        return this.guildMemberCount;
    }

    public final String getGuildName() {
        return this.guildName;
    }

    public int hashCode() {
        String str = this.guildName;
        int iHashCode = (((str != null ? str.hashCode() : 0) * 31) + this.guildMemberCount) * 31;
        HubEmailEntryPoint hubEmailEntryPoint = this.entryPoint;
        return iHashCode + (hubEmailEntryPoint != null ? hubEmailEntryPoint.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("HubEmailArgs(guildName=");
        sbU.append(this.guildName);
        sbU.append(", guildMemberCount=");
        sbU.append(this.guildMemberCount);
        sbU.append(", entryPoint=");
        sbU.append(this.entryPoint);
        sbU.append(")");
        return sbU.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        m.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.guildName);
        parcel.writeInt(this.guildMemberCount);
        parcel.writeString(this.entryPoint.name());
    }

    public /* synthetic */ HubEmailArgs(String str, int i, HubEmailEntryPoint hubEmailEntryPoint, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? 0 : i, (i2 & 4) != 0 ? HubEmailEntryPoint.Default : hubEmailEntryPoint);
    }
}
