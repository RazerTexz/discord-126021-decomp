package b.i.a.g.j;

import android.view.MotionEvent;
import android.view.View;
import android.widget.AutoCompleteTextView;
import androidx.annotation.NonNull;

/* JADX INFO: renamed from: b.i.a.g.j.j, reason: use source file name */
/* JADX INFO: compiled from: DropdownMenuEndIconDelegate.java */
/* JADX INFO: loaded from: classes3.dex */
public class DropdownMenuEndIconDelegate3 implements View.OnTouchListener {
    public final /* synthetic */ AutoCompleteTextView j;
    public final /* synthetic */ DropdownMenuEndIconDelegate k;

    public DropdownMenuEndIconDelegate3(DropdownMenuEndIconDelegate dropdownMenuEndIconDelegate, AutoCompleteTextView autoCompleteTextView) {
        this.k = dropdownMenuEndIconDelegate;
        this.j = autoCompleteTextView;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(@NonNull View view, @NonNull MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            if (this.k.i()) {
                this.k.i = false;
            }
            DropdownMenuEndIconDelegate.g(this.k, this.j);
        }
        return false;
    }
}
