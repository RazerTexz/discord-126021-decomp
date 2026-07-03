package p007b.p008a.p025i;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: renamed from: b.a.i.m5 */
/* JADX INFO: compiled from: WidgetHomePanelLoadingBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class C1008m5 implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final FrameLayout f1063a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final ImageView f1064b;

    public C1008m5(@NonNull FrameLayout frameLayout, @NonNull ImageView imageView) {
        this.f1063a = frameLayout;
        this.f1064b = imageView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f1063a;
    }
}
