package androidx.work;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.annotation.RestrictTo$Scope;
import b.d.b.a.a;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo$Scope.LIBRARY_GROUP})
public final class ListenableWorker$Result$Failure extends ListenableWorker$Result {
    private final Data mOutputData;

    public ListenableWorker$Result$Failure() {
        this(Data.EMPTY);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ListenableWorker$Result$Failure.class != obj.getClass()) {
            return false;
        }
        return this.mOutputData.equals(((ListenableWorker$Result$Failure) obj).mOutputData);
    }

    @NonNull
    @RestrictTo({RestrictTo$Scope.LIBRARY_GROUP})
    public Data getOutputData() {
        return this.mOutputData;
    }

    public int hashCode() {
        return this.mOutputData.hashCode() + 846803280;
    }

    public String toString() {
        StringBuilder sbU = a.U("Failure {mOutputData=");
        sbU.append(this.mOutputData);
        sbU.append('}');
        return sbU.toString();
    }

    public ListenableWorker$Result$Failure(@NonNull Data data) {
        this.mOutputData = data;
    }
}
