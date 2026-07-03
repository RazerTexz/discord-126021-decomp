package p007b.p008a.p025i;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: renamed from: b.a.i.m2 */
/* JADX INFO: compiled from: ViewInteractionFailedLabelBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class C1005m2 implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final ConstraintLayout f1047a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final TextView f1048b;

    public C1005m2(@NonNull ConstraintLayout constraintLayout, @NonNull ImageView imageView, @NonNull TextView textView) {
        this.f1047a = constraintLayout;
        this.f1048b = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f1047a;
    }
}
