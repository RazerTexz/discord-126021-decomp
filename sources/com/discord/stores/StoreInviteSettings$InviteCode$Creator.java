package com.discord.stores;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import d0.z.d.m;

/* JADX INFO: loaded from: classes2.dex */
public class StoreInviteSettings$InviteCode$Creator implements Parcelable$Creator<StoreInviteSettings$InviteCode> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable$Creator
    public final StoreInviteSettings$InviteCode createFromParcel(Parcel parcel) {
        m.checkNotNullParameter(parcel, "in");
        return new StoreInviteSettings$InviteCode(parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? Long.valueOf(parcel.readLong()) : null);
    }

    @Override // android.os.Parcelable$Creator
    public /* bridge */ /* synthetic */ StoreInviteSettings$InviteCode createFromParcel(Parcel parcel) {
        return createFromParcel(parcel);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable$Creator
    public final StoreInviteSettings$InviteCode[] newArray(int i) {
        return new StoreInviteSettings$InviteCode[i];
    }

    @Override // android.os.Parcelable$Creator
    public /* bridge */ /* synthetic */ StoreInviteSettings$InviteCode[] newArray(int i) {
        return newArray(i);
    }
}
