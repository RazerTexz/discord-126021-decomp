package androidx.loader.app;

import androidx.annotation.NonNull;
import androidx.collection.SparseArrayCompat;
import androidx.view.ViewModel;
import androidx.view.ViewModelProvider;
import androidx.view.ViewModelProvider$Factory;
import androidx.view.ViewModelStore;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes.dex */
public class LoaderManagerImpl$LoaderViewModel extends ViewModel {
    private static final ViewModelProvider$Factory FACTORY = new LoaderManagerImpl$LoaderViewModel$1();
    private SparseArrayCompat<LoaderManagerImpl$LoaderInfo> mLoaders = new SparseArrayCompat<>();
    private boolean mCreatingLoader = false;

    @NonNull
    public static LoaderManagerImpl$LoaderViewModel getInstance(ViewModelStore viewModelStore) {
        return (LoaderManagerImpl$LoaderViewModel) new ViewModelProvider(viewModelStore, FACTORY).get(LoaderManagerImpl$LoaderViewModel.class);
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        if (this.mLoaders.size() > 0) {
            printWriter.print(str);
            printWriter.println("Loaders:");
            String str2 = str + "    ";
            for (int i = 0; i < this.mLoaders.size(); i++) {
                LoaderManagerImpl$LoaderInfo loaderManagerImpl$LoaderInfoValueAt = this.mLoaders.valueAt(i);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.mLoaders.keyAt(i));
                printWriter.print(": ");
                printWriter.println(loaderManagerImpl$LoaderInfoValueAt.toString());
                loaderManagerImpl$LoaderInfoValueAt.dump(str2, fileDescriptor, printWriter, strArr);
            }
        }
    }

    public void finishCreatingLoader() {
        this.mCreatingLoader = false;
    }

    public <D> LoaderManagerImpl$LoaderInfo<D> getLoader(int i) {
        return this.mLoaders.get(i);
    }

    public boolean hasRunningLoaders() {
        int size = this.mLoaders.size();
        for (int i = 0; i < size; i++) {
            if (this.mLoaders.valueAt(i).isCallbackWaitingForData()) {
                return true;
            }
        }
        return false;
    }

    public boolean isCreatingLoader() {
        return this.mCreatingLoader;
    }

    public void markForRedelivery() {
        int size = this.mLoaders.size();
        for (int i = 0; i < size; i++) {
            this.mLoaders.valueAt(i).markForRedelivery();
        }
    }

    @Override // androidx.view.ViewModel
    public void onCleared() {
        super.onCleared();
        int size = this.mLoaders.size();
        for (int i = 0; i < size; i++) {
            this.mLoaders.valueAt(i).destroy(true);
        }
        this.mLoaders.clear();
    }

    public void putLoader(int i, @NonNull LoaderManagerImpl$LoaderInfo loaderManagerImpl$LoaderInfo) {
        this.mLoaders.put(i, loaderManagerImpl$LoaderInfo);
    }

    public void removeLoader(int i) {
        this.mLoaders.remove(i);
    }

    public void startCreatingLoader() {
        this.mCreatingLoader = true;
    }
}
