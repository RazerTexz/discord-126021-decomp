package androidx.viewpager2.adapter;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentManager$FragmentLifecycleCallbacks;

/* JADX INFO: loaded from: classes.dex */
public class FragmentStateAdapter$3 extends FragmentManager$FragmentLifecycleCallbacks {
    public final /* synthetic */ FragmentStateAdapter this$0;
    public final /* synthetic */ FrameLayout val$container;
    public final /* synthetic */ Fragment val$fragment;

    public FragmentStateAdapter$3(FragmentStateAdapter fragmentStateAdapter, Fragment fragment, FrameLayout frameLayout) {
        this.this$0 = fragmentStateAdapter;
        this.val$fragment = fragment;
        this.val$container = frameLayout;
    }

    @Override // androidx.fragment.app.FragmentManager$FragmentLifecycleCallbacks
    public void onFragmentViewCreated(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment, @NonNull View view, @Nullable Bundle bundle) {
        if (fragment == this.val$fragment) {
            fragmentManager.unregisterFragmentLifecycleCallbacks(this);
            this.this$0.addViewToContainer(view, this.val$container);
        }
    }
}
