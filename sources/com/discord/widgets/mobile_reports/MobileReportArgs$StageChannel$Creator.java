package com.discord.widgets.mobile_reports;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import d0.z.d.m;

/* JADX INFO: loaded from: classes2.dex */
public class MobileReportArgs$StageChannel$Creator implements Parcelable$Creator<MobileReportArgs$StageChannel> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable$Creator
    public final MobileReportArgs$StageChannel createFromParcel(Parcel parcel) {
        m.checkNotNullParameter(parcel, "in");
        return new MobileReportArgs$StageChannel(parcel.readLong());
    }

    @Override // android.os.Parcelable$Creator
    public /* bridge */ /* synthetic */ MobileReportArgs$StageChannel createFromParcel(Parcel parcel) {
        return createFromParcel(parcel);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable$Creator
    public final MobileReportArgs$StageChannel[] newArray(int i) {
        return new MobileReportArgs$StageChannel[i];
    }

    @Override // android.os.Parcelable$Creator
    public /* bridge */ /* synthetic */ MobileReportArgs$StageChannel[] newArray(int i) {
        return newArray(i);
    }
}
