package b.a.i;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.views.StatusView;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: compiled from: UserAvatarPresenceViewBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class v1 implements ViewBinding {

    @NonNull
    public final RelativeLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final SimpleDraweeView f215b;

    @NonNull
    public final ImageView c;

    @NonNull
    public final SimpleDraweeView d;

    @NonNull
    public final StatusView e;

    public v1(@NonNull RelativeLayout relativeLayout, @NonNull SimpleDraweeView simpleDraweeView, @NonNull FrameLayout frameLayout, @NonNull ImageView imageView, @NonNull SimpleDraweeView simpleDraweeView2, @NonNull RelativeLayout relativeLayout2, @NonNull StatusView statusView) {
        this.a = relativeLayout;
        this.f215b = simpleDraweeView;
        this.c = imageView;
        this.d = simpleDraweeView2;
        this.e = statusView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
