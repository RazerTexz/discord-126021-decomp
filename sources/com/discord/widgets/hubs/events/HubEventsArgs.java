package com.discord.widgets.hubs.events;

import android.os.Parcel;
import android.os.Parcelable;
import p001a0.p002a.p003a.C0002b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetHubEventsPage.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class HubEventsArgs implements Parcelable {
    public static final Parcelable.Creator<HubEventsArgs> CREATOR = new Creator();
    private final long directoryChannelId;
    private final long guildId;

    public static class Creator implements Parcelable.Creator<HubEventsArgs> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final HubEventsArgs createFromParcel(Parcel parcel) {
            C12238m.checkNotNullParameter(parcel, "in");
            return new HubEventsArgs(parcel.readLong(), parcel.readLong());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final HubEventsArgs[] newArray(int i) {
            return new HubEventsArgs[i];
        }
    }

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
        return C0002b.m3a(this.directoryChannelId) + (C0002b.m3a(this.guildId) * 31);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("HubEventsArgs(guildId=");
        sbM833U.append(this.guildId);
        sbM833U.append(", directoryChannelId=");
        return C1643a.m815C(sbM833U, this.directoryChannelId, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        C12238m.checkNotNullParameter(parcel, "parcel");
        parcel.writeLong(this.guildId);
        parcel.writeLong(this.directoryChannelId);
    }
}
