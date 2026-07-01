package androidx.constraintlayout.solver.state;

/* JADX INFO: loaded from: classes.dex */
public /* synthetic */ class State$1 {
    public static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$solver$state$State$Helper;

    static {
        State$Helper.values();
        int[] iArr = new int[7];
        $SwitchMap$androidx$constraintlayout$solver$state$State$Helper = iArr;
        try {
            iArr[State$Helper.HORIZONTAL_CHAIN.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            $SwitchMap$androidx$constraintlayout$solver$state$State$Helper[State$Helper.VERTICAL_CHAIN.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            $SwitchMap$androidx$constraintlayout$solver$state$State$Helper[State$Helper.ALIGN_HORIZONTALLY.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            $SwitchMap$androidx$constraintlayout$solver$state$State$Helper[State$Helper.ALIGN_VERTICALLY.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            $SwitchMap$androidx$constraintlayout$solver$state$State$Helper[State$Helper.BARRIER.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
    }
}
