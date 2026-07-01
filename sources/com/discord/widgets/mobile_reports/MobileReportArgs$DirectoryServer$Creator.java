package com.discord.widgets.mobile_reports;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import d0.z.d.m;

/* JADX INFO: loaded from: classes2.dex */
public class MobileReportArgs$DirectoryServer$Creator implements Parcelable$Creator<MobileReportArgs$DirectoryServer> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable$Creator
    public final MobileReportArgs$DirectoryServer createFromParcel(Parcel parcel) {
        m.checkNotNullParameter(parcel, "in");
        return new MobileReportArgs$DirectoryServer(parcel.readLong(), parcel.readLong(), parcel.readLong());
    }

    @Override // android.os.Parcelable$Creator
    public /* bridge */ /* synthetic */ MobileReportArgs$DirectoryServer createFromParcel(Parcel parcel) {
        return createFromParcel(parcel);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable$Creator
    public final MobileReportArgs$DirectoryServer[] newArray(int i) {
        return new MobileReportArgs$DirectoryServer[i];
    }

    @Override // android.os.Parcelable$Creator
    public /* bridge */ /* synthetic */ MobileReportArgs$DirectoryServer[] newArray(int i) {
        return newArray(i);
    }
}
