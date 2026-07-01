package b.i.e.r.d;

import java.util.Formatter;

/* JADX INFO: renamed from: b.i.e.r.d.g, reason: use source file name */
/* JADX INFO: compiled from: DetectionResultColumn.java */
/* JADX INFO: loaded from: classes3.dex */
public class DetectionResultColumn {
    public final BoundingBox a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Codeword[] f1881b;

    public DetectionResultColumn(BoundingBox boundingBox) {
        this.a = new BoundingBox(boundingBox);
        this.f1881b = new Codeword[(boundingBox.i - boundingBox.h) + 1];
    }

    public final Codeword a(int i) {
        Codeword codeword;
        Codeword codeword2;
        Codeword codeword3 = this.f1881b[i - this.a.h];
        if (codeword3 != null) {
            return codeword3;
        }
        for (int i2 = 1; i2 < 5; i2++) {
            int i3 = i - this.a.h;
            int i4 = i3 - i2;
            if (i4 >= 0 && (codeword2 = this.f1881b[i4]) != null) {
                return codeword2;
            }
            int i5 = i3 + i2;
            Codeword[] codewordArr = this.f1881b;
            if (i5 < codewordArr.length && (codeword = codewordArr[i5]) != null) {
                return codeword;
            }
        }
        return null;
    }

    public final int b(int i) {
        return i - this.a.h;
    }

    public String toString() {
        Formatter formatter = new Formatter();
        try {
            int i = 0;
            for (Codeword codeword : this.f1881b) {
                if (codeword == null) {
                    formatter.format("%3d:    |   %n", Integer.valueOf(i));
                    i++;
                } else {
                    formatter.format("%3d: %3d|%3d%n", Integer.valueOf(i), Integer.valueOf(codeword.e), Integer.valueOf(codeword.d));
                    i++;
                }
            }
            String string = formatter.toString();
            formatter.close();
            return string;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                try {
                    formatter.close();
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                }
                throw th2;
            }
        }
    }
}
