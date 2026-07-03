package p007b.p225i.p226a.p242c.p260g3;

import android.content.Context;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import androidx.work.Data;
import com.google.android.exoplayer2.util.GlUtil;
import java.nio.Buffer;
import java.nio.FloatBuffer;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import p007b.p225i.p226a.p242c.p265v2.C2961i;

/* JADX INFO: renamed from: b.i.a.c.g3.s */
/* JADX INFO: compiled from: VideoDecoderGLSurfaceView.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2782s extends GLSurfaceView implements InterfaceC2783t {

    /* JADX INFO: renamed from: j */
    public final a f6910j;

    /* JADX INFO: renamed from: b.i.a.c.g3.s$a */
    /* JADX INFO: compiled from: VideoDecoderGLSurfaceView.java */
    public static final class a implements GLSurfaceView.Renderer {

        /* JADX INFO: renamed from: j */
        public static final float[] f6911j = {1.164f, 1.164f, 1.164f, 0.0f, -0.392f, 2.017f, 1.596f, -0.813f, 0.0f};

        /* JADX INFO: renamed from: k */
        public static final float[] f6912k = {1.164f, 1.164f, 1.164f, 0.0f, -0.213f, 2.112f, 1.793f, -0.533f, 0.0f};

        /* JADX INFO: renamed from: l */
        public static final float[] f6913l = {1.168f, 1.168f, 1.168f, 0.0f, -0.188f, 2.148f, 1.683f, -0.652f, 0.0f};

        /* JADX INFO: renamed from: m */
        public static final String[] f6914m = {"y_tex", "u_tex", "v_tex"};

        /* JADX INFO: renamed from: n */
        public static final FloatBuffer f6915n = GlUtil.m8946b(new float[]{-1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f, -1.0f});

        /* JADX INFO: renamed from: o */
        public final GLSurfaceView f6916o;

        /* JADX INFO: renamed from: p */
        public final int[] f6917p = new int[3];

        /* JADX INFO: renamed from: q */
        public final int[] f6918q = new int[3];

        /* JADX INFO: renamed from: r */
        public final int[] f6919r = new int[3];

        /* JADX INFO: renamed from: s */
        public final int[] f6920s = new int[3];

        /* JADX INFO: renamed from: t */
        public final AtomicReference<C2961i> f6921t = new AtomicReference<>();

        /* JADX INFO: renamed from: u */
        public final FloatBuffer[] f6922u = new FloatBuffer[3];

        /* JADX INFO: renamed from: v */
        public GlUtil.C10776a f6923v;

        /* JADX INFO: renamed from: w */
        public int f6924w;

        /* JADX INFO: renamed from: x */
        public C2961i f6925x;

        public a(GLSurfaceView gLSurfaceView) {
            this.f6916o = gLSurfaceView;
            for (int i = 0; i < 3; i++) {
                int[] iArr = this.f6919r;
                this.f6920s[i] = -1;
                iArr[i] = -1;
            }
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl10) {
            C2961i andSet = this.f6921t.getAndSet(null);
            if (andSet == null && this.f6925x == null) {
                return;
            }
            if (andSet != null) {
                C2961i c2961i = this.f6925x;
                if (c2961i != null) {
                    Objects.requireNonNull(c2961i);
                    throw null;
                }
                this.f6925x = andSet;
            }
            Objects.requireNonNull(this.f6925x);
            GLES20.glUniformMatrix3fv(this.f6924w, 1, false, f6912k, 0);
            Objects.requireNonNull(null);
            throw null;
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl10, int i, int i2) {
            GLES20.glViewport(0, 0, i, i2);
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            GlUtil.C10776a c10776a = new GlUtil.C10776a("varying vec2 interp_tc_y;\nvarying vec2 interp_tc_u;\nvarying vec2 interp_tc_v;\nattribute vec4 in_pos;\nattribute vec2 in_tc_y;\nattribute vec2 in_tc_u;\nattribute vec2 in_tc_v;\nvoid main() {\n  gl_Position = in_pos;\n  interp_tc_y = in_tc_y;\n  interp_tc_u = in_tc_u;\n  interp_tc_v = in_tc_v;\n}\n", "precision mediump float;\nvarying vec2 interp_tc_y;\nvarying vec2 interp_tc_u;\nvarying vec2 interp_tc_v;\nuniform sampler2D y_tex;\nuniform sampler2D u_tex;\nuniform sampler2D v_tex;\nuniform mat3 mColorConversion;\nvoid main() {\n  vec3 yuv;\n  yuv.x = texture2D(y_tex, interp_tc_y).r - 0.0625;\n  yuv.y = texture2D(u_tex, interp_tc_u).r - 0.5;\n  yuv.z = texture2D(v_tex, interp_tc_v).r - 0.5;\n  gl_FragColor = vec4(mColorConversion * yuv, 1.0);\n}\n");
            this.f6923v = c10776a;
            c10776a.m8949c();
            int iGlGetAttribLocation = GLES20.glGetAttribLocation(this.f6923v.f20280a, "in_pos");
            GLES20.glEnableVertexAttribArray(iGlGetAttribLocation);
            GLES20.glVertexAttribPointer(iGlGetAttribLocation, 2, 5126, false, 0, (Buffer) f6915n);
            this.f6918q[0] = GLES20.glGetAttribLocation(this.f6923v.f20280a, "in_tc_y");
            GLES20.glEnableVertexAttribArray(this.f6918q[0]);
            this.f6918q[1] = GLES20.glGetAttribLocation(this.f6923v.f20280a, "in_tc_u");
            GLES20.glEnableVertexAttribArray(this.f6918q[1]);
            this.f6918q[2] = GLES20.glGetAttribLocation(this.f6923v.f20280a, "in_tc_v");
            GLES20.glEnableVertexAttribArray(this.f6918q[2]);
            GlUtil.m8945a();
            this.f6924w = GLES20.glGetUniformLocation(this.f6923v.f20280a, "mColorConversion");
            GlUtil.m8945a();
            GLES20.glGenTextures(3, this.f6917p, 0);
            for (int i = 0; i < 3; i++) {
                GLES20.glUniform1i(this.f6923v.m8948b(f6914m[i]), i);
                GLES20.glActiveTexture(33984 + i);
                GLES20.glBindTexture(3553, this.f6917p[i]);
                GLES20.glTexParameterf(3553, 10241, 9729.0f);
                GLES20.glTexParameterf(3553, Data.MAX_DATA_BYTES, 9729.0f);
                GLES20.glTexParameterf(3553, 10242, 33071.0f);
                GLES20.glTexParameterf(3553, 10243, 33071.0f);
            }
            GlUtil.m8945a();
            GlUtil.m8945a();
        }
    }

    public C2782s(Context context) {
        super(context, null);
        a aVar = new a(this);
        this.f6910j = aVar;
        setPreserveEGLContextOnPause(true);
        setEGLContextClientVersion(2);
        setRenderer(aVar);
        setRenderMode(0);
    }

    @Deprecated
    public InterfaceC2783t getVideoDecoderOutputBufferRenderer() {
        return this;
    }

    public void setOutputBuffer(C2961i c2961i) {
        a aVar = this.f6910j;
        if (aVar.f6921t.getAndSet(c2961i) != null) {
            throw null;
        }
        aVar.f6916o.requestRender();
    }
}
