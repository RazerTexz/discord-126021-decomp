package androidx.core.view.accessibility;

import android.os.Bundle;
import androidx.annotation.RestrictTo;
import androidx.annotation.RestrictTo$Scope;

/* JADX INFO: loaded from: classes.dex */
public abstract class AccessibilityViewCommand$CommandArguments {
    public Bundle mBundle;

    @RestrictTo({RestrictTo$Scope.LIBRARY_GROUP_PREFIX})
    public void setBundle(Bundle bundle) {
        this.mBundle = bundle;
    }
}
