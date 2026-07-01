package androidx.constraintlayout.solver.state.helpers;

import androidx.constraintlayout.solver.state.State$Chain;

/* JADX INFO: loaded from: classes.dex */
public /* synthetic */ class HorizontalChainReference$1 {
    public static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$solver$state$State$Chain;

    static {
        State$Chain.values();
        int[] iArr = new int[3];
        $SwitchMap$androidx$constraintlayout$solver$state$State$Chain = iArr;
        try {
            iArr[State$Chain.SPREAD.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            $SwitchMap$androidx$constraintlayout$solver$state$State$Chain[State$Chain.SPREAD_INSIDE.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            $SwitchMap$androidx$constraintlayout$solver$state$State$Chain[State$Chain.PACKED.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
    }
}
