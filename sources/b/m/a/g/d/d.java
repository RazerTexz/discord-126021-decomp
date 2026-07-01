package b.m.a.g.d;

import d0.z.d.m;
import java.net.InetAddress;
import java.net.UnknownHostException;

/* JADX INFO: compiled from: DnsResolver.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d implements c {
    @Override // b.m.a.g.d.c
    public InetAddress a(String str) throws UnknownHostException {
        m.checkParameterIsNotNull(str, "host");
        InetAddress byName = InetAddress.getByName(str);
        m.checkExpressionValueIsNotNull(byName, "InetAddress.getByName(host)");
        return byName;
    }
}
