package androidx.fragment.app;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.view.Lifecycle$State;
import b.d.b.a.a;
import java.io.PrintWriter;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class BackStackRecord extends FragmentTransaction implements FragmentManager$BackStackEntry, FragmentManager$OpGenerator {
    private static final String TAG = "FragmentManager";
    public boolean mCommitted;
    public int mIndex;
    public final FragmentManager mManager;

    public BackStackRecord(@NonNull FragmentManager fragmentManager) {
        super(fragmentManager.getFragmentFactory(), fragmentManager.getHost() != null ? fragmentManager.getHost().getContext().getClassLoader() : null);
        this.mIndex = -1;
        this.mManager = fragmentManager;
    }

    private static boolean isFragmentPostponed(FragmentTransaction$Op fragmentTransaction$Op) {
        Fragment fragment = fragmentTransaction$Op.mFragment;
        return (fragment == null || !fragment.mAdded || fragment.mView == null || fragment.mDetached || fragment.mHidden || !fragment.isPostponed()) ? false : true;
    }

    public void bumpBackStackNesting(int i) {
        if (this.mAddToBackStack) {
            if (FragmentManager.isLoggingEnabled(2)) {
                Log.v("FragmentManager", "Bump nesting in " + this + " by " + i);
            }
            int size = this.mOps.size();
            for (int i2 = 0; i2 < size; i2++) {
                FragmentTransaction$Op fragmentTransaction$Op = this.mOps.get(i2);
                Fragment fragment = fragmentTransaction$Op.mFragment;
                if (fragment != null) {
                    fragment.mBackStackNesting += i;
                    if (FragmentManager.isLoggingEnabled(2)) {
                        StringBuilder sbU = a.U("Bump nesting of ");
                        sbU.append(fragmentTransaction$Op.mFragment);
                        sbU.append(" to ");
                        sbU.append(fragmentTransaction$Op.mFragment.mBackStackNesting);
                        Log.v("FragmentManager", sbU.toString());
                    }
                }
            }
        }
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public int commit() {
        return commitInternal(false);
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public int commitAllowingStateLoss() {
        return commitInternal(true);
    }

    public int commitInternal(boolean z2) {
        if (this.mCommitted) {
            throw new IllegalStateException("commit already called");
        }
        if (FragmentManager.isLoggingEnabled(2)) {
            Log.v("FragmentManager", "Commit: " + this);
            PrintWriter printWriter = new PrintWriter(new LogWriter("FragmentManager"));
            dump("  ", printWriter);
            printWriter.close();
        }
        this.mCommitted = true;
        if (this.mAddToBackStack) {
            this.mIndex = this.mManager.allocBackStackIndex();
        } else {
            this.mIndex = -1;
        }
        this.mManager.enqueueAction(this, z2);
        return this.mIndex;
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public void commitNow() {
        disallowAddToBackStack();
        this.mManager.execSingleAction(this, false);
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public void commitNowAllowingStateLoss() {
        disallowAddToBackStack();
        this.mManager.execSingleAction(this, true);
    }

    @Override // androidx.fragment.app.FragmentTransaction
    @NonNull
    public FragmentTransaction detach(@NonNull Fragment fragment) {
        FragmentManager fragmentManager = fragment.mFragmentManager;
        if (fragmentManager == null || fragmentManager == this.mManager) {
            return super.detach(fragment);
        }
        StringBuilder sbU = a.U("Cannot detach Fragment attached to a different FragmentManager. Fragment ");
        sbU.append(fragment.toString());
        sbU.append(" is already attached to a FragmentManager.");
        throw new IllegalStateException(sbU.toString());
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public void doAddOp(int i, Fragment fragment, @Nullable String str, int i2) {
        super.doAddOp(i, fragment, str, i2);
        fragment.mFragmentManager = this.mManager;
    }

    public void dump(String str, PrintWriter printWriter) {
        dump(str, printWriter, true);
    }

    public void executeOps() {
        int size = this.mOps.size();
        for (int i = 0; i < size; i++) {
            FragmentTransaction$Op fragmentTransaction$Op = this.mOps.get(i);
            Fragment fragment = fragmentTransaction$Op.mFragment;
            if (fragment != null) {
                fragment.setNextTransition(this.mTransition);
                fragment.setSharedElementNames(this.mSharedElementSourceNames, this.mSharedElementTargetNames);
            }
            switch (fragmentTransaction$Op.mCmd) {
                case 1:
                    fragment.setNextAnim(fragmentTransaction$Op.mEnterAnim);
                    this.mManager.setExitAnimationOrder(fragment, false);
                    this.mManager.addFragment(fragment);
                    break;
                case 2:
                default:
                    StringBuilder sbU = a.U("Unknown cmd: ");
                    sbU.append(fragmentTransaction$Op.mCmd);
                    throw new IllegalArgumentException(sbU.toString());
                case 3:
                    fragment.setNextAnim(fragmentTransaction$Op.mExitAnim);
                    this.mManager.removeFragment(fragment);
                    break;
                case 4:
                    fragment.setNextAnim(fragmentTransaction$Op.mExitAnim);
                    this.mManager.hideFragment(fragment);
                    break;
                case 5:
                    fragment.setNextAnim(fragmentTransaction$Op.mEnterAnim);
                    this.mManager.setExitAnimationOrder(fragment, false);
                    this.mManager.showFragment(fragment);
                    break;
                case 6:
                    fragment.setNextAnim(fragmentTransaction$Op.mExitAnim);
                    this.mManager.detachFragment(fragment);
                    break;
                case 7:
                    fragment.setNextAnim(fragmentTransaction$Op.mEnterAnim);
                    this.mManager.setExitAnimationOrder(fragment, false);
                    this.mManager.attachFragment(fragment);
                    break;
                case 8:
                    this.mManager.setPrimaryNavigationFragment(fragment);
                    break;
                case 9:
                    this.mManager.setPrimaryNavigationFragment(null);
                    break;
                case 10:
                    this.mManager.setMaxLifecycle(fragment, fragmentTransaction$Op.mCurrentMaxState);
                    break;
            }
            if (!this.mReorderingAllowed && fragmentTransaction$Op.mCmd != 1 && fragment != null && !FragmentManager.USE_STATE_MANAGER) {
                this.mManager.moveFragmentToExpectedState(fragment);
            }
        }
        if (this.mReorderingAllowed || FragmentManager.USE_STATE_MANAGER) {
            return;
        }
        FragmentManager fragmentManager = this.mManager;
        fragmentManager.moveToState(fragmentManager.mCurState, true);
    }

    public void executePopOps(boolean z2) {
        for (int size = this.mOps.size() - 1; size >= 0; size--) {
            FragmentTransaction$Op fragmentTransaction$Op = this.mOps.get(size);
            Fragment fragment = fragmentTransaction$Op.mFragment;
            if (fragment != null) {
                fragment.setNextTransition(FragmentManager.reverseTransit(this.mTransition));
                fragment.setSharedElementNames(this.mSharedElementTargetNames, this.mSharedElementSourceNames);
            }
            switch (fragmentTransaction$Op.mCmd) {
                case 1:
                    fragment.setNextAnim(fragmentTransaction$Op.mPopExitAnim);
                    this.mManager.setExitAnimationOrder(fragment, true);
                    this.mManager.removeFragment(fragment);
                    break;
                case 2:
                default:
                    StringBuilder sbU = a.U("Unknown cmd: ");
                    sbU.append(fragmentTransaction$Op.mCmd);
                    throw new IllegalArgumentException(sbU.toString());
                case 3:
                    fragment.setNextAnim(fragmentTransaction$Op.mPopEnterAnim);
                    this.mManager.addFragment(fragment);
                    break;
                case 4:
                    fragment.setNextAnim(fragmentTransaction$Op.mPopEnterAnim);
                    this.mManager.showFragment(fragment);
                    break;
                case 5:
                    fragment.setNextAnim(fragmentTransaction$Op.mPopExitAnim);
                    this.mManager.setExitAnimationOrder(fragment, true);
                    this.mManager.hideFragment(fragment);
                    break;
                case 6:
                    fragment.setNextAnim(fragmentTransaction$Op.mPopEnterAnim);
                    this.mManager.attachFragment(fragment);
                    break;
                case 7:
                    fragment.setNextAnim(fragmentTransaction$Op.mPopExitAnim);
                    this.mManager.setExitAnimationOrder(fragment, true);
                    this.mManager.detachFragment(fragment);
                    break;
                case 8:
                    this.mManager.setPrimaryNavigationFragment(null);
                    break;
                case 9:
                    this.mManager.setPrimaryNavigationFragment(fragment);
                    break;
                case 10:
                    this.mManager.setMaxLifecycle(fragment, fragmentTransaction$Op.mOldMaxState);
                    break;
            }
            if (!this.mReorderingAllowed && fragmentTransaction$Op.mCmd != 3 && fragment != null && !FragmentManager.USE_STATE_MANAGER) {
                this.mManager.moveFragmentToExpectedState(fragment);
            }
        }
        if (this.mReorderingAllowed || !z2 || FragmentManager.USE_STATE_MANAGER) {
            return;
        }
        FragmentManager fragmentManager = this.mManager;
        fragmentManager.moveToState(fragmentManager.mCurState, true);
    }

    /* JADX WARN: Code duplicated, block: B:34:0x00b2  */
    public Fragment expandOps(ArrayList<Fragment> arrayList, Fragment fragment) {
        Fragment fragment2 = fragment;
        int i = 0;
        while (i < this.mOps.size()) {
            FragmentTransaction$Op fragmentTransaction$Op = this.mOps.get(i);
            int i2 = fragmentTransaction$Op.mCmd;
            if (i2 == 1) {
                arrayList.add(fragmentTransaction$Op.mFragment);
            } else if (i2 == 2) {
                Fragment fragment3 = fragmentTransaction$Op.mFragment;
                int i3 = fragment3.mContainerId;
                boolean z2 = false;
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    Fragment fragment4 = arrayList.get(size);
                    if (fragment4.mContainerId == i3) {
                        if (fragment4 == fragment3) {
                            z2 = true;
                        } else {
                            if (fragment4 == fragment2) {
                                this.mOps.add(i, new FragmentTransaction$Op(9, fragment4));
                                i++;
                                fragment2 = null;
                            }
                            FragmentTransaction$Op fragmentTransaction$Op2 = new FragmentTransaction$Op(3, fragment4);
                            fragmentTransaction$Op2.mEnterAnim = fragmentTransaction$Op.mEnterAnim;
                            fragmentTransaction$Op2.mPopEnterAnim = fragmentTransaction$Op.mPopEnterAnim;
                            fragmentTransaction$Op2.mExitAnim = fragmentTransaction$Op.mExitAnim;
                            fragmentTransaction$Op2.mPopExitAnim = fragmentTransaction$Op.mPopExitAnim;
                            this.mOps.add(i, fragmentTransaction$Op2);
                            arrayList.remove(fragment4);
                            i++;
                        }
                    }
                }
                if (z2) {
                    this.mOps.remove(i);
                    i--;
                } else {
                    fragmentTransaction$Op.mCmd = 1;
                    arrayList.add(fragment3);
                }
            } else if (i2 == 3 || i2 == 6) {
                arrayList.remove(fragmentTransaction$Op.mFragment);
                Fragment fragment5 = fragmentTransaction$Op.mFragment;
                if (fragment5 == fragment2) {
                    this.mOps.add(i, new FragmentTransaction$Op(9, fragment5));
                    i++;
                    fragment2 = null;
                }
            } else if (i2 == 7) {
                arrayList.add(fragmentTransaction$Op.mFragment);
            } else if (i2 == 8) {
                this.mOps.add(i, new FragmentTransaction$Op(9, fragment2));
                i++;
                fragment2 = fragmentTransaction$Op.mFragment;
            }
            i++;
        }
        return fragment2;
    }

    @Override // androidx.fragment.app.FragmentManager$OpGenerator
    public boolean generateOps(@NonNull ArrayList<BackStackRecord> arrayList, @NonNull ArrayList<Boolean> arrayList2) {
        if (FragmentManager.isLoggingEnabled(2)) {
            Log.v("FragmentManager", "Run: " + this);
        }
        arrayList.add(this);
        arrayList2.add(Boolean.FALSE);
        if (!this.mAddToBackStack) {
            return true;
        }
        this.mManager.addBackStackState(this);
        return true;
    }

    @Override // androidx.fragment.app.FragmentManager$BackStackEntry
    @Nullable
    public CharSequence getBreadCrumbShortTitle() {
        return this.mBreadCrumbShortTitleRes != 0 ? this.mManager.getHost().getContext().getText(this.mBreadCrumbShortTitleRes) : this.mBreadCrumbShortTitleText;
    }

    @Override // androidx.fragment.app.FragmentManager$BackStackEntry
    public int getBreadCrumbShortTitleRes() {
        return this.mBreadCrumbShortTitleRes;
    }

    @Override // androidx.fragment.app.FragmentManager$BackStackEntry
    @Nullable
    public CharSequence getBreadCrumbTitle() {
        return this.mBreadCrumbTitleRes != 0 ? this.mManager.getHost().getContext().getText(this.mBreadCrumbTitleRes) : this.mBreadCrumbTitleText;
    }

    @Override // androidx.fragment.app.FragmentManager$BackStackEntry
    public int getBreadCrumbTitleRes() {
        return this.mBreadCrumbTitleRes;
    }

    @Override // androidx.fragment.app.FragmentManager$BackStackEntry
    public int getId() {
        return this.mIndex;
    }

    @Override // androidx.fragment.app.FragmentManager$BackStackEntry
    @Nullable
    public String getName() {
        return this.mName;
    }

    @Override // androidx.fragment.app.FragmentTransaction
    @NonNull
    public FragmentTransaction hide(@NonNull Fragment fragment) {
        FragmentManager fragmentManager = fragment.mFragmentManager;
        if (fragmentManager == null || fragmentManager == this.mManager) {
            return super.hide(fragment);
        }
        StringBuilder sbU = a.U("Cannot hide Fragment attached to a different FragmentManager. Fragment ");
        sbU.append(fragment.toString());
        sbU.append(" is already attached to a FragmentManager.");
        throw new IllegalStateException(sbU.toString());
    }

    public boolean interactsWith(int i) {
        int size = this.mOps.size();
        for (int i2 = 0; i2 < size; i2++) {
            Fragment fragment = this.mOps.get(i2).mFragment;
            int i3 = fragment != null ? fragment.mContainerId : 0;
            if (i3 != 0 && i3 == i) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public boolean isEmpty() {
        return this.mOps.isEmpty();
    }

    public boolean isPostponed() {
        for (int i = 0; i < this.mOps.size(); i++) {
            if (isFragmentPostponed(this.mOps.get(i))) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.fragment.app.FragmentTransaction
    @NonNull
    public FragmentTransaction remove(@NonNull Fragment fragment) {
        FragmentManager fragmentManager = fragment.mFragmentManager;
        if (fragmentManager == null || fragmentManager == this.mManager) {
            return super.remove(fragment);
        }
        StringBuilder sbU = a.U("Cannot remove Fragment attached to a different FragmentManager. Fragment ");
        sbU.append(fragment.toString());
        sbU.append(" is already attached to a FragmentManager.");
        throw new IllegalStateException(sbU.toString());
    }

    public void runOnCommitRunnables() {
        if (this.mCommitRunnables != null) {
            for (int i = 0; i < this.mCommitRunnables.size(); i++) {
                this.mCommitRunnables.get(i).run();
            }
            this.mCommitRunnables = null;
        }
    }

    @Override // androidx.fragment.app.FragmentTransaction
    @NonNull
    public FragmentTransaction setMaxLifecycle(@NonNull Fragment fragment, @NonNull Lifecycle$State lifecycle$State) {
        if (fragment.mFragmentManager != this.mManager) {
            StringBuilder sbU = a.U("Cannot setMaxLifecycle for Fragment not attached to FragmentManager ");
            sbU.append(this.mManager);
            throw new IllegalArgumentException(sbU.toString());
        }
        if (lifecycle$State == Lifecycle$State.INITIALIZED && fragment.mState > -1) {
            throw new IllegalArgumentException("Cannot set maximum Lifecycle to " + lifecycle$State + " after the Fragment has been created");
        }
        if (lifecycle$State != Lifecycle$State.DESTROYED) {
            return super.setMaxLifecycle(fragment, lifecycle$State);
        }
        throw new IllegalArgumentException("Cannot set maximum Lifecycle to " + lifecycle$State + ". Use remove() to remove the fragment from the FragmentManager and trigger its destruction.");
    }

    public void setOnStartPostponedListener(Fragment$OnStartEnterTransitionListener fragment$OnStartEnterTransitionListener) {
        for (int i = 0; i < this.mOps.size(); i++) {
            FragmentTransaction$Op fragmentTransaction$Op = this.mOps.get(i);
            if (isFragmentPostponed(fragmentTransaction$Op)) {
                fragmentTransaction$Op.mFragment.setOnStartEnterTransitionListener(fragment$OnStartEnterTransitionListener);
            }
        }
    }

    @Override // androidx.fragment.app.FragmentTransaction
    @NonNull
    public FragmentTransaction setPrimaryNavigationFragment(@Nullable Fragment fragment) {
        FragmentManager fragmentManager;
        if (fragment == null || (fragmentManager = fragment.mFragmentManager) == null || fragmentManager == this.mManager) {
            return super.setPrimaryNavigationFragment(fragment);
        }
        StringBuilder sbU = a.U("Cannot setPrimaryNavigation for Fragment attached to a different FragmentManager. Fragment ");
        sbU.append(fragment.toString());
        sbU.append(" is already attached to a FragmentManager.");
        throw new IllegalStateException(sbU.toString());
    }

    @Override // androidx.fragment.app.FragmentTransaction
    @NonNull
    public FragmentTransaction show(@NonNull Fragment fragment) {
        FragmentManager fragmentManager = fragment.mFragmentManager;
        if (fragmentManager == null || fragmentManager == this.mManager) {
            return super.show(fragment);
        }
        StringBuilder sbU = a.U("Cannot show Fragment attached to a different FragmentManager. Fragment ");
        sbU.append(fragment.toString());
        sbU.append(" is already attached to a FragmentManager.");
        throw new IllegalStateException(sbU.toString());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("BackStackEntry{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.mIndex >= 0) {
            sb.append(" #");
            sb.append(this.mIndex);
        }
        if (this.mName != null) {
            sb.append(" ");
            sb.append(this.mName);
        }
        sb.append("}");
        return sb.toString();
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0027  */
    /* JADX WARN: Code duplicated, block: B:14:0x002d  */
    public Fragment trackAddedFragmentsInPop(ArrayList<Fragment> arrayList, Fragment fragment) {
        for (int size = this.mOps.size() - 1; size >= 0; size--) {
            FragmentTransaction$Op fragmentTransaction$Op = this.mOps.get(size);
            int i = fragmentTransaction$Op.mCmd;
            if (i == 1) {
                arrayList.remove(fragmentTransaction$Op.mFragment);
            } else if (i != 3) {
                switch (i) {
                    case 6:
                        arrayList.add(fragmentTransaction$Op.mFragment);
                        break;
                    case 7:
                        arrayList.remove(fragmentTransaction$Op.mFragment);
                        break;
                    case 8:
                        fragment = null;
                        break;
                    case 9:
                        fragment = fragmentTransaction$Op.mFragment;
                        break;
                    case 10:
                        fragmentTransaction$Op.mCurrentMaxState = fragmentTransaction$Op.mOldMaxState;
                        break;
                }
            } else {
                arrayList.add(fragmentTransaction$Op.mFragment);
            }
        }
        return fragment;
    }

    public void dump(String str, PrintWriter printWriter, boolean z2) {
        String string;
        if (z2) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.mName);
            printWriter.print(" mIndex=");
            printWriter.print(this.mIndex);
            printWriter.print(" mCommitted=");
            printWriter.println(this.mCommitted);
            if (this.mTransition != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.mTransition));
            }
            if (this.mEnterAnim != 0 || this.mExitAnim != 0) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.mEnterAnim));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.mExitAnim));
            }
            if (this.mPopEnterAnim != 0 || this.mPopExitAnim != 0) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.mPopEnterAnim));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.mPopExitAnim));
            }
            if (this.mBreadCrumbTitleRes != 0 || this.mBreadCrumbTitleText != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.mBreadCrumbTitleRes));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.mBreadCrumbTitleText);
            }
            if (this.mBreadCrumbShortTitleRes != 0 || this.mBreadCrumbShortTitleText != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.mBreadCrumbShortTitleRes));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.mBreadCrumbShortTitleText);
            }
        }
        if (this.mOps.isEmpty()) {
            return;
        }
        printWriter.print(str);
        printWriter.println("Operations:");
        int size = this.mOps.size();
        for (int i = 0; i < size; i++) {
            FragmentTransaction$Op fragmentTransaction$Op = this.mOps.get(i);
            switch (fragmentTransaction$Op.mCmd) {
                case 0:
                    string = "NULL";
                    break;
                case 1:
                    string = "ADD";
                    break;
                case 2:
                    string = "REPLACE";
                    break;
                case 3:
                    string = "REMOVE";
                    break;
                case 4:
                    string = "HIDE";
                    break;
                case 5:
                    string = "SHOW";
                    break;
                case 6:
                    string = "DETACH";
                    break;
                case 7:
                    string = "ATTACH";
                    break;
                case 8:
                    string = "SET_PRIMARY_NAV";
                    break;
                case 9:
                    string = "UNSET_PRIMARY_NAV";
                    break;
                case 10:
                    string = "OP_SET_MAX_LIFECYCLE";
                    break;
                default:
                    StringBuilder sbU = a.U("cmd=");
                    sbU.append(fragmentTransaction$Op.mCmd);
                    string = sbU.toString();
                    break;
            }
            printWriter.print(str);
            printWriter.print("  Op #");
            printWriter.print(i);
            printWriter.print(": ");
            printWriter.print(string);
            printWriter.print(" ");
            printWriter.println(fragmentTransaction$Op.mFragment);
            if (z2) {
                if (fragmentTransaction$Op.mEnterAnim != 0 || fragmentTransaction$Op.mExitAnim != 0) {
                    printWriter.print(str);
                    printWriter.print("enterAnim=#");
                    printWriter.print(Integer.toHexString(fragmentTransaction$Op.mEnterAnim));
                    printWriter.print(" exitAnim=#");
                    printWriter.println(Integer.toHexString(fragmentTransaction$Op.mExitAnim));
                }
                if (fragmentTransaction$Op.mPopEnterAnim != 0 || fragmentTransaction$Op.mPopExitAnim != 0) {
                    printWriter.print(str);
                    printWriter.print("popEnterAnim=#");
                    printWriter.print(Integer.toHexString(fragmentTransaction$Op.mPopEnterAnim));
                    printWriter.print(" popExitAnim=#");
                    printWriter.println(Integer.toHexString(fragmentTransaction$Op.mPopExitAnim));
                }
            }
        }
    }

    public boolean interactsWith(ArrayList<BackStackRecord> arrayList, int i, int i2) {
        if (i2 == i) {
            return false;
        }
        int size = this.mOps.size();
        int i3 = -1;
        for (int i4 = 0; i4 < size; i4++) {
            Fragment fragment = this.mOps.get(i4).mFragment;
            int i5 = fragment != null ? fragment.mContainerId : 0;
            if (i5 != 0 && i5 != i3) {
                for (int i6 = i; i6 < i2; i6++) {
                    BackStackRecord backStackRecord = arrayList.get(i6);
                    int size2 = backStackRecord.mOps.size();
                    for (int i7 = 0; i7 < size2; i7++) {
                        Fragment fragment2 = backStackRecord.mOps.get(i7).mFragment;
                        if ((fragment2 != null ? fragment2.mContainerId : 0) == i5) {
                            return true;
                        }
                    }
                }
                i3 = i5;
            }
        }
        return false;
    }
}
