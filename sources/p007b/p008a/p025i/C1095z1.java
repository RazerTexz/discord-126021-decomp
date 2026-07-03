package p007b.p008a.p025i;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: renamed from: b.a.i.z1 */
/* JADX INFO: compiled from: ViewAddOverrideItemBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class C1095z1 implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final ConstraintLayout f1434a;

    public C1095z1(@NonNull ConstraintLayout constraintLayout, @NonNull TextView textView, @NonNull Guideline guideline, @NonNull ImageView imageView) {
        this.f1434a = constraintLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f1434a;
    }
}
