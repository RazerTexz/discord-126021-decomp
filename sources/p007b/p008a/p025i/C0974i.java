package p007b.p008a.p025i;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: renamed from: b.a.i.i */
/* JADX INFO: compiled from: DefaultTooltipViewBottomBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0974i implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final ConstraintLayout f935a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final TextView f936b;

    public C0974i(@NonNull ConstraintLayout constraintLayout, @NonNull TextView textView) {
        this.f935a = constraintLayout;
        this.f936b = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f935a;
    }
}
