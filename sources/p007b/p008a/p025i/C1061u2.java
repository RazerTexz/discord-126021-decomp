package p007b.p008a.p025i;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: renamed from: b.a.i.u2 */
/* JADX INFO: compiled from: ViewPhoneOrEmailInputBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class C1061u2 implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final View f1286a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final TextInputLayout f1287b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final TextInputEditText f1288c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final TextInputLayout f1289d;

    public C1061u2(@NonNull View view, @NonNull TextInputLayout textInputLayout, @NonNull TextInputEditText textInputEditText, @NonNull TextInputLayout textInputLayout2) {
        this.f1286a = view;
        this.f1287b = textInputLayout;
        this.f1288c = textInputEditText;
        this.f1289d = textInputLayout2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f1286a;
    }
}
