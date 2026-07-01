package b.i.a.c.g3.z;

import androidx.annotation.Nullable;
import b.i.a.c.g3.z.Projection;
import com.google.android.exoplayer2.util.GlUtil;
import java.nio.FloatBuffer;

/* JADX INFO: renamed from: b.i.a.c.g3.z.i, reason: use source file name */
/* JADX INFO: compiled from: ProjectionRenderer.java */
/* JADX INFO: loaded from: classes3.dex */
public final class ProjectionRenderer {
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
    public a i;

    @Nullable
    public a j;
    public GlUtil.a k;
    public int l;
    public int m;
    public int n;
    public int o;
    public int p;

    /* JADX INFO: renamed from: b.i.a.c.g3.z.i$a */
    /* JADX INFO: compiled from: ProjectionRenderer.java */
    public static class a {
        public final int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final FloatBuffer f1003b;
        public final FloatBuffer c;
        public final int d;

        public a(Projection.b bVar) {
            float[] fArr = bVar.c;
            this.a = fArr.length / 3;
            this.f1003b = GlUtil.b(fArr);
            this.c = GlUtil.b(bVar.d);
            int i = bVar.f1001b;
            if (i == 1) {
                this.d = 5;
            } else if (i != 2) {
                this.d = 4;
            } else {
                this.d = 6;
            }
        }
    }

    public static boolean a(Projection projection) {
        Projection.a aVar = projection.a;
        Projection.a aVar2 = projection.f1000b;
        Projection.b[] bVarArr = aVar.a;
        if (bVarArr.length == 1 && bVarArr[0].a == 0) {
            Projection.b[] bVarArr2 = aVar2.a;
            if (bVarArr2.length == 1 && bVarArr2[0].a == 0) {
                return true;
            }
        }
        return false;
    }
}
