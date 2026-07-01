package b.i.e.m;

import b.i.e.ResultPoint;
import b.i.e.n.BitMatrix;
import b.i.e.n.DetectorResult;

/* JADX INFO: renamed from: b.i.e.m.a, reason: use source file name */
/* JADX INFO: compiled from: AztecDetectorResult.java */
/* JADX INFO: loaded from: classes3.dex */
public final class AztecDetectorResult extends DetectorResult {
    public final boolean c;
    public final int d;
    public final int e;

    public AztecDetectorResult(BitMatrix bitMatrix, ResultPoint[] resultPointArr, boolean z2, int i, int i2) {
        super(bitMatrix, resultPointArr);
        this.c = z2;
        this.d = i;
        this.e = i2;
    }
}
