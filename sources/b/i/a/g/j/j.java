package b.i.a.g.j;

import android.view.MotionEvent;
import android.view.View;
import android.view.View$OnTouchListener;
import android.widget.AutoCompleteTextView;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: DropdownMenuEndIconDelegate.java */
/* JADX INFO: loaded from: classes3.dex */
public class j implements View$OnTouchListener {
    public final /* synthetic */ AutoCompleteTextView j;
    public final /* synthetic */ h k;

    public j(h hVar, AutoCompleteTextView autoCompleteTextView) {
        this.k = hVar;
        this.j = autoCompleteTextView;
    }

    @Override // android.view.View$OnTouchListener
    public boolean onTouch(@NonNull View view, @NonNull MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            if (this.k.i()) {
                this.k.i = false;
            }
            h.g(this.k, this.j);
        }
        return false;
    }
}
