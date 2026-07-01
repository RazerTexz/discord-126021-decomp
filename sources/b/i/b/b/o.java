package b.i.b.b;

import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: compiled from: ImmutableEntry.java */
/* JADX INFO: loaded from: classes3.dex */
public class o<K, V> extends f<K, V> implements Serializable {
    private static final long serialVersionUID = 0;

    @NullableDecl
    public final K key;

    @NullableDecl
    public final V value;

    public o(@NullableDecl K k, @NullableDecl V v) {
        this.key = k;
        this.value = v;
    }

    @Override // b.i.b.b.f, java.util.Map$Entry
    @NullableDecl
    public final K getKey() {
        return this.key;
    }

    @Override // b.i.b.b.f, java.util.Map$Entry
    @NullableDecl
    public final V getValue() {
        return this.value;
    }

    @Override // java.util.Map$Entry
    public final V setValue(V v) {
        throw new UnsupportedOperationException();
    }
}
