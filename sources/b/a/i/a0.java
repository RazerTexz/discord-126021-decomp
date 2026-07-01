package b.a.i;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: compiled from: IconRowBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class a0 implements ViewBinding {

    @NonNull
    public final View a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f73b;

    @NonNull
    public final TextView c;

    public a0(@NonNull View view, @NonNull View view2, @NonNull ImageView imageView, @NonNull TextView textView) {
        this.a = view;
        this.f73b = imageView;
        this.c = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
