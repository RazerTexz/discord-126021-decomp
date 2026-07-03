package p007b.p008a.p025i;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: renamed from: b.a.i.z2 */
/* JADX INFO: compiled from: ViewPremiumSettingsPerksBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class C1096z2 implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final LinearLayout f1435a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final TextView f1436b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final TextView f1437c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final TextView f1438d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final TextView f1439e;

    public C1096z2(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull TextView textView4, @NonNull TextView textView5) {
        this.f1435a = linearLayout;
        this.f1436b = textView;
        this.f1437c = textView3;
        this.f1438d = textView4;
        this.f1439e = textView5;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f1435a;
    }
}
