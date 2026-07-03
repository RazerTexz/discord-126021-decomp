package p007b.p008a.p025i;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.views.LoadingButton;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: renamed from: b.a.i.h0 */
/* JADX INFO: compiled from: LayoutAgeVerifyConfirmBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0968h0 implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final ConstraintLayout f895a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final MaterialButton f896b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final LoadingButton f897c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final LinkifiedTextView f898d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final TextView f899e;

    public C0968h0(@NonNull ConstraintLayout constraintLayout, @NonNull MaterialButton materialButton, @NonNull LoadingButton loadingButton, @NonNull LinkifiedTextView linkifiedTextView, @NonNull TextView textView) {
        this.f895a = constraintLayout;
        this.f896b = materialButton;
        this.f897c = loadingButton;
        this.f898d = linkifiedTextView;
        this.f899e = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f895a;
    }
}
