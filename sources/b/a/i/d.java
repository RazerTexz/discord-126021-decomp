package b.a.i;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.textview.MaterialTextView;

/* JADX INFO: compiled from: BottomSheetSimpleSelectorItemBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class d implements ViewBinding {

    @NonNull
    public final ConstraintLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final MaterialTextView f95b;

    @NonNull
    public final SimpleDraweeView c;

    @NonNull
    public final MaterialTextView d;

    public d(@NonNull ConstraintLayout constraintLayout, @NonNull MaterialTextView materialTextView, @NonNull SimpleDraweeView simpleDraweeView, @NonNull MaterialTextView materialTextView2) {
        this.a = constraintLayout;
        this.f95b = materialTextView;
        this.c = simpleDraweeView;
        this.d = materialTextView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
