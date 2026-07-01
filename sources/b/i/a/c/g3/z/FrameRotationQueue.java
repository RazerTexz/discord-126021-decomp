package b.i.a.c.g3.z;

import android.opengl.Matrix;
import b.i.a.c.f3.TimedValueQueue;

/* JADX INFO: renamed from: b.i.a.c.g3.z.f, reason: use source file name */
/* JADX INFO: compiled from: FrameRotationQueue.java */
/* JADX INFO: loaded from: classes3.dex */
public final class FrameRotationQueue {
    public final float[] a = new float[16];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float[] f998b = new float[16];
    public final TimedValueQueue<float[]> c = new TimedValueQueue<>();
    public boolean d;

    public static void a(float[] fArr, float[] fArr2) {
        Matrix.setIdentityM(fArr, 0);
        float fSqrt = (float) Math.sqrt((fArr2[8] * fArr2[8]) + (fArr2[10] * fArr2[10]));
        fArr[0] = fArr2[10] / fSqrt;
        fArr[2] = fArr2[8] / fSqrt;
        fArr[8] = (-fArr2[8]) / fSqrt;
        fArr[10] = fArr2[10] / fSqrt;
    }
}
