package p007b.p008a.p025i;

import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.card.MaterialCardView;

/* JADX INFO: renamed from: b.a.i.i2 */
/* JADX INFO: compiled from: ViewExperimentOverrideBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0977i2 implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final View f946a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final TextView f947b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final Spinner f948c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final TextView f949d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final TextView f950e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final TextView f951f;

    public C0977i2(@NonNull View view, @NonNull TextView textView, @NonNull Spinner spinner, @NonNull MaterialCardView materialCardView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull TextView textView4) {
        this.f946a = view;
        this.f947b = textView;
        this.f948c = spinner;
        this.f949d = textView2;
        this.f950e = textView3;
        this.f951f = textView4;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f946a;
    }
}
