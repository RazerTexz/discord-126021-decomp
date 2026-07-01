package f0.e0.g;

import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import f0.Address;
import f0.CertificatePinner;
import f0.Handshake;
import f0.e0.m.CertificateChainCleaner;
import java.security.cert.Certificate;
import java.util.List;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: f0.e0.g.g, reason: use source file name */
/* JADX INFO: compiled from: RealConnection.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class RealConnection extends Lambda implements Function0<List<? extends Certificate>> {
    public final /* synthetic */ Address $address;
    public final /* synthetic */ CertificatePinner $certificatePinner;
    public final /* synthetic */ Handshake $unverifiedHandshake;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RealConnection(CertificatePinner certificatePinner, Handshake handshake, Address address) {
        super(0);
        this.$certificatePinner = certificatePinner;
        this.$unverifiedHandshake = handshake;
        this.$address = address;
    }

    @Override // kotlin.jvm.functions.Function0
    public List<? extends Certificate> invoke() {
        CertificateChainCleaner certificateChainCleaner = this.$certificatePinner.d;
        if (certificateChainCleaner == null) {
            Intrinsics3.throwNpe();
        }
        return certificateChainCleaner.a(this.$unverifiedHandshake.c(), this.$address.a.g);
    }
}
