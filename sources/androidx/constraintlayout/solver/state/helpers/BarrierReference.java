package androidx.constraintlayout.solver.state.helpers;

import androidx.constraintlayout.solver.state.HelperReference;
import androidx.constraintlayout.solver.state.State;
import androidx.constraintlayout.solver.widgets.Barrier;
import androidx.constraintlayout.solver.widgets.HelperWidget;

/* JADX INFO: loaded from: classes.dex */
public class BarrierReference extends HelperReference {
    private Barrier mBarrierWidget;
    private State.Direction mDirection;
    private int mMargin;

    /* JADX INFO: renamed from: androidx.constraintlayout.solver.state.helpers.BarrierReference$1 */
    public static /* synthetic */ class C01861 {

        /* JADX INFO: renamed from: $SwitchMap$androidx$constraintlayout$solver$state$State$Direction */
        public static final /* synthetic */ int[] f112xf452c4aa;

        static {
            State.Direction.values();
            int[] iArr = new int[6];
            f112xf452c4aa = iArr;
            try {
                iArr[State.Direction.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f112xf452c4aa[State.Direction.START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f112xf452c4aa[State.Direction.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f112xf452c4aa[State.Direction.END.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f112xf452c4aa[State.Direction.TOP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f112xf452c4aa[State.Direction.BOTTOM.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public BarrierReference(State state) {
        super(state, State.Helper.BARRIER);
    }

    /* JADX WARN: Code duplicated, block: B:11:0x001b  */
    /* JADX WARN: Code duplicated, block: B:13:0x001f  */
    @Override // androidx.constraintlayout.solver.state.HelperReference
    public void apply() {
        getHelperWidget();
        int iOrdinal = this.mDirection.ordinal();
        int i = 3;
        if (iOrdinal == 0) {
            i = 0;
        } else if (iOrdinal == 1) {
            i = 1;
        } else if (iOrdinal == 2) {
            i = 0;
        } else if (iOrdinal == 3) {
            i = 1;
        } else if (iOrdinal == 4) {
            i = 2;
        } else if (iOrdinal != 5) {
            i = 0;
        }
        this.mBarrierWidget.setBarrierType(i);
        this.mBarrierWidget.setMargin(this.mMargin);
    }

    @Override // androidx.constraintlayout.solver.state.HelperReference
    public HelperWidget getHelperWidget() {
        if (this.mBarrierWidget == null) {
            this.mBarrierWidget = new Barrier();
        }
        return this.mBarrierWidget;
    }

    public void margin(Object obj) {
        margin(this.mState.convertDimension(obj));
    }

    public void setBarrierDirection(State.Direction direction) {
        this.mDirection = direction;
    }

    public void margin(int i) {
        this.mMargin = i;
    }
}
