package androidx.work.impl.constraints.controllers;

import androidx.annotation.NonNull;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface ConstraintController$OnConstraintUpdatedCallback {
    void onConstraintMet(@NonNull List<String> list);

    void onConstraintNotMet(@NonNull List<String> list);
}
