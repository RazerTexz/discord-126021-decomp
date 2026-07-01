package androidx.work;

import android.os.Build$VERSION;
import androidx.annotation.NonNull;
import androidx.work.impl.model.WorkSpec;

/* JADX INFO: loaded from: classes.dex */
public final class OneTimeWorkRequest$Builder extends WorkRequest$Builder<OneTimeWorkRequest$Builder, OneTimeWorkRequest> {
    public OneTimeWorkRequest$Builder(@NonNull Class<? extends ListenableWorker> cls) {
        super(cls);
        this.mWorkSpec.inputMergerClassName = OverwritingInputMerger.class.getName();
    }

    @Override // androidx.work.WorkRequest$Builder
    @NonNull
    public /* bridge */ /* synthetic */ WorkRequest buildInternal() {
        return buildInternal();
    }

    @Override // androidx.work.WorkRequest$Builder
    @NonNull
    public OneTimeWorkRequest$Builder getThis() {
        return this;
    }

    @Override // androidx.work.WorkRequest$Builder
    @NonNull
    public /* bridge */ /* synthetic */ WorkRequest$Builder getThis() {
        return getThis();
    }

    @NonNull
    public OneTimeWorkRequest$Builder setInputMerger(@NonNull Class<? extends InputMerger> cls) {
        this.mWorkSpec.inputMergerClassName = cls.getName();
        return this;
    }

    @Override // androidx.work.WorkRequest$Builder
    @NonNull
    public OneTimeWorkRequest buildInternal() {
        if (this.mBackoffCriteriaSet && Build$VERSION.SDK_INT >= 23 && this.mWorkSpec.constraints.requiresDeviceIdle()) {
            throw new IllegalArgumentException("Cannot set backoff criteria on an idle mode job");
        }
        WorkSpec workSpec = this.mWorkSpec;
        if (workSpec.runInForeground && Build$VERSION.SDK_INT >= 23 && workSpec.constraints.requiresDeviceIdle()) {
            throw new IllegalArgumentException("Cannot run in foreground with an idle mode constraint");
        }
        return new OneTimeWorkRequest(this);
    }
}
