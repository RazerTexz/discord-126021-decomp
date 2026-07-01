package androidx.constraintlayout.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup$MarginLayoutParams;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.exifinterface.media.ExifInterface;

/* JADX INFO: loaded from: classes.dex */
public class ConstraintLayout$LayoutParams extends ViewGroup$MarginLayoutParams {
    public static final int BASELINE = 5;
    public static final int BOTTOM = 4;
    public static final int CHAIN_PACKED = 2;
    public static final int CHAIN_SPREAD = 0;
    public static final int CHAIN_SPREAD_INSIDE = 1;
    public static final int END = 7;
    public static final int HORIZONTAL = 0;
    public static final int LEFT = 1;
    public static final int MATCH_CONSTRAINT = 0;
    public static final int MATCH_CONSTRAINT_PERCENT = 2;
    public static final int MATCH_CONSTRAINT_SPREAD = 0;
    public static final int MATCH_CONSTRAINT_WRAP = 1;
    public static final int PARENT_ID = 0;
    public static final int RIGHT = 2;
    public static final int START = 6;
    public static final int TOP = 3;
    public static final int UNSET = -1;
    public static final int VERTICAL = 1;
    public int baselineToBaseline;
    public int bottomToBottom;
    public int bottomToTop;
    public float circleAngle;
    public int circleConstraint;
    public int circleRadius;
    public boolean constrainedHeight;
    public boolean constrainedWidth;
    public String constraintTag;
    public String dimensionRatio;
    public int dimensionRatioSide;
    public float dimensionRatioValue;
    public int editorAbsoluteX;
    public int editorAbsoluteY;
    public int endToEnd;
    public int endToStart;
    public int goneBottomMargin;
    public int goneEndMargin;
    public int goneLeftMargin;
    public int goneRightMargin;
    public int goneStartMargin;
    public int goneTopMargin;
    public int guideBegin;
    public int guideEnd;
    public float guidePercent;
    public boolean helped;
    public float horizontalBias;
    public int horizontalChainStyle;
    public boolean horizontalDimensionFixed;
    public float horizontalWeight;
    public boolean isGuideline;
    public boolean isHelper;
    public boolean isInPlaceholder;
    public boolean isVirtualGroup;
    public int leftToLeft;
    public int leftToRight;
    public int matchConstraintDefaultHeight;
    public int matchConstraintDefaultWidth;
    public int matchConstraintMaxHeight;
    public int matchConstraintMaxWidth;
    public int matchConstraintMinHeight;
    public int matchConstraintMinWidth;
    public float matchConstraintPercentHeight;
    public float matchConstraintPercentWidth;
    public boolean needsBaseline;
    public int orientation;
    public int resolveGoneLeftMargin;
    public int resolveGoneRightMargin;
    public int resolvedGuideBegin;
    public int resolvedGuideEnd;
    public float resolvedGuidePercent;
    public float resolvedHorizontalBias;
    public int resolvedLeftToLeft;
    public int resolvedLeftToRight;
    public int resolvedRightToLeft;
    public int resolvedRightToRight;
    public int rightToLeft;
    public int rightToRight;
    public int startToEnd;
    public int startToStart;
    public int topToBottom;
    public int topToTop;
    public float verticalBias;
    public int verticalChainStyle;
    public boolean verticalDimensionFixed;
    public float verticalWeight;
    public ConstraintWidget widget;

