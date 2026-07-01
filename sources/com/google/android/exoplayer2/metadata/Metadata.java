package com.google.android.exoplayer2.metadata;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable$Creator;
import androidx.annotation.Nullable;
import b.i.a.c.f3.e0;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class Metadata implements Parcelable {
    public static final Parcelable$Creator<Metadata> CREATOR = new Metadata$a();
    public final Metadata$Entry[] j;

    public Metadata(Metadata$Entry... metadata$EntryArr) {
        this.j = metadata$EntryArr;
    }

    public Metadata a(Metadata$Entry... metadata$EntryArr) {
        if (metadata$EntryArr.length == 0) {
            return this;
        }
        Metadata$Entry[] metadata$EntryArr2 = this.j;
        int i = e0.a;
        Object[] objArrCopyOf = Arrays.copyOf(metadata$EntryArr2, metadata$EntryArr2.length + metadata$EntryArr.length);
        System.arraycopy(metadata$EntryArr, 0, objArrCopyOf, metadata$EntryArr2.length, metadata$EntryArr.length);
        return new Metadata((Metadata$Entry[]) objArrCopyOf);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Metadata.class != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.j, ((Metadata) obj).j);
    }

    public int hashCode() {
        return Arrays.hashCode(this.j);
    }

    public String toString() {
        String strValueOf = String.valueOf(Arrays.toString(this.j));
        return strValueOf.length() != 0 ? "entries=".concat(strValueOf) : new String("entries=");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.j.length);
        for (Metadata$Entry metadata$Entry : this.j) {
            parcel.writeParcelable(metadata$Entry, 0);
        }
    }

    public Metadata(List<? extends Metadata$Entry> list) {
        this.j = (Metadata$Entry[]) list.toArray(new Metadata$Entry[0]);
    }

    public Metadata(Parcel parcel) {
        this.j = new Metadata$Entry[parcel.readInt()];
        int i = 0;
        while (true) {
            Metadata$Entry[] metadata$EntryArr = this.j;
            if (i >= metadata$EntryArr.length) {
                return;
            }
            metadata$EntryArr[i] = (Metadata$Entry) parcel.readParcelable(Metadata$Entry.class.getClassLoader());
            i++;
        }
    }
}
