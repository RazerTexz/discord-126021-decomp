package com.google.android.material.textfield;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView$OnItemClickListener;

/* JADX INFO: loaded from: classes3.dex */
public class MaterialAutoCompleteTextView$a implements AdapterView$OnItemClickListener {
    public final /* synthetic */ MaterialAutoCompleteTextView j;

    public MaterialAutoCompleteTextView$a(MaterialAutoCompleteTextView materialAutoCompleteTextView) {
        this.j = materialAutoCompleteTextView;
    }

    @Override // android.widget.AdapterView$OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        MaterialAutoCompleteTextView.access$100(this.j, i < 0 ? MaterialAutoCompleteTextView.access$000(this.j).getSelectedItem() : this.j.getAdapter().getItem(i));
        AdapterView$OnItemClickListener onItemClickListener = this.j.getOnItemClickListener();
        if (onItemClickListener != null) {
            if (view == null || i < 0) {
                view = MaterialAutoCompleteTextView.access$000(this.j).getSelectedView();
                i = MaterialAutoCompleteTextView.access$000(this.j).getSelectedItemPosition();
                j = MaterialAutoCompleteTextView.access$000(this.j).getSelectedItemId();
            }
            onItemClickListener.onItemClick(MaterialAutoCompleteTextView.access$000(this.j).getListView(), view, i, j);
        }
        MaterialAutoCompleteTextView.access$000(this.j).dismiss();
    }
}
