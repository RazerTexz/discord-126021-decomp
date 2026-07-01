package b.f.j.s;

import b.f.d.d.ImmutableList;
import b.f.j.d.ResizeOptions;
import b.f.j.d.RotationOptions;
import b.f.j.j.EncodedImage2;
import java.util.Collections;

/* JADX INFO: renamed from: b.f.j.s.d, reason: use source file name */
/* JADX INFO: compiled from: JpegTranscoderUtils.java */
/* JADX INFO: loaded from: classes3.dex */
public class JpegTranscoderUtils {
    public static final ImmutableList<Integer> a;

    static {
        ImmutableList<Integer> immutableList = new ImmutableList<>(4);
        Collections.addAll(immutableList, 2, 7, 4, 5);
        a = immutableList;
    }

    public static int a(RotationOptions rotationOptions, EncodedImage2 encodedImage2) {
        encodedImage2.x();
        int i = encodedImage2.n;
        ImmutableList<Integer> immutableList = a;
        int iIndexOf = immutableList.indexOf(Integer.valueOf(i));
        if (iIndexOf >= 0) {
            return immutableList.get((((rotationOptions.c() ? 0 : rotationOptions.a()) / 90) + iIndexOf) % immutableList.size()).intValue();
        }
        throw new IllegalArgumentException("Only accepts inverted exif orientations");
    }

    public static int b(RotationOptions rotationOptions, EncodedImage2 encodedImage2) {
        int i = 0;
        if (!rotationOptions.b()) {
            return 0;
        }
        encodedImage2.x();
        int i2 = encodedImage2.m;
        if (i2 == 90 || i2 == 180 || i2 == 270) {
            encodedImage2.x();
            i = encodedImage2.m;
        }
        return rotationOptions.c() ? i : (rotationOptions.a() + i) % 360;
    }

    public static int c(RotationOptions rotationOptions, ResizeOptions resizeOptions, EncodedImage2 encodedImage2, boolean z2) {
        int i;
        int i2;
        if (!z2 || resizeOptions == null) {
            return 8;
        }
        int iB = b(rotationOptions, encodedImage2);
        ImmutableList<Integer> immutableList = a;
        encodedImage2.x();
        int iA = immutableList.contains(Integer.valueOf(encodedImage2.n)) ? a(rotationOptions, encodedImage2) : 0;
        boolean z3 = iB == 90 || iB == 270 || iA == 5 || iA == 7;
        if (z3) {
            encodedImage2.x();
            i = encodedImage2.p;
        } else {
            encodedImage2.x();
            i = encodedImage2.o;
        }
        if (z3) {
            encodedImage2.x();
            i2 = encodedImage2.o;
        } else {
            encodedImage2.x();
            i2 = encodedImage2.p;
        }
        float f = i;
        float f2 = i2;
        float fMax = Math.max(resizeOptions.a / f, resizeOptions.f566b / f2);
        float f3 = f * fMax;
        float f4 = resizeOptions.c;
        if (f3 > f4) {
            fMax = f4 / f;
        }
        if (f2 * fMax > f4) {
            fMax = f4 / f2;
        }
        int i3 = (int) ((fMax * 8.0f) + resizeOptions.d);
        if (i3 > 8) {
            return 8;
        }
        if (i3 < 1) {
            return 1;
        }
        return i3;
    }
}
