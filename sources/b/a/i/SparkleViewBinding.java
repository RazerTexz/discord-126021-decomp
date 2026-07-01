package b.a.i;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: renamed from: b.a.i.q1, reason: use source file name */
/* JADX INFO: compiled from: SparkleViewBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class SparkleViewBinding implements ViewBinding {

    @NonNull
    public final View a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f184b;

    public SparkleViewBinding(@NonNull View view, @NonNull ImageView imageView) {
        this.a = view;
        this.f184b = imageView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
