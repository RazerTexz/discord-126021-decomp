package androidx.constraintlayout.motion.utils;

/* JADX INFO: loaded from: classes.dex */
public class ArcCurveFit extends CurveFit {
    public static final int ARC_START_FLIP = 3;
    public static final int ARC_START_HORIZONTAL = 2;
    public static final int ARC_START_LINEAR = 0;
    public static final int ARC_START_VERTICAL = 1;
    private static final int START_HORIZONTAL = 2;
    private static final int START_LINEAR = 3;
    private static final int START_VERTICAL = 1;
    public ArcCurveFit$Arc[] mArcs;
    private final double[] mTime;

    public ArcCurveFit(int[] iArr, double[] dArr, double[][] dArr2) {
        this.mTime = dArr;
        this.mArcs = new ArcCurveFit$Arc[dArr.length - 1];
        int i = 0;
        int i2 = 1;
        int i3 = 1;
        while (true) {
            ArcCurveFit$Arc[] arcCurveFit$ArcArr = this.mArcs;
            if (i >= arcCurveFit$ArcArr.length) {
                return;
            }
            int i4 = iArr[i];
            if (i4 == 0) {
                i3 = 3;
            } else if (i4 == 1) {
                i2 = 1;
                i3 = 1;
            } else if (i4 == 2) {
                i2 = 2;
                i3 = 2;
            } else if (i4 == 3) {
                i2 = i2 == 1 ? 2 : 1;
                i3 = i2;
            }
            int i5 = i + 1;
            arcCurveFit$ArcArr[i] = new ArcCurveFit$Arc(i3, dArr[i], dArr[i5], dArr2[i][0], dArr2[i][1], dArr2[i5][0], dArr2[i5][1]);
            i = i5;
        }
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public void getPos(double d, double[] dArr) {
        ArcCurveFit$Arc[] arcCurveFit$ArcArr = this.mArcs;
        if (d < arcCurveFit$ArcArr[0].mTime1) {
            d = arcCurveFit$ArcArr[0].mTime1;
        }
        if (d > arcCurveFit$ArcArr[arcCurveFit$ArcArr.length - 1].mTime2) {
            d = arcCurveFit$ArcArr[arcCurveFit$ArcArr.length - 1].mTime2;
        }
        int i = 0;
        while (true) {
            ArcCurveFit$Arc[] arcCurveFit$ArcArr2 = this.mArcs;
            if (i >= arcCurveFit$ArcArr2.length) {
                return;
            }
            if (d <= arcCurveFit$ArcArr2[i].mTime2) {
                if (arcCurveFit$ArcArr2[i].linear) {
                    dArr[0] = arcCurveFit$ArcArr2[i].getLinearX(d);
                    dArr[1] = this.mArcs[i].getLinearY(d);
                    return;
                } else {
                    arcCurveFit$ArcArr2[i].setPoint(d);
                    dArr[0] = this.mArcs[i].getX();
                    dArr[1] = this.mArcs[i].getY();
                    return;
                }
            }
            i++;
        }
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public void getSlope(double d, double[] dArr) {
        ArcCurveFit$Arc[] arcCurveFit$ArcArr = this.mArcs;
        if (d < arcCurveFit$ArcArr[0].mTime1) {
            d = arcCurveFit$ArcArr[0].mTime1;
        } else if (d > arcCurveFit$ArcArr[arcCurveFit$ArcArr.length - 1].mTime2) {
            d = arcCurveFit$ArcArr[arcCurveFit$ArcArr.length - 1].mTime2;
        }
        int i = 0;
        while (true) {
            ArcCurveFit$Arc[] arcCurveFit$ArcArr2 = this.mArcs;
            if (i >= arcCurveFit$ArcArr2.length) {
                return;
            }
            if (d <= arcCurveFit$ArcArr2[i].mTime2) {
                if (arcCurveFit$ArcArr2[i].linear) {
                    dArr[0] = arcCurveFit$ArcArr2[i].getLinearDX(d);
                    dArr[1] = this.mArcs[i].getLinearDY(d);
                    return;
                } else {
                    arcCurveFit$ArcArr2[i].setPoint(d);
                    dArr[0] = this.mArcs[i].getDX();
                    dArr[1] = this.mArcs[i].getDY();
                    return;
                }
            }
            i++;
        }
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public double[] getTimePoints() {
        return this.mTime;
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public void getPos(double d, float[] fArr) {
        ArcCurveFit$Arc[] arcCurveFit$ArcArr = this.mArcs;
        if (d < arcCurveFit$ArcArr[0].mTime1) {
            d = arcCurveFit$ArcArr[0].mTime1;
        } else if (d > arcCurveFit$ArcArr[arcCurveFit$ArcArr.length - 1].mTime2) {
            d = arcCurveFit$ArcArr[arcCurveFit$ArcArr.length - 1].mTime2;
        }
        int i = 0;
        while (true) {
            ArcCurveFit$Arc[] arcCurveFit$ArcArr2 = this.mArcs;
            if (i >= arcCurveFit$ArcArr2.length) {
                return;
            }
            if (d <= arcCurveFit$ArcArr2[i].mTime2) {
                if (arcCurveFit$ArcArr2[i].linear) {
                    fArr[0] = (float) arcCurveFit$ArcArr2[i].getLinearX(d);
                    fArr[1] = (float) this.mArcs[i].getLinearY(d);
                    return;
                } else {
                    arcCurveFit$ArcArr2[i].setPoint(d);
                    fArr[0] = (float) this.mArcs[i].getX();
                    fArr[1] = (float) this.mArcs[i].getY();
                    return;
                }
            }
            i++;
        }
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public double getSlope(double d, int i) {
        ArcCurveFit$Arc[] arcCurveFit$ArcArr = this.mArcs;
        int i2 = 0;
        if (d < arcCurveFit$ArcArr[0].mTime1) {
            d = arcCurveFit$ArcArr[0].mTime1;
        }
        if (d > arcCurveFit$ArcArr[arcCurveFit$ArcArr.length - 1].mTime2) {
            d = arcCurveFit$ArcArr[arcCurveFit$ArcArr.length - 1].mTime2;
        }
        while (true) {
            ArcCurveFit$Arc[] arcCurveFit$ArcArr2 = this.mArcs;
            if (i2 >= arcCurveFit$ArcArr2.length) {
                return Double.NaN;
            }
            if (d <= arcCurveFit$ArcArr2[i2].mTime2) {
                if (arcCurveFit$ArcArr2[i2].linear) {
                    if (i == 0) {
                        return arcCurveFit$ArcArr2[i2].getLinearDX(d);
                    }
                    return arcCurveFit$ArcArr2[i2].getLinearDY(d);
                }
                arcCurveFit$ArcArr2[i2].setPoint(d);
                if (i == 0) {
                    return this.mArcs[i2].getDX();
                }
                return this.mArcs[i2].getDY();
            }
            i2++;
        }
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public double getPos(double d, int i) {
        ArcCurveFit$Arc[] arcCurveFit$ArcArr = this.mArcs;
        int i2 = 0;
        if (d < arcCurveFit$ArcArr[0].mTime1) {
            d = arcCurveFit$ArcArr[0].mTime1;
        } else if (d > arcCurveFit$ArcArr[arcCurveFit$ArcArr.length - 1].mTime2) {
            d = arcCurveFit$ArcArr[arcCurveFit$ArcArr.length - 1].mTime2;
        }
        while (true) {
            ArcCurveFit$Arc[] arcCurveFit$ArcArr2 = this.mArcs;
            if (i2 >= arcCurveFit$ArcArr2.length) {
                return Double.NaN;
            }
            if (d <= arcCurveFit$ArcArr2[i2].mTime2) {
                if (arcCurveFit$ArcArr2[i2].linear) {
                    if (i == 0) {
                        return arcCurveFit$ArcArr2[i2].getLinearX(d);
                    }
                    return arcCurveFit$ArcArr2[i2].getLinearY(d);
                }
                arcCurveFit$ArcArr2[i2].setPoint(d);
                if (i == 0) {
                    return this.mArcs[i2].getX();
                }
                return this.mArcs[i2].getY();
            }
            i2++;
        }
    }
}
