package b.a.i;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.view.recycler.MaxHeightRecyclerView;

/* JADX INFO: renamed from: b.a.i.c, reason: use source file name */
/* JADX INFO: compiled from: BottomSheetSimpleSelectorBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class BottomSheetSimpleSelectorBinding implements ViewBinding {

    @NonNull
    public final ConstraintLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f88b;

    @NonNull
    public final TextView c;

    @NonNull
    public final MaxHeightRecyclerView d;

    public BottomSheetSimpleSelectorBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ConstraintLayout constraintLayout2, @NonNull TextView textView, @NonNull MaxHeightRecyclerView maxHeightRecyclerView) {
        this.a = constraintLayout;
        this.f88b = constraintLayout2;
        this.c = textView;
        this.d = maxHeightRecyclerView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
