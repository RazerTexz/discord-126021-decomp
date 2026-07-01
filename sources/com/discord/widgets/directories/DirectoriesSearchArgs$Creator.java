package com.discord.widgets.directories;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import d0.z.d.m;

/* JADX INFO: loaded from: classes2.dex */
public class DirectoriesSearchArgs$Creator implements Parcelable$Creator<DirectoriesSearchArgs> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable$Creator
    public final DirectoriesSearchArgs createFromParcel(Parcel parcel) {
        m.checkNotNullParameter(parcel, "in");
        return new DirectoriesSearchArgs(parcel.readLong());
    }

    @Override // android.os.Parcelable$Creator
    public /* bridge */ /* synthetic */ DirectoriesSearchArgs createFromParcel(Parcel parcel) {
        return createFromParcel(parcel);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable$Creator
    public final DirectoriesSearchArgs[] newArray(int i) {
        return new DirectoriesSearchArgs[i];
    }

    @Override // android.os.Parcelable$Creator
    public /* bridge */ /* synthetic */ DirectoriesSearchArgs[] newArray(int i) {
        return newArray(i);
    }
}
