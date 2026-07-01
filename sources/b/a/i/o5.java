package b.a.i;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.view.text.LinkifiedTextView;

/* JADX INFO: compiled from: WidgetHubEmailFlowConfirmationBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class o5 implements ViewBinding {

    @NonNull
    public final NestedScrollView a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final LinkifiedTextView f176b;

    @NonNull
    public final TextView c;

    @NonNull
    public final LinkifiedTextView d;

    public o5(@NonNull NestedScrollView nestedScrollView, @NonNull LinkifiedTextView linkifiedTextView, @NonNull TextView textView, @NonNull LinkifiedTextView linkifiedTextView2) {
        this.a = nestedScrollView;
        this.f176b = linkifiedTextView;
        this.c = textView;
        this.d = linkifiedTextView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
