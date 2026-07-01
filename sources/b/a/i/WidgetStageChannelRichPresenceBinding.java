package b.a.i;

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

/* JADX INFO: renamed from: b.a.i.c6, reason: use source file name */
/* JADX INFO: compiled from: WidgetStageChannelRichPresenceBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetStageChannelRichPresenceBinding implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final LinearLayout f94b;

    @NonNull
    public final TextView c;

    @NonNull
    public final TextView d;

    @NonNull
    public final SimpleDraweeView e;

    @NonNull
    public final TextView f;

    @NonNull
    public final MaterialButton g;

    @NonNull
    public final TextView h;

    @NonNull
    public final TextView i;

    public WidgetStageChannelRichPresenceBinding(@NonNull LinearLayout linearLayout, @NonNull Barrier barrier, @NonNull Space space, @NonNull LinearLayout linearLayout2, @NonNull TextView textView, @NonNull TextView textView2, @NonNull SimpleDraweeView simpleDraweeView, @NonNull TextView textView3, @NonNull FrameLayout frameLayout, @NonNull MaterialButton materialButton, @NonNull TextView textView4, @NonNull TextView textView5) {
        this.a = linearLayout;
        this.f94b = linearLayout2;
        this.c = textView;
        this.d = textView2;
        this.e = simpleDraweeView;
        this.f = textView3;
        this.g = materialButton;
        this.h = textView4;
        this.i = textView5;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
