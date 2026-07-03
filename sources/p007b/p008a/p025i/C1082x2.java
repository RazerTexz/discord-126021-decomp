package p007b.p008a.p025i;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: renamed from: b.a.i.x2 */
/* JADX INFO: compiled from: ViewPremiumGuildProgressBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class C1082x2 implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final FrameLayout f1373a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final ImageView f1374b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final TextView f1375c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final ProgressBar f1376d;

    public C1082x2(@NonNull FrameLayout frameLayout, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull ProgressBar progressBar) {
        this.f1373a = frameLayout;
        this.f1374b = imageView;
        this.f1375c = textView;
        this.f1376d = progressBar;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f1373a;
    }
}
