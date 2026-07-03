package p007b.p008a.p025i;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.Barrier;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: renamed from: b.a.i.c6 */
/* JADX INFO: compiled from: WidgetStageChannelRichPresenceBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0934c6 implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final LinearLayout f752a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final LinearLayout f753b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final TextView f754c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final TextView f755d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final SimpleDraweeView f756e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final TextView f757f;

    /* JADX INFO: renamed from: g */
    @NonNull
    public final MaterialButton f758g;

    /* JADX INFO: renamed from: h */
    @NonNull
    public final TextView f759h;

    /* JADX INFO: renamed from: i */
    @NonNull
    public final TextView f760i;

    public C0934c6(@NonNull LinearLayout linearLayout, @NonNull Barrier barrier, @NonNull Space space, @NonNull LinearLayout linearLayout2, @NonNull TextView textView, @NonNull TextView textView2, @NonNull SimpleDraweeView simpleDraweeView, @NonNull TextView textView3, @NonNull FrameLayout frameLayout, @NonNull MaterialButton materialButton, @NonNull TextView textView4, @NonNull TextView textView5) {
        this.f752a = linearLayout;
        this.f753b = linearLayout2;
        this.f754c = textView;
        this.f755d = textView2;
        this.f756e = simpleDraweeView;
        this.f757f = textView3;
        this.f758g = materialButton;
        this.f759h = textView4;
        this.f760i = textView5;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f752a;
    }
}
