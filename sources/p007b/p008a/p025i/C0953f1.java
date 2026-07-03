package p007b.p008a.p025i;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: renamed from: b.a.i.f1 */
/* JADX INFO: compiled from: PremiumUpgradeYearlyDialogBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0953f1 implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final LinearLayout f834a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final ImageView f835b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final TextView f836c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final TextView f837d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final TextView f838e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final MaterialButton f839f;

    public C0953f1(@NonNull LinearLayout linearLayout, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull MaterialButton materialButton) {
        this.f834a = linearLayout;
        this.f835b = imageView;
        this.f836c = textView;
        this.f837d = textView2;
        this.f838e = textView3;
        this.f839f = materialButton;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f834a;
    }
}
