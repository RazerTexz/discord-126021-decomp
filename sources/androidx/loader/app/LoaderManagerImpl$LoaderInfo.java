package androidx.loader.app;

import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.DebugUtils;
import androidx.loader.content.Loader;
import androidx.loader.content.Loader$OnLoadCompleteListener;
import androidx.view.LifecycleOwner;
import androidx.view.MutableLiveData;
import androidx.view.Observer;
import b.d.b.a.a;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes.dex */
public class LoaderManagerImpl$LoaderInfo<D> extends MutableLiveData<D> implements Loader$OnLoadCompleteListener<D> {

    @Nullable
    private final Bundle mArgs;
    private final int mId;
    private LifecycleOwner mLifecycleOwner;

    @NonNull
    private final Loader<D> mLoader;
    private LoaderManagerImpl$LoaderObserver<D> mObserver;
    private Loader<D> mPriorLoader;

    public LoaderManagerImpl$LoaderInfo(int i, @Nullable Bundle bundle, @NonNull Loader<D> loader, @Nullable Loader<D> loader2) {
        this.mId = i;
        this.mArgs = bundle;
        this.mLoader = loader;
        this.mPriorLoader = loader2;
        loader.registerListener(i, this);
    }

    @MainThread
    public Loader<D> destroy(boolean z2) {
        if (LoaderManagerImpl.DEBUG) {
            Log.v(LoaderManagerImpl.TAG, "  Destroying: " + this);
        }
        this.mLoader.cancelLoad();
        this.mLoader.abandon();
        LoaderManagerImpl$LoaderObserver<D> loaderManagerImpl$LoaderObserver = this.mObserver;
        if (loaderManagerImpl$LoaderObserver != null) {
            removeObserver(loaderManagerImpl$LoaderObserver);
            if (z2) {
                loaderManagerImpl$LoaderObserver.reset();
            }
        }
        this.mLoader.unregisterListener(this);
        if ((loaderManagerImpl$LoaderObserver == null || loaderManagerImpl$LoaderObserver.hasDeliveredData()) && !z2) {
            return this.mLoader;
        }
        this.mLoader.reset();
        return this.mPriorLoader;
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mId=");
        printWriter.print(this.mId);
        printWriter.print(" mArgs=");
        printWriter.println(this.mArgs);
        printWriter.print(str);
        printWriter.print("mLoader=");
        printWriter.println(this.mLoader);
        this.mLoader.dump(a.w(str, "  "), fileDescriptor, printWriter, strArr);
        if (this.mObserver != null) {
            printWriter.print(str);
            printWriter.print("mCallbacks=");
            printWriter.println(this.mObserver);
            this.mObserver.dump(str + "  ", printWriter);
        }
        printWriter.print(str);
        printWriter.print("mData=");
        printWriter.println(getLoader().dataToString(getValue()));
        printWriter.print(str);
        printWriter.print("mStarted=");
        printWriter.println(hasActiveObservers());
    }

    @NonNull
    public Loader<D> getLoader() {
        return this.mLoader;
    }

    public boolean isCallbackWaitingForData() {
        LoaderManagerImpl$LoaderObserver<D> loaderManagerImpl$LoaderObserver;
        return (!hasActiveObservers() || (loaderManagerImpl$LoaderObserver = this.mObserver) == null || loaderManagerImpl$LoaderObserver.hasDeliveredData()) ? false : true;
    }

    public void markForRedelivery() {
        LifecycleOwner lifecycleOwner = this.mLifecycleOwner;
        LoaderManagerImpl$LoaderObserver<D> loaderManagerImpl$LoaderObserver = this.mObserver;
        if (lifecycleOwner == null || loaderManagerImpl$LoaderObserver == null) {
            return;
        }
        super.removeObserver(loaderManagerImpl$LoaderObserver);
        observe(lifecycleOwner, loaderManagerImpl$LoaderObserver);
    }

    @Override // androidx.view.LiveData
    public void onActive() {
        if (LoaderManagerImpl.DEBUG) {
            Log.v(LoaderManagerImpl.TAG, "  Starting: " + this);
        }
        this.mLoader.startLoading();
    }

    @Override // androidx.view.LiveData
    public void onInactive() {
        if (LoaderManagerImpl.DEBUG) {
            Log.v(LoaderManagerImpl.TAG, "  Stopping: " + this);
        }
        this.mLoader.stopLoading();
    }

    @Override // androidx.loader.content.Loader$OnLoadCompleteListener
    public void onLoadComplete(@NonNull Loader<D> loader, @Nullable D d) {
        if (LoaderManagerImpl.DEBUG) {
            Log.v(LoaderManagerImpl.TAG, "onLoadComplete: " + this);
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            setValue(d);
            return;
        }
        if (LoaderManagerImpl.DEBUG) {
            Log.w(LoaderManagerImpl.TAG, "onLoadComplete was incorrectly called on a background thread");
        }
        postValue(d);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.view.LiveData
    public void removeObserver(@NonNull Observer<? super D> observer) {
        super.removeObserver(observer);
        this.mLifecycleOwner = null;
        this.mObserver = null;
    }

    @NonNull
    @MainThread
    public Loader<D> setCallback(@NonNull LifecycleOwner lifecycleOwner, @NonNull LoaderManager$LoaderCallbacks<D> loaderManager$LoaderCallbacks) {
        LoaderManagerImpl$LoaderObserver<D> loaderManagerImpl$LoaderObserver = new LoaderManagerImpl$LoaderObserver<>(this.mLoader, loaderManager$LoaderCallbacks);
        observe(lifecycleOwner, loaderManagerImpl$LoaderObserver);
        LoaderManagerImpl$LoaderObserver<D> loaderManagerImpl$LoaderObserver2 = this.mObserver;
        if (loaderManagerImpl$LoaderObserver2 != null) {
            removeObserver(loaderManagerImpl$LoaderObserver2);
        }
        this.mLifecycleOwner = lifecycleOwner;
        this.mObserver = loaderManagerImpl$LoaderObserver;
        return this.mLoader;
    }

    @Override // androidx.view.MutableLiveData, androidx.view.LiveData
    public void setValue(D d) {
        super.setValue(d);
        Loader<D> loader = this.mPriorLoader;
        if (loader != null) {
            loader.reset();
            this.mPriorLoader = null;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        sb.append("LoaderInfo{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" #");
        sb.append(this.mId);
        sb.append(" : ");
        DebugUtils.buildShortClassTag(this.mLoader, sb);
        sb.append("}}");
        return sb.toString();
    }
}
