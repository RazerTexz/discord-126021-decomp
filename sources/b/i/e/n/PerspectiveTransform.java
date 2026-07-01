package b.i.e.n;

/* JADX INFO: renamed from: b.i.e.n.i, reason: use source file name */
/* JADX INFO: compiled from: PerspectiveTransform.java */
/* JADX INFO: loaded from: classes3.dex */
public final class PerspectiveTransform {
    public final float a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f1838b;
    public final float c;
    public final float d;
    public final float e;
    public final float f;
    public final float g;
    public final float h;
    public final float i;

    public PerspectiveTransform(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        this.a = f;
        this.f1838b = f4;
        this.c = f7;
        this.d = f2;
        this.e = f5;
        this.f = f8;
        this.g = f3;
        this.h = f6;
        this.i = f9;
    }

    public static PerspectiveTransform a(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16) {
        PerspectiveTransform perspectiveTransformB = b(f, f2, f3, f4, f5, f6, f7, f8);
        float f17 = perspectiveTransformB.e;
        float f18 = perspectiveTransformB.i;
        float f19 = perspectiveTransformB.f;
        float f20 = perspectiveTransformB.h;
        float f21 = (f17 * f18) - (f19 * f20);
        float f22 = perspectiveTransformB.g;
        float f23 = perspectiveTransformB.d;
        float f24 = (f19 * f22) - (f23 * f18);
        float f25 = (f23 * f20) - (f17 * f22);
        float f26 = perspectiveTransformB.c;
        float f27 = perspectiveTransformB.f1838b;
        float f28 = (f26 * f20) - (f27 * f18);
        float f29 = perspectiveTransformB.a;
        float f30 = (f18 * f29) - (f26 * f22);
        float f31 = (f22 * f27) - (f20 * f29);
        float f32 = (f27 * f19) - (f26 * f17);
        float f33 = (f26 * f23) - (f19 * f29);
        float f34 = (f29 * f17) - (f27 * f23);
        PerspectiveTransform perspectiveTransformB2 = b(f9, f10, f11, f12, f13, f14, f15, f16);
        float f35 = perspectiveTransformB2.a;
        float f36 = perspectiveTransformB2.d;
        float f37 = perspectiveTransformB2.g;
        float f38 = (f36 * f28) + (f35 * f21) + (f37 * f32);
        float f39 = (f37 * f33) + (f36 * f30) + (f35 * f24);
        float f40 = f37 * f34;
        float f41 = f40 + (f36 * f31) + (f35 * f25);
        float f42 = perspectiveTransformB2.f1838b;
        float f43 = perspectiveTransformB2.e;
        float f44 = perspectiveTransformB2.h;
        float f45 = (f44 * f32) + (f43 * f28) + (f42 * f21);
        float f46 = (f44 * f33) + (f43 * f30) + (f42 * f24);
        float f47 = (f43 * f31) + (f42 * f25) + (f44 * f34);
        float f48 = perspectiveTransformB2.c;
        float f49 = perspectiveTransformB2.f;
        float f50 = f28 * f49;
        float f51 = perspectiveTransformB2.i;
        return new PerspectiveTransform(f38, f39, f41, f45, f46, f47, (f32 * f51) + f50 + (f21 * f48), (f30 * f49) + (f24 * f48) + (f33 * f51), (f51 * f34) + (f49 * f31) + (f48 * f25));
    }

    public static PerspectiveTransform b(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        float f9 = ((f - f3) + f5) - f7;
        float f10 = ((f2 - f4) + f6) - f8;
        if (f9 == 0.0f && f10 == 0.0f) {
            return new PerspectiveTransform(f3 - f, f5 - f3, f, f4 - f2, f6 - f4, f2, 0.0f, 0.0f, 1.0f);
        }
        float f11 = f3 - f5;
        float f12 = f7 - f5;
        float f13 = f4 - f6;
        float f14 = f8 - f6;
        float f15 = (f11 * f14) - (f12 * f13);
        float f16 = ((f14 * f9) - (f12 * f10)) / f15;
        float f17 = ((f11 * f10) - (f9 * f13)) / f15;
        return new PerspectiveTransform((f16 * f3) + (f3 - f), (f17 * f7) + (f7 - f), f, (f16 * f4) + (f4 - f2), (f17 * f8) + (f8 - f2), f2, f16, f17, 1.0f);
    }
}
