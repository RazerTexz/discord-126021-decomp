package b.a.i;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.view.text.LinkifiedTextView;

/* JADX INFO: renamed from: b.a.i.y4, reason: use source file name */
/* JADX INFO: compiled from: WidgetChatListAdapterItemEmbedFieldBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetChatListAdapterItemEmbedFieldBinding implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    public WidgetChatListAdapterItemEmbedFieldBinding(@NonNull LinearLayout linearLayout, @NonNull LinkifiedTextView linkifiedTextView, @NonNull LinkifiedTextView linkifiedTextView2) {
        this.a = linearLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
