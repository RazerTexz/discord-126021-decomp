package b.a.i;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.app.AppViewFlipper;
import com.discord.rlottie.RLottieImageView;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: compiled from: WidgetAcceptGiftDialogBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class m4 implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final SimpleDraweeView f161b;

    @NonNull
    public final RLottieImageView c;

    @NonNull
    public final TextView d;

    @NonNull
    public final MaterialButton e;

    @NonNull
    public final LinearLayout f;

    @NonNull
    public final LinkifiedTextView g;

    @NonNull
    public final AppViewFlipper h;

    @NonNull
    public final TextView i;

    @NonNull
    public final ProgressBar j;

    public m4(@NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull SimpleDraweeView simpleDraweeView, @NonNull RLottieImageView rLottieImageView, @NonNull TextView textView, @NonNull MaterialButton materialButton, @NonNull LinearLayout linearLayout3, @NonNull LinkifiedTextView linkifiedTextView, @NonNull AppViewFlipper appViewFlipper, @NonNull TextView textView2, @NonNull ProgressBar progressBar) {
        this.a = linearLayout;
        this.f161b = simpleDraweeView;
        this.c = rLottieImageView;
        this.d = textView;
        this.e = materialButton;
        this.f = linearLayout3;
        this.g = linkifiedTextView;
        this.h = appViewFlipper;
        this.i = textView2;
        this.j = progressBar;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
