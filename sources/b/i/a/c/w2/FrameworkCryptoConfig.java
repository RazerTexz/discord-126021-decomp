package b.i.a.c.w2;

import b.i.a.c.f3.Util2;
import b.i.a.c.v2.CryptoConfig;
import java.util.UUID;

/* JADX INFO: renamed from: b.i.a.c.w2.b0, reason: use source file name */
/* JADX INFO: compiled from: FrameworkCryptoConfig.java */
/* JADX INFO: loaded from: classes3.dex */
public final class FrameworkCryptoConfig implements CryptoConfig {
    public static final boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final UUID f1150b;
    public final byte[] c;
    public final boolean d;

    /* JADX WARN: Code duplicated, block: B:9:0x001e  */
    static {
        boolean z2;
        if ("Amazon".equals(Util2.c)) {
            String str = Util2.d;
            if ("AFTM".equals(str) || "AFTB".equals(str)) {
                z2 = true;
            } else {
                z2 = false;
            }
        } else {
            z2 = false;
        }
        a = z2;
    }

    public FrameworkCryptoConfig(UUID uuid, byte[] bArr, boolean z2) {
        this.f1150b = uuid;
        this.c = bArr;
        this.d = z2;
    }
}
