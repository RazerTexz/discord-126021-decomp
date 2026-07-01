package androidx.constraintlayout.widget;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup$MarginLayoutParams;
import b.d.b.a.a;

/* JADX INFO: loaded from: classes.dex */
public class ConstraintProperties {
    public static final int BASELINE = 5;
    public static final int BOTTOM = 4;
    public static final int END = 7;
    public static final int LEFT = 1;
    public static final int MATCH_CONSTRAINT = 0;
    public static final int MATCH_CONSTRAINT_SPREAD = 0;
    public static final int MATCH_CONSTRAINT_WRAP = 1;
    public static final int PARENT_ID = 0;
    public static final int RIGHT = 2;
    public static final int START = 6;
    public static final int TOP = 3;
    public static final int UNSET = -1;
    public static final int WRAP_CONTENT = -2;
    public ConstraintLayout$LayoutParams mParams;
    public View mView;

    public ConstraintProperties(View view) {
        ViewGroup$LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof ConstraintLayout$LayoutParams)) {
            throw new RuntimeException("Only children of ConstraintLayout.LayoutParams supported");
        }
        this.mParams = (ConstraintLayout$LayoutParams) layoutParams;
        this.mView = view;
    }

    private String sideToString(int i) {
        switch (i) {
            case 1:
                return "left";
            case 2:
                return "right";
            case 3:
                return "top";
            case 4:
                return "bottom";
            case 5:
                return "baseline";
            case 6:
                return "start";
            case 7:
                return "end";
            default:
                return "undefined";
        }
    }

    public ConstraintProperties addToHorizontalChain(int i, int i2) {
        connect(1, i, i == 0 ? 1 : 2, 0);
        connect(2, i2, i2 == 0 ? 2 : 1, 0);
        if (i != 0) {
            new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(i)).connect(2, this.mView.getId(), 1, 0);
        }
        if (i2 != 0) {
            new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(i2)).connect(1, this.mView.getId(), 2, 0);
        }
        return this;
    }

    public ConstraintProperties addToHorizontalChainRTL(int i, int i2) {
        connect(6, i, i == 0 ? 6 : 7, 0);
        connect(7, i2, i2 == 0 ? 7 : 6, 0);
        if (i != 0) {
            new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(i)).connect(7, this.mView.getId(), 6, 0);
        }
        if (i2 != 0) {
            new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(i2)).connect(6, this.mView.getId(), 7, 0);
        }
        return this;
    }

    public ConstraintProperties addToVerticalChain(int i, int i2) {
        connect(3, i, i == 0 ? 3 : 4, 0);
        connect(4, i2, i2 == 0 ? 4 : 3, 0);
        if (i != 0) {
            new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(i)).connect(4, this.mView.getId(), 3, 0);
        }
        if (i2 != 0) {
            new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(i2)).connect(3, this.mView.getId(), 4, 0);
        }
        return this;
    }

    public ConstraintProperties alpha(float f) {
        this.mView.setAlpha(f);
        return this;
    }

    public void apply() {
    }

    public ConstraintProperties center(int i, int i2, int i3, int i4, int i5, int i6, float f) {
        if (i3 < 0) {
            throw new IllegalArgumentException("margin must be > 0");
        }
        if (i6 < 0) {
            throw new IllegalArgumentException("margin must be > 0");
        }
        if (f <= 0.0f || f > 1.0f) {
            throw new IllegalArgumentException("bias must be between 0 and 1 inclusive");
        }
        if (i2 == 1 || i2 == 2) {
            connect(1, i, i2, i3);
            connect(2, i4, i5, i6);
            this.mParams.horizontalBias = f;
        } else if (i2 == 6 || i2 == 7) {
            connect(6, i, i2, i3);
            connect(7, i4, i5, i6);
            this.mParams.horizontalBias = f;
        } else {
            connect(3, i, i2, i3);
            connect(4, i4, i5, i6);
            this.mParams.verticalBias = f;
        }
        return this;
    }

    public ConstraintProperties centerHorizontally(int i, int i2, int i3, int i4, int i5, int i6, float f) {
        connect(1, i, i2, i3);
        connect(2, i4, i5, i6);
        this.mParams.horizontalBias = f;
        return this;
    }

    public ConstraintProperties centerHorizontallyRtl(int i, int i2, int i3, int i4, int i5, int i6, float f) {
        connect(6, i, i2, i3);
        connect(7, i4, i5, i6);
        this.mParams.horizontalBias = f;
        return this;
    }

    public ConstraintProperties centerVertically(int i, int i2, int i3, int i4, int i5, int i6, float f) {
        connect(3, i, i2, i3);
        connect(4, i4, i5, i6);
        this.mParams.verticalBias = f;
        return this;
    }

    public ConstraintProperties connect(int i, int i2, int i3, int i4) {
        switch (i) {
            case 1:
                if (i3 == 1) {
                    ConstraintLayout$LayoutParams constraintLayout$LayoutParams = this.mParams;
                    constraintLayout$LayoutParams.leftToLeft = i2;
                    constraintLayout$LayoutParams.leftToRight = -1;
                } else {
                    if (i3 != 2) {
                        throw new IllegalArgumentException(a.J(a.U("Left to "), sideToString(i3), " undefined"));
                    }
                    ConstraintLayout$LayoutParams constraintLayout$LayoutParams2 = this.mParams;
                    constraintLayout$LayoutParams2.leftToRight = i2;
                    constraintLayout$LayoutParams2.leftToLeft = -1;
                }
                ((ViewGroup$MarginLayoutParams) this.mParams).leftMargin = i4;
                return this;
            case 2:
                if (i3 == 1) {
                    ConstraintLayout$LayoutParams constraintLayout$LayoutParams3 = this.mParams;
                    constraintLayout$LayoutParams3.rightToLeft = i2;
                    constraintLayout$LayoutParams3.rightToRight = -1;
                } else {
                    if (i3 != 2) {
                        throw new IllegalArgumentException(a.J(a.U("right to "), sideToString(i3), " undefined"));
                    }
                    ConstraintLayout$LayoutParams constraintLayout$LayoutParams4 = this.mParams;
                    constraintLayout$LayoutParams4.rightToRight = i2;
                    constraintLayout$LayoutParams4.rightToLeft = -1;
                }
                ((ViewGroup$MarginLayoutParams) this.mParams).rightMargin = i4;
                return this;
            case 3:
                if (i3 == 3) {
                    ConstraintLayout$LayoutParams constraintLayout$LayoutParams5 = this.mParams;
                    constraintLayout$LayoutParams5.topToTop = i2;
                    constraintLayout$LayoutParams5.topToBottom = -1;
                    constraintLayout$LayoutParams5.baselineToBaseline = -1;
                } else {
                    if (i3 != 4) {
                        throw new IllegalArgumentException(a.J(a.U("right to "), sideToString(i3), " undefined"));
                    }
                    ConstraintLayout$LayoutParams constraintLayout$LayoutParams6 = this.mParams;
                    constraintLayout$LayoutParams6.topToBottom = i2;
                    constraintLayout$LayoutParams6.topToTop = -1;
                    constraintLayout$LayoutParams6.baselineToBaseline = -1;
                }
                ((ViewGroup$MarginLayoutParams) this.mParams).topMargin = i4;
                return this;
            case 4:
                if (i3 == 4) {
                    ConstraintLayout$LayoutParams constraintLayout$LayoutParams7 = this.mParams;
                    constraintLayout$LayoutParams7.bottomToBottom = i2;
                    constraintLayout$LayoutParams7.bottomToTop = -1;
                    constraintLayout$LayoutParams7.baselineToBaseline = -1;
                } else {
                    if (i3 != 3) {
                        throw new IllegalArgumentException(a.J(a.U("right to "), sideToString(i3), " undefined"));
                    }
                    ConstraintLayout$LayoutParams constraintLayout$LayoutParams8 = this.mParams;
                    constraintLayout$LayoutParams8.bottomToTop = i2;
                    constraintLayout$LayoutParams8.bottomToBottom = -1;
                    constraintLayout$LayoutParams8.baselineToBaseline = -1;
                }
                ((ViewGroup$MarginLayoutParams) this.mParams).bottomMargin = i4;
                return this;
            case 5:
                if (i3 != 5) {
                    throw new IllegalArgumentException(a.J(a.U("right to "), sideToString(i3), " undefined"));
                }
                ConstraintLayout$LayoutParams constraintLayout$LayoutParams9 = this.mParams;
                constraintLayout$LayoutParams9.baselineToBaseline = i2;
                constraintLayout$LayoutParams9.bottomToBottom = -1;
                constraintLayout$LayoutParams9.bottomToTop = -1;
                constraintLayout$LayoutParams9.topToTop = -1;
                constraintLayout$LayoutParams9.topToBottom = -1;
                return this;
            case 6:
                if (i3 == 6) {
                    ConstraintLayout$LayoutParams constraintLayout$LayoutParams10 = this.mParams;
                    constraintLayout$LayoutParams10.startToStart = i2;
                    constraintLayout$LayoutParams10.startToEnd = -1;
                } else {
                    if (i3 != 7) {
                        throw new IllegalArgumentException(a.J(a.U("right to "), sideToString(i3), " undefined"));
                    }
                    ConstraintLayout$LayoutParams constraintLayout$LayoutParams11 = this.mParams;
                    constraintLayout$LayoutParams11.startToEnd = i2;
                    constraintLayout$LayoutParams11.startToStart = -1;
                }
                this.mParams.setMarginStart(i4);
                return this;
            case 7:
                if (i3 == 7) {
                    ConstraintLayout$LayoutParams constraintLayout$LayoutParams12 = this.mParams;
                    constraintLayout$LayoutParams12.endToEnd = i2;
                    constraintLayout$LayoutParams12.endToStart = -1;
                } else {
                    if (i3 != 6) {
                        throw new IllegalArgumentException(a.J(a.U("right to "), sideToString(i3), " undefined"));
                    }
                    ConstraintLayout$LayoutParams constraintLayout$LayoutParams13 = this.mParams;
                    constraintLayout$LayoutParams13.endToStart = i2;
                    constraintLayout$LayoutParams13.endToEnd = -1;
                }
                this.mParams.setMarginEnd(i4);
                return this;
            default:
                StringBuilder sb = new StringBuilder();
                sb.append(sideToString(i));
                sb.append(" to ");
                throw new IllegalArgumentException(a.J(sb, sideToString(i3), " unknown"));
        }
    }

    public ConstraintProperties constrainDefaultHeight(int i) {
        this.mParams.matchConstraintDefaultHeight = i;
        return this;
    }

    public ConstraintProperties constrainDefaultWidth(int i) {
        this.mParams.matchConstraintDefaultWidth = i;
        return this;
    }

    public ConstraintProperties constrainHeight(int i) {
        ((ViewGroup$MarginLayoutParams) this.mParams).height = i;
        return this;
    }

    public ConstraintProperties constrainMaxHeight(int i) {
        this.mParams.matchConstraintMaxHeight = i;
        return this;
    }

    public ConstraintProperties constrainMaxWidth(int i) {
        this.mParams.matchConstraintMaxWidth = i;
        return this;
    }

    public ConstraintProperties constrainMinHeight(int i) {
        this.mParams.matchConstraintMinHeight = i;
        return this;
    }

    public ConstraintProperties constrainMinWidth(int i) {
        this.mParams.matchConstraintMinWidth = i;
        return this;
    }

    public ConstraintProperties constrainWidth(int i) {
        ((ViewGroup$MarginLayoutParams) this.mParams).width = i;
        return this;
    }

    public ConstraintProperties dimensionRatio(String str) {
        this.mParams.dimensionRatio = str;
        return this;
    }

    public ConstraintProperties elevation(float f) {
        this.mView.setElevation(f);
        return this;
    }

    public ConstraintProperties goneMargin(int i, int i2) {
        switch (i) {
            case 1:
                this.mParams.goneLeftMargin = i2;
                return this;
            case 2:
                this.mParams.goneRightMargin = i2;
                return this;
            case 3:
                this.mParams.goneTopMargin = i2;
                return this;
            case 4:
                this.mParams.goneBottomMargin = i2;
                return this;
            case 5:
                throw new IllegalArgumentException("baseline does not support margins");
            case 6:
                this.mParams.goneStartMargin = i2;
                return this;
            case 7:
                this.mParams.goneEndMargin = i2;
                return this;
            default:
                throw new IllegalArgumentException("unknown constraint");
        }
    }

    public ConstraintProperties horizontalBias(float f) {
        this.mParams.horizontalBias = f;
        return this;
    }

    public ConstraintProperties horizontalChainStyle(int i) {
        this.mParams.horizontalChainStyle = i;
        return this;
    }

    public ConstraintProperties horizontalWeight(float f) {
        this.mParams.horizontalWeight = f;
        return this;
    }

    public ConstraintProperties margin(int i, int i2) {
        switch (i) {
            case 1:
                ((ViewGroup$MarginLayoutParams) this.mParams).leftMargin = i2;
                return this;
            case 2:
                ((ViewGroup$MarginLayoutParams) this.mParams).rightMargin = i2;
                return this;
            case 3:
                ((ViewGroup$MarginLayoutParams) this.mParams).topMargin = i2;
                return this;
            case 4:
                ((ViewGroup$MarginLayoutParams) this.mParams).bottomMargin = i2;
                return this;
            case 5:
                throw new IllegalArgumentException("baseline does not support margins");
            case 6:
                this.mParams.setMarginStart(i2);
                return this;
            case 7:
                this.mParams.setMarginEnd(i2);
                return this;
            default:
                throw new IllegalArgumentException("unknown constraint");
        }
    }

    public ConstraintProperties removeConstraints(int i) {
        switch (i) {
            case 1:
                ConstraintLayout$LayoutParams constraintLayout$LayoutParams = this.mParams;
                constraintLayout$LayoutParams.leftToRight = -1;
                constraintLayout$LayoutParams.leftToLeft = -1;
                ((ViewGroup$MarginLayoutParams) constraintLayout$LayoutParams).leftMargin = -1;
                constraintLayout$LayoutParams.goneLeftMargin = -1;
                return this;
            case 2:
                ConstraintLayout$LayoutParams constraintLayout$LayoutParams2 = this.mParams;
                constraintLayout$LayoutParams2.rightToRight = -1;
                constraintLayout$LayoutParams2.rightToLeft = -1;
                ((ViewGroup$MarginLayoutParams) constraintLayout$LayoutParams2).rightMargin = -1;
                constraintLayout$LayoutParams2.goneRightMargin = -1;
                return this;
            case 3:
                ConstraintLayout$LayoutParams constraintLayout$LayoutParams3 = this.mParams;
                constraintLayout$LayoutParams3.topToBottom = -1;
                constraintLayout$LayoutParams3.topToTop = -1;
                ((ViewGroup$MarginLayoutParams) constraintLayout$LayoutParams3).topMargin = -1;
                constraintLayout$LayoutParams3.goneTopMargin = -1;
                return this;
            case 4:
                ConstraintLayout$LayoutParams constraintLayout$LayoutParams4 = this.mParams;
                constraintLayout$LayoutParams4.bottomToTop = -1;
                constraintLayout$LayoutParams4.bottomToBottom = -1;
                ((ViewGroup$MarginLayoutParams) constraintLayout$LayoutParams4).bottomMargin = -1;
                constraintLayout$LayoutParams4.goneBottomMargin = -1;
                return this;
            case 5:
                this.mParams.baselineToBaseline = -1;
                return this;
            case 6:
                ConstraintLayout$LayoutParams constraintLayout$LayoutParams5 = this.mParams;
                constraintLayout$LayoutParams5.startToEnd = -1;
                constraintLayout$LayoutParams5.startToStart = -1;
                constraintLayout$LayoutParams5.setMarginStart(-1);
                this.mParams.goneStartMargin = -1;
                return this;
            case 7:
                ConstraintLayout$LayoutParams constraintLayout$LayoutParams6 = this.mParams;
                constraintLayout$LayoutParams6.endToStart = -1;
                constraintLayout$LayoutParams6.endToEnd = -1;
                constraintLayout$LayoutParams6.setMarginEnd(-1);
                this.mParams.goneEndMargin = -1;
                return this;
            default:
                throw new IllegalArgumentException("unknown constraint");
        }
    }

    public ConstraintProperties removeFromHorizontalChain() {
        ConstraintLayout$LayoutParams constraintLayout$LayoutParams = this.mParams;
        int i = constraintLayout$LayoutParams.leftToRight;
        int i2 = constraintLayout$LayoutParams.rightToLeft;
        if (i == -1 && i2 == -1) {
            int i3 = constraintLayout$LayoutParams.startToEnd;
            int i4 = constraintLayout$LayoutParams.endToStart;
            if (i3 != -1 || i4 != -1) {
                ConstraintProperties constraintProperties = new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(i3));
                ConstraintProperties constraintProperties2 = new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(i4));
                ConstraintLayout$LayoutParams constraintLayout$LayoutParams2 = this.mParams;
                if (i3 != -1 && i4 != -1) {
                    constraintProperties.connect(7, i4, 6, 0);
                    constraintProperties2.connect(6, i, 7, 0);
                } else if (i != -1 || i4 != -1) {
                    int i5 = constraintLayout$LayoutParams2.rightToRight;
                    if (i5 != -1) {
                        constraintProperties.connect(7, i5, 7, 0);
                    } else {
                        int i6 = constraintLayout$LayoutParams2.leftToLeft;
                        if (i6 != -1) {
                            constraintProperties2.connect(6, i6, 6, 0);
                        }
                    }
                }
            }
            removeConstraints(6);
            removeConstraints(7);
        } else {
            ConstraintProperties constraintProperties3 = new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(i));
            ConstraintProperties constraintProperties4 = new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(i2));
            ConstraintLayout$LayoutParams constraintLayout$LayoutParams3 = this.mParams;
            if (i != -1 && i2 != -1) {
                constraintProperties3.connect(2, i2, 1, 0);
                constraintProperties4.connect(1, i, 2, 0);
            } else if (i != -1 || i2 != -1) {
                int i7 = constraintLayout$LayoutParams3.rightToRight;
                if (i7 != -1) {
                    constraintProperties3.connect(2, i7, 2, 0);
                } else {
                    int i8 = constraintLayout$LayoutParams3.leftToLeft;
                    if (i8 != -1) {
                        constraintProperties4.connect(1, i8, 1, 0);
                    }
                }
            }
            removeConstraints(1);
            removeConstraints(2);
        }
        return this;
    }

    public ConstraintProperties removeFromVerticalChain() {
        ConstraintLayout$LayoutParams constraintLayout$LayoutParams = this.mParams;
        int i = constraintLayout$LayoutParams.topToBottom;
        int i2 = constraintLayout$LayoutParams.bottomToTop;
        if (i != -1 || i2 != -1) {
            ConstraintProperties constraintProperties = new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(i));
            ConstraintProperties constraintProperties2 = new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(i2));
            ConstraintLayout$LayoutParams constraintLayout$LayoutParams2 = this.mParams;
            if (i != -1 && i2 != -1) {
                constraintProperties.connect(4, i2, 3, 0);
                constraintProperties2.connect(3, i, 4, 0);
            } else if (i != -1 || i2 != -1) {
                int i3 = constraintLayout$LayoutParams2.bottomToBottom;
                if (i3 != -1) {
                    constraintProperties.connect(4, i3, 4, 0);
                } else {
                    int i4 = constraintLayout$LayoutParams2.topToTop;
                    if (i4 != -1) {
                        constraintProperties2.connect(3, i4, 3, 0);
                    }
                }
            }
        }
        removeConstraints(3);
        removeConstraints(4);
        return this;
    }

    public ConstraintProperties rotation(float f) {
        this.mView.setRotation(f);
        return this;
    }

    public ConstraintProperties rotationX(float f) {
        this.mView.setRotationX(f);
        return this;
    }

    public ConstraintProperties rotationY(float f) {
        this.mView.setRotationY(f);
        return this;
    }

    public ConstraintProperties scaleX(float f) {
        this.mView.setScaleY(f);
        return this;
    }

    public ConstraintProperties scaleY(float f) {
        return this;
    }

    public ConstraintProperties transformPivot(float f, float f2) {
        this.mView.setPivotX(f);
        this.mView.setPivotY(f2);
        return this;
    }

    public ConstraintProperties transformPivotX(float f) {
        this.mView.setPivotX(f);
        return this;
    }

    public ConstraintProperties transformPivotY(float f) {
        this.mView.setPivotY(f);
        return this;
    }

    public ConstraintProperties translation(float f, float f2) {
        this.mView.setTranslationX(f);
        this.mView.setTranslationY(f2);
        return this;
    }

    public ConstraintProperties translationX(float f) {
        this.mView.setTranslationX(f);
        return this;
    }

    public ConstraintProperties translationY(float f) {
        this.mView.setTranslationY(f);
        return this;
    }

    public ConstraintProperties translationZ(float f) {
        this.mView.setTranslationZ(f);
        return this;
    }

    public ConstraintProperties verticalBias(float f) {
        this.mParams.verticalBias = f;
        return this;
    }

    public ConstraintProperties verticalChainStyle(int i) {
        this.mParams.verticalChainStyle = i;
        return this;
    }

    public ConstraintProperties verticalWeight(float f) {
        this.mParams.verticalWeight = f;
        return this;
    }

    public ConstraintProperties visibility(int i) {
        this.mView.setVisibility(i);
        return this;
    }

    public ConstraintProperties centerHorizontally(int i) {
        if (i == 0) {
            center(0, 1, 0, 0, 2, 0, 0.5f);
        } else {
            center(i, 2, 0, i, 1, 0, 0.5f);
        }
        return this;
    }

    public ConstraintProperties centerHorizontallyRtl(int i) {
        if (i == 0) {
            center(0, 6, 0, 0, 7, 0, 0.5f);
        } else {
            center(i, 7, 0, i, 6, 0, 0.5f);
        }
        return this;
    }

    public ConstraintProperties centerVertically(int i) {
        if (i == 0) {
            center(0, 3, 0, 0, 4, 0, 0.5f);
        } else {
            center(i, 4, 0, i, 3, 0, 0.5f);
        }
        return this;
    }
}
