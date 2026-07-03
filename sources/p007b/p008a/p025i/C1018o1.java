package p007b.p008a.p025i;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: renamed from: b.a.i.o1 */
/* JADX INFO: compiled from: SimpleConfirmationDialogBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class C1018o1 implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final LinearLayout f1097a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final TextView f1098b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final MaterialButton f1099c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final MaterialButton f1100d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final TextView f1101e;

    public C1018o1(@NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull TextView textView, @NonNull MaterialButton materialButton, @NonNull MaterialButton materialButton2, @NonNull TextView textView2) {
        this.f1097a = linearLayout;
        this.f1098b = textView;
        this.f1099c = materialButton;
        this.f1100d = materialButton2;
        this.f1101e = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f1097a;
    }
}
