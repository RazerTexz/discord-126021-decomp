package b.b.a.a;

import com.lytefast.flexinput.model.Attachment;
import com.lytefast.flexinput.utils.SelectionCoordinator$ItemSelectionListener;

/* JADX INFO: compiled from: AddContentDialogFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a$c implements SelectionCoordinator$ItemSelectionListener<Attachment<?>> {
    public final /* synthetic */ a a;

    public a$c(a aVar) {
        this.a = aVar;
    }

    @Override // com.lytefast.flexinput.utils.SelectionCoordinator$ItemSelectionListener
    public void onItemSelected(Attachment<?> attachment) {
        d0.z.d.m.checkNotNullParameter(attachment, "item");
        a.g(this.a);
    }

    @Override // com.lytefast.flexinput.utils.SelectionCoordinator$ItemSelectionListener
    public void onItemUnselected(Attachment<?> attachment) {
        d0.z.d.m.checkNotNullParameter(attachment, "item");
        a.g(this.a);
    }

    @Override // com.lytefast.flexinput.utils.SelectionCoordinator$ItemSelectionListener
    public void unregister() {
    }
}
