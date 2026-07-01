package b.a.i;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.textfield.TextInputEditText;

/* JADX INFO: compiled from: SearchInputViewBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class j1 implements ViewBinding {

    @NonNull
    public final View a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f139b;

    @NonNull
    public final TextInputEditText c;

    public j1(@NonNull View view, @NonNull ImageView imageView, @NonNull TextInputEditText textInputEditText) {
        this.a = view;
        this.f139b = imageView;
        this.c = textInputEditText;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
