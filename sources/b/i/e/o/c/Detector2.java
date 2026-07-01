package b.i.e.o.c;

import b.i.a.f.e.o.f;
import b.i.e.ResultPoint;
import b.i.e.n.BitMatrix;
import b.i.e.n.DefaultGridSampler;
import b.i.e.n.PerspectiveTransform;
import b.i.e.n.k.WhiteRectangleDetector;
import com.discord.widgets.chat.input.MentionUtils;
import com.discord.widgets.chat.input.autocomplete.AutocompleteViewModel;
import com.google.zxing.NotFoundException;
import java.io.Serializable;
import java.util.Comparator;
import java.util.Map;

/* JADX INFO: renamed from: b.i.e.o.c.a, reason: use source file name */
/* JADX INFO: compiled from: Detector.java */
/* JADX INFO: loaded from: classes3.dex */
public final class Detector2 {
    public final BitMatrix a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WhiteRectangleDetector f1850b;

    /* JADX INFO: renamed from: b.i.e.o.c.a$b */
    /* JADX INFO: compiled from: Detector.java */
    public static final class b {
        public final ResultPoint a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ResultPoint f1851b;
        public final int c;

        public b(ResultPoint resultPoint, ResultPoint resultPoint2, int i, a aVar) {
            this.a = resultPoint;
            this.f1851b = resultPoint2;
            this.c = i;
        }

        public String toString() {
            return this.a + AutocompleteViewModel.COMMAND_DISCOVER_TOKEN + this.f1851b + MentionUtils.SLASH_CHAR + this.c;
        }
    }

    /* JADX INFO: renamed from: b.i.e.o.c.a$c */
    /* JADX INFO: compiled from: Detector.java */
    public static final class c implements Serializable, Comparator<b> {
        public c(a aVar) {
        }

        @Override // java.util.Comparator
        public int compare(b bVar, b bVar2) {
            return bVar.c - bVar2.c;
        }
    }

    public Detector2(BitMatrix bitMatrix) throws NotFoundException {
        this.a = bitMatrix;
        this.f1850b = new WhiteRectangleDetector(bitMatrix, 10, bitMatrix.j / 2, bitMatrix.k / 2);
    }

    public static int a(ResultPoint resultPoint, ResultPoint resultPoint2) {
        return f.Z0(f.Q(resultPoint.a, resultPoint.f1826b, resultPoint2.a, resultPoint2.f1826b));
    }

    public static void b(Map<ResultPoint, Integer> map, ResultPoint resultPoint) {
        Integer num = map.get(resultPoint);
        map.put(resultPoint, Integer.valueOf(num != null ? 1 + num.intValue() : 1));
    }

    public static BitMatrix d(BitMatrix bitMatrix, ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3, ResultPoint resultPoint4, int i, int i2) throws NotFoundException {
        float f = i - 0.5f;
        float f2 = i2 - 0.5f;
        return DefaultGridSampler.a.a(bitMatrix, i, i2, PerspectiveTransform.a(0.5f, 0.5f, f, 0.5f, f, f2, 0.5f, f2, resultPoint.a, resultPoint.f1826b, resultPoint4.a, resultPoint4.f1826b, resultPoint3.a, resultPoint3.f1826b, resultPoint2.a, resultPoint2.f1826b));
    }

    public final boolean c(ResultPoint resultPoint) {
        float f = resultPoint.a;
        if (f < 0.0f) {
            return false;
        }
        BitMatrix bitMatrix = this.a;
        if (f >= bitMatrix.j) {
            return false;
        }
        float f2 = resultPoint.f1826b;
        return f2 > 0.0f && f2 < ((float) bitMatrix.k);
    }

    public final b e(ResultPoint resultPoint, ResultPoint resultPoint2) {
        Detector2 detector2 = this;
        int i = (int) resultPoint.a;
        int i2 = (int) resultPoint.f1826b;
        int i3 = (int) resultPoint2.a;
        int i4 = (int) resultPoint2.f1826b;
        boolean z2 = Math.abs(i4 - i2) > Math.abs(i3 - i);
        if (z2) {
            i2 = i;
            i = i2;
            i4 = i3;
            i3 = i4;
        }
        int iAbs = Math.abs(i3 - i);
        int iAbs2 = Math.abs(i4 - i2);
        int i5 = (-iAbs) / 2;
        int i6 = i2 < i4 ? 1 : -1;
        int i7 = i >= i3 ? -1 : 1;
        boolean zF = detector2.a.f(z2 ? i2 : i, z2 ? i : i2);
        int i8 = 0;
        while (i != i3) {
            boolean zF2 = detector2.a.f(z2 ? i2 : i, z2 ? i : i2);
            if (zF2 != zF) {
                i8++;
                zF = zF2;
            }
            i5 += iAbs2;
            if (i5 > 0) {
                if (i2 == i4) {
                    break;
                }
                i2 += i6;
                i5 -= iAbs;
            }
            i += i7;
            detector2 = this;
        }
        return new b(resultPoint, resultPoint2, i8, null);
    }
}
