package b.i.a.c.g3.z;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.GlUtil$a;

/* JADX INFO: compiled from: ProjectionRenderer.java */
/* JADX INFO: loaded from: classes3.dex */
public final class i {
    public static final String[] a = {"uniform mat4 uMvpMatrix;", "uniform mat3 uTexMatrix;", "attribute vec4 aPosition;", "attribute vec2 aTexCoords;", "varying vec2 vTexCoords;", "void main() {", "  gl_Position = uMvpMatrix * aPosition;", "  vTexCoords = (uTexMatrix * vec3(aTexCoords, 1)).xy;", "}"};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String[] f1002b = {"#extension GL_OES_EGL_image_external : require", "precision mediump float;", "uniform samplerExternalOES uTexture;", "varying vec2 vTexCoords;", "void main() {", "  gl_FragColor = texture2D(uTexture, vTexCoords);", "}"};
    public static final float[] c = {1.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 1.0f, 1.0f};
    public static final float[] d = {1.0f, 0.0f, 0.0f, 0.0f, -0.5f, 0.0f, 0.0f, 0.5f, 1.0f};
    public static final float[] e = {1.0f, 0.0f, 0.0f, 0.0f, -0.5f, 0.0f, 0.0f, 1.0f, 1.0f};
    public static final float[] f = {0.5f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 1.0f, 1.0f};
    public static final float[] g = {0.5f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.5f, 1.0f, 1.0f};
    public int h;

    @Nullable
    public i$a i;

    @Nullable
    public i$a j;
    public GlUtil$a k;
    public int l;
    public int m;
    public int n;
    public int o;
    public int p;

    public static boolean a(h hVar) {
        h$a h_a = hVar.a;
        h$a h_a2 = hVar.f1000b;
        h$b[] h_bArr = h_a.a;
        if (h_bArr.length == 1 && h_bArr[0].a == 0) {
            h$b[] h_bArr2 = h_a2.a;
            if (h_bArr2.length == 1 && h_bArr2[0].a == 0) {
                return true;
            }
        }
        return false;
    }
}
