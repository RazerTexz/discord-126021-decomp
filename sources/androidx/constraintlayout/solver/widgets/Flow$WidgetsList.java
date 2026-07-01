package androidx.constraintlayout.solver.widgets;

/* JADX INFO: loaded from: classes.dex */
public class Flow$WidgetsList {
    private ConstraintAnchor mBottom;
    private ConstraintAnchor mLeft;
    private int mMax;
    private int mOrientation;
    private int mPaddingBottom;
    private int mPaddingLeft;
    private int mPaddingRight;
    private int mPaddingTop;
    private ConstraintAnchor mRight;
    private ConstraintAnchor mTop;
    public final /* synthetic */ Flow this$0;
    private ConstraintWidget biggest = null;
    public int biggestDimension = 0;
    private int mWidth = 0;
    private int mHeight = 0;
    private int mStartIndex = 0;
    private int mCount = 0;
    private int mNbMatchConstraintsWidgets = 0;

    public Flow$WidgetsList(Flow flow, int i, ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, ConstraintAnchor constraintAnchor3, ConstraintAnchor constraintAnchor4, int i2) {
        this.this$0 = flow;
        this.mOrientation = 0;
        this.mPaddingLeft = 0;
        this.mPaddingTop = 0;
        this.mPaddingRight = 0;
        this.mPaddingBottom = 0;
        this.mMax = 0;
        this.mOrientation = i;
        this.mLeft = constraintAnchor;
        this.mTop = constraintAnchor2;
        this.mRight = constraintAnchor3;
        this.mBottom = constraintAnchor4;
        this.mPaddingLeft = flow.getPaddingLeft();
        this.mPaddingTop = flow.getPaddingTop();
        this.mPaddingRight = flow.getPaddingRight();
        this.mPaddingBottom = flow.getPaddingBottom();
        this.mMax = i2;
    }

    public static /* synthetic */ ConstraintWidget access$2000(Flow$WidgetsList flow$WidgetsList) {
        return flow$WidgetsList.biggest;
    }

    private void recomputeDimensions() {
        this.mWidth = 0;
        this.mHeight = 0;
        this.biggest = null;
        this.biggestDimension = 0;
        int i = this.mCount;
        for (int i2 = 0; i2 < i && this.mStartIndex + i2 < Flow.access$400(this.this$0); i2++) {
            ConstraintWidget constraintWidget = Flow.access$500(this.this$0)[this.mStartIndex + i2];
            if (this.mOrientation == 0) {
                int width = constraintWidget.getWidth();
                int iAccess$000 = Flow.access$000(this.this$0);
                if (constraintWidget.getVisibility() == 8) {
                    iAccess$000 = 0;
                }
                this.mWidth = width + iAccess$000 + this.mWidth;
                int iAccess$300 = Flow.access$300(this.this$0, constraintWidget, this.mMax);
                if (this.biggest == null || this.biggestDimension < iAccess$300) {
                    this.biggest = constraintWidget;
                    this.biggestDimension = iAccess$300;
                    this.mHeight = iAccess$300;
                }
            } else {
                int iAccess$200 = Flow.access$200(this.this$0, constraintWidget, this.mMax);
                int iAccess$301 = Flow.access$300(this.this$0, constraintWidget, this.mMax);
                int iAccess$100 = Flow.access$100(this.this$0);
                if (constraintWidget.getVisibility() == 8) {
                    iAccess$100 = 0;
                }
                this.mHeight = iAccess$301 + iAccess$100 + this.mHeight;
                if (this.biggest == null || this.biggestDimension < iAccess$200) {
                    this.biggest = constraintWidget;
                    this.biggestDimension = iAccess$200;
                    this.mWidth = iAccess$200;
                }
            }
        }
    }

