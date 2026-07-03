package p007b.p008a.p025i;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: renamed from: b.a.i.n0 */
/* JADX INFO: compiled from: LayoutContactSyncSuggestionsEmptyBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class C1010n0 implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final ConstraintLayout f1067a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final MaterialButton f1068b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final MaterialButton f1069c;

    public C1010n0(@NonNull ConstraintLayout constraintLayout, @NonNull TextView textView, @NonNull TextView textView2, @NonNull MaterialButton materialButton, @NonNull MaterialButton materialButton2) {
        this.f1067a = constraintLayout;
        this.f1068b = materialButton;
        this.f1069c = materialButton2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f1067a;
    }
}
