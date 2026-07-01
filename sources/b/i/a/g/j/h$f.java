package b.i.a.g.j;

import android.view.View;
import android.view.View$OnClickListener;
import android.widget.AutoCompleteTextView;

/* JADX INFO: compiled from: DropdownMenuEndIconDelegate.java */
/* JADX INFO: loaded from: classes3.dex */
public class h$f implements View$OnClickListener {
    public final /* synthetic */ h j;

    public h$f(h hVar) {
        this.j = hVar;
    }

    @Override // android.view.View$OnClickListener
    public void onClick(View view) {
        h.g(this.j, (AutoCompleteTextView) this.j.a.getEditText());
    }
}
