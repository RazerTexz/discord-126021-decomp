package androidx.constraintlayout.solver.state.helpers;

import androidx.constraintlayout.solver.state.HelperReference;
import androidx.constraintlayout.solver.state.State;
import androidx.constraintlayout.solver.state.State$Direction;
import androidx.constraintlayout.solver.state.State$Helper;
import androidx.constraintlayout.solver.widgets.Barrier;
import androidx.constraintlayout.solver.widgets.HelperWidget;

/* JADX INFO: loaded from: classes.dex */
public class BarrierReference extends HelperReference {
    private Barrier mBarrierWidget;
    private State$Direction mDirection;
    private int mMargin;

    public BarrierReference(State state) {
        super(state, State$Helper.BARRIER);
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

    public void setBarrierDirection(State$Direction state$Direction) {
        this.mDirection = state$Direction;
    }

    public void margin(int i) {
        this.mMargin = i;
    }
}
