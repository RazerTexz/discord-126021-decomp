package androidx.viewpager2.widget;

import android.R$id;
import android.os.Bundle;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat$AccessibilityActionCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat$CollectionInfoCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$Adapter;
import androidx.recyclerview.widget.RecyclerView$AdapterDataObserver;

/* JADX INFO: loaded from: classes.dex */
public class ViewPager2$PageAwareAccessibilityProvider extends ViewPager2$AccessibilityProvider {
    private final AccessibilityViewCommand mActionPageBackward;
    private final AccessibilityViewCommand mActionPageForward;
    private RecyclerView$AdapterDataObserver mAdapterDataObserver;
    public final /* synthetic */ ViewPager2 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewPager2$PageAwareAccessibilityProvider(ViewPager2 viewPager2) {
        super(viewPager2, null);
        this.this$0 = viewPager2;
        this.mActionPageForward = new ViewPager2$PageAwareAccessibilityProvider$1(this);
        this.mActionPageBackward = new ViewPager2$PageAwareAccessibilityProvider$2(this);
    }

    private void addCollectionInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        int itemCount;
        int itemCount2;
        if (this.this$0.getAdapter() != null) {
            if (this.this$0.getOrientation() == 1) {
                itemCount = this.this$0.getAdapter().getItemCount();
            } else {
                itemCount2 = this.this$0.getAdapter().getItemCount();
                itemCount = 0;
            }
            AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo).setCollectionInfo(AccessibilityNodeInfoCompat$CollectionInfoCompat.obtain(itemCount, itemCount2, false, 0));
        }
        itemCount = 0;
        itemCount2 = 0;
        AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo).setCollectionInfo(AccessibilityNodeInfoCompat$CollectionInfoCompat.obtain(itemCount, itemCount2, false, 0));
    }

    private void addScrollActions(AccessibilityNodeInfo accessibilityNodeInfo) {
        int itemCount;
        RecyclerView$Adapter adapter = this.this$0.getAdapter();
        if (adapter == null || (itemCount = adapter.getItemCount()) == 0 || !this.this$0.isUserInputEnabled()) {
            return;
        }
        if (this.this$0.mCurrentItem > 0) {
            accessibilityNodeInfo.addAction(8192);
        }
        if (this.this$0.mCurrentItem < itemCount - 1) {
            accessibilityNodeInfo.addAction(4096);
        }
        accessibilityNodeInfo.setScrollable(true);
    }

    @Override // androidx.viewpager2.widget.ViewPager2$AccessibilityProvider
    public boolean handlesGetAccessibilityClassName() {
        return true;
    }

    @Override // androidx.viewpager2.widget.ViewPager2$AccessibilityProvider
    public boolean handlesPerformAccessibilityAction(int i, Bundle bundle) {
        return i == 8192 || i == 4096;
    }

    @Override // androidx.viewpager2.widget.ViewPager2$AccessibilityProvider
    public void onAttachAdapter(@Nullable RecyclerView$Adapter<?> recyclerView$Adapter) {
        updatePageAccessibilityActions();
        if (recyclerView$Adapter != null) {
            recyclerView$Adapter.registerAdapterDataObserver(this.mAdapterDataObserver);
        }
    }

    @Override // androidx.viewpager2.widget.ViewPager2$AccessibilityProvider
    public void onDetachAdapter(@Nullable RecyclerView$Adapter<?> recyclerView$Adapter) {
        if (recyclerView$Adapter != null) {
            recyclerView$Adapter.unregisterAdapterDataObserver(this.mAdapterDataObserver);
        }
    }

    @Override // androidx.viewpager2.widget.ViewPager2$AccessibilityProvider
    public String onGetAccessibilityClassName() {
        if (handlesGetAccessibilityClassName()) {
            return "androidx.viewpager.widget.ViewPager";
        }
        throw new IllegalStateException();
    }

    @Override // androidx.viewpager2.widget.ViewPager2$AccessibilityProvider
    public void onInitialize(@NonNull CompositeOnPageChangeCallback compositeOnPageChangeCallback, @NonNull RecyclerView recyclerView) {
        ViewCompat.setImportantForAccessibility(recyclerView, 2);
        this.mAdapterDataObserver = new ViewPager2$PageAwareAccessibilityProvider$3(this);
        if (ViewCompat.getImportantForAccessibility(this.this$0) == 0) {
            ViewCompat.setImportantForAccessibility(this.this$0, 1);
        }
    }

    @Override // androidx.viewpager2.widget.ViewPager2$AccessibilityProvider
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        addCollectionInfo(accessibilityNodeInfo);
        addScrollActions(accessibilityNodeInfo);
    }

    @Override // androidx.viewpager2.widget.ViewPager2$AccessibilityProvider
    public boolean onPerformAccessibilityAction(int i, Bundle bundle) {
        if (!handlesPerformAccessibilityAction(i, bundle)) {
            throw new IllegalStateException();
        }
        setCurrentItemFromAccessibilityCommand(i == 8192 ? this.this$0.getCurrentItem() - 1 : this.this$0.getCurrentItem() + 1);
        return true;
    }

    @Override // androidx.viewpager2.widget.ViewPager2$AccessibilityProvider
    public void onRestorePendingState() {
        updatePageAccessibilityActions();
    }

    @Override // androidx.viewpager2.widget.ViewPager2$AccessibilityProvider
    public void onRvInitializeAccessibilityEvent(@NonNull AccessibilityEvent accessibilityEvent) {
        accessibilityEvent.setSource(this.this$0);
        accessibilityEvent.setClassName(onGetAccessibilityClassName());
    }

    @Override // androidx.viewpager2.widget.ViewPager2$AccessibilityProvider
    public void onSetLayoutDirection() {
        updatePageAccessibilityActions();
    }

    @Override // androidx.viewpager2.widget.ViewPager2$AccessibilityProvider
    public void onSetNewCurrentItem() {
        updatePageAccessibilityActions();
    }

    @Override // androidx.viewpager2.widget.ViewPager2$AccessibilityProvider
    public void onSetOrientation() {
        updatePageAccessibilityActions();
    }

    @Override // androidx.viewpager2.widget.ViewPager2$AccessibilityProvider
    public void onSetUserInputEnabled() {
        updatePageAccessibilityActions();
    }

    public void setCurrentItemFromAccessibilityCommand(int i) {
        if (this.this$0.isUserInputEnabled()) {
            this.this$0.setCurrentItemInternal(i, true);
        }
    }

    public void updatePageAccessibilityActions() {
        int itemCount;
        ViewPager2 viewPager2 = this.this$0;
        int i = R$id.accessibilityActionPageLeft;
        ViewCompat.removeAccessibilityAction(viewPager2, R$id.accessibilityActionPageLeft);
        ViewCompat.removeAccessibilityAction(viewPager2, R$id.accessibilityActionPageRight);
        ViewCompat.removeAccessibilityAction(viewPager2, R$id.accessibilityActionPageUp);
        ViewCompat.removeAccessibilityAction(viewPager2, R$id.accessibilityActionPageDown);
        if (this.this$0.getAdapter() == null || (itemCount = this.this$0.getAdapter().getItemCount()) == 0 || !this.this$0.isUserInputEnabled()) {
            return;
        }
        if (this.this$0.getOrientation() != 0) {
            if (this.this$0.mCurrentItem < itemCount - 1) {
                ViewCompat.replaceAccessibilityAction(viewPager2, new AccessibilityNodeInfoCompat$AccessibilityActionCompat(R$id.accessibilityActionPageDown, null), null, this.mActionPageForward);
            }
            if (this.this$0.mCurrentItem > 0) {
                ViewCompat.replaceAccessibilityAction(viewPager2, new AccessibilityNodeInfoCompat$AccessibilityActionCompat(R$id.accessibilityActionPageUp, null), null, this.mActionPageBackward);
                return;
            }
            return;
        }
        boolean zIsRtl = this.this$0.isRtl();
        int i2 = zIsRtl ? R$id.accessibilityActionPageLeft : R$id.accessibilityActionPageRight;
        if (zIsRtl) {
            i = R$id.accessibilityActionPageRight;
        }
        if (this.this$0.mCurrentItem < itemCount - 1) {
            ViewCompat.replaceAccessibilityAction(viewPager2, new AccessibilityNodeInfoCompat$AccessibilityActionCompat(i2, null), null, this.mActionPageForward);
        }
        if (this.this$0.mCurrentItem > 0) {
            ViewCompat.replaceAccessibilityAction(viewPager2, new AccessibilityNodeInfoCompat$AccessibilityActionCompat(i, null), null, this.mActionPageBackward);
        }
    }
}
