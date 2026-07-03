package p007b.p008a.p025i;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: renamed from: b.a.i.w2 */
/* JADX INFO: compiled from: ViewPremiumGuildProgressBarBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class C1075w2 implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final ConstraintLayout f1339a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final ProgressBar f1340b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final ImageView f1341c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final ImageView f1342d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final TextView f1343e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final ImageView f1344f;

    /* JADX INFO: renamed from: g */
    @NonNull
    public final TextView f1345g;

    /* JADX INFO: renamed from: h */
    @NonNull
    public final ImageView f1346h;

    /* JADX INFO: renamed from: i */
    @NonNull
    public final TextView f1347i;

    public C1075w2(@NonNull ConstraintLayout constraintLayout, @NonNull ProgressBar progressBar, @NonNull FrameLayout frameLayout, @NonNull ImageView imageView, @NonNull LinearLayout linearLayout, @NonNull ImageView imageView2, @NonNull TextView textView, @NonNull LinearLayout linearLayout2, @NonNull ImageView imageView3, @NonNull TextView textView2, @NonNull LinearLayout linearLayout3, @NonNull ImageView imageView4, @NonNull TextView textView3) {
        this.f1339a = constraintLayout;
        this.f1340b = progressBar;
        this.f1341c = imageView;
        this.f1342d = imageView2;
        this.f1343e = textView;
        this.f1344f = imageView3;
        this.f1345g = textView2;
        this.f1346h = imageView4;
        this.f1347i = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f1339a;
    }
}
