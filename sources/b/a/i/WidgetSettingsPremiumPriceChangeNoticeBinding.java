package b.a.i;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: renamed from: b.a.i.a6, reason: use source file name */
/* JADX INFO: compiled from: WidgetSettingsPremiumPriceChangeNoticeBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetSettingsPremiumPriceChangeNoticeBinding implements ViewBinding {

    @NonNull
    public final CardView a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final CardView f79b;

    @NonNull
    public final TextView c;

    public WidgetSettingsPremiumPriceChangeNoticeBinding(@NonNull CardView cardView, @NonNull CardView cardView2, @NonNull TextView textView) {
        this.a = cardView;
        this.f79b = cardView2;
        this.c = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
