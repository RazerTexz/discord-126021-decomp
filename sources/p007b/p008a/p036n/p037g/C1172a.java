package p007b.p008a.p036n.p037g;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: renamed from: b.a.n.g.a */
/* JADX INFO: compiled from: TrashWrapBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class C1172a implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final View f1557a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final ImageView f1558b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final FrameLayout f1559c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final FrameLayout f1560d;

    public C1172a(@NonNull View view, @NonNull ImageView imageView, @NonNull FrameLayout frameLayout, @NonNull FrameLayout frameLayout2) {
        this.f1557a = view;
        this.f1558b = imageView;
        this.f1559c = frameLayout;
        this.f1560d = frameLayout2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f1557a;
    }
}
