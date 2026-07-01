package b.a.i;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: renamed from: b.a.i.p, reason: use source file name */
/* JADX INFO: compiled from: ForumBrowserLoadingBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class ForumBrowserLoadingBinding implements ViewBinding {

    @NonNull
    public final ConstraintLayout a;

    public ForumBrowserLoadingBinding(@NonNull ConstraintLayout constraintLayout) {
        this.a = constraintLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
