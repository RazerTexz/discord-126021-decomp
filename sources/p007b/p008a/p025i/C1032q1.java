package p007b.p008a.p025i;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: renamed from: b.a.i.q1 */
/* JADX INFO: compiled from: SparkleViewBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class C1032q1 implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final View f1144a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final ImageView f1145b;

    public C1032q1(@NonNull View view, @NonNull ImageView imageView) {
        this.f1144a = view;
        this.f1145b = imageView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f1144a;
    }
}
