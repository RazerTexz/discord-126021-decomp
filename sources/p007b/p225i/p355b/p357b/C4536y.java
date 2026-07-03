package p007b.p225i.p355b.p357b;

import com.google.j2objc.annotations.Weak;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: renamed from: b.i.b.b.y */
/* JADX INFO: compiled from: Maps.java */
/* JADX INFO: loaded from: classes3.dex */
public class C4536y<K, V> extends AbstractC4522o0<K> {

    /* JADX INFO: renamed from: j */
    @Weak
    public final Map<K, V> f12111j;

    public C4536y(Map<K, V> map) {
        Objects.requireNonNull(map);
        this.f12111j = map;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return this.f12111j.containsKey(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.f12111j.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.f12111j.size();
    }
}
