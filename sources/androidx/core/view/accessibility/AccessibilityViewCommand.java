package androidx.core.view.accessibility;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public interface AccessibilityViewCommand {
    boolean perform(@NonNull View view, @Nullable AccessibilityViewCommand$CommandArguments accessibilityViewCommand$CommandArguments);
}
