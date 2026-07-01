package androidx.work.impl;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.annotation.RestrictTo$Scope;
import androidx.view.LiveData;
import androidx.view.MutableLiveData;
import androidx.work.Operation;
import androidx.work.Operation$State;
import androidx.work.Operation$State$FAILURE;
import androidx.work.Operation$State$SUCCESS;
import androidx.work.impl.utils.futures.SettableFuture;
import b.i.b.d.a.a;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo$Scope.LIBRARY_GROUP})
public class OperationImpl implements Operation {
    private final MutableLiveData<Operation$State> mOperationState = new MutableLiveData<>();
    private final SettableFuture<Operation$State$SUCCESS> mOperationFuture = SettableFuture.create();

    public OperationImpl() {
        setState(Operation.IN_PROGRESS);
    }

    @Override // androidx.work.Operation
    @NonNull
    public a<Operation$State$SUCCESS> getResult() {
        return this.mOperationFuture;
    }

    @Override // androidx.work.Operation
    @NonNull
    public LiveData<Operation$State> getState() {
        return this.mOperationState;
    }

    public void setState(@NonNull Operation$State operation$State) {
        this.mOperationState.postValue(operation$State);
        if (operation$State instanceof Operation$State$SUCCESS) {
            this.mOperationFuture.set((Operation$State$SUCCESS) operation$State);
        } else if (operation$State instanceof Operation$State$FAILURE) {
            this.mOperationFuture.setException(((Operation$State$FAILURE) operation$State).getThrowable());
        }
    }
}
