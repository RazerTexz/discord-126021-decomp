package p007b.p008a.p025i;

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

/* JADX INFO: renamed from: b.a.i.s5 */
/* JADX INFO: compiled from: WidgetMusicRichPresenceBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class C1050s5 implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final LinearLayout f1219a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final LinearLayout f1220b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final TextView f1221c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final TextView f1222d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final SimpleDraweeView f1223e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final SimpleDraweeView f1224f;

    /* JADX INFO: renamed from: g */
    @NonNull
    public final TextView f1225g;

    /* JADX INFO: renamed from: h */
    @NonNull
    public final TextView f1226h;

    /* JADX INFO: renamed from: i */
    @NonNull
    public final MaterialButton f1227i;

    /* JADX INFO: renamed from: j */
    @NonNull
    public final SeekBar f1228j;

    /* JADX INFO: renamed from: k */
    @NonNull
    public final TextView f1229k;

    /* JADX INFO: renamed from: l */
    @NonNull
    public final TextView f1230l;

    public C1050s5(@NonNull LinearLayout linearLayout, @NonNull Barrier barrier, @NonNull Space space, @NonNull LinearLayout linearLayout2, @NonNull TextView textView, @NonNull TextView textView2, @NonNull SimpleDraweeView simpleDraweeView, @NonNull SimpleDraweeView simpleDraweeView2, @NonNull TextView textView3, @NonNull TextView textView4, @NonNull FrameLayout frameLayout, @NonNull MaterialButton materialButton, @NonNull SeekBar seekBar, @NonNull TextView textView5, @NonNull TextView textView6) {
        this.f1219a = linearLayout;
        this.f1220b = linearLayout2;
        this.f1221c = textView;
        this.f1222d = textView2;
        this.f1223e = simpleDraweeView;
        this.f1224f = simpleDraweeView2;
        this.f1225g = textView3;
        this.f1226h = textView4;
        this.f1227i = materialButton;
        this.f1228j = seekBar;
        this.f1229k = textView5;
        this.f1230l = textView6;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f1219a;
    }
}
