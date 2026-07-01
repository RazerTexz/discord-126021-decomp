package com.discord.widgets.hubs;

import android.os.Parcel;
import android.os.Parcelable;
import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: com.discord.widgets.hubs.HubEmailArgs, reason: use source file name */
/* JADX INFO: compiled from: WidgetHubEmailViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetHubEmailViewModel2 implements Parcelable {
    public static final Parcelable.Creator<WidgetHubEmailViewModel2> CREATOR = new Creator();
    private final WidgetHubEmailViewModel3 entryPoint;
    private final int guildMemberCount;
    private final String guildName;

    /* JADX INFO: renamed from: com.discord.widgets.hubs.HubEmailArgs$Creator */
    public static class Creator implements Parcelable.Creator<WidgetHubEmailViewModel2> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final WidgetHubEmailViewModel2 createFromParcel(Parcel parcel) {
            Intrinsics3.checkNotNullParameter(parcel, "in");
            return new WidgetHubEmailViewModel2(parcel.readString(), parcel.readInt(), (WidgetHubEmailViewModel3) Enum.valueOf(WidgetHubEmailViewModel3.class, parcel.readString()));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final WidgetHubEmailViewModel2[] newArray(int i) {
            return new WidgetHubEmailViewModel2[i];
        }
    }

    public WidgetHubEmailViewModel2() {
        this(null, 0, null, 7, null);
    }

    public WidgetHubEmailViewModel2(String str, int i, WidgetHubEmailViewModel3 widgetHubEmailViewModel3) {
        Intrinsics3.checkNotNullParameter(str, "guildName");
        Intrinsics3.checkNotNullParameter(widgetHubEmailViewModel3, "entryPoint");
        this.guildName = str;
        this.guildMemberCount = i;
        this.entryPoint = widgetHubEmailViewModel3;
    }

    public static /* synthetic */ WidgetHubEmailViewModel2 copy$default(WidgetHubEmailViewModel2 widgetHubEmailViewModel2, String str, int i, WidgetHubEmailViewModel3 widgetHubEmailViewModel3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = widgetHubEmailViewModel2.guildName;
        }
        if ((i2 & 2) != 0) {
            i = widgetHubEmailViewModel2.guildMemberCount;
        }
        if ((i2 & 4) != 0) {
            widgetHubEmailViewModel3 = widgetHubEmailViewModel2.entryPoint;
        }
        return widgetHubEmailViewModel2.copy(str, i, widgetHubEmailViewModel3);
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
    public final WidgetHubEmailViewModel3 getEntryPoint() {
        return this.entryPoint;
    }

    public final WidgetHubEmailViewModel2 copy(String guildName, int guildMemberCount, WidgetHubEmailViewModel3 entryPoint) {
        Intrinsics3.checkNotNullParameter(guildName, "guildName");
        Intrinsics3.checkNotNullParameter(entryPoint, "entryPoint");
        return new WidgetHubEmailViewModel2(guildName, guildMemberCount, entryPoint);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetHubEmailViewModel2)) {
            return false;
        }
        WidgetHubEmailViewModel2 widgetHubEmailViewModel2 = (WidgetHubEmailViewModel2) other;
        return Intrinsics3.areEqual(this.guildName, widgetHubEmailViewModel2.guildName) && this.guildMemberCount == widgetHubEmailViewModel2.guildMemberCount && Intrinsics3.areEqual(this.entryPoint, widgetHubEmailViewModel2.entryPoint);
    }

    public final WidgetHubEmailViewModel3 getEntryPoint() {
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
        WidgetHubEmailViewModel3 widgetHubEmailViewModel3 = this.entryPoint;
        return iHashCode + (widgetHubEmailViewModel3 != null ? widgetHubEmailViewModel3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("HubEmailArgs(guildName=");
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
        Intrinsics3.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.guildName);
        parcel.writeInt(this.guildMemberCount);
        parcel.writeString(this.entryPoint.name());
    }

    public /* synthetic */ WidgetHubEmailViewModel2(String str, int i, WidgetHubEmailViewModel3 widgetHubEmailViewModel3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? 0 : i, (i2 & 4) != 0 ? WidgetHubEmailViewModel3.Default : widgetHubEmailViewModel3);
    }
}
