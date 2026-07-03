package com.facebook.imagepipeline.nativecode;

import androidx.annotation.VisibleForTesting;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Objects;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p109f.p115d.p119d.C1678a;
import p007b.p109f.p115d.p119d.C1682e;
import p007b.p109f.p115d.p119d.InterfaceC1680c;
import p007b.p109f.p160i.C1831b;
import p007b.p109f.p160i.C1832c;
import p007b.p109f.p161j.p169d.C1884e;
import p007b.p109f.p161j.p169d.C1885f;
import p007b.p109f.p161j.p175j.C1919e;
import p007b.p109f.p161j.p184s.C2031a;
import p007b.p109f.p161j.p184s.C2034d;
import p007b.p109f.p161j.p184s.InterfaceC2032b;

/* JADX INFO: loaded from: classes3.dex */
@InterfaceC1680c
public class NativeJpegTranscoder implements InterfaceC2032b {

    /* JADX INFO: renamed from: a */
    public boolean f19568a;

    /* JADX INFO: renamed from: b */
    public int f19569b;

    /* JADX INFO: renamed from: c */
    public boolean f19570c;

    public NativeJpegTranscoder(boolean z2, int i, boolean z3, boolean z4) {
        this.f19568a = z2;
        this.f19569b = i;
        this.f19570c = z3;
        if (z4) {
            C1460d.m512e0();
        }
    }

    @VisibleForTesting
    /* JADX INFO: renamed from: e */
    public static void m8713e(InputStream inputStream, OutputStream outputStream, int i, int i2, int i3) throws IOException {
        C1460d.m512e0();
        C1460d.m527i(Boolean.valueOf(i2 >= 1));
        C1460d.m527i(Boolean.valueOf(i2 <= 16));
        C1460d.m527i(Boolean.valueOf(i3 >= 0));
        C1460d.m527i(Boolean.valueOf(i3 <= 100));
        C1682e<Integer> c1682e = C2034d.f4268a;
        C1460d.m527i(Boolean.valueOf(i >= 0 && i <= 270 && i % 90 == 0));
        C1460d.m535k((i2 == 8 && i == 0) ? false : true, "no transformation requested");
        Objects.requireNonNull(outputStream);
        nativeTranscodeJpeg(inputStream, outputStream, i, i2, i3);
    }

    @VisibleForTesting
    /* JADX INFO: renamed from: f */
    public static void m8714f(InputStream inputStream, OutputStream outputStream, int i, int i2, int i3) throws IOException {
        boolean z2;
        C1460d.m512e0();
        C1460d.m527i(Boolean.valueOf(i2 >= 1));
        C1460d.m527i(Boolean.valueOf(i2 <= 16));
        C1460d.m527i(Boolean.valueOf(i3 >= 0));
        C1460d.m527i(Boolean.valueOf(i3 <= 100));
        C1682e<Integer> c1682e = C2034d.f4268a;
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
        C1460d.m527i(Boolean.valueOf(z2));
        C1460d.m535k((i2 == 8 && i == 1) ? false : true, "no transformation requested");
        Objects.requireNonNull(outputStream);
        nativeTranscodeJpegWithExifOrientation(inputStream, outputStream, i, i2, i3);
    }

    @InterfaceC1680c
    private static native void nativeTranscodeJpeg(InputStream inputStream, OutputStream outputStream, int i, int i2, int i3) throws IOException;

    @InterfaceC1680c
    private static native void nativeTranscodeJpegWithExifOrientation(InputStream inputStream, OutputStream outputStream, int i, int i2, int i3) throws IOException;

    @Override // p007b.p109f.p161j.p184s.InterfaceC2032b
    /* JADX INFO: renamed from: a */
    public String mo1528a() {
        return "NativeJpegTranscoder";
    }

    @Override // p007b.p109f.p161j.p184s.InterfaceC2032b
    /* JADX INFO: renamed from: b */
    public boolean mo1529b(C1919e c1919e, C1885f c1885f, C1884e c1884e) {
        if (c1885f == null) {
            c1885f = C1885f.f3721a;
        }
        return C2034d.m1534c(c1885f, c1884e, c1919e, this.f19568a) < 8;
    }

    @Override // p007b.p109f.p161j.p184s.InterfaceC2032b
    /* JADX INFO: renamed from: c */
    public C2031a mo1530c(C1919e c1919e, OutputStream outputStream, C1885f c1885f, C1884e c1884e, C1832c c1832c, Integer num) throws IOException {
        if (num == null) {
            num = 85;
        }
        if (c1885f == null) {
            c1885f = C1885f.f3721a;
        }
        int iM496a0 = C1460d.m496a0(c1885f, c1884e, c1919e, this.f19569b);
        try {
            int iM1534c = C2034d.m1534c(c1885f, c1884e, c1919e, this.f19568a);
            int iMax = Math.max(1, 8 / iM496a0);
            if (this.f19570c) {
                iM1534c = iMax;
            }
            InputStream inputStreamM1342e = c1919e.m1342e();
            C1682e<Integer> c1682e = C2034d.f4268a;
            c1919e.m1347x();
            if (c1682e.contains(Integer.valueOf(c1919e.f3895n))) {
                int iM1532a = C2034d.m1532a(c1885f, c1919e);
                C1460d.m591y(inputStreamM1342e, "Cannot transcode from null input stream!");
                m8714f(inputStreamM1342e, outputStream, iM1532a, iM1534c, num.intValue());
            } else {
                int iM1533b = C2034d.m1533b(c1885f, c1919e);
                C1460d.m591y(inputStreamM1342e, "Cannot transcode from null input stream!");
                m8713e(inputStreamM1342e, outputStream, iM1533b, iM1534c, num.intValue());
            }
            C1678a.m966b(inputStreamM1342e);
            return new C2031a(iM496a0 != 1 ? 0 : 1);
        } catch (Throwable th) {
            C1678a.m966b(null);
            throw th;
        }
    }

    @Override // p007b.p109f.p161j.p184s.InterfaceC2032b
    /* JADX INFO: renamed from: d */
    public boolean mo1531d(C1832c c1832c) {
        return c1832c == C1831b.f3585a;
    }
}
