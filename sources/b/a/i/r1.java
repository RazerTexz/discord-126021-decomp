package b.a.i;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.rlottie.RLottieImageView;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: compiled from: StickerViewBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class r1 implements ViewBinding {

    @NonNull
    public final View a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final SimpleDraweeView f191b;

    @NonNull
    public final RLottieImageView c;

    @NonNull
    public final ImageView d;

    public r1(@NonNull View view, @NonNull SimpleDraweeView simpleDraweeView, @NonNull RLottieImageView rLottieImageView, @NonNull ImageView imageView) {
        this.a = view;
        this.f191b = simpleDraweeView;
        this.c = rLottieImageView;
        this.d = imageView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
