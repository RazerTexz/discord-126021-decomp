package b.a.i;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.discord.views.OverlayMenuView;

/* JADX INFO: compiled from: OverlayBubbleMenuBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class y0 implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final LinearLayout f233b;

    @NonNull
    public final View c;

    @NonNull
    public final TextView d;

    @NonNull
    public final RecyclerView e;

    @NonNull
    public final OverlayMenuView f;

    public y0(@NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull View view, @NonNull TextView textView, @NonNull RecyclerView recyclerView, @NonNull OverlayMenuView overlayMenuView) {
        this.a = linearLayout;
        this.f233b = linearLayout2;
        this.c = view;
        this.d = textView;
        this.e = recyclerView;
        this.f = overlayMenuView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
