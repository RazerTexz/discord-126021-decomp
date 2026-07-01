package f0;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

/* JADX INFO: compiled from: Dns.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class r implements s {
    @Override // f0.s
    public List<InetAddress> a(String str) throws UnknownHostException {
        d0.z.d.m.checkParameterIsNotNull(str, "hostname");
        try {
            InetAddress[] allByName = InetAddress.getAllByName(str);
            d0.z.d.m.checkExpressionValueIsNotNull(allByName, "InetAddress.getAllByName(hostname)");
            return d0.t.k.toList(allByName);
        } catch (NullPointerException e) {
            UnknownHostException unknownHostException = new UnknownHostException(b.d.b.a.a.w("Broken system behaviour for dns lookup of ", str));
            unknownHostException.initCause(e);
            throw unknownHostException;
        }
    }
}
