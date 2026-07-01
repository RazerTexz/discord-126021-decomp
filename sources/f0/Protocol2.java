package f0;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import java.io.IOException;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: f0.y, reason: use source file name */
/* JADX INFO: compiled from: Protocol.kt */
/* JADX INFO: loaded from: classes3.dex */
public enum Protocol2 {
    HTTP_1_0("http/1.0"),
    HTTP_1_1("http/1.1"),
    SPDY_3("spdy/3.1"),
    HTTP_2("h2"),
    H2_PRIOR_KNOWLEDGE("h2_prior_knowledge"),
    QUIC("quic");

    public static final a q = new a(null);
    private final String protocol;

    /* JADX INFO: renamed from: f0.y$a */
    /* JADX INFO: compiled from: Protocol.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final Protocol2 a(String str) throws IOException {
            Intrinsics3.checkParameterIsNotNull(str, "protocol");
            Protocol2 protocol2 = Protocol2.HTTP_1_0;
            if (!Intrinsics3.areEqual(str, protocol2.protocol)) {
                protocol2 = Protocol2.HTTP_1_1;
                if (!Intrinsics3.areEqual(str, protocol2.protocol)) {
                    protocol2 = Protocol2.H2_PRIOR_KNOWLEDGE;
                    if (!Intrinsics3.areEqual(str, protocol2.protocol)) {
                        protocol2 = Protocol2.HTTP_2;
                        if (!Intrinsics3.areEqual(str, protocol2.protocol)) {
                            protocol2 = Protocol2.SPDY_3;
                            if (!Intrinsics3.areEqual(str, protocol2.protocol)) {
                                protocol2 = Protocol2.QUIC;
                                if (!Intrinsics3.areEqual(str, protocol2.protocol)) {
                                    throw new IOException(outline.w("Unexpected protocol: ", str));
                                }
                            }
                        }
                    }
                }
            }
            return protocol2;
        }
    }

    Protocol2(String str) {
        this.protocol = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.protocol;
    }
}
