package b.a.i;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: compiled from: LayoutAgeVerifyUnderageBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class i0 implements ViewBinding {

    @NonNull
    public final ConstraintLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final MaterialButton f131b;

    @NonNull
    public final LinkifiedTextView c;

    @NonNull
    public final TextView d;

    public i0(@NonNull ConstraintLayout constraintLayout, @NonNull MaterialButton materialButton, @NonNull LinkifiedTextView linkifiedTextView, @NonNull TextView textView, @NonNull TextView textView2) {
        this.a = constraintLayout;
        this.f131b = materialButton;
        this.c = linkifiedTextView;
        this.d = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
