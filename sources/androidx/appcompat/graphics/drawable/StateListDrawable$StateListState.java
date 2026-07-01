package androidx.appcompat.graphics.drawable;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.StateSet;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public class StateListDrawable$StateListState extends DrawableContainer$DrawableContainerState {
    public int[][] mStateSets;

    public StateListDrawable$StateListState(StateListDrawable$StateListState stateListDrawable$StateListState, StateListDrawable stateListDrawable, Resources resources) {
        super(stateListDrawable$StateListState, stateListDrawable, resources);
        if (stateListDrawable$StateListState != null) {
            this.mStateSets = stateListDrawable$StateListState.mStateSets;
        } else {
            this.mStateSets = new int[getCapacity()][];
        }
    }

    public int addStateSet(int[] iArr, Drawable drawable) {
        int iAddChild = addChild(drawable);
        this.mStateSets[iAddChild] = iArr;
        return iAddChild;
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer$DrawableContainerState
    public void growArray(int i, int i2) {
        super.growArray(i, i2);
        int[][] iArr = new int[i2][];
        System.arraycopy(this.mStateSets, 0, iArr, 0, i);
        this.mStateSets = iArr;
    }

    public int indexOfStateSet(int[] iArr) {
        int[][] iArr2 = this.mStateSets;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (StateSet.stateSetMatches(iArr2[i], iArr)) {
                return i;
            }
        }
        return -1;
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer$DrawableContainerState
    public void mutate() {
        int[][] iArr = this.mStateSets;
        int[][] iArr2 = new int[iArr.length][];
        for (int length = iArr.length - 1; length >= 0; length--) {
            int[][] iArr3 = this.mStateSets;
            iArr2[length] = iArr3[length] != null ? (int[]) iArr3[length].clone() : null;
        }
        this.mStateSets = iArr2;
    }

    @Override // android.graphics.drawable.Drawable$ConstantState
    @NonNull
    public Drawable newDrawable() {
        return new StateListDrawable(this, null);
    }

    @Override // android.graphics.drawable.Drawable$ConstantState
    @NonNull
    public Drawable newDrawable(Resources resources) {
        return new StateListDrawable(this, resources);
    }
}
