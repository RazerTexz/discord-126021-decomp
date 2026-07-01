package b.i.a.b.j;

import java.util.Set;

/* JADX INFO: compiled from: TransportFactoryImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public final class j implements b.i.a.b.g {
    public final Set<b.i.a.b.b> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i f767b;
    public final m c;

    public j(Set<b.i.a.b.b> set, i iVar, m mVar) {
        this.a = set;
        this.f767b = iVar;
        this.c = mVar;
    }

    @Override // b.i.a.b.g
    public <T> b.i.a.b.f<T> a(String str, Class<T> cls, b.i.a.b.b bVar, b.i.a.b.e<T, byte[]> eVar) {
        if (this.a.contains(bVar)) {
            return new l(this.f767b, str, bVar, eVar, this.c);
        }
        throw new IllegalArgumentException(String.format("%s is not supported byt this factory. Supported encodings are: %s.", bVar, this.a));
    }
}
