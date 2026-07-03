package p600f0;

import java.io.IOException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: f0.y */
/* JADX INFO: compiled from: Protocol.kt */
/* JADX INFO: loaded from: classes3.dex */
public enum EnumC12381y {
    HTTP_1_0("http/1.0"),
    HTTP_1_1("http/1.1"),
    SPDY_3("spdy/3.1"),
    HTTP_2("h2"),
    H2_PRIOR_KNOWLEDGE("h2_prior_knowledge"),
    QUIC("quic");


    /* JADX INFO: renamed from: q */
    public static final a f26062q = new a(null);
    private final String protocol;

    /* JADX INFO: renamed from: f0.y$a */
    /* JADX INFO: compiled from: Protocol.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        /* JADX INFO: renamed from: a */
        public final EnumC12381y m10423a(String str) throws IOException {
            C12238m.checkParameterIsNotNull(str, "protocol");
            EnumC12381y enumC12381y = EnumC12381y.HTTP_1_0;
            if (!C12238m.areEqual(str, enumC12381y.protocol)) {
                enumC12381y = EnumC12381y.HTTP_1_1;
                if (!C12238m.areEqual(str, enumC12381y.protocol)) {
                    enumC12381y = EnumC12381y.H2_PRIOR_KNOWLEDGE;
                    if (!C12238m.areEqual(str, enumC12381y.protocol)) {
                        enumC12381y = EnumC12381y.HTTP_2;
                        if (!C12238m.areEqual(str, enumC12381y.protocol)) {
                            enumC12381y = EnumC12381y.SPDY_3;
                            if (!C12238m.areEqual(str, enumC12381y.protocol)) {
                                enumC12381y = EnumC12381y.QUIC;
                                if (!C12238m.areEqual(str, enumC12381y.protocol)) {
                                    throw new IOException(C1643a.m883w("Unexpected protocol: ", str));
                                }
                            }
                        }
                    }
                }
            }
            return enumC12381y;
        }
    }

    EnumC12381y(String str) {
        this.protocol = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.protocol;
    }
}
