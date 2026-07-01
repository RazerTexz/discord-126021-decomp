package com.discord.widgets.directories;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import com.discord.models.hubs.DirectoryEntryCategory;
import d0.z.d.m;

/* JADX INFO: loaded from: classes2.dex */
public class DirectoryCategoryArgs$Creator implements Parcelable$Creator<DirectoryCategoryArgs> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable$Creator
    public final DirectoryCategoryArgs createFromParcel(Parcel parcel) {
        m.checkNotNullParameter(parcel, "in");
        return new DirectoryCategoryArgs((DirectoryEntryCategory) Enum.valueOf(DirectoryEntryCategory.class, parcel.readString()));
    }

    @Override // android.os.Parcelable$Creator
    public /* bridge */ /* synthetic */ DirectoryCategoryArgs createFromParcel(Parcel parcel) {
        return createFromParcel(parcel);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable$Creator
    public final DirectoryCategoryArgs[] newArray(int i) {
        return new DirectoryCategoryArgs[i];
    }

    @Override // android.os.Parcelable$Creator
    public /* bridge */ /* synthetic */ DirectoryCategoryArgs[] newArray(int i) {
        return newArray(i);
    }
}
