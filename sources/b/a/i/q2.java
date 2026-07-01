package b.a.i;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: compiled from: ViewMobileReportsChildBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class q2 implements ViewBinding {

    @NonNull
    public final FrameLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f185b;

    public q2(@NonNull FrameLayout frameLayout, @NonNull CardView cardView, @NonNull TextView textView) {
        this.a = frameLayout;
        this.f185b = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
