package com.discord.widgets.settings.premium;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import com.discord.utilities.UtcDateTimeParceler;
import d0.z.d.m;

/* JADX INFO: loaded from: classes2.dex */
public class ClaimStatus$Claimed$Creator implements Parcelable$Creator<ClaimStatus$Claimed> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable$Creator
    public final ClaimStatus$Claimed createFromParcel(Parcel parcel) {
        m.checkNotNullParameter(parcel, "in");
        return new ClaimStatus$Claimed(parcel.readLong(), parcel.readString(), parcel.readString(), parcel.readString(), UtcDateTimeParceler.INSTANCE.create(parcel));
    }

    @Override // android.os.Parcelable$Creator
    public /* bridge */ /* synthetic */ ClaimStatus$Claimed createFromParcel(Parcel parcel) {
        return createFromParcel(parcel);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable$Creator
    public final ClaimStatus$Claimed[] newArray(int i) {
        return new ClaimStatus$Claimed[i];
    }

    @Override // android.os.Parcelable$Creator
    public /* bridge */ /* synthetic */ ClaimStatus$Claimed[] newArray(int i) {
        return newArray(i);
    }
}
