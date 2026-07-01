package b.o.b.d;

import android.opengl.GLES20;
import android.util.Log;
import d0.p;
import d0.z.d.m;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: GlProgramLocation.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b {
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f1965b;
    public final int c;

    public b(int i, b$a b_a, String str, DefaultConstructorMarker defaultConstructorMarker) {
        int iGlGetAttribLocation;
        this.a = str;
        int iOrdinal = b_a.ordinal();
        if (iOrdinal == 0) {
            iGlGetAttribLocation = GLES20.glGetAttribLocation(p.m105constructorimpl(i), str);
        } else {
            if (iOrdinal != 1) {
                throw new NoWhenBranchMatchedException();
            }
            iGlGetAttribLocation = GLES20.glGetUniformLocation(p.m105constructorimpl(i), str);
        }
        this.f1965b = iGlGetAttribLocation;
        float[] fArr = b.o.b.a.d.a;
        m.checkNotNullParameter(str, "label");
        if (iGlGetAttribLocation >= 0) {
            this.c = p.m105constructorimpl(iGlGetAttribLocation);
            return;
        }
        String str2 = "Unable to locate " + str + " in program";
        Log.e("Egloo", str2);
        throw new RuntimeException(str2);
    }
}
