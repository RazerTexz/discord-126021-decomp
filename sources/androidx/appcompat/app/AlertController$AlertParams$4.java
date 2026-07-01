package androidx.appcompat.app;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView$OnItemClickListener;

/* JADX INFO: loaded from: classes.dex */
public class AlertController$AlertParams$4 implements AdapterView$OnItemClickListener {
    public final /* synthetic */ AlertController$AlertParams this$0;
    public final /* synthetic */ AlertController val$dialog;
    public final /* synthetic */ AlertController$RecycleListView val$listView;

    public AlertController$AlertParams$4(AlertController$AlertParams alertController$AlertParams, AlertController$RecycleListView alertController$RecycleListView, AlertController alertController) {
        this.this$0 = alertController$AlertParams;
        this.val$listView = alertController$RecycleListView;
        this.val$dialog = alertController;
    }

    @Override // android.widget.AdapterView$OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        boolean[] zArr = this.this$0.mCheckedItems;
        if (zArr != null) {
            zArr[i] = this.val$listView.isItemChecked(i);
        }
        this.this$0.mOnCheckboxClickListener.onClick(this.val$dialog.mDialog, i, this.val$listView.isItemChecked(i));
    }
}
