package p007b.p008a.p025i;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.views.LoadingButton;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: renamed from: b.a.i.h5 */
/* JADX INFO: compiled from: WidgetEnableTwoFactorPasswordDialogBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0973h5 implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final LinearLayout f931a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final MaterialButton f932b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final LoadingButton f933c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final TextInputLayout f934d;

    public C0973h5(@NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull TextView textView, @NonNull MaterialButton materialButton, @NonNull TextView textView2, @NonNull LinearLayout linearLayout3, @NonNull LoadingButton loadingButton, @NonNull TextInputLayout textInputLayout) {
        this.f931a = linearLayout;
        this.f932b = materialButton;
        this.f933c = loadingButton;
        this.f934d = textInputLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f931a;
    }
}
