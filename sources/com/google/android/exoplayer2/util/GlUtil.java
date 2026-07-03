package com.google.android.exoplayer2.util;

import android.opengl.GLES20;
import android.opengl.GLU;
import android.text.TextUtils;
import android.util.Log;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: loaded from: classes3.dex */
public final class GlUtil {

    public static final class GlException extends RuntimeException {
    }

    public static final class UnsupportedEglVersionException extends Exception {
    }

    /* JADX INFO: renamed from: a */
    public static void m8945a() {
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

    /* JADX INFO: renamed from: b */
    public static FloatBuffer m8946b(float[] fArr) {
        return (FloatBuffer) ByteBuffer.allocateDirect(fArr.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer().put(fArr).flip();
    }

    /* JADX INFO: renamed from: com.google.android.exoplayer2.util.GlUtil$a */
    public static final class C10776a {

        /* JADX INFO: renamed from: a */
        public final int f20280a;

        public C10776a(String str, String str2) {
            this.f20280a = GLES20.glCreateProgram();
            GlUtil.m8945a();
            m8947a(35633, str);
            m8947a(35632, str2);
        }

        /* JADX INFO: renamed from: a */
        public final void m8947a(int i, String str) {
            int iGlCreateShader = GLES20.glCreateShader(i);
            GLES20.glShaderSource(iGlCreateShader, str);
            GLES20.glCompileShader(iGlCreateShader);
            int[] iArr = {0};
            GLES20.glGetShaderiv(iGlCreateShader, 35713, iArr, 0);
            if (iArr[0] != 1) {
                String strGlGetShaderInfoLog = GLES20.glGetShaderInfoLog(iGlCreateShader);
                StringBuilder sb = new StringBuilder(C1643a.m841b(str, C1643a.m841b(strGlGetShaderInfoLog, 10)));
                sb.append(strGlGetShaderInfoLog);
                sb.append(", source: ");
                sb.append(str);
                Log.e("GlUtil", sb.toString());
            }
            GLES20.glAttachShader(this.f20280a, iGlCreateShader);
            GLES20.glDeleteShader(iGlCreateShader);
            GlUtil.m8945a();
        }

        /* JADX INFO: renamed from: b */
        public int m8948b(String str) {
            return GLES20.glGetUniformLocation(this.f20280a, str);
        }

        /* JADX INFO: renamed from: c */
        public void m8949c() {
            GLES20.glLinkProgram(this.f20280a);
            int[] iArr = {0};
            GLES20.glGetProgramiv(this.f20280a, 35714, iArr, 0);
            if (iArr[0] != 1) {
                String strValueOf = String.valueOf(GLES20.glGetProgramInfoLog(this.f20280a));
                Log.e("GlUtil", strValueOf.length() != 0 ? "Unable to link shader program: \n".concat(strValueOf) : new String("Unable to link shader program: \n"));
            }
            GlUtil.m8945a();
            GLES20.glUseProgram(this.f20280a);
        }

        public C10776a(String[] strArr, String[] strArr2) {
            String strJoin = TextUtils.join("\n", strArr);
            String strJoin2 = TextUtils.join("\n", strArr2);
            this.f20280a = GLES20.glCreateProgram();
            GlUtil.m8945a();
            m8947a(35633, strJoin);
            m8947a(35632, strJoin2);
        }
    }
}
