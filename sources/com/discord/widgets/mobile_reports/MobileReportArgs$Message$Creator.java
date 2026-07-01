package com.discord.widgets.mobile_reports;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import d0.z.d.m;

/* JADX INFO: loaded from: classes2.dex */
public class MobileReportArgs$Message$Creator implements Parcelable$Creator<MobileReportArgs$Message> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable$Creator
    public final MobileReportArgs$Message createFromParcel(Parcel parcel) {
        m.checkNotNullParameter(parcel, "in");
        return new MobileReportArgs$Message(parcel.readLong(), parcel.readLong());
    }

    @Override // android.os.Parcelable$Creator
    public /* bridge */ /* synthetic */ MobileReportArgs$Message createFromParcel(Parcel parcel) {
        return createFromParcel(parcel);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable$Creator
    public final MobileReportArgs$Message[] newArray(int i) {
        return new MobileReportArgs$Message[i];
    }

    @Override // android.os.Parcelable$Creator
    public /* bridge */ /* synthetic */ MobileReportArgs$Message[] newArray(int i) {
        return newArray(i);
    }
}
