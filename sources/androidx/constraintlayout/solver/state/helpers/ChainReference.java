package androidx.constraintlayout.solver.state.helpers;

import androidx.constraintlayout.solver.state.HelperReference;
import androidx.constraintlayout.solver.state.State;
import androidx.constraintlayout.solver.state.State$Chain;
import androidx.constraintlayout.solver.state.State$Helper;

/* JADX INFO: loaded from: classes.dex */
public class ChainReference extends HelperReference {
    public float mBias;
    public State$Chain mStyle;

    public ChainReference(State state, State$Helper state$Helper) {
        super(state, state$Helper);
        this.mBias = 0.5f;
        this.mStyle = State$Chain.SPREAD;
    }

    public void bias(float f) {
        this.mBias = f;
    }

    public float getBias() {
        return this.mBias;
    }

    public State$Chain getStyle() {
        return State$Chain.SPREAD;
    }

    public void style(State$Chain state$Chain) {
        this.mStyle = state$Chain;
    }
}
