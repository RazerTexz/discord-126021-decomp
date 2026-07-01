package androidx.fragment.app;

import android.util.Log;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.os.CancellationSignal;
import androidx.core.view.ViewCompat;
import androidx.fragment.R$id;
import b.d.b.a.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class SpecialEffectsController {
    private final ViewGroup mContainer;
    public final ArrayList<SpecialEffectsController$Operation> mPendingOperations = new ArrayList<>();
    public final ArrayList<SpecialEffectsController$Operation> mRunningOperations = new ArrayList<>();
    public boolean mOperationDirectionIsPop = false;
    public boolean mIsContainerPostponed = false;

    public SpecialEffectsController(@NonNull ViewGroup viewGroup) {
        this.mContainer = viewGroup;
    }

    private void enqueue(@NonNull SpecialEffectsController$Operation$State specialEffectsController$Operation$State, @NonNull SpecialEffectsController$Operation$LifecycleImpact specialEffectsController$Operation$LifecycleImpact, @NonNull FragmentStateManager fragmentStateManager) {
        synchronized (this.mPendingOperations) {
            CancellationSignal cancellationSignal = new CancellationSignal();
            SpecialEffectsController$Operation specialEffectsController$OperationFindPendingOperation = findPendingOperation(fragmentStateManager.getFragment());
            if (specialEffectsController$OperationFindPendingOperation != null) {
                specialEffectsController$OperationFindPendingOperation.mergeWith(specialEffectsController$Operation$State, specialEffectsController$Operation$LifecycleImpact);
                return;
            }
            SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation = new SpecialEffectsController$FragmentStateManagerOperation(specialEffectsController$Operation$State, specialEffectsController$Operation$LifecycleImpact, fragmentStateManager, cancellationSignal);
            this.mPendingOperations.add(specialEffectsController$FragmentStateManagerOperation);
            specialEffectsController$FragmentStateManagerOperation.addCompletionListener(new SpecialEffectsController$1(this, specialEffectsController$FragmentStateManagerOperation));
            specialEffectsController$FragmentStateManagerOperation.addCompletionListener(new SpecialEffectsController$2(this, specialEffectsController$FragmentStateManagerOperation));
        }
    }

    @Nullable
    private SpecialEffectsController$Operation findPendingOperation(@NonNull Fragment fragment) {
        for (SpecialEffectsController$Operation specialEffectsController$Operation : this.mPendingOperations) {
            if (specialEffectsController$Operation.getFragment().equals(fragment) && !specialEffectsController$Operation.isCanceled()) {
                return specialEffectsController$Operation;
            }
        }
        return null;
    }

    @Nullable
    private SpecialEffectsController$Operation findRunningOperation(@NonNull Fragment fragment) {
        for (SpecialEffectsController$Operation specialEffectsController$Operation : this.mRunningOperations) {
            if (specialEffectsController$Operation.getFragment().equals(fragment) && !specialEffectsController$Operation.isCanceled()) {
                return specialEffectsController$Operation;
            }
        }
        return null;
    }

    @NonNull
    public static SpecialEffectsController getOrCreateController(@NonNull ViewGroup viewGroup, @NonNull FragmentManager fragmentManager) {
        return getOrCreateController(viewGroup, fragmentManager.getSpecialEffectsControllerFactory());
    }

    private void updateFinalState() {
        for (SpecialEffectsController$Operation specialEffectsController$Operation : this.mPendingOperations) {
            if (specialEffectsController$Operation.getLifecycleImpact() == SpecialEffectsController$Operation$LifecycleImpact.ADDING) {
                specialEffectsController$Operation.mergeWith(SpecialEffectsController$Operation$State.from(specialEffectsController$Operation.getFragment().requireView().getVisibility()), SpecialEffectsController$Operation$LifecycleImpact.NONE);
            }
        }
    }

    public void enqueueAdd(@NonNull SpecialEffectsController$Operation$State specialEffectsController$Operation$State, @NonNull FragmentStateManager fragmentStateManager) {
        if (FragmentManager.isLoggingEnabled(2)) {
            StringBuilder sbU = a.U("SpecialEffectsController: Enqueuing add operation for fragment ");
            sbU.append(fragmentStateManager.getFragment());
            Log.v(FragmentManager.TAG, sbU.toString());
        }
        enqueue(specialEffectsController$Operation$State, SpecialEffectsController$Operation$LifecycleImpact.ADDING, fragmentStateManager);
    }

    public void enqueueHide(@NonNull FragmentStateManager fragmentStateManager) {
        if (FragmentManager.isLoggingEnabled(2)) {
            StringBuilder sbU = a.U("SpecialEffectsController: Enqueuing hide operation for fragment ");
            sbU.append(fragmentStateManager.getFragment());
            Log.v(FragmentManager.TAG, sbU.toString());
        }
        enqueue(SpecialEffectsController$Operation$State.GONE, SpecialEffectsController$Operation$LifecycleImpact.NONE, fragmentStateManager);
    }

    public void enqueueRemove(@NonNull FragmentStateManager fragmentStateManager) {
        if (FragmentManager.isLoggingEnabled(2)) {
            StringBuilder sbU = a.U("SpecialEffectsController: Enqueuing remove operation for fragment ");
            sbU.append(fragmentStateManager.getFragment());
            Log.v(FragmentManager.TAG, sbU.toString());
        }
        enqueue(SpecialEffectsController$Operation$State.REMOVED, SpecialEffectsController$Operation$LifecycleImpact.REMOVING, fragmentStateManager);
    }

    public void enqueueShow(@NonNull FragmentStateManager fragmentStateManager) {
        if (FragmentManager.isLoggingEnabled(2)) {
            StringBuilder sbU = a.U("SpecialEffectsController: Enqueuing show operation for fragment ");
            sbU.append(fragmentStateManager.getFragment());
            Log.v(FragmentManager.TAG, sbU.toString());
        }
        enqueue(SpecialEffectsController$Operation$State.VISIBLE, SpecialEffectsController$Operation$LifecycleImpact.NONE, fragmentStateManager);
    }

    public abstract void executeOperations(@NonNull List<SpecialEffectsController$Operation> list, boolean z2);

    public void executePendingOperations() {
        if (this.mIsContainerPostponed) {
            return;
        }
        if (!ViewCompat.isAttachedToWindow(this.mContainer)) {
            forceCompleteAllOperations();
            this.mOperationDirectionIsPop = false;
            return;
        }
        synchronized (this.mPendingOperations) {
            if (!this.mPendingOperations.isEmpty()) {
                ArrayList<SpecialEffectsController$Operation> arrayList = new ArrayList(this.mRunningOperations);
                this.mRunningOperations.clear();
                for (SpecialEffectsController$Operation specialEffectsController$Operation : arrayList) {
                    if (FragmentManager.isLoggingEnabled(2)) {
                        Log.v(FragmentManager.TAG, "SpecialEffectsController: Cancelling operation " + specialEffectsController$Operation);
                    }
                    specialEffectsController$Operation.cancel();
                    if (!specialEffectsController$Operation.isComplete()) {
                        this.mRunningOperations.add(specialEffectsController$Operation);
                    }
                }
                updateFinalState();
                ArrayList arrayList2 = new ArrayList(this.mPendingOperations);
                this.mPendingOperations.clear();
                this.mRunningOperations.addAll(arrayList2);
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    ((SpecialEffectsController$Operation) it.next()).onStart();
                }
                executeOperations(arrayList2, this.mOperationDirectionIsPop);
                this.mOperationDirectionIsPop = false;
            }
        }
    }

    public void forceCompleteAllOperations() {
        boolean zIsAttachedToWindow = ViewCompat.isAttachedToWindow(this.mContainer);
        synchronized (this.mPendingOperations) {
            updateFinalState();
            Iterator<SpecialEffectsController$Operation> it = this.mPendingOperations.iterator();
            while (it.hasNext()) {
                it.next().onStart();
            }
            for (SpecialEffectsController$Operation specialEffectsController$Operation : new ArrayList(this.mRunningOperations)) {
                if (FragmentManager.isLoggingEnabled(2)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("SpecialEffectsController: ");
                    sb.append(zIsAttachedToWindow ? "" : "Container " + this.mContainer + " is not attached to window. ");
                    sb.append("Cancelling running operation ");
                    sb.append(specialEffectsController$Operation);
                    Log.v(FragmentManager.TAG, sb.toString());
                }
                specialEffectsController$Operation.cancel();
            }
            for (SpecialEffectsController$Operation specialEffectsController$Operation2 : new ArrayList(this.mPendingOperations)) {
                if (FragmentManager.isLoggingEnabled(2)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("SpecialEffectsController: ");
                    sb2.append(zIsAttachedToWindow ? "" : "Container " + this.mContainer + " is not attached to window. ");
                    sb2.append("Cancelling pending operation ");
                    sb2.append(specialEffectsController$Operation2);
                    Log.v(FragmentManager.TAG, sb2.toString());
                }
                specialEffectsController$Operation2.cancel();
            }
        }
    }

    public void forcePostponedExecutePendingOperations() {
        if (this.mIsContainerPostponed) {
            this.mIsContainerPostponed = false;
            executePendingOperations();
        }
    }

    @Nullable
    public SpecialEffectsController$Operation$LifecycleImpact getAwaitingCompletionLifecycleImpact(@NonNull FragmentStateManager fragmentStateManager) {
        SpecialEffectsController$Operation specialEffectsController$OperationFindPendingOperation = findPendingOperation(fragmentStateManager.getFragment());
        if (specialEffectsController$OperationFindPendingOperation != null) {
            return specialEffectsController$OperationFindPendingOperation.getLifecycleImpact();
        }
        SpecialEffectsController$Operation specialEffectsController$OperationFindRunningOperation = findRunningOperation(fragmentStateManager.getFragment());
        if (specialEffectsController$OperationFindRunningOperation != null) {
            return specialEffectsController$OperationFindRunningOperation.getLifecycleImpact();
        }
        return null;
    }

    @NonNull
    public ViewGroup getContainer() {
        return this.mContainer;
    }

    public void markPostponedState() {
        synchronized (this.mPendingOperations) {
            updateFinalState();
            this.mIsContainerPostponed = false;
            for (int size = this.mPendingOperations.size() - 1; size >= 0; size--) {
                SpecialEffectsController$Operation specialEffectsController$Operation = this.mPendingOperations.get(size);
                SpecialEffectsController$Operation$State specialEffectsController$Operation$StateFrom = SpecialEffectsController$Operation$State.from(specialEffectsController$Operation.getFragment().mView);
                SpecialEffectsController$Operation$State finalState = specialEffectsController$Operation.getFinalState();
                SpecialEffectsController$Operation$State specialEffectsController$Operation$State = SpecialEffectsController$Operation$State.VISIBLE;
                if (finalState == specialEffectsController$Operation$State && specialEffectsController$Operation$StateFrom != specialEffectsController$Operation$State) {
                    this.mIsContainerPostponed = specialEffectsController$Operation.getFragment().isPostponed();
                    break;
                }
            }
        }
    }

    public void updateOperationDirection(boolean z2) {
        this.mOperationDirectionIsPop = z2;
    }

    @NonNull
    public static SpecialEffectsController getOrCreateController(@NonNull ViewGroup viewGroup, @NonNull SpecialEffectsControllerFactory specialEffectsControllerFactory) {
        int i = R$id.special_effects_controller_view_tag;
        Object tag = viewGroup.getTag(i);
        if (tag instanceof SpecialEffectsController) {
            return (SpecialEffectsController) tag;
        }
        SpecialEffectsController specialEffectsControllerCreateController = specialEffectsControllerFactory.createController(viewGroup);
        viewGroup.setTag(i, specialEffectsControllerCreateController);
        return specialEffectsControllerCreateController;
    }
}
