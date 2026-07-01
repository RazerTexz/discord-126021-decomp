package androidx.appcompat.widget;

import android.content.DialogInterface;
import android.content.DialogInterface$OnClickListener;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AlertDialog$Builder;

/* JADX INFO: loaded from: classes.dex */
@VisibleForTesting
public class AppCompatSpinner$DialogPopup implements AppCompatSpinner$SpinnerPopup, DialogInterface$OnClickListener {
    private ListAdapter mListAdapter;

    @VisibleForTesting
    public AlertDialog mPopup;
    private CharSequence mPrompt;
    public final /* synthetic */ AppCompatSpinner this$0;

    public AppCompatSpinner$DialogPopup(AppCompatSpinner appCompatSpinner) {
        this.this$0 = appCompatSpinner;
    }

    @Override // androidx.appcompat.widget.AppCompatSpinner$SpinnerPopup
    public void dismiss() {
        AlertDialog alertDialog = this.mPopup;
        if (alertDialog != null) {
            alertDialog.dismiss();
            this.mPopup = null;
        }
    }

    @Override // androidx.appcompat.widget.AppCompatSpinner$SpinnerPopup
    public Drawable getBackground() {
        return null;
    }

    @Override // androidx.appcompat.widget.AppCompatSpinner$SpinnerPopup
    public CharSequence getHintText() {
        return this.mPrompt;
    }

    @Override // androidx.appcompat.widget.AppCompatSpinner$SpinnerPopup
    public int getHorizontalOffset() {
        return 0;
    }

    @Override // androidx.appcompat.widget.AppCompatSpinner$SpinnerPopup
    public int getHorizontalOriginalOffset() {
        return 0;
    }

    @Override // androidx.appcompat.widget.AppCompatSpinner$SpinnerPopup
    public int getVerticalOffset() {
        return 0;
    }

    @Override // androidx.appcompat.widget.AppCompatSpinner$SpinnerPopup
    public boolean isShowing() {
        AlertDialog alertDialog = this.mPopup;
        if (alertDialog != null) {
            return alertDialog.isShowing();
        }
        return false;
    }

    @Override // android.content.DialogInterface$OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.this$0.setSelection(i);
        if (this.this$0.getOnItemClickListener() != null) {
            this.this$0.performItemClick(null, i, this.mListAdapter.getItemId(i));
        }
        dismiss();
    }

    @Override // androidx.appcompat.widget.AppCompatSpinner$SpinnerPopup
    public void setAdapter(ListAdapter listAdapter) {
        this.mListAdapter = listAdapter;
    }

    @Override // androidx.appcompat.widget.AppCompatSpinner$SpinnerPopup
    public void setBackgroundDrawable(Drawable drawable) {
        Log.e("AppCompatSpinner", "Cannot set popup background for MODE_DIALOG, ignoring");
    }

    @Override // androidx.appcompat.widget.AppCompatSpinner$SpinnerPopup
    public void setHorizontalOffset(int i) {
        Log.e("AppCompatSpinner", "Cannot set horizontal offset for MODE_DIALOG, ignoring");
    }

    @Override // androidx.appcompat.widget.AppCompatSpinner$SpinnerPopup
    public void setHorizontalOriginalOffset(int i) {
        Log.e("AppCompatSpinner", "Cannot set horizontal (original) offset for MODE_DIALOG, ignoring");
    }

    @Override // androidx.appcompat.widget.AppCompatSpinner$SpinnerPopup
    public void setPromptText(CharSequence charSequence) {
        this.mPrompt = charSequence;
    }

    @Override // androidx.appcompat.widget.AppCompatSpinner$SpinnerPopup
    public void setVerticalOffset(int i) {
        Log.e("AppCompatSpinner", "Cannot set vertical offset for MODE_DIALOG, ignoring");
    }

    @Override // androidx.appcompat.widget.AppCompatSpinner$SpinnerPopup
    public void show(int i, int i2) {
        if (this.mListAdapter == null) {
            return;
        }
        AlertDialog$Builder alertDialog$Builder = new AlertDialog$Builder(this.this$0.getPopupContext());
        CharSequence charSequence = this.mPrompt;
        if (charSequence != null) {
            alertDialog$Builder.setTitle(charSequence);
        }
        AlertDialog alertDialogCreate = alertDialog$Builder.setSingleChoiceItems(this.mListAdapter, this.this$0.getSelectedItemPosition(), this).create();
        this.mPopup = alertDialogCreate;
        ListView listView = alertDialogCreate.getListView();
        listView.setTextDirection(i);
        listView.setTextAlignment(i2);
        this.mPopup.show();
    }
}
