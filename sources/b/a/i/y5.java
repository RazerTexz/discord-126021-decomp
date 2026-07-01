package b.a.i;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: compiled from: WidgetServerSettingsConfirmDisableIntegrationBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class y5 implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f237b;

    @NonNull
    public final MaterialButton c;

    @NonNull
    public final MaterialButton d;

    public y5(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull MaterialButton materialButton, @NonNull MaterialButton materialButton2, @NonNull TextView textView2) {
        this.a = linearLayout;
        this.f237b = textView;
        this.c = materialButton;
        this.d = materialButton2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
