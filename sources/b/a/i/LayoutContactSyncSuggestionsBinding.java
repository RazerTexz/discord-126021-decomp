package b.a.i;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.views.LoadingButton;

/* JADX INFO: renamed from: b.a.i.m0, reason: use source file name */
/* JADX INFO: compiled from: LayoutContactSyncSuggestionsBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class LayoutContactSyncSuggestionsBinding implements ViewBinding {

    @NonNull
    public final ConstraintLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final RecyclerView f157b;

    @NonNull
    public final LoadingButton c;

    public LayoutContactSyncSuggestionsBinding(@NonNull ConstraintLayout constraintLayout, @NonNull RecyclerView recyclerView, @NonNull LoadingButton loadingButton, @NonNull LinkifiedTextView linkifiedTextView, @NonNull TextView textView) {
        this.a = constraintLayout;
        this.f157b = recyclerView;
        this.c = loadingButton;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
