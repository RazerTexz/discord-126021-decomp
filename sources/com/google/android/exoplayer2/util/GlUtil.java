package com.google.android.exoplayer2.util;

import android.opengl.GLES20;
import android.opengl.GLU;
import android.text.TextUtils;
import android.util.Log;
import b.d.b.a.outline;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* JADX INFO: loaded from: classes3.dex */
public final class GlUtil {

    public static final class GlException extends RuntimeException {
    }

    public static final class UnsupportedEglVersionException extends Exception {
    }

    public static void a() {
        int i = 0;
        while (true) {
            int iGlGetError = GLES20.glGetError();
            if (iGlGetError == 0) {
                break;
            }
            String strValueOf = String.valueOf(GLU.gluErrorString(iGlGetError));
            Log.e("GlUtil", strValueOf.length() != 0 ? "glError ".concat(strValueOf) : new String("glError "));
            i = iGlGetError;
        }
        if (i != 0) {
            String strValueOf2 = String.valueOf(GLU.gluErrorString(i));
            Log.e("GlUtil", strValueOf2.length() != 0 ? "glError ".concat(strValueOf2) : new String("glError "));
        }
    }

    public static FloatBuffer b(float[] fArr) {
        return (FloatBuffer) ByteBuffer.allocateDirect(fArr.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer().put(fArr).flip();
    }

    public static final class a {
        public final int a;

        public a(String str, String str2) {
            this.a = GLES20.glCreateProgram();
            GlUtil.a();
            a(35633, str);
            a(35632, str2);
        }

        public final void a(int i, String str) {
            int iGlCreateShader = GLES20.glCreateShader(i);
            GLES20.glShaderSource(iGlCreateShader, str);
            GLES20.glCompileShader(iGlCreateShader);
            int[] iArr = {0};
            GLES20.glGetShaderiv(iGlCreateShader, 35713, iArr, 0);
            if (iArr[0] != 1) {
                String strGlGetShaderInfoLog = GLES20.glGetShaderInfoLog(iGlCreateShader);
                StringBuilder sb = new StringBuilder(outline.b(str, outline.b(strGlGetShaderInfoLog, 10)));
                sb.append(strGlGetShaderInfoLog);
                sb.append(", source: ");
                sb.append(str);
                Log.e("GlUtil", sb.toString());
            }
            GLES20.glAttachShader(this.a, iGlCreateShader);
            GLES20.glDeleteShader(iGlCreateShader);
            GlUtil.a();
        }

        public int b(String str) {
            return GLES20.glGetUniformLocation(this.a, str);
        }

        public void c() {
            GLES20.glLinkProgram(this.a);
            int[] iArr = {0};
            GLES20.glGetProgramiv(this.a, 35714, iArr, 0);
            if (iArr[0] != 1) {
                String strValueOf = String.valueOf(GLES20.glGetProgramInfoLog(this.a));
                Log.e("GlUtil", strValueOf.length() != 0 ? "Unable to link shader program: \n".concat(strValueOf) : new String("Unable to link shader program: \n"));
            }
            GlUtil.a();
            GLES20.glUseProgram(this.a);
        }

        public a(String[] strArr, String[] strArr2) {
            String strJoin = TextUtils.join("\n", strArr);
            String strJoin2 = TextUtils.join("\n", strArr2);
            this.a = GLES20.glCreateProgram();
            GlUtil.a();
            a(35633, strJoin);
            a(35632, strJoin2);
        }
    }
}
