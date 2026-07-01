package b.b.a.a;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.lytefast.flexinput.model.Attachment;
import com.lytefast.flexinput.utils.SelectionAggregator;

/* JADX INFO: compiled from: AddContentDialogFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d implements Runnable {
    public final /* synthetic */ a j;

    public d(a aVar) {
        this.j = aVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SelectionAggregator<Attachment<Object>> selectionAggregator = this.j.selectionAggregator;
        if ((selectionAggregator != null ? selectionAggregator.getSize() : 0) > 0) {
            FloatingActionButton floatingActionButton = this.j.actionButton;
            if (floatingActionButton != null) {
                floatingActionButton.show();
                return;
            }
            return;
        }
        FloatingActionButton floatingActionButton2 = this.j.actionButton;
        if (floatingActionButton2 != null) {
            floatingActionButton2.hide();
        }
    }
}
