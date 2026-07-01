package b.a.i;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: renamed from: b.a.i.m5, reason: use source file name */
/* JADX INFO: compiled from: WidgetHomePanelLoadingBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetHomePanelLoadingBinding implements ViewBinding {

    @NonNull
    public final FrameLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f162b;

    public WidgetHomePanelLoadingBinding(@NonNull FrameLayout frameLayout, @NonNull ImageView imageView) {
        this.a = frameLayout;
        this.f162b = imageView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
