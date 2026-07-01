package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour;

/* JADX INFO: loaded from: classes.dex */
public class BasicMeasure$Measure {
    public static int SELF_DIMENSIONS = 0;
    public static int TRY_GIVEN_DIMENSIONS = 1;
    public static int USE_GIVEN_DIMENSIONS = 2;
    public ConstraintWidget$DimensionBehaviour horizontalBehavior;
    public int horizontalDimension;
    public int measureStrategy;
    public int measuredBaseline;
    public boolean measuredHasBaseline;
    public int measuredHeight;
    public boolean measuredNeedsSolverPass;
    public int measuredWidth;
    public ConstraintWidget$DimensionBehaviour verticalBehavior;
    public int verticalDimension;
}
