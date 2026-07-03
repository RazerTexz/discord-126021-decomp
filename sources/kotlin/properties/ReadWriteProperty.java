package kotlin.properties;

import androidx.exifinterface.media.ExifInterface;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: Interfaces.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface ReadWriteProperty<T, V> {
    V getValue(T thisRef, KProperty<?> property);

    void setValue(T thisRef, KProperty<?> property, V value);
}
