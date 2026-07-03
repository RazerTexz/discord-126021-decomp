package p007b.p008a.p025i;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.views.StatusView;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: renamed from: b.a.i.v1 */
/* JADX INFO: compiled from: UserAvatarPresenceViewBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class C1067v1 implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final RelativeLayout f1309a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final SimpleDraweeView f1310b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final ImageView f1311c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final SimpleDraweeView f1312d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final StatusView f1313e;

    public C1067v1(@NonNull RelativeLayout relativeLayout, @NonNull SimpleDraweeView simpleDraweeView, @NonNull FrameLayout frameLayout, @NonNull ImageView imageView, @NonNull SimpleDraweeView simpleDraweeView2, @NonNull RelativeLayout relativeLayout2, @NonNull StatusView statusView) {
        this.f1309a = relativeLayout;
        this.f1310b = simpleDraweeView;
        this.f1311c = imageView;
        this.f1312d = simpleDraweeView2;
        this.f1313e = statusView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f1309a;
    }
}