    public ConstraintLayout$LayoutParams(ConstraintLayout$LayoutParams constraintLayout$LayoutParams) {
        super((ViewGroup$MarginLayoutParams) constraintLayout$LayoutParams);
        this.guideBegin = -1;
        this.guideEnd = -1;
        this.guidePercent = -1.0f;
        this.leftToLeft = -1;
        this.leftToRight = -1;
        this.rightToLeft = -1;
        this.rightToRight = -1;
        this.topToTop = -1;
        this.topToBottom = -1;
        this.bottomToTop = -1;
        this.bottomToBottom = -1;
        this.baselineToBaseline = -1;
        this.circleConstraint = -1;
        this.circleRadius = 0;
        this.circleAngle = 0.0f;
        this.startToEnd = -1;
        this.startToStart = -1;
        this.endToStart = -1;
        this.endToEnd = -1;
        this.goneLeftMargin = -1;
        this.goneTopMargin = -1;
        this.goneRightMargin = -1;
        this.goneBottomMargin = -1;
        this.goneStartMargin = -1;
        this.goneEndMargin = -1;
        this.horizontalBias = 0.5f;
        this.verticalBias = 0.5f;
        this.dimensionRatio = null;
        this.dimensionRatioValue = 0.0f;
        this.dimensionRatioSide = 1;
        this.horizontalWeight = -1.0f;
        this.verticalWeight = -1.0f;
        this.horizontalChainStyle = 0;
        this.verticalChainStyle = 0;
        this.matchConstraintDefaultWidth = 0;
        this.matchConstraintDefaultHeight = 0;
        this.matchConstraintMinWidth = 0;
        this.matchConstraintMinHeight = 0;
        this.matchConstraintMaxWidth = 0;
        this.matchConstraintMaxHeight = 0;
        this.matchConstraintPercentWidth = 1.0f;
        this.matchConstraintPercentHeight = 1.0f;
        this.editorAbsoluteX = -1;
        this.editorAbsoluteY = -1;
        this.orientation = -1;
        this.constrainedWidth = false;
        this.constrainedHeight = false;
        this.constraintTag = null;
        this.horizontalDimensionFixed = true;
        this.verticalDimensionFixed = true;
        this.needsBaseline = false;
        this.isGuideline = false;
        this.isHelper = false;
        this.isInPlaceholder = false;
        this.isVirtualGroup = false;
        this.resolvedLeftToLeft = -1;
        this.resolvedLeftToRight = -1;
        this.resolvedRightToLeft = -1;
        this.resolvedRightToRight = -1;
        this.resolveGoneLeftMargin = -1;
        this.resolveGoneRightMargin = -1;
        this.resolvedHorizontalBias = 0.5f;
        this.widget = new ConstraintWidget();
        this.helped = false;
        this.guideBegin = constraintLayout$LayoutParams.guideBegin;
        this.guideEnd = constraintLayout$LayoutParams.guideEnd;
        this.guidePercent = constraintLayout$LayoutParams.guidePercent;
        this.leftToLeft = constraintLayout$LayoutParams.leftToLeft;
        this.leftToRight = constraintLayout$LayoutParams.leftToRight;
        this.rightToLeft = constraintLayout$LayoutParams.rightToLeft;
        this.rightToRight = constraintLayout$LayoutParams.rightToRight;
        this.topToTop = constraintLayout$LayoutParams.topToTop;
        this.topToBottom = constraintLayout$LayoutParams.topToBottom;
        this.bottomToTop = constraintLayout$LayoutParams.bottomToTop;
        this.bottomToBottom = constraintLayout$LayoutParams.bottomToBottom;
        this.baselineToBaseline = constraintLayout$LayoutParams.baselineToBaseline;
        this.circleConstraint = constraintLayout$LayoutParams.circleConstraint;
        this.circleRadius = constraintLayout$LayoutParams.circleRadius;
        this.circleAngle = constraintLayout$LayoutParams.circleAngle;
        this.startToEnd = constraintLayout$LayoutParams.startToEnd;
        this.startToStart = constraintLayout$LayoutParams.startToStart;
        this.endToStart = constraintLayout$LayoutParams.endToStart;
        this.endToEnd = constraintLayout$LayoutParams.endToEnd;
        this.goneLeftMargin = constraintLayout$LayoutParams.goneLeftMargin;
        this.goneTopMargin = constraintLayout$LayoutParams.goneTopMargin;
        this.goneRightMargin = constraintLayout$LayoutParams.goneRightMargin;
        this.goneBottomMargin = constraintLayout$LayoutParams.goneBottomMargin;
        this.goneStartMargin = constraintLayout$LayoutParams.goneStartMargin;
        this.goneEndMargin = constraintLayout$LayoutParams.goneEndMargin;
        this.horizontalBias = constraintLayout$LayoutParams.horizontalBias;
        this.verticalBias = constraintLayout$LayoutParams.verticalBias;
        this.dimensionRatio = constraintLayout$LayoutParams.dimensionRatio;
        this.dimensionRatioValue = constraintLayout$LayoutParams.dimensionRatioValue;
        this.dimensionRatioSide = constraintLayout$LayoutParams.dimensionRatioSide;
        this.horizontalWeight = constraintLayout$LayoutParams.horizontalWeight;
        this.verticalWeight = constraintLayout$LayoutParams.verticalWeight;
        this.horizontalChainStyle = constraintLayout$LayoutParams.horizontalChainStyle;
        this.verticalChainStyle = constraintLayout$LayoutParams.verticalChainStyle;
        this.constrainedWidth = constraintLayout$LayoutParams.constrainedWidth;
        this.constrainedHeight = constraintLayout$LayoutParams.constrainedHeight;
        this.matchConstraintDefaultWidth = constraintLayout$LayoutParams.matchConstraintDefaultWidth;
        this.matchConstraintDefaultHeight = constraintLayout$LayoutParams.matchConstraintDefaultHeight;
        this.matchConstraintMinWidth = constraintLayout$LayoutParams.matchConstraintMinWidth;
        this.matchConstraintMaxWidth = constraintLayout$LayoutParams.matchConstraintMaxWidth;
        this.matchConstraintMinHeight = constraintLayout$LayoutParams.matchConstraintMinHeight;
        this.matchConstraintMaxHeight = constraintLayout$LayoutParams.matchConstraintMaxHeight;
        this.matchConstraintPercentWidth = constraintLayout$LayoutParams.matchConstraintPercentWidth;
        this.matchConstraintPercentHeight = constraintLayout$LayoutParams.matchConstraintPercentHeight;
        this.editorAbsoluteX = constraintLayout$LayoutParams.editorAbsoluteX;
        this.editorAbsoluteY = constraintLayout$LayoutParams.editorAbsoluteY;
        this.orientation = constraintLayout$LayoutParams.orientation;
        this.horizontalDimensionFixed = constraintLayout$LayoutParams.horizontalDimensionFixed;
        this.verticalDimensionFixed = constraintLayout$LayoutParams.verticalDimensionFixed;
        this.needsBaseline = constraintLayout$LayoutParams.needsBaseline;
        this.isGuideline = constraintLayout$LayoutParams.isGuideline;
        this.resolvedLeftToLeft = constraintLayout$LayoutParams.resolvedLeftToLeft;
        this.resolvedLeftToRight = constraintLayout$LayoutParams.resolvedLeftToRight;
        this.resolvedRightToLeft = constraintLayout$LayoutParams.resolvedRightToLeft;
        this.resolvedRightToRight = constraintLayout$LayoutParams.resolvedRightToRight;
        this.resolveGoneLeftMargin = constraintLayout$LayoutParams.resolveGoneLeftMargin;
        this.resolveGoneRightMargin = constraintLayout$LayoutParams.resolveGoneRightMargin;
        this.resolvedHorizontalBias = constraintLayout$LayoutParams.resolvedHorizontalBias;
        this.constraintTag = constraintLayout$LayoutParams.constraintTag;
        this.widget = constraintLayout$LayoutParams.widget;
    }

