package p007b.p008a.p025i;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: renamed from: b.a.i.u0 */
/* JADX INFO: compiled from: LayoutVoiceBottomSheetHeaderBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class C1059u0 implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final ConstraintLayout f1273a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final ImageView f1274b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final ImageView f1275c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final ImageView f1276d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final ImageView f1277e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final TextView f1278f;

    /* JADX INFO: renamed from: g */
    @NonNull
    public final TextView f1279g;

    public C1059u0(@NonNull ConstraintLayout constraintLayout, @NonNull Barrier barrier, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull ImageView imageView3, @NonNull ImageView imageView4, @NonNull ImageView imageView5, @NonNull TextView textView, @NonNull TextView textView2) {
        this.f1273a = constraintLayout;
        this.f1274b = imageView;
        this.f1275c = imageView3;
        this.f1276d = imageView4;
        this.f1277e = imageView5;
        this.f1278f = textView;
        this.f1279g = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f1273a;
    }
}
