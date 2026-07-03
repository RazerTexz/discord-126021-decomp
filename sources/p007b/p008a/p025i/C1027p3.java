package p007b.p008a.p025i;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.checkbox.MaterialCheckBox;

/* JADX INFO: renamed from: b.a.i.p3 */
/* JADX INFO: compiled from: ViewSettingCheckBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class C1027p3 implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final View f1134a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final MaterialCheckBox f1135b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final ConstraintLayout f1136c;

    public C1027p3(@NonNull View view, @NonNull MaterialCheckBox materialCheckBox, @NonNull ConstraintLayout constraintLayout) {
        this.f1134a = view;
        this.f1135b = materialCheckBox;
        this.f1136c = constraintLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f1134a;
    }
}
