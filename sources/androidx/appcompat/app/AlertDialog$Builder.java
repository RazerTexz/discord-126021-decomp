package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface$OnCancelListener;
import android.content.DialogInterface$OnClickListener;
import android.content.DialogInterface$OnDismissListener;
import android.content.DialogInterface$OnKeyListener;
import android.content.DialogInterface$OnMultiChoiceClickListener;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.AdapterView$OnItemSelectedListener;
import android.widget.ListAdapter;
import androidx.annotation.ArrayRes;
import androidx.annotation.AttrRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.RestrictTo$Scope;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;

/* JADX INFO: loaded from: classes.dex */
public class AlertDialog$Builder {
    private final AlertController$AlertParams P;
    private final int mTheme;

    public AlertDialog$Builder(@NonNull Context context) {
        this(context, AlertDialog.resolveDialogTheme(context, 0));
    }

    @NonNull
    public AlertDialog create() {
        AlertDialog alertDialog = new AlertDialog(this.P.mContext, this.mTheme);
        this.P.apply(alertDialog.mAlert);
        alertDialog.setCancelable(this.P.mCancelable);
        if (this.P.mCancelable) {
            alertDialog.setCanceledOnTouchOutside(true);
        }
        alertDialog.setOnCancelListener(this.P.mOnCancelListener);
        alertDialog.setOnDismissListener(this.P.mOnDismissListener);
        DialogInterface$OnKeyListener dialogInterface$OnKeyListener = this.P.mOnKeyListener;
        if (dialogInterface$OnKeyListener != null) {
            alertDialog.setOnKeyListener(dialogInterface$OnKeyListener);
        }
        return alertDialog;
    }

    @NonNull
    public Context getContext() {
        return this.P.mContext;
    }

    public AlertDialog$Builder setAdapter(ListAdapter listAdapter, DialogInterface$OnClickListener dialogInterface$OnClickListener) {
        AlertController$AlertParams alertController$AlertParams = this.P;
        alertController$AlertParams.mAdapter = listAdapter;
        alertController$AlertParams.mOnClickListener = dialogInterface$OnClickListener;
        return this;
    }

    public AlertDialog$Builder setCancelable(boolean z2) {
        this.P.mCancelable = z2;
        return this;
    }

    public AlertDialog$Builder setCursor(Cursor cursor, DialogInterface$OnClickListener dialogInterface$OnClickListener, String str) {
        AlertController$AlertParams alertController$AlertParams = this.P;
        alertController$AlertParams.mCursor = cursor;
        alertController$AlertParams.mLabelColumn = str;
        alertController$AlertParams.mOnClickListener = dialogInterface$OnClickListener;
        return this;
    }

    public AlertDialog$Builder setCustomTitle(@Nullable View view) {
        this.P.mCustomTitleView = view;
        return this;
    }

    public AlertDialog$Builder setIcon(@DrawableRes int i) {
        this.P.mIconId = i;
        return this;
    }

    public AlertDialog$Builder setIconAttribute(@AttrRes int i) {
        TypedValue typedValue = new TypedValue();
        this.P.mContext.getTheme().resolveAttribute(i, typedValue, true);
        this.P.mIconId = typedValue.resourceId;
        return this;
    }

    @Deprecated
    public AlertDialog$Builder setInverseBackgroundForced(boolean z2) {
        this.P.mForceInverseBackground = z2;
        return this;
    }

    public AlertDialog$Builder setItems(@ArrayRes int i, DialogInterface$OnClickListener dialogInterface$OnClickListener) {
        AlertController$AlertParams alertController$AlertParams = this.P;
        alertController$AlertParams.mItems = alertController$AlertParams.mContext.getResources().getTextArray(i);
        this.P.mOnClickListener = dialogInterface$OnClickListener;
        return this;
    }

    public AlertDialog$Builder setMessage(@StringRes int i) {
        AlertController$AlertParams alertController$AlertParams = this.P;
        alertController$AlertParams.mMessage = alertController$AlertParams.mContext.getText(i);
        return this;
    }

    public AlertDialog$Builder setMultiChoiceItems(@ArrayRes int i, boolean[] zArr, DialogInterface$OnMultiChoiceClickListener dialogInterface$OnMultiChoiceClickListener) {
        AlertController$AlertParams alertController$AlertParams = this.P;
        alertController$AlertParams.mItems = alertController$AlertParams.mContext.getResources().getTextArray(i);
        AlertController$AlertParams alertController$AlertParams2 = this.P;
        alertController$AlertParams2.mOnCheckboxClickListener = dialogInterface$OnMultiChoiceClickListener;
        alertController$AlertParams2.mCheckedItems = zArr;
        alertController$AlertParams2.mIsMultiChoice = true;
        return this;
    }

    public AlertDialog$Builder setNegativeButton(@StringRes int i, DialogInterface$OnClickListener dialogInterface$OnClickListener) {
        AlertController$AlertParams alertController$AlertParams = this.P;
        alertController$AlertParams.mNegativeButtonText = alertController$AlertParams.mContext.getText(i);
        this.P.mNegativeButtonListener = dialogInterface$OnClickListener;
        return this;
    }

