package f0.e0.l;

import d0.t.CollectionsJVM;
import java.io.IOException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.util.List;

/* JADX INFO: renamed from: f0.e0.l.a, reason: use source file name */
/* JADX INFO: compiled from: NullProxySelector.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class NullProxySelector extends ProxySelector {
    public static final NullProxySelector a = new NullProxySelector();

    @Override // java.net.ProxySelector
    public void connectFailed(URI uri, SocketAddress socketAddress, IOException iOException) {
    }

    @Override // java.net.ProxySelector
    public List<Proxy> select(URI uri) {
        if (uri != null) {
            return CollectionsJVM.listOf(Proxy.NO_PROXY);
        }
        throw new IllegalArgumentException("uri must not be null".toString());
    }
}
