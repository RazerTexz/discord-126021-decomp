package androidx.constraintlayout.solver.state.helpers;

import androidx.constraintlayout.solver.state.State$Direction;

/* JADX INFO: loaded from: classes.dex */
public /* synthetic */ class BarrierReference$1 {
    public static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$solver$state$State$Direction;

    static {
        State$Direction.values();
        int[] iArr = new int[6];
        $SwitchMap$androidx$constraintlayout$solver$state$State$Direction = iArr;
        try {
            iArr[State$Direction.LEFT.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            $SwitchMap$androidx$constraintlayout$solver$state$State$Direction[State$Direction.START.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            $SwitchMap$androidx$constraintlayout$solver$state$State$Direction[State$Direction.RIGHT.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            $SwitchMap$androidx$constraintlayout$solver$state$State$Direction[State$Direction.END.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            $SwitchMap$androidx$constraintlayout$solver$state$State$Direction[State$Direction.TOP.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            $SwitchMap$androidx$constraintlayout$solver$state$State$Direction[State$Direction.BOTTOM.ordinal()] = 6;
        } catch (NoSuchFieldError unused6) {
        }
    }
}
