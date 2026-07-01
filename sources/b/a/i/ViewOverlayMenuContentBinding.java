package b.a.i;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: renamed from: b.a.i.t2, reason: use source file name */
/* JADX INFO: compiled from: ViewOverlayMenuContentBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class ViewOverlayMenuContentBinding implements ViewBinding {

    @NonNull
    public final CardView a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f203b;

    @NonNull
    public final TextView c;

    @NonNull
    public final TextView d;

    @NonNull
    public final ImageView e;

    @NonNull
    public final TextView f;

    @NonNull
    public final TextView g;

    public ViewOverlayMenuContentBinding(@NonNull CardView cardView, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull ImageView imageView, @NonNull TextView textView4, @NonNull TextView textView5) {
        this.a = cardView;
        this.f203b = textView;
        this.c = textView2;
        this.d = textView3;
        this.e = imageView;
        this.f = textView4;
        this.g = textView5;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
