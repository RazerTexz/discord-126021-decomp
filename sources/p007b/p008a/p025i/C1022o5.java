package p007b.p008a.p025i;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.view.text.LinkifiedTextView;

/* JADX INFO: renamed from: b.a.i.o5 */
/* JADX INFO: compiled from: WidgetHubEmailFlowConfirmationBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class C1022o5 implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final NestedScrollView f1117a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final LinkifiedTextView f1118b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final TextView f1119c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final LinkifiedTextView f1120d;

    public C1022o5(@NonNull NestedScrollView nestedScrollView, @NonNull LinkifiedTextView linkifiedTextView, @NonNull TextView textView, @NonNull LinkifiedTextView linkifiedTextView2) {
        this.f1117a = nestedScrollView;
        this.f1118b = linkifiedTextView;
        this.f1119c = textView;
        this.f1120d = linkifiedTextView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f1117a;
    }
}
