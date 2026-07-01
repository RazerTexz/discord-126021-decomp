package com.discord.widgets.guilds.create;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import d0.z.d.m;

/* JADX INFO: loaded from: classes2.dex */
public class WidgetGuildCreate$Options$Creator implements Parcelable$Creator<WidgetGuildCreate$Options> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable$Creator
    public final WidgetGuildCreate$Options createFromParcel(Parcel parcel) {
        m.checkNotNullParameter(parcel, "in");
        return new WidgetGuildCreate$Options(parcel.readString(), (StockGuildTemplate) Enum.valueOf(StockGuildTemplate.class, parcel.readString()), parcel.readInt() != 0, parcel.readString(), parcel.readInt() != 0);
    }

    @Override // android.os.Parcelable$Creator
    public /* bridge */ /* synthetic */ WidgetGuildCreate$Options createFromParcel(Parcel parcel) {
        return createFromParcel(parcel);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable$Creator
    public final WidgetGuildCreate$Options[] newArray(int i) {
        return new WidgetGuildCreate$Options[i];
    }

    @Override // android.os.Parcelable$Creator
    public /* bridge */ /* synthetic */ WidgetGuildCreate$Options[] newArray(int i) {
        return newArray(i);
    }
}
