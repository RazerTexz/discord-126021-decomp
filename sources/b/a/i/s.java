package b.a.i;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: compiled from: GuildBoostActivatedDialogBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class s implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f194b;

    @NonNull
    public final TextView c;

    @NonNull
    public final LottieAnimationView d;

    @NonNull
    public final MaterialButton e;

    public s(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull TextView textView2, @NonNull LottieAnimationView lottieAnimationView, @NonNull MaterialButton materialButton) {
        this.a = linearLayout;
        this.f194b = textView;
        this.c = textView2;
        this.d = lottieAnimationView;
        this.e = materialButton;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
