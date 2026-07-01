package b.a.i;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.switchmaterial.SwitchMaterial;

/* JADX INFO: renamed from: b.a.i.s3, reason: use source file name */
/* JADX INFO: compiled from: ViewSettingSwitchBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class ViewSettingSwitchBinding implements ViewBinding {

    @NonNull
    public final View a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final SwitchMaterial f198b;

    @NonNull
    public final ConstraintLayout c;

    public ViewSettingSwitchBinding(@NonNull View view, @NonNull SwitchMaterial switchMaterial, @NonNull ConstraintLayout constraintLayout) {
        this.a = view;
        this.f198b = switchMaterial;
        this.c = constraintLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
