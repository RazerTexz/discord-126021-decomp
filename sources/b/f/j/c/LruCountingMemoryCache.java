package b.f.j.c;

import b.f.j.c.CountingMemoryCache;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* JADX INFO: renamed from: b.f.j.c.u, reason: use source file name */
/* JADX INFO: compiled from: LruCountingMemoryCache.java */
/* JADX INFO: loaded from: classes.dex */
public class LruCountingMemoryCache<K, V> implements ValueDescriptor<CountingMemoryCache.a<K, V>> {
    public final /* synthetic */ ValueDescriptor a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LruCountingMemoryCache2 f560b;

    public LruCountingMemoryCache(LruCountingMemoryCache2 lruCountingMemoryCache2, ValueDescriptor valueDescriptor) {
        this.f560b = lruCountingMemoryCache2;
        this.a = valueDescriptor;
    }

    @Override // b.f.j.c.ValueDescriptor
    public int a(Object obj) {
        CountingMemoryCache.a aVar = (CountingMemoryCache.a) obj;
        return this.f560b.h ? aVar.f : this.a.a(aVar.f558b.u());
    }
}
