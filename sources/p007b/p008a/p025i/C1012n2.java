package p007b.p008a.p025i;

import android.view.View;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: renamed from: b.a.i.n2 */
/* JADX INFO: compiled from: ViewLoadingButtonBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class C1012n2 implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final View f1074a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final MaterialButton f1075b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final ProgressBar f1076c;

    public C1012n2(@NonNull View view, @NonNull MaterialButton materialButton, @NonNull ProgressBar progressBar) {
        this.f1074a = view;
        this.f1075b = materialButton;
        this.f1076c = progressBar;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f1074a;
    }
}
