package b.a.i;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.Space;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.Barrier;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: compiled from: WidgetMusicRichPresenceBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class s5 implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final LinearLayout f200b;

    @NonNull
    public final TextView c;

    @NonNull
    public final TextView d;

    @NonNull
    public final SimpleDraweeView e;

    @NonNull
    public final SimpleDraweeView f;

    @NonNull
    public final TextView g;

    @NonNull
    public final TextView h;

    @NonNull
    public final MaterialButton i;

    @NonNull
    public final SeekBar j;

    @NonNull
    public final TextView k;

    @NonNull
    public final TextView l;

    public s5(@NonNull LinearLayout linearLayout, @NonNull Barrier barrier, @NonNull Space space, @NonNull LinearLayout linearLayout2, @NonNull TextView textView, @NonNull TextView textView2, @NonNull SimpleDraweeView simpleDraweeView, @NonNull SimpleDraweeView simpleDraweeView2, @NonNull TextView textView3, @NonNull TextView textView4, @NonNull FrameLayout frameLayout, @NonNull MaterialButton materialButton, @NonNull SeekBar seekBar, @NonNull TextView textView5, @NonNull TextView textView6) {
        this.a = linearLayout;
        this.f200b = linearLayout2;
        this.c = textView;
        this.d = textView2;
        this.e = simpleDraweeView;
        this.f = simpleDraweeView2;
        this.g = textView3;
        this.h = textView4;
        this.i = materialButton;
        this.j = seekBar;
        this.k = textView5;
        this.l = textView6;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
