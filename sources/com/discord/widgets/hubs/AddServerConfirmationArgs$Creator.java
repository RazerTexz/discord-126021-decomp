package com.discord.widgets.hubs;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import d0.z.d.m;

/* JADX INFO: loaded from: classes2.dex */
public class AddServerConfirmationArgs$Creator implements Parcelable$Creator<AddServerConfirmationArgs> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable$Creator
    public final AddServerConfirmationArgs createFromParcel(Parcel parcel) {
        m.checkNotNullParameter(parcel, "in");
        return new AddServerConfirmationArgs(parcel.readLong(), parcel.readString());
    }

    @Override // android.os.Parcelable$Creator
    public /* bridge */ /* synthetic */ AddServerConfirmationArgs createFromParcel(Parcel parcel) {
        return createFromParcel(parcel);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable$Creator
    public final AddServerConfirmationArgs[] newArray(int i) {
        return new AddServerConfirmationArgs[i];
    }

    @Override // android.os.Parcelable$Creator
    public /* bridge */ /* synthetic */ AddServerConfirmationArgs[] newArray(int i) {
        return newArray(i);
    }
}
