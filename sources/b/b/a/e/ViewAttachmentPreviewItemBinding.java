package b.b.a.e;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: renamed from: b.b.a.e.b, reason: use source file name */
/* JADX INFO: compiled from: ViewAttachmentPreviewItemBinding.java */
/* JADX INFO: loaded from: classes3.dex */
public final class ViewAttachmentPreviewItemBinding implements ViewBinding {

    @NonNull
    public final ConstraintLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final SimpleDraweeView f323b;

    @NonNull
    public final SimpleDraweeView c;

    @NonNull
    public final View d;

    @NonNull
    public final SimpleDraweeView e;

    public ViewAttachmentPreviewItemBinding(@NonNull ConstraintLayout constraintLayout, @NonNull SimpleDraweeView simpleDraweeView, @NonNull SimpleDraweeView simpleDraweeView2, @NonNull View view, @NonNull SimpleDraweeView simpleDraweeView3) {
        this.a = constraintLayout;
        this.f323b = simpleDraweeView;
        this.c = simpleDraweeView2;
        this.d = view;
        this.e = simpleDraweeView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
