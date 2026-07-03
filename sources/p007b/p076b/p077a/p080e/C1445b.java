package p007b.p076b.p077a.p080e;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: renamed from: b.b.a.e.b */
/* JADX INFO: compiled from: ViewAttachmentPreviewItemBinding.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C1445b implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final ConstraintLayout f2189a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final SimpleDraweeView f2190b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final SimpleDraweeView f2191c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final View f2192d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final SimpleDraweeView f2193e;

    public C1445b(@NonNull ConstraintLayout constraintLayout, @NonNull SimpleDraweeView simpleDraweeView, @NonNull SimpleDraweeView simpleDraweeView2, @NonNull View view, @NonNull SimpleDraweeView simpleDraweeView3) {
        this.f2189a = constraintLayout;
        this.f2190b = simpleDraweeView;
        this.f2191c = simpleDraweeView2;
        this.f2192d = view;
        this.f2193e = simpleDraweeView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f2189a;
    }
}
