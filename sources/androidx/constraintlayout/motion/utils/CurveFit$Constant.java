package androidx.constraintlayout.motion.utils;

/* JADX INFO: loaded from: classes.dex */
public class CurveFit$Constant extends CurveFit {
    public double mTime;
    public double[] mValue;

    public CurveFit$Constant(double d, double[] dArr) {
        this.mTime = d;
        this.mValue = dArr;
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public void getPos(double d, double[] dArr) {
        double[] dArr2 = this.mValue;
        System.arraycopy(dArr2, 0, dArr, 0, dArr2.length);
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public double getSlope(double d, int i) {
        return 0.0d;
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public void getSlope(double d, double[] dArr) {
        for (int i = 0; i < this.mValue.length; i++) {
            dArr[i] = 0.0d;
        }
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public double[] getTimePoints() {
        return new double[]{this.mTime};
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public void getPos(double d, float[] fArr) {
        int i = 0;
        while (true) {
            double[] dArr = this.mValue;
            if (i >= dArr.length) {
                return;
            }
            fArr[i] = (float) dArr[i];
            i++;
        }
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public double getPos(double d, int i) {
        return this.mValue[i];
    }
}
