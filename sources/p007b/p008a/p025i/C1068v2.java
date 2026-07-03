package p007b.p008a.p025i;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.views.CutoutView;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: renamed from: b.a.i.v2 */
/* JADX INFO: compiled from: ViewPileItemBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class C1068v2 implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final CutoutView f1314a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final SimpleDraweeView f1315b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final SimpleDraweeView f1316c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final TextView f1317d;

    public C1068v2(@NonNull CutoutView cutoutView, @NonNull SimpleDraweeView simpleDraweeView, @NonNull SimpleDraweeView simpleDraweeView2, @NonNull TextView textView) {
        this.f1314a = cutoutView;
        this.f1315b = simpleDraweeView;
        this.f1316c = simpleDraweeView2;
        this.f1317d = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f1314a;
    }
}
