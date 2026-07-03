package p007b.p008a.p025i;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: renamed from: b.a.i.n1 */
/* JADX INFO: compiled from: ShinyButtonBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class C1011n1 implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final View f1070a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final LinearLayout f1071b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final ImageView f1072c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final TextView f1073d;

    public C1011n1(@NonNull View view, @NonNull LinearLayout linearLayout, @NonNull ImageView imageView, @NonNull TextView textView) {
        this.f1070a = view;
        this.f1071b = linearLayout;
        this.f1072c = imageView;
        this.f1073d = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f1070a;
    }
}
