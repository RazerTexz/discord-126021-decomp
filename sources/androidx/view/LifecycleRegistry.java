package androidx.view;

import android.annotation.SuppressLint;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.arch.core.internal.FastSafeIterableMap;
import androidx.arch.core.internal.SafeIterableMap$IteratorWithAdditions;
import b.d.b.a.a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map$Entry;

/* JADX INFO: loaded from: classes.dex */
public class LifecycleRegistry extends Lifecycle {
    private int mAddingObserverCounter;
    private final boolean mEnforceMainThread;
    private boolean mHandlingEvent;
    private final WeakReference<LifecycleOwner> mLifecycleOwner;
    private boolean mNewEventOccurred;
    private FastSafeIterableMap<LifecycleObserver, LifecycleRegistry$ObserverWithState> mObserverMap;
    private ArrayList<Lifecycle$State> mParentStates;
    private Lifecycle$State mState;

    public LifecycleRegistry(@NonNull LifecycleOwner lifecycleOwner) {
        this(lifecycleOwner, true);
    }

    private void backwardPass(LifecycleOwner lifecycleOwner) {
        Iterator<Map$Entry<LifecycleObserver, LifecycleRegistry$ObserverWithState>> itDescendingIterator = this.mObserverMap.descendingIterator();
        while (itDescendingIterator.hasNext() && !this.mNewEventOccurred) {
            Map$Entry<LifecycleObserver, LifecycleRegistry$ObserverWithState> next = itDescendingIterator.next();
            LifecycleRegistry$ObserverWithState value = next.getValue();
            while (value.mState.compareTo(this.mState) > 0 && !this.mNewEventOccurred && this.mObserverMap.contains(next.getKey())) {
                Lifecycle$Event lifecycle$EventDownFrom = Lifecycle$Event.downFrom(value.mState);
                if (lifecycle$EventDownFrom == null) {
                    StringBuilder sbU = a.U("no event down from ");
                    sbU.append(value.mState);
                    throw new IllegalStateException(sbU.toString());
                }
                pushParentState(lifecycle$EventDownFrom.getTargetState());
                value.dispatchEvent(lifecycleOwner, lifecycle$EventDownFrom);
                popParentState();
            }
        }
    }

    private Lifecycle$State calculateTargetState(LifecycleObserver lifecycleObserver) {
        Map$Entry<LifecycleObserver, LifecycleRegistry$ObserverWithState> map$EntryCeil = this.mObserverMap.ceil(lifecycleObserver);
        Lifecycle$State lifecycle$State = null;
        Lifecycle$State lifecycle$State2 = map$EntryCeil != null ? map$EntryCeil.getValue().mState : null;
        if (!this.mParentStates.isEmpty()) {
            ArrayList<Lifecycle$State> arrayList = this.mParentStates;
            lifecycle$State = arrayList.get(arrayList.size() - 1);
        }
        return min(min(this.mState, lifecycle$State2), lifecycle$State);
    }

    @NonNull
    @VisibleForTesting
    public static LifecycleRegistry createUnsafe(@NonNull LifecycleOwner lifecycleOwner) {
        return new LifecycleRegistry(lifecycleOwner, false);
    }

    @SuppressLint({"RestrictedApi"})
    private void enforceMainThreadIfNeeded(String str) {
        if (this.mEnforceMainThread && !ArchTaskExecutor.getInstance().isMainThread()) {
            throw new IllegalStateException(a.y("Method ", str, " must be called on the main thread"));
        }
    }

    private void forwardPass(LifecycleOwner lifecycleOwner) {
        SafeIterableMap$IteratorWithAdditions safeIterableMap$IteratorWithAdditionsIteratorWithAdditions = this.mObserverMap.iteratorWithAdditions();
        while (safeIterableMap$IteratorWithAdditionsIteratorWithAdditions.hasNext() && !this.mNewEventOccurred) {
            Map$Entry next = safeIterableMap$IteratorWithAdditionsIteratorWithAdditions.next();
            LifecycleRegistry$ObserverWithState lifecycleRegistry$ObserverWithState = (LifecycleRegistry$ObserverWithState) next.getValue();
            while (lifecycleRegistry$ObserverWithState.mState.compareTo(this.mState) < 0 && !this.mNewEventOccurred && this.mObserverMap.contains((LifecycleObserver) next.getKey())) {
                pushParentState(lifecycleRegistry$ObserverWithState.mState);
                Lifecycle$Event lifecycle$EventUpFrom = Lifecycle$Event.upFrom(lifecycleRegistry$ObserverWithState.mState);
                if (lifecycle$EventUpFrom == null) {
                    StringBuilder sbU = a.U("no event up from ");
                    sbU.append(lifecycleRegistry$ObserverWithState.mState);
                    throw new IllegalStateException(sbU.toString());
                }
                lifecycleRegistry$ObserverWithState.dispatchEvent(lifecycleOwner, lifecycle$EventUpFrom);
                popParentState();
            }
        }
    }

    private boolean isSynced() {
        if (this.mObserverMap.size() == 0) {
            return true;
        }
        Lifecycle$State lifecycle$State = this.mObserverMap.eldest().getValue().mState;
        Lifecycle$State lifecycle$State2 = this.mObserverMap.newest().getValue().mState;
        return lifecycle$State == lifecycle$State2 && this.mState == lifecycle$State2;
    }

    public static Lifecycle$State min(@NonNull Lifecycle$State lifecycle$State, @Nullable Lifecycle$State lifecycle$State2) {
        return (lifecycle$State2 == null || lifecycle$State2.compareTo(lifecycle$State) >= 0) ? lifecycle$State : lifecycle$State2;
    }

