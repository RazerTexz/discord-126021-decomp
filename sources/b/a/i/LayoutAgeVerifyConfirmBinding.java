package b.a.i;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.views.LoadingButton;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: renamed from: b.a.i.h0, reason: use source file name */
/* JADX INFO: compiled from: LayoutAgeVerifyConfirmBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class LayoutAgeVerifyConfirmBinding implements ViewBinding {

    @NonNull
    public final ConstraintLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final MaterialButton f124b;

    @NonNull
    public final LoadingButton c;

    @NonNull
    public final LinkifiedTextView d;

    @NonNull
    public final TextView e;

    public LayoutAgeVerifyConfirmBinding(@NonNull ConstraintLayout constraintLayout, @NonNull MaterialButton materialButton, @NonNull LoadingButton loadingButton, @NonNull LinkifiedTextView linkifiedTextView, @NonNull TextView textView) {
        this.a = constraintLayout;
        this.f124b = materialButton;
        this.c = loadingButton;
        this.d = linkifiedTextView;
        this.e = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
