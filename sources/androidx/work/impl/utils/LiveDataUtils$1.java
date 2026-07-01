package androidx.work.impl.utils;

import androidx.annotation.Nullable;
import androidx.arch.core.util.Function;
import androidx.view.MediatorLiveData;
import androidx.view.Observer;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;

/* JADX INFO: Add missing generic type declarations: [In] */
/* JADX INFO: loaded from: classes.dex */
public class LiveDataUtils$1<In> implements Observer<In> {
    public Out mCurrentOutput = null;
    public final /* synthetic */ Object val$lock;
    public final /* synthetic */ Function val$mappingMethod;
    public final /* synthetic */ MediatorLiveData val$outputLiveData;
    public final /* synthetic */ TaskExecutor val$workTaskExecutor;

    public LiveDataUtils$1(TaskExecutor taskExecutor, Object obj, Function function, MediatorLiveData mediatorLiveData) {
        this.val$workTaskExecutor = taskExecutor;
        this.val$lock = obj;
        this.val$mappingMethod = function;
        this.val$outputLiveData = mediatorLiveData;
    }

    @Override // androidx.view.Observer
    public void onChanged(@Nullable In in) {
        this.val$workTaskExecutor.executeOnBackgroundThread(new LiveDataUtils$1$1(this, in));
    }
}
