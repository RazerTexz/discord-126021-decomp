package b.a.i;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.R$id;
import com.discord.views.CutoutView;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: compiled from: ViewUserSummaryItemBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class f4 implements ViewBinding {

    @NonNull
    public final CutoutView a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final SimpleDraweeView f113b;

    public f4(@NonNull CutoutView cutoutView, @NonNull SimpleDraweeView simpleDraweeView) {
        this.a = cutoutView;
        this.f113b = simpleDraweeView;
    }

    @NonNull
    public static f4 a(@NonNull View view) {
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R$id.avatar);
        if (simpleDraweeView != null) {
            return new f4((CutoutView) view, simpleDraweeView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R$id.avatar)));
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
