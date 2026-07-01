package b.a.n.g;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: compiled from: TrashWrapBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class a implements ViewBinding {

    @NonNull
    public final View a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f250b;

    @NonNull
    public final FrameLayout c;

    @NonNull
    public final FrameLayout d;

    public a(@NonNull View view, @NonNull ImageView imageView, @NonNull FrameLayout frameLayout, @NonNull FrameLayout frameLayout2) {
        this.a = view;
        this.f250b = imageView;
        this.c = frameLayout;
        this.d = frameLayout2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
