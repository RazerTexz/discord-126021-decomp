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

/* JADX INFO: compiled from: ViewServerSettingsUploadSplashBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class o3 implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final FrameLayout f174b;

    @NonNull
    public final FloatingActionButton c;

    @NonNull
    public final TextView d;

    @NonNull
    public final SimpleDraweeView e;

    @NonNull
    public final LinkifiedTextView f;

    @NonNull
    public final TextView g;

    @NonNull
    public final TextView h;

    public o3(@NonNull LinearLayout linearLayout, @NonNull FrameLayout frameLayout, @NonNull FloatingActionButton floatingActionButton, @NonNull TextView textView, @NonNull SimpleDraweeView simpleDraweeView, @NonNull LinkifiedTextView linkifiedTextView, @NonNull TextView textView2, @NonNull TextView textView3) {
        this.a = linearLayout;
        this.f174b = frameLayout;
        this.c = floatingActionButton;
        this.d = textView;
        this.e = simpleDraweeView;
        this.f = linkifiedTextView;
        this.g = textView2;
        this.h = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
