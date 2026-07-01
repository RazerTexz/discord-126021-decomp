package b.a.i;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: compiled from: WidgetServerSettingsOverviewSectionAfkChannelBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class z5 implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f242b;

    @NonNull
    public final LinearLayout c;

    @NonNull
    public final TextView d;

    @NonNull
    public final LinearLayout e;

    public z5(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull LinearLayout linearLayout2, @NonNull TextView textView2, @NonNull LinearLayout linearLayout3) {
        this.a = linearLayout;
        this.f242b = textView;
        this.c = linearLayout2;
        this.d = textView2;
        this.e = linearLayout3;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
