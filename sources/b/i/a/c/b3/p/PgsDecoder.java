package b.i.a.c.b3.p;

import android.graphics.Bitmap;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import b.i.a.c.b3.Cue;
import b.i.a.c.b3.SimpleSubtitleDecoder2;
import b.i.a.c.b3.Subtitle;
import b.i.a.c.f3.ParsableByteArray;
import b.i.a.c.f3.Util2;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;
import java.util.zip.Inflater;

/* JADX INFO: renamed from: b.i.a.c.b3.p.a, reason: use source file name */
/* JADX INFO: compiled from: PgsDecoder.java */
/* JADX INFO: loaded from: classes3.dex */
public final class PgsDecoder extends SimpleSubtitleDecoder2 {
    public final ParsableByteArray n;
    public final ParsableByteArray o;
    public final a p;

    @Nullable
    public Inflater q;

    /* JADX INFO: renamed from: b.i.a.c.b3.p.a$a */
    /* JADX INFO: compiled from: PgsDecoder.java */
    public static final class a {
        public final ParsableByteArray a = new ParsableByteArray();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int[] f871b = new int[256];
        public boolean c;
        public int d;
        public int e;
        public int f;
        public int g;
        public int h;
        public int i;

        public void a() {
            this.d = 0;
            this.e = 0;
            this.f = 0;
            this.g = 0;
            this.h = 0;
            this.i = 0;
            this.a.A(0);
            this.c = false;
        }
    }

