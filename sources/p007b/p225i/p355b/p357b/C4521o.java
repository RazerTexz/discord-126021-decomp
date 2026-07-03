package p007b.p225i.p355b.p357b;

import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: renamed from: b.i.b.b.o */
/* JADX INFO: compiled from: ImmutableEntry.java */
/* JADX INFO: loaded from: classes3.dex */
public class C4521o<K, V> extends AbstractC4503f<K, V> implements Serializable {
    private static final long serialVersionUID = 0;

    @NullableDecl
    public final K key;

    @NullableDecl
    public final V value;

    public C4521o(@NullableDecl K k, @NullableDecl V v) {
        this.key = k;
        this.value = v;
    }

    @Override // p007b.p225i.p355b.p357b.AbstractC4503f, java.util.Map.Entry
    @NullableDecl
    public final K getKey() {
        return this.key;
    }

    @Override // p007b.p225i.p355b.p357b.AbstractC4503f, java.util.Map.Entry
    @NullableDecl
    public final V getValue() {
        return this.value;
    }

    @Override // java.util.Map.Entry
    public final V setValue(V v) {
        throw new UnsupportedOperationException();
    }
}
