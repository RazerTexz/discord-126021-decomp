package b.i.a.b;

/* JADX INFO: renamed from: b.i.a.b.g, reason: use source file name */
/* JADX INFO: compiled from: TransportFactory.java */
/* JADX INFO: loaded from: classes3.dex */
public interface TransportFactory {
    <T> Transport2<T> a(String str, Class<T> cls, Encoding2 encoding2, Transformer<T, byte[]> transformer);
}
