package androidx.work.impl.constraints;

import androidx.annotation.NonNull;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface WorkConstraintsCallback {
    void onAllConstraintsMet(@NonNull List<String> list);

    void onAllConstraintsNotMet(@NonNull List<String> list);
}
