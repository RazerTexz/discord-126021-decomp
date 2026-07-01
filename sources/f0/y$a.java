package f0;

import java.io.IOException;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: Protocol.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class y$a {
    public y$a(DefaultConstructorMarker defaultConstructorMarker) {
    }

    public final y a(String str) throws IOException {
        d0.z.d.m.checkParameterIsNotNull(str, "protocol");
        y yVar = y.HTTP_1_0;
        if (!d0.z.d.m.areEqual(str, y.f(yVar))) {
            yVar = y.HTTP_1_1;
            if (!d0.z.d.m.areEqual(str, y.f(yVar))) {
                yVar = y.H2_PRIOR_KNOWLEDGE;
                if (!d0.z.d.m.areEqual(str, y.f(yVar))) {
                    yVar = y.HTTP_2;
                    if (!d0.z.d.m.areEqual(str, y.f(yVar))) {
                        yVar = y.SPDY_3;
                        if (!d0.z.d.m.areEqual(str, y.f(yVar))) {
                            yVar = y.QUIC;
                            if (!d0.z.d.m.areEqual(str, y.f(yVar))) {
                                throw new IOException(b.d.b.a.a.w("Unexpected protocol: ", str));
                            }
                        }
                    }
                }
            }
        }
        return yVar;
    }
}
