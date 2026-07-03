package com.google.android.exoplayer2.metadata;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.List;
import p007b.p225i.p226a.p242c.C2811j1;
import p007b.p225i.p226a.p242c.C2835p1;
import p007b.p225i.p226a.p242c.p259f3.C2738e0;

/* JADX INFO: loaded from: classes3.dex */
public final class Metadata implements Parcelable {
    public static final Parcelable.Creator<Metadata> CREATOR = new C10719a();

    /* JADX INFO: renamed from: j */
    public final Entry[] f19936j;

    public interface Entry extends Parcelable {
        /* JADX INFO: renamed from: n */
        void mo8878n(C2835p1.b bVar);

        @Nullable
        /* JADX INFO: renamed from: o0 */
        byte[] mo8879o0();

        @Nullable
        /* JADX INFO: renamed from: y */
        C2811j1 mo8880y();
    }

    /* JADX INFO: renamed from: com.google.android.exoplayer2.metadata.Metadata$a */
    public class C10719a implements Parcelable.Creator<Metadata> {
        @Override // android.os.Parcelable.Creator
        public Metadata createFromParcel(Parcel parcel) {
            return new Metadata(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public Metadata[] newArray(int i) {
            return new Metadata[i];
        }
    }

    public Metadata(Entry... entryArr) {
        this.f19936j = entryArr;
    }

    /* JADX INFO: renamed from: a */
    public Metadata m8877a(Entry... entryArr) {
        if (entryArr.length == 0) {
            return this;
        }
        Entry[] entryArr2 = this.f19936j;
        int i = C2738e0.f6708a;
        Object[] objArrCopyOf = Arrays.copyOf(entryArr2, entryArr2.length + entryArr.length);
        System.arraycopy(entryArr, 0, objArrCopyOf, entryArr2.length, entryArr.length);
        return new Metadata((Entry[]) objArrCopyOf);
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
        return Arrays.equals(this.f19936j, ((Metadata) obj).f19936j);
    }

    public int hashCode() {
        return Arrays.hashCode(this.f19936j);
    }

    public String toString() {
        String strValueOf = String.valueOf(Arrays.toString(this.f19936j));
        return strValueOf.length() != 0 ? "entries=".concat(strValueOf) : new String("entries=");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f19936j.length);
        for (Entry entry : this.f19936j) {
            parcel.writeParcelable(entry, 0);
        }
    }

    public Metadata(List<? extends Entry> list) {
        this.f19936j = (Entry[]) list.toArray(new Entry[0]);
    }

    public Metadata(Parcel parcel) {
        this.f19936j = new Entry[parcel.readInt()];
        int i = 0;
        while (true) {
            Entry[] entryArr = this.f19936j;
            if (i >= entryArr.length) {
                return;
            }
            entryArr[i] = (Entry) parcel.readParcelable(Entry.class.getClassLoader());
            i++;
        }
    }
}
