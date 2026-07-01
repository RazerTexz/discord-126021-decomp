package b.a.i;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: renamed from: b.a.i.x1, reason: use source file name */
/* JADX INFO: compiled from: ViewAccountCreditBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class ViewAccountCreditBinding implements ViewBinding {

    @NonNull
    public final ConstraintLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f227b;

    @NonNull
    public final ImageView c;

    @NonNull
    public final TextView d;

    @NonNull
    public final TextView e;

    public ViewAccountCreditBinding(@NonNull ConstraintLayout constraintLayout, @NonNull TextView textView, @NonNull ImageView imageView, @NonNull TextView textView2, @NonNull LinearLayout linearLayout, @NonNull TextView textView3) {
        this.a = constraintLayout;
        this.f227b = textView;
        this.c = imageView;
        this.d = textView2;
        this.e = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
