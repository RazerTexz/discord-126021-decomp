package com.discord.widgets.hubs;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import d0.z.d.m;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class RadioSelectorItems$Creator implements Parcelable$Creator<RadioSelectorItems> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable$Creator
    public final RadioSelectorItems createFromParcel(Parcel parcel) {
        m.checkNotNullParameter(parcel, "in");
        String string = parcel.readString();
        int i = parcel.readInt();
        ArrayList arrayList = new ArrayList(i);
        while (i != 0) {
            arrayList.add(RadioSelectorItem.CREATOR.createFromParcel(parcel));
            i--;
        }
        return new RadioSelectorItems(string, arrayList);
    }

    @Override // android.os.Parcelable$Creator
    public /* bridge */ /* synthetic */ RadioSelectorItems createFromParcel(Parcel parcel) {
        return createFromParcel(parcel);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable$Creator
    public final RadioSelectorItems[] newArray(int i) {
        return new RadioSelectorItems[i];
    }

    @Override // android.os.Parcelable$Creator
    public /* bridge */ /* synthetic */ RadioSelectorItems[] newArray(int i) {
        return newArray(i);
    }
}
