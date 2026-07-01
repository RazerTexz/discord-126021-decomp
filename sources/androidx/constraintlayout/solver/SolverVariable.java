package androidx.constraintlayout.solver;

import androidx.exifinterface.media.ExifInterface;
import b.d.b.a.a;
import java.util.Arrays;
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
public class SolverVariable {
    private static final boolean INTERNAL_DEBUG = false;
    public static final int MAX_STRENGTH = 9;
    public static final int STRENGTH_BARRIER = 6;
    public static final int STRENGTH_CENTERING = 7;
    public static final int STRENGTH_EQUALITY = 5;
    public static final int STRENGTH_FIXED = 8;
    public static final int STRENGTH_HIGH = 3;
    public static final int STRENGTH_HIGHEST = 4;
    public static final int STRENGTH_LOW = 1;
    public static final int STRENGTH_MEDIUM = 2;
    public static final int STRENGTH_NONE = 0;
    private static final boolean VAR_USE_HASH = false;
    private static int uniqueConstantId = 1;
    private static int uniqueErrorId = 1;
    private static int uniqueId = 1;
    private static int uniqueSlackId = 1;
    private static int uniqueUnrestrictedId = 1;
    public float computedValue;
    public int definitionId;
    public float[] goalStrengthVector;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public int f30id;
    public boolean inGoal;
    public HashSet<ArrayRow> inRows;
    public boolean isFinalValue;
    public boolean isSynonym;
    public ArrayRow[] mClientEquations;
    public int mClientEquationsCount;
    private String mName;
    public SolverVariable$Type mType;
    public int strength;
    public float[] strengthVector;
    public int synonym;
    public float synonymDelta;
    public int usageInRowCount;

    public SolverVariable(String str, SolverVariable$Type solverVariable$Type) {
        this.f30id = -1;
        this.definitionId = -1;
        this.strength = 0;
        this.isFinalValue = false;
        this.strengthVector = new float[9];
        this.goalStrengthVector = new float[9];
        this.mClientEquations = new ArrayRow[16];
        this.mClientEquationsCount = 0;
        this.usageInRowCount = 0;
        this.isSynonym = false;
        this.synonym = -1;
        this.synonymDelta = 0.0f;
        this.inRows = null;
        this.mName = str;
        this.mType = solverVariable$Type;
    }

    private static String getUniqueName(SolverVariable$Type solverVariable$Type, String str) {
        if (str != null) {
            StringBuilder sbU = a.U(str);
            sbU.append(uniqueErrorId);
            return sbU.toString();
        }
        int iOrdinal = solverVariable$Type.ordinal();
        if (iOrdinal == 0) {
            StringBuilder sbU2 = a.U("U");
            int i = uniqueUnrestrictedId + 1;
            uniqueUnrestrictedId = i;
            sbU2.append(i);
            return sbU2.toString();
        }
        if (iOrdinal == 1) {
            StringBuilder sbU3 = a.U("C");
            int i2 = uniqueConstantId + 1;
            uniqueConstantId = i2;
            sbU3.append(i2);
            return sbU3.toString();
        }
        if (iOrdinal == 2) {
            StringBuilder sbU4 = a.U(ExifInterface.LATITUDE_SOUTH);
            int i3 = uniqueSlackId + 1;
            uniqueSlackId = i3;
            sbU4.append(i3);
            return sbU4.toString();
        }
        if (iOrdinal == 3) {
            StringBuilder sbU5 = a.U("e");
            int i4 = uniqueErrorId + 1;
            uniqueErrorId = i4;
            sbU5.append(i4);
            return sbU5.toString();
        }
        if (iOrdinal != 4) {
            throw new AssertionError(solverVariable$Type.name());
        }
        StringBuilder sbU6 = a.U(ExifInterface.GPS_MEASUREMENT_INTERRUPTED);
        int i5 = uniqueId + 1;
        uniqueId = i5;
        sbU6.append(i5);
        return sbU6.toString();
    }

    public static void increaseErrorId() {
        uniqueErrorId++;
    }

    public final void addToRow(ArrayRow arrayRow) {
        int i = 0;
        while (true) {
            int i2 = this.mClientEquationsCount;
            if (i >= i2) {
                ArrayRow[] arrayRowArr = this.mClientEquations;
                if (i2 >= arrayRowArr.length) {
                    this.mClientEquations = (ArrayRow[]) Arrays.copyOf(arrayRowArr, arrayRowArr.length * 2);
                }
                ArrayRow[] arrayRowArr2 = this.mClientEquations;
                int i3 = this.mClientEquationsCount;
                arrayRowArr2[i3] = arrayRow;
                this.mClientEquationsCount = i3 + 1;
                return;
            }
            if (this.mClientEquations[i] == arrayRow) {
                return;
            } else {
                i++;
            }
        }
    }

