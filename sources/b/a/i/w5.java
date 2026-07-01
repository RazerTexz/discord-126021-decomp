package b.a.i;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.switchmaterial.SwitchMaterial;

/* JADX INFO: compiled from: WidgetRemoteAuthPendingLoginBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class w5 implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final MaterialButton f225b;

    @NonNull
    public final MaterialButton c;

    @NonNull
    public final SwitchMaterial d;

    public w5(@NonNull LinearLayout linearLayout, @NonNull MaterialButton materialButton, @NonNull MaterialButton materialButton2, @NonNull SwitchMaterial switchMaterial) {
        this.a = linearLayout;
        this.f225b = materialButton;
        this.c = materialButton2;
        this.d = switchMaterial;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
