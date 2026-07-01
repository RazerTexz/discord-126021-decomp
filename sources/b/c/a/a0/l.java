package b.c.a.a0;

import android.graphics.Color;
import android.graphics.PointF;
import b.c.a.a0.i0.c$b;
import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: compiled from: GradientColorParser.java */
/* JADX INFO: loaded from: classes.dex */
public class l implements h0<b.c.a.y.l.c> {
    public int a;

    public l(int i) {
        this.a = i;
    }

    @Override // b.c.a.a0.h0
    public b.c.a.y.l.c a(b.c.a.a0.i0.c cVar, float f) throws IOException {
        int i;
        double d;
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        boolean z2 = cVar.u() == c$b.BEGIN_ARRAY;
        if (z2) {
            cVar.a();
        }
        while (cVar.e()) {
            arrayList.add(Float.valueOf((float) cVar.n()));
        }
        if (z2) {
            cVar.c();
        }
        if (this.a == -1) {
            this.a = arrayList.size() / 4;
        }
        int i3 = this.a;
        float[] fArr = new float[i3];
        int[] iArr = new int[i3];
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (true) {
            i = this.a * 4;
            if (i4 >= i) {
                break;
            }
            int i7 = i4 / 4;
            double dFloatValue = ((Float) arrayList.get(i4)).floatValue();
            int i8 = i4 % 4;
            if (i8 == 0) {
                fArr[i7] = (float) dFloatValue;
            } else if (i8 == 1) {
                i5 = (int) (dFloatValue * 255.0d);
            } else if (i8 == 2) {
                i6 = (int) (dFloatValue * 255.0d);
            } else if (i8 == 3) {
                iArr[i7] = Color.argb(255, i5, i6, (int) (dFloatValue * 255.0d));
            }
            i4++;
        }
        b.c.a.y.l.c cVar2 = new b.c.a.y.l.c(fArr, iArr);
        if (arrayList.size() > i) {
            int size = (arrayList.size() - i) / 2;
            double[] dArr = new double[size];
            double[] dArr2 = new double[size];
            int i9 = 0;
            while (i < arrayList.size()) {
                if (i % 2 == 0) {
                    dArr[i9] = ((Float) arrayList.get(i)).floatValue();
                } else {
                    dArr2[i9] = ((Float) arrayList.get(i)).floatValue();
                    i9++;
                }
                i++;
            }
            while (true) {
                int[] iArr2 = cVar2.f416b;
                if (i2 >= iArr2.length) {
                    break;
                }
                int i10 = iArr2[i2];
                double d2 = cVar2.a[i2];
                int i11 = 1;
                while (true) {
                    if (i11 >= size) {
                        d = dArr2[size - 1];
                        break;
                    }
                    int i12 = i11 - 1;
                    double d3 = dArr[i12];
                    double d4 = dArr[i11];
                    if (dArr[i11] >= d2) {
                        double d5 = dArr2[i12];
                        double d6 = dArr2[i11];
                        PointF pointF = b.c.a.b0.f.a;
                        d = ((d6 - d5) * ((d2 - d3) / (d4 - d3))) + d5;
                        break;
                    }
                    i11++;
                }
                cVar2.f416b[i2] = Color.argb((int) (d * 255.0d), Color.red(i10), Color.green(i10), Color.blue(i10));
                i2++;
            }
        }
        return cVar2;
    }
}
