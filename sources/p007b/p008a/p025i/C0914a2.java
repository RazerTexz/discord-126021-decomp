package p007b.p008a.p025i;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: renamed from: b.a.i.a2 */
/* JADX INFO: compiled from: ViewCallEventsButtonBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0914a2 implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final ConstraintLayout f663a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final ImageView f664b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final TextView f665c;

    public C0914a2(@NonNull ConstraintLayout constraintLayout, @NonNull ImageView imageView, @NonNull TextView textView) {
        this.f663a = constraintLayout;
        this.f664b = imageView;
        this.f665c = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f663a;
    }
}
