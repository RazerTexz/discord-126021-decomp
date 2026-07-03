package p007b.p008a.p025i;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: renamed from: b.a.i.d0 */
/* JADX INFO: compiled from: IntegrationSyncSettingsBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0936d0 implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final LinearLayout f765a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final TextView f766b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final TextView f767c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final RelativeLayout f768d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final TextView f769e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final RelativeLayout f770f;

    public C0936d0(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull TextView textView2, @NonNull RelativeLayout relativeLayout, @NonNull TextView textView3, @NonNull RelativeLayout relativeLayout2) {
        this.f765a = linearLayout;
        this.f766b = textView;
        this.f767c = textView2;
        this.f768d = relativeLayout;
        this.f769e = textView3;
        this.f770f = relativeLayout2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f765a;
    }
}
