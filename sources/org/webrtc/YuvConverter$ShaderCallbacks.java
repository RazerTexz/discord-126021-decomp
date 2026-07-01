package org.webrtc;

import android.opengl.GLES20;

/* JADX INFO: loaded from: classes3.dex */
public class YuvConverter$ShaderCallbacks implements GlGenericDrawer$ShaderCallbacks {
    private float[] coeffs;
    private int coeffsLoc;
    private float stepSize;
    private int xUnitLoc;
    private static final float[] yCoeffs = {0.256788f, 0.504129f, 0.0979059f, 0.0627451f};
    private static final float[] uCoeffs = {-0.148223f, -0.290993f, 0.439216f, 0.501961f};
    private static final float[] vCoeffs = {0.439216f, -0.367788f, -0.0714274f, 0.501961f};

    private YuvConverter$ShaderCallbacks() {
    }

    @Override // org.webrtc.GlGenericDrawer$ShaderCallbacks
    public void onNewShader(GlShader glShader) {
        this.xUnitLoc = glShader.getUniformLocation("xUnit");
        this.coeffsLoc = glShader.getUniformLocation("coeffs");
    }

    @Override // org.webrtc.GlGenericDrawer$ShaderCallbacks
    public void onPrepareShader(GlShader glShader, float[] fArr, int i, int i2, int i3, int i4) {
        GLES20.glUniform4fv(this.coeffsLoc, 1, this.coeffs, 0);
        int i5 = this.xUnitLoc;
        float f = this.stepSize;
        float f2 = i;
        GLES20.glUniform2f(i5, (fArr[0] * f) / f2, (f * fArr[1]) / f2);
    }

    public void setPlaneU() {
        this.coeffs = uCoeffs;
        this.stepSize = 2.0f;
    }

    public void setPlaneV() {
        this.coeffs = vCoeffs;
        this.stepSize = 2.0f;
    }

    public void setPlaneY() {
        this.coeffs = yCoeffs;
        this.stepSize = 1.0f;
    }

    public /* synthetic */ YuvConverter$ShaderCallbacks(YuvConverter$1 yuvConverter$1) {
        this();
    }
}
