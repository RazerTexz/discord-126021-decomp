package b.a.i;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: renamed from: b.a.i.s2, reason: use source file name */
/* JADX INFO: compiled from: ViewOverlayMenuBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class ViewOverlayMenuBinding implements ViewBinding {

    @NonNull
    public final View a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final ViewOverlayMenuContentBinding f197b;

    @NonNull
    public final ImageView c;

    @NonNull
    public final ImageView d;

    @NonNull
    public final ImageView e;

    public ViewOverlayMenuBinding(@NonNull View view, @NonNull ViewOverlayMenuContentBinding viewOverlayMenuContentBinding, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull ImageView imageView3) {
        this.a = view;
        this.f197b = viewOverlayMenuContentBinding;
        this.c = imageView;
        this.d = imageView2;
        this.e = imageView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
