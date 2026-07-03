package p007b.p008a.p025i;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: renamed from: b.a.i.f3 */
/* JADX INFO: compiled from: ViewServerDiscoveryHeaderBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0955f3 implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final View f841a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final TextView f842b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final FrameLayout f843c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final TextView f844d;

    public C0955f3(@NonNull View view, @NonNull TextView textView, @NonNull ImageView imageView, @NonNull FrameLayout frameLayout, @NonNull TextView textView2) {
        this.f841a = view;
        this.f842b = textView;
        this.f843c = frameLayout;
        this.f844d = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f841a;
    }
}
