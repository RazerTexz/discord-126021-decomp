package p007b.p008a.p025i;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.discord.views.LoadingButton;

/* JADX INFO: renamed from: b.a.i.k0 */
/* JADX INFO: compiled from: LayoutContactSyncLandingBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0989k0 implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final ConstraintLayout f991a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final TextView f992b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final LoadingButton f993c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final View f994d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final C1017o0 f995e;

    public C0989k0(@NonNull ConstraintLayout constraintLayout, @NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull LoadingButton loadingButton, @NonNull View view, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull C1017o0 c1017o0) {
        this.f991a = constraintLayout;
        this.f992b = textView;
        this.f993c = loadingButton;
        this.f994d = view;
        this.f995e = c1017o0;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f991a;
    }
}
