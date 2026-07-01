package b.i.a.b.j;

import b.i.a.b.Encoding2;
import b.i.a.b.Transformer;
import b.i.a.b.Transport2;
import b.i.a.b.TransportFactory;
import java.util.Set;

/* JADX INFO: renamed from: b.i.a.b.j.j, reason: use source file name */
/* JADX INFO: compiled from: TransportFactoryImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public final class TransportFactoryImpl implements TransportFactory {
    public final Set<Encoding2> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TransportContext f767b;
    public final TransportInternal c;

    public TransportFactoryImpl(Set<Encoding2> set, TransportContext transportContext, TransportInternal transportInternal) {
        this.a = set;
        this.f767b = transportContext;
        this.c = transportInternal;
    }

    @Override // b.i.a.b.TransportFactory
    public <T> Transport2<T> a(String str, Class<T> cls, Encoding2 encoding2, Transformer<T, byte[]> transformer) {
        if (this.a.contains(encoding2)) {
            return new TransportImpl2(this.f767b, str, encoding2, transformer, this.c);
        }
        throw new IllegalArgumentException(String.format("%s is not supported byt this factory. Supported encodings are: %s.", encoding2, this.a));
    }
}
