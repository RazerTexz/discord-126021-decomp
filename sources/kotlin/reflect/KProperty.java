package kotlin.reflect;

import androidx.exifinterface.media.ExifInterface;

/* JADX INFO: compiled from: KProperty.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface KProperty<V> extends KCallable<V> {

    /* JADX INFO: compiled from: KProperty.kt */
    public interface Getter<V> extends KFunction<V> {
    }

    boolean isConst();

    boolean isLateinit();
}
