package p007b.p008a.p025i;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: renamed from: b.a.i.a6 */
/* JADX INFO: compiled from: WidgetSettingsPremiumPriceChangeNoticeBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0918a6 implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final CardView f682a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final CardView f683b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final TextView f684c;

    public C0918a6(@NonNull CardView cardView, @NonNull CardView cardView2, @NonNull TextView textView) {
        this.f682a = cardView;
        this.f683b = cardView2;
        this.f684c = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f682a;
    }
}
