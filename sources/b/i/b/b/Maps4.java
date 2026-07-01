package b.i.b.b;

import com.google.j2objc.annotations.Weak;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: renamed from: b.i.b.b.y, reason: use source file name */
/* JADX INFO: compiled from: Maps.java */
/* JADX INFO: loaded from: classes3.dex */
public class Maps4<K, V> extends Sets3<K> {

    @Weak
    public final Map<K, V> j;

    public Maps4(Map<K, V> map) {
        Objects.requireNonNull(map);
        this.j = map;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return this.j.containsKey(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.j.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.j.size();
    }
}
