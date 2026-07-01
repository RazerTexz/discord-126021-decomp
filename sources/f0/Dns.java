package f0;

import b.d.b.a.outline;
import d0.t._Arrays;
import d0.z.d.Intrinsics3;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

/* JADX INFO: renamed from: f0.r, reason: use source file name */
/* JADX INFO: compiled from: Dns.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class Dns implements Dns2 {
    @Override // f0.Dns2
    public List<InetAddress> a(String str) throws UnknownHostException {
        Intrinsics3.checkParameterIsNotNull(str, "hostname");
        try {
            InetAddress[] allByName = InetAddress.getAllByName(str);
            Intrinsics3.checkExpressionValueIsNotNull(allByName, "InetAddress.getAllByName(hostname)");
            return _Arrays.toList(allByName);
        } catch (NullPointerException e) {
            UnknownHostException unknownHostException = new UnknownHostException(outline.w("Broken system behaviour for dns lookup of ", str));
            unknownHostException.initCause(e);
            throw unknownHostException;
        }
    }
}
