package com.discord.widgets.hubs;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import d0.z.d.m;

/* JADX INFO: loaded from: classes2.dex */
public class DescriptionResult$Creator implements Parcelable$Creator<DescriptionResult> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable$Creator
    public final DescriptionResult createFromParcel(Parcel parcel) {
        m.checkNotNullParameter(parcel, "in");
        return new DescriptionResult(parcel.readLong(), parcel.readString());
    }

    @Override // android.os.Parcelable$Creator
    public /* bridge */ /* synthetic */ DescriptionResult createFromParcel(Parcel parcel) {
        return createFromParcel(parcel);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable$Creator
    public final DescriptionResult[] newArray(int i) {
        return new DescriptionResult[i];
    }

    @Override // android.os.Parcelable$Creator
    public /* bridge */ /* synthetic */ DescriptionResult[] newArray(int i) {
        return newArray(i);
    }
}
