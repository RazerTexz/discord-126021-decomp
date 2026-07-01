package androidx.loader.app;

import android.util.Log;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.loader.content.Loader;
import androidx.view.Observer;
import b.d.b.a.a;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes.dex */
public class LoaderManagerImpl$LoaderObserver<D> implements Observer<D> {

    @NonNull
    private final LoaderManager$LoaderCallbacks<D> mCallback;
    private boolean mDeliveredData = false;

    @NonNull
    private final Loader<D> mLoader;

    public LoaderManagerImpl$LoaderObserver(@NonNull Loader<D> loader, @NonNull LoaderManager$LoaderCallbacks<D> loaderManager$LoaderCallbacks) {
        this.mLoader = loader;
        this.mCallback = loaderManager$LoaderCallbacks;
    }

    public void dump(String str, PrintWriter printWriter) {
        printWriter.print(str);
        printWriter.print("mDeliveredData=");
        printWriter.println(this.mDeliveredData);
    }

    public boolean hasDeliveredData() {
        return this.mDeliveredData;
    }

    @Override // androidx.view.Observer
    public void onChanged(@Nullable D d) {
        if (LoaderManagerImpl.DEBUG) {
            StringBuilder sbU = a.U("  onLoadFinished in ");
            sbU.append(this.mLoader);
            sbU.append(": ");
            sbU.append(this.mLoader.dataToString(d));
            Log.v(LoaderManagerImpl.TAG, sbU.toString());
        }
        this.mCallback.onLoadFinished(this.mLoader, d);
        this.mDeliveredData = true;
    }

    @MainThread
    public void reset() {
        if (this.mDeliveredData) {
            if (LoaderManagerImpl.DEBUG) {
                StringBuilder sbU = a.U("  Resetting: ");
                sbU.append(this.mLoader);
                Log.v(LoaderManagerImpl.TAG, sbU.toString());
            }
            this.mCallback.onLoaderReset(this.mLoader);
        }
    }

    public String toString() {
        return this.mCallback.toString();
    }
}
