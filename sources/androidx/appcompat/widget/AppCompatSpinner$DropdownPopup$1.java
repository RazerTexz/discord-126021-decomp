package androidx.appcompat.widget;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView$OnItemClickListener;

/* JADX INFO: loaded from: classes.dex */
public class AppCompatSpinner$DropdownPopup$1 implements AdapterView$OnItemClickListener {
    public final /* synthetic */ AppCompatSpinner$DropdownPopup this$1;
    public final /* synthetic */ AppCompatSpinner val$this$0;

    public AppCompatSpinner$DropdownPopup$1(AppCompatSpinner$DropdownPopup appCompatSpinner$DropdownPopup, AppCompatSpinner appCompatSpinner) {
        this.this$1 = appCompatSpinner$DropdownPopup;
        this.val$this$0 = appCompatSpinner;
    }

    @Override // android.widget.AdapterView$OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.this$1.this$0.setSelection(i);
        if (this.this$1.this$0.getOnItemClickListener() != null) {
            AppCompatSpinner$DropdownPopup appCompatSpinner$DropdownPopup = this.this$1;
            appCompatSpinner$DropdownPopup.this$0.performItemClick(view, i, appCompatSpinner$DropdownPopup.mAdapter.getItemId(i));
        }
        this.this$1.dismiss();
    }
}
