package p007b.p008a.p025i;

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

/* JADX INFO: renamed from: b.a.i.m4 */
/* JADX INFO: compiled from: WidgetAcceptGiftDialogBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class C1007m4 implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final LinearLayout f1053a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final SimpleDraweeView f1054b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final RLottieImageView f1055c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final TextView f1056d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final MaterialButton f1057e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final LinearLayout f1058f;

    /* JADX INFO: renamed from: g */
    @NonNull
    public final LinkifiedTextView f1059g;

    /* JADX INFO: renamed from: h */
    @NonNull
    public final AppViewFlipper f1060h;

    /* JADX INFO: renamed from: i */
    @NonNull
    public final TextView f1061i;

    /* JADX INFO: renamed from: j */
    @NonNull
    public final ProgressBar f1062j;

    public C1007m4(@NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull SimpleDraweeView simpleDraweeView, @NonNull RLottieImageView rLottieImageView, @NonNull TextView textView, @NonNull MaterialButton materialButton, @NonNull LinearLayout linearLayout3, @NonNull LinkifiedTextView linkifiedTextView, @NonNull AppViewFlipper appViewFlipper, @NonNull TextView textView2, @NonNull ProgressBar progressBar) {
        this.f1053a = linearLayout;
        this.f1054b = simpleDraweeView;
        this.f1055c = rLottieImageView;
        this.f1056d = textView;
        this.f1057e = materialButton;
        this.f1058f = linearLayout3;
        this.f1059g = linkifiedTextView;
        this.f1060h = appViewFlipper;
        this.f1061i = textView2;
        this.f1062j = progressBar;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f1053a;
    }
}
