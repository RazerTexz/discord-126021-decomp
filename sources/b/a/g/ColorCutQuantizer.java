package b.a.g;

import android.graphics.Color;
import android.util.SparseIntArray;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.PriorityQueue;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: b.a.g.a, reason: use source file name */
/* JADX INFO: compiled from: ColorCutQuantizer.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ColorCutQuantizer {
    public static final b a = new b(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float[] f68b = new float[3];
    public final int[] c;
    public final SparseIntArray d;
    public final List<Swatch> e;

    /* JADX INFO: renamed from: b.a.g.a$a */
    /* JADX INFO: compiled from: ColorCutQuantizer.kt */
    public static final class a<T> implements Comparator<c> {
        public static final a j = new a();

        @Override // java.util.Comparator
        public int compare(c cVar, c cVar2) {
            return cVar2.b() - cVar.b();
        }
    }

    /* JADX INFO: renamed from: b.a.g.a$b */
    /* JADX INFO: compiled from: ColorCutQuantizer.kt */
    public static final class b {
        public b(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* JADX INFO: renamed from: b.a.g.a$c */
    /* JADX INFO: compiled from: ColorCutQuantizer.kt */
    public final class c {
        public int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f69b;
        public int c;
        public int d;
        public int e;
        public int f;
        public final int g;
        public int h;

        public c(int i, int i2) {
            this.g = i;
            this.h = i2;
            a();
        }

        public final void a() {
            this.e = 255;
            this.c = 255;
            this.a = 255;
            this.f = 0;
            this.d = 0;
            this.f69b = 0;
            int i = this.g;
            int i2 = this.h;
            if (i > i2) {
                return;
            }
            while (true) {
                int i3 = ColorCutQuantizer.this.c[i];
                int iRed = Color.red(i3);
                int iGreen = Color.green(i3);
                int iBlue = Color.blue(i3);
                if (iRed > this.f69b) {
                    this.f69b = iRed;
                }
                if (iRed < this.a) {
                    this.a = iRed;
                }
                if (iGreen > this.d) {
                    this.d = iGreen;
                }
                if (iGreen < this.c) {
                    this.c = iGreen;
                }
                if (iBlue > this.f) {
                    this.f = iBlue;
                }
                if (iBlue < this.e) {
                    this.e = iBlue;
                }
                if (i == i2) {
                    return;
                } else {
                    i++;
                }
            }
        }

        public final int b() {
            return ((this.f - this.e) + 1) * ((this.d - this.c) + 1) * ((this.f69b - this.a) + 1);
        }
    }

    /* JADX WARN: Code duplicated, block: B:133:0x025d  */
    /* JADX WARN: Code duplicated, block: B:36:0x0097  */
    /* JADX WARN: Code duplicated, block: B:40:0x009d  */
    public ColorCutQuantizer(ColorHistogram colorHistogram, int i, DefaultConstructorMarker defaultConstructorMarker) {
        int i2;
        int iRed;
        int iGreen;
        int iBlue;
        boolean z2;
        boolean z3;
        c cVar;
        boolean z4;
        boolean z5;
        if (!(i >= 1)) {
            throw new IllegalArgumentException("maxColors must be 1 or greater".toString());
        }
        int i3 = colorHistogram.d;
        int[] iArr = colorHistogram.f70b;
        int[] iArr2 = colorHistogram.c;
        this.d = new SparseIntArray(i3);
        int length = iArr.length;
        for (int i4 = 0; i4 < length; i4++) {
            this.d.append(iArr[i4], iArr2[i4]);
        }
        this.c = new int[i3];
        int i5 = 0;
        for (int i6 : iArr) {
            int iAlpha = Color.alpha(i6);
            ColorUtils2.a(Color.red(i6), Color.green(i6), Color.blue(i6), this.f68b);
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
                this.e.add(new Swatch(i7, this.d.get(i7)));
            }
            return;
        }
        PriorityQueue<c> priorityQueue = new PriorityQueue(i, a.j);
        priorityQueue.offer(new c(0, i5 - 1));
        while (priorityQueue.size() < i && (cVar = (c) priorityQueue.poll()) != null) {
            int i8 = cVar.h;
            int i9 = cVar.g;
            int i10 = i8 - i9;
            if (!(i10 > 1)) {
                break;
            }
            if (!(i10 > 1)) {
                throw new IllegalStateException("Can not split a box with only 1 color".toString());
            }
            int i11 = cVar.f69b - cVar.a;
            int i12 = cVar.d - cVar.c;
            int i13 = cVar.f - cVar.e;
            int i14 = (i11 < i12 || i11 < i13) ? (i12 < i11 || i12 < i13) ? -1 : -2 : -3;
            a(ColorCutQuantizer.this, i14, i9, i8);
            Arrays.sort(ColorCutQuantizer.this.c, cVar.g, cVar.h + 1);
            a(ColorCutQuantizer.this, i14, cVar.g, cVar.h);
            int i15 = i14 != -3 ? i14 != -2 ? i14 != -1 ? (cVar.a + cVar.f69b) / 2 : (cVar.e + cVar.f) / 2 : (cVar.c + cVar.d) / 2 : (cVar.a + cVar.f69b) / 2;
            int i16 = cVar.g;
            int i17 = cVar.h;
            while (true) {
                if (i16 >= i17) {
                    i16 = cVar.g;
                    break;
                }
                int i18 = ColorCutQuantizer.this.c[i16];
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
            c cVar2 = ColorCutQuantizer.this.new c(i16 + 1, cVar.h);
            cVar.h = i16;
            cVar.a();
            priorityQueue.offer(cVar2);
            priorityQueue.offer(cVar);
        }
        ArrayList arrayList = new ArrayList(priorityQueue.size());
        for (c cVar3 : priorityQueue) {
            int i19 = cVar3.g;
            int i20 = cVar3.h;
            if (i19 <= i20) {
                i2 = 0;
                iRed = 0;
                iGreen = 0;
                iBlue = 0;
                while (true) {
                    ColorCutQuantizer colorCutQuantizer = ColorCutQuantizer.this;
                    int i21 = colorCutQuantizer.c[i19];
                    int i22 = colorCutQuantizer.d.get(i21);
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
            Swatch swatch = new Swatch(Math.round(iRed / f2), Math.round(iGreen / f2), Math.round(iBlue / f2), i2);
            float[] fArrA = swatch.a();
            Intrinsics3.checkNotNullExpressionValue(fArrA, "color.hsl");
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
                arrayList.add(swatch);
            }
        }
        this.e = arrayList;
    }

    public static final void a(ColorCutQuantizer colorCutQuantizer, int i, int i2, int i3) {
        Objects.requireNonNull(colorCutQuantizer);
        if (i == -2) {
            while (i2 <= i3) {
                int[] iArr = colorCutQuantizer.c;
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
            int[] iArr2 = colorCutQuantizer.c;
            int i5 = iArr2[i2];
            iArr2[i2] = Color.rgb(i5 & 255, (i5 >> 8) & 255, (i5 >> 16) & 255);
            i2++;
        }
    }
}
