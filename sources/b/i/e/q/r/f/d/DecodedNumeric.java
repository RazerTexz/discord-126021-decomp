package b.i.e.q.r.f.d;

import com.google.zxing.FormatException;

/* JADX INFO: renamed from: b.i.e.q.r.f.d.p, reason: use source file name */
/* JADX INFO: compiled from: DecodedNumeric.java */
/* JADX INFO: loaded from: classes3.dex */
public final class DecodedNumeric extends DecodedObject {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f1872b;
    public final int c;

    public DecodedNumeric(int i, int i2, int i3) throws FormatException {
        super(i);
        if (i2 < 0 || i2 > 10 || i3 < 0 || i3 > 10) {
            throw FormatException.a();
        }
        this.f1872b = i2;
        this.c = i3;
    }
}
