package b.i.a.g.j;

import android.widget.AutoCompleteTextView;

/* JADX INFO: renamed from: b.i.a.g.j.k, reason: use source file name */
/* JADX INFO: compiled from: DropdownMenuEndIconDelegate.java */
/* JADX INFO: loaded from: classes3.dex */
public class DropdownMenuEndIconDelegate4 implements AutoCompleteTextView.OnDismissListener {
    public final /* synthetic */ DropdownMenuEndIconDelegate a;

    public DropdownMenuEndIconDelegate4(DropdownMenuEndIconDelegate dropdownMenuEndIconDelegate) {
        this.a = dropdownMenuEndIconDelegate;
    }

    @Override // android.widget.AutoCompleteTextView.OnDismissListener
    public void onDismiss() {
        DropdownMenuEndIconDelegate dropdownMenuEndIconDelegate = this.a;
        dropdownMenuEndIconDelegate.i = true;
        dropdownMenuEndIconDelegate.k = System.currentTimeMillis();
        DropdownMenuEndIconDelegate.f(this.a, false);
    }
}
