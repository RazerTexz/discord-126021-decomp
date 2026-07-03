package p007b.p008a.p025i;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: renamed from: b.a.i.a1 */
/* JADX INFO: compiled from: OverlayVoiceBubbleBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0913a1 implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final SimpleDraweeView f661a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final SimpleDraweeView f662b;

    public C0913a1(@NonNull SimpleDraweeView simpleDraweeView, @NonNull SimpleDraweeView simpleDraweeView2) {
        this.f661a = simpleDraweeView;
        this.f662b = simpleDraweeView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f661a;
    }
}
