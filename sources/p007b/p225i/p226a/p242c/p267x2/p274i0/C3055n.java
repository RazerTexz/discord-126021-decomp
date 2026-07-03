package p007b.p225i.p226a.p242c.p267x2.p274i0;

import androidx.annotation.Nullable;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p242c.p267x2.InterfaceC3122w;

/* JADX INFO: renamed from: b.i.a.c.x2.i0.n */
/* JADX INFO: compiled from: TrackEncryptionBox.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C3055n {

    /* JADX INFO: renamed from: a */
    public final boolean f8471a;

    /* JADX INFO: renamed from: b */
    @Nullable
    public final String f8472b;

    /* JADX INFO: renamed from: c */
    public final InterfaceC3122w.a f8473c;

    /* JADX INFO: renamed from: d */
    public final int f8474d;

    /* JADX INFO: renamed from: e */
    @Nullable
    public final byte[] f8475e;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:29:0x0053  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public C3055n(boolean z2, @Nullable String str, int i, byte[] bArr, int i2, int i3, @Nullable byte[] bArr2) {
        byte b2 = 0;
        int i4 = 1;
        C1460d.m531j((i == 0) ^ (bArr2 == null));
        this.f8471a = z2;
        this.f8472b = str;
        this.f8474d = i;
        this.f8475e = bArr2;
        if (str != null) {
            switch (str.hashCode()) {
                case 3046605:
                    if (!str.equals("cbc1")) {
                        b2 = -1;
                    }
                    break;
                case 3046671:
                    if (!str.equals("cbcs")) {
                        b2 = -1;
                    } else {
                        b2 = 1;
                    }
                    break;
                case 3049879:
                    if (!str.equals("cenc")) {
                        b2 = -1;
                    } else {
                        b2 = 2;
                    }
                    break;
                case 3049895:
                    if (!str.equals("cens")) {
                        b2 = -1;
                    } else {
                        b2 = 3;
                    }
                    break;
                default:
                    b2 = -1;
                    break;
            }
            if (b2 == 0 || b2 == 1) {
                i4 = 2;
            } else if (b2 != 2 && b2 != 3) {
                C1643a.m856i0(str.length() + 68, "Unsupported protection scheme type '", str, "'. Assuming AES-CTR crypto mode.", "TrackEncryptionBox");
            }
        }
        this.f8473c = new InterfaceC3122w.a(i4, bArr, i2, i3);
    }
}
