package androidx.work;

import androidx.annotation.RestrictTo;
import androidx.annotation.RestrictTo$Scope;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo$Scope.LIBRARY_GROUP})
public final class ListenableWorker$Result$Retry extends ListenableWorker$Result {
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && ListenableWorker$Result$Retry.class == obj.getClass();
    }

    public int hashCode() {
        return 25945934;
    }

    public String toString() {
        return "Retry";
    }
}
