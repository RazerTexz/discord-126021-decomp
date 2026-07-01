package b.a.i;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: renamed from: b.a.i.e1, reason: use source file name */
/* JADX INFO: compiled from: PremiumAndGuildBoostActivatedDialogBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class PremiumAndGuildBoostActivatedDialogBinding implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final MaterialButton f103b;

    @NonNull
    public final TextView c;

    public PremiumAndGuildBoostActivatedDialogBinding(@NonNull LinearLayout linearLayout, @NonNull MaterialButton materialButton, @NonNull TextView textView) {
        this.a = linearLayout;
        this.f103b = materialButton;
        this.c = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
