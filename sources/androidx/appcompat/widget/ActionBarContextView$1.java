package androidx.appcompat.widget;

import android.view.View;
import android.view.View$OnClickListener;
import androidx.appcompat.view.ActionMode;

/* JADX INFO: loaded from: classes.dex */
public class ActionBarContextView$1 implements View$OnClickListener {
    public final /* synthetic */ ActionBarContextView this$0;
    public final /* synthetic */ ActionMode val$mode;

    public ActionBarContextView$1(ActionBarContextView actionBarContextView, ActionMode actionMode) {
        this.this$0 = actionBarContextView;
        this.val$mode = actionMode;
    }

    @Override // android.view.View$OnClickListener
    public void onClick(View view) {
        this.val$mode.finish();
    }
}
