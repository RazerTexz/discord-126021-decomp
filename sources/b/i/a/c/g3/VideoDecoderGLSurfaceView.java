package b.i.a.c.g3;

import android.content.Context;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import androidx.work.Data;
import b.i.a.c.v2.VideoDecoderOutputBuffer;
import com.google.android.exoplayer2.util.GlUtil;
import java.nio.Buffer;
import java.nio.FloatBuffer;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* JADX INFO: renamed from: b.i.a.c.g3.s, reason: use source file name */
/* JADX INFO: compiled from: VideoDecoderGLSurfaceView.java */
/* JADX INFO: loaded from: classes3.dex */
public final class VideoDecoderGLSurfaceView extends GLSurfaceView implements VideoDecoderOutputBufferRenderer {
    public final a j;

    /* JADX INFO: renamed from: b.i.a.c.g3.s$a */
    /* JADX INFO: compiled from: VideoDecoderGLSurfaceView.java */
    public static final class a implements GLSurfaceView.Renderer {
        public static final float[] j = {1.164f, 1.164f, 1.164f, 0.0f, -0.392f, 2.017f, 1.596f, -0.813f, 0.0f};
        public static final float[] k = {1.164f, 1.164f, 1.164f, 0.0f, -0.213f, 2.112f, 1.793f, -0.533f, 0.0f};
        public static final float[] l = {1.168f, 1.168f, 1.168f, 0.0f, -0.188f, 2.148f, 1.683f, -0.652f, 0.0f};
        public static final String[] m = {"y_tex", "u_tex", "v_tex"};
        public static final FloatBuffer n = GlUtil.b(new float[]{-1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f, -1.0f});
        public final GLSurfaceView o;
        public final int[] p = new int[3];
        public final int[] q = new int[3];
        public final int[] r = new int[3];

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public final int[] f991s = new int[3];
        public final AtomicReference<VideoDecoderOutputBuffer> t = new AtomicReference<>();
        public final FloatBuffer[] u = new FloatBuffer[3];
        public GlUtil.a v;
        public int w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public VideoDecoderOutputBuffer f992x;

        public a(GLSurfaceView gLSurfaceView) {
            this.o = gLSurfaceView;
            for (int i = 0; i < 3; i++) {
                int[] iArr = this.r;
                this.f991s[i] = -1;
                iArr[i] = -1;
            }
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl10) {
            VideoDecoderOutputBuffer andSet = this.t.getAndSet(null);
            if (andSet == null && this.f992x == null) {
                return;
            }
            if (andSet != null) {
                VideoDecoderOutputBuffer videoDecoderOutputBuffer = this.f992x;
                if (videoDecoderOutputBuffer != null) {
                    Objects.requireNonNull(videoDecoderOutputBuffer);
                    throw null;
                }
                this.f992x = andSet;
            }
            Objects.requireNonNull(this.f992x);
            GLES20.glUniformMatrix3fv(this.w, 1, false, k, 0);
            Objects.requireNonNull(null);
            throw null;
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl10, int i, int i2) {
            GLES20.glViewport(0, 0, i, i2);
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            GlUtil.a aVar = new GlUtil.a("varying vec2 interp_tc_y;\nvarying vec2 interp_tc_u;\nvarying vec2 interp_tc_v;\nattribute vec4 in_pos;\nattribute vec2 in_tc_y;\nattribute vec2 in_tc_u;\nattribute vec2 in_tc_v;\nvoid main() {\n  gl_Position = in_pos;\n  interp_tc_y = in_tc_y;\n  interp_tc_u = in_tc_u;\n  interp_tc_v = in_tc_v;\n}\n", "precision mediump float;\nvarying vec2 interp_tc_y;\nvarying vec2 interp_tc_u;\nvarying vec2 interp_tc_v;\nuniform sampler2D y_tex;\nuniform sampler2D u_tex;\nuniform sampler2D v_tex;\nuniform mat3 mColorConversion;\nvoid main() {\n  vec3 yuv;\n  yuv.x = texture2D(y_tex, interp_tc_y).r - 0.0625;\n  yuv.y = texture2D(u_tex, interp_tc_u).r - 0.5;\n  yuv.z = texture2D(v_tex, interp_tc_v).r - 0.5;\n  gl_FragColor = vec4(mColorConversion * yuv, 1.0);\n}\n");
            this.v = aVar;
            aVar.c();
            int iGlGetAttribLocation = GLES20.glGetAttribLocation(this.v.a, "in_pos");
            GLES20.glEnableVertexAttribArray(iGlGetAttribLocation);
            GLES20.glVertexAttribPointer(iGlGetAttribLocation, 2, 5126, false, 0, (Buffer) n);
            this.q[0] = GLES20.glGetAttribLocation(this.v.a, "in_tc_y");
            GLES20.glEnableVertexAttribArray(this.q[0]);
            this.q[1] = GLES20.glGetAttribLocation(this.v.a, "in_tc_u");
            GLES20.glEnableVertexAttribArray(this.q[1]);
            this.q[2] = GLES20.glGetAttribLocation(this.v.a, "in_tc_v");
            GLES20.glEnableVertexAttribArray(this.q[2]);
            GlUtil.a();
            this.w = GLES20.glGetUniformLocation(this.v.a, "mColorConversion");
            GlUtil.a();
            GLES20.glGenTextures(3, this.p, 0);
            for (int i = 0; i < 3; i++) {
                GLES20.glUniform1i(this.v.b(m[i]), i);
                GLES20.glActiveTexture(33984 + i);
                GLES20.glBindTexture(3553, this.p[i]);
                GLES20.glTexParameterf(3553, 10241, 9729.0f);
                GLES20.glTexParameterf(3553, Data.MAX_DATA_BYTES, 9729.0f);
                GLES20.glTexParameterf(3553, 10242, 33071.0f);
                GLES20.glTexParameterf(3553, 10243, 33071.0f);
            }
            GlUtil.a();
            GlUtil.a();
        }
    }

    public VideoDecoderGLSurfaceView(Context context) {
        super(context, null);
        a aVar = new a(this);
        this.j = aVar;
        setPreserveEGLContextOnPause(true);
        setEGLContextClientVersion(2);
        setRenderer(aVar);
        setRenderMode(0);
    }

    @Deprecated
    public VideoDecoderOutputBufferRenderer getVideoDecoderOutputBufferRenderer() {
        return this;
    }

    public void setOutputBuffer(VideoDecoderOutputBuffer videoDecoderOutputBuffer) {
        a aVar = this.j;
        if (aVar.t.getAndSet(videoDecoderOutputBuffer) != null) {
            throw null;
        }
        aVar.o.requestRender();
    }
}
