package androidx.fragment.app;

import androidx.annotation.MainThread;
import androidx.view.ViewModel;
import androidx.view.ViewModelLazy;
import androidx.view.ViewModelProvider$Factory;
import androidx.view.ViewModelStore;
import androidx.view.ViewModelStoreOwner;
import d0.e0.c;
import d0.z.d.a0;
import d0.z.d.m;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: FragmentViewModelLazy.kt */
/* JADX INFO: loaded from: classes.dex */
public final class FragmentViewModelLazyKt {
    @MainThread
    public static final /* synthetic */ <VM extends ViewModel> Lazy<VM> activityViewModels(Fragment fragment, Function0<? extends ViewModelProvider$Factory> function0) {
        m.checkNotNullParameter(fragment, "$this$activityViewModels");
        m.reifiedOperationMarker(4, "VM");
        c orCreateKotlinClass = a0.getOrCreateKotlinClass(ViewModel.class);
        FragmentViewModelLazyKt$activityViewModels$1 fragmentViewModelLazyKt$activityViewModels$1 = new FragmentViewModelLazyKt$activityViewModels$1(fragment);
        if (function0 == null) {
            function0 = new FragmentViewModelLazyKt$activityViewModels$2(fragment);
        }
        return createViewModelLazy(fragment, orCreateKotlinClass, fragmentViewModelLazyKt$activityViewModels$1, function0);
    }

    public static /* synthetic */ Lazy activityViewModels$default(Fragment fragment, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            function0 = null;
        }
        m.checkNotNullParameter(fragment, "$this$activityViewModels");
        m.reifiedOperationMarker(4, "VM");
        c orCreateKotlinClass = a0.getOrCreateKotlinClass(ViewModel.class);
        FragmentViewModelLazyKt$activityViewModels$1 fragmentViewModelLazyKt$activityViewModels$1 = new FragmentViewModelLazyKt$activityViewModels$1(fragment);
        if (function0 == null) {
            function0 = new FragmentViewModelLazyKt$activityViewModels$2(fragment);
        }
        return createViewModelLazy(fragment, orCreateKotlinClass, fragmentViewModelLazyKt$activityViewModels$1, function0);
    }

    @MainThread
    public static final <VM extends ViewModel> Lazy<VM> createViewModelLazy(Fragment fragment, c<VM> cVar, Function0<? extends ViewModelStore> function0, Function0<? extends ViewModelProvider$Factory> function1) {
        m.checkNotNullParameter(fragment, "$this$createViewModelLazy");
        m.checkNotNullParameter(cVar, "viewModelClass");
        m.checkNotNullParameter(function0, "storeProducer");
        if (function1 == null) {
            function1 = new FragmentViewModelLazyKt$createViewModelLazy$factoryPromise$1(fragment);
        }
        return new ViewModelLazy(cVar, function0, function1);
    }

    public static /* synthetic */ Lazy createViewModelLazy$default(Fragment fragment, c cVar, Function0 function0, Function0 function1, int i, Object obj) {
        if ((i & 4) != 0) {
            function1 = null;
        }
        return createViewModelLazy(fragment, cVar, function0, function1);
    }

    @MainThread
    public static final /* synthetic */ <VM extends ViewModel> Lazy<VM> viewModels(Fragment fragment, Function0<? extends ViewModelStoreOwner> function0, Function0<? extends ViewModelProvider$Factory> function1) {
        m.checkNotNullParameter(fragment, "$this$viewModels");
        m.checkNotNullParameter(function0, "ownerProducer");
        m.reifiedOperationMarker(4, "VM");
        return createViewModelLazy(fragment, a0.getOrCreateKotlinClass(ViewModel.class), new FragmentViewModelLazyKt$viewModels$2(function0), function1);
    }

    public static /* synthetic */ Lazy viewModels$default(Fragment fragment, Function0 function0, Function0 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            function0 = new FragmentViewModelLazyKt$viewModels$1(fragment);
        }
        if ((i & 2) != 0) {
            function1 = null;
        }
        m.checkNotNullParameter(fragment, "$this$viewModels");
        m.checkNotNullParameter(function0, "ownerProducer");
        m.reifiedOperationMarker(4, "VM");
        return createViewModelLazy(fragment, a0.getOrCreateKotlinClass(ViewModel.class), new FragmentViewModelLazyKt$viewModels$2(function0), function1);
    }
}
