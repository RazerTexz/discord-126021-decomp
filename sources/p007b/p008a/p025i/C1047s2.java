package p007b.p008a.p025i;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: renamed from: b.a.i.s2 */
/* JADX INFO: compiled from: ViewOverlayMenuBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class C1047s2 implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final View f1206a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final C1054t2 f1207b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final ImageView f1208c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final ImageView f1209d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final ImageView f1210e;

    public C1047s2(@NonNull View view, @NonNull C1054t2 c1054t2, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull ImageView imageView3) {
        this.f1206a = view;
        this.f1207b = c1054t2;
        this.f1208c = imageView;
        this.f1209d = imageView2;
        this.f1210e = imageView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f1206a;
    }
}
