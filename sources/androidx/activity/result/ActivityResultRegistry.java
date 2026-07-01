package androidx.activity.result;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityOptionsCompat;
import androidx.view.Lifecycle;
import androidx.view.Lifecycle$State;
import androidx.view.LifecycleOwner;
import b.d.b.a.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/* JADX INFO: loaded from: classes.dex */
public abstract class ActivityResultRegistry {
    private static final int INITIAL_REQUEST_CODE_VALUE = 65536;
    private static final String KEY_COMPONENT_ACTIVITY_PENDING_RESULTS = "KEY_COMPONENT_ACTIVITY_PENDING_RESULT";
    private static final String KEY_COMPONENT_ACTIVITY_RANDOM_OBJECT = "KEY_COMPONENT_ACTIVITY_RANDOM_OBJECT";
    private static final String KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS = "KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS";
    private static final String KEY_COMPONENT_ACTIVITY_REGISTERED_RCS = "KEY_COMPONENT_ACTIVITY_REGISTERED_RCS";
    private static final String LOG_TAG = "ActivityResultRegistry";
    private Random mRandom = new Random();
    private final Map<Integer, String> mRcToKey = new HashMap();
    private final Map<String, Integer> mKeyToRc = new HashMap();
    private final Map<String, ActivityResultRegistry$LifecycleContainer> mKeyToLifecycleContainers = new HashMap();
    public final transient Map<String, ActivityResultRegistry$CallbackAndContract<?>> mKeyToCallback = new HashMap();
    public final Map<String, Object> mParsedPendingResults = new HashMap();
    public final Bundle mPendingResults = new Bundle();

    private void bindRcKey(int i, String str) {
        this.mRcToKey.put(Integer.valueOf(i), str);
        this.mKeyToRc.put(str, Integer.valueOf(i));
    }

    private <O> void doDispatch(String str, int i, @Nullable Intent intent, @Nullable ActivityResultRegistry$CallbackAndContract<O> activityResultRegistry$CallbackAndContract) {
        ActivityResultCallback<O> activityResultCallback;
        if (activityResultRegistry$CallbackAndContract != null && (activityResultCallback = activityResultRegistry$CallbackAndContract.mCallback) != null) {
            activityResultCallback.onActivityResult(activityResultRegistry$CallbackAndContract.mContract.parseResult(i, intent));
        } else {
            this.mParsedPendingResults.remove(str);
            this.mPendingResults.putParcelable(str, new ActivityResult(i, intent));
        }
    }

    private int generateRandomNumber() {
        int iNextInt = this.mRandom.nextInt(2147418112);
        while (true) {
            int i = iNextInt + 65536;
            if (!this.mRcToKey.containsKey(Integer.valueOf(i))) {
                return i;
            }
            iNextInt = this.mRandom.nextInt(2147418112);
        }
    }

    private int registerKey(String str) {
        Integer num = this.mKeyToRc.get(str);
        if (num != null) {
            return num.intValue();
        }
        int iGenerateRandomNumber = generateRandomNumber();
        bindRcKey(iGenerateRandomNumber, str);
        return iGenerateRandomNumber;
    }

    @MainThread
    public final boolean dispatchResult(int i, int i2, @Nullable Intent intent) {
        String str = this.mRcToKey.get(Integer.valueOf(i));
        if (str == null) {
            return false;
        }
        doDispatch(str, i2, intent, this.mKeyToCallback.get(str));
        return true;
    }

    @MainThread
    public abstract <I, O> void onLaunch(int i, @NonNull ActivityResultContract<I, O> activityResultContract, @SuppressLint({"UnknownNullness"}) I i2, @Nullable ActivityOptionsCompat activityOptionsCompat);

    public final void onRestoreInstanceState(@Nullable Bundle bundle) {
        if (bundle == null) {
            return;
        }
        ArrayList<Integer> integerArrayList = bundle.getIntegerArrayList(KEY_COMPONENT_ACTIVITY_REGISTERED_RCS);
        ArrayList<String> stringArrayList = bundle.getStringArrayList(KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS);
        if (stringArrayList == null || integerArrayList == null) {
            return;
        }
        int size = stringArrayList.size();
        for (int i = 0; i < size; i++) {
            bindRcKey(integerArrayList.get(i).intValue(), stringArrayList.get(i));
        }
        this.mRandom = (Random) bundle.getSerializable(KEY_COMPONENT_ACTIVITY_RANDOM_OBJECT);
        this.mPendingResults.putAll(bundle.getBundle(KEY_COMPONENT_ACTIVITY_PENDING_RESULTS));
    }

