package p007b.p008a.p025i;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.view.recycler.MaxHeightRecyclerView;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: renamed from: b.a.i.l */
/* JADX INFO: compiled from: DialogSimpleSelectorBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0995l implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final LinearLayout f1008a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final MaterialButton f1009b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final MaxHeightRecyclerView f1010c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final TextView f1011d;

    public C0995l(@NonNull LinearLayout linearLayout, @NonNull MaterialButton materialButton, @NonNull MaxHeightRecyclerView maxHeightRecyclerView, @NonNull TextView textView) {
        this.f1008a = linearLayout;
        this.f1009b = materialButton;
        this.f1010c = maxHeightRecyclerView;
        this.f1011d = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f1008a;
    }
}
