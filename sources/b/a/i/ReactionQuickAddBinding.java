package b.a.i;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: renamed from: b.a.i.h1, reason: use source file name */
/* JADX INFO: compiled from: ReactionQuickAddBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class ReactionQuickAddBinding implements ViewBinding {

    @NonNull
    public final ImageView a;

    public ReactionQuickAddBinding(@NonNull ImageView imageView, @NonNull ImageView imageView2) {
        this.a = imageView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
