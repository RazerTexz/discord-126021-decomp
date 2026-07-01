package androidx.fragment.app;

import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.ActivityResultRegistryOwner;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.view.Lifecycle;
import androidx.view.ViewModelStore;
import androidx.view.ViewModelStoreOwner;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes.dex */
public class FragmentActivity$HostCallbacks extends FragmentHostCallback<FragmentActivity> implements ViewModelStoreOwner, OnBackPressedDispatcherOwner, ActivityResultRegistryOwner, FragmentOnAttachListener {
    public final /* synthetic */ FragmentActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FragmentActivity$HostCallbacks(FragmentActivity fragmentActivity) {
        super(fragmentActivity);
        this.this$0 = fragmentActivity;
    }

    @Override // androidx.activity.result.ActivityResultRegistryOwner
    @NonNull
    public ActivityResultRegistry getActivityResultRegistry() {
        return this.this$0.getActivityResultRegistry();
    }

    @Override // androidx.view.LifecycleOwner
    @NonNull
    public Lifecycle getLifecycle() {
        return this.this$0.mFragmentLifecycleRegistry;
    }

    @Override // androidx.activity.OnBackPressedDispatcherOwner
    @NonNull
    public OnBackPressedDispatcher getOnBackPressedDispatcher() {
        return this.this$0.getOnBackPressedDispatcher();
    }

    @Override // androidx.view.ViewModelStoreOwner
    @NonNull
    public ViewModelStore getViewModelStore() {
        return this.this$0.getViewModelStore();
    }

    @Override // androidx.fragment.app.FragmentOnAttachListener
    public void onAttachFragment(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment) {
        this.this$0.onAttachFragment(fragment);
    }

    @Override // androidx.fragment.app.FragmentHostCallback
    public void onDump(@NonNull String str, @Nullable FileDescriptor fileDescriptor, @NonNull PrintWriter printWriter, @Nullable String[] strArr) {
        this.this$0.dump(str, fileDescriptor, printWriter, strArr);
    }

    @Override // androidx.fragment.app.FragmentHostCallback, androidx.fragment.app.FragmentContainer
    @Nullable
    public View onFindViewById(int i) {
        return this.this$0.findViewById(i);
    }

    @Override // androidx.fragment.app.FragmentHostCallback
    public /* bridge */ /* synthetic */ FragmentActivity onGetHost() {
        return onGetHost();
    }

    @Override // androidx.fragment.app.FragmentHostCallback
    @NonNull
    public LayoutInflater onGetLayoutInflater() {
        return this.this$0.getLayoutInflater().cloneInContext(this.this$0);
    }

    @Override // androidx.fragment.app.FragmentHostCallback
    public int onGetWindowAnimations() {
        Window window = this.this$0.getWindow();
        if (window == null) {
            return 0;
        }
        return window.getAttributes().windowAnimations;
    }

    @Override // androidx.fragment.app.FragmentHostCallback, androidx.fragment.app.FragmentContainer
    public boolean onHasView() {
        Window window = this.this$0.getWindow();
        return (window == null || window.peekDecorView() == null) ? false : true;
    }

    @Override // androidx.fragment.app.FragmentHostCallback
    public boolean onHasWindowAnimations() {
        return this.this$0.getWindow() != null;
    }

    @Override // androidx.fragment.app.FragmentHostCallback
    public boolean onShouldSaveFragmentState(@NonNull Fragment fragment) {
        return !this.this$0.isFinishing();
    }

    @Override // androidx.fragment.app.FragmentHostCallback
    public boolean onShouldShowRequestPermissionRationale(@NonNull String str) {
        return ActivityCompat.shouldShowRequestPermissionRationale(this.this$0, str);
    }

    @Override // androidx.fragment.app.FragmentHostCallback
    public void onSupportInvalidateOptionsMenu() {
        this.this$0.supportInvalidateOptionsMenu();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.fragment.app.FragmentHostCallback
    public FragmentActivity onGetHost() {
        return this.this$0;
    }
}
