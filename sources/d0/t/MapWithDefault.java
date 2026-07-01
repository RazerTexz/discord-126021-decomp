package d0.t;

import d0.z.d.g0.KMarkers;
import java.util.Map;

/* JADX INFO: renamed from: d0.t.e0, reason: use source file name */
/* JADX INFO: compiled from: MapWithDefault.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface MapWithDefault<K, V> extends Map<K, V>, KMarkers {
    V getOrImplicitDefault(K k);
}
