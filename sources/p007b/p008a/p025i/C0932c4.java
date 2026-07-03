package p007b.p008a.p025i;

import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: renamed from: b.a.i.c4 */
/* JADX INFO: compiled from: ViewUploadProgressBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0932c4 implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final ConstraintLayout f746a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final ProgressBar f747b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final ImageView f748c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final TextView f749d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final TextView f750e;

    public C0932c4(@NonNull ConstraintLayout constraintLayout, @NonNull ProgressBar progressBar, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull TextView textView2) {
        this.f746a = constraintLayout;
        this.f747b = progressBar;
        this.f748c = imageView;
        this.f749d = textView;
        this.f750e = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f746a;
    }
}
