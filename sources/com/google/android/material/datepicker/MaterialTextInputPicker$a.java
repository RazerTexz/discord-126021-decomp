package com.google.android.material.datepicker;

import java.util.Iterator;

/* JADX INFO: Add missing generic type declarations: [S] */
/* JADX INFO: loaded from: classes3.dex */
public class MaterialTextInputPicker$a<S> extends OnSelectionChangedListener<S> {
    public final /* synthetic */ MaterialTextInputPicker a;

    public MaterialTextInputPicker$a(MaterialTextInputPicker materialTextInputPicker) {
        this.a = materialTextInputPicker;
    }

    @Override // com.google.android.material.datepicker.OnSelectionChangedListener
    public void onIncompleteSelectionChanged() {
        Iterator<OnSelectionChangedListener<S>> it = this.a.onSelectionChangedListeners.iterator();
        while (it.hasNext()) {
            it.next().onIncompleteSelectionChanged();
        }
    }

    @Override // com.google.android.material.datepicker.OnSelectionChangedListener
    public void onSelectionChanged(S s2) {
        Iterator<OnSelectionChangedListener<S>> it = this.a.onSelectionChangedListeners.iterator();
        while (it.hasNext()) {
            it.next().onSelectionChanged(s2);
        }
    }
}
