package p007b.p008a.p025i;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.discord.views.OverlayMenuView;

/* JADX INFO: renamed from: b.a.i.y0 */
/* JADX INFO: compiled from: OverlayBubbleMenuBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class C1087y0 implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final LinearLayout f1392a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final LinearLayout f1393b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final View f1394c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final TextView f1395d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final RecyclerView f1396e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final OverlayMenuView f1397f;

    public C1087y0(@NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull View view, @NonNull TextView textView, @NonNull RecyclerView recyclerView, @NonNull OverlayMenuView overlayMenuView) {
        this.f1392a = linearLayout;
        this.f1393b = linearLayout2;
        this.f1394c = view;
        this.f1395d = textView;
        this.f1396e = recyclerView;
        this.f1397f = overlayMenuView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f1392a;
    }
}
