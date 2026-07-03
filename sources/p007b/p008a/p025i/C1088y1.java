package p007b.p008a.p025i;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: renamed from: b.a.i.y1 */
/* JADX INFO: compiled from: ViewActiveSubscriptionBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class C1088y1 implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final FrameLayout f1398a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final TextView f1399b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final ImageView f1400c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final ImageView f1401d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final ImageView f1402e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final TextView f1403f;

    /* JADX INFO: renamed from: g */
    @NonNull
    public final MaterialButton f1404g;

    /* JADX INFO: renamed from: h */
    @NonNull
    public final ProgressBar f1405h;

    /* JADX INFO: renamed from: i */
    @NonNull
    public final MaterialButton f1406i;

    public C1088y1(@NonNull FrameLayout frameLayout, @NonNull TextView textView, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull ImageView imageView3, @NonNull TextView textView2, @NonNull MaterialButton materialButton, @NonNull ProgressBar progressBar, @NonNull MaterialButton materialButton2) {
        this.f1398a = frameLayout;
        this.f1399b = textView;
        this.f1400c = imageView;
        this.f1401d = imageView2;
        this.f1402e = imageView3;
        this.f1403f = textView2;
        this.f1404g = materialButton;
        this.f1405h = progressBar;
        this.f1406i = materialButton2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f1398a;
    }
}
