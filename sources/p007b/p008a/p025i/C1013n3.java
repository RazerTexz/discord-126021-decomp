package p007b.p008a.p025i;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

/* JADX INFO: renamed from: b.a.i.n3 */
/* JADX INFO: compiled from: ViewServerSettingsUploadBannerBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class C1013n3 implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final LinearLayout f1077a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final C1006m3 f1078b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final FrameLayout f1079c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final TextView f1080d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final SimpleDraweeView f1081e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final FloatingActionButton f1082f;

    /* JADX INFO: renamed from: g */
    @NonNull
    public final LinkifiedTextView f1083g;

    /* JADX INFO: renamed from: h */
    @NonNull
    public final TextView f1084h;

    /* JADX INFO: renamed from: i */
    @NonNull
    public final TextView f1085i;

    public C1013n3(@NonNull LinearLayout linearLayout, @NonNull C1006m3 c1006m3, @NonNull FrameLayout frameLayout, @NonNull TextView textView, @NonNull SimpleDraweeView simpleDraweeView, @NonNull FloatingActionButton floatingActionButton, @NonNull LinkifiedTextView linkifiedTextView, @NonNull TextView textView2, @NonNull TextView textView3) {
        this.f1077a = linearLayout;
        this.f1078b = c1006m3;
        this.f1079c = frameLayout;
        this.f1080d = textView;
        this.f1081e = simpleDraweeView;
        this.f1082f = floatingActionButton;
        this.f1083g = linkifiedTextView;
        this.f1084h = textView2;
        this.f1085i = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f1077a;
    }
}
