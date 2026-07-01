package b.a.i;

import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: renamed from: b.a.i.j2, reason: use source file name */
/* JADX INFO: compiled from: ViewGenericLoadingBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class ViewGenericLoadingBinding implements ViewBinding {

    @NonNull
    public final FrameLayout a;

    public ViewGenericLoadingBinding(@NonNull FrameLayout frameLayout) {
        this.a = frameLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
