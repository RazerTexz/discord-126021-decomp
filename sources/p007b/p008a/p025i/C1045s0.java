package p007b.p008a.p025i;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: renamed from: b.a.i.s0 */
/* JADX INFO: compiled from: LayoutPremiumSettingsPaymentBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class C1045s0 implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final LinearLayout f1195a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final MaterialButton f1196b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final View f1197c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final TextView f1198d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final TextView f1199e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final LinearLayout f1200f;

    /* JADX INFO: renamed from: g */
    @NonNull
    public final TextView f1201g;

    public C1045s0(@NonNull LinearLayout linearLayout, @NonNull MaterialButton materialButton, @NonNull View view, @NonNull TextView textView, @NonNull TextView textView2, @NonNull LinearLayout linearLayout2, @NonNull TextView textView3) {
        this.f1195a = linearLayout;
        this.f1196b = materialButton;
        this.f1197c = view;
        this.f1198d = textView;
        this.f1199e = textView2;
        this.f1200f = linearLayout2;
        this.f1201g = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f1195a;
    }
}
