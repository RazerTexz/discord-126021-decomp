package b.a.i;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: compiled from: ViewServerDiscoveryHeaderBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class f3 implements ViewBinding {

    @NonNull
    public final View a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f112b;

    @NonNull
    public final FrameLayout c;

    @NonNull
    public final TextView d;

    public f3(@NonNull View view, @NonNull TextView textView, @NonNull ImageView imageView, @NonNull FrameLayout frameLayout, @NonNull TextView textView2) {
        this.a = view;
        this.f112b = textView;
        this.c = frameLayout;
        this.d = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
