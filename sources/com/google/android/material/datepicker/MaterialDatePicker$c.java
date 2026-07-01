package com.google.android.material.datepicker;

/* JADX INFO: Add missing generic type declarations: [S] */
/* JADX INFO: loaded from: classes3.dex */
public class MaterialDatePicker$c<S> extends OnSelectionChangedListener<S> {
    public final /* synthetic */ MaterialDatePicker a;

    public MaterialDatePicker$c(MaterialDatePicker materialDatePicker) {
        this.a = materialDatePicker;
    }

    @Override // com.google.android.material.datepicker.OnSelectionChangedListener
    public void onIncompleteSelectionChanged() {
        MaterialDatePicker.access$400(this.a).setEnabled(false);
    }

    @Override // com.google.android.material.datepicker.OnSelectionChangedListener
    public void onSelectionChanged(S s2) {
        MaterialDatePicker.access$200(this.a);
        MaterialDatePicker.access$400(this.a).setEnabled(MaterialDatePicker.access$300(this.a).isSelectionComplete());
    }
}
