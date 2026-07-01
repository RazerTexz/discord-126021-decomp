package androidx.fragment.app;

import android.R$attr;
import android.R$id;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.FrameLayout$LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout$LayoutParams;
import android.widget.TabHost;
import android.widget.TabHost$OnTabChangeListener;
import android.widget.TabHost$TabSpec;
import android.widget.TabWidget;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import b.d.b.a.a;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class FragmentTabHost extends TabHost implements TabHost$OnTabChangeListener {
    private boolean mAttached;
    private int mContainerId;
    private Context mContext;
    private FragmentManager mFragmentManager;
    private FragmentTabHost$TabInfo mLastTab;
    private TabHost$OnTabChangeListener mOnTabChangeListener;
    private FrameLayout mRealTabContent;
    private final ArrayList<FragmentTabHost$TabInfo> mTabs;

    @Deprecated
    public FragmentTabHost(@NonNull Context context) {
        super(context, null);
        this.mTabs = new ArrayList<>();
        initFragmentTabHost(context, null);
    }

    @Nullable
    private FragmentTransaction doTabChanged(@Nullable String str, @Nullable FragmentTransaction fragmentTransaction) {
        Fragment fragment;
        FragmentTabHost$TabInfo tabInfoForTag = getTabInfoForTag(str);
        if (this.mLastTab != tabInfoForTag) {
            if (fragmentTransaction == null) {
                fragmentTransaction = this.mFragmentManager.beginTransaction();
            }
            FragmentTabHost$TabInfo fragmentTabHost$TabInfo = this.mLastTab;
            if (fragmentTabHost$TabInfo != null && (fragment = fragmentTabHost$TabInfo.fragment) != null) {
                fragmentTransaction.detach(fragment);
            }
            if (tabInfoForTag != null) {
                Fragment fragment2 = tabInfoForTag.fragment;
                if (fragment2 == null) {
                    Fragment fragmentInstantiate = this.mFragmentManager.getFragmentFactory().instantiate(this.mContext.getClassLoader(), tabInfoForTag.clss.getName());
                    tabInfoForTag.fragment = fragmentInstantiate;
                    fragmentInstantiate.setArguments(tabInfoForTag.args);
                    fragmentTransaction.add(this.mContainerId, tabInfoForTag.fragment, tabInfoForTag.tag);
                } else {
                    fragmentTransaction.attach(fragment2);
                }
            }
            this.mLastTab = tabInfoForTag;
        }
        return fragmentTransaction;
    }

    private void ensureContent() {
        if (this.mRealTabContent == null) {
            FrameLayout frameLayout = (FrameLayout) findViewById(this.mContainerId);
            this.mRealTabContent = frameLayout;
            if (frameLayout != null) {
                return;
            }
            StringBuilder sbU = a.U("No tab content FrameLayout found for id ");
            sbU.append(this.mContainerId);
            throw new IllegalStateException(sbU.toString());
        }
    }

    private void ensureHierarchy(Context context) {
        if (findViewById(R$id.tabs) == null) {
            LinearLayout linearLayout = new LinearLayout(context);
            linearLayout.setOrientation(1);
            addView(linearLayout, new FrameLayout$LayoutParams(-1, -1));
            TabWidget tabWidget = new TabWidget(context);
            tabWidget.setId(R$id.tabs);
            tabWidget.setOrientation(0);
            linearLayout.addView(tabWidget, new LinearLayout$LayoutParams(-1, -2, 0.0f));
            FrameLayout frameLayout = new FrameLayout(context);
            frameLayout.setId(R$id.tabcontent);
            linearLayout.addView(frameLayout, new LinearLayout$LayoutParams(0, 0, 0.0f));
            FrameLayout frameLayout2 = new FrameLayout(context);
            this.mRealTabContent = frameLayout2;
            frameLayout2.setId(this.mContainerId);
            linearLayout.addView(frameLayout2, new LinearLayout$LayoutParams(-1, 0, 1.0f));
        }
    }

    @Nullable
    private FragmentTabHost$TabInfo getTabInfoForTag(String str) {
        int size = this.mTabs.size();
        for (int i = 0; i < size; i++) {
            FragmentTabHost$TabInfo fragmentTabHost$TabInfo = this.mTabs.get(i);
            if (fragmentTabHost$TabInfo.tag.equals(str)) {
                return fragmentTabHost$TabInfo;
            }
        }
        return null;
    }

    private void initFragmentTabHost(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R$attr.inflatedId}, 0, 0);
        this.mContainerId = typedArrayObtainStyledAttributes.getResourceId(0, 0);
        typedArrayObtainStyledAttributes.recycle();
        super.setOnTabChangedListener(this);
    }

    @Deprecated
    public void addTab(@NonNull TabHost$TabSpec tabHost$TabSpec, @NonNull Class<?> cls, @Nullable Bundle bundle) {
        tabHost$TabSpec.setContent(new FragmentTabHost$DummyTabFactory(this.mContext));
        String tag = tabHost$TabSpec.getTag();
        FragmentTabHost$TabInfo fragmentTabHost$TabInfo = new FragmentTabHost$TabInfo(tag, cls, bundle);
        if (this.mAttached) {
            Fragment fragmentFindFragmentByTag = this.mFragmentManager.findFragmentByTag(tag);
            fragmentTabHost$TabInfo.fragment = fragmentFindFragmentByTag;
            if (fragmentFindFragmentByTag != null && !fragmentFindFragmentByTag.isDetached()) {
                FragmentTransaction fragmentTransactionBeginTransaction = this.mFragmentManager.beginTransaction();
                fragmentTransactionBeginTransaction.detach(fragmentTabHost$TabInfo.fragment);
                fragmentTransactionBeginTransaction.commit();
            }
        }
        this.mTabs.add(fragmentTabHost$TabInfo);
        addTab(tabHost$TabSpec);
    }

    @Override // android.view.ViewGroup, android.view.View
    @Deprecated
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        String currentTabTag = getCurrentTabTag();
        int size = this.mTabs.size();
        FragmentTransaction fragmentTransactionBeginTransaction = null;
        for (int i = 0; i < size; i++) {
            FragmentTabHost$TabInfo fragmentTabHost$TabInfo = this.mTabs.get(i);
            Fragment fragmentFindFragmentByTag = this.mFragmentManager.findFragmentByTag(fragmentTabHost$TabInfo.tag);
            fragmentTabHost$TabInfo.fragment = fragmentFindFragmentByTag;
            if (fragmentFindFragmentByTag != null && !fragmentFindFragmentByTag.isDetached()) {
                if (fragmentTabHost$TabInfo.tag.equals(currentTabTag)) {
                    this.mLastTab = fragmentTabHost$TabInfo;
                } else {
                    if (fragmentTransactionBeginTransaction == null) {
                        fragmentTransactionBeginTransaction = this.mFragmentManager.beginTransaction();
                    }
                    fragmentTransactionBeginTransaction.detach(fragmentTabHost$TabInfo.fragment);
                }
            }
        }
        this.mAttached = true;
        FragmentTransaction fragmentTransactionDoTabChanged = doTabChanged(currentTabTag, fragmentTransactionBeginTransaction);
        if (fragmentTransactionDoTabChanged != null) {
            fragmentTransactionDoTabChanged.commit();
            this.mFragmentManager.executePendingTransactions();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    @Deprecated
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mAttached = false;
    }

    @Override // android.view.View
    @Deprecated
    public void onRestoreInstanceState(@SuppressLint({"UnknownNullness"}) Parcelable parcelable) {
        if (!(parcelable instanceof FragmentTabHost$SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        FragmentTabHost$SavedState fragmentTabHost$SavedState = (FragmentTabHost$SavedState) parcelable;
        super.onRestoreInstanceState(fragmentTabHost$SavedState.getSuperState());
        setCurrentTabByTag(fragmentTabHost$SavedState.curTab);
    }

    @Override // android.view.View
    @NonNull
    @Deprecated
    public Parcelable onSaveInstanceState() {
        FragmentTabHost$SavedState fragmentTabHost$SavedState = new FragmentTabHost$SavedState(super.onSaveInstanceState());
        fragmentTabHost$SavedState.curTab = getCurrentTabTag();
        return fragmentTabHost$SavedState;
    }

    @Override // android.widget.TabHost$OnTabChangeListener
    @Deprecated
    public void onTabChanged(@Nullable String str) {
        FragmentTransaction fragmentTransactionDoTabChanged;
        if (this.mAttached && (fragmentTransactionDoTabChanged = doTabChanged(str, null)) != null) {
            fragmentTransactionDoTabChanged.commit();
        }
        TabHost$OnTabChangeListener tabHost$OnTabChangeListener = this.mOnTabChangeListener;
        if (tabHost$OnTabChangeListener != null) {
            tabHost$OnTabChangeListener.onTabChanged(str);
        }
    }

    @Override // android.widget.TabHost
    @Deprecated
    public void setOnTabChangedListener(@Nullable TabHost$OnTabChangeListener tabHost$OnTabChangeListener) {
        this.mOnTabChangeListener = tabHost$OnTabChangeListener;
    }

    @Override // android.widget.TabHost
    @Deprecated
    public void setup() {
        throw new IllegalStateException("Must call setup() that takes a Context and FragmentManager");
    }

    @Deprecated
    public void setup(@NonNull Context context, @NonNull FragmentManager fragmentManager) {
        ensureHierarchy(context);
        super.setup();
        this.mContext = context;
        this.mFragmentManager = fragmentManager;
        ensureContent();
    }

    @Deprecated
    public FragmentTabHost(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mTabs = new ArrayList<>();
        initFragmentTabHost(context, attributeSet);
    }

    @Deprecated
    public void setup(@NonNull Context context, @NonNull FragmentManager fragmentManager, int i) {
        ensureHierarchy(context);
        super.setup();
        this.mContext = context;
        this.mFragmentManager = fragmentManager;
        this.mContainerId = i;
        ensureContent();
        this.mRealTabContent.setId(i);
        if (getId() == -1) {
            setId(R$id.tabhost);
        }
    }
}
