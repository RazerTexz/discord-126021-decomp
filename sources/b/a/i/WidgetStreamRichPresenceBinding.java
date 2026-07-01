package b.a.i;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.discord.views.StreamPreviewView;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: renamed from: b.a.i.d6, reason: use source file name */
/* JADX INFO: compiled from: WidgetStreamRichPresenceBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetStreamRichPresenceBinding implements ViewBinding {

    @NonNull
    public final ConstraintLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final LinearLayout f101b;

    @NonNull
    public final TextView c;

    @NonNull
    public final TextView d;

    @NonNull
    public final SimpleDraweeView e;

    @NonNull
    public final TextView f;

    @NonNull
    public final TextView g;

    @NonNull
    public final TextView h;

    @NonNull
    public final StreamPreviewView i;

    public WidgetStreamRichPresenceBinding(@NonNull ConstraintLayout constraintLayout, @NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull TextView textView2, @NonNull SimpleDraweeView simpleDraweeView, @NonNull TextView textView3, @NonNull TextView textView4, @NonNull TextView textView5, @NonNull StreamPreviewView streamPreviewView) {
        this.a = constraintLayout;
        this.f101b = linearLayout;
        this.c = textView;
        this.d = textView2;
        this.e = simpleDraweeView;
        this.f = textView3;
        this.g = textView4;
        this.h = textView5;
        this.i = streamPreviewView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
