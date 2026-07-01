package kotlin;

import androidx.exifinterface.media.ExifInterface;

/* JADX INFO: compiled from: Lazy.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface Lazy<T> {
    T getValue();

    boolean isInitialized();
}
