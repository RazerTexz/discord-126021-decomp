package p007b.p008a.p025i;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: renamed from: b.a.i.e3 */
/* JADX INFO: compiled from: ViewScreenTitleBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0947e3 implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final LinearLayout f810a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final TextView f811b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final TextView f812c;

    public C0947e3(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull TextView textView2) {
        this.f810a = linearLayout;
        this.f811b = textView;
        this.f812c = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f810a;
    }
}
