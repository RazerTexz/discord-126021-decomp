package com.discord.models.domain.emoji;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class ModelEmojiUnicode$1 implements Parcelable$Creator<ModelEmojiUnicode> {
    @Override // android.os.Parcelable$Creator
    public /* bridge */ /* synthetic */ ModelEmojiUnicode createFromParcel(Parcel parcel) {
        return createFromParcel(parcel);
    }

    @Override // android.os.Parcelable$Creator
    public /* bridge */ /* synthetic */ ModelEmojiUnicode[] newArray(int i) {
        return newArray(i);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable$Creator
    public ModelEmojiUnicode createFromParcel(Parcel parcel) {
        ArrayList arrayList = new ArrayList();
        parcel.readStringList(arrayList);
        String string = parcel.readString();
        boolean z2 = parcel.readInt() > 0;
        boolean z3 = parcel.readInt() > 0;
        boolean z4 = parcel.readInt() > 0;
        boolean z5 = parcel.readInt() > 0;
        ArrayList arrayList2 = new ArrayList();
        parcel.readTypedList(arrayList2, this);
        return new ModelEmojiUnicode(arrayList, string, z2, z3, z4, z5, arrayList2);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable$Creator
    public ModelEmojiUnicode[] newArray(int i) {
        return new ModelEmojiUnicode[i];
    }
}
