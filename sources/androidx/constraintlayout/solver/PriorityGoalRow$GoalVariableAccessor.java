package androidx.constraintlayout.solver;

import b.d.b.a.a;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class PriorityGoalRow$GoalVariableAccessor implements Comparable {
    public PriorityGoalRow row;
    public final /* synthetic */ PriorityGoalRow this$0;
    public SolverVariable variable;

    public PriorityGoalRow$GoalVariableAccessor(PriorityGoalRow priorityGoalRow, PriorityGoalRow priorityGoalRow2) {
        this.this$0 = priorityGoalRow;
        this.row = priorityGoalRow2;
    }

    public void add(SolverVariable solverVariable) {
        for (int i = 0; i < 9; i++) {
            float[] fArr = this.variable.goalStrengthVector;
            fArr[i] = fArr[i] + solverVariable.goalStrengthVector[i];
            if (Math.abs(fArr[i]) < 1.0E-4f) {
                this.variable.goalStrengthVector[i] = 0.0f;
            }
        }
    }

    public boolean addToGoal(SolverVariable solverVariable, float f) {
        boolean z2 = true;
        if (!this.variable.inGoal) {
            for (int i = 0; i < 9; i++) {
                float f2 = solverVariable.goalStrengthVector[i];
                if (f2 != 0.0f) {
                    float f3 = f2 * f;
                    if (Math.abs(f3) < 1.0E-4f) {
                        f3 = 0.0f;
                    }
                    this.variable.goalStrengthVector[i] = f3;
                } else {
                    this.variable.goalStrengthVector[i] = 0.0f;
                }
            }
            return true;
        }
        for (int i2 = 0; i2 < 9; i2++) {
            float[] fArr = this.variable.goalStrengthVector;
            fArr[i2] = (solverVariable.goalStrengthVector[i2] * f) + fArr[i2];
            if (Math.abs(fArr[i2]) < 1.0E-4f) {
                this.variable.goalStrengthVector[i2] = 0.0f;
            } else {
                z2 = false;
            }
        }
        if (z2) {
            PriorityGoalRow.access$000(this.this$0, this.variable);
        }
        return false;
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        return this.variable.f30id - ((SolverVariable) obj).f30id;
    }

    public void init(SolverVariable solverVariable) {
        this.variable = solverVariable;
    }

    public final boolean isNegative() {
        for (int i = 8; i >= 0; i--) {
            float f = this.variable.goalStrengthVector[i];
            if (f > 0.0f) {
                return false;
            }
            if (f < 0.0f) {
                return true;
            }
        }
        return false;
    }

    public final boolean isNull() {
        for (int i = 0; i < 9; i++) {
            if (this.variable.goalStrengthVector[i] != 0.0f) {
                return false;
            }
        }
        return true;
    }

    public final boolean isSmallerThan(SolverVariable solverVariable) {
        for (int i = 8; i >= 0; i--) {
            float f = solverVariable.goalStrengthVector[i];
            float f2 = this.variable.goalStrengthVector[i];
            if (f2 != f) {
                if (f2 < f) {
                    return true;
                }
            }
        }
        return false;
    }

    public void reset() {
        Arrays.fill(this.variable.goalStrengthVector, 0.0f);
    }

    public String toString() {
        String string = "[ ";
        if (this.variable != null) {
            for (int i = 0; i < 9; i++) {
                StringBuilder sbU = a.U(string);
                sbU.append(this.variable.goalStrengthVector[i]);
                sbU.append(" ");
                string = sbU.toString();
            }
        }
        StringBuilder sbX = a.X(string, "] ");
        sbX.append(this.variable);
        return sbX.toString();
    }
}
