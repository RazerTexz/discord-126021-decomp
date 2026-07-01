package com.discord.widgets.hubs;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import d0.z.d.m;

/* JADX INFO: loaded from: classes2.dex */
public class DomainGuildInfo$Creator implements Parcelable$Creator<DomainGuildInfo> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable$Creator
    public final DomainGuildInfo createFromParcel(Parcel parcel) {
        m.checkNotNullParameter(parcel, "in");
        return new DomainGuildInfo(parcel.readString(), parcel.readLong(), parcel.readString());
    }

    @Override // android.os.Parcelable$Creator
    public /* bridge */ /* synthetic */ DomainGuildInfo createFromParcel(Parcel parcel) {
        return createFromParcel(parcel);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable$Creator
    public final DomainGuildInfo[] newArray(int i) {
        return new DomainGuildInfo[i];
    }

    @Override // android.os.Parcelable$Creator
    public /* bridge */ /* synthetic */ DomainGuildInfo[] newArray(int i) {
        return newArray(i);
    }
}
