package kotlin.reflect;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: KProperty.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface KMutableProperty0<V> extends KProperty0<V>, KProperty {

    /* JADX INFO: compiled from: KProperty.kt */
    public interface Setter<V> extends KMutableProperty$Setter<V>, Function1<V, Unit> {
    }

    /* JADX INFO: renamed from: getSetter */
    Setter<V> mo11490getSetter();
}
