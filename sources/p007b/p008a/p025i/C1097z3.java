package p007b.p008a.p025i;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: renamed from: b.a.i.z3 */
/* JADX INFO: compiled from: ViewStreamPreviewBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class C1097z3 implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final ConstraintLayout f1440a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final SimpleDraweeView f1441b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final TextView f1442c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final TextView f1443d;

    public C1097z3(@NonNull ConstraintLayout constraintLayout, @NonNull SimpleDraweeView simpleDraweeView, @NonNull TextView textView, @NonNull TextView textView2) {
        this.f1440a = constraintLayout;
        this.f1441b = simpleDraweeView;
        this.f1442c = textView;
        this.f1443d = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f1440a;
    }
}
