package p007b.p225i.p226a.p341g.p351j;

import android.view.MotionEvent;
import android.view.View;
import android.widget.AutoCompleteTextView;
import androidx.annotation.NonNull;

/* JADX INFO: renamed from: b.i.a.g.j.j */
/* JADX INFO: compiled from: DropdownMenuEndIconDelegate.java */
/* JADX INFO: loaded from: classes3.dex */
public class ViewOnTouchListenerC4439j implements View.OnTouchListener {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ AutoCompleteTextView f11815j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ C4437h f11816k;

    public ViewOnTouchListenerC4439j(C4437h c4437h, AutoCompleteTextView autoCompleteTextView) {
        this.f11816k = c4437h;
        this.f11815j = autoCompleteTextView;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(@NonNull View view, @NonNull MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            if (this.f11816k.m6156i()) {
                this.f11816k.f11796i = false;
            }
            C4437h.m6153g(this.f11816k, this.f11815j);
        }
        return false;
    }
}
