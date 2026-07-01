package f0.e0.k.i;

import f0.Protocol2;
import java.util.List;
import javax.net.ssl.SSLSocket;

/* JADX INFO: renamed from: f0.e0.k.i.k, reason: use source file name */
/* JADX INFO: compiled from: SocketAdapter.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface SocketAdapter {
    boolean a(SSLSocket sSLSocket);

    boolean b();

    String c(SSLSocket sSLSocket);

    void d(SSLSocket sSLSocket, String str, List<? extends Protocol2> list);
}
