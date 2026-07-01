package b.a.i;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: renamed from: b.a.i.u2, reason: use source file name */
/* JADX INFO: compiled from: ViewPhoneOrEmailInputBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class ViewPhoneOrEmailInputBinding implements ViewBinding {

    @NonNull
    public final View a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextInputLayout f210b;

    @NonNull
    public final TextInputEditText c;

    @NonNull
    public final TextInputLayout d;

    public ViewPhoneOrEmailInputBinding(@NonNull View view, @NonNull TextInputLayout textInputLayout, @NonNull TextInputEditText textInputEditText, @NonNull TextInputLayout textInputLayout2) {
        this.a = view;
        this.f210b = textInputLayout;
        this.c = textInputEditText;
        this.d = textInputLayout2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
