package com.discord.widgets.hubs;

import a0.a.a.b;
import android.os.Parcel;
import android.os.Parcelable;
import b.d.b.a.outline;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.widgets.hubs.AddServerConfirmationArgs, reason: use source file name */
/* JADX INFO: compiled from: WidgetHubAddServerConfirmationDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetHubAddServerConfirmationDialog2 implements Parcelable {
    public static final Parcelable.Creator<WidgetHubAddServerConfirmationDialog2> CREATOR = new Creator();
    private final long guildId;
    private final String hubName;

    /* JADX INFO: renamed from: com.discord.widgets.hubs.AddServerConfirmationArgs$Creator */
    public static class Creator implements Parcelable.Creator<WidgetHubAddServerConfirmationDialog2> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final WidgetHubAddServerConfirmationDialog2 createFromParcel(Parcel parcel) {
            Intrinsics3.checkNotNullParameter(parcel, "in");
            return new WidgetHubAddServerConfirmationDialog2(parcel.readLong(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final WidgetHubAddServerConfirmationDialog2[] newArray(int i) {
            return new WidgetHubAddServerConfirmationDialog2[i];
        }
    }

    public WidgetHubAddServerConfirmationDialog2(long j, String str) {
        Intrinsics3.checkNotNullParameter(str, "hubName");
        this.guildId = j;
        this.hubName = str;
    }

    public static /* synthetic */ WidgetHubAddServerConfirmationDialog2 copy$default(WidgetHubAddServerConfirmationDialog2 widgetHubAddServerConfirmationDialog2, long j, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            j = widgetHubAddServerConfirmationDialog2.guildId;
        }
        if ((i & 2) != 0) {
            str = widgetHubAddServerConfirmationDialog2.hubName;
        }
        return widgetHubAddServerConfirmationDialog2.copy(j, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getGuildId() {
        return this.guildId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getHubName() {
        return this.hubName;
    }

    public final WidgetHubAddServerConfirmationDialog2 copy(long guildId, String hubName) {
        Intrinsics3.checkNotNullParameter(hubName, "hubName");
        return new WidgetHubAddServerConfirmationDialog2(guildId, hubName);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetHubAddServerConfirmationDialog2)) {
            return false;
        }
        WidgetHubAddServerConfirmationDialog2 widgetHubAddServerConfirmationDialog2 = (WidgetHubAddServerConfirmationDialog2) other;
        return this.guildId == widgetHubAddServerConfirmationDialog2.guildId && Intrinsics3.areEqual(this.hubName, widgetHubAddServerConfirmationDialog2.hubName);
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
        StringBuilder sbU = outline.U("AddServerConfirmationArgs(guildId=");
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