    public final void onSaveInstanceState(@NonNull Bundle bundle) {
        bundle.putIntegerArrayList(KEY_COMPONENT_ACTIVITY_REGISTERED_RCS, new ArrayList<>(this.mRcToKey.keySet()));
        bundle.putStringArrayList(KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS, new ArrayList<>(this.mRcToKey.values()));
        bundle.putBundle(KEY_COMPONENT_ACTIVITY_PENDING_RESULTS, (Bundle) this.mPendingResults.clone());
        bundle.putSerializable(KEY_COMPONENT_ACTIVITY_RANDOM_OBJECT, this.mRandom);
    }

    @NonNull
    public final <I, O> ActivityResultLauncher<I> register(@NonNull String str, @NonNull LifecycleOwner lifecycleOwner, @NonNull ActivityResultContract<I, O> activityResultContract, @NonNull ActivityResultCallback<O> activityResultCallback) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        if (lifecycle.getCurrentState().isAtLeast(Lifecycle$State.STARTED)) {
            throw new IllegalStateException("LifecycleOwner " + lifecycleOwner + " is attempting to register while current state is " + lifecycle.getCurrentState() + ". LifecycleOwners must call register before they are STARTED.");
        }
        int iRegisterKey = registerKey(str);
        ActivityResultRegistry$LifecycleContainer activityResultRegistry$LifecycleContainer = this.mKeyToLifecycleContainers.get(str);
        if (activityResultRegistry$LifecycleContainer == null) {
            activityResultRegistry$LifecycleContainer = new ActivityResultRegistry$LifecycleContainer(lifecycle);
        }
        activityResultRegistry$LifecycleContainer.addObserver(new ActivityResultRegistry$1(this, str, activityResultCallback, activityResultContract));
        this.mKeyToLifecycleContainers.put(str, activityResultRegistry$LifecycleContainer);
        return new ActivityResultRegistry$2(this, iRegisterKey, activityResultContract, str);
    }

    @MainThread
    public final void unregister(@NonNull String str) {
        Integer numRemove = this.mKeyToRc.remove(str);
        if (numRemove != null) {
            this.mRcToKey.remove(numRemove);
        }
        this.mKeyToCallback.remove(str);
        if (this.mParsedPendingResults.containsKey(str)) {
            StringBuilder sbY = a.Y("Dropping pending result for request ", str, ": ");
            sbY.append(this.mParsedPendingResults.get(str));
            Log.w(LOG_TAG, sbY.toString());
            this.mParsedPendingResults.remove(str);
        }
        if (this.mPendingResults.containsKey(str)) {
            StringBuilder sbY2 = a.Y("Dropping pending result for request ", str, ": ");
            sbY2.append(this.mPendingResults.getParcelable(str));
            Log.w(LOG_TAG, sbY2.toString());
            this.mPendingResults.remove(str);
        }
        ActivityResultRegistry$LifecycleContainer activityResultRegistry$LifecycleContainer = this.mKeyToLifecycleContainers.get(str);
        if (activityResultRegistry$LifecycleContainer != null) {
            activityResultRegistry$LifecycleContainer.clearObservers();
            this.mKeyToLifecycleContainers.remove(str);
        }
    }

    @MainThread
    public final <O> boolean dispatchResult(int i, @SuppressLint({"UnknownNullness"}) O o) {
        ActivityResultCallback<?> activityResultCallback;
        String str = this.mRcToKey.get(Integer.valueOf(i));
        if (str == null) {
            return false;
        }
        ActivityResultRegistry$CallbackAndContract<?> activityResultRegistry$CallbackAndContract = this.mKeyToCallback.get(str);
        if (activityResultRegistry$CallbackAndContract != null && (activityResultCallback = activityResultRegistry$CallbackAndContract.mCallback) != null) {
            activityResultCallback.onActivityResult(o);
            return true;
        }
        this.mPendingResults.remove(str);
        this.mParsedPendingResults.put(str, o);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NonNull
    public final <I, O> ActivityResultLauncher<I> register(@NonNull String str, @NonNull ActivityResultContract<I, O> activityResultContract, @NonNull ActivityResultCallback<O> activityResultCallback) {
        int iRegisterKey = registerKey(str);
        this.mKeyToCallback.put(str, new ActivityResultRegistry$CallbackAndContract<>(activityResultCallback, activityResultContract));
        if (this.mParsedPendingResults.containsKey(str)) {
            Object obj = this.mParsedPendingResults.get(str);
            this.mParsedPendingResults.remove(str);
            activityResultCallback.onActivityResult(obj);
        }
        ActivityResult activityResult = (ActivityResult) this.mPendingResults.getParcelable(str);
        if (activityResult != null) {
            this.mPendingResults.remove(str);
            activityResultCallback.onActivityResult(activityResultContract.parseResult(activityResult.getResultCode(), activityResult.getData()));
        }
        return new ActivityResultRegistry$3(this, iRegisterKey, activityResultContract, str);
    }
}
