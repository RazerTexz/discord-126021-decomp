package com.discord.widgets.botuikit;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import com.discord.api.interaction.InteractionModalCreate;
import d0.z.d.m;

/* JADX INFO: loaded from: classes2.dex */
public class ModalComponent$Options$Creator implements Parcelable$Creator<ModalComponent$Options> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable$Creator
    public final ModalComponent$Options createFromParcel(Parcel parcel) {
        m.checkNotNullParameter(parcel, "in");
        return new ModalComponent$Options((InteractionModalCreate) parcel.readSerializable());
    }

    @Override // android.os.Parcelable$Creator
    public /* bridge */ /* synthetic */ ModalComponent$Options createFromParcel(Parcel parcel) {
        return createFromParcel(parcel);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable$Creator
    public final ModalComponent$Options[] newArray(int i) {
        return new ModalComponent$Options[i];
    }

    @Override // android.os.Parcelable$Creator
    public /* bridge */ /* synthetic */ ModalComponent$Options[] newArray(int i) {
        return newArray(i);
    }
}
