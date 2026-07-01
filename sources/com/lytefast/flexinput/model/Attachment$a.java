package com.lytefast.flexinput.model;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import d0.z.d.m;

/* JADX INFO: compiled from: Attachment.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class Attachment$a implements Parcelable$Creator<Attachment<?>> {
    @Override // android.os.Parcelable$Creator
    public Attachment<?> createFromParcel(Parcel parcel) {
        m.checkNotNullParameter(parcel, "parcelIn");
        return new Attachment<>(parcel);
    }

    @Override // android.os.Parcelable$Creator
    public Attachment<?>[] newArray(int i) {
        return new Attachment[i];
    }
}
