package b.a.i;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: renamed from: b.a.i.n1, reason: use source file name */
/* JADX INFO: compiled from: ShinyButtonBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class ShinyButtonBinding implements ViewBinding {

    @NonNull
    public final View a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final LinearLayout f165b;

    @NonNull
    public final ImageView c;

    @NonNull
    public final TextView d;

    public ShinyButtonBinding(@NonNull View view, @NonNull LinearLayout linearLayout, @NonNull ImageView imageView, @NonNull TextView textView) {
        this.a = view;
        this.f165b = linearLayout;
        this.c = imageView;
        this.d = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
