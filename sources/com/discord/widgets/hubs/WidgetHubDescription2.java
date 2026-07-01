package com.discord.widgets.hubs;

import a0.a.a.b;
import android.os.Parcel;
import android.os.Parcelable;
import b.d.b.a.outline;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.widgets.hubs.DescriptionResult, reason: use source file name */
/* JADX INFO: compiled from: WidgetHubDescription.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetHubDescription2 implements Parcelable {
    public static final Parcelable.Creator<WidgetHubDescription2> CREATOR = new Creator();
    private final long guildId;
    private final String hubName;

    /* JADX INFO: renamed from: com.discord.widgets.hubs.DescriptionResult$Creator */
    public static class Creator implements Parcelable.Creator<WidgetHubDescription2> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final WidgetHubDescription2 createFromParcel(Parcel parcel) {
            Intrinsics3.checkNotNullParameter(parcel, "in");
            return new WidgetHubDescription2(parcel.readLong(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final WidgetHubDescription2[] newArray(int i) {
            return new WidgetHubDescription2[i];
        }
    }

    public WidgetHubDescription2(long j, String str) {
        Intrinsics3.checkNotNullParameter(str, "hubName");
        this.guildId = j;
        this.hubName = str;
    }

    public static /* synthetic */ WidgetHubDescription2 copy$default(WidgetHubDescription2 widgetHubDescription2, long j, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            j = widgetHubDescription2.guildId;
        }
        if ((i & 2) != 0) {
            str = widgetHubDescription2.hubName;
        }
        return widgetHubDescription2.copy(j, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getGuildId() {
        return this.guildId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getHubName() {
        return this.hubName;
    }

    public final WidgetHubDescription2 copy(long guildId, String hubName) {
        Intrinsics3.checkNotNullParameter(hubName, "hubName");
        return new WidgetHubDescription2(guildId, hubName);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetHubDescription2)) {
            return false;
        }
        WidgetHubDescription2 widgetHubDescription2 = (WidgetHubDescription2) other;
        return this.guildId == widgetHubDescription2.guildId && Intrinsics3.areEqual(this.hubName, widgetHubDescription2.hubName);
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
        StringBuilder sbU = outline.U("DescriptionResult(guildId=");
        sbU.append(this.guildId);
        sbU.append(", hubName=");
        return outline.J(sbU, this.hubName, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics3.checkNotNullParameter(parcel, "parcel");
        parcel.writeLong(this.guildId);
        parcel.writeString(this.hubName);
    }
}
