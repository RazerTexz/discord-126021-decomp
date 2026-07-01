package b.a.i;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: renamed from: b.a.i.b6, reason: use source file name */
/* JADX INFO: compiled from: WidgetSettingsPrivacyDefaultsBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetSettingsPrivacyDefaultsBinding implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final MaterialButton f87b;

    @NonNull
    public final MaterialButton c;

    public WidgetSettingsPrivacyDefaultsBinding(@NonNull LinearLayout linearLayout, @NonNull MaterialButton materialButton, @NonNull MaterialButton materialButton2) {
        this.a = linearLayout;
        this.f87b = materialButton;
        this.c = materialButton2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
