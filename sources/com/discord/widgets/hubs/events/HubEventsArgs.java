package com.discord.widgets.hubs.events;

import a0.a.a.b;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable$Creator;
import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetHubEventsPage.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class HubEventsArgs implements Parcelable {
    public static final Parcelable$Creator<HubEventsArgs> CREATOR = new HubEventsArgs$Creator();
    private final long directoryChannelId;
    private final long guildId;

    public HubEventsArgs(long j, long j2) {
        this.guildId = j;
        this.directoryChannelId = j2;
    }

    public static /* synthetic */ HubEventsArgs copy$default(HubEventsArgs hubEventsArgs, long j, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = hubEventsArgs.guildId;
        }
        if ((i & 2) != 0) {
            j2 = hubEventsArgs.directoryChannelId;
        }
        return hubEventsArgs.copy(j, j2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getGuildId() {
        return this.guildId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getDirectoryChannelId() {
        return this.directoryChannelId;
    }

    public final HubEventsArgs copy(long guildId, long directoryChannelId) {
        return new HubEventsArgs(guildId, directoryChannelId);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HubEventsArgs)) {
            return false;
        }
        HubEventsArgs hubEventsArgs = (HubEventsArgs) other;
        return this.guildId == hubEventsArgs.guildId && this.directoryChannelId == hubEventsArgs.directoryChannelId;
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
        StringBuilder sbU = a.U("HubEventsArgs(guildId=");
        sbU.append(this.guildId);
        sbU.append(", directoryChannelId=");
        return a.C(sbU, this.directoryChannelId, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        m.checkNotNullParameter(parcel, "parcel");
        parcel.writeLong(this.guildId);
        parcel.writeLong(this.directoryChannelId);
    }
}
