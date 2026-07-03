package p007b.p008a.p025i;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.views.LoadingButton;

/* JADX INFO: renamed from: b.a.i.m0 */
/* JADX INFO: compiled from: LayoutContactSyncSuggestionsBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class C1003m0 implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final ConstraintLayout f1040a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final RecyclerView f1041b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final LoadingButton f1042c;

    public C1003m0(@NonNull ConstraintLayout constraintLayout, @NonNull RecyclerView recyclerView, @NonNull LoadingButton loadingButton, @NonNull LinkifiedTextView linkifiedTextView, @NonNull TextView textView) {
        this.f1040a = constraintLayout;
        this.f1041b = recyclerView;
        this.f1042c = loadingButton;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f1040a;
    }
}
