package com.discord.widgets.hubs;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import d0.z.d.m;

/* JADX INFO: loaded from: classes2.dex */
public class RadioSelectorItem$Creator implements Parcelable$Creator<RadioSelectorItem> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable$Creator
    public final RadioSelectorItem createFromParcel(Parcel parcel) {
        m.checkNotNullParameter(parcel, "in");
        return new RadioSelectorItem(parcel.readInt(), parcel.readString(), parcel.readInt() != 0);
    }

    @Override // android.os.Parcelable$Creator
    public /* bridge */ /* synthetic */ RadioSelectorItem createFromParcel(Parcel parcel) {
        return createFromParcel(parcel);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable$Creator
    public final RadioSelectorItem[] newArray(int i) {
        return new RadioSelectorItem[i];
    }

    @Override // android.os.Parcelable$Creator
    public /* bridge */ /* synthetic */ RadioSelectorItem[] newArray(int i) {
        return newArray(i);
    }
}
