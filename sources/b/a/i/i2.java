package b.a.i;

import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.card.MaterialCardView;

/* JADX INFO: compiled from: ViewExperimentOverrideBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class i2 implements ViewBinding {

    @NonNull
    public final View a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f133b;

    @NonNull
    public final Spinner c;

    @NonNull
    public final TextView d;

    @NonNull
    public final TextView e;

    @NonNull
    public final TextView f;

    public i2(@NonNull View view, @NonNull TextView textView, @NonNull Spinner spinner, @NonNull MaterialCardView materialCardView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull TextView textView4) {
        this.a = view;
        this.f133b = textView;
        this.c = spinner;
        this.d = textView2;
        this.e = textView3;
        this.f = textView4;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
