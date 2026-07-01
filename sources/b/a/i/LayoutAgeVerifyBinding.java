package b.a.i;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.views.LoadingButton;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: renamed from: b.a.i.g0, reason: use source file name */
/* JADX INFO: compiled from: LayoutAgeVerifyBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class LayoutAgeVerifyBinding implements ViewBinding {

    @NonNull
    public final ConstraintLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final LinkifiedTextView f117b;

    @NonNull
    public final TextInputLayout c;

    @NonNull
    public final LoadingButton d;

    public LayoutAgeVerifyBinding(@NonNull ConstraintLayout constraintLayout, @NonNull LinkifiedTextView linkifiedTextView, @NonNull TextInputLayout textInputLayout, @NonNull LoadingButton loadingButton, @NonNull TextView textView) {
        this.a = constraintLayout;
        this.f117b = linkifiedTextView;
        this.c = textInputLayout;
        this.d = loadingButton;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
