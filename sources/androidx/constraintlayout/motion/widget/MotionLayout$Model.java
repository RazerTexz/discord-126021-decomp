package androidx.constraintlayout.motion.widget;

import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.View$MeasureSpec;
import android.view.ViewGroup$LayoutParams;
import android.widget.TextView;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.solver.widgets.Flow;
import androidx.constraintlayout.solver.widgets.Guideline;
import androidx.constraintlayout.solver.widgets.Helper;
import androidx.constraintlayout.solver.widgets.HelperWidget;
import androidx.constraintlayout.solver.widgets.VirtualLayout;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout$LayoutParams;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.Constraints$LayoutParams;
import androidx.exifinterface.media.ExifInterface;
import b.d.b.a.a;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class MotionLayout$Model {
    public int mEndId;
    public int mStartId;
    public final /* synthetic */ MotionLayout this$0;
    public ConstraintWidgetContainer mLayoutStart = new ConstraintWidgetContainer();
    public ConstraintWidgetContainer mLayoutEnd = new ConstraintWidgetContainer();
    public ConstraintSet mStart = null;
    public ConstraintSet mEnd = null;

    public MotionLayout$Model(MotionLayout motionLayout) {
        this.this$0 = motionLayout;
    }

    private void debugLayout(String str, ConstraintWidgetContainer constraintWidgetContainer) {
        View view = (View) constraintWidgetContainer.getCompanionWidget();
        StringBuilder sbX = a.X(str, " ");
        sbX.append(Debug.getName(view));
        String string = sbX.toString();
        Log.v(MotionLayout.TAG, string + "  ========= " + constraintWidgetContainer);
        int size = constraintWidgetContainer.getChildren().size();
        for (int i = 0; i < size; i++) {
            String str2 = string + "[" + i + "] ";
            ConstraintWidget constraintWidget = constraintWidgetContainer.getChildren().get(i);
            StringBuilder sbU = a.U("");
            sbU.append(constraintWidget.mTop.mTarget != null ? ExifInterface.GPS_DIRECTION_TRUE : "_");
            StringBuilder sbU2 = a.U(sbU.toString());
            sbU2.append(constraintWidget.mBottom.mTarget != null ? "B" : "_");
            StringBuilder sbU3 = a.U(sbU2.toString());
            sbU3.append(constraintWidget.mLeft.mTarget != null ? "L" : "_");
            StringBuilder sbU4 = a.U(sbU3.toString());
            sbU4.append(constraintWidget.mRight.mTarget != null ? "R" : "_");
            String string2 = sbU4.toString();
            View view2 = (View) constraintWidget.getCompanionWidget();
            String name = Debug.getName(view2);
            if (view2 instanceof TextView) {
                StringBuilder sbX2 = a.X(name, "(");
                sbX2.append((Object) ((TextView) view2).getText());
                sbX2.append(")");
                name = sbX2.toString();
            }
            Log.v(MotionLayout.TAG, str2 + "  " + name + " " + constraintWidget + " " + string2);
        }
        Log.v(MotionLayout.TAG, string + " done. ");
    }

    private void debugLayoutParam(String str, ConstraintLayout$LayoutParams constraintLayout$LayoutParams) {
        StringBuilder sbU = a.U(" ");
        sbU.append(constraintLayout$LayoutParams.startToStart != -1 ? "SS" : "__");
        StringBuilder sbU2 = a.U(sbU.toString());
        sbU2.append(constraintLayout$LayoutParams.startToEnd != -1 ? "|SE" : "|__");
        StringBuilder sbU3 = a.U(sbU2.toString());
        sbU3.append(constraintLayout$LayoutParams.endToStart != -1 ? "|ES" : "|__");
        StringBuilder sbU4 = a.U(sbU3.toString());
        sbU4.append(constraintLayout$LayoutParams.endToEnd != -1 ? "|EE" : "|__");
        StringBuilder sbU5 = a.U(sbU4.toString());
        sbU5.append(constraintLayout$LayoutParams.leftToLeft != -1 ? "|LL" : "|__");
        StringBuilder sbU6 = a.U(sbU5.toString());
        sbU6.append(constraintLayout$LayoutParams.leftToRight != -1 ? "|LR" : "|__");
        StringBuilder sbU7 = a.U(sbU6.toString());
        sbU7.append(constraintLayout$LayoutParams.rightToLeft != -1 ? "|RL" : "|__");
        StringBuilder sbU8 = a.U(sbU7.toString());
        sbU8.append(constraintLayout$LayoutParams.rightToRight != -1 ? "|RR" : "|__");
        StringBuilder sbU9 = a.U(sbU8.toString());
        sbU9.append(constraintLayout$LayoutParams.topToTop != -1 ? "|TT" : "|__");
        StringBuilder sbU10 = a.U(sbU9.toString());
        sbU10.append(constraintLayout$LayoutParams.topToBottom != -1 ? "|TB" : "|__");
        StringBuilder sbU11 = a.U(sbU10.toString());
        sbU11.append(constraintLayout$LayoutParams.bottomToTop != -1 ? "|BT" : "|__");
        StringBuilder sbU12 = a.U(sbU11.toString());
        sbU12.append(constraintLayout$LayoutParams.bottomToBottom != -1 ? "|BB" : "|__");
        Log.v(MotionLayout.TAG, str + sbU12.toString());
    }

    private void debugWidget(String str, ConstraintWidget constraintWidget) {
        String string;
        String string2;
        String string3;
        StringBuilder sbU = a.U(" ");
        String string4 = "__";
        if (constraintWidget.mTop.mTarget != null) {
            StringBuilder sbU2 = a.U(ExifInterface.GPS_DIRECTION_TRUE);
            sbU2.append(constraintWidget.mTop.mTarget.mType == ConstraintAnchor$Type.TOP ? ExifInterface.GPS_DIRECTION_TRUE : "B");
            string = sbU2.toString();
        } else {
            string = "__";
        }
        sbU.append(string);
        StringBuilder sbU3 = a.U(sbU.toString());
        if (constraintWidget.mBottom.mTarget != null) {
            StringBuilder sbU4 = a.U("B");
            sbU4.append(constraintWidget.mBottom.mTarget.mType == ConstraintAnchor$Type.TOP ? ExifInterface.GPS_DIRECTION_TRUE : "B");
            string2 = sbU4.toString();
        } else {
            string2 = "__";
        }
        sbU3.append(string2);
        StringBuilder sbU5 = a.U(sbU3.toString());
        if (constraintWidget.mLeft.mTarget != null) {
            StringBuilder sbU6 = a.U("L");
            sbU6.append(constraintWidget.mLeft.mTarget.mType == ConstraintAnchor$Type.LEFT ? "L" : "R");
            string3 = sbU6.toString();
        } else {
            string3 = "__";
        }
        sbU5.append(string3);
        StringBuilder sbU7 = a.U(sbU5.toString());
        if (constraintWidget.mRight.mTarget != null) {
            StringBuilder sbU8 = a.U("R");
            sbU8.append(constraintWidget.mRight.mTarget.mType == ConstraintAnchor$Type.LEFT ? "L" : "R");
            string4 = sbU8.toString();
        }
        sbU7.append(string4);
        Log.v(MotionLayout.TAG, str + sbU7.toString() + " ---  " + constraintWidget);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void setupConstraintWidget(ConstraintWidgetContainer constraintWidgetContainer, ConstraintSet constraintSet) {
        SparseArray<ConstraintWidget> sparseArray = new SparseArray<>();
        Constraints$LayoutParams constraints$LayoutParams = new Constraints$LayoutParams(-2, -2);
        sparseArray.clear();
        sparseArray.put(0, constraintWidgetContainer);
        sparseArray.put(this.this$0.getId(), constraintWidgetContainer);
        for (ConstraintWidget constraintWidget : constraintWidgetContainer.getChildren()) {
            sparseArray.put(((View) constraintWidget.getCompanionWidget()).getId(), constraintWidget);
        }
        for (ConstraintWidget constraintWidget2 : constraintWidgetContainer.getChildren()) {
            View view = (View) constraintWidget2.getCompanionWidget();
            constraintSet.applyToLayoutParams(view.getId(), constraints$LayoutParams);
            constraintWidget2.setWidth(constraintSet.getWidth(view.getId()));
            constraintWidget2.setHeight(constraintSet.getHeight(view.getId()));
            if (view instanceof ConstraintHelper) {
                constraintSet.applyToHelper((ConstraintHelper) view, constraintWidget2, constraints$LayoutParams, sparseArray);
                if (view instanceof Barrier) {
                    ((Barrier) view).validateParams();
                }
            }
            constraints$LayoutParams.resolveLayoutDirection(this.this$0.getLayoutDirection());
            MotionLayout.access$800(this.this$0, false, view, constraintWidget2, constraints$LayoutParams, sparseArray);
            if (constraintSet.getVisibilityMode(view.getId()) == 1) {
                constraintWidget2.setVisibility(view.getVisibility());
            } else {
                constraintWidget2.setVisibility(constraintSet.getVisibility(view.getId()));
            }
        }
        for (ConstraintWidget constraintWidget3 : constraintWidgetContainer.getChildren()) {
            if (constraintWidget3 instanceof VirtualLayout) {
                ConstraintHelper constraintHelper = (ConstraintHelper) constraintWidget3.getCompanionWidget();
                Helper helper = (Helper) constraintWidget3;
                constraintHelper.updatePreLayout(constraintWidgetContainer, helper, sparseArray);
                ((VirtualLayout) helper).captureWidgets();
            }
        }
    }

    public void build() {
        int childCount = this.this$0.getChildCount();
        this.this$0.mFrameArrayList.clear();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.this$0.getChildAt(i);
            this.this$0.mFrameArrayList.put(childAt, new MotionController(childAt));
        }
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt2 = this.this$0.getChildAt(i2);
            MotionController motionController = this.this$0.mFrameArrayList.get(childAt2);
            if (motionController != null) {
                if (this.mStart != null) {
                    ConstraintWidget widget = getWidget(this.mLayoutStart, childAt2);
                    if (widget != null) {
                        motionController.setStartState(widget, this.mStart);
                    } else if (this.this$0.mDebugPath != 0) {
                        Log.e(MotionLayout.TAG, Debug.getLocation() + "no widget for  " + Debug.getName(childAt2) + " (" + childAt2.getClass().getName() + ")");
                    }
                }
                if (this.mEnd != null) {
                    ConstraintWidget widget2 = getWidget(this.mLayoutEnd, childAt2);
                    if (widget2 != null) {
                        motionController.setEndState(widget2, this.mEnd);
                    } else if (this.this$0.mDebugPath != 0) {
                        Log.e(MotionLayout.TAG, Debug.getLocation() + "no widget for  " + Debug.getName(childAt2) + " (" + childAt2.getClass().getName() + ")");
                    }
                }
            }
        }
    }

    public void copy(ConstraintWidgetContainer constraintWidgetContainer, ConstraintWidgetContainer constraintWidgetContainer2) {
        ConstraintWidget helperWidget;
        ArrayList<ConstraintWidget> children = constraintWidgetContainer.getChildren();
        HashMap<ConstraintWidget, ConstraintWidget> map = new HashMap<>();
        map.put(constraintWidgetContainer, constraintWidgetContainer2);
        constraintWidgetContainer2.getChildren().clear();
        constraintWidgetContainer2.copy(constraintWidgetContainer, map);
        for (ConstraintWidget constraintWidget : children) {
            if (constraintWidget instanceof androidx.constraintlayout.solver.widgets.Barrier) {
                helperWidget = new androidx.constraintlayout.solver.widgets.Barrier();
            } else if (constraintWidget instanceof Guideline) {
                helperWidget = new Guideline();
            } else if (constraintWidget instanceof Flow) {
                helperWidget = new Flow();
            } else {
                helperWidget = constraintWidget instanceof Helper ? new HelperWidget() : new ConstraintWidget();
            }
            constraintWidgetContainer2.add(helperWidget);
            map.put(constraintWidget, helperWidget);
        }
        for (ConstraintWidget constraintWidget2 : children) {
            map.get(constraintWidget2).copy(constraintWidget2, map);
        }
    }

    public ConstraintWidget getWidget(ConstraintWidgetContainer constraintWidgetContainer, View view) {
        if (constraintWidgetContainer.getCompanionWidget() == view) {
            return constraintWidgetContainer;
        }
        ArrayList<ConstraintWidget> children = constraintWidgetContainer.getChildren();
        int size = children.size();
        for (int i = 0; i < size; i++) {
            ConstraintWidget constraintWidget = children.get(i);
            if (constraintWidget.getCompanionWidget() == view) {
                return constraintWidget;
            }
        }
        return null;
    }

    public void initFrom(ConstraintWidgetContainer constraintWidgetContainer, ConstraintSet constraintSet, ConstraintSet constraintSet2) {
        this.mStart = constraintSet;
        this.mEnd = constraintSet2;
        this.mLayoutStart = new ConstraintWidgetContainer();
        this.mLayoutEnd = new ConstraintWidgetContainer();
        this.mLayoutStart.setMeasurer(MotionLayout.access$200(this.this$0).getMeasurer());
        this.mLayoutEnd.setMeasurer(MotionLayout.access$300(this.this$0).getMeasurer());
        this.mLayoutStart.removeAllChildren();
        this.mLayoutEnd.removeAllChildren();
        copy(MotionLayout.access$400(this.this$0), this.mLayoutStart);
        copy(MotionLayout.access$500(this.this$0), this.mLayoutEnd);
        if (this.this$0.mTransitionLastPosition > 0.5d) {
            if (constraintSet != null) {
                setupConstraintWidget(this.mLayoutStart, constraintSet);
            }
            setupConstraintWidget(this.mLayoutEnd, constraintSet2);
        } else {
            setupConstraintWidget(this.mLayoutEnd, constraintSet2);
            if (constraintSet != null) {
                setupConstraintWidget(this.mLayoutStart, constraintSet);
            }
        }
        this.mLayoutStart.setRtl(MotionLayout.access$600(this.this$0));
        this.mLayoutStart.updateHierarchy();
        this.mLayoutEnd.setRtl(MotionLayout.access$700(this.this$0));
        this.mLayoutEnd.updateHierarchy();
        ViewGroup$LayoutParams layoutParams = this.this$0.getLayoutParams();
        if (layoutParams != null) {
            if (layoutParams.width == -2) {
                ConstraintWidgetContainer constraintWidgetContainer2 = this.mLayoutStart;
                ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour = ConstraintWidget$DimensionBehaviour.WRAP_CONTENT;
                constraintWidgetContainer2.setHorizontalDimensionBehaviour(constraintWidget$DimensionBehaviour);
                this.mLayoutEnd.setHorizontalDimensionBehaviour(constraintWidget$DimensionBehaviour);
            }
            if (layoutParams.height == -2) {
                ConstraintWidgetContainer constraintWidgetContainer3 = this.mLayoutStart;
                ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour2 = ConstraintWidget$DimensionBehaviour.WRAP_CONTENT;
                constraintWidgetContainer3.setVerticalDimensionBehaviour(constraintWidget$DimensionBehaviour2);
                this.mLayoutEnd.setVerticalDimensionBehaviour(constraintWidget$DimensionBehaviour2);
            }
        }
    }

    public boolean isNotConfiguredWith(int i, int i2) {
        return (i == this.mStartId && i2 == this.mEndId) ? false : true;
    }

    public void measure(int i, int i2) {
        int mode = View$MeasureSpec.getMode(i);
        int mode2 = View$MeasureSpec.getMode(i2);
        MotionLayout motionLayout = this.this$0;
        motionLayout.mWidthMeasureMode = mode;
        motionLayout.mHeightMeasureMode = mode2;
        int optimizationLevel = motionLayout.getOptimizationLevel();
        MotionLayout motionLayout2 = this.this$0;
        if (motionLayout2.mCurrentState == motionLayout2.getStartState()) {
            MotionLayout.access$1200(this.this$0, this.mLayoutEnd, optimizationLevel, i, i2);
            if (this.mStart != null) {
                MotionLayout.access$1300(this.this$0, this.mLayoutStart, optimizationLevel, i, i2);
            }
        } else {
            if (this.mStart != null) {
                MotionLayout.access$1400(this.this$0, this.mLayoutStart, optimizationLevel, i, i2);
            }
            MotionLayout.access$1500(this.this$0, this.mLayoutEnd, optimizationLevel, i, i2);
        }
        if (((this.this$0.getParent() instanceof MotionLayout) && mode == 1073741824 && mode2 == 1073741824) ? false : true) {
            MotionLayout motionLayout3 = this.this$0;
            motionLayout3.mWidthMeasureMode = mode;
            motionLayout3.mHeightMeasureMode = mode2;
            if (motionLayout3.mCurrentState == motionLayout3.getStartState()) {
                MotionLayout.access$1600(this.this$0, this.mLayoutEnd, optimizationLevel, i, i2);
                if (this.mStart != null) {
                    MotionLayout.access$1700(this.this$0, this.mLayoutStart, optimizationLevel, i, i2);
                }
            } else {
                if (this.mStart != null) {
                    MotionLayout.access$1800(this.this$0, this.mLayoutStart, optimizationLevel, i, i2);
                }
                MotionLayout.access$1900(this.this$0, this.mLayoutEnd, optimizationLevel, i, i2);
            }
            this.this$0.mStartWrapWidth = this.mLayoutStart.getWidth();
            this.this$0.mStartWrapHeight = this.mLayoutStart.getHeight();
            this.this$0.mEndWrapWidth = this.mLayoutEnd.getWidth();
            this.this$0.mEndWrapHeight = this.mLayoutEnd.getHeight();
            MotionLayout motionLayout4 = this.this$0;
            motionLayout4.mMeasureDuringTransition = (motionLayout4.mStartWrapWidth == motionLayout4.mEndWrapWidth && motionLayout4.mStartWrapHeight == motionLayout4.mEndWrapHeight) ? false : true;
        }
        MotionLayout motionLayout5 = this.this$0;
        int i3 = motionLayout5.mStartWrapWidth;
        int i4 = motionLayout5.mStartWrapHeight;
        int i5 = motionLayout5.mWidthMeasureMode;
        if (i5 == Integer.MIN_VALUE || i5 == 0) {
            i3 = (int) ((motionLayout5.mPostInterpolationPosition * (motionLayout5.mEndWrapWidth - i3)) + i3);
        }
        int i6 = motionLayout5.mHeightMeasureMode;
        if (i6 == Integer.MIN_VALUE || i6 == 0) {
            i4 = (int) ((motionLayout5.mPostInterpolationPosition * (motionLayout5.mEndWrapHeight - i4)) + i4);
        }
        MotionLayout.access$2000(this.this$0, i, i2, i3, i4, this.mLayoutStart.isWidthMeasuredTooSmall() || this.mLayoutEnd.isWidthMeasuredTooSmall(), this.mLayoutStart.isHeightMeasuredTooSmall() || this.mLayoutEnd.isHeightMeasuredTooSmall());
    }

    public void reEvaluateState() {
        measure(MotionLayout.access$900(this.this$0), MotionLayout.access$1000(this.this$0));
        MotionLayout.access$1100(this.this$0);
    }

    public void setMeasuredId(int i, int i2) {
        this.mStartId = i;
        this.mEndId = i2;
    }
}
