package p007b.p225i.p226a.p242c.p266w2;

import java.util.UUID;
import p007b.p225i.p226a.p242c.p259f3.C2738e0;
import p007b.p225i.p226a.p242c.p265v2.InterfaceC2954b;

/* JADX INFO: renamed from: b.i.a.c.w2.b0 */
/* JADX INFO: compiled from: FrameworkCryptoConfig.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2968b0 implements InterfaceC2954b {

    /* JADX INFO: renamed from: a */
    public static final boolean f7972a;

    /* JADX INFO: renamed from: b */
    public final UUID f7973b;

    /* JADX INFO: renamed from: c */
    public final byte[] f7974c;

    /* JADX INFO: renamed from: d */
    public final boolean f7975d;

    /* JADX WARN: Code duplicated, block: B:9:0x001e  */
    static {
        boolean z2;
        if ("Amazon".equals(C2738e0.f6710c)) {
            String str = C2738e0.f6711d;
            if ("AFTM".equals(str) || "AFTB".equals(str)) {
                z2 = true;
            } else {
                z2 = false;
            }
        } else {
            z2 = false;
        }
        f7972a = z2;
    }

    public C2968b0(UUID uuid, byte[] bArr, boolean z2) {
        this.f7973b = uuid;
        this.f7974c = bArr;
        this.f7975d = z2;
    }
}
