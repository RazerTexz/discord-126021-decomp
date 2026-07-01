package com.discord.widgets.settings.premium;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import com.discord.utilities.UtcDateTimeParceler;
import d0.z.d.m;

/* JADX INFO: loaded from: classes2.dex */
public class ClaimStatus$Unclaimed$Creator implements Parcelable$Creator<ClaimStatus$Unclaimed> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable$Creator
    public final ClaimStatus$Unclaimed createFromParcel(Parcel parcel) {
        m.checkNotNullParameter(parcel, "in");
        return new ClaimStatus$Unclaimed(parcel.readLong(), UtcDateTimeParceler.INSTANCE.create(parcel));
    }

    @Override // android.os.Parcelable$Creator
    public /* bridge */ /* synthetic */ ClaimStatus$Unclaimed createFromParcel(Parcel parcel) {
        return createFromParcel(parcel);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable$Creator
    public final ClaimStatus$Unclaimed[] newArray(int i) {
        return new ClaimStatus$Unclaimed[i];
    }

    @Override // android.os.Parcelable$Creator
    public /* bridge */ /* synthetic */ ClaimStatus$Unclaimed[] newArray(int i) {
        return newArray(i);
    }
}
