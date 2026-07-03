package p007b.p008a.p025i;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: renamed from: b.a.i.t2 */
/* JADX INFO: compiled from: ViewOverlayMenuContentBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class C1054t2 implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final CardView f1243a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final TextView f1244b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final TextView f1245c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final TextView f1246d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final ImageView f1247e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final TextView f1248f;

    /* JADX INFO: renamed from: g */
    @NonNull
    public final TextView f1249g;

    public C1054t2(@NonNull CardView cardView, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull ImageView imageView, @NonNull TextView textView4, @NonNull TextView textView5) {
        this.f1243a = cardView;
        this.f1244b = textView;
        this.f1245c = textView2;
        this.f1246d = textView3;
        this.f1247e = imageView;
        this.f1248f = textView4;
        this.f1249g = textView5;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f1243a;
    }
}
