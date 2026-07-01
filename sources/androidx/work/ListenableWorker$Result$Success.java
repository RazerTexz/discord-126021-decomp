package androidx.work;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.annotation.RestrictTo$Scope;
import b.d.b.a.a;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo$Scope.LIBRARY_GROUP})
public final class ListenableWorker$Result$Success extends ListenableWorker$Result {
    private final Data mOutputData;

    public ListenableWorker$Result$Success() {
        this(Data.EMPTY);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ListenableWorker$Result$Success.class != obj.getClass()) {
            return false;
        }
        return this.mOutputData.equals(((ListenableWorker$Result$Success) obj).mOutputData);
    }

    @NonNull
    @RestrictTo({RestrictTo$Scope.LIBRARY_GROUP})
    public Data getOutputData() {
        return this.mOutputData;
    }

    public int hashCode() {
        return this.mOutputData.hashCode() - 1876823561;
    }

    public String toString() {
        StringBuilder sbU = a.U("Success {mOutputData=");
        sbU.append(this.mOutputData);
        sbU.append('}');
        return sbU.toString();
    }

    public ListenableWorker$Result$Success(@NonNull Data data) {
        this.mOutputData = data;
    }
}
