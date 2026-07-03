package p007b.p008a.p025i;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.textfield.TextInputEditText;

/* JADX INFO: renamed from: b.a.i.j1 */
/* JADX INFO: compiled from: SearchInputViewBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0983j1 implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final View f969a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final ImageView f970b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final TextInputEditText f971c;

    public C0983j1(@NonNull View view, @NonNull ImageView imageView, @NonNull TextInputEditText textInputEditText) {
        this.f969a = view;
        this.f970b = imageView;
        this.f971c = textInputEditText;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f969a;
    }
}
