package b.a.i;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.views.CutoutView;

/* JADX INFO: renamed from: b.a.i.c1, reason: use source file name */
/* JADX INFO: compiled from: PileItemOverflowViewBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class PileItemOverflowViewBinding implements ViewBinding {

    @NonNull
    public final CutoutView a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f90b;

    public PileItemOverflowViewBinding(@NonNull CutoutView cutoutView, @NonNull TextView textView) {
        this.a = cutoutView;
        this.f90b = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
