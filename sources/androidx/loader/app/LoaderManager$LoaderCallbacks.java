package androidx.loader.app;

import android.os.Bundle;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.loader.content.Loader;

/* JADX INFO: loaded from: classes.dex */
public interface LoaderManager$LoaderCallbacks<D> {
    @NonNull
    @MainThread
    Loader<D> onCreateLoader(int i, @Nullable Bundle bundle);

    @MainThread
    void onLoadFinished(@NonNull Loader<D> loader, D d);

    @MainThread
    void onLoaderReset(@NonNull Loader<D> loader);
}
