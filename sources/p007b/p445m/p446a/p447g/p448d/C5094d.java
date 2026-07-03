package p007b.p445m.p446a.p447g.p448d;

import java.net.InetAddress;
import java.net.UnknownHostException;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.m.a.g.d.d */
/* JADX INFO: compiled from: DnsResolver.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C5094d implements InterfaceC5093c {
    @Override // p007b.p445m.p446a.p447g.p448d.InterfaceC5093c
    /* JADX INFO: renamed from: a */
    public InetAddress mo7143a(String str) throws UnknownHostException {
        C12238m.checkParameterIsNotNull(str, "host");
        InetAddress byName = InetAddress.getByName(str);
        C12238m.checkExpressionValueIsNotNull(byName, "InetAddress.getByName(host)");
        return byName;
    }
}
