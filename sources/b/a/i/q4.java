package b.a.i;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.widgets.voice.fullscreen.grid.PrivateCallBlurredGridView;
import com.discord.widgets.voice.fullscreen.grid.PrivateCallGridView;

/* JADX INFO: compiled from: WidgetCallFullscreenPrivateCallBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class q4 implements ViewBinding {

    @NonNull
    public final RelativeLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final PrivateCallBlurredGridView f187b;

    @NonNull
    public final TextView c;

    @NonNull
    public final RelativeLayout d;

    @NonNull
    public final LinearLayout e;

    @NonNull
    public final PrivateCallGridView f;

    @NonNull
    public final TextView g;

    @NonNull
    public final TextView h;

    @NonNull
    public final TextView i;

    public q4(@NonNull RelativeLayout relativeLayout, @NonNull PrivateCallBlurredGridView privateCallBlurredGridView, @NonNull TextView textView, @NonNull RelativeLayout relativeLayout2, @NonNull LinearLayout linearLayout, @NonNull PrivateCallGridView privateCallGridView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull TextView textView4) {
        this.a = relativeLayout;
        this.f187b = privateCallBlurredGridView;
        this.c = textView;
        this.d = relativeLayout2;
        this.e = linearLayout;
        this.f = privateCallGridView;
        this.g = textView2;
        this.h = textView3;
        this.i = textView4;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
