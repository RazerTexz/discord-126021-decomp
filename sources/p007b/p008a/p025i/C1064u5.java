package p007b.p008a.p025i;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: renamed from: b.a.i.u5 */
/* JADX INFO: compiled from: WidgetPremiumUpsellBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class C1064u5 implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final LinearLayout f1296a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final TextView f1297b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final TextView f1298c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final ImageView f1299d;

    public C1064u5(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull TextView textView2, @NonNull ImageView imageView) {
        this.f1296a = linearLayout;
        this.f1297b = textView;
        this.f1298c = textView2;
        this.f1299d = imageView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f1296a;
    }
}
