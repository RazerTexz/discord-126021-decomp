package com.facebook.imagepipeline.nativecode;

import androidx.annotation.VisibleForTesting;
import b.c.a.a0.d;
import b.f.d.d.c;
import b.f.d.d.e;
import b.f.j.d.f;
import b.f.j.s.a;
import b.f.j.s.b;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
@c
public class NativeJpegTranscoder implements b {
    public boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f2899b;
    public boolean c;

    public NativeJpegTranscoder(boolean z2, int i, boolean z3, boolean z4) {
        this.a = z2;
        this.f2899b = i;
        this.c = z3;
        if (z4) {
            d.e0();
        }
    }

    @VisibleForTesting
    public static void e(InputStream inputStream, OutputStream outputStream, int i, int i2, int i3) throws IOException {
        d.e0();
        d.i(Boolean.valueOf(i2 >= 1));
        d.i(Boolean.valueOf(i2 <= 16));
        d.i(Boolean.valueOf(i3 >= 0));
        d.i(Boolean.valueOf(i3 <= 100));
        e<Integer> eVar = b.f.j.s.d.a;
        d.i(Boolean.valueOf(i >= 0 && i <= 270 && i % 90 == 0));
        d.k((i2 == 8 && i == 0) ? false : true, "no transformation requested");
        Objects.requireNonNull(outputStream);
        nativeTranscodeJpeg(inputStream, outputStream, i, i2, i3);
    }

    @VisibleForTesting
    public static void f(InputStream inputStream, OutputStream outputStream, int i, int i2, int i3) throws IOException {
        boolean z2;
        d.e0();
        d.i(Boolean.valueOf(i2 >= 1));
        d.i(Boolean.valueOf(i2 <= 16));
        d.i(Boolean.valueOf(i3 >= 0));
        d.i(Boolean.valueOf(i3 <= 100));
        e<Integer> eVar = b.f.j.s.d.a;
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                z2 = true;
                break;
            default:
                z2 = false;
                break;
        }
        d.i(Boolean.valueOf(z2));
        d.k((i2 == 8 && i == 1) ? false : true, "no transformation requested");
        Objects.requireNonNull(outputStream);
        nativeTranscodeJpegWithExifOrientation(inputStream, outputStream, i, i2, i3);
    }

    @c
    private static native void nativeTranscodeJpeg(InputStream inputStream, OutputStream outputStream, int i, int i2, int i3) throws IOException;

    @c
    private static native void nativeTranscodeJpegWithExifOrientation(InputStream inputStream, OutputStream outputStream, int i, int i2, int i3) throws IOException;

    @Override // b.f.j.s.b
    public String a() {
        return "NativeJpegTranscoder";
    }

    @Override // b.f.j.s.b
    public boolean b(b.f.j.j.e eVar, f fVar, b.f.j.d.e eVar2) {
        if (fVar == null) {
            fVar = f.a;
        }
        return b.f.j.s.d.c(fVar, eVar2, eVar, this.a) < 8;
    }

    @Override // b.f.j.s.b
    public a c(b.f.j.j.e eVar, OutputStream outputStream, f fVar, b.f.j.d.e eVar2, b.f.i.c cVar, Integer num) throws IOException {
        if (num == null) {
            num = 85;
        }
        if (fVar == null) {
            fVar = f.a;
        }
        int iA0 = d.a0(fVar, eVar2, eVar, this.f2899b);
        try {
            int iC = b.f.j.s.d.c(fVar, eVar2, eVar, this.a);
            int iMax = Math.max(1, 8 / iA0);
            if (this.c) {
                iC = iMax;
            }
            InputStream inputStreamE = eVar.e();
            e<Integer> eVar3 = b.f.j.s.d.a;
            eVar.x();
            if (eVar3.contains(Integer.valueOf(eVar.n))) {
                int iA = b.f.j.s.d.a(fVar, eVar);
                d.y(inputStreamE, "Cannot transcode from null input stream!");
                f(inputStreamE, outputStream, iA, iC, num.intValue());
            } else {
                int iB = b.f.j.s.d.b(fVar, eVar);
                d.y(inputStreamE, "Cannot transcode from null input stream!");
                e(inputStreamE, outputStream, iB, iC, num.intValue());
            }
            b.f.d.d.a.b(inputStreamE);
            return new a(iA0 != 1 ? 0 : 1);
        } catch (Throwable th) {
            b.f.d.d.a.b(null);
            throw th;
        }
    }

    @Override // b.f.j.s.b
    public boolean d(b.f.i.c cVar) {
        return cVar == b.f.i.b.a;
    }
}
