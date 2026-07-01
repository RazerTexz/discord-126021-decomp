package b.a.i;

import android.view.View;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: compiled from: ViewLoadingButtonBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class n2 implements ViewBinding {

    @NonNull
    public final View a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final MaterialButton f166b;

    @NonNull
    public final ProgressBar c;

    public n2(@NonNull View view, @NonNull MaterialButton materialButton, @NonNull ProgressBar progressBar) {
        this.a = view;
        this.f166b = materialButton;
        this.c = progressBar;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
