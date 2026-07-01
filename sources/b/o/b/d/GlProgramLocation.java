package b.o.b.d;

import android.opengl.GLES20;
import android.util.Log;
import b.o.b.a.Egloo;
import d0.UInt;
import d0.z.d.Intrinsics3;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: b.o.b.d.b, reason: use source file name */
/* JADX INFO: compiled from: GlProgramLocation.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class GlProgramLocation {
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f1965b;
    public final int c;

    /* JADX INFO: renamed from: b.o.b.d.b$a */
    /* JADX INFO: compiled from: GlProgramLocation.kt */
    public enum a {
        ATTRIB,
        UNIFORM
    }

    public GlProgramLocation(int i, a aVar, String str, DefaultConstructorMarker defaultConstructorMarker) {
        int iGlGetAttribLocation;
        this.a = str;
        int iOrdinal = aVar.ordinal();
        if (iOrdinal == 0) {
            iGlGetAttribLocation = GLES20.glGetAttribLocation(UInt.m105constructorimpl(i), str);
        } else {
            if (iOrdinal != 1) {
                throw new NoWhenBranchMatchedException();
            }
            iGlGetAttribLocation = GLES20.glGetUniformLocation(UInt.m105constructorimpl(i), str);
        }
        this.f1965b = iGlGetAttribLocation;
        float[] fArr = Egloo.a;
        Intrinsics3.checkNotNullParameter(str, "label");
        if (iGlGetAttribLocation >= 0) {
            this.c = UInt.m105constructorimpl(iGlGetAttribLocation);
            return;
        }
        String str2 = "Unable to locate " + str + " in program";
        Log.e("Egloo", str2);
        throw new RuntimeException(str2);
    }
}
