package androidx.core.view;

import android.view.View;
import android.view.View$OnLongClickListener;

/* JADX INFO: loaded from: classes.dex */
public class DragStartHelper$1 implements View$OnLongClickListener {
    public final /* synthetic */ DragStartHelper this$0;

    public DragStartHelper$1(DragStartHelper dragStartHelper) {
        this.this$0 = dragStartHelper;
    }

    @Override // android.view.View$OnLongClickListener
    public boolean onLongClick(View view) {
        return this.this$0.onLongClick(view);
    }
}
