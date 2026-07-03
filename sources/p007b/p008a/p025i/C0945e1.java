package p007b.p008a.p025i;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: renamed from: b.a.i.e1 */
/* JADX INFO: compiled from: PremiumAndGuildBoostActivatedDialogBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0945e1 implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final LinearLayout f805a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final MaterialButton f806b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final TextView f807c;

    public C0945e1(@NonNull LinearLayout linearLayout, @NonNull MaterialButton materialButton, @NonNull TextView textView) {
        this.f805a = linearLayout;
        this.f806b = materialButton;
        this.f807c = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f805a;
    }
}