    private void moveToState(Lifecycle$State lifecycle$State) {
        if (this.mState == lifecycle$State) {
            return;
        }
        this.mState = lifecycle$State;
        if (this.mHandlingEvent || this.mAddingObserverCounter != 0) {
            this.mNewEventOccurred = true;
            return;
        }
        this.mHandlingEvent = true;
        sync();
        this.mHandlingEvent = false;
    }

    private void popParentState() {
        ArrayList<Lifecycle$State> arrayList = this.mParentStates;
        arrayList.remove(arrayList.size() - 1);
    }

    private void pushParentState(Lifecycle$State lifecycle$State) {
        this.mParentStates.add(lifecycle$State);
    }

    private void sync() {
        LifecycleOwner lifecycleOwner = this.mLifecycleOwner.get();
        if (lifecycleOwner == null) {
            throw new IllegalStateException("LifecycleOwner of this LifecycleRegistry is alreadygarbage collected. It is too late to change lifecycle state.");
        }
        while (!isSynced()) {
            this.mNewEventOccurred = false;
            if (this.mState.compareTo(this.mObserverMap.eldest().getValue().mState) < 0) {
                backwardPass(lifecycleOwner);
            }
            Map$Entry<LifecycleObserver, LifecycleRegistry$ObserverWithState> map$EntryNewest = this.mObserverMap.newest();
            if (!this.mNewEventOccurred && map$EntryNewest != null && this.mState.compareTo(map$EntryNewest.getValue().mState) > 0) {
                forwardPass(lifecycleOwner);
            }
        }
        this.mNewEventOccurred = false;
    }

    @Override // androidx.view.Lifecycle
    public void addObserver(@NonNull LifecycleObserver lifecycleObserver) {
        LifecycleOwner lifecycleOwner;
        enforceMainThreadIfNeeded("addObserver");
        Lifecycle$State lifecycle$State = this.mState;
        Lifecycle$State lifecycle$State2 = Lifecycle$State.DESTROYED;
        if (lifecycle$State != lifecycle$State2) {
            lifecycle$State2 = Lifecycle$State.INITIALIZED;
        }
        LifecycleRegistry$ObserverWithState lifecycleRegistry$ObserverWithState = new LifecycleRegistry$ObserverWithState(lifecycleObserver, lifecycle$State2);
        if (this.mObserverMap.putIfAbsent(lifecycleObserver, lifecycleRegistry$ObserverWithState) == null && (lifecycleOwner = this.mLifecycleOwner.get()) != null) {
            boolean z2 = this.mAddingObserverCounter != 0 || this.mHandlingEvent;
            Lifecycle$State lifecycle$StateCalculateTargetState = calculateTargetState(lifecycleObserver);
            this.mAddingObserverCounter++;
            while (lifecycleRegistry$ObserverWithState.mState.compareTo(lifecycle$StateCalculateTargetState) < 0 && this.mObserverMap.contains(lifecycleObserver)) {
                pushParentState(lifecycleRegistry$ObserverWithState.mState);
                Lifecycle$Event lifecycle$EventUpFrom = Lifecycle$Event.upFrom(lifecycleRegistry$ObserverWithState.mState);
                if (lifecycle$EventUpFrom == null) {
                    StringBuilder sbU = a.U("no event up from ");
                    sbU.append(lifecycleRegistry$ObserverWithState.mState);
                    throw new IllegalStateException(sbU.toString());
                }
                lifecycleRegistry$ObserverWithState.dispatchEvent(lifecycleOwner, lifecycle$EventUpFrom);
                popParentState();
                lifecycle$StateCalculateTargetState = calculateTargetState(lifecycleObserver);
            }
            if (!z2) {
                sync();
            }
            this.mAddingObserverCounter--;
        }
    }

    @Override // androidx.view.Lifecycle
    @NonNull
    public Lifecycle$State getCurrentState() {
        return this.mState;
    }

    public int getObserverCount() {
        enforceMainThreadIfNeeded("getObserverCount");
        return this.mObserverMap.size();
    }

    public void handleLifecycleEvent(@NonNull Lifecycle$Event lifecycle$Event) {
        enforceMainThreadIfNeeded("handleLifecycleEvent");
        moveToState(lifecycle$Event.getTargetState());
    }

    @MainThread
    @Deprecated
    public void markState(@NonNull Lifecycle$State lifecycle$State) {
        enforceMainThreadIfNeeded("markState");
        setCurrentState(lifecycle$State);
    }

    @Override // androidx.view.Lifecycle
    public void removeObserver(@NonNull LifecycleObserver lifecycleObserver) {
        enforceMainThreadIfNeeded("removeObserver");
        this.mObserverMap.remove(lifecycleObserver);
    }

    @MainThread
    public void setCurrentState(@NonNull Lifecycle$State lifecycle$State) {
        enforceMainThreadIfNeeded("setCurrentState");
        moveToState(lifecycle$State);
    }

    private LifecycleRegistry(@NonNull LifecycleOwner lifecycleOwner, boolean z2) {
        this.mObserverMap = new FastSafeIterableMap<>();
        this.mAddingObserverCounter = 0;
        this.mHandlingEvent = false;
        this.mNewEventOccurred = false;
        this.mParentStates = new ArrayList<>();
        this.mLifecycleOwner = new WeakReference<>(lifecycleOwner);
        this.mState = Lifecycle$State.INITIALIZED;
        this.mEnforceMainThread = z2;
    }
}
