package p007b.p076b.p077a.p078a;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.lytefast.flexinput.model.Attachment;
import com.lytefast.flexinput.utils.SelectionAggregator;

/* JADX INFO: renamed from: b.b.a.a.d */
/* JADX INFO: compiled from: AddContentDialogFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class RunnableC1416d implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ C1413a f2131j;

    public RunnableC1416d(C1413a c1413a) {
        this.f2131j = c1413a;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SelectionAggregator<Attachment<Object>> selectionAggregator = this.f2131j.selectionAggregator;
        if ((selectionAggregator != null ? selectionAggregator.getSize() : 0) > 0) {
            FloatingActionButton floatingActionButton = this.f2131j.actionButton;
            if (floatingActionButton != null) {
                floatingActionButton.show();
                return;
            }
            return;
        }
        FloatingActionButton floatingActionButton2 = this.f2131j.actionButton;
        if (floatingActionButton2 != null) {
            floatingActionButton2.hide();
        }
    }
}
