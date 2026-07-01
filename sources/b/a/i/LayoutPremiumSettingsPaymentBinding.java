package b.a.i;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: renamed from: b.a.i.s0, reason: use source file name */
/* JADX INFO: compiled from: LayoutPremiumSettingsPaymentBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class LayoutPremiumSettingsPaymentBinding implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final MaterialButton f195b;

    @NonNull
    public final View c;

    @NonNull
    public final TextView d;

    @NonNull
    public final TextView e;

    @NonNull
    public final LinearLayout f;

    @NonNull
    public final TextView g;

    public LayoutPremiumSettingsPaymentBinding(@NonNull LinearLayout linearLayout, @NonNull MaterialButton materialButton, @NonNull View view, @NonNull TextView textView, @NonNull TextView textView2, @NonNull LinearLayout linearLayout2, @NonNull TextView textView3) {
        this.a = linearLayout;
        this.f195b = materialButton;
        this.c = view;
        this.d = textView;
        this.e = textView2;
        this.f = linearLayout2;
        this.g = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
