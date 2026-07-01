package b.a.i;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.views.LoadingButton;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: compiled from: WidgetEnableTwoFactorPasswordDialogBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class h5 implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final MaterialButton f129b;

    @NonNull
    public final LoadingButton c;

    @NonNull
    public final TextInputLayout d;

    public h5(@NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull TextView textView, @NonNull MaterialButton materialButton, @NonNull TextView textView2, @NonNull LinearLayout linearLayout3, @NonNull LoadingButton loadingButton, @NonNull TextInputLayout textInputLayout) {
        this.a = linearLayout;
        this.f129b = materialButton;
        this.c = loadingButton;
        this.d = textInputLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
