package com.discord.widgets.hubs;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import d0.z.d.m;

/* JADX INFO: loaded from: classes2.dex */
public class AuthenticationResult$Creator implements Parcelable$Creator<AuthenticationResult> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable$Creator
    public final AuthenticationResult createFromParcel(Parcel parcel) {
        m.checkNotNullParameter(parcel, "in");
        return new AuthenticationResult(parcel.readLong());
    }

    @Override // android.os.Parcelable$Creator
    public /* bridge */ /* synthetic */ AuthenticationResult createFromParcel(Parcel parcel) {
        return createFromParcel(parcel);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable$Creator
    public final AuthenticationResult[] newArray(int i) {
        return new AuthenticationResult[i];
    }

    @Override // android.os.Parcelable$Creator
    public /* bridge */ /* synthetic */ AuthenticationResult[] newArray(int i) {
        return newArray(i);
    }
}
