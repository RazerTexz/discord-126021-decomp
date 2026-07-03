package p007b.p008a.p025i;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: renamed from: b.a.i.a0 */
/* JADX INFO: compiled from: IconRowBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0912a0 implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final View f658a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final ImageView f659b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final TextView f660c;

    public C0912a0(@NonNull View view, @NonNull View view2, @NonNull ImageView imageView, @NonNull TextView textView) {
        this.f658a = view;
        this.f659b = imageView;
        this.f660c = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f658a;
    }
}
