package com.discord.widgets.hubs.events;

import a0.a.a.b;
import android.os.Parcel;
import android.os.Parcelable;
import b.d.b.a.outline;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.widgets.hubs.events.HubEventsArgs, reason: use source file name */
/* JADX INFO: compiled from: WidgetHubEventsPage.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetHubEventsPage2 implements Parcelable {
    public static final Parcelable.Creator<WidgetHubEventsPage2> CREATOR = new Creator();
    private final long directoryChannelId;
    private final long guildId;

    /* JADX INFO: renamed from: com.discord.widgets.hubs.events.HubEventsArgs$Creator */
    public static class Creator implements Parcelable.Creator<WidgetHubEventsPage2> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final WidgetHubEventsPage2 createFromParcel(Parcel parcel) {
            Intrinsics3.checkNotNullParameter(parcel, "in");
            return new WidgetHubEventsPage2(parcel.readLong(), parcel.readLong());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final WidgetHubEventsPage2[] newArray(int i) {
            return new WidgetHubEventsPage2[i];
        }
    }

    public WidgetHubEventsPage2(long j, long j2) {
        this.guildId = j;
        this.directoryChannelId = j2;
    }

    public static /* synthetic */ WidgetHubEventsPage2 copy$default(WidgetHubEventsPage2 widgetHubEventsPage2, long j, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = widgetHubEventsPage2.guildId;
        }
        if ((i & 2) != 0) {
            j2 = widgetHubEventsPage2.directoryChannelId;
        }
        return widgetHubEventsPage2.copy(j, j2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getGuildId() {
        return this.guildId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getDirectoryChannelId() {
        return this.directoryChannelId;
    }

    public final WidgetHubEventsPage2 copy(long guildId, long directoryChannelId) {
        return new WidgetHubEventsPage2(guildId, directoryChannelId);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetHubEventsPage2)) {
            return false;
        }
        WidgetHubEventsPage2 widgetHubEventsPage2 = (WidgetHubEventsPage2) other;
        return this.guildId == widgetHubEventsPage2.guildId && this.directoryChannelId == widgetHubEventsPage2.directoryChannelId;
    }

    public final long getDirectoryChannelId() {
        return this.directoryChannelId;
    }

    public final long getGuildId() {
        return this.guildId;
    }

    public int hashCode() {
        return b.a(this.directoryChannelId) + (b.a(this.guildId) * 31);
    }

    public String toString() {
        StringBuilder sbU = outline.U("HubEventsArgs(guildId=");
        sbU.append(this.guildId);
        sbU.append(", directoryChannelId=");
        return outline.C(sbU, this.directoryChannelId, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics3.checkNotNullParameter(parcel, "parcel");
        parcel.writeLong(this.guildId);
        parcel.writeLong(this.directoryChannelId);
    }
}
