package p007b.p008a.p025i;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.views.CutoutView;

/* JADX INFO: renamed from: b.a.i.c1 */
/* JADX INFO: compiled from: PileItemOverflowViewBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0929c1 implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final CutoutView f736a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final TextView f737b;

    public C0929c1(@NonNull CutoutView cutoutView, @NonNull TextView textView) {
        this.f736a = cutoutView;
        this.f737b = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f736a;
    }
}
