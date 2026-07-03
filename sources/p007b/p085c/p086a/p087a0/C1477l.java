package p007b.p085c.p086a.p087a0;

import android.graphics.Color;
import android.graphics.PointF;
import java.io.IOException;
import java.util.ArrayList;
import p007b.p085c.p086a.p087a0.p088i0.AbstractC1473c;
import p007b.p085c.p086a.p089b0.C1498f;
import p007b.p085c.p086a.p095y.p097l.C1588c;

/* JADX INFO: renamed from: b.c.a.a0.l */
/* JADX INFO: compiled from: GradientColorParser.java */
/* JADX INFO: loaded from: classes.dex */
public class C1477l implements InterfaceC1469h0<C1588c> {

    /* JADX INFO: renamed from: a */
    public int f2268a;

    public C1477l(int i) {
        this.f2268a = i;
    }

    @Override // p007b.p085c.p086a.p087a0.InterfaceC1469h0
    /* JADX INFO: renamed from: a */
    public C1588c mo413a(AbstractC1473c abstractC1473c, float f) throws IOException {
        int i;
        double d;
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        boolean z2 = abstractC1473c.mo613u() == AbstractC1473c.b.BEGIN_ARRAY;
        if (z2) {
            abstractC1473c.mo603a();
        }
        while (abstractC1473c.mo607e()) {
            arrayList.add(Float.valueOf((float) abstractC1473c.mo609n()));
        }
        if (z2) {
            abstractC1473c.mo605c();
        }
        if (this.f2268a == -1) {
            this.f2268a = arrayList.size() / 4;
        }
        int i3 = this.f2268a;
        float[] fArr = new float[i3];
        int[] iArr = new int[i3];
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (true) {
            i = this.f2268a * 4;
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
        C1588c c1588c = new C1588c(fArr, iArr);
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
                int[] iArr2 = c1588c.f2745b;
                if (i2 >= iArr2.length) {
                    break;
                }
                int i10 = iArr2[i2];
                double d2 = c1588c.f2744a[i2];
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
                        PointF pointF = C1498f.f2308a;
                        d = ((d6 - d5) * ((d2 - d3) / (d4 - d3))) + d5;
                        break;
                    }
                    i11++;
                }
                c1588c.f2745b[i2] = Color.argb((int) (d * 255.0d), Color.red(i10), Color.green(i10), Color.blue(i10));
                i2++;
            }
        }
        return c1588c;
    }
}
