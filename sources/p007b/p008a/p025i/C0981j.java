package p007b.p008a.p025i;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: renamed from: b.a.i.j */
/* JADX INFO: compiled from: DefaultTooltipViewTopBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0981j implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final ConstraintLayout f964a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final TextView f965b;

    public C0981j(@NonNull ConstraintLayout constraintLayout, @NonNull TextView textView) {
        this.f964a = constraintLayout;
        this.f965b = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f964a;
    }
}
