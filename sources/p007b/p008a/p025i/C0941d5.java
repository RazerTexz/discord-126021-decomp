package p007b.p008a.p025i;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.views.ChatActionItem;

/* JADX INFO: renamed from: b.a.i.d5 */
/* JADX INFO: compiled from: WidgetDirectoryChannelEmptyBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0941d5 implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final LinearLayout f788a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final TextView f789b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final ChatActionItem f790c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final ChatActionItem f791d;

    public C0941d5(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull LinkifiedTextView linkifiedTextView, @NonNull ChatActionItem chatActionItem, @NonNull ChatActionItem chatActionItem2) {
        this.f788a = linearLayout;
        this.f789b = textView;
        this.f790c = chatActionItem;
        this.f791d = chatActionItem2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f788a;
    }
}
