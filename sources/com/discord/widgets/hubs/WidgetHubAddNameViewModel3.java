package com.discord.widgets.hubs;

import a0.a.a.b;
import android.os.Parcel;
import android.os.Parcelable;
import b.d.b.a.outline;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.widgets.hubs.HubAddNameArgs, reason: use source file name */
/* JADX INFO: compiled from: WidgetHubAddNameViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetHubAddNameViewModel3 implements Parcelable {
    public static final Parcelable.Creator<WidgetHubAddNameViewModel3> CREATOR = new Creator();
    private final long guildId;

    /* JADX INFO: renamed from: com.discord.widgets.hubs.HubAddNameArgs$Creator */
    public static class Creator implements Parcelable.Creator<WidgetHubAddNameViewModel3> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final WidgetHubAddNameViewModel3 createFromParcel(Parcel parcel) {
            Intrinsics3.checkNotNullParameter(parcel, "in");
            return new WidgetHubAddNameViewModel3(parcel.readLong());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final WidgetHubAddNameViewModel3[] newArray(int i) {
            return new WidgetHubAddNameViewModel3[i];
        }
    }

    public WidgetHubAddNameViewModel3(long j) {
        this.guildId = j;
    }

    public static /* synthetic */ WidgetHubAddNameViewModel3 copy$default(WidgetHubAddNameViewModel3 widgetHubAddNameViewModel3, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = widgetHubAddNameViewModel3.guildId;
        }
        return widgetHubAddNameViewModel3.copy(j);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getGuildId() {
        return this.guildId;
    }

    public final WidgetHubAddNameViewModel3 copy(long guildId) {
        return new WidgetHubAddNameViewModel3(guildId);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof WidgetHubAddNameViewModel3) && this.guildId == ((WidgetHubAddNameViewModel3) other).guildId;
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
        return outline.C(outline.U("HubAddNameArgs(guildId="), this.guildId, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics3.checkNotNullParameter(parcel, "parcel");
        parcel.writeLong(this.guildId);
    }
}
