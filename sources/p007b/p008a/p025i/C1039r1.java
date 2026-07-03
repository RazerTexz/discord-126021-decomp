package p007b.p008a.p025i;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.rlottie.RLottieImageView;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: renamed from: b.a.i.r1 */
/* JADX INFO: compiled from: StickerViewBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class C1039r1 implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final View f1176a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final SimpleDraweeView f1177b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final RLottieImageView f1178c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final ImageView f1179d;

    public C1039r1(@NonNull View view, @NonNull SimpleDraweeView simpleDraweeView, @NonNull RLottieImageView rLottieImageView, @NonNull ImageView imageView) {
        this.f1176a = view;
        this.f1177b = simpleDraweeView;
        this.f1178c = rLottieImageView;
        this.f1179d = imageView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f1176a;
    }
}
