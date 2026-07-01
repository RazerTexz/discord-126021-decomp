package b.m.a.g.d;

import d0.z.d.Intrinsics3;
import java.net.InetAddress;
import java.net.UnknownHostException;

/* JADX INFO: renamed from: b.m.a.g.d.d, reason: use source file name */
/* JADX INFO: compiled from: DnsResolver.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class DnsResolver2 implements DnsResolver {
    @Override // b.m.a.g.d.DnsResolver
    public InetAddress a(String str) throws UnknownHostException {
        Intrinsics3.checkParameterIsNotNull(str, "host");
        InetAddress byName = InetAddress.getByName(str);
        Intrinsics3.checkExpressionValueIsNotNull(byName, "InetAddress.getByName(host)");
        return byName;
    }
}