    public String getConstraintTag() {
        return this.constraintTag;
    }

    public ConstraintWidget getConstraintWidget() {
        return this.widget;
    }

    public void reset() {
        ConstraintWidget constraintWidget = this.widget;
        if (constraintWidget != null) {
            constraintWidget.reset();
        }
    }

    /* JADX WARN: Code duplicated, block: B:17:0x004c  */
    /* JADX WARN: Code duplicated, block: B:20:0x0053  */
    /* JADX WARN: Code duplicated, block: B:23:0x005a  */
    /* JADX WARN: Code duplicated, block: B:26:0x0060  */
    /* JADX WARN: Code duplicated, block: B:29:0x0066  */
    /* JADX WARN: Code duplicated, block: B:36:0x0078  */
    /* JADX WARN: Code duplicated, block: B:37:0x0080 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:38:0x0082  */
    /* JADX WARN: Code duplicated, block: B:39:0x0089 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:40:0x008b  */
    @Override // android.view.ViewGroup$MarginLayoutParams, android.view.ViewGroup$LayoutParams
    @TargetApi(17)
    public void resolveLayoutDirection(int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6 = ((ViewGroup$MarginLayoutParams) this).leftMargin;
        int i7 = ((ViewGroup$MarginLayoutParams) this).rightMargin;
        super.resolveLayoutDirection(i);
        boolean z2 = false;
        boolean z3 = 1 == getLayoutDirection();
        this.resolvedRightToLeft = -1;
        this.resolvedRightToRight = -1;
        this.resolvedLeftToLeft = -1;
        this.resolvedLeftToRight = -1;
        this.resolveGoneLeftMargin = -1;
        this.resolveGoneRightMargin = -1;
        this.resolveGoneLeftMargin = this.goneLeftMargin;
        this.resolveGoneRightMargin = this.goneRightMargin;
        float f = this.horizontalBias;
        this.resolvedHorizontalBias = f;
        int i8 = this.guideBegin;
        this.resolvedGuideBegin = i8;
        int i9 = this.guideEnd;
        this.resolvedGuideEnd = i9;
        float f2 = this.guidePercent;
        this.resolvedGuidePercent = f2;
        if (z3) {
            int i10 = this.startToEnd;
            if (i10 != -1) {
                this.resolvedRightToLeft = i10;
            } else {
                int i11 = this.startToStart;
                if (i11 != -1) {
                    this.resolvedRightToRight = i11;
                } else {
                    i2 = this.endToStart;
                    if (i2 != -1) {
                        this.resolvedLeftToRight = i2;
                        z2 = true;
                    }
                    i3 = this.endToEnd;
                    if (i3 != -1) {
                        this.resolvedLeftToLeft = i3;
                        z2 = true;
                    }
                    i4 = this.goneStartMargin;
                    if (i4 != -1) {
                        this.resolveGoneRightMargin = i4;
                    }
                    i5 = this.goneEndMargin;
                    if (i5 != -1) {
                        this.resolveGoneLeftMargin = i5;
                    }
                    if (z2) {
                        this.resolvedHorizontalBias = 1.0f - f;
                    }
                    if (this.isGuideline && this.orientation == 1) {
                        if (f2 != -1.0f) {
                            this.resolvedGuidePercent = 1.0f - f2;
                            this.resolvedGuideBegin = -1;
                            this.resolvedGuideEnd = -1;
                        } else if (i8 != -1) {
                            this.resolvedGuideEnd = i8;
                            this.resolvedGuideBegin = -1;
                            this.resolvedGuidePercent = -1.0f;
                        } else if (i9 != -1) {
                            this.resolvedGuideBegin = i9;
                            this.resolvedGuideEnd = -1;
                            this.resolvedGuidePercent = -1.0f;
                        }
                    }
                }
            }
            z2 = true;
            i2 = this.endToStart;
            if (i2 != -1) {
                this.resolvedLeftToRight = i2;
                z2 = true;
            }
            i3 = this.endToEnd;
            if (i3 != -1) {
                this.resolvedLeftToLeft = i3;
                z2 = true;
            }
            i4 = this.goneStartMargin;
            if (i4 != -1) {
                this.resolveGoneRightMargin = i4;
            }
            i5 = this.goneEndMargin;
            if (i5 != -1) {
                this.resolveGoneLeftMargin = i5;
            }
            if (z2) {
                this.resolvedHorizontalBias = 1.0f - f;
            }
            if (this.isGuideline) {
                if (f2 != -1.0f) {
                    this.resolvedGuidePercent = 1.0f - f2;
                    this.resolvedGuideBegin = -1;
                    this.resolvedGuideEnd = -1;
                } else if (i8 != -1) {
                    this.resolvedGuideEnd = i8;
                    this.resolvedGuideBegin = -1;
                    this.resolvedGuidePercent = -1.0f;
                } else if (i9 != -1) {
                    this.resolvedGuideBegin = i9;
                    this.resolvedGuideEnd = -1;
                    this.resolvedGuidePercent = -1.0f;
                }
            }
        } else {
            int i12 = this.startToEnd;
            if (i12 != -1) {
                this.resolvedLeftToRight = i12;
            }
            int i13 = this.startToStart;
            if (i13 != -1) {
                this.resolvedLeftToLeft = i13;
            }
            int i14 = this.endToStart;
            if (i14 != -1) {
                this.resolvedRightToLeft = i14;
            }
            int i15 = this.endToEnd;
            if (i15 != -1) {
                this.resolvedRightToRight = i15;
            }
            int i16 = this.goneStartMargin;
            if (i16 != -1) {
                this.resolveGoneLeftMargin = i16;
            }
            int i17 = this.goneEndMargin;
            if (i17 != -1) {
                this.resolveGoneRightMargin = i17;
            }
        }
        if (this.endToStart == -1 && this.endToEnd == -1 && this.startToStart == -1 && this.startToEnd == -1) {
            int i18 = this.rightToLeft;
            if (i18 != -1) {
                this.resolvedRightToLeft = i18;
                if (((ViewGroup$MarginLayoutParams) this).rightMargin <= 0 && i7 > 0) {
                    ((ViewGroup$MarginLayoutParams) this).rightMargin = i7;
                }
            } else {
                int i19 = this.rightToRight;
                if (i19 != -1) {
                    this.resolvedRightToRight = i19;
                    if (((ViewGroup$MarginLayoutParams) this).rightMargin <= 0 && i7 > 0) {
                        ((ViewGroup$MarginLayoutParams) this).rightMargin = i7;
                    }
                }
            }
            int i20 = this.leftToLeft;
            if (i20 != -1) {
                this.resolvedLeftToLeft = i20;
                if (((ViewGroup$MarginLayoutParams) this).leftMargin > 0 || i6 <= 0) {
                    return;
                }
                ((ViewGroup$MarginLayoutParams) this).leftMargin = i6;
                return;
            }
            int i21 = this.leftToRight;
            if (i21 != -1) {
                this.resolvedLeftToRight = i21;
                if (((ViewGroup$MarginLayoutParams) this).leftMargin > 0 || i6 <= 0) {
                    return;
                }
                ((ViewGroup$MarginLayoutParams) this).leftMargin = i6;
            }
        }
    }

