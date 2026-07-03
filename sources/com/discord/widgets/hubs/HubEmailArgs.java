package com.discord.widgets.hubs;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetHubEmailViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class HubEmailArgs implements Parcelable {
    public static final Parcelable.Creator<HubEmailArgs> CREATOR = new Creator();
    private final HubEmailEntryPoint entryPoint;
    private final int guildMemberCount;
    private final String guildName;

    public static class Creator implements Parcelable.Creator<HubEmailArgs> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final HubEmailArgs createFromParcel(Parcel parcel) {
            C12238m.checkNotNullParameter(parcel, "in");
            return new HubEmailArgs(parcel.readString(), parcel.readInt(), (HubEmailEntryPoint) Enum.valueOf(HubEmailEntryPoint.class, parcel.readString()));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final HubEmailArgs[] newArray(int i) {
            return new HubEmailArgs[i];
        }
    }

    public HubEmailArgs() {
        this(null, 0, null, 7, null);
    }

    public HubEmailArgs(String str, int i, HubEmailEntryPoint hubEmailEntryPoint) {
        C12238m.checkNotNullParameter(str, "guildName");
        C12238m.checkNotNullParameter(hubEmailEntryPoint, "entryPoint");
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
        C12238m.checkNotNullParameter(guildName, "guildName");
        C12238m.checkNotNullParameter(entryPoint, "entryPoint");
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
        return C12238m.areEqual(this.guildName, hubEmailArgs.guildName) && this.guildMemberCount == hubEmailArgs.guildMemberCount && C12238m.areEqual(this.entryPoint, hubEmailArgs.entryPoint);
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
        StringBuilder sbM833U = C1643a.m833U("HubEmailArgs(guildName=");
        sbM833U.append(this.guildName);
        sbM833U.append(", guildMemberCount=");
        sbM833U.append(this.guildMemberCount);
        sbM833U.append(", entryPoint=");
        sbM833U.append(this.entryPoint);
        sbM833U.append(")");
        return sbM833U.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        C12238m.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.guildName);
        parcel.writeInt(this.guildMemberCount);
        parcel.writeString(this.entryPoint.name());
    }

    public /* synthetic */ HubEmailArgs(String str, int i, HubEmailEntryPoint hubEmailEntryPoint, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? 0 : i, (i2 & 4) != 0 ? HubEmailEntryPoint.Default : hubEmailEntryPoint);
    }
}
