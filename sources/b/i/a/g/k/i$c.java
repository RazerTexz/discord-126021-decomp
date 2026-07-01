package b.i.a.g.k;

import android.view.View;
import android.view.View$OnClickListener;
import com.google.android.material.R$id;

/* JADX INFO: compiled from: TimePickerTextInputPresenter.java */
/* JADX INFO: loaded from: classes3.dex */
public class i$c implements View$OnClickListener {
    public final /* synthetic */ i j;

    public i$c(i iVar) {
        this.j = iVar;
    }

    @Override // android.view.View$OnClickListener
    public void onClick(View view) {
        this.j.b(((Integer) view.getTag(R$id.selection_type)).intValue());
    }
}
