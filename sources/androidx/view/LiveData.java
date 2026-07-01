package androidx.view;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.arch.core.internal.SafeIterableMap;
import androidx.arch.core.internal.SafeIterableMap$IteratorWithAdditions;
import b.d.b.a.a;
import java.util.Map$Entry;

/* JADX INFO: loaded from: classes.dex */
public abstract class LiveData<T> {
    public static final Object NOT_SET = new Object();
    public static final int START_VERSION = -1;
    public int mActiveCount;
    private boolean mChangingActiveState;
    private volatile Object mData;
    public final Object mDataLock;
    private boolean mDispatchInvalidated;
    private boolean mDispatchingValue;
    private SafeIterableMap<Observer<? super T>, LiveData<T>.LiveData$ObserverWrapper> mObservers;
    public volatile Object mPendingData;
    private final Runnable mPostValueRunnable;
    private int mVersion;

    public LiveData(T t) {
        this.mDataLock = new Object();
        this.mObservers = new SafeIterableMap<>();
        this.mActiveCount = 0;
        this.mPendingData = NOT_SET;
        this.mPostValueRunnable = new LiveData$1(this);
        this.mData = t;
        this.mVersion = 0;
    }

    public static void assertMainThread(String str) {
        if (!ArchTaskExecutor.getInstance().isMainThread()) {
            throw new IllegalStateException(a.y("Cannot invoke ", str, " on a background thread"));
        }
    }

    /* JADX WARN: Incorrect inner types in method signature: (Landroidx/lifecycle/LiveData<TT;>.ObserverWrapper;)V */
    private void considerNotify(LiveData$ObserverWrapper liveData$ObserverWrapper) {
        if (liveData$ObserverWrapper.mActive) {
            if (!liveData$ObserverWrapper.shouldBeActive()) {
                liveData$ObserverWrapper.activeStateChanged(false);
                return;
            }
            int i = liveData$ObserverWrapper.mLastVersion;
            int i2 = this.mVersion;
            if (i >= i2) {
                return;
            }
            liveData$ObserverWrapper.mLastVersion = i2;
            liveData$ObserverWrapper.mObserver.onChanged((Object) this.mData);
        }
    }

    @MainThread
    public void changeActiveCounter(int i) {
        int i2 = this.mActiveCount;
        this.mActiveCount = i + i2;
        if (this.mChangingActiveState) {
            return;
        }
        this.mChangingActiveState = true;
        while (true) {
            try {
                int i3 = this.mActiveCount;
                if (i2 == i3) {
                    this.mChangingActiveState = false;
                    return;
                }
                boolean z2 = i2 == 0 && i3 > 0;
                boolean z3 = i2 > 0 && i3 == 0;
                if (z2) {
                    onActive();
                } else if (z3) {
                    onInactive();
                }
                i2 = i3;
            } catch (Throwable th) {
                this.mChangingActiveState = false;
                throw th;
            }
        }
    }

    /* JADX WARN: Incorrect inner types in method signature: (Landroidx/lifecycle/LiveData<TT;>.ObserverWrapper;)V */
    public void dispatchingValue(@Nullable LiveData$ObserverWrapper liveData$ObserverWrapper) {
        if (this.mDispatchingValue) {
            this.mDispatchInvalidated = true;
            return;
        }
        this.mDispatchingValue = true;
        do {
            this.mDispatchInvalidated = false;
            if (liveData$ObserverWrapper != null) {
                considerNotify(liveData$ObserverWrapper);
                liveData$ObserverWrapper = null;
            } else {
                SafeIterableMap$IteratorWithAdditions safeIterableMap$IteratorWithAdditionsIteratorWithAdditions = this.mObservers.iteratorWithAdditions();
                while (safeIterableMap$IteratorWithAdditionsIteratorWithAdditions.hasNext()) {
                    considerNotify((LiveData$ObserverWrapper) safeIterableMap$IteratorWithAdditionsIteratorWithAdditions.next().getValue());
                    if (this.mDispatchInvalidated) {
                        break;
                    }
                }
            }
        } while (this.mDispatchInvalidated);
        this.mDispatchingValue = false;
    }