    public PgsDecoder() {
        super("PgsDecoder");
        this.n = new ParsableByteArray();
        this.o = new ParsableByteArray();
        this.p = new a();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:21:0x006f  */
    @Override // b.i.a.c.b3.SimpleSubtitleDecoder2
    public Subtitle j(byte[] bArr, int i, boolean z2) throws SubtitleDecoderException {
        ParsableByteArray parsableByteArray;
        Cue cue;
        ParsableByteArray parsableByteArray2;
        int i2;
        int iT;
        int i3;
        int i4;
        int iV;
        PgsDecoder pgsDecoder = this;
        ParsableByteArray parsableByteArray3 = pgsDecoder.n;
        parsableByteArray3.a = bArr;
        parsableByteArray3.c = i;
        int i5 = 0;
        parsableByteArray3.f984b = 0;
        if (parsableByteArray3.a() > 0 && parsableByteArray3.c() == 120) {
            if (pgsDecoder.q == null) {
                pgsDecoder.q = new Inflater();
            }
            if (Util2.x(parsableByteArray3, pgsDecoder.o, pgsDecoder.q)) {
                ParsableByteArray parsableByteArray4 = pgsDecoder.o;
                parsableByteArray3.C(parsableByteArray4.a, parsableByteArray4.c);
            }
        }
        pgsDecoder.p.a();
        ArrayList arrayList = new ArrayList();
        while (pgsDecoder.n.a() >= 3) {
            ParsableByteArray parsableByteArray5 = pgsDecoder.n;
            a aVar = pgsDecoder.p;
            int i6 = parsableByteArray5.c;
            int iT2 = parsableByteArray5.t();
            int iY = parsableByteArray5.y();
            int i7 = parsableByteArray5.f984b + iY;
            if (i7 > i6) {
                parsableByteArray5.E(i6);
                cue = null;
            } else {
                if (iT2 != 128) {
                    switch (iT2) {
                        case 20:
                            Objects.requireNonNull(aVar);
                            if (iY % 5 == 2) {
                                parsableByteArray5.F(2);
                                Arrays.fill(aVar.f871b, i5);
                                int i8 = iY / 5;
                                int i9 = 0;
                                while (i9 < i8) {
                                    int iT3 = parsableByteArray5.t();
                                    int iT4 = parsableByteArray5.t();
                                    double d = iT4;
                                    double dT = parsableByteArray5.t() - 128;
                                    arrayList = arrayList;
                                    double dT2 = parsableByteArray5.t() - 128;
                                    aVar.f871b[iT3] = (Util2.h((int) ((1.402d * dT) + d), 0, 255) << 16) | (parsableByteArray5.t() << 24) | (Util2.h((int) ((d - (0.34414d * dT2)) - (dT * 0.71414d)), 0, 255) << 8) | Util2.h((int) ((dT2 * 1.772d) + d), 0, 255);
                                    i9++;
                                    parsableByteArray5 = parsableByteArray5;
                                }
                                parsableByteArray = parsableByteArray5;
                                aVar.c = true;
                            } else {
                                parsableByteArray = parsableByteArray5;
                            }
                            break;
                        case 21:
                            Objects.requireNonNull(aVar);
                            if (iY >= 4) {
                                parsableByteArray5.F(3);
                                int i10 = iY - 4;
                                if (!((parsableByteArray5.t() & 128) != 0)) {
                                    ParsableByteArray parsableByteArray6 = aVar.a;
                                    i3 = parsableByteArray6.f984b;
                                    i4 = parsableByteArray6.c;
                                    if (i3 < i4 && i10 > 0) {
                                        int iMin = Math.min(i10, i4 - i3);
                                        parsableByteArray5.e(aVar.a.a, i3, iMin);
                                        aVar.a.E(i3 + iMin);
                                    }
                                } else if (i10 >= 7 && (iV = parsableByteArray5.v()) >= 4) {
                                    aVar.h = parsableByteArray5.y();
                                    aVar.i = parsableByteArray5.y();
                                    aVar.a.A(iV - 4);
                                    i10 -= 7;
                                    ParsableByteArray parsableByteArray7 = aVar.a;
                                    i3 = parsableByteArray7.f984b;
                                    i4 = parsableByteArray7.c;
                                    if (i3 < i4) {
                                        int iMin2 = Math.min(i10, i4 - i3);
                                        parsableByteArray5.e(aVar.a.a, i3, iMin2);
                                        aVar.a.E(i3 + iMin2);
                                    }
                                }
                            }
                            parsableByteArray = parsableByteArray5;
                            break;
                        case 22:
                            Objects.requireNonNull(aVar);
                            if (iY >= 19) {
                                aVar.d = parsableByteArray5.y();
                                aVar.e = parsableByteArray5.y();
                                parsableByteArray5.F(11);
                                aVar.f = parsableByteArray5.y();
                                aVar.g = parsableByteArray5.y();
                            }
                            parsableByteArray = parsableByteArray5;
                            break;
                        default:
                            parsableByteArray = parsableByteArray5;
                            break;
                    }
                    cue = null;
                } else {
                    parsableByteArray = parsableByteArray5;
                    if (aVar.d == 0 || aVar.e == 0 || aVar.h == 0 || aVar.i == 0 || (i2 = (parsableByteArray2 = aVar.a).c) == 0 || parsableByteArray2.f984b != i2 || !aVar.c) {
                        cue = null;
                    } else {
                        parsableByteArray2.E(0);
                        int i11 = aVar.h * aVar.i;
                        int[] iArr = new int[i11];
                        int i12 = 0;
                        while (i12 < i11) {
                            int iT5 = aVar.a.t();
                            if (iT5 != 0) {
                                iT = i12 + 1;
                                iArr[i12] = aVar.f871b[iT5];
                            } else {
                                int iT6 = aVar.a.t();
                                if (iT6 != 0) {
                                    iT = ((iT6 & 64) == 0 ? iT6 & 63 : ((iT6 & 63) << 8) | aVar.a.t()) + i12;
                                    Arrays.fill(iArr, i12, iT, (iT6 & 128) == 0 ? 0 : aVar.f871b[aVar.a.t()]);
                                }
                            }
                            i12 = iT;
                        }
                        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iArr, aVar.h, aVar.i, Bitmap.Config.ARGB_8888);
                        float f = aVar.f;
                        float f2 = aVar.d;
                        float f3 = f / f2;
                        float f4 = aVar.g;
                        float f5 = aVar.e;
                        cue = new Cue(null, null, null, bitmapCreateBitmap, f4 / f5, 0, 0, f3, 0, Integer.MIN_VALUE, -3.4028235E38f, aVar.h / f2, aVar.i / f5, false, ViewCompat.MEASURED_STATE_MASK, Integer.MIN_VALUE, 0.0f, null);
                    }
                    aVar.a();
                }
                parsableByteArray.E(i7);
            }
            ArrayList arrayList2 = arrayList;
            if (cue != null) {
                arrayList2.add(cue);
            }
            arrayList = arrayList2;
            i5 = 0;
            pgsDecoder = this;
        }
        return new PgsSubtitle(Collections.unmodifiableList(arrayList));
    }
}
