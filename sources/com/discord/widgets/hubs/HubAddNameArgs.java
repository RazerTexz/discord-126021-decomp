package com.discord.widgets.hubs;

import android.os.Parcel;
import android.os.Parcelable;
import p001a0.p002a.p003a.C0002b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetHubAddNameViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class HubAddNameArgs implements Parcelable {
    public static final Parcelable.Creator<HubAddNameArgs> CREATOR = new Creator();
    private final long guildId;

    public static class Creator implements Parcelable.Creator<HubAddNameArgs> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final HubAddNameArgs createFromParcel(Parcel parcel) {
            C12238m.checkNotNullParameter(parcel, "in");
            return new HubAddNameArgs(parcel.readLong());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final HubAddNameArgs[] newArray(int i) {
            return new HubAddNameArgs[i];
        }
    }

    public HubAddNameArgs(long j) {
        this.guildId = j;
    }

    public static /* synthetic */ HubAddNameArgs copy$default(HubAddNameArgs hubAddNameArgs, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = hubAddNameArgs.guildId;
        }
        return hubAddNameArgs.copy(j);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getGuildId() {
        return this.guildId;
    }

    public final HubAddNameArgs copy(long guildId) {
        return new HubAddNameArgs(guildId);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof HubAddNameArgs) && this.guildId == ((HubAddNameArgs) other).guildId;
        }
        return true;
    }

    public final long getGuildId() {
        return this.guildId;
    }

    public int hashCode() {
        return C0002b.m3a(this.guildId);
    }

    public String toString() {
        return C1643a.m815C(C1643a.m833U("HubAddNameArgs(guildId="), this.guildId, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        C12238m.checkNotNullParameter(parcel, "parcel");
        parcel.writeLong(this.guildId);
    }
}
