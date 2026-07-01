package b.a.i;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.Barrier;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: renamed from: b.a.i.t5, reason: use source file name */
/* JADX INFO: compiled from: WidgetPlatformRichPresenceBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetPlatformRichPresenceBinding implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final LinearLayout f206b;

    @NonNull
    public final TextView c;

    @NonNull
    public final SimpleDraweeView d;

    @NonNull
    public final SimpleDraweeView e;

    @NonNull
    public final MaterialButton f;

    @NonNull
    public final TextView g;

    @NonNull
    public final TextView h;

    public WidgetPlatformRichPresenceBinding(@NonNull LinearLayout linearLayout, @NonNull Barrier barrier, @NonNull Space space, @NonNull LinearLayout linearLayout2, @NonNull TextView textView, @NonNull SimpleDraweeView simpleDraweeView, @NonNull SimpleDraweeView simpleDraweeView2, @NonNull MaterialButton materialButton, @NonNull TextView textView2, @NonNull TextView textView3) {
        this.a = linearLayout;
        this.f206b = linearLayout2;
        this.c = textView;
        this.d = simpleDraweeView;
        this.e = simpleDraweeView2;
        this.f = materialButton;
        this.g = textView2;
        this.h = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
