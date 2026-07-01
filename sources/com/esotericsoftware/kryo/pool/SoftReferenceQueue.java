package com.esotericsoftware.kryo.pool;

import com.esotericsoftware.kryo.Kryo;
import java.lang.ref.SoftReference;
import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

/* JADX INFO: loaded from: classes.dex */
public class SoftReferenceQueue implements Queue<Kryo> {
    private Queue<SoftReference<Kryo>> delegate;

    /* JADX WARN: Multi-variable type inference failed */
    public SoftReferenceQueue(Queue<?> queue) {
        this.delegate = queue;
    }

    @Override // java.util.Queue, java.util.Collection
    public /* bridge */ /* synthetic */ boolean add(Object obj) {
        return add((Kryo) obj);
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends Kryo> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public void clear() {
        this.delegate.clear();
    }

    @Override // java.util.Collection
    public boolean contains(Object obj) {
        return this.delegate.contains(obj);
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Queue
    public /* bridge */ /* synthetic */ Kryo element() {
        return element();
    }

    @Override // java.util.Collection
    public boolean equals(Object obj) {
        return this.delegate.equals(obj);
    }

    @Override // java.util.Collection
    public int hashCode() {
        return this.delegate.hashCode();
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return this.delegate.isEmpty();
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator<Kryo> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Queue
    public /* bridge */ /* synthetic */ boolean offer(Kryo kryo) {
        return offer2(kryo);
    }

    @Override // java.util.Queue
    public /* bridge */ /* synthetic */ Kryo peek() {
        return peek();
    }

    @Override // java.util.Queue
    public /* bridge */ /* synthetic */ Kryo poll() {
        return poll();
    }

    @Override // java.util.Queue
    public /* bridge */ /* synthetic */ Kryo remove() {
        return remove();
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public int size() {
        return this.delegate.size();
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        throw new UnsupportedOperationException();
    }

    public String toString() {
        return getClass().getSimpleName() + super.toString();
    }

    public boolean add(Kryo kryo) {
        return this.delegate.add(new SoftReference<>(kryo));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.Queue
    public Kryo element() {
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: renamed from: offer, reason: avoid collision after fix types in other method */
    public boolean offer2(Kryo kryo) {
        return this.delegate.offer(new SoftReference<>(kryo));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.Queue
    public Kryo peek() {
        throw new UnsupportedOperationException();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.Queue
    public Kryo poll() {
        Kryo kryo;
        do {
            SoftReference<Kryo> softReferencePoll = this.delegate.poll();
            if (softReferencePoll == null) {
                return null;
            }
            kryo = softReferencePoll.get();
        } while (kryo == null);
        return kryo;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.Queue
    public Kryo remove() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }
}
