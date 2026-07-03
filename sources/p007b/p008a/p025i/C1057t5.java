package p007b.p008a.p025i;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.Barrier;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: renamed from: b.a.i.t5 */
/* JADX INFO: compiled from: WidgetPlatformRichPresenceBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class C1057t5 implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final LinearLayout f1257a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final LinearLayout f1258b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final TextView f1259c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final SimpleDraweeView f1260d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final SimpleDraweeView f1261e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final MaterialButton f1262f;

    /* JADX INFO: renamed from: g */
    @NonNull
    public final TextView f1263g;

    /* JADX INFO: renamed from: h */
    @NonNull
    public final TextView f1264h;

    public C1057t5(@NonNull LinearLayout linearLayout, @NonNull Barrier barrier, @NonNull Space space, @NonNull LinearLayout linearLayout2, @NonNull TextView textView, @NonNull SimpleDraweeView simpleDraweeView, @NonNull SimpleDraweeView simpleDraweeView2, @NonNull MaterialButton materialButton, @NonNull TextView textView2, @NonNull TextView textView3) {
        this.f1257a = linearLayout;
        this.f1258b = linearLayout2;
        this.f1259c = textView;
        this.f1260d = simpleDraweeView;
        this.f1261e = simpleDraweeView2;
        this.f1262f = materialButton;
        this.f1263g = textView2;
        this.f1264h = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f1257a;
    }
}
