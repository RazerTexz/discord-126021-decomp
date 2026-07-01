package b.a.i;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: renamed from: b.a.i.g5, reason: use source file name */
/* JADX INFO: compiled from: WidgetDiscoveryStageCardSpeakerBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetDiscoveryStageCardSpeakerBinding implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final SimpleDraweeView f121b;

    @NonNull
    public final TextView c;

    public WidgetDiscoveryStageCardSpeakerBinding(@NonNull LinearLayout linearLayout, @NonNull SimpleDraweeView simpleDraweeView, @NonNull TextView textView) {
        this.a = linearLayout;
        this.f121b = simpleDraweeView;
        this.c = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
