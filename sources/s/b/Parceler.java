package s.b;

import android.os.Parcel;

/* JADX INFO: renamed from: s.b.a, reason: use source file name */
/* JADX INFO: compiled from: Parceler.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface Parceler<T> {
    T create(Parcel parcel);

    void write(T t, Parcel parcel, int i);
}
