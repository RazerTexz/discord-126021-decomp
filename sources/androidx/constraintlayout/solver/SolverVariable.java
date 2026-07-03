package androidx.constraintlayout.solver;

import androidx.exifinterface.media.ExifInterface;
import java.util.Arrays;
import java.util.HashSet;
import p007b.p100d.p104b.p105a.C1643a;

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

    /* JADX INFO: renamed from: id */
    public int f110id;
    public boolean inGoal;
    public HashSet<ArrayRow> inRows;
    public boolean isFinalValue;
    public boolean isSynonym;
    public ArrayRow[] mClientEquations;
    public int mClientEquationsCount;
    private String mName;
    public Type mType;
    public int strength;
    public float[] strengthVector;
    public int synonym;
    public float synonymDelta;
    public int usageInRowCount;

    /* JADX INFO: renamed from: androidx.constraintlayout.solver.SolverVariable$1 */
    public static /* synthetic */ class C01831 {
        public static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$solver$SolverVariable$Type;

        static {
            Type.values();
            int[] iArr = new int[5];
            $SwitchMap$androidx$constraintlayout$solver$SolverVariable$Type = iArr;
            try {
                iArr[Type.UNRESTRICTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$SolverVariable$Type[Type.CONSTANT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$SolverVariable$Type[Type.SLACK.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$SolverVariable$Type[Type.ERROR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$SolverVariable$Type[Type.UNKNOWN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public enum Type {
        UNRESTRICTED,
        CONSTANT,
        SLACK,
        ERROR,
        UNKNOWN
    }

    public SolverVariable(String str, Type type) {
        this.f110id = -1;
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
        this.mType = type;
    }

    private static String getUniqueName(Type type, String str) {
        if (str != null) {
            StringBuilder sbM833U = C1643a.m833U(str);
            sbM833U.append(uniqueErrorId);
            return sbM833U.toString();
        }
        int iOrdinal = type.ordinal();
        if (iOrdinal == 0) {
            StringBuilder sbM833U2 = C1643a.m833U("U");
            int i = uniqueUnrestrictedId + 1;
            uniqueUnrestrictedId = i;
            sbM833U2.append(i);
            return sbM833U2.toString();
        }
        if (iOrdinal == 1) {
            StringBuilder sbM833U3 = C1643a.m833U("C");
            int i2 = uniqueConstantId + 1;
            uniqueConstantId = i2;
            sbM833U3.append(i2);
            return sbM833U3.toString();
        }
        if (iOrdinal == 2) {
            StringBuilder sbM833U4 = C1643a.m833U(ExifInterface.LATITUDE_SOUTH);
            int i3 = uniqueSlackId + 1;
            uniqueSlackId = i3;
            sbM833U4.append(i3);
            return sbM833U4.toString();
        }
        if (iOrdinal == 3) {
            StringBuilder sbM833U5 = C1643a.m833U("e");
            int i4 = uniqueErrorId + 1;
            uniqueErrorId = i4;
            sbM833U5.append(i4);
            return sbM833U5.toString();
        }
        if (iOrdinal != 4) {
            throw new AssertionError(type.name());
        }
        StringBuilder sbM833U6 = C1643a.m833U(ExifInterface.GPS_MEASUREMENT_INTERRUPTED);
        int i5 = uniqueId + 1;
        uniqueId = i5;
        sbM833U6.append(i5);
        return sbM833U6.toString();
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
        this.mType = Type.UNKNOWN;
        this.strength = 0;
        this.f110id = -1;
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
        this.synonym = solverVariable.f110id;
        this.synonymDelta = f;
        int i = this.mClientEquationsCount;
        this.definitionId = -1;
        for (int i2 = 0; i2 < i; i2++) {
            this.mClientEquations[i2].updateFromSynonymVariable(linearSystem, this, false);
        }
        this.mClientEquationsCount = 0;
        linearSystem.displayReadableRows();
    }

    public void setType(Type type, String str) {
        this.mType = type;
    }

    public String strengthsToString() {
        String strM883w = this + "[";
        int i = 0;
        boolean z2 = false;
        boolean z3 = true;
        while (i < this.strengthVector.length) {
            StringBuilder sbM833U = C1643a.m833U(strM883w);
            sbM833U.append(this.strengthVector[i]);
            String string = sbM833U.toString();
            float[] fArr = this.strengthVector;
            if (fArr[i] > 0.0f) {
                z2 = false;
            } else if (fArr[i] < 0.0f) {
                z2 = true;
            }
            if (fArr[i] != 0.0f) {
                z3 = false;
            }
            strM883w = i < fArr.length + (-1) ? C1643a.m883w(string, ", ") : C1643a.m883w(string, "] ");
            i++;
        }
        if (z2) {
            strM883w = C1643a.m883w(strM883w, " (-)");
        }
        return z3 ? C1643a.m883w(strM883w, " (*)") : strM883w;
    }

    public String toString() {
        if (this.mName != null) {
            StringBuilder sbM833U = C1643a.m833U("");
            sbM833U.append(this.mName);
            return sbM833U.toString();
        }
        StringBuilder sbM833U2 = C1643a.m833U("");
        sbM833U2.append(this.f110id);
        return sbM833U2.toString();
    }

    public final void updateReferencesWithNewDefinition(LinearSystem linearSystem, ArrayRow arrayRow) {
        int i = this.mClientEquationsCount;
        for (int i2 = 0; i2 < i; i2++) {
            this.mClientEquations[i2].updateFromRow(linearSystem, arrayRow, false);
        }
        this.mClientEquationsCount = 0;
    }

    public SolverVariable(Type type, String str) {
        this.f110id = -1;
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
        this.mType = type;
    }
}
