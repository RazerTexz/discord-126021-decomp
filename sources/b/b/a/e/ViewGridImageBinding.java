package b.b.a.e;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: renamed from: b.b.a.e.c, reason: use source file name */
/* JADX INFO: compiled from: ViewGridImageBinding.java */
/* JADX INFO: loaded from: classes3.dex */
public final class ViewGridImageBinding implements ViewBinding {

    @NonNull
    public final FrameLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final FrameLayout f324b;

    @NonNull
    public final SimpleDraweeView c;

    @NonNull
    public final SimpleDraweeView d;

    @NonNull
    public final TextView e;

    public ViewGridImageBinding(@NonNull FrameLayout frameLayout, @NonNull FrameLayout frameLayout2, @NonNull SimpleDraweeView simpleDraweeView, @NonNull SimpleDraweeView simpleDraweeView2, @NonNull TextView textView) {
        this.a = frameLayout;
        this.f324b = frameLayout2;
        this.c = simpleDraweeView;
        this.d = simpleDraweeView2;
        this.e = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