    @Nullable
    public T getValue() {
        T t = (T) this.mData;
        if (t != NOT_SET) {
            return t;
        }
        return null;
    }

    public int getVersion() {
        return this.mVersion;
    }

    public boolean hasActiveObservers() {
        return this.mActiveCount > 0;
    }

    public boolean hasObservers() {
        return this.mObservers.size() > 0;
    }

    @MainThread
    public void observe(@NonNull LifecycleOwner lifecycleOwner, @NonNull Observer<? super T> observer) {
        assertMainThread("observe");
        if (lifecycleOwner.getLifecycle().getCurrentState() == Lifecycle$State.DESTROYED) {
            return;
        }
        LiveData$LifecycleBoundObserver liveData$LifecycleBoundObserver = new LiveData$LifecycleBoundObserver(this, lifecycleOwner, observer);
        LiveData<T>.LiveData$ObserverWrapper liveData$ObserverWrapperPutIfAbsent = this.mObservers.putIfAbsent(observer, liveData$LifecycleBoundObserver);
        if (liveData$ObserverWrapperPutIfAbsent != null && !liveData$ObserverWrapperPutIfAbsent.isAttachedTo(lifecycleOwner)) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        }
        if (liveData$ObserverWrapperPutIfAbsent != null) {
            return;
        }
        lifecycleOwner.getLifecycle().addObserver(liveData$LifecycleBoundObserver);
    }

    @MainThread
    public void observeForever(@NonNull Observer<? super T> observer) {
        assertMainThread("observeForever");
        LiveData$AlwaysActiveObserver liveData$AlwaysActiveObserver = new LiveData$AlwaysActiveObserver(this, observer);
        LiveData<T>.LiveData$ObserverWrapper liveData$ObserverWrapperPutIfAbsent = this.mObservers.putIfAbsent(observer, liveData$AlwaysActiveObserver);
        if (liveData$ObserverWrapperPutIfAbsent instanceof LiveData$LifecycleBoundObserver) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        }
        if (liveData$ObserverWrapperPutIfAbsent != null) {
            return;
        }
        liveData$AlwaysActiveObserver.activeStateChanged(true);
    }

    public void onActive() {
    }

    public void onInactive() {
    }

    public void postValue(T t) {
        boolean z2;
        synchronized (this.mDataLock) {
            z2 = this.mPendingData == NOT_SET;
            this.mPendingData = t;
        }
        if (z2) {
            ArchTaskExecutor.getInstance().postToMainThread(this.mPostValueRunnable);
        }
    }

    @MainThread
    public void removeObserver(@NonNull Observer<? super T> observer) {
        assertMainThread("removeObserver");
        LiveData<T>.LiveData$ObserverWrapper liveData$ObserverWrapperRemove = this.mObservers.remove(observer);
        if (liveData$ObserverWrapperRemove == null) {
            return;
        }
        liveData$ObserverWrapperRemove.detachObserver();
        liveData$ObserverWrapperRemove.activeStateChanged(false);
    }

    @MainThread
    public void removeObservers(@NonNull LifecycleOwner lifecycleOwner) {
        assertMainThread("removeObservers");
        for (Map$Entry<Observer<? super T>, LiveData<T>.LiveData$ObserverWrapper> map$Entry : this.mObservers) {
            if (map$Entry.getValue().isAttachedTo(lifecycleOwner)) {
                removeObserver(map$Entry.getKey());
            }
        }
    }

    @MainThread
    public void setValue(T t) {
        assertMainThread("setValue");
        this.mVersion++;
        this.mData = t;
        dispatchingValue(null);
    }

    public LiveData() {
        this.mDataLock = new Object();
        this.mObservers = new SafeIterableMap<>();
        this.mActiveCount = 0;
        Object obj = NOT_SET;
        this.mPendingData = obj;
        this.mPostValueRunnable = new LiveData$1(this);
        this.mData = obj;
        this.mVersion = -1;
    }
}
