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

/* JADX INFO: compiled from: ViewServerSettingsUploadBannerBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class n3 implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final m3 f167b;

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

    public n3(@NonNull LinearLayout linearLayout, @NonNull m3 m3Var, @NonNull FrameLayout frameLayout, @NonNull TextView textView, @NonNull SimpleDraweeView simpleDraweeView, @NonNull FloatingActionButton floatingActionButton, @NonNull LinkifiedTextView linkifiedTextView, @NonNull TextView textView2, @NonNull TextView textView3) {
        this.a = linearLayout;
        this.f167b = m3Var;
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
