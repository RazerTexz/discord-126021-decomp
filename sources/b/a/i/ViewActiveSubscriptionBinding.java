package b.a.i;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: renamed from: b.a.i.y1, reason: use source file name */
/* JADX INFO: compiled from: ViewActiveSubscriptionBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class ViewActiveSubscriptionBinding implements ViewBinding {

    @NonNull
    public final FrameLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f234b;

    @NonNull
    public final ImageView c;

    @NonNull
    public final ImageView d;

    @NonNull
    public final ImageView e;

    @NonNull
    public final TextView f;

    @NonNull
    public final MaterialButton g;

    @NonNull
    public final ProgressBar h;

    @NonNull
    public final MaterialButton i;

    public ViewActiveSubscriptionBinding(@NonNull FrameLayout frameLayout, @NonNull TextView textView, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull ImageView imageView3, @NonNull TextView textView2, @NonNull MaterialButton materialButton, @NonNull ProgressBar progressBar, @NonNull MaterialButton materialButton2) {
        this.a = frameLayout;
        this.f234b = textView;
        this.c = imageView;
        this.d = imageView2;
        this.e = imageView3;
        this.f = textView2;
        this.g = materialButton;
        this.h = progressBar;
        this.i = materialButton2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