    public void add(ConstraintWidget constraintWidget) {
        if (this.mOrientation == 0) {
            int iAccess$200 = Flow.access$200(this.this$0, constraintWidget, this.mMax);
            if (constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT) {
                this.mNbMatchConstraintsWidgets++;
                iAccess$200 = 0;
            }
            this.mWidth = iAccess$200 + (constraintWidget.getVisibility() != 8 ? Flow.access$000(this.this$0) : 0) + this.mWidth;
            int iAccess$300 = Flow.access$300(this.this$0, constraintWidget, this.mMax);
            if (this.biggest == null || this.biggestDimension < iAccess$300) {
                this.biggest = constraintWidget;
                this.biggestDimension = iAccess$300;
                this.mHeight = iAccess$300;
            }
        } else {
            int iAccess$201 = Flow.access$200(this.this$0, constraintWidget, this.mMax);
            int iAccess$301 = Flow.access$300(this.this$0, constraintWidget, this.mMax);
            if (constraintWidget.getVerticalDimensionBehaviour() == ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT) {
                this.mNbMatchConstraintsWidgets++;
                iAccess$301 = 0;
            }
            this.mHeight = iAccess$301 + (constraintWidget.getVisibility() != 8 ? Flow.access$100(this.this$0) : 0) + this.mHeight;
            if (this.biggest == null || this.biggestDimension < iAccess$201) {
                this.biggest = constraintWidget;
                this.biggestDimension = iAccess$201;
                this.mWidth = iAccess$201;
            }
        }
        this.mCount++;
    }

    public void clear() {
        this.biggestDimension = 0;
        this.biggest = null;
        this.mWidth = 0;
        this.mHeight = 0;
        this.mStartIndex = 0;
        this.mCount = 0;
        this.mNbMatchConstraintsWidgets = 0;
    }

