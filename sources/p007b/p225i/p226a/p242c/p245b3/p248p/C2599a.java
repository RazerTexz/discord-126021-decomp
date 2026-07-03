package p007b.p225i.p226a.p242c.p245b3.p248p;

import android.graphics.Bitmap;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;
import java.util.zip.Inflater;
import p007b.p225i.p226a.p242c.p245b3.AbstractC2582f;
import p007b.p225i.p226a.p242c.p245b3.C2578b;
import p007b.p225i.p226a.p242c.p245b3.InterfaceC2583g;
import p007b.p225i.p226a.p242c.p259f3.C2738e0;
import p007b.p225i.p226a.p242c.p259f3.C2757x;

/* JADX INFO: renamed from: b.i.a.c.b3.p.a */
/* JADX INFO: compiled from: PgsDecoder.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2599a extends AbstractC2582f {

    /* JADX INFO: renamed from: n */
    public final C2757x f5967n;

    /* JADX INFO: renamed from: o */
    public final C2757x f5968o;

    /* JADX INFO: renamed from: p */
    public final a f5969p;

    /* JADX INFO: renamed from: q */
    @Nullable
    public Inflater f5970q;

    /* JADX INFO: renamed from: b.i.a.c.b3.p.a$a */
    /* JADX INFO: compiled from: PgsDecoder.java */
    public static final class a {

        /* JADX INFO: renamed from: a */
        public final C2757x f5971a = new C2757x();

        /* JADX INFO: renamed from: b */
        public final int[] f5972b = new int[256];

        /* JADX INFO: renamed from: c */
        public boolean f5973c;

        /* JADX INFO: renamed from: d */
        public int f5974d;

        /* JADX INFO: renamed from: e */
        public int f5975e;

        /* JADX INFO: renamed from: f */
        public int f5976f;

        /* JADX INFO: renamed from: g */
        public int f5977g;

        /* JADX INFO: renamed from: h */
        public int f5978h;

        /* JADX INFO: renamed from: i */
        public int f5979i;

        /* JADX INFO: renamed from: a */
        public void m2667a() {
            this.f5974d = 0;
            this.f5975e = 0;
            this.f5976f = 0;
            this.f5977g = 0;
            this.f5978h = 0;
            this.f5979i = 0;
            this.f5971a.m3075A(0);
            this.f5973c = false;
        }
    }

    public C2599a() {
        super("PgsDecoder");
        this.f5967n = new C2757x();
        this.f5968o = new C2757x();
        this.f5969p = new a();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:21:0x006f  */
    @Override // p007b.p225i.p226a.p242c.p245b3.AbstractC2582f
    /* JADX INFO: renamed from: j */
    public InterfaceC2583g mo2617j(byte[] bArr, int i, boolean z2) throws SubtitleDecoderException {
        C2757x c2757x;
        C2578b c2578b;
        C2757x c2757x2;
        int i2;
        int iM3100t;
        int i3;
        int i4;
        int iM3102v;
        C2599a c2599a = this;
        C2757x c2757x3 = c2599a.f5967n;
        c2757x3.f6793a = bArr;
        c2757x3.f6795c = i;
        int i5 = 0;
        c2757x3.f6794b = 0;
        if (c2757x3.m3081a() > 0 && c2757x3.m3083c() == 120) {
            if (c2599a.f5970q == null) {
                c2599a.f5970q = new Inflater();
            }
            if (C2738e0.m3016x(c2757x3, c2599a.f5968o, c2599a.f5970q)) {
                C2757x c2757x4 = c2599a.f5968o;
                c2757x3.m3077C(c2757x4.f6793a, c2757x4.f6795c);
            }
        }
        c2599a.f5969p.m2667a();
        ArrayList arrayList = new ArrayList();
        while (c2599a.f5967n.m3081a() >= 3) {
            C2757x c2757x5 = c2599a.f5967n;
            a aVar = c2599a.f5969p;
            int i6 = c2757x5.f6795c;
            int iM3100t2 = c2757x5.m3100t();
            int iM3105y = c2757x5.m3105y();
            int i7 = c2757x5.f6794b + iM3105y;
            if (i7 > i6) {
                c2757x5.m3079E(i6);
                c2578b = null;
            } else {
                if (iM3100t2 != 128) {
                    switch (iM3100t2) {
                        case 20:
                            Objects.requireNonNull(aVar);
                            if (iM3105y % 5 == 2) {
                                c2757x5.m3080F(2);
                                Arrays.fill(aVar.f5972b, i5);
                                int i8 = iM3105y / 5;
                                int i9 = 0;
                                while (i9 < i8) {
                                    int iM3100t3 = c2757x5.m3100t();
                                    int iM3100t4 = c2757x5.m3100t();
                                    double d = iM3100t4;
                                    double dM3100t = c2757x5.m3100t() - 128;
                                    arrayList = arrayList;
                                    double dM3100t2 = c2757x5.m3100t() - 128;
                                    aVar.f5972b[iM3100t3] = (C2738e0.m3000h((int) ((1.402d * dM3100t) + d), 0, 255) << 16) | (c2757x5.m3100t() << 24) | (C2738e0.m3000h((int) ((d - (0.34414d * dM3100t2)) - (dM3100t * 0.71414d)), 0, 255) << 8) | C2738e0.m3000h((int) ((dM3100t2 * 1.772d) + d), 0, 255);
                                    i9++;
                                    c2757x5 = c2757x5;
                                }
                                c2757x = c2757x5;
                                aVar.f5973c = true;
                            } else {
                                c2757x = c2757x5;
                            }
                            break;
                        case 21:
                            Objects.requireNonNull(aVar);
                            if (iM3105y >= 4) {
                                c2757x5.m3080F(3);
                                int i10 = iM3105y - 4;
                                if (!((c2757x5.m3100t() & 128) != 0)) {
                                    C2757x c2757x6 = aVar.f5971a;
                                    i3 = c2757x6.f6794b;
                                    i4 = c2757x6.f6795c;
                                    if (i3 < i4 && i10 > 0) {
                                        int iMin = Math.min(i10, i4 - i3);
                                        c2757x5.m3085e(aVar.f5971a.f6793a, i3, iMin);
                                        aVar.f5971a.m3079E(i3 + iMin);
                                    }
                                } else if (i10 >= 7 && (iM3102v = c2757x5.m3102v()) >= 4) {
                                    aVar.f5978h = c2757x5.m3105y();
                                    aVar.f5979i = c2757x5.m3105y();
                                    aVar.f5971a.m3075A(iM3102v - 4);
                                    i10 -= 7;
                                    C2757x c2757x7 = aVar.f5971a;
                                    i3 = c2757x7.f6794b;
                                    i4 = c2757x7.f6795c;
                                    if (i3 < i4) {
                                        int iMin2 = Math.min(i10, i4 - i3);
                                        c2757x5.m3085e(aVar.f5971a.f6793a, i3, iMin2);
                                        aVar.f5971a.m3079E(i3 + iMin2);
                                    }
                                }
                            }
                            c2757x = c2757x5;
                            break;
                        case 22:
                            Objects.requireNonNull(aVar);
                            if (iM3105y >= 19) {
                                aVar.f5974d = c2757x5.m3105y();
                                aVar.f5975e = c2757x5.m3105y();
                                c2757x5.m3080F(11);
                                aVar.f5976f = c2757x5.m3105y();
                                aVar.f5977g = c2757x5.m3105y();
                            }
                            c2757x = c2757x5;
                            break;
                        default:
                            c2757x = c2757x5;
                            break;
                    }
                    c2578b = null;
                } else {
                    c2757x = c2757x5;
                    if (aVar.f5974d == 0 || aVar.f5975e == 0 || aVar.f5978h == 0 || aVar.f5979i == 0 || (i2 = (c2757x2 = aVar.f5971a).f6795c) == 0 || c2757x2.f6794b != i2 || !aVar.f5973c) {
                        c2578b = null;
                    } else {
                        c2757x2.m3079E(0);
                        int i11 = aVar.f5978h * aVar.f5979i;
                        int[] iArr = new int[i11];
                        int i12 = 0;
                        while (i12 < i11) {
                            int iM3100t5 = aVar.f5971a.m3100t();
                            if (iM3100t5 != 0) {
                                iM3100t = i12 + 1;
                                iArr[i12] = aVar.f5972b[iM3100t5];
                            } else {
                                int iM3100t6 = aVar.f5971a.m3100t();
                                if (iM3100t6 != 0) {
                                    iM3100t = ((iM3100t6 & 64) == 0 ? iM3100t6 & 63 : ((iM3100t6 & 63) << 8) | aVar.f5971a.m3100t()) + i12;
                                    Arrays.fill(iArr, i12, iM3100t, (iM3100t6 & 128) == 0 ? 0 : aVar.f5972b[aVar.f5971a.m3100t()]);
                                }
                            }
                            i12 = iM3100t;
                        }
                        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iArr, aVar.f5978h, aVar.f5979i, Bitmap.Config.ARGB_8888);
                        float f = aVar.f5976f;
                        float f2 = aVar.f5974d;
                        float f3 = f / f2;
                        float f4 = aVar.f5977g;
                        float f5 = aVar.f5975e;
                        c2578b = new C2578b(null, null, null, bitmapCreateBitmap, f4 / f5, 0, 0, f3, 0, Integer.MIN_VALUE, -3.4028235E38f, aVar.f5978h / f2, aVar.f5979i / f5, false, ViewCompat.MEASURED_STATE_MASK, Integer.MIN_VALUE, 0.0f, null);
                    }
                    aVar.m2667a();
                }
                c2757x.m3079E(i7);
            }
            ArrayList arrayList2 = arrayList;
            if (c2578b != null) {
                arrayList2.add(c2578b);
            }
            arrayList = arrayList2;
            i5 = 0;
            c2599a = this;
        }
        return new C2600b(Collections.unmodifiableList(arrayList));
    }
}
