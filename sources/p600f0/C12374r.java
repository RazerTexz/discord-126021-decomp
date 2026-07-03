package p600f0;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p580t.C12141k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: f0.r */
/* JADX INFO: compiled from: Dns.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12374r implements InterfaceC12375s {
    @Override // p600f0.InterfaceC12375s
    /* JADX INFO: renamed from: a */
    public List<InetAddress> mo10392a(String str) throws UnknownHostException {
        C12238m.checkParameterIsNotNull(str, "hostname");
        try {
            InetAddress[] allByName = InetAddress.getAllByName(str);
            C12238m.checkExpressionValueIsNotNull(allByName, "InetAddress.getAllByName(hostname)");
            return C12141k.toList(allByName);
        } catch (NullPointerException e) {
            UnknownHostException unknownHostException = new UnknownHostException(C1643a.m883w("Broken system behaviour for dns lookup of ", str));
            unknownHostException.initCause(e);
            throw unknownHostException;
        }
    }
}