    public void createConstraints(boolean z2, int i, boolean z3) {
        ConstraintWidget constraintWidget;
        int i2 = this.mCount;
        for (int i3 = 0; i3 < i2 && this.mStartIndex + i3 < Flow.access$400(this.this$0); i3++) {
            ConstraintWidget constraintWidget2 = Flow.access$500(this.this$0)[this.mStartIndex + i3];
            if (constraintWidget2 != null) {
                constraintWidget2.resetAnchors();
            }
        }
        if (i2 == 0 || this.biggest == null) {
            return;
        }
        boolean z4 = z3 && i == 0;
        int i4 = -1;
        int i5 = -1;
        for (int i6 = 0; i6 < i2; i6++) {
            int i7 = z2 ? (i2 - 1) - i6 : i6;
            if (this.mStartIndex + i7 >= Flow.access$400(this.this$0)) {
                break;
            }
            if (Flow.access$500(this.this$0)[this.mStartIndex + i7].getVisibility() == 0) {
                if (i4 == -1) {
                    i4 = i6;
                }
                i5 = i6;
            }
        }
        ConstraintWidget constraintWidget3 = null;
        if (this.mOrientation != 0) {
            ConstraintWidget constraintWidget4 = this.biggest;
            constraintWidget4.setHorizontalChainStyle(Flow.access$800(this.this$0));
            int iAccess$000 = this.mPaddingLeft;
            if (i > 0) {
                iAccess$000 += Flow.access$000(this.this$0);
            }
            if (z2) {
                constraintWidget4.mRight.connect(this.mRight, iAccess$000);
                if (z3) {
                    constraintWidget4.mLeft.connect(this.mLeft, this.mPaddingRight);
                }
                if (i > 0) {
                    this.mRight.mOwner.mLeft.connect(constraintWidget4.mRight, 0);
                }
            } else {
                constraintWidget4.mLeft.connect(this.mLeft, iAccess$000);
                if (z3) {
                    constraintWidget4.mRight.connect(this.mRight, this.mPaddingRight);
                }
                if (i > 0) {
                    this.mLeft.mOwner.mRight.connect(constraintWidget4.mLeft, 0);
                }
            }
            int i8 = 0;
            while (i8 < i2 && this.mStartIndex + i8 < Flow.access$400(this.this$0)) {
                ConstraintWidget constraintWidget5 = Flow.access$500(this.this$0)[this.mStartIndex + i8];
                if (i8 == 0) {
                    constraintWidget5.connect(constraintWidget5.mTop, this.mTop, this.mPaddingTop);
                    int iAccess$600 = Flow.access$600(this.this$0);
                    float fAccess$1400 = Flow.access$1400(this.this$0);
                    if (this.mStartIndex == 0 && Flow.access$1500(this.this$0) != -1) {
                        iAccess$600 = Flow.access$1500(this.this$0);
                        fAccess$1400 = Flow.access$1600(this.this$0);
                    } else if (z3 && Flow.access$1700(this.this$0) != -1) {
                        iAccess$600 = Flow.access$1700(this.this$0);
                        fAccess$1400 = Flow.access$1800(this.this$0);
                    }
                    constraintWidget5.setVerticalChainStyle(iAccess$600);
                    constraintWidget5.setVerticalBiasPercent(fAccess$1400);
                }
                if (i8 == i2 - 1) {
                    constraintWidget5.connect(constraintWidget5.mBottom, this.mBottom, this.mPaddingBottom);
                }
                if (constraintWidget3 != null) {
                    constraintWidget5.mTop.connect(constraintWidget3.mBottom, Flow.access$100(this.this$0));
                    if (i8 == i4) {
                        constraintWidget5.mTop.setGoneMargin(this.mPaddingTop);
                    }
                    constraintWidget3.mBottom.connect(constraintWidget5.mTop, 0);
                    if (i8 == i5 + 1) {
                        constraintWidget3.mBottom.setGoneMargin(this.mPaddingBottom);
                    }
                }
                if (constraintWidget5 != constraintWidget4) {
                    if (z2) {
                        int iAccess$1900 = Flow.access$1900(this.this$0);
                        if (iAccess$1900 == 0) {
                            constraintWidget5.mRight.connect(constraintWidget4.mRight, 0);
                        } else if (iAccess$1900 == 1) {
                            constraintWidget5.mLeft.connect(constraintWidget4.mLeft, 0);
                        } else if (iAccess$1900 == 2) {
                            constraintWidget5.mLeft.connect(constraintWidget4.mLeft, 0);
                            constraintWidget5.mRight.connect(constraintWidget4.mRight, 0);
                        }
                    } else {
                        int iAccess$1901 = Flow.access$1900(this.this$0);
                        if (iAccess$1901 == 0) {
                            constraintWidget5.mLeft.connect(constraintWidget4.mLeft, 0);
                        } else if (iAccess$1901 == 1) {
                            constraintWidget5.mRight.connect(constraintWidget4.mRight, 0);
                        } else if (iAccess$1901 == 2) {
                            if (z4) {
                                constraintWidget5.mLeft.connect(this.mLeft, this.mPaddingLeft);
                                constraintWidget5.mRight.connect(this.mRight, this.mPaddingRight);
                            } else {
                                constraintWidget5.mLeft.connect(constraintWidget4.mLeft, 0);
                                constraintWidget5.mRight.connect(constraintWidget4.mRight, 0);
                            }
                        }
                    }
                }
                i8++;
                constraintWidget3 = constraintWidget5;
            }
            return;
        }
        ConstraintWidget constraintWidget6 = this.biggest;
        constraintWidget6.setVerticalChainStyle(Flow.access$600(this.this$0));
        int iAccess$100 = this.mPaddingTop;
        if (i > 0) {
            iAccess$100 += Flow.access$100(this.this$0);
        }
        constraintWidget6.mTop.connect(this.mTop, iAccess$100);
        if (z3) {
            constraintWidget6.mBottom.connect(this.mBottom, this.mPaddingBottom);
        }
        if (i > 0) {
            this.mTop.mOwner.mBottom.connect(constraintWidget6.mTop, 0);
        }
        if (Flow.access$700(this.this$0) != 3 || constraintWidget6.hasBaseline()) {
            constraintWidget = constraintWidget6;
            break;
        }
        int i9 = 0;
        while (true) {
            if (i9 < i2) {
                int i10 = z2 ? (i2 - 1) - i9 : i9;
                if (this.mStartIndex + i10 < Flow.access$400(this.this$0)) {
                    constraintWidget = Flow.access$500(this.this$0)[this.mStartIndex + i10];
                    if (constraintWidget.hasBaseline()) {
                        break;
                    } else {
                        i9++;
                    }
                }
            }
            constraintWidget = constraintWidget6;
            break;
        }
        int i11 = 0;
        while (i11 < i2) {
            int i12 = z2 ? (i2 - 1) - i11 : i11;
            if (this.mStartIndex + i12 >= Flow.access$400(this.this$0)) {
                return;
            }
            ConstraintWidget constraintWidget7 = Flow.access$500(this.this$0)[this.mStartIndex + i12];
            if (i11 == 0) {
                constraintWidget7.connect(constraintWidget7.mLeft, this.mLeft, this.mPaddingLeft);
            }
            if (i12 == 0) {
                int iAccess$800 = Flow.access$800(this.this$0);
                float fAccess$900 = Flow.access$900(this.this$0);
                if (this.mStartIndex == 0 && Flow.access$1000(this.this$0) != -1) {
                    iAccess$800 = Flow.access$1000(this.this$0);
                    fAccess$900 = Flow.access$1100(this.this$0);
                } else if (z3 && Flow.access$1200(this.this$0) != -1) {
                    iAccess$800 = Flow.access$1200(this.this$0);
                    fAccess$900 = Flow.access$1300(this.this$0);
                }
                constraintWidget7.setHorizontalChainStyle(iAccess$800);
                constraintWidget7.setHorizontalBiasPercent(fAccess$900);
            }
            if (i11 == i2 - 1) {
                constraintWidget7.connect(constraintWidget7.mRight, this.mRight, this.mPaddingRight);
            }
            if (constraintWidget3 != null) {
                constraintWidget7.mLeft.connect(constraintWidget3.mRight, Flow.access$000(this.this$0));
                if (i11 == i4) {
                    constraintWidget7.mLeft.setGoneMargin(this.mPaddingLeft);
                }
                constraintWidget3.mRight.connect(constraintWidget7.mLeft, 0);
                if (i11 == i5 + 1) {
                    constraintWidget3.mRight.setGoneMargin(this.mPaddingRight);
                }
            }
            if (constraintWidget7 != constraintWidget6) {
                if (Flow.access$700(this.this$0) == 3 && constraintWidget.hasBaseline() && constraintWidget7 != constraintWidget && constraintWidget7.hasBaseline()) {
                    constraintWidget7.mBaseline.connect(constraintWidget.mBaseline, 0);
                } else {
                    int iAccess$700 = Flow.access$700(this.this$0);
                    if (iAccess$700 == 0) {
                        constraintWidget7.mTop.connect(constraintWidget6.mTop, 0);
                    } else if (iAccess$700 == 1) {
                        constraintWidget7.mBottom.connect(constraintWidget6.mBottom, 0);
                    } else if (z4) {
                        constraintWidget7.mTop.connect(this.mTop, this.mPaddingTop);
                        constraintWidget7.mBottom.connect(this.mBottom, this.mPaddingBottom);
                    } else {
                        constraintWidget7.mTop.connect(constraintWidget6.mTop, 0);
                        constraintWidget7.mBottom.connect(constraintWidget6.mBottom, 0);
                    }
                }
            }
            i11++;
            constraintWidget3 = constraintWidget7;
        }
    }

