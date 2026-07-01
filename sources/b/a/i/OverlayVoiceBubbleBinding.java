package b.a.i;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: renamed from: b.a.i.a1, reason: use source file name */
/* JADX INFO: compiled from: OverlayVoiceBubbleBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class OverlayVoiceBubbleBinding implements ViewBinding {

    @NonNull
    public final SimpleDraweeView a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final SimpleDraweeView f74b;

    public OverlayVoiceBubbleBinding(@NonNull SimpleDraweeView simpleDraweeView, @NonNull SimpleDraweeView simpleDraweeView2) {
        this.a = simpleDraweeView;
        this.f74b = simpleDraweeView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
