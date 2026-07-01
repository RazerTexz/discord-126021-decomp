package androidx.constraintlayout.widget;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.View$MeasureSpec;
import android.view.ViewGroup;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.solver.widgets.Optimizer;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure$Measure;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure$Measurer;

/* JADX INFO: loaded from: classes.dex */
public class ConstraintLayout$Measurer implements BasicMeasure$Measurer {
    public ConstraintLayout layout;
    public int layoutHeightSpec;
    public int layoutWidthSpec;
    public int paddingBottom;
    public int paddingHeight;
    public int paddingTop;
    public int paddingWidth;
    public final /* synthetic */ ConstraintLayout this$0;

    public ConstraintLayout$Measurer(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2) {
        this.this$0 = constraintLayout;
        this.layout = constraintLayout2;
    }

    private boolean isSimilarSpec(int i, int i2, int i3) {
        if (i == i2) {
            return true;
        }
        int mode = View$MeasureSpec.getMode(i);
        View$MeasureSpec.getSize(i);
        int mode2 = View$MeasureSpec.getMode(i2);
        int size = View$MeasureSpec.getSize(i2);
        if (mode2 == 1073741824) {
            return (mode == Integer.MIN_VALUE || mode == 0) && i3 == size;
        }
        return false;
    }

    public void captureLayoutInfos(int i, int i2, int i3, int i4, int i5, int i6) {
        this.paddingTop = i3;
        this.paddingBottom = i4;
        this.paddingWidth = i5;
        this.paddingHeight = i6;
        this.layoutWidthSpec = i;
        this.layoutHeightSpec = i2;
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure$Measurer
    public final void didMeasures() {
        int childCount = this.layout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.layout.getChildAt(i);
            if (childAt instanceof Placeholder) {
                ((Placeholder) childAt).updatePostMeasure(this.layout);
            }
        }
        int size = ConstraintLayout.access$100(this.layout).size();
        if (size > 0) {
            for (int i2 = 0; i2 < size; i2++) {
                ((ConstraintHelper) ConstraintLayout.access$100(this.layout).get(i2)).updatePostMeasure(this.layout);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:30:0x0073  */
    /* JADX WARN: Code duplicated, block: B:68:0x00ee  */
    @Override // androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure$Measurer
    @SuppressLint({"WrongCall"})
    public final void measure(ConstraintWidget constraintWidget, BasicMeasure$Measure basicMeasure$Measure) {
        int iMakeMeasureSpec;
        int iMakeMeasureSpec2;
        int baseline;
        int iMax;
        int iMax2;
        int iMakeMeasureSpec3;
        int i;
        if (constraintWidget == null) {
            return;
        }
        if (constraintWidget.getVisibility() == 8 && !constraintWidget.isInPlaceholder()) {
            basicMeasure$Measure.measuredWidth = 0;
            basicMeasure$Measure.measuredHeight = 0;
            basicMeasure$Measure.measuredBaseline = 0;
            return;
        }
        if (constraintWidget.getParent() == null) {
            return;
        }
        ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour = basicMeasure$Measure.horizontalBehavior;
        ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour2 = basicMeasure$Measure.verticalBehavior;
        int i2 = basicMeasure$Measure.horizontalDimension;
        int i3 = basicMeasure$Measure.verticalDimension;
        int i4 = this.paddingTop + this.paddingBottom;
        int i5 = this.paddingWidth;
        View view = (View) constraintWidget.getCompanionWidget();
        int iOrdinal = constraintWidget$DimensionBehaviour.ordinal();
        if (iOrdinal == 0) {
            iMakeMeasureSpec = View$MeasureSpec.makeMeasureSpec(i2, BasicMeasure.EXACTLY);
        } else if (iOrdinal == 1) {
            iMakeMeasureSpec = ViewGroup.getChildMeasureSpec(this.layoutWidthSpec, i5, -2);
        } else if (iOrdinal != 2) {
            iMakeMeasureSpec = iOrdinal != 3 ? 0 : ViewGroup.getChildMeasureSpec(this.layoutWidthSpec, constraintWidget.getHorizontalMargin() + i5, -1);
        } else {
            iMakeMeasureSpec = ViewGroup.getChildMeasureSpec(this.layoutWidthSpec, i5, -2);
            boolean z2 = constraintWidget.mMatchConstraintDefaultWidth == 1;
            int i6 = basicMeasure$Measure.measureStrategy;
            if (i6 == BasicMeasure$Measure.TRY_GIVEN_DIMENSIONS || i6 == BasicMeasure$Measure.USE_GIVEN_DIMENSIONS) {
                if (basicMeasure$Measure.measureStrategy == BasicMeasure$Measure.USE_GIVEN_DIMENSIONS || !z2 || (z2 && (view.getMeasuredHeight() == constraintWidget.getHeight())) || (view instanceof Placeholder) || constraintWidget.isResolvedHorizontally()) {
                    iMakeMeasureSpec = View$MeasureSpec.makeMeasureSpec(constraintWidget.getWidth(), BasicMeasure.EXACTLY);
                }
            }
        }
        int iOrdinal2 = constraintWidget$DimensionBehaviour2.ordinal();
        if (iOrdinal2 == 0) {
            iMakeMeasureSpec2 = View$MeasureSpec.makeMeasureSpec(i3, BasicMeasure.EXACTLY);
        } else if (iOrdinal2 == 1) {
            iMakeMeasureSpec2 = ViewGroup.getChildMeasureSpec(this.layoutHeightSpec, i4, -2);
        } else if (iOrdinal2 != 2) {
            iMakeMeasureSpec2 = iOrdinal2 != 3 ? 0 : ViewGroup.getChildMeasureSpec(this.layoutHeightSpec, constraintWidget.getVerticalMargin() + i4, -1);
        } else {
            iMakeMeasureSpec2 = ViewGroup.getChildMeasureSpec(this.layoutHeightSpec, i4, -2);
            boolean z3 = constraintWidget.mMatchConstraintDefaultHeight == 1;
            int i7 = basicMeasure$Measure.measureStrategy;
            if (i7 == BasicMeasure$Measure.TRY_GIVEN_DIMENSIONS || i7 == BasicMeasure$Measure.USE_GIVEN_DIMENSIONS) {
                if (basicMeasure$Measure.measureStrategy == BasicMeasure$Measure.USE_GIVEN_DIMENSIONS || !z3 || (z3 && (view.getMeasuredWidth() == constraintWidget.getWidth())) || (view instanceof Placeholder) || constraintWidget.isResolvedVertically()) {
                    iMakeMeasureSpec2 = View$MeasureSpec.makeMeasureSpec(constraintWidget.getHeight(), BasicMeasure.EXACTLY);
                }
            }
        }
        ConstraintWidgetContainer constraintWidgetContainer = (ConstraintWidgetContainer) constraintWidget.getParent();
        if (constraintWidgetContainer != null && Optimizer.enabled(ConstraintLayout.access$000(this.this$0), 256) && view.getMeasuredWidth() == constraintWidget.getWidth() && view.getMeasuredWidth() < constraintWidgetContainer.getWidth() && view.getMeasuredHeight() == constraintWidget.getHeight() && view.getMeasuredHeight() < constraintWidgetContainer.getHeight() && view.getBaseline() == constraintWidget.getBaselineDistance() && !constraintWidget.isMeasureRequested()) {
            if (isSimilarSpec(constraintWidget.getLastHorizontalMeasureSpec(), iMakeMeasureSpec, constraintWidget.getWidth()) && isSimilarSpec(constraintWidget.getLastVerticalMeasureSpec(), iMakeMeasureSpec2, constraintWidget.getHeight())) {
                basicMeasure$Measure.measuredWidth = constraintWidget.getWidth();
                basicMeasure$Measure.measuredHeight = constraintWidget.getHeight();
                basicMeasure$Measure.measuredBaseline = constraintWidget.getBaselineDistance();
                return;
            }
        }
        ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour3 = ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT;
        boolean z4 = constraintWidget$DimensionBehaviour == constraintWidget$DimensionBehaviour3;
        boolean z5 = constraintWidget$DimensionBehaviour2 == constraintWidget$DimensionBehaviour3;
        ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour4 = ConstraintWidget$DimensionBehaviour.MATCH_PARENT;
        boolean z6 = constraintWidget$DimensionBehaviour2 == constraintWidget$DimensionBehaviour4 || constraintWidget$DimensionBehaviour2 == ConstraintWidget$DimensionBehaviour.FIXED;
        boolean z7 = constraintWidget$DimensionBehaviour == constraintWidget$DimensionBehaviour4 || constraintWidget$DimensionBehaviour == ConstraintWidget$DimensionBehaviour.FIXED;
        boolean z8 = z4 && constraintWidget.mDimensionRatio > 0.0f;
        boolean z9 = z5 && constraintWidget.mDimensionRatio > 0.0f;
        if (view == null) {
            return;
        }
        ConstraintLayout$LayoutParams constraintLayout$LayoutParams = (ConstraintLayout$LayoutParams) view.getLayoutParams();
        int i8 = basicMeasure$Measure.measureStrategy;
        if (i8 != BasicMeasure$Measure.TRY_GIVEN_DIMENSIONS && i8 != BasicMeasure$Measure.USE_GIVEN_DIMENSIONS && z4 && constraintWidget.mMatchConstraintDefaultWidth == 0 && z5 && constraintWidget.mMatchConstraintDefaultHeight == 0) {
            i = -1;
            iMax2 = 0;
            baseline = 0;
            iMax = 0;
        } else {
            if ((view instanceof VirtualLayout) && (constraintWidget instanceof androidx.constraintlayout.solver.widgets.VirtualLayout)) {
                ((VirtualLayout) view).onMeasure((androidx.constraintlayout.solver.widgets.VirtualLayout) constraintWidget, iMakeMeasureSpec, iMakeMeasureSpec2);
            } else {
                view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
            }
            constraintWidget.setLastMeasureSpec(iMakeMeasureSpec, iMakeMeasureSpec2);
            int measuredWidth = view.getMeasuredWidth();
            int measuredHeight = view.getMeasuredHeight();
            baseline = view.getBaseline();
            int i9 = constraintWidget.mMatchConstraintMinWidth;
            iMax = i9 > 0 ? Math.max(i9, measuredWidth) : measuredWidth;
            int i10 = constraintWidget.mMatchConstraintMaxWidth;
            if (i10 > 0) {
                iMax = Math.min(i10, iMax);
            }
            int i11 = constraintWidget.mMatchConstraintMinHeight;
            iMax2 = i11 > 0 ? Math.max(i11, measuredHeight) : measuredHeight;
            int i12 = constraintWidget.mMatchConstraintMaxHeight;
            if (i12 > 0) {
                iMax2 = Math.min(i12, iMax2);
            }
            if (!Optimizer.enabled(ConstraintLayout.access$000(this.this$0), 1)) {
                if (z8 && z6) {
                    iMax = (int) ((iMax2 * constraintWidget.mDimensionRatio) + 0.5f);
                } else if (z9 && z7) {
                    iMax2 = (int) ((iMax / constraintWidget.mDimensionRatio) + 0.5f);
                }
            }
            if (measuredWidth != iMax || measuredHeight != iMax2) {
                if (measuredWidth != iMax) {
                    iMakeMeasureSpec3 = View$MeasureSpec.makeMeasureSpec(iMax, BasicMeasure.EXACTLY);
                }
                if (measuredHeight != iMax2) {
                    iMakeMeasureSpec3 = iMakeMeasureSpec;
                    iMakeMeasureSpec2 = View$MeasureSpec.makeMeasureSpec(iMax2, BasicMeasure.EXACTLY);
                }
                iMakeMeasureSpec3 = iMakeMeasureSpec;
                view.measure(iMakeMeasureSpec3, iMakeMeasureSpec2);
                constraintWidget.setLastMeasureSpec(iMakeMeasureSpec3, iMakeMeasureSpec2);
                iMax = view.getMeasuredWidth();
                iMax2 = view.getMeasuredHeight();
                baseline = view.getBaseline();
            }
            i = -1;
        }
        boolean z10 = baseline != i;
        basicMeasure$Measure.measuredNeedsSolverPass = (iMax == basicMeasure$Measure.horizontalDimension && iMax2 == basicMeasure$Measure.verticalDimension) ? false : true;
        if (constraintLayout$LayoutParams.needsBaseline) {
            z10 = true;
        }
        if (z10 && baseline != -1 && constraintWidget.getBaselineDistance() != baseline) {
            basicMeasure$Measure.measuredNeedsSolverPass = true;
        }
        basicMeasure$Measure.measuredWidth = iMax;
        basicMeasure$Measure.measuredHeight = iMax2;
        basicMeasure$Measure.measuredHasBaseline = z10;
        basicMeasure$Measure.measuredBaseline = baseline;
    }
}
