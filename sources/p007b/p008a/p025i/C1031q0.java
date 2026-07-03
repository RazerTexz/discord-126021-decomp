package p007b.p008a.p025i;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: renamed from: b.a.i.q0 */
/* JADX INFO: compiled from: LayoutFullscreenCallPreviewEmptyBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class C1031q0 implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final ConstraintLayout f1142a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final ConstraintLayout f1143b;

    public C1031q0(@NonNull ConstraintLayout constraintLayout, @NonNull ImageView imageView, @NonNull ConstraintLayout constraintLayout2, @NonNull TextView textView, @NonNull TextView textView2) {
        this.f1142a = constraintLayout;
        this.f1143b = constraintLayout2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f1142a;
    }
}
