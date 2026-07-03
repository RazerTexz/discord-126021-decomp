package p007b.p076b.p077a.p080e;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: renamed from: b.b.a.e.c */
/* JADX INFO: compiled from: ViewGridImageBinding.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C1446c implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final FrameLayout f2194a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final FrameLayout f2195b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final SimpleDraweeView f2196c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final SimpleDraweeView f2197d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final TextView f2198e;

    public C1446c(@NonNull FrameLayout frameLayout, @NonNull FrameLayout frameLayout2, @NonNull SimpleDraweeView simpleDraweeView, @NonNull SimpleDraweeView simpleDraweeView2, @NonNull TextView textView) {
        this.f2194a = frameLayout;
        this.f2195b = frameLayout2;
        this.f2196c = simpleDraweeView;
        this.f2197d = simpleDraweeView2;
        this.f2198e = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f2194a;
    }
}