    public void setWidgetDebugName(String str) {
        this.widget.setDebugName(str);
    }

    public void validate() {
        this.isGuideline = false;
        this.horizontalDimensionFixed = true;
        this.verticalDimensionFixed = true;
        int i = ((ViewGroup$MarginLayoutParams) this).width;
        if (i == -2 && this.constrainedWidth) {
            this.horizontalDimensionFixed = false;
            if (this.matchConstraintDefaultWidth == 0) {
                this.matchConstraintDefaultWidth = 1;
            }
        }
        int i2 = ((ViewGroup$MarginLayoutParams) this).height;
        if (i2 == -2 && this.constrainedHeight) {
            this.verticalDimensionFixed = false;
            if (this.matchConstraintDefaultHeight == 0) {
                this.matchConstraintDefaultHeight = 1;
            }
        }
        if (i == 0 || i == -1) {
            this.horizontalDimensionFixed = false;
            if (i == 0 && this.matchConstraintDefaultWidth == 1) {
                ((ViewGroup$MarginLayoutParams) this).width = -2;
                this.constrainedWidth = true;
            }
        }
        if (i2 == 0 || i2 == -1) {
            this.verticalDimensionFixed = false;
            if (i2 == 0 && this.matchConstraintDefaultHeight == 1) {
                ((ViewGroup$MarginLayoutParams) this).height = -2;
                this.constrainedHeight = true;
            }
        }
        if (this.guidePercent == -1.0f && this.guideBegin == -1 && this.guideEnd == -1) {
            return;
        }
        this.isGuideline = true;
        this.horizontalDimensionFixed = true;
        this.verticalDimensionFixed = true;
        if (!(this.widget instanceof androidx.constraintlayout.solver.widgets.Guideline)) {
            this.widget = new androidx.constraintlayout.solver.widgets.Guideline();
        }
        ((androidx.constraintlayout.solver.widgets.Guideline) this.widget).setOrientation(this.orientation);
    }

