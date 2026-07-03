package p007b.p008a.p025i;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: renamed from: b.a.i.g */
/* JADX INFO: compiled from: ChannelPermissionOwnerViewBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0959g implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final View f852a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final ImageView f853b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final TextView f854c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final SimpleDraweeView f855d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final TextView f856e;

    public C0959g(@NonNull View view, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull SimpleDraweeView simpleDraweeView, @NonNull TextView textView2) {
        this.f852a = view;
        this.f853b = imageView;
        this.f854c = textView;
        this.f855d = simpleDraweeView;
        this.f856e = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f852a;
    }
}
