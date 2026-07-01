package b.i.a.c.x2.i0;

import androidx.annotation.Nullable;
import b.c.a.a0.AnimatableValueParser;
import b.d.b.a.outline;
import b.i.a.c.x2.TrackOutput2;

/* JADX INFO: renamed from: b.i.a.c.x2.i0.n, reason: use source file name */
/* JADX INFO: compiled from: TrackEncryptionBox.java */
/* JADX INFO: loaded from: classes3.dex */
public final class TrackEncryptionBox {
    public final boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final String f1231b;
    public final TrackOutput2.a c;
    public final int d;

    @Nullable
    public final byte[] e;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:29:0x0053  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public TrackEncryptionBox(boolean z2, @Nullable String str, int i, byte[] bArr, int i2, int i3, @Nullable byte[] bArr2) {
        byte b2 = 0;
        int i4 = 1;
        AnimatableValueParser.j((i == 0) ^ (bArr2 == null));
        this.a = z2;
        this.f1231b = str;
        this.d = i;
        this.e = bArr2;
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
                outline.i0(str.length() + 68, "Unsupported protection scheme type '", str, "'. Assuming AES-CTR crypto mode.", "TrackEncryptionBox");
            }
        }
        this.c = new TrackOutput2.a(i4, bArr, i2, i3);
    }
}
