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

/* JADX INFO: renamed from: b.a.i.o3 */
/* JADX INFO: compiled from: ViewServerSettingsUploadSplashBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class C1020o3 implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final LinearLayout f1106a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final FrameLayout f1107b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final FloatingActionButton f1108c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final TextView f1109d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final SimpleDraweeView f1110e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final LinkifiedTextView f1111f;

    /* JADX INFO: renamed from: g */
    @NonNull
    public final TextView f1112g;

    /* JADX INFO: renamed from: h */
    @NonNull
    public final TextView f1113h;

    public C1020o3(@NonNull LinearLayout linearLayout, @NonNull FrameLayout frameLayout, @NonNull FloatingActionButton floatingActionButton, @NonNull TextView textView, @NonNull SimpleDraweeView simpleDraweeView, @NonNull LinkifiedTextView linkifiedTextView, @NonNull TextView textView2, @NonNull TextView textView3) {
        this.f1106a = linearLayout;
        this.f1107b = frameLayout;
        this.f1108c = floatingActionButton;
        this.f1109d = textView;
        this.f1110e = simpleDraweeView;
        this.f1111f = linkifiedTextView;
        this.f1112g = textView2;
        this.f1113h = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f1106a;
    }
}
