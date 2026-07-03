package p007b.p008a.p025i;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: renamed from: b.a.i.i0 */
/* JADX INFO: compiled from: LayoutAgeVerifyUnderageBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0975i0 implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final ConstraintLayout f937a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final MaterialButton f938b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final LinkifiedTextView f939c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final TextView f940d;

    public C0975i0(@NonNull ConstraintLayout constraintLayout, @NonNull MaterialButton materialButton, @NonNull LinkifiedTextView linkifiedTextView, @NonNull TextView textView, @NonNull TextView textView2) {
        this.f937a = constraintLayout;
        this.f938b = materialButton;
        this.f939c = linkifiedTextView;
        this.f940d = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f937a;
    }
}
