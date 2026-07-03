package p600f0.p601e0.p611l;

import java.io.IOException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.util.List;
import p507d0.p580t.C12145m;

/* JADX INFO: renamed from: f0.e0.l.a */
/* JADX INFO: compiled from: NullProxySelector.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12346a extends ProxySelector {

    /* JADX INFO: renamed from: a */
    public static final C12346a f25808a = new C12346a();

    @Override // java.net.ProxySelector
    public void connectFailed(URI uri, SocketAddress socketAddress, IOException iOException) {
    }

    @Override // java.net.ProxySelector
    public List<Proxy> select(URI uri) {
        if (uri != null) {
            return C12145m.listOf(Proxy.NO_PROXY);
        }
        throw new IllegalArgumentException("uri must not be null".toString());
    }
}