    public AlertDialog$Builder setNegativeButtonIcon(Drawable drawable) {
        this.P.mNegativeButtonIcon = drawable;
        return this;
    }

    public AlertDialog$Builder setNeutralButton(@StringRes int i, DialogInterface$OnClickListener dialogInterface$OnClickListener) {
        AlertController$AlertParams alertController$AlertParams = this.P;
        alertController$AlertParams.mNeutralButtonText = alertController$AlertParams.mContext.getText(i);
        this.P.mNeutralButtonListener = dialogInterface$OnClickListener;
        return this;
    }

    public AlertDialog$Builder setNeutralButtonIcon(Drawable drawable) {
        this.P.mNeutralButtonIcon = drawable;
        return this;
    }

    public AlertDialog$Builder setOnCancelListener(DialogInterface$OnCancelListener dialogInterface$OnCancelListener) {
        this.P.mOnCancelListener = dialogInterface$OnCancelListener;
        return this;
    }

    public AlertDialog$Builder setOnDismissListener(DialogInterface$OnDismissListener dialogInterface$OnDismissListener) {
        this.P.mOnDismissListener = dialogInterface$OnDismissListener;
        return this;
    }

    public AlertDialog$Builder setOnItemSelectedListener(AdapterView$OnItemSelectedListener adapterView$OnItemSelectedListener) {
        this.P.mOnItemSelectedListener = adapterView$OnItemSelectedListener;
        return this;
    }

    public AlertDialog$Builder setOnKeyListener(DialogInterface$OnKeyListener dialogInterface$OnKeyListener) {
        this.P.mOnKeyListener = dialogInterface$OnKeyListener;
        return this;
    }

    public AlertDialog$Builder setPositiveButton(@StringRes int i, DialogInterface$OnClickListener dialogInterface$OnClickListener) {
        AlertController$AlertParams alertController$AlertParams = this.P;
        alertController$AlertParams.mPositiveButtonText = alertController$AlertParams.mContext.getText(i);
        this.P.mPositiveButtonListener = dialogInterface$OnClickListener;
        return this;
    }

    public AlertDialog$Builder setPositiveButtonIcon(Drawable drawable) {
        this.P.mPositiveButtonIcon = drawable;
        return this;
    }

    @RestrictTo({RestrictTo$Scope.LIBRARY_GROUP_PREFIX})
    public AlertDialog$Builder setRecycleOnMeasureEnabled(boolean z2) {
        this.P.mRecycleOnMeasure = z2;
        return this;
    }

    public AlertDialog$Builder setSingleChoiceItems(@ArrayRes int i, int i2, DialogInterface$OnClickListener dialogInterface$OnClickListener) {
        AlertController$AlertParams alertController$AlertParams = this.P;
        alertController$AlertParams.mItems = alertController$AlertParams.mContext.getResources().getTextArray(i);
        AlertController$AlertParams alertController$AlertParams2 = this.P;
        alertController$AlertParams2.mOnClickListener = dialogInterface$OnClickListener;
        alertController$AlertParams2.mCheckedItem = i2;
        alertController$AlertParams2.mIsSingleChoice = true;
        return this;
    }

    public AlertDialog$Builder setTitle(@StringRes int i) {
        AlertController$AlertParams alertController$AlertParams = this.P;
        alertController$AlertParams.mTitle = alertController$AlertParams.mContext.getText(i);
        return this;
    }

    public AlertDialog$Builder setView(int i) {
        AlertController$AlertParams alertController$AlertParams = this.P;
        alertController$AlertParams.mView = null;
        alertController$AlertParams.mViewLayoutResId = i;
        alertController$AlertParams.mViewSpacingSpecified = false;
        return this;
    }

    public AlertDialog show() {
        AlertDialog alertDialogCreate = create();
        alertDialogCreate.show();
        return alertDialogCreate;
    }

    public AlertDialog$Builder(@NonNull Context context, @StyleRes int i) {
        this.P = new AlertController$AlertParams(new ContextThemeWrapper(context, AlertDialog.resolveDialogTheme(context, i)));
        this.mTheme = i;
    }

    public AlertDialog$Builder setIcon(@Nullable Drawable drawable) {
        this.P.mIcon = drawable;
        return this;
    }

    public AlertDialog$Builder setMessage(@Nullable CharSequence charSequence) {
        this.P.mMessage = charSequence;
        return this;
    }

    public AlertDialog$Builder setTitle(@Nullable CharSequence charSequence) {
        this.P.mTitle = charSequence;
        return this;
    }

    public AlertDialog$Builder setItems(CharSequence[] charSequenceArr, DialogInterface$OnClickListener dialogInterface$OnClickListener) {
        AlertController$AlertParams alertController$AlertParams = this.P;
        alertController$AlertParams.mItems = charSequenceArr;
        alertController$AlertParams.mOnClickListener = dialogInterface$OnClickListener;
        return this;
    }

