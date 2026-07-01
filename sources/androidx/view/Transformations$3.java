package androidx.view;

/* JADX INFO: Add missing generic type declarations: [X] */
/* JADX INFO: loaded from: classes.dex */
public class Transformations$3<X> implements Observer<X> {
    public boolean mFirstTime = true;
    public final /* synthetic */ MediatorLiveData val$outputLiveData;

    public Transformations$3(MediatorLiveData mediatorLiveData) {
        this.val$outputLiveData = mediatorLiveData;
    }

    @Override // androidx.view.Observer
    public void onChanged(X x2) {
        T value = this.val$outputLiveData.getValue();
        if (this.mFirstTime || ((value == 0 && x2 != null) || !(value == 0 || value.equals(x2)))) {
            this.mFirstTime = false;
            this.val$outputLiveData.setValue(x2);
        }
    }
}
