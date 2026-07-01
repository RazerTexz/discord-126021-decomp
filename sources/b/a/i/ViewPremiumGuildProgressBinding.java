package b.a.i;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: renamed from: b.a.i.x2, reason: use source file name */
/* JADX INFO: compiled from: ViewPremiumGuildProgressBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class ViewPremiumGuildProgressBinding implements ViewBinding {

    @NonNull
    public final FrameLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f228b;

    @NonNull
    public final TextView c;

    @NonNull
    public final ProgressBar d;

    public ViewPremiumGuildProgressBinding(@NonNull FrameLayout frameLayout, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull ProgressBar progressBar) {
        this.a = frameLayout;
        this.f228b = imageView;
        this.c = textView;
        this.d = progressBar;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
