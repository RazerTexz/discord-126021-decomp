package b.a.i;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: renamed from: b.a.i.w2, reason: use source file name */
/* JADX INFO: compiled from: ViewPremiumGuildProgressBarBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class ViewPremiumGuildProgressBarBinding implements ViewBinding {

    @NonNull
    public final ConstraintLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final ProgressBar f222b;

    @NonNull
    public final ImageView c;

    @NonNull
    public final ImageView d;

    @NonNull
    public final TextView e;

    @NonNull
    public final ImageView f;

    @NonNull
    public final TextView g;

    @NonNull
    public final ImageView h;

    @NonNull
    public final TextView i;

    public ViewPremiumGuildProgressBarBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ProgressBar progressBar, @NonNull FrameLayout frameLayout, @NonNull ImageView imageView, @NonNull LinearLayout linearLayout, @NonNull ImageView imageView2, @NonNull TextView textView, @NonNull LinearLayout linearLayout2, @NonNull ImageView imageView3, @NonNull TextView textView2, @NonNull LinearLayout linearLayout3, @NonNull ImageView imageView4, @NonNull TextView textView3) {
        this.a = constraintLayout;
        this.f222b = progressBar;
        this.c = imageView;
        this.d = imageView2;
        this.e = textView;
        this.f = imageView3;
        this.g = textView2;
        this.h = imageView4;
        this.i = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
