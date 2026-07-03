package p007b.p008a.p025i;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.discord.views.LoadingButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: renamed from: b.a.i.l0 */
/* JADX INFO: compiled from: LayoutContactSyncNameInputBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0996l0 implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final ConstraintLayout f1012a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final TextInputEditText f1013b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final TextInputLayout f1014c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final LoadingButton f1015d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final TextView f1016e;

    public C0996l0(@NonNull ConstraintLayout constraintLayout, @NonNull TextInputEditText textInputEditText, @NonNull TextInputLayout textInputLayout, @NonNull LoadingButton loadingButton, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3) {
        this.f1012a = constraintLayout;
        this.f1013b = textInputEditText;
        this.f1014c = textInputLayout;
        this.f1015d = loadingButton;
        this.f1016e = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f1012a;
    }
}
