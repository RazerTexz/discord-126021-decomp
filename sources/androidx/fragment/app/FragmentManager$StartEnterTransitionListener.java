package androidx.fragment.app;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public class FragmentManager$StartEnterTransitionListener implements Fragment$OnStartEnterTransitionListener {
    public final boolean mIsBack;
    private int mNumPostponed;
    public final BackStackRecord mRecord;

    public FragmentManager$StartEnterTransitionListener(@NonNull BackStackRecord backStackRecord, boolean z2) {
        this.mIsBack = z2;
        this.mRecord = backStackRecord;
    }

    public void cancelTransaction() {
        BackStackRecord backStackRecord = this.mRecord;
        backStackRecord.mManager.completeExecute(backStackRecord, this.mIsBack, false, false);
    }

    public void completeTransaction() {
        boolean z2 = this.mNumPostponed > 0;
        for (Fragment fragment : this.mRecord.mManager.getFragments()) {
            fragment.setOnStartEnterTransitionListener(null);
            if (z2 && fragment.isPostponed()) {
                fragment.startPostponedEnterTransition();
            }
        }
        BackStackRecord backStackRecord = this.mRecord;
        backStackRecord.mManager.completeExecute(backStackRecord, this.mIsBack, !z2, true);
    }

    public boolean isReady() {
        return this.mNumPostponed == 0;
    }

    @Override // androidx.fragment.app.Fragment$OnStartEnterTransitionListener
    public void onStartEnterTransition() {
        int i = this.mNumPostponed - 1;
        this.mNumPostponed = i;
        if (i != 0) {
            return;
        }
        this.mRecord.mManager.scheduleCommit();
    }

    @Override // androidx.fragment.app.Fragment$OnStartEnterTransitionListener
    public void startListening() {
        this.mNumPostponed++;
    }
}
