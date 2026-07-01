package androidx.appcompat.app;

import android.R$id;
import android.content.Context;
import android.content.DialogInterface$OnCancelListener;
import android.content.DialogInterface$OnClickListener;
import android.content.DialogInterface$OnDismissListener;
import android.content.DialogInterface$OnKeyListener;
import android.content.DialogInterface$OnMultiChoiceClickListener;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView$OnItemSelectedListener;
import android.widget.ListAdapter;
import android.widget.SimpleCursorAdapter;

/* JADX INFO: loaded from: classes.dex */
public class AlertController$AlertParams {
    public ListAdapter mAdapter;
    public boolean[] mCheckedItems;
    public final Context mContext;
    public Cursor mCursor;
    public View mCustomTitleView;
    public boolean mForceInverseBackground;
    public Drawable mIcon;
    public final LayoutInflater mInflater;
    public String mIsCheckedColumn;
    public boolean mIsMultiChoice;
    public boolean mIsSingleChoice;
    public CharSequence[] mItems;
    public String mLabelColumn;
    public CharSequence mMessage;
    public Drawable mNegativeButtonIcon;
    public DialogInterface$OnClickListener mNegativeButtonListener;
    public CharSequence mNegativeButtonText;
    public Drawable mNeutralButtonIcon;
    public DialogInterface$OnClickListener mNeutralButtonListener;
    public CharSequence mNeutralButtonText;
    public DialogInterface$OnCancelListener mOnCancelListener;
    public DialogInterface$OnMultiChoiceClickListener mOnCheckboxClickListener;
    public DialogInterface$OnClickListener mOnClickListener;
    public DialogInterface$OnDismissListener mOnDismissListener;
    public AdapterView$OnItemSelectedListener mOnItemSelectedListener;
    public DialogInterface$OnKeyListener mOnKeyListener;
    public AlertController$AlertParams$OnPrepareListViewListener mOnPrepareListViewListener;
    public Drawable mPositiveButtonIcon;
    public DialogInterface$OnClickListener mPositiveButtonListener;
    public CharSequence mPositiveButtonText;
    public CharSequence mTitle;
    public View mView;
    public int mViewLayoutResId;
    public int mViewSpacingBottom;
    public int mViewSpacingLeft;
    public int mViewSpacingRight;
    public int mViewSpacingTop;
    public int mIconId = 0;
    public int mIconAttrId = 0;
    public boolean mViewSpacingSpecified = false;
    public int mCheckedItem = -1;
    public boolean mRecycleOnMeasure = true;
    public boolean mCancelable = true;

    public AlertController$AlertParams(Context context) {
        this.mContext = context;
        this.mInflater = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    private void createListView(AlertController alertController) {
        ListAdapter alertController$CheckedItemAdapter;
        AlertController$RecycleListView alertController$RecycleListView = (AlertController$RecycleListView) this.mInflater.inflate(alertController.mListLayout, (ViewGroup) null);
        if (this.mIsMultiChoice) {
            alertController$CheckedItemAdapter = this.mCursor == null ? new AlertController$AlertParams$1(this, this.mContext, alertController.mMultiChoiceItemLayout, R$id.text1, this.mItems, alertController$RecycleListView) : new AlertController$AlertParams$2(this, this.mContext, this.mCursor, false, alertController$RecycleListView, alertController);
        } else {
            int i = this.mIsSingleChoice ? alertController.mSingleChoiceItemLayout : alertController.mListItemLayout;
            if (this.mCursor != null) {
                alertController$CheckedItemAdapter = new SimpleCursorAdapter(this.mContext, i, this.mCursor, new String[]{this.mLabelColumn}, new int[]{R$id.text1});
            } else {
                alertController$CheckedItemAdapter = this.mAdapter;
                if (alertController$CheckedItemAdapter == null) {
                    alertController$CheckedItemAdapter = new AlertController$CheckedItemAdapter(this.mContext, i, R$id.text1, this.mItems);
                }
            }
        }
        AlertController$AlertParams$OnPrepareListViewListener alertController$AlertParams$OnPrepareListViewListener = this.mOnPrepareListViewListener;
        if (alertController$AlertParams$OnPrepareListViewListener != null) {
            alertController$AlertParams$OnPrepareListViewListener.onPrepareListView(alertController$RecycleListView);
        }
        alertController.mAdapter = alertController$CheckedItemAdapter;
        alertController.mCheckedItem = this.mCheckedItem;
        if (this.mOnClickListener != null) {
            alertController$RecycleListView.setOnItemClickListener(new AlertController$AlertParams$3(this, alertController));
        } else if (this.mOnCheckboxClickListener != null) {
            alertController$RecycleListView.setOnItemClickListener(new AlertController$AlertParams$4(this, alertController$RecycleListView, alertController));
        }
        AdapterView$OnItemSelectedListener adapterView$OnItemSelectedListener = this.mOnItemSelectedListener;
        if (adapterView$OnItemSelectedListener != null) {
            alertController$RecycleListView.setOnItemSelectedListener(adapterView$OnItemSelectedListener);
        }
        if (this.mIsSingleChoice) {
            alertController$RecycleListView.setChoiceMode(1);
        } else if (this.mIsMultiChoice) {
            alertController$RecycleListView.setChoiceMode(2);
        }
        alertController.mListView = alertController$RecycleListView;
    }

    public void apply(AlertController alertController) {
        View view = this.mCustomTitleView;
        if (view != null) {
            alertController.setCustomTitle(view);
        } else {
            CharSequence charSequence = this.mTitle;
            if (charSequence != null) {
                alertController.setTitle(charSequence);
            }
            Drawable drawable = this.mIcon;
            if (drawable != null) {
                alertController.setIcon(drawable);
            }
            int i = this.mIconId;
            if (i != 0) {
                alertController.setIcon(i);
            }
            int i2 = this.mIconAttrId;
            if (i2 != 0) {
                alertController.setIcon(alertController.getIconAttributeResId(i2));
            }
        }
        CharSequence charSequence2 = this.mMessage;
        if (charSequence2 != null) {
            alertController.setMessage(charSequence2);
        }
        CharSequence charSequence3 = this.mPositiveButtonText;
        if (charSequence3 != null || this.mPositiveButtonIcon != null) {
            alertController.setButton(-1, charSequence3, this.mPositiveButtonListener, null, this.mPositiveButtonIcon);
        }
        CharSequence charSequence4 = this.mNegativeButtonText;
        if (charSequence4 != null || this.mNegativeButtonIcon != null) {
            alertController.setButton(-2, charSequence4, this.mNegativeButtonListener, null, this.mNegativeButtonIcon);
        }
        CharSequence charSequence5 = this.mNeutralButtonText;
        if (charSequence5 != null || this.mNeutralButtonIcon != null) {
            alertController.setButton(-3, charSequence5, this.mNeutralButtonListener, null, this.mNeutralButtonIcon);
        }
        if (this.mItems != null || this.mCursor != null || this.mAdapter != null) {
            createListView(alertController);
        }
        View view2 = this.mView;
        if (view2 != null) {
            if (this.mViewSpacingSpecified) {
                alertController.setView(view2, this.mViewSpacingLeft, this.mViewSpacingTop, this.mViewSpacingRight, this.mViewSpacingBottom);
                return;
            } else {
                alertController.setView(view2);
                return;
            }
        }
        int i3 = this.mViewLayoutResId;
        if (i3 != 0) {
            alertController.setView(i3);
        }
    }
}
