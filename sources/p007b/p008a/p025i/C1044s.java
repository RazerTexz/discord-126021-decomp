package p007b.p008a.p025i;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: renamed from: b.a.i.s */
/* JADX INFO: compiled from: GuildBoostActivatedDialogBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class C1044s implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final LinearLayout f1190a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final TextView f1191b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final TextView f1192c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final LottieAnimationView f1193d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final MaterialButton f1194e;

    public C1044s(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull TextView textView2, @NonNull LottieAnimationView lottieAnimationView, @NonNull MaterialButton materialButton) {
        this.f1190a = linearLayout;
        this.f1191b = textView;
        this.f1192c = textView2;
        this.f1193d = lottieAnimationView;
        this.f1194e = materialButton;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f1190a;
    }
}
