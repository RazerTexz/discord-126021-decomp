package org.webrtc;

import android.opengl.GLES20;
import androidx.annotation.Nullable;
import b.d.b.a.a;
import java.nio.Buffer;
import java.nio.FloatBuffer;

/* JADX INFO: loaded from: classes3.dex */
public class GlGenericDrawer implements RendererCommon$GlDrawer {
    private static final String DEFAULT_VERTEX_SHADER_STRING = "varying vec2 tc;\nattribute vec4 in_pos;\nattribute vec4 in_tc;\nuniform mat4 tex_mat;\nvoid main() {\n  gl_Position = in_pos;\n  tc = (tex_mat * in_tc).xy;\n}\n";
    private static final FloatBuffer FULL_RECTANGLE_BUFFER = GlUtil.createFloatBuffer(new float[]{-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f});
    private static final FloatBuffer FULL_RECTANGLE_TEXTURE_BUFFER = GlUtil.createFloatBuffer(new float[]{0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f});
    private static final String INPUT_TEXTURE_COORDINATE_NAME = "in_tc";
    private static final String INPUT_VERTEX_COORDINATE_NAME = "in_pos";
    private static final String TEXTURE_MATRIX_NAME = "tex_mat";

    @Nullable
    private GlShader currentShader;

    @Nullable
    private GlGenericDrawer$ShaderType currentShaderType;
    private final String genericFragmentSource;
    private int inPosLocation;
    private int inTcLocation;
    private final GlGenericDrawer$ShaderCallbacks shaderCallbacks;
    private int texMatrixLocation;
    private final String vertexShader;

    public GlGenericDrawer(String str, GlGenericDrawer$ShaderCallbacks glGenericDrawer$ShaderCallbacks) {
        this(DEFAULT_VERTEX_SHADER_STRING, str, glGenericDrawer$ShaderCallbacks);
    }

    public static String createFragmentShaderString(String str, GlGenericDrawer$ShaderType glGenericDrawer$ShaderType) {
        StringBuilder sb = new StringBuilder();
        GlGenericDrawer$ShaderType glGenericDrawer$ShaderType2 = GlGenericDrawer$ShaderType.OES;
        if (glGenericDrawer$ShaderType == glGenericDrawer$ShaderType2) {
            sb.append("#extension GL_OES_EGL_image_external : require\n");
        }
        sb.append("precision mediump float;\n");
        sb.append("varying vec2 tc;\n");
        if (glGenericDrawer$ShaderType == GlGenericDrawer$ShaderType.YUV) {
            a.s0(sb, "uniform sampler2D y_tex;\n", "uniform sampler2D u_tex;\n", "uniform sampler2D v_tex;\n", "vec4 sample(vec2 p) {\n");
            a.s0(sb, "  float y = texture2D(y_tex, p).r * 1.16438;\n", "  float u = texture2D(u_tex, p).r;\n", "  float v = texture2D(v_tex, p).r;\n", "  return vec4(y + 1.59603 * v - 0.874202,\n");
            a.s0(sb, "    y - 0.391762 * u - 0.812968 * v + 0.531668,\n", "    y + 2.01723 * u - 1.08563, 1);\n", "}\n", str);
        } else {
            String str2 = glGenericDrawer$ShaderType == glGenericDrawer$ShaderType2 ? "samplerExternalOES" : "sampler2D";
            sb.append("uniform ");
            sb.append(str2);
            sb.append(" tex;\n");
            sb.append(str.replace("sample(", "texture2D(tex, "));
        }
        return sb.toString();
    }

