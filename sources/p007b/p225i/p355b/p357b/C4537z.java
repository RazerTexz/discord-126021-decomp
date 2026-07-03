package p007b.p225i.p355b.p357b;

import com.google.j2objc.annotations.Weak;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;

/* JADX INFO: renamed from: b.i.b.b.z */
/* JADX INFO: compiled from: Maps.java */
/* JADX INFO: loaded from: classes3.dex */
public class C4537z<K, V> extends AbstractCollection<V> {

    /* JADX INFO: renamed from: j */
    @Weak
    public final Map<K, V> f12112j;

    public C4537z(Map<K, V> map) {
        this.f12112j = map;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public void clear() {
        this.f12112j.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean contains(@NullableDecl Object obj) {
        return this.f12112j.containsValue(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return this.f12112j.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<V> iterator() {
        return new C4534w(this.f12112j.entrySet().iterator());
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean remove(Object obj) {
        try {
            return super.remove(obj);
        } catch (UnsupportedOperationException unused) {
            for (Map.Entry<K, V> entry : this.f12112j.entrySet()) {
                if (C3404f.m4252V(obj, entry.getValue())) {
                    this.f12112j.remove(entry.getKey());
                    return true;
                }
            }
            return false;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean removeAll(Collection<?> collection) {
        try {
            Objects.requireNonNull(collection);
            return super.removeAll(collection);
        } catch (UnsupportedOperationException unused) {
            HashSet hashSet = new HashSet();
            for (Map.Entry<K, V> entry : this.f12112j.entrySet()) {
                if (collection.contains(entry.getValue())) {
                    hashSet.add(entry.getKey());
                }
            }
            return this.f12112j.keySet().removeAll(hashSet);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean retainAll(Collection<?> collection) {
        try {
            Objects.requireNonNull(collection);
            return super.retainAll(collection);
        } catch (UnsupportedOperationException unused) {
            HashSet hashSet = new HashSet();
            for (Map.Entry<K, V> entry : this.f12112j.entrySet()) {
                if (collection.contains(entry.getValue())) {
                    hashSet.add(entry.getKey());
                }
            }
            return this.f12112j.keySet().retainAll(hashSet);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        return this.f12112j.size();
    }
}
