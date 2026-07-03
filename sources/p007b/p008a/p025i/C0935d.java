package p007b.p008a.p025i;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.textview.MaterialTextView;

/* JADX INFO: renamed from: b.a.i.d */
/* JADX INFO: compiled from: BottomSheetSimpleSelectorItemBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0935d implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final ConstraintLayout f761a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final MaterialTextView f762b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final SimpleDraweeView f763c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final MaterialTextView f764d;

    public C0935d(@NonNull ConstraintLayout constraintLayout, @NonNull MaterialTextView materialTextView, @NonNull SimpleDraweeView simpleDraweeView, @NonNull MaterialTextView materialTextView2) {
        this.f761a = constraintLayout;
        this.f762b = materialTextView;
        this.f763c = simpleDraweeView;
        this.f764d = materialTextView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f761a;
    }
}
