package p007b.p225i.p226a.p242c.p260g3.p261z;

import android.opengl.Matrix;
import p007b.p225i.p226a.p242c.p259f3.C2734c0;

/* JADX INFO: renamed from: b.i.a.c.g3.z.f */
/* JADX INFO: compiled from: FrameRotationQueue.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2794f {

    /* JADX INFO: renamed from: a */
    public final float[] f6968a = new float[16];

    /* JADX INFO: renamed from: b */
    public final float[] f6969b = new float[16];

    /* JADX INFO: renamed from: c */
    public final C2734c0<float[]> f6970c = new C2734c0<>();

    /* JADX INFO: renamed from: d */
    public boolean f6971d;

    /* JADX INFO: renamed from: a */
    public static void m3198a(float[] fArr, float[] fArr2) {
        Matrix.setIdentityM(fArr, 0);
        float fSqrt = (float) Math.sqrt((fArr2[8] * fArr2[8]) + (fArr2[10] * fArr2[10]));
        fArr[0] = fArr2[10] / fSqrt;
        fArr[2] = fArr2[8] / fSqrt;
        fArr[8] = (-fArr2[8]) / fSqrt;
        fArr[10] = fArr2[10] / fSqrt;
    }
}
