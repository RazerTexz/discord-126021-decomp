package b.a.i;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.views.CutoutView;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: compiled from: ViewPileItemBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class v2 implements ViewBinding {

    @NonNull
    public final CutoutView a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final SimpleDraweeView f216b;

    @NonNull
    public final SimpleDraweeView c;

    @NonNull
    public final TextView d;

    public v2(@NonNull CutoutView cutoutView, @NonNull SimpleDraweeView simpleDraweeView, @NonNull SimpleDraweeView simpleDraweeView2, @NonNull TextView textView) {
        this.a = cutoutView;
        this.f216b = simpleDraweeView;
        this.c = simpleDraweeView2;
        this.d = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
