package b.o.b.d;

import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: b.o.b.d.a, reason: use source file name */
/* JADX INFO: compiled from: GlProgram.kt */
/* JADX INFO: loaded from: classes3.dex */
public class GlProgram {
    public final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f1964b;
    public final GlShader2[] c;
    public boolean d;

    public GlProgram(int i, boolean z2, GlShader2... glShader2Arr) {
        Intrinsics3.checkNotNullParameter(glShader2Arr, "shaders");
        this.a = i;
        this.f1964b = z2;
        this.c = glShader2Arr;
    }
}
