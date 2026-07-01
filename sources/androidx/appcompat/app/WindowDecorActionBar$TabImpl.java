package androidx.appcompat.app;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.RestrictTo;
import androidx.annotation.RestrictTo$Scope;
import androidx.appcompat.content.res.AppCompatResources;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo$Scope.LIBRARY_GROUP_PREFIX})
public class WindowDecorActionBar$TabImpl extends ActionBar$Tab {
    private ActionBar$TabListener mCallback;
    private CharSequence mContentDesc;
    private View mCustomView;
    private Drawable mIcon;
    private int mPosition = -1;
    private Object mTag;
    private CharSequence mText;
    public final /* synthetic */ WindowDecorActionBar this$0;

    public WindowDecorActionBar$TabImpl(WindowDecorActionBar windowDecorActionBar) {
        this.this$0 = windowDecorActionBar;
    }

    public ActionBar$TabListener getCallback() {
        return this.mCallback;
    }

    @Override // androidx.appcompat.app.ActionBar$Tab
    public CharSequence getContentDescription() {
        return this.mContentDesc;
    }

    @Override // androidx.appcompat.app.ActionBar$Tab
    public View getCustomView() {
        return this.mCustomView;
    }

    @Override // androidx.appcompat.app.ActionBar$Tab
    public Drawable getIcon() {
        return this.mIcon;
    }

    @Override // androidx.appcompat.app.ActionBar$Tab
    public int getPosition() {
        return this.mPosition;
    }

    @Override // androidx.appcompat.app.ActionBar$Tab
    public Object getTag() {
        return this.mTag;
    }

    @Override // androidx.appcompat.app.ActionBar$Tab
    public CharSequence getText() {
        return this.mText;
    }

    @Override // androidx.appcompat.app.ActionBar$Tab
    public void select() {
        this.this$0.selectTab(this);
    }

    @Override // androidx.appcompat.app.ActionBar$Tab
    public ActionBar$Tab setContentDescription(int i) {
        return setContentDescription(this.this$0.mContext.getResources().getText(i));
    }

    @Override // androidx.appcompat.app.ActionBar$Tab
    public ActionBar$Tab setCustomView(View view) {
        this.mCustomView = view;
        int i = this.mPosition;
        if (i >= 0) {
            this.this$0.mTabScrollView.updateTab(i);
        }
        return this;
    }

    @Override // androidx.appcompat.app.ActionBar$Tab
    public ActionBar$Tab setIcon(Drawable drawable) {
        this.mIcon = drawable;
        int i = this.mPosition;
        if (i >= 0) {
            this.this$0.mTabScrollView.updateTab(i);
        }
        return this;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    @Override // androidx.appcompat.app.ActionBar$Tab
    public ActionBar$Tab setTabListener(ActionBar$TabListener actionBar$TabListener) {
        this.mCallback = actionBar$TabListener;
        return this;
    }

    @Override // androidx.appcompat.app.ActionBar$Tab
    public ActionBar$Tab setTag(Object obj) {
        this.mTag = obj;
        return this;
    }

    @Override // androidx.appcompat.app.ActionBar$Tab
    public ActionBar$Tab setText(CharSequence charSequence) {
        this.mText = charSequence;
        int i = this.mPosition;
        if (i >= 0) {
            this.this$0.mTabScrollView.updateTab(i);
        }
        return this;
    }

    @Override // androidx.appcompat.app.ActionBar$Tab
    public ActionBar$Tab setContentDescription(CharSequence charSequence) {
        this.mContentDesc = charSequence;
        int i = this.mPosition;
        if (i >= 0) {
            this.this$0.mTabScrollView.updateTab(i);
        }
        return this;
    }

    @Override // androidx.appcompat.app.ActionBar$Tab
    public ActionBar$Tab setCustomView(int i) {
        return setCustomView(LayoutInflater.from(this.this$0.getThemedContext()).inflate(i, (ViewGroup) null));
    }

    @Override // androidx.appcompat.app.ActionBar$Tab
    public ActionBar$Tab setIcon(int i) {
        return setIcon(AppCompatResources.getDrawable(this.this$0.mContext, i));
    }

    @Override // androidx.appcompat.app.ActionBar$Tab
    public ActionBar$Tab setText(int i) {
        return setText(this.this$0.mContext.getResources().getText(i));
    }
}
