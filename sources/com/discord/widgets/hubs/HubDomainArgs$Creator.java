package com.discord.widgets.hubs;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import d0.z.d.m;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class HubDomainArgs$Creator implements Parcelable$Creator<HubDomainArgs> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable$Creator
    public final HubDomainArgs createFromParcel(Parcel parcel) {
        m.checkNotNullParameter(parcel, "in");
        String string = parcel.readString();
        int i = parcel.readInt();
        ArrayList arrayList = new ArrayList(i);
        while (i != 0) {
            arrayList.add(DomainGuildInfo.CREATOR.createFromParcel(parcel));
            i--;
        }
        return new HubDomainArgs(string, arrayList);
    }

    @Override // android.os.Parcelable$Creator
    public /* bridge */ /* synthetic */ HubDomainArgs createFromParcel(Parcel parcel) {
        return createFromParcel(parcel);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable$Creator
    public final HubDomainArgs[] newArray(int i) {
        return new HubDomainArgs[i];
    }

    @Override // android.os.Parcelable$Creator
    public /* bridge */ /* synthetic */ HubDomainArgs[] newArray(int i) {
        return newArray(i);
    }
}
