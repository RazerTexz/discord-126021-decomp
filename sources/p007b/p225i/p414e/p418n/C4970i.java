package p007b.p225i.p414e.p418n;

/* JADX INFO: renamed from: b.i.e.n.i */
/* JADX INFO: compiled from: PerspectiveTransform.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C4970i {

    /* JADX INFO: renamed from: a */
    public final float f13281a;

    /* JADX INFO: renamed from: b */
    public final float f13282b;

    /* JADX INFO: renamed from: c */
    public final float f13283c;

    /* JADX INFO: renamed from: d */
    public final float f13284d;

    /* JADX INFO: renamed from: e */
    public final float f13285e;

    /* JADX INFO: renamed from: f */
    public final float f13286f;

    /* JADX INFO: renamed from: g */
    public final float f13287g;

    /* JADX INFO: renamed from: h */
    public final float f13288h;

    /* JADX INFO: renamed from: i */
    public final float f13289i;

    public C4970i(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        this.f13281a = f;
        this.f13282b = f4;
        this.f13283c = f7;
        this.f13284d = f2;
        this.f13285e = f5;
        this.f13286f = f8;
        this.f13287g = f3;
        this.f13288h = f6;
        this.f13289i = f9;
    }

    /* JADX INFO: renamed from: a */
    public static C4970i m6954a(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16) {
        C4970i c4970iM6955b = m6955b(f, f2, f3, f4, f5, f6, f7, f8);
        float f17 = c4970iM6955b.f13285e;
        float f18 = c4970iM6955b.f13289i;
        float f19 = c4970iM6955b.f13286f;
        float f20 = c4970iM6955b.f13288h;
        float f21 = (f17 * f18) - (f19 * f20);
        float f22 = c4970iM6955b.f13287g;
        float f23 = c4970iM6955b.f13284d;
        float f24 = (f19 * f22) - (f23 * f18);
        float f25 = (f23 * f20) - (f17 * f22);
        float f26 = c4970iM6955b.f13283c;
        float f27 = c4970iM6955b.f13282b;
        float f28 = (f26 * f20) - (f27 * f18);
        float f29 = c4970iM6955b.f13281a;
        float f30 = (f18 * f29) - (f26 * f22);
        float f31 = (f22 * f27) - (f20 * f29);
        float f32 = (f27 * f19) - (f26 * f17);
        float f33 = (f26 * f23) - (f19 * f29);
        float f34 = (f29 * f17) - (f27 * f23);
        C4970i c4970iM6955b2 = m6955b(f9, f10, f11, f12, f13, f14, f15, f16);
        float f35 = c4970iM6955b2.f13281a;
        float f36 = c4970iM6955b2.f13284d;
        float f37 = c4970iM6955b2.f13287g;
        float f38 = (f36 * f28) + (f35 * f21) + (f37 * f32);
        float f39 = (f37 * f33) + (f36 * f30) + (f35 * f24);
        float f40 = f37 * f34;
        float f41 = f40 + (f36 * f31) + (f35 * f25);
        float f42 = c4970iM6955b2.f13282b;
        float f43 = c4970iM6955b2.f13285e;
        float f44 = c4970iM6955b2.f13288h;
        float f45 = (f44 * f32) + (f43 * f28) + (f42 * f21);
        float f46 = (f44 * f33) + (f43 * f30) + (f42 * f24);
        float f47 = (f43 * f31) + (f42 * f25) + (f44 * f34);
        float f48 = c4970iM6955b2.f13283c;
        float f49 = c4970iM6955b2.f13286f;
        float f50 = f28 * f49;
        float f51 = c4970iM6955b2.f13289i;
        return new C4970i(f38, f39, f41, f45, f46, f47, (f32 * f51) + f50 + (f21 * f48), (f30 * f49) + (f24 * f48) + (f33 * f51), (f51 * f34) + (f49 * f31) + (f48 * f25));
    }

    /* JADX INFO: renamed from: b */
    public static C4970i m6955b(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        float f9 = ((f - f3) + f5) - f7;
        float f10 = ((f2 - f4) + f6) - f8;
        if (f9 == 0.0f && f10 == 0.0f) {
            return new C4970i(f3 - f, f5 - f3, f, f4 - f2, f6 - f4, f2, 0.0f, 0.0f, 1.0f);
        }
        float f11 = f3 - f5;
        float f12 = f7 - f5;
        float f13 = f4 - f6;
        float f14 = f8 - f6;
        float f15 = (f11 * f14) - (f12 * f13);
        float f16 = ((f14 * f9) - (f12 * f10)) / f15;
        float f17 = ((f11 * f10) - (f9 * f13)) / f15;
        return new C4970i((f16 * f3) + (f3 - f), (f17 * f7) + (f7 - f), f, (f16 * f4) + (f4 - f2), (f17 * f8) + (f8 - f2), f2, f16, f17, 1.0f);
    }
}
