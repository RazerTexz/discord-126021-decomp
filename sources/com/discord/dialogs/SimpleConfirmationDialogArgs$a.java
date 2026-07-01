package com.discord.dialogs;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import d0.z.d.m;

/* JADX INFO: loaded from: classes.dex */
public class SimpleConfirmationDialogArgs$a implements Parcelable$Creator<SimpleConfirmationDialogArgs> {
    @Override // android.os.Parcelable$Creator
    public SimpleConfirmationDialogArgs createFromParcel(Parcel parcel) {
        m.checkNotNullParameter(parcel, "in");
        return new SimpleConfirmationDialogArgs(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
    }

    @Override // android.os.Parcelable$Creator
    public SimpleConfirmationDialogArgs[] newArray(int i) {
        return new SimpleConfirmationDialogArgs[i];
    }
}
