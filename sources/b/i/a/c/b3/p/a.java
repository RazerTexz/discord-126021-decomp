package b.i.a.c.b3.p;

import android.graphics.Bitmap;
import android.graphics.Bitmap$Config;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import b.i.a.c.b3.f;
import b.i.a.c.b3.g;
import b.i.a.c.f3.e0;
import b.i.a.c.f3.x;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;
import java.util.zip.Inflater;

/* JADX INFO: compiled from: PgsDecoder.java */
/* JADX INFO: loaded from: classes3.dex */
public final class a extends f {
    public final x n;
    public final x o;
    public final a$a p;

    @Nullable
    public Inflater q;

    public a() {
        super("PgsDecoder");
        this.n = new x();
        this.o = new x();
        this.p = new a$a();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:21:0x006f  */
    @Override // b.i.a.c.b3.f
    public g j(byte[] bArr, int i, boolean z2) throws SubtitleDecoderException {
        x xVar;
        b.i.a.c.b3.b bVar;
        x xVar2;
        int i2;
        int iT;
        int i3;
        int i4;
        int iV;
        a aVar = this;
        x xVar3 = aVar.n;
        xVar3.a = bArr;
        xVar3.c = i;
        int i5 = 0;
        xVar3.f984b = 0;
        if (xVar3.a() > 0 && xVar3.c() == 120) {
            if (aVar.q == null) {
                aVar.q = new Inflater();
            }
            if (e0.x(xVar3, aVar.o, aVar.q)) {
                x xVar4 = aVar.o;
                xVar3.C(xVar4.a, xVar4.c);
            }
        }
        aVar.p.a();
        ArrayList arrayList = new ArrayList();
        while (aVar.n.a() >= 3) {
            x xVar5 = aVar.n;
            a$a a_a = aVar.p;
            int i6 = xVar5.c;
            int iT2 = xVar5.t();
            int iY = xVar5.y();
            int i7 = xVar5.f984b + iY;
            if (i7 > i6) {
                xVar5.E(i6);
                bVar = null;
            } else {
                if (iT2 != 128) {
                    switch (iT2) {
                        case 20:
                            Objects.requireNonNull(a_a);
                            if (iY % 5 == 2) {
                                xVar5.F(2);
                                Arrays.fill(a_a.f871b, i5);
                                int i8 = iY / 5;
                                int i9 = 0;
                                while (i9 < i8) {
                                    int iT3 = xVar5.t();
                                    int iT4 = xVar5.t();
                                    double d = iT4;
                                    double dT = xVar5.t() - 128;
                                    arrayList = arrayList;
                                    double dT2 = xVar5.t() - 128;
                                    a_a.f871b[iT3] = (e0.h((int) ((1.402d * dT) + d), 0, 255) << 16) | (xVar5.t() << 24) | (e0.h((int) ((d - (0.34414d * dT2)) - (dT * 0.71414d)), 0, 255) << 8) | e0.h((int) ((dT2 * 1.772d) + d), 0, 255);
                                    i9++;
                                    xVar5 = xVar5;
                                }
                                xVar = xVar5;
                                a_a.c = true;
                            } else {
                                xVar = xVar5;
                            }
                            break;
                        case 21:
                            Objects.requireNonNull(a_a);
                            if (iY >= 4) {
                                xVar5.F(3);
                                int i10 = iY - 4;
                                if (!((xVar5.t() & 128) != 0)) {
                                    x xVar6 = a_a.a;
                                    i3 = xVar6.f984b;
                                    i4 = xVar6.c;
                                    if (i3 < i4 && i10 > 0) {
                                        int iMin = Math.min(i10, i4 - i3);
                                        xVar5.e(a_a.a.a, i3, iMin);
                                        a_a.a.E(i3 + iMin);
                                    }
                                } else if (i10 >= 7 && (iV = xVar5.v()) >= 4) {
                                    a_a.h = xVar5.y();
                                    a_a.i = xVar5.y();
                                    a_a.a.A(iV - 4);
                                    i10 -= 7;
                                    x xVar7 = a_a.a;
                                    i3 = xVar7.f984b;
                                    i4 = xVar7.c;
                                    if (i3 < i4) {
                                        int iMin2 = Math.min(i10, i4 - i3);
                                        xVar5.e(a_a.a.a, i3, iMin2);
                                        a_a.a.E(i3 + iMin2);
                                    }
                                }
                            }
                            xVar = xVar5;
                            break;
                        case 22:
                            Objects.requireNonNull(a_a);
                            if (iY >= 19) {
                                a_a.d = xVar5.y();
                                a_a.e = xVar5.y();
                                xVar5.F(11);
                                a_a.f = xVar5.y();
                                a_a.g = xVar5.y();
                            }
                            xVar = xVar5;
                            break;
                        default:
                            xVar = xVar5;
                            break;
                    }
                    bVar = null;
                } else {
                    xVar = xVar5;
                    if (a_a.d == 0 || a_a.e == 0 || a_a.h == 0 || a_a.i == 0 || (i2 = (xVar2 = a_a.a).c) == 0 || xVar2.f984b != i2 || !a_a.c) {
                        bVar = null;
                    } else {
                        xVar2.E(0);
                        int i11 = a_a.h * a_a.i;
                        int[] iArr = new int[i11];
                        int i12 = 0;
                        while (i12 < i11) {
                            int iT5 = a_a.a.t();
                            if (iT5 != 0) {
                                iT = i12 + 1;
                                iArr[i12] = a_a.f871b[iT5];
                            } else {
                                int iT6 = a_a.a.t();
                                if (iT6 != 0) {
                                    iT = ((iT6 & 64) == 0 ? iT6 & 63 : ((iT6 & 63) << 8) | a_a.a.t()) + i12;
                                    Arrays.fill(iArr, i12, iT, (iT6 & 128) == 0 ? 0 : a_a.f871b[a_a.a.t()]);
                                }
                            }
                            i12 = iT;
                        }
                        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iArr, a_a.h, a_a.i, Bitmap$Config.ARGB_8888);
                        float f = a_a.f;
                        float f2 = a_a.d;
                        float f3 = f / f2;
                        float f4 = a_a.g;
                        float f5 = a_a.e;
                        bVar = new b.i.a.c.b3.b(null, null, null, bitmapCreateBitmap, f4 / f5, 0, 0, f3, 0, Integer.MIN_VALUE, -3.4028235E38f, a_a.h / f2, a_a.i / f5, false, ViewCompat.MEASURED_STATE_MASK, Integer.MIN_VALUE, 0.0f, null);
                    }
                    a_a.a();
                }
                xVar.E(i7);
            }
            ArrayList arrayList2 = arrayList;
            if (bVar != null) {
                arrayList2.add(bVar);
            }
            arrayList = arrayList2;
            i5 = 0;
            aVar = this;
        }
        return new b(Collections.unmodifiableList(arrayList));
    }
}
