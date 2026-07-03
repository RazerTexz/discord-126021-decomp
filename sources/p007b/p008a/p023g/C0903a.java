package p007b.p008a.p023g;

import android.graphics.Color;
import android.util.SparseIntArray;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.PriorityQueue;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.a.g.a */
/* JADX INFO: compiled from: ColorCutQuantizer.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C0903a {

    /* JADX INFO: renamed from: a */
    public static final b f626a = new b(null);

    /* JADX INFO: renamed from: b */
    public final float[] f627b = new float[3];

    /* JADX INFO: renamed from: c */
    public final int[] f628c;

    /* JADX INFO: renamed from: d */
    public final SparseIntArray f629d;

    /* JADX INFO: renamed from: e */
    public final List<C0906d> f630e;

    /* JADX INFO: renamed from: b.a.g.a$a */
    /* JADX INFO: compiled from: ColorCutQuantizer.kt */
    public static final class a<T> implements Comparator<c> {

        /* JADX INFO: renamed from: j */
        public static final a f631j = new a();

        @Override // java.util.Comparator
        public int compare(c cVar, c cVar2) {
            return cVar2.m191b() - cVar.m191b();
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

        /* JADX INFO: renamed from: a */
        public int f632a;

        /* JADX INFO: renamed from: b */
        public int f633b;

        /* JADX INFO: renamed from: c */
        public int f634c;

        /* JADX INFO: renamed from: d */
        public int f635d;

        /* JADX INFO: renamed from: e */
        public int f636e;

        /* JADX INFO: renamed from: f */
        public int f637f;

        /* JADX INFO: renamed from: g */
        public final int f638g;

        /* JADX INFO: renamed from: h */
        public int f639h;

        public c(int i, int i2) {
            this.f638g = i;
            this.f639h = i2;
            m190a();
        }

        /* JADX INFO: renamed from: a */
        public final void m190a() {
            this.f636e = 255;
            this.f634c = 255;
            this.f632a = 255;
            this.f637f = 0;
            this.f635d = 0;
            this.f633b = 0;
            int i = this.f638g;
            int i2 = this.f639h;
            if (i > i2) {
                return;
            }
            while (true) {
                int i3 = C0903a.this.f628c[i];
                int iRed = Color.red(i3);
                int iGreen = Color.green(i3);
                int iBlue = Color.blue(i3);
                if (iRed > this.f633b) {
                    this.f633b = iRed;
                }
                if (iRed < this.f632a) {
                    this.f632a = iRed;
                }
                if (iGreen > this.f635d) {
                    this.f635d = iGreen;
                }
                if (iGreen < this.f634c) {
                    this.f634c = iGreen;
                }
                if (iBlue > this.f637f) {
                    this.f637f = iBlue;
                }
                if (iBlue < this.f636e) {
                    this.f636e = iBlue;
                }
                if (i == i2) {
                    return;
                } else {
                    i++;
                }
            }
        }

        /* JADX INFO: renamed from: b */
        public final int m191b() {
            return ((this.f637f - this.f636e) + 1) * ((this.f635d - this.f634c) + 1) * ((this.f633b - this.f632a) + 1);
        }
    }

    /* JADX WARN: Code duplicated, block: B:133:0x025d  */
    /* JADX WARN: Code duplicated, block: B:36:0x0097  */
    /* JADX WARN: Code duplicated, block: B:40:0x009d  */
    public C0903a(C0904b c0904b, int i, DefaultConstructorMarker defaultConstructorMarker) {
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
        int i3 = c0904b.f644d;
        int[] iArr = c0904b.f642b;
        int[] iArr2 = c0904b.f643c;
        this.f629d = new SparseIntArray(i3);
        int length = iArr.length;
        for (int i4 = 0; i4 < length; i4++) {
            this.f629d.append(iArr[i4], iArr2[i4]);
        }
        this.f628c = new int[i3];
        int i5 = 0;
        for (int i6 : iArr) {
            int iAlpha = Color.alpha(i6);
            C0905c.m192a(Color.red(i6), Color.green(i6), Color.blue(i6), this.f627b);
            if (iAlpha >= 250) {
                float[] fArr = this.f627b;
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
                this.f628c[i5] = i6;
                i5++;
            }
        }
        if (i5 <= i) {
            this.f630e = new ArrayList();
            for (int i7 : this.f628c) {
                this.f630e.add(new C0906d(i7, this.f629d.get(i7)));
            }
            return;
        }
        PriorityQueue<c> priorityQueue = new PriorityQueue(i, a.f631j);
        priorityQueue.offer(new c(0, i5 - 1));
        while (priorityQueue.size() < i && (cVar = (c) priorityQueue.poll()) != null) {
            int i8 = cVar.f639h;
            int i9 = cVar.f638g;
            int i10 = i8 - i9;
            if (!(i10 > 1)) {
                break;
            }
            if (!(i10 > 1)) {
                throw new IllegalStateException("Can not split a box with only 1 color".toString());
            }
            int i11 = cVar.f633b - cVar.f632a;
            int i12 = cVar.f635d - cVar.f634c;
            int i13 = cVar.f637f - cVar.f636e;
            int i14 = (i11 < i12 || i11 < i13) ? (i12 < i11 || i12 < i13) ? -1 : -2 : -3;
            m189a(C0903a.this, i14, i9, i8);
            Arrays.sort(C0903a.this.f628c, cVar.f638g, cVar.f639h + 1);
            m189a(C0903a.this, i14, cVar.f638g, cVar.f639h);
            int i15 = i14 != -3 ? i14 != -2 ? i14 != -1 ? (cVar.f632a + cVar.f633b) / 2 : (cVar.f636e + cVar.f637f) / 2 : (cVar.f634c + cVar.f635d) / 2 : (cVar.f632a + cVar.f633b) / 2;
            int i16 = cVar.f638g;
            int i17 = cVar.f639h;
            while (true) {
                if (i16 >= i17) {
                    i16 = cVar.f638g;
                    break;
                }
                int i18 = C0903a.this.f628c[i16];
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
            c cVar2 = C0903a.this.new c(i16 + 1, cVar.f639h);
            cVar.f639h = i16;
            cVar.m190a();
            priorityQueue.offer(cVar2);
            priorityQueue.offer(cVar);
        }
        ArrayList arrayList = new ArrayList(priorityQueue.size());
        for (c cVar3 : priorityQueue) {
            int i19 = cVar3.f638g;
            int i20 = cVar3.f639h;
            if (i19 <= i20) {
                i2 = 0;
                iRed = 0;
                iGreen = 0;
                iBlue = 0;
                while (true) {
                    C0903a c0903a = C0903a.this;
                    int i21 = c0903a.f628c[i19];
                    int i22 = c0903a.f629d.get(i21);
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
            C0906d c0906d = new C0906d(Math.round(iRed / f2), Math.round(iGreen / f2), Math.round(iBlue / f2), i2);
            float[] fArrM193a = c0906d.m193a();
            C12238m.checkNotNullExpressionValue(fArrM193a, "color.hsl");
            if (fArrM193a[2] >= 0.95f) {
                z2 = true;
            } else {
                if (!(fArrM193a[2] <= 0.05f)) {
                    float f3 = fArrM193a[0];
                    if (f3 >= 10.0f && f3 <= 37.0f) {
                        z3 = fArrM193a[1] <= 0.82f;
                    }
                    if (!z3) {
                        z2 = false;
                    }
                }
                z2 = true;
            }
            if (!z2) {
                arrayList.add(c0906d);
            }
        }
        this.f630e = arrayList;
    }

    /* JADX INFO: renamed from: a */
    public static final void m189a(C0903a c0903a, int i, int i2, int i3) {
        Objects.requireNonNull(c0903a);
        if (i == -2) {
            while (i2 <= i3) {
                int[] iArr = c0903a.f628c;
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
            int[] iArr2 = c0903a.f628c;
            int i5 = iArr2[i2];
            iArr2[i2] = Color.rgb(i5 & 255, (i5 >> 8) & 255, (i5 >> 16) & 255);
            i2++;
        }
    }
}
