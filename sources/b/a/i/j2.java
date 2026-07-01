package b.a.i;

import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: compiled from: ViewGenericLoadingBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class j2 implements ViewBinding {

    @NonNull
    public final FrameLayout a;

    public j2(@NonNull FrameLayout frameLayout) {
        this.a = frameLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
