package p007b.p008a.p025i;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: renamed from: b.a.i.n4 */
/* JADX INFO: compiled from: WidgetAuthMfaInfoBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class C1014n4 implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final LinearLayout f1086a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final MaterialButton f1087b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final LinkifiedTextView f1088c;

    public C1014n4(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull MaterialButton materialButton, @NonNull LinkifiedTextView linkifiedTextView) {
        this.f1086a = linearLayout;
        this.f1087b = materialButton;
        this.f1088c = linkifiedTextView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f1086a;
    }
}
