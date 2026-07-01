package androidx.constraintlayout.solver;

/* JADX INFO: loaded from: classes.dex */
public /* synthetic */ class SolverVariable$1 {
    public static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$solver$SolverVariable$Type;

    static {
        SolverVariable$Type.values();
        int[] iArr = new int[5];
        $SwitchMap$androidx$constraintlayout$solver$SolverVariable$Type = iArr;
        try {
            iArr[SolverVariable$Type.UNRESTRICTED.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            $SwitchMap$androidx$constraintlayout$solver$SolverVariable$Type[SolverVariable$Type.CONSTANT.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            $SwitchMap$androidx$constraintlayout$solver$SolverVariable$Type[SolverVariable$Type.SLACK.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            $SwitchMap$androidx$constraintlayout$solver$SolverVariable$Type[SolverVariable$Type.ERROR.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            $SwitchMap$androidx$constraintlayout$solver$SolverVariable$Type[SolverVariable$Type.UNKNOWN.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
    }
}
