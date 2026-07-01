package b.a.i;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: renamed from: b.a.i.f5, reason: use source file name */
/* JADX INFO: compiled from: WidgetDiscoveryOtherSpeakersCountBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetDiscoveryOtherSpeakersCountBinding implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f114b;

    public WidgetDiscoveryOtherSpeakersCountBinding(@NonNull LinearLayout linearLayout, @NonNull TextView textView) {
        this.a = linearLayout;
        this.f114b = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
