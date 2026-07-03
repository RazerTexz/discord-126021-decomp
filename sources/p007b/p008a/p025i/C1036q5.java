package p007b.p008a.p025i;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: renamed from: b.a.i.q5 */
/* JADX INFO: compiled from: WidgetMaskedLinksDialogBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class C1036q5 implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final LinearLayout f1160a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final TextView f1161b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final MaterialButton f1162c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final MaterialButton f1163d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final TextView f1164e;

    public C1036q5(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull MaterialButton materialButton, @NonNull MaterialButton materialButton2, @NonNull TextView textView2, @NonNull TextView textView3) {
        this.f1160a = linearLayout;
        this.f1161b = textView;
        this.f1162c = materialButton;
        this.f1163d = materialButton2;
        this.f1164e = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f1160a;
    }
}
