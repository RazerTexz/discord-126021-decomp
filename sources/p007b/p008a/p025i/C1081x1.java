package p007b.p008a.p025i;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: renamed from: b.a.i.x1 */
/* JADX INFO: compiled from: ViewAccountCreditBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class C1081x1 implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final ConstraintLayout f1368a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final TextView f1369b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final ImageView f1370c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final TextView f1371d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final TextView f1372e;

    public C1081x1(@NonNull ConstraintLayout constraintLayout, @NonNull TextView textView, @NonNull ImageView imageView, @NonNull TextView textView2, @NonNull LinearLayout linearLayout, @NonNull TextView textView3) {
        this.f1368a = constraintLayout;
        this.f1369b = textView;
        this.f1370c = imageView;
        this.f1371d = textView2;
        this.f1372e = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f1368a;
    }
}
