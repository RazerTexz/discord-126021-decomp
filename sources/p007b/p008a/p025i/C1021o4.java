package p007b.p008a.p025i;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: renamed from: b.a.i.o4 */
/* JADX INFO: compiled from: WidgetBlockRussianPurchasesDialogBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class C1021o4 implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final LinearLayout f1114a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final LinkifiedTextView f1115b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final MaterialButton f1116c;

    public C1021o4(@NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull LinkifiedTextView linkifiedTextView, @NonNull TextView textView, @NonNull LinearLayout linearLayout3, @NonNull MaterialButton materialButton) {
        this.f1114a = linearLayout;
        this.f1115b = linkifiedTextView;
        this.f1116c = materialButton;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f1114a;
    }
}
