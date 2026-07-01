package androidx.view;

/* JADX INFO: loaded from: classes.dex */
public class SavedStateHandle$SavingStateLiveData<T> extends MutableLiveData<T> {
    private SavedStateHandle mHandle;
    private String mKey;

    public SavedStateHandle$SavingStateLiveData(SavedStateHandle savedStateHandle, String str, T t) {
        super(t);
        this.mKey = str;
        this.mHandle = savedStateHandle;
    }

    public void detach() {
        this.mHandle = null;
    }

    @Override // androidx.view.MutableLiveData, androidx.view.LiveData
    public void setValue(T t) {
        SavedStateHandle savedStateHandle = this.mHandle;
        if (savedStateHandle != null) {
            savedStateHandle.mRegular.put(this.mKey, t);
        }
        super.setValue(t);
    }

    public SavedStateHandle$SavingStateLiveData(SavedStateHandle savedStateHandle, String str) {
        this.mKey = str;
        this.mHandle = savedStateHandle;
    }
}
