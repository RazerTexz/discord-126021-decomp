package b.a.i;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.textview.MaterialTextView;

/* JADX INFO: compiled from: WidgetChatListBotUiSelectComponentPillBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class c5 implements ViewBinding {

    @NonNull
    public final MaterialTextView a;

    public c5(@NonNull MaterialTextView materialTextView) {
        this.a = materialTextView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