    public AlertDialog$Builder setNegativeButton(CharSequence charSequence, DialogInterface$OnClickListener dialogInterface$OnClickListener) {
        AlertController$AlertParams alertController$AlertParams = this.P;
        alertController$AlertParams.mNegativeButtonText = charSequence;
        alertController$AlertParams.mNegativeButtonListener = dialogInterface$OnClickListener;
        return this;
    }

    public AlertDialog$Builder setNeutralButton(CharSequence charSequence, DialogInterface$OnClickListener dialogInterface$OnClickListener) {
        AlertController$AlertParams alertController$AlertParams = this.P;
        alertController$AlertParams.mNeutralButtonText = charSequence;
        alertController$AlertParams.mNeutralButtonListener = dialogInterface$OnClickListener;
        return this;
    }

    public AlertDialog$Builder setPositiveButton(CharSequence charSequence, DialogInterface$OnClickListener dialogInterface$OnClickListener) {
        AlertController$AlertParams alertController$AlertParams = this.P;
        alertController$AlertParams.mPositiveButtonText = charSequence;
        alertController$AlertParams.mPositiveButtonListener = dialogInterface$OnClickListener;
        return this;
    }

    public AlertDialog$Builder setView(View view) {
        AlertController$AlertParams alertController$AlertParams = this.P;
        alertController$AlertParams.mView = view;
        alertController$AlertParams.mViewLayoutResId = 0;
        alertController$AlertParams.mViewSpacingSpecified = false;
        return this;
    }

    public AlertDialog$Builder setMultiChoiceItems(CharSequence[] charSequenceArr, boolean[] zArr, DialogInterface$OnMultiChoiceClickListener dialogInterface$OnMultiChoiceClickListener) {
        AlertController$AlertParams alertController$AlertParams = this.P;
        alertController$AlertParams.mItems = charSequenceArr;
        alertController$AlertParams.mOnCheckboxClickListener = dialogInterface$OnMultiChoiceClickListener;
        alertController$AlertParams.mCheckedItems = zArr;
        alertController$AlertParams.mIsMultiChoice = true;
        return this;
    }

    public AlertDialog$Builder setSingleChoiceItems(Cursor cursor, int i, String str, DialogInterface$OnClickListener dialogInterface$OnClickListener) {
        AlertController$AlertParams alertController$AlertParams = this.P;
        alertController$AlertParams.mCursor = cursor;
        alertController$AlertParams.mOnClickListener = dialogInterface$OnClickListener;
        alertController$AlertParams.mCheckedItem = i;
        alertController$AlertParams.mLabelColumn = str;
        alertController$AlertParams.mIsSingleChoice = true;
        return this;
    }

    @RestrictTo({RestrictTo$Scope.LIBRARY_GROUP_PREFIX})
    @Deprecated
    public AlertDialog$Builder setView(View view, int i, int i2, int i3, int i4) {
        AlertController$AlertParams alertController$AlertParams = this.P;
        alertController$AlertParams.mView = view;
        alertController$AlertParams.mViewLayoutResId = 0;
        alertController$AlertParams.mViewSpacingSpecified = true;
        alertController$AlertParams.mViewSpacingLeft = i;
        alertController$AlertParams.mViewSpacingTop = i2;
        alertController$AlertParams.mViewSpacingRight = i3;
        alertController$AlertParams.mViewSpacingBottom = i4;
        return this;
    }

    public AlertDialog$Builder setMultiChoiceItems(Cursor cursor, String str, String str2, DialogInterface$OnMultiChoiceClickListener dialogInterface$OnMultiChoiceClickListener) {
        AlertController$AlertParams alertController$AlertParams = this.P;
        alertController$AlertParams.mCursor = cursor;
        alertController$AlertParams.mOnCheckboxClickListener = dialogInterface$OnMultiChoiceClickListener;
        alertController$AlertParams.mIsCheckedColumn = str;
        alertController$AlertParams.mLabelColumn = str2;
        alertController$AlertParams.mIsMultiChoice = true;
        return this;
    }

    public AlertDialog$Builder setSingleChoiceItems(CharSequence[] charSequenceArr, int i, DialogInterface$OnClickListener dialogInterface$OnClickListener) {
        AlertController$AlertParams alertController$AlertParams = this.P;
        alertController$AlertParams.mItems = charSequenceArr;
        alertController$AlertParams.mOnClickListener = dialogInterface$OnClickListener;
        alertController$AlertParams.mCheckedItem = i;
        alertController$AlertParams.mIsSingleChoice = true;
        return this;
    }

    public AlertDialog$Builder setSingleChoiceItems(ListAdapter listAdapter, int i, DialogInterface$OnClickListener dialogInterface$OnClickListener) {
        AlertController$AlertParams alertController$AlertParams = this.P;
        alertController$AlertParams.mAdapter = listAdapter;
        alertController$AlertParams.mOnClickListener = dialogInterface$OnClickListener;
        alertController$AlertParams.mCheckedItem = i;
        alertController$AlertParams.mIsSingleChoice = true;
        return this;
    }
}
