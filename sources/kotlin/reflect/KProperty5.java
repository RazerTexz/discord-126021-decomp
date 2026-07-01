package kotlin.reflect;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: kotlin.reflect.KMutableProperty0, reason: use source file name */
/* JADX INFO: compiled from: KProperty.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface KProperty5<V> extends KProperty6<V>, KProperty {

    /* JADX INFO: renamed from: kotlin.reflect.KMutableProperty0$Setter */
    /* JADX INFO: compiled from: KProperty.kt */
    public interface Setter<V> extends KProperty4<V>, Function1<V, Unit> {
    }

    /* JADX INFO: renamed from: getSetter */
    Setter<V> mo113getSetter();
}
