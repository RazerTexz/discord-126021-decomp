package b.a.i;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.textview.MaterialTextView;

/* JADX INFO: renamed from: b.a.i.c5, reason: use source file name */
/* JADX INFO: compiled from: WidgetChatListBotUiSelectComponentPillBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetChatListBotUiSelectComponentPillBinding implements ViewBinding {

    @NonNull
    public final MaterialTextView a;

    public WidgetChatListBotUiSelectComponentPillBinding(@NonNull MaterialTextView materialTextView) {
        this.a = materialTextView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
