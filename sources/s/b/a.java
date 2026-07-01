package s.b;

import android.os.Parcel;

/* JADX INFO: compiled from: Parceler.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface a<T> {
    T create(Parcel parcel);

    void write(T t, Parcel parcel, int i);
}
