package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public class WidgetGroup$MeasureResult {
    public int baseline;
    public int bottom;
    public int left;
    public int orientation;
    public int right;
    public final /* synthetic */ WidgetGroup this$0;
    public int top;
    public WeakReference<ConstraintWidget> widgetRef;

    public WidgetGroup$MeasureResult(WidgetGroup widgetGroup, ConstraintWidget constraintWidget, LinearSystem linearSystem, int i) {
        this.this$0 = widgetGroup;
        this.widgetRef = new WeakReference<>(constraintWidget);
        this.left = linearSystem.getObjectVariableValue(constraintWidget.mLeft);
        this.top = linearSystem.getObjectVariableValue(constraintWidget.mTop);
        this.right = linearSystem.getObjectVariableValue(constraintWidget.mRight);
        this.bottom = linearSystem.getObjectVariableValue(constraintWidget.mBottom);
        this.baseline = linearSystem.getObjectVariableValue(constraintWidget.mBaseline);
        this.orientation = i;
    }

    public void apply() {
        ConstraintWidget constraintWidget = this.widgetRef.get();
        if (constraintWidget != null) {
            constraintWidget.setFinalFrame(this.left, this.top, this.right, this.bottom, this.baseline, this.orientation);
        }
    }
}