    public ConstraintLayout$LayoutParams(Context context, AttributeSet attributeSet) {
        int i;
        super(context, attributeSet);
        this.guideBegin = -1;
        this.guideEnd = -1;
        this.guidePercent = -1.0f;
        this.leftToLeft = -1;
        this.leftToRight = -1;
        this.rightToLeft = -1;
        this.rightToRight = -1;
        this.topToTop = -1;
        this.topToBottom = -1;
        this.bottomToTop = -1;
        this.bottomToBottom = -1;
        this.baselineToBaseline = -1;
        this.circleConstraint = -1;
        this.circleRadius = 0;
        this.circleAngle = 0.0f;
        this.startToEnd = -1;
        this.startToStart = -1;
        this.endToStart = -1;
        this.endToEnd = -1;
        this.goneLeftMargin = -1;
        this.goneTopMargin = -1;
        this.goneRightMargin = -1;
        this.goneBottomMargin = -1;
        this.goneStartMargin = -1;
        this.goneEndMargin = -1;
        this.horizontalBias = 0.5f;
        this.verticalBias = 0.5f;
        this.dimensionRatio = null;
        this.dimensionRatioValue = 0.0f;
        this.dimensionRatioSide = 1;
        this.horizontalWeight = -1.0f;
        this.verticalWeight = -1.0f;
        this.horizontalChainStyle = 0;
        this.verticalChainStyle = 0;
        this.matchConstraintDefaultWidth = 0;
        this.matchConstraintDefaultHeight = 0;
        this.matchConstraintMinWidth = 0;
        this.matchConstraintMinHeight = 0;
        this.matchConstraintMaxWidth = 0;
        this.matchConstraintMaxHeight = 0;
        this.matchConstraintPercentWidth = 1.0f;
        this.matchConstraintPercentHeight = 1.0f;
        this.editorAbsoluteX = -1;
        this.editorAbsoluteY = -1;
        this.orientation = -1;
        this.constrainedWidth = false;
        this.constrainedHeight = false;
        this.constraintTag = null;
        this.horizontalDimensionFixed = true;
        this.verticalDimensionFixed = true;
        this.needsBaseline = false;
        this.isGuideline = false;
        this.isHelper = false;
        this.isInPlaceholder = false;
        this.isVirtualGroup = false;
        this.resolvedLeftToLeft = -1;
        this.resolvedLeftToRight = -1;
        this.resolvedRightToLeft = -1;
        this.resolvedRightToRight = -1;
        this.resolveGoneLeftMargin = -1;
        this.resolveGoneRightMargin = -1;
        this.resolvedHorizontalBias = 0.5f;
        this.widget = new ConstraintWidget();
        this.helped = false;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ConstraintLayout_Layout);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i2 = 0; i2 < indexCount; i2++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i2);
            int i3 = ConstraintLayout$LayoutParams$Table.map.get(index);
            switch (i3) {
                case 1:
                    this.orientation = typedArrayObtainStyledAttributes.getInt(index, this.orientation);
                    break;
                case 2:
                    int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, this.circleConstraint);
                    this.circleConstraint = resourceId;
                    if (resourceId == -1) {
                        this.circleConstraint = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                    break;
                case 3:
                    this.circleRadius = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.circleRadius);
                    break;
                case 4:
                    float f = typedArrayObtainStyledAttributes.getFloat(index, this.circleAngle) % 360.0f;
                    this.circleAngle = f;
                    if (f < 0.0f) {
                        this.circleAngle = (360.0f - f) % 360.0f;
                    }
                    break;
                case 5:
                    this.guideBegin = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.guideBegin);
                    break;
                case 6:
                    this.guideEnd = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.guideEnd);
                    break;
                case 7:
                    this.guidePercent = typedArrayObtainStyledAttributes.getFloat(index, this.guidePercent);
                    break;
                case 8:
                    int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(index, this.leftToLeft);
                    this.leftToLeft = resourceId2;
                    if (resourceId2 == -1) {
                        this.leftToLeft = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                    break;
                case 9:
                    int resourceId3 = typedArrayObtainStyledAttributes.getResourceId(index, this.leftToRight);
                    this.leftToRight = resourceId3;
                    if (resourceId3 == -1) {
                        this.leftToRight = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                    break;
                case 10:
                    int resourceId4 = typedArrayObtainStyledAttributes.getResourceId(index, this.rightToLeft);
                    this.rightToLeft = resourceId4;
                    if (resourceId4 == -1) {
                        this.rightToLeft = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                    break;
                case 11:
                    int resourceId5 = typedArrayObtainStyledAttributes.getResourceId(index, this.rightToRight);
                    this.rightToRight = resourceId5;
                    if (resourceId5 == -1) {
                        this.rightToRight = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                    break;
                case 12:
                    int resourceId6 = typedArrayObtainStyledAttributes.getResourceId(index, this.topToTop);
                    this.topToTop = resourceId6;
                    if (resourceId6 == -1) {
                        this.topToTop = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                    break;
                case 13:
                    int resourceId7 = typedArrayObtainStyledAttributes.getResourceId(index, this.topToBottom);
                    this.topToBottom = resourceId7;
                    if (resourceId7 == -1) {
                        this.topToBottom = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                    break;
                case 14:
                    int resourceId8 = typedArrayObtainStyledAttributes.getResourceId(index, this.bottomToTop);
                    this.bottomToTop = resourceId8;
                    if (resourceId8 == -1) {
                        this.bottomToTop = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                    break;
                case 15:
                    int resourceId9 = typedArrayObtainStyledAttributes.getResourceId(index, this.bottomToBottom);
                    this.bottomToBottom = resourceId9;
                    if (resourceId9 == -1) {
                        this.bottomToBottom = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                    break;
                case 16:
                    int resourceId10 = typedArrayObtainStyledAttributes.getResourceId(index, this.baselineToBaseline);
                    this.baselineToBaseline = resourceId10;
                    if (resourceId10 == -1) {
                        this.baselineToBaseline = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                    break;
                case 17:
                    int resourceId11 = typedArrayObtainStyledAttributes.getResourceId(index, this.startToEnd);
                    this.startToEnd = resourceId11;
                    if (resourceId11 == -1) {
                        this.startToEnd = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                    break;
                case 18:
                    int resourceId12 = typedArrayObtainStyledAttributes.getResourceId(index, this.startToStart);
                    this.startToStart = resourceId12;
                    if (resourceId12 == -1) {
                        this.startToStart = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                    break;
                case 19:
                    int resourceId13 = typedArrayObtainStyledAttributes.getResourceId(index, this.endToStart);
                    this.endToStart = resourceId13;
                    if (resourceId13 == -1) {
                        this.endToStart = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                    break;
                case 20:
                    int resourceId14 = typedArrayObtainStyledAttributes.getResourceId(index, this.endToEnd);
                    this.endToEnd = resourceId14;
                    if (resourceId14 == -1) {
                        this.endToEnd = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                    break;
                case 21:
                    this.goneLeftMargin = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.goneLeftMargin);
                    break;
                case 22:
                    this.goneTopMargin = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.goneTopMargin);
                    break;
                case 23:
                    this.goneRightMargin = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.goneRightMargin);
                    break;
                case 24:
                    this.goneBottomMargin = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.goneBottomMargin);
                    break;
                case 25:
                    this.goneStartMargin = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.goneStartMargin);
                    break;
                case 26:
                    this.goneEndMargin = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.goneEndMargin);
                    break;
                case 27:
                    this.constrainedWidth = typedArrayObtainStyledAttributes.getBoolean(index, this.constrainedWidth);
                    break;
                case 28:
                    this.constrainedHeight = typedArrayObtainStyledAttributes.getBoolean(index, this.constrainedHeight);
                    break;
                case 29:
                    this.horizontalBias = typedArrayObtainStyledAttributes.getFloat(index, this.horizontalBias);
                    break;
                case 30:
                    this.verticalBias = typedArrayObtainStyledAttributes.getFloat(index, this.verticalBias);
                    break;
                case 31:
                    int i4 = typedArrayObtainStyledAttributes.getInt(index, 0);
                    this.matchConstraintDefaultWidth = i4;
                    if (i4 == 1) {
                        Log.e("ConstraintLayout", "layout_constraintWidth_default=\"wrap\" is deprecated.\nUse layout_width=\"WRAP_CONTENT\" and layout_constrainedWidth=\"true\" instead.");
                    }
                    break;
                case 32:
                    int i5 = typedArrayObtainStyledAttributes.getInt(index, 0);
                    this.matchConstraintDefaultHeight = i5;
                    if (i5 == 1) {
                        Log.e("ConstraintLayout", "layout_constraintHeight_default=\"wrap\" is deprecated.\nUse layout_height=\"WRAP_CONTENT\" and layout_constrainedHeight=\"true\" instead.");
                    }
                    break;
                case 33:
                    try {
                        this.matchConstraintMinWidth = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.matchConstraintMinWidth);
                    } catch (Exception unused) {
                        if (typedArrayObtainStyledAttributes.getInt(index, this.matchConstraintMinWidth) == -2) {
                            this.matchConstraintMinWidth = -2;
                        }
                    }
                    break;
                case 34:
                    try {
                        this.matchConstraintMaxWidth = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.matchConstraintMaxWidth);
                    } catch (Exception unused2) {
                        if (typedArrayObtainStyledAttributes.getInt(index, this.matchConstraintMaxWidth) == -2) {
                            this.matchConstraintMaxWidth = -2;
                        }
                    }
                    break;
                case 35:
                    this.matchConstraintPercentWidth = Math.max(0.0f, typedArrayObtainStyledAttributes.getFloat(index, this.matchConstraintPercentWidth));
                    this.matchConstraintDefaultWidth = 2;
                    break;
                case 36:
                    try {
                        this.matchConstraintMinHeight = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.matchConstraintMinHeight);
                    } catch (Exception unused3) {
                        if (typedArrayObtainStyledAttributes.getInt(index, this.matchConstraintMinHeight) == -2) {
                            this.matchConstraintMinHeight = -2;
                        }
                    }
                    break;
                case 37:
                    try {
                        this.matchConstraintMaxHeight = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.matchConstraintMaxHeight);
                    } catch (Exception unused4) {
                        if (typedArrayObtainStyledAttributes.getInt(index, this.matchConstraintMaxHeight) == -2) {
                            this.matchConstraintMaxHeight = -2;
                        }
                    }
                    break;
                case 38:
                    this.matchConstraintPercentHeight = Math.max(0.0f, typedArrayObtainStyledAttributes.getFloat(index, this.matchConstraintPercentHeight));
                    this.matchConstraintDefaultHeight = 2;
                    break;
                default:
                    switch (i3) {
                        case 44:
                            String string = typedArrayObtainStyledAttributes.getString(index);
                            this.dimensionRatio = string;
                            this.dimensionRatioValue = Float.NaN;
                            this.dimensionRatioSide = -1;
                            if (string != null) {
                                int length = string.length();
                                int iIndexOf = this.dimensionRatio.indexOf(44);
                                if (iIndexOf <= 0 || iIndexOf >= length - 1) {
                                    i = 0;
                                } else {
                                    String strSubstring = this.dimensionRatio.substring(0, iIndexOf);
                                    if (strSubstring.equalsIgnoreCase(ExifInterface.LONGITUDE_WEST)) {
                                        this.dimensionRatioSide = 0;
                                    } else if (strSubstring.equalsIgnoreCase("H")) {
                                        this.dimensionRatioSide = 1;
                                    }
                                    i = iIndexOf + 1;
                                }
                                int iIndexOf2 = this.dimensionRatio.indexOf(58);
                                if (iIndexOf2 >= 0 && iIndexOf2 < length - 1) {
                                    String strSubstring2 = this.dimensionRatio.substring(i, iIndexOf2);
                                    String strSubstring3 = this.dimensionRatio.substring(iIndexOf2 + 1);
                                    if (strSubstring2.length() > 0 && strSubstring3.length() > 0) {
                                        try {
                                            float f2 = Float.parseFloat(strSubstring2);
                                            float f3 = Float.parseFloat(strSubstring3);
                                            if (f2 > 0.0f && f3 > 0.0f) {
                                                if (this.dimensionRatioSide == 1) {
                                                    this.dimensionRatioValue = Math.abs(f3 / f2);
                                                } else {
                                                    this.dimensionRatioValue = Math.abs(f2 / f3);
                                                }
                                            }
                                        } catch (NumberFormatException unused5) {
                                        }
                                    }
                                } else {
                                    String strSubstring4 = this.dimensionRatio.substring(i);
                                    if (strSubstring4.length() > 0) {
                                        this.dimensionRatioValue = Float.parseFloat(strSubstring4);
                                    }
                                }
                            }
                            break;
                        case 45:
                            this.horizontalWeight = typedArrayObtainStyledAttributes.getFloat(index, this.horizontalWeight);
                            break;
                        case 46:
                            this.verticalWeight = typedArrayObtainStyledAttributes.getFloat(index, this.verticalWeight);
                            break;
                        case 47:
                            this.horizontalChainStyle = typedArrayObtainStyledAttributes.getInt(index, 0);
                            break;
                        case 48:
                            this.verticalChainStyle = typedArrayObtainStyledAttributes.getInt(index, 0);
                            break;
                        case 49:
                            this.editorAbsoluteX = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.editorAbsoluteX);
                            break;
                        case 50:
                            this.editorAbsoluteY = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.editorAbsoluteY);
                            break;
                        case 51:
                            this.constraintTag = typedArrayObtainStyledAttributes.getString(index);
                            break;
                    }
                    break;
            }
        }
        typedArrayObtainStyledAttributes.recycle();
        validate();
    }

    public ConstraintLayout$LayoutParams(int i, int i2) {
        super(i, i2);
        this.guideBegin = -1;
        this.guideEnd = -1;
        this.guidePercent = -1.0f;
        this.leftToLeft = -1;
        this.leftToRight = -1;
        this.rightToLeft = -1;
        this.rightToRight = -1;
        this.topToTop = -1;
        this.topToBottom = -1;
        this.bottomToTop = -1;
        this.bottomToBottom = -1;
        this.baselineToBaseline = -1;
        this.circleConstraint = -1;
        this.circleRadius = 0;
        this.circleAngle = 0.0f;
        this.startToEnd = -1;
        this.startToStart = -1;
        this.endToStart = -1;
        this.endToEnd = -1;
        this.goneLeftMargin = -1;
        this.goneTopMargin = -1;
        this.goneRightMargin = -1;
        this.goneBottomMargin = -1;
        this.goneStartMargin = -1;
        this.goneEndMargin = -1;
        this.horizontalBias = 0.5f;
        this.verticalBias = 0.5f;
        this.dimensionRatio = null;
        this.dimensionRatioValue = 0.0f;
        this.dimensionRatioSide = 1;
        this.horizontalWeight = -1.0f;
        this.verticalWeight = -1.0f;
        this.horizontalChainStyle = 0;
        this.verticalChainStyle = 0;
        this.matchConstraintDefaultWidth = 0;
        this.matchConstraintDefaultHeight = 0;
        this.matchConstraintMinWidth = 0;
        this.matchConstraintMinHeight = 0;
        this.matchConstraintMaxWidth = 0;
        this.matchConstraintMaxHeight = 0;
        this.matchConstraintPercentWidth = 1.0f;
        this.matchConstraintPercentHeight = 1.0f;
        this.editorAbsoluteX = -1;
        this.editorAbsoluteY = -1;
        this.orientation = -1;
        this.constrainedWidth = false;
        this.constrainedHeight = false;
        this.constraintTag = null;
        this.horizontalDimensionFixed = true;
        this.verticalDimensionFixed = true;
        this.needsBaseline = false;
        this.isGuideline = false;
        this.isHelper = false;
        this.isInPlaceholder = false;
        this.isVirtualGroup = false;
        this.resolvedLeftToLeft = -1;
        this.resolvedLeftToRight = -1;
        this.resolvedRightToLeft = -1;
        this.resolvedRightToRight = -1;
        this.resolveGoneLeftMargin = -1;
        this.resolveGoneRightMargin = -1;
        this.resolvedHorizontalBias = 0.5f;
        this.widget = new ConstraintWidget();
        this.helped = false;
    }

    public ConstraintLayout$LayoutParams(ViewGroup$LayoutParams viewGroup$LayoutParams) {
        super(viewGroup$LayoutParams);
        this.guideBegin = -1;
        this.guideEnd = -1;
        this.guidePercent = -1.0f;
        this.leftToLeft = -1;
        this.leftToRight = -1;
        this.rightToLeft = -1;
        this.rightToRight = -1;
        this.topToTop = -1;
        this.topToBottom = -1;
        this.bottomToTop = -1;
        this.bottomToBottom = -1;
        this.baselineToBaseline = -1;
        this.circleConstraint = -1;
        this.circleRadius = 0;
        this.circleAngle = 0.0f;
        this.startToEnd = -1;
        this.startToStart = -1;
        this.endToStart = -1;
        this.endToEnd = -1;
        this.goneLeftMargin = -1;
        this.goneTopMargin = -1;
        this.goneRightMargin = -1;
        this.goneBottomMargin = -1;
        this.goneStartMargin = -1;
        this.goneEndMargin = -1;
        this.horizontalBias = 0.5f;
        this.verticalBias = 0.5f;
        this.dimensionRatio = null;
        this.dimensionRatioValue = 0.0f;
        this.dimensionRatioSide = 1;
        this.horizontalWeight = -1.0f;
        this.verticalWeight = -1.0f;
        this.horizontalChainStyle = 0;
        this.verticalChainStyle = 0;
        this.matchConstraintDefaultWidth = 0;
        this.matchConstraintDefaultHeight = 0;
        this.matchConstraintMinWidth = 0;
        this.matchConstraintMinHeight = 0;
        this.matchConstraintMaxWidth = 0;
        this.matchConstraintMaxHeight = 0;
        this.matchConstraintPercentWidth = 1.0f;
        this.matchConstraintPercentHeight = 1.0f;
        this.editorAbsoluteX = -1;
        this.editorAbsoluteY = -1;
        this.orientation = -1;
        this.constrainedWidth = false;
        this.constrainedHeight = false;
        this.constraintTag = null;
        this.horizontalDimensionFixed = true;
        this.verticalDimensionFixed = true;
        this.needsBaseline = false;
        this.isGuideline = false;
        this.isHelper = false;
        this.isInPlaceholder = false;
        this.isVirtualGroup = false;
        this.resolvedLeftToLeft = -1;
        this.resolvedLeftToRight = -1;
        this.resolvedRightToLeft = -1;
        this.resolvedRightToRight = -1;
        this.resolveGoneLeftMargin = -1;
        this.resolveGoneRightMargin = -1;
        this.resolvedHorizontalBias = 0.5f;
        this.widget = new ConstraintWidget();
        this.helped = false;
    }
}