    public void clearStrengths() {
        for (int i = 0; i < 9; i++) {
            this.strengthVector[i] = 0.0f;
        }
    }

    public String getName() {
        return this.mName;
    }

    public final void removeFromRow(ArrayRow arrayRow) {
        int i = this.mClientEquationsCount;
        int i2 = 0;
        while (i2 < i) {
            if (this.mClientEquations[i2] == arrayRow) {
                while (i2 < i - 1) {
                    ArrayRow[] arrayRowArr = this.mClientEquations;
                    int i3 = i2 + 1;
                    arrayRowArr[i2] = arrayRowArr[i3];
                    i2 = i3;
                }
                this.mClientEquationsCount--;
                return;
            }
            i2++;
        }
    }

    public void reset() {
        this.mName = null;
        this.mType = SolverVariable$Type.UNKNOWN;
        this.strength = 0;
        this.f30id = -1;
        this.definitionId = -1;
        this.computedValue = 0.0f;
        this.isFinalValue = false;
        this.isSynonym = false;
        this.synonym = -1;
        this.synonymDelta = 0.0f;
        int i = this.mClientEquationsCount;
        for (int i2 = 0; i2 < i; i2++) {
            this.mClientEquations[i2] = null;
        }
        this.mClientEquationsCount = 0;
        this.usageInRowCount = 0;
        this.inGoal = false;
        Arrays.fill(this.goalStrengthVector, 0.0f);
    }

    public void setFinalValue(LinearSystem linearSystem, float f) {
        this.computedValue = f;
        this.isFinalValue = true;
        this.isSynonym = false;
        this.synonym = -1;
        this.synonymDelta = 0.0f;
        int i = this.mClientEquationsCount;
        this.definitionId = -1;
        for (int i2 = 0; i2 < i; i2++) {
            this.mClientEquations[i2].updateFromFinalVariable(linearSystem, this, false);
        }
        this.mClientEquationsCount = 0;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public void setSynonym(LinearSystem linearSystem, SolverVariable solverVariable, float f) {
        this.isSynonym = true;
        this.synonym = solverVariable.f30id;
        this.synonymDelta = f;
        int i = this.mClientEquationsCount;
        this.definitionId = -1;
        for (int i2 = 0; i2 < i; i2++) {
            this.mClientEquations[i2].updateFromSynonymVariable(linearSystem, this, false);
        }
        this.mClientEquationsCount = 0;
        linearSystem.displayReadableRows();
    }

    public void setType(SolverVariable$Type solverVariable$Type, String str) {
        this.mType = solverVariable$Type;
    }

    public String strengthsToString() {
        String strW = this + "[";
        int i = 0;
        boolean z2 = false;
        boolean z3 = true;
        while (i < this.strengthVector.length) {
            StringBuilder sbU = a.U(strW);
            sbU.append(this.strengthVector[i]);
            String string = sbU.toString();
            float[] fArr = this.strengthVector;
            if (fArr[i] > 0.0f) {
                z2 = false;
            } else if (fArr[i] < 0.0f) {
                z2 = true;
            }
            if (fArr[i] != 0.0f) {
                z3 = false;
            }
            strW = i < fArr.length + (-1) ? a.w(string, ", ") : a.w(string, "] ");
            i++;
        }
        if (z2) {
            strW = a.w(strW, " (-)");
        }
        return z3 ? a.w(strW, " (*)") : strW;
    }

    public String toString() {
        if (this.mName != null) {
            StringBuilder sbU = a.U("");
            sbU.append(this.mName);
            return sbU.toString();
        }
        StringBuilder sbU2 = a.U("");
        sbU2.append(this.f30id);
        return sbU2.toString();
    }

    public final void updateReferencesWithNewDefinition(LinearSystem linearSystem, ArrayRow arrayRow) {
        int i = this.mClientEquationsCount;
        for (int i2 = 0; i2 < i; i2++) {
            this.mClientEquations[i2].updateFromRow(linearSystem, arrayRow, false);
        }
        this.mClientEquationsCount = 0;
    }

    public SolverVariable(SolverVariable$Type solverVariable$Type, String str) {
        this.f30id = -1;
        this.definitionId = -1;
        this.strength = 0;
        this.isFinalValue = false;
        this.strengthVector = new float[9];
        this.goalStrengthVector = new float[9];
        this.mClientEquations = new ArrayRow[16];
        this.mClientEquationsCount = 0;
        this.usageInRowCount = 0;
        this.isSynonym = false;
        this.synonym = -1;
        this.synonymDelta = 0.0f;
        this.inRows = null;
        this.mType = solverVariable$Type;
    }
}
