package b.i.a.f.h.l;

import java.nio.charset.Charset;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class p5 implements p6 {
    public static final z5 a = new s5();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final z5 f1478b;

    public p5() {
        z5 z5Var;
        z5[] z5VarArr = new z5[2];
        z5VarArr[0] = v4.a;
        try {
            z5Var = (z5) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            z5Var = a;
        }
        z5VarArr[1] = z5Var;
        r5 r5Var = new r5(z5VarArr);
        Charset charset = w4.a;
        this.f1478b = r5Var;
    }
}
