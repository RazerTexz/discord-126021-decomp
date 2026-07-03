package p007b.p008a.p025i;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: renamed from: b.a.i.z5 */
/* JADX INFO: compiled from: WidgetServerSettingsOverviewSectionAfkChannelBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class C1099z5 implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final LinearLayout f1449a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final TextView f1450b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final LinearLayout f1451c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final TextView f1452d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final LinearLayout f1453e;

    public C1099z5(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull LinearLayout linearLayout2, @NonNull TextView textView2, @NonNull LinearLayout linearLayout3) {
        this.f1449a = linearLayout;
        this.f1450b = textView;
        this.f1451c = linearLayout2;
        this.f1452d = textView2;
        this.f1453e = linearLayout3;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f1449a;
    }
}