    public int getHeight() {
        return this.mOrientation == 1 ? this.mHeight - Flow.access$100(this.this$0) : this.mHeight;
    }

    public int getWidth() {
        return this.mOrientation == 0 ? this.mWidth - Flow.access$000(this.this$0) : this.mWidth;
    }

    public void measureMatchConstraints(int i) {
        int i2 = this.mNbMatchConstraintsWidgets;
        if (i2 == 0) {
            return;
        }
        int i3 = this.mCount;
        int i4 = i / i2;
        for (int i5 = 0; i5 < i3 && this.mStartIndex + i5 < Flow.access$400(this.this$0); i5++) {
            ConstraintWidget constraintWidget = Flow.access$500(this.this$0)[this.mStartIndex + i5];
            if (this.mOrientation == 0) {
                if (constraintWidget != null && constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.mMatchConstraintDefaultWidth == 0) {
                    this.this$0.measure(constraintWidget, ConstraintWidget$DimensionBehaviour.FIXED, i4, constraintWidget.getVerticalDimensionBehaviour(), constraintWidget.getHeight());
                }
            } else if (constraintWidget != null && constraintWidget.getVerticalDimensionBehaviour() == ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.mMatchConstraintDefaultHeight == 0) {
                this.this$0.measure(constraintWidget, constraintWidget.getHorizontalDimensionBehaviour(), constraintWidget.getWidth(), ConstraintWidget$DimensionBehaviour.FIXED, i4);
            }
        }
        recomputeDimensions();
    }

    public void setStartIndex(int i) {
        this.mStartIndex = i;
    }

    public void setup(int i, ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, ConstraintAnchor constraintAnchor3, ConstraintAnchor constraintAnchor4, int i2, int i3, int i4, int i5, int i6) {
        this.mOrientation = i;
        this.mLeft = constraintAnchor;
        this.mTop = constraintAnchor2;
        this.mRight = constraintAnchor3;
        this.mBottom = constraintAnchor4;
        this.mPaddingLeft = i2;
        this.mPaddingTop = i3;
        this.mPaddingRight = i4;
        this.mPaddingBottom = i5;
        this.mMax = i6;
    }
}
