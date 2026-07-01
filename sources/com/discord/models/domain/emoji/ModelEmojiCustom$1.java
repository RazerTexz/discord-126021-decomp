package com.discord.models.domain.emoji;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class ModelEmojiCustom$1 implements Parcelable$Creator<ModelEmojiCustom> {
    @Override // android.os.Parcelable$Creator
    public /* bridge */ /* synthetic */ ModelEmojiCustom createFromParcel(Parcel parcel) {
        return createFromParcel(parcel);
    }

    @Override // android.os.Parcelable$Creator
    public /* bridge */ /* synthetic */ ModelEmojiCustom[] newArray(int i) {
        return newArray(i);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable$Creator
    public ModelEmojiCustom createFromParcel(Parcel parcel) {
        long j = parcel.readLong();
        String string = parcel.readString();
        ArrayList arrayList = new ArrayList();
        parcel.readList(arrayList, null);
        return new ModelEmojiCustom(j, string, arrayList, parcel.readInt() > 0, parcel.readInt() > 0, parcel.readInt(), parcel.readString(), parcel.readInt() > 0, parcel.readInt() > 0, parcel.readInt() > 0, parcel.readLong());
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable$Creator
    public ModelEmojiCustom[] newArray(int i) {
        return new ModelEmojiCustom[i];
    }
}
