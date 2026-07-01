package b.i.e.r.d;

import java.util.Formatter;

/* JADX INFO: compiled from: DetectionResultColumn.java */
/* JADX INFO: loaded from: classes3.dex */
public class g {
    public final c a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d[] f1881b;

    public g(c cVar) {
        this.a = new c(cVar);
        this.f1881b = new d[(cVar.i - cVar.h) + 1];
    }

    public final d a(int i) {
        d dVar;
        d dVar2;
        d dVar3 = this.f1881b[i - this.a.h];
        if (dVar3 != null) {
            return dVar3;
        }
        for (int i2 = 1; i2 < 5; i2++) {
            int i3 = i - this.a.h;
            int i4 = i3 - i2;
            if (i4 >= 0 && (dVar2 = this.f1881b[i4]) != null) {
                return dVar2;
            }
            int i5 = i3 + i2;
            d[] dVarArr = this.f1881b;
            if (i5 < dVarArr.length && (dVar = dVarArr[i5]) != null) {
                return dVar;
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
            for (d dVar : this.f1881b) {
                if (dVar == null) {
                    formatter.format("%3d:    |   %n", Integer.valueOf(i));
                    i++;
                } else {
                    formatter.format("%3d: %3d|%3d%n", Integer.valueOf(i), Integer.valueOf(dVar.e), Integer.valueOf(dVar.d));
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
