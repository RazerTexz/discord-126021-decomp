package androidx.fragment.app;

import androidx.annotation.NonNull;
import androidx.view.Lifecycle$State;

/* JADX INFO: loaded from: classes.dex */
public final class FragmentTransaction$Op {
    public int mCmd;
    public Lifecycle$State mCurrentMaxState;
    public int mEnterAnim;
    public int mExitAnim;
    public Fragment mFragment;
    public Lifecycle$State mOldMaxState;
    public int mPopEnterAnim;
    public int mPopExitAnim;

    public FragmentTransaction$Op() {
    }

    public FragmentTransaction$Op(int i, Fragment fragment) {
        this.mCmd = i;
        this.mFragment = fragment;
        Lifecycle$State lifecycle$State = Lifecycle$State.RESUMED;
        this.mOldMaxState = lifecycle$State;
        this.mCurrentMaxState = lifecycle$State;
    }

    public FragmentTransaction$Op(int i, @NonNull Fragment fragment, Lifecycle$State lifecycle$State) {
        this.mCmd = i;
        this.mFragment = fragment;
        this.mOldMaxState = fragment.mMaxState;
        this.mCurrentMaxState = lifecycle$State;
    }
}
