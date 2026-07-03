package p007b.p008a.p025i;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.switchmaterial.SwitchMaterial;

/* JADX INFO: renamed from: b.a.i.w5 */
/* JADX INFO: compiled from: WidgetRemoteAuthPendingLoginBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class C1078w5 implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final LinearLayout f1358a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final MaterialButton f1359b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final MaterialButton f1360c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final SwitchMaterial f1361d;

    public C1078w5(@NonNull LinearLayout linearLayout, @NonNull MaterialButton materialButton, @NonNull MaterialButton materialButton2, @NonNull SwitchMaterial switchMaterial) {
        this.f1358a = linearLayout;
        this.f1359b = materialButton;
        this.f1360c = materialButton2;
        this.f1361d = switchMaterial;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f1358a;
    }
}
