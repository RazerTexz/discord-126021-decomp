package p007b.p008a.p025i;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: renamed from: b.a.i.c3 */
/* JADX INFO: compiled from: ViewPremiumUpsellInfoBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0931c3 implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final LinearLayout f742a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final TextView f743b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final TextView f744c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final TextView f745d;

    public C0931c3(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3) {
        this.f742a = linearLayout;
        this.f743b = textView;
        this.f744c = textView2;
        this.f745d = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f742a;
    }
}
