package b.i.a.c.e3;

import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: compiled from: SlidingPercentile.java */
/* JADX INFO: loaded from: classes3.dex */
public class x {
    public static final /* synthetic */ int a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f954b;
    public int f;
    public int g;
    public int h;
    public final x$b[] d = new x$b[5];
    public final ArrayList<x$b> c = new ArrayList<>();
    public int e = -1;

    public x(int i) {
        this.f954b = i;
    }

    public void a(int i, float f) {
        x$b x_b;
        if (this.e != 1) {
            Collections.sort(this.c, d.j);
            this.e = 1;
        }
        int i2 = this.h;
        if (i2 > 0) {
            x$b[] x_bArr = this.d;
            int i3 = i2 - 1;
            this.h = i3;
            x_b = x_bArr[i3];
        } else {
            x_b = new x$b(null);
        }
        int i4 = this.f;
        this.f = i4 + 1;
        x_b.a = i4;
        x_b.f955b = i;
        x_b.c = f;
        this.c.add(x_b);
        this.g += i;
        while (true) {
            int i5 = this.g;
            int i6 = this.f954b;
            if (i5 <= i6) {
                return;
            }
            int i7 = i5 - i6;
            x$b x_b2 = this.c.get(0);
            int i8 = x_b2.f955b;
            if (i8 <= i7) {
                this.g -= i8;
                this.c.remove(0);
                int i9 = this.h;
                if (i9 < 5) {
                    x$b[] x_bArr2 = this.d;
                    this.h = i9 + 1;
                    x_bArr2[i9] = x_b2;
                }
            } else {
                x_b2.f955b = i8 - i7;
                this.g -= i7;
            }
        }
    }

    public float b(float f) {
        if (this.e != 0) {
            Collections.sort(this.c, c.j);
            this.e = 0;
        }
        float f2 = f * this.g;
        int i = 0;
        for (int i2 = 0; i2 < this.c.size(); i2++) {
            x$b x_b = this.c.get(i2);
            i += x_b.f955b;
            if (i >= f2) {
                return x_b.c;
            }
        }
        if (this.c.isEmpty()) {
            return Float.NaN;
        }
        ArrayList<x$b> arrayList = this.c;
        return arrayList.get(arrayList.size() - 1).c;
    }
}
