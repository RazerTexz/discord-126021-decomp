package b.a.i;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: compiled from: ForumBrowserLoadingBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class p implements ViewBinding {

    @NonNull
    public final ConstraintLayout a;

    public p(@NonNull ConstraintLayout constraintLayout) {
        this.a = constraintLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
