package com.discord.widgets.nux;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import d0.z.d.m;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class GuildTemplateArgs$Creator implements Parcelable$Creator<GuildTemplateArgs> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable$Creator
    public final GuildTemplateArgs createFromParcel(Parcel parcel) {
        m.checkNotNullParameter(parcel, "in");
        String string = parcel.readString();
        String string2 = parcel.readString();
        int i = parcel.readInt();
        ArrayList arrayList = new ArrayList(i);
        while (i != 0) {
            arrayList.add((GuildTemplate) Enum.valueOf(GuildTemplate.class, parcel.readString()));
            i--;
        }
        return new GuildTemplateArgs(string, string2, arrayList, parcel.readInt() != 0, parcel.readInt() != 0);
    }

    @Override // android.os.Parcelable$Creator
    public /* bridge */ /* synthetic */ GuildTemplateArgs createFromParcel(Parcel parcel) {
        return createFromParcel(parcel);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable$Creator
    public final GuildTemplateArgs[] newArray(int i) {
        return new GuildTemplateArgs[i];
    }

    @Override // android.os.Parcelable$Creator
    public /* bridge */ /* synthetic */ GuildTemplateArgs[] newArray(int i) {
        return newArray(i);
    }
}
