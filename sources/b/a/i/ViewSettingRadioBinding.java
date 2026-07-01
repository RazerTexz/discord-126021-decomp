package b.a.i;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.radiobutton.MaterialRadioButton;

/* JADX INFO: renamed from: b.a.i.q3, reason: use source file name */
/* JADX INFO: compiled from: ViewSettingRadioBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class ViewSettingRadioBinding implements ViewBinding {

    @NonNull
    public final View a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final MaterialRadioButton f186b;

    @NonNull
    public final ConstraintLayout c;

    public ViewSettingRadioBinding(@NonNull View view, @NonNull MaterialRadioButton materialRadioButton, @NonNull ConstraintLayout constraintLayout) {
        this.a = view;
        this.f186b = materialRadioButton;
        this.c = constraintLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