    private void prepareShader(GlGenericDrawer$ShaderType glGenericDrawer$ShaderType, float[] fArr, int i, int i2, int i3, int i4) {
        GlShader glShader;
        if (glGenericDrawer$ShaderType.equals(this.currentShaderType)) {
            glShader = this.currentShader;
        } else {
            this.currentShaderType = null;
            GlShader glShader2 = this.currentShader;
            if (glShader2 != null) {
                glShader2.release();
                this.currentShader = null;
            }
            GlShader glShaderCreateShader = createShader(glGenericDrawer$ShaderType);
            this.currentShaderType = glGenericDrawer$ShaderType;
            this.currentShader = glShaderCreateShader;
            glShaderCreateShader.useProgram();
            if (glGenericDrawer$ShaderType == GlGenericDrawer$ShaderType.YUV) {
                GLES20.glUniform1i(glShaderCreateShader.getUniformLocation("y_tex"), 0);
                GLES20.glUniform1i(glShaderCreateShader.getUniformLocation("u_tex"), 1);
                GLES20.glUniform1i(glShaderCreateShader.getUniformLocation("v_tex"), 2);
            } else {
                GLES20.glUniform1i(glShaderCreateShader.getUniformLocation("tex"), 0);
            }
            GlUtil.checkNoGLES2Error("Create shader");
            this.shaderCallbacks.onNewShader(glShaderCreateShader);
            this.texMatrixLocation = glShaderCreateShader.getUniformLocation(TEXTURE_MATRIX_NAME);
            this.inPosLocation = glShaderCreateShader.getAttribLocation(INPUT_VERTEX_COORDINATE_NAME);
            this.inTcLocation = glShaderCreateShader.getAttribLocation(INPUT_TEXTURE_COORDINATE_NAME);
            glShader = glShaderCreateShader;
        }
        glShader.useProgram();
        GLES20.glEnableVertexAttribArray(this.inPosLocation);
        GLES20.glVertexAttribPointer(this.inPosLocation, 2, 5126, false, 0, (Buffer) FULL_RECTANGLE_BUFFER);
        GLES20.glEnableVertexAttribArray(this.inTcLocation);
        GLES20.glVertexAttribPointer(this.inTcLocation, 2, 5126, false, 0, (Buffer) FULL_RECTANGLE_TEXTURE_BUFFER);
        GLES20.glUniformMatrix4fv(this.texMatrixLocation, 1, false, fArr, 0);
        this.shaderCallbacks.onPrepareShader(glShader, fArr, i, i2, i3, i4);
        GlUtil.checkNoGLES2Error("Prepare shader");
    }

    public GlShader createShader(GlGenericDrawer$ShaderType glGenericDrawer$ShaderType) {
        return new GlShader(this.vertexShader, createFragmentShaderString(this.genericFragmentSource, glGenericDrawer$ShaderType));
    }

    @Override // org.webrtc.RendererCommon$GlDrawer
    public void drawOes(int i, float[] fArr, int i2, int i3, int i4, int i5, int i6, int i7) {
        prepareShader(GlGenericDrawer$ShaderType.OES, fArr, i2, i3, i6, i7);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, i);
        GLES20.glViewport(i4, i5, i6, i7);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glBindTexture(36197, 0);
    }

    @Override // org.webrtc.RendererCommon$GlDrawer
    public void drawRgb(int i, float[] fArr, int i2, int i3, int i4, int i5, int i6, int i7) {
        prepareShader(GlGenericDrawer$ShaderType.RGB, fArr, i2, i3, i6, i7);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, i);
        GLES20.glViewport(i4, i5, i6, i7);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glBindTexture(3553, 0);
    }

    @Override // org.webrtc.RendererCommon$GlDrawer
    public void drawYuv(int[] iArr, float[] fArr, int i, int i2, int i3, int i4, int i5, int i6) {
        prepareShader(GlGenericDrawer$ShaderType.YUV, fArr, i, i2, i5, i6);
        for (int i7 = 0; i7 < 3; i7++) {
            GLES20.glActiveTexture(33984 + i7);
            GLES20.glBindTexture(3553, iArr[i7]);
        }
        GLES20.glViewport(i3, i4, i5, i6);
        GLES20.glDrawArrays(5, 0, 4);
        for (int i8 = 0; i8 < 3; i8++) {
            GLES20.glActiveTexture(i8 + 33984);
            GLES20.glBindTexture(3553, 0);
        }
    }

    @Override // org.webrtc.RendererCommon$GlDrawer
    public void release() {
        GlShader glShader = this.currentShader;
        if (glShader != null) {
            glShader.release();
            this.currentShader = null;
            this.currentShaderType = null;
        }
    }

    public GlGenericDrawer(String str, String str2, GlGenericDrawer$ShaderCallbacks glGenericDrawer$ShaderCallbacks) {
        this.vertexShader = str;
        this.genericFragmentSource = str2;
        this.shaderCallbacks = glGenericDrawer$ShaderCallbacks;
    }
}
