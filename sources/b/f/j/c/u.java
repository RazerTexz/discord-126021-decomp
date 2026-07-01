package b.f.j.c;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* JADX INFO: compiled from: LruCountingMemoryCache.java */
/* JADX INFO: loaded from: classes.dex */
public class u<K, V> implements b0<m$a<K, V>> {
    public final /* synthetic */ b0 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ v f560b;

    public u(v vVar, b0 b0Var) {
        this.f560b = vVar;
        this.a = b0Var;
    }

    @Override // b.f.j.c.b0
    public int a(Object obj) {
        m$a m_a = (m$a) obj;
        return this.f560b.h ? m_a.f : this.a.a(m_a.f558b.u());
    }
}
