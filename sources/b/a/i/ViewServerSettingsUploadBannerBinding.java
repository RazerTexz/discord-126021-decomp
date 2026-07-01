package b.a.i;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

/* JADX INFO: renamed from: b.a.i.n3, reason: use source file name */
/* JADX INFO: compiled from: ViewServerSettingsUploadBannerBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class ViewServerSettingsUploadBannerBinding implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final ViewServerSettingsUploadBannerAnimatedUpsellBinding f167b;

    @NonNull
    public final FrameLayout c;

    @NonNull
    public final TextView d;

    @NonNull
    public final SimpleDraweeView e;

    @NonNull
    public final FloatingActionButton f;

    @NonNull
    public final LinkifiedTextView g;

    @NonNull
    public final TextView h;

    @NonNull
    public final TextView i;

    public ViewServerSettingsUploadBannerBinding(@NonNull LinearLayout linearLayout, @NonNull ViewServerSettingsUploadBannerAnimatedUpsellBinding viewServerSettingsUploadBannerAnimatedUpsellBinding, @NonNull FrameLayout frameLayout, @NonNull TextView textView, @NonNull SimpleDraweeView simpleDraweeView, @NonNull FloatingActionButton floatingActionButton, @NonNull LinkifiedTextView linkifiedTextView, @NonNull TextView textView2, @NonNull TextView textView3) {
        this.a = linearLayout;
        this.f167b = viewServerSettingsUploadBannerAnimatedUpsellBinding;
        this.c = frameLayout;
        this.d = textView;
        this.e = simpleDraweeView;
        this.f = floatingActionButton;
        this.g = linkifiedTextView;
        this.h = textView2;
        this.i = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
