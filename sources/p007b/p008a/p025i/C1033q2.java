package p007b.p008a.p025i;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: renamed from: b.a.i.q2 */
/* JADX INFO: compiled from: ViewMobileReportsChildBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class C1033q2 implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final FrameLayout f1146a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final TextView f1147b;

    public C1033q2(@NonNull FrameLayout frameLayout, @NonNull CardView cardView, @NonNull TextView textView) {
        this.f1146a = frameLayout;
        this.f1147b = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f1146a;
    }
}
