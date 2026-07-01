package b.a.g;

import android.graphics.Color;
import android.util.SparseIntArray;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.PriorityQueue;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ColorCutQuantizer.kt */
/* JADX INFO: loaded from: classes.dex */
public final class a {
    public static final a$b a = new a$b(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float[] f68b = new float[3];
    public final int[] c;
    public final SparseIntArray d;
    public final List<d> e;

    /* JADX WARN: Code duplicated, block: B:133:0x025d  */
    /* JADX WARN: Code duplicated, block: B:36:0x0097  */
    /* JADX WARN: Code duplicated, block: B:40:0x009d  */
    public a(b bVar, int i, DefaultConstructorMarker defaultConstructorMarker) {
        int i2;
        int iRed;
        int iGreen;
        int iBlue;
        boolean z2;
        boolean z3;
        a$c a_c;
        boolean z4;
        boolean z5;
        if (!(i >= 1)) {
            throw new IllegalArgumentException("maxColors must be 1 or greater".toString());
        }
        int i3 = bVar.d;
        int[] iArr = bVar.f70b;
        int[] iArr2 = bVar.c;
        this.d = new SparseIntArray(i3);
        int length = iArr.length;
        for (int i4 = 0; i4 < length; i4++) {
            this.d.append(iArr[i4], iArr2[i4]);
        }
        this.c = new int[i3];
        int i5 = 0;
        for (int i6 : iArr) {
            int iAlpha = Color.alpha(i6);
            c.a(Color.red(i6), Color.green(i6), Color.blue(i6), this.f68b);
            if (iAlpha >= 250) {
                float[] fArr = this.f68b;
                if (fArr[2] >= 0.95f) {
                    z5 = true;
                } else if (fArr[2] <= 0.05f) {
                    z5 = true;
                } else {
                    float f = fArr[0];
                    if (f >= 10.0f && f <= 37.0f && fArr[1] <= 0.82f) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                }
                if (z5) {
                    z4 = true;
                } else {
                    z4 = false;
                }
            } else {
                z4 = true;
            }
            if (!z4) {
                this.c[i5] = i6;
                i5++;
            }
        }
        if (i5 <= i) {
            this.e = new ArrayList();
            for (int i7 : this.c) {
                this.e.add(new d(i7, this.d.get(i7)));
            }
            return;
        }
        PriorityQueue<a$c> priorityQueue = new PriorityQueue(i, a$a.j);
        priorityQueue.offer(new a$c(this, 0, i5 - 1));
        while (priorityQueue.size() < i && (a_c = (a$c) priorityQueue.poll()) != null) {
            int i8 = a_c.h;
            int i9 = a_c.g;
            int i10 = i8 - i9;
            if (!(i10 > 1)) {
                break;
            }
            if (!(i10 > 1)) {
                throw new IllegalStateException("Can not split a box with only 1 color".toString());
            }
            int i11 = a_c.f69b - a_c.a;
            int i12 = a_c.d - a_c.c;
            int i13 = a_c.f - a_c.e;
            int i14 = (i11 < i12 || i11 < i13) ? (i12 < i11 || i12 < i13) ? -1 : -2 : -3;
            a(a_c.i, i14, i9, i8);
            Arrays.sort(a_c.i.c, a_c.g, a_c.h + 1);
            a(a_c.i, i14, a_c.g, a_c.h);
            int i15 = i14 != -3 ? i14 != -2 ? i14 != -1 ? (a_c.a + a_c.f69b) / 2 : (a_c.e + a_c.f) / 2 : (a_c.c + a_c.d) / 2 : (a_c.a + a_c.f69b) / 2;
            int i16 = a_c.g;
            int i17 = a_c.h;
            while (true) {
                if (i16 >= i17) {
                    i16 = a_c.g;
                    break;
                }
                int i18 = a_c.i.c[i16];
                if (i14 != -3) {
                    if (i14 != -2) {
                        if (i14 == -1 && Color.blue(i18) > i15) {
                            break;
                        } else {
                            i16++;
                        }
                    } else if (Color.green(i18) >= i15) {
                        break;
                    } else {
                        i16++;
                    }
                } else if (Color.red(i18) >= i15) {
                    break;
                } else {
                    i16++;
                }
            }
            a$c a_c2 = new a$c(a_c.i, i16 + 1, a_c.h);
            a_c.h = i16;
            a_c.a();
            priorityQueue.offer(a_c2);
            priorityQueue.offer(a_c);
        }
        ArrayList arrayList = new ArrayList(priorityQueue.size());
        for (a$c a_c3 : priorityQueue) {
            int i19 = a_c3.g;
            int i20 = a_c3.h;
            if (i19 <= i20) {
                i2 = 0;
                iRed = 0;
                iGreen = 0;
                iBlue = 0;
                while (true) {
                    a aVar = a_c3.i;
                    int i21 = aVar.c[i19];
                    int i22 = aVar.d.get(i21);
                    i2 += i22;
                    iRed = (Color.red(i21) * i22) + iRed;
                    iGreen = (Color.green(i21) * i22) + iGreen;
                    iBlue += Color.blue(i21) * i22;
                    if (i19 == i20) {
                        break;
                    } else {
                        i19++;
                    }
                }
            } else {
                i2 = 0;
                iRed = 0;
                iGreen = 0;
                iBlue = 0;
            }
            float f2 = i2;
            d dVar = new d(Math.round(iRed / f2), Math.round(iGreen / f2), Math.round(iBlue / f2), i2);
            float[] fArrA = dVar.a();
            m.checkNotNullExpressionValue(fArrA, "color.hsl");
            if (fArrA[2] >= 0.95f) {
                z2 = true;
            } else {
                if (!(fArrA[2] <= 0.05f)) {
                    float f3 = fArrA[0];
                    if (f3 >= 10.0f && f3 <= 37.0f) {
                        z3 = fArrA[1] <= 0.82f;
                    }
                    if (!z3) {
                        z2 = false;
                    }
                }
                z2 = true;
            }
            if (!z2) {
                arrayList.add(dVar);
            }
        }
        this.e = arrayList;
    }

    public static final void a(a aVar, int i, int i2, int i3) {
        Objects.requireNonNull(aVar);
        if (i == -2) {
            while (i2 <= i3) {
                int[] iArr = aVar.c;
                int i4 = iArr[i2];
                iArr[i2] = Color.rgb((i4 >> 8) & 255, (i4 >> 16) & 255, i4 & 255);
                i2++;
            }
            return;
        }
        if (i != -1) {
            return;
        }
        while (i2 <= i3) {
            int[] iArr2 = aVar.c;
            int i5 = iArr2[i2];
            iArr2[i2] = Color.rgb(i5 & 255, (i5 >> 8) & 255, (i5 >> 16) & 255);
            i2++;
        }
    }
}
