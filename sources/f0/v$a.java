package f0;

import java.security.cert.Certificate;
import java.util.List;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: Handshake.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class v$a extends d0.z.d.o implements Function0<List<? extends Certificate>> {
    public final /* synthetic */ List $peerCertificatesCopy;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v$a(List list) {
        super(0);
        this.$peerCertificatesCopy = list;
    }

    @Override // kotlin.jvm.functions.Function0
    public List<? extends Certificate> invoke() {
        return this.$peerCertificatesCopy;
    }
}
