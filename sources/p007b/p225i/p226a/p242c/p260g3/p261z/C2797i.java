package p007b.p225i.p226a.p242c.p260g3.p261z;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.GlUtil;
import java.nio.FloatBuffer;

/* JADX INFO: renamed from: b.i.a.c.g3.z.i */
/* JADX INFO: compiled from: ProjectionRenderer.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2797i {

    /* JADX INFO: renamed from: a */
    public static final String[] f6988a = {"uniform mat4 uMvpMatrix;", "uniform mat3 uTexMatrix;", "attribute vec4 aPosition;", "attribute vec2 aTexCoords;", "varying vec2 vTexCoords;", "void main() {", "  gl_Position = uMvpMatrix * aPosition;", "  vTexCoords = (uTexMatrix * vec3(aTexCoords, 1)).xy;", "}"};

    /* JADX INFO: renamed from: b */
    public static final String[] f6989b = {"#extension GL_OES_EGL_image_external : require", "precision mediump float;", "uniform samplerExternalOES uTexture;", "varying vec2 vTexCoords;", "void main() {", "  gl_FragColor = texture2D(uTexture, vTexCoords);", "}"};

    /* JADX INFO: renamed from: c */
    public static final float[] f6990c = {1.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 1.0f, 1.0f};

    /* JADX INFO: renamed from: d */
    public static final float[] f6991d = {1.0f, 0.0f, 0.0f, 0.0f, -0.5f, 0.0f, 0.0f, 0.5f, 1.0f};

    /* JADX INFO: renamed from: e */
    public static final float[] f6992e = {1.0f, 0.0f, 0.0f, 0.0f, -0.5f, 0.0f, 0.0f, 1.0f, 1.0f};

    /* JADX INFO: renamed from: f */
    public static final float[] f6993f = {0.5f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 1.0f, 1.0f};

    /* JADX INFO: renamed from: g */
    public static final float[] f6994g = {0.5f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.5f, 1.0f, 1.0f};

    /* JADX INFO: renamed from: h */
    public int f6995h;

    /* JADX INFO: renamed from: i */
    @Nullable
    public a f6996i;

    /* JADX INFO: renamed from: j */
    @Nullable
    public a f6997j;

    /* JADX INFO: renamed from: k */
    public GlUtil.C10776a f6998k;

    /* JADX INFO: renamed from: l */
    public int f6999l;

    /* JADX INFO: renamed from: m */
    public int f7000m;

    /* JADX INFO: renamed from: n */
    public int f7001n;

    /* JADX INFO: renamed from: o */
    public int f7002o;

    /* JADX INFO: renamed from: p */
    public int f7003p;

    /* JADX INFO: renamed from: b.i.a.c.g3.z.i$a */
    /* JADX INFO: compiled from: ProjectionRenderer.java */
    public static class a {

        /* JADX INFO: renamed from: a */
        public final int f7004a;

        /* JADX INFO: renamed from: b */
        public final FloatBuffer f7005b;

        /* JADX INFO: renamed from: c */
        public final FloatBuffer f7006c;

        /* JADX INFO: renamed from: d */
        public final int f7007d;

        public a(C2796h.b bVar) {
            float[] fArr = bVar.f6986c;
            this.f7004a = fArr.length / 3;
            this.f7005b = GlUtil.m8946b(fArr);
            this.f7006c = GlUtil.m8946b(bVar.f6987d);
            int i = bVar.f6985b;
            if (i == 1) {
                this.f7007d = 5;
            } else if (i != 2) {
                this.f7007d = 4;
            } else {
                this.f7007d = 6;
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public static boolean m3200a(C2796h c2796h) {
        C2796h.a aVar = c2796h.f6979a;
        C2796h.a aVar2 = c2796h.f6980b;
        C2796h.b[] bVarArr = aVar.f6983a;
        if (bVarArr.length == 1 && bVarArr[0].f6984a == 0) {
            C2796h.b[] bVarArr2 = aVar2.f6983a;
            if (bVarArr2.length == 1 && bVarArr2[0].f6984a == 0) {
                return true;
            }
        }
        return false;
    }
}
