package androidx.constraintlayout.utils.widget;

import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes.dex */
public class ImageFilterView$ImageMatrix {
    public float[] m = new float[20];
    public ColorMatrix mColorMatrix = new ColorMatrix();
    public ColorMatrix mTmpColorMatrix = new ColorMatrix();
    public float mBrightness = 1.0f;
    public float mSaturation = 1.0f;
    public float mContrast = 1.0f;
    public float mWarmth = 1.0f;

    private void brightness(float f) {
        float[] fArr = this.m;
        fArr[0] = f;
        fArr[1] = 0.0f;
        fArr[2] = 0.0f;
        fArr[3] = 0.0f;
        fArr[4] = 0.0f;
        fArr[5] = 0.0f;
        fArr[6] = f;
        fArr[7] = 0.0f;
        fArr[8] = 0.0f;
        fArr[9] = 0.0f;
        fArr[10] = 0.0f;
        fArr[11] = 0.0f;
        fArr[12] = f;
        fArr[13] = 0.0f;
        fArr[14] = 0.0f;
        fArr[15] = 0.0f;
        fArr[16] = 0.0f;
        fArr[17] = 0.0f;
        fArr[18] = 1.0f;
        fArr[19] = 0.0f;
    }

    private void saturation(float f) {
        float f2 = 1.0f - f;
        float f3 = 0.2999f * f2;
        float f4 = 0.587f * f2;
        float f5 = f2 * 0.114f;
        float[] fArr = this.m;
        fArr[0] = f3 + f;
        fArr[1] = f4;
        fArr[2] = f5;
        fArr[3] = 0.0f;
        fArr[4] = 0.0f;
        fArr[5] = f3;
        fArr[6] = f4 + f;
        fArr[7] = f5;
        fArr[8] = 0.0f;
        fArr[9] = 0.0f;
        fArr[10] = f3;
        fArr[11] = f4;
        fArr[12] = f5 + f;
        fArr[13] = 0.0f;
        fArr[14] = 0.0f;
        fArr[15] = 0.0f;
        fArr[16] = 0.0f;
        fArr[17] = 0.0f;
        fArr[18] = 1.0f;
        fArr[19] = 0.0f;
    }

    private void warmth(float f) {
        float fLog;
        float fPow;
        float fLog2;
        if (f <= 0.0f) {
            f = 0.01f;
        }
        float f2 = (5000.0f / f) / 100.0f;
        if (f2 > 66.0f) {
            double d = f2 - 60.0f;
            fPow = ((float) Math.pow(d, -0.13320475816726685d)) * 329.69873f;
            fLog = ((float) Math.pow(d, 0.07551484555006027d)) * 288.12216f;
        } else {
            fLog = (((float) Math.log(f2)) * 99.4708f) - 161.11957f;
            fPow = 255.0f;
        }
        if (f2 < 66.0f) {
            fLog2 = f2 > 19.0f ? (((float) Math.log(f2 - 10.0f)) * 138.51773f) - 305.0448f : 0.0f;
        } else {
            fLog2 = 255.0f;
        }
        float fMin = Math.min(255.0f, Math.max(fPow, 0.0f));
        float fMin2 = Math.min(255.0f, Math.max(fLog, 0.0f));
        float fMin3 = Math.min(255.0f, Math.max(fLog2, 0.0f));
        float fLog3 = (((float) Math.log(50.0f)) * 99.4708f) - 161.11957f;
        float fLog4 = (((float) Math.log(40.0f)) * 138.51773f) - 305.0448f;
        float fMin4 = Math.min(255.0f, Math.max(255.0f, 0.0f));
        float fMin5 = Math.min(255.0f, Math.max(fLog3, 0.0f));
        float fMin6 = fMin3 / Math.min(255.0f, Math.max(fLog4, 0.0f));
        float[] fArr = this.m;
        fArr[0] = fMin / fMin4;
        fArr[1] = 0.0f;
        fArr[2] = 0.0f;
        fArr[3] = 0.0f;
        fArr[4] = 0.0f;
        fArr[5] = 0.0f;
        fArr[6] = fMin2 / fMin5;
        fArr[7] = 0.0f;
        fArr[8] = 0.0f;
        fArr[9] = 0.0f;
        fArr[10] = 0.0f;
        fArr[11] = 0.0f;
        fArr[12] = fMin6;
        fArr[13] = 0.0f;
        fArr[14] = 0.0f;
        fArr[15] = 0.0f;
        fArr[16] = 0.0f;
        fArr[17] = 0.0f;
        fArr[18] = 1.0f;
        fArr[19] = 0.0f;
    }

    public void updateMatrix(ImageView imageView) {
        boolean z2;
        this.mColorMatrix.reset();
        float f = this.mSaturation;
        boolean z3 = true;
        if (f != 1.0f) {
            saturation(f);
            this.mColorMatrix.set(this.m);
            z2 = true;
        } else {
            z2 = false;
        }
        float f2 = this.mContrast;
        if (f2 != 1.0f) {
            this.mTmpColorMatrix.setScale(f2, f2, f2, 1.0f);
            this.mColorMatrix.postConcat(this.mTmpColorMatrix);
            z2 = true;
        }
        float f3 = this.mWarmth;
        if (f3 != 1.0f) {
            warmth(f3);
            this.mTmpColorMatrix.set(this.m);
            this.mColorMatrix.postConcat(this.mTmpColorMatrix);
            z2 = true;
        }
        float f4 = this.mBrightness;
        if (f4 != 1.0f) {
            brightness(f4);
            this.mTmpColorMatrix.set(this.m);
            this.mColorMatrix.postConcat(this.mTmpColorMatrix);
        } else {
            z3 = z2;
        }
        if (z3) {
            imageView.setColorFilter(new ColorMatrixColorFilter(this.mColorMatrix));
        } else {
            imageView.clearColorFilter();
        }
    }
}
