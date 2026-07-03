package p007b.p225i.p414e.p430r.p431d;

import java.util.Formatter;

/* JADX INFO: renamed from: b.i.e.r.d.g */
/* JADX INFO: compiled from: DetectionResultColumn.java */
/* JADX INFO: loaded from: classes3.dex */
public class C5040g {

    /* JADX INFO: renamed from: a */
    public final C5036c f13491a;

    /* JADX INFO: renamed from: b */
    public final C5037d[] f13492b;

    public C5040g(C5036c c5036c) {
        this.f13491a = new C5036c(c5036c);
        this.f13492b = new C5037d[(c5036c.f13478i - c5036c.f13477h) + 1];
    }

    /* JADX INFO: renamed from: a */
    public final C5037d m7057a(int i) {
        C5037d c5037d;
        C5037d c5037d2;
        C5037d c5037d3 = this.f13492b[i - this.f13491a.f13477h];
        if (c5037d3 != null) {
            return c5037d3;
        }
        for (int i2 = 1; i2 < 5; i2++) {
            int i3 = i - this.f13491a.f13477h;
            int i4 = i3 - i2;
            if (i4 >= 0 && (c5037d2 = this.f13492b[i4]) != null) {
                return c5037d2;
            }
            int i5 = i3 + i2;
            C5037d[] c5037dArr = this.f13492b;
            if (i5 < c5037dArr.length && (c5037d = c5037dArr[i5]) != null) {
                return c5037d;
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: b */
    public final int m7058b(int i) {
        return i - this.f13491a.f13477h;
    }

    public String toString() {
        Formatter formatter = new Formatter();
        try {
            int i = 0;
            for (C5037d c5037d : this.f13492b) {
                if (c5037d == null) {
                    formatter.format("%3d:    |   %n", Integer.valueOf(i));
                    i++;
                } else {
                    formatter.format("%3d: %3d|%3d%n", Integer.valueOf(i), Integer.valueOf(c5037d.f13483e), Integer.valueOf(c5037d.f13482d));
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
