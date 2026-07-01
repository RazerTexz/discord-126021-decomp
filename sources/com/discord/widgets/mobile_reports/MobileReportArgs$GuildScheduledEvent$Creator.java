package com.discord.widgets.mobile_reports;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import d0.z.d.m;

/* JADX INFO: loaded from: classes2.dex */
public class MobileReportArgs$GuildScheduledEvent$Creator implements Parcelable$Creator<MobileReportArgs$GuildScheduledEvent> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable$Creator
    public final MobileReportArgs$GuildScheduledEvent createFromParcel(Parcel parcel) {
        m.checkNotNullParameter(parcel, "in");
        return new MobileReportArgs$GuildScheduledEvent(parcel.readLong(), parcel.readLong());
    }

    @Override // android.os.Parcelable$Creator
    public /* bridge */ /* synthetic */ MobileReportArgs$GuildScheduledEvent createFromParcel(Parcel parcel) {
        return createFromParcel(parcel);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable$Creator
    public final MobileReportArgs$GuildScheduledEvent[] newArray(int i) {
        return new MobileReportArgs$GuildScheduledEvent[i];
    }

    @Override // android.os.Parcelable$Creator
    public /* bridge */ /* synthetic */ MobileReportArgs$GuildScheduledEvent[] newArray(int i) {
        return newArray(i);
    }
}
