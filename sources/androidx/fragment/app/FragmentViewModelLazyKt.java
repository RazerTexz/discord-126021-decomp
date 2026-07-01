package androidx.fragment.app;

import androidx.annotation.MainThread;
import androidx.view.ViewModel;
import androidx.view.ViewModelProvider;
import androidx.view.ViewModelProvider2;
import androidx.view.ViewModelStore;
import androidx.view.ViewModelStoreOwner;
import b.d.b.a.outline;
import d0.e0.KClass;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: FragmentViewModelLazy.kt */
/* JADX INFO: loaded from: classes.dex */
public final class FragmentViewModelLazyKt {

    /* JADX INFO: renamed from: androidx.fragment.app.FragmentViewModelLazyKt$activityViewModels$1, reason: invalid class name */
    /* JADX INFO: compiled from: FragmentViewModelLazy.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<ViewModelStore> {
        public final /* synthetic */ Fragment $this_activityViewModels;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Fragment fragment) {
            super(0);
            this.$this_activityViewModels = fragment;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ViewModelStore invoke() {
            return outline.p0(this.$this_activityViewModels, "requireActivity()", "requireActivity().viewModelStore");
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.FragmentViewModelLazyKt$activityViewModels$2, reason: invalid class name */
    /* JADX INFO: compiled from: FragmentViewModelLazy.kt */
    public static final class AnonymousClass2 extends Lambda implements Function0<ViewModelProvider.Factory> {
        public final /* synthetic */ Fragment $this_activityViewModels;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Fragment fragment) {
            super(0);
            this.$this_activityViewModels = fragment;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ViewModelProvider.Factory invoke() {
            return outline.e0(this.$this_activityViewModels, "requireActivity()");
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.FragmentViewModelLazyKt$viewModels$1, reason: invalid class name */
    /* JADX INFO: compiled from: FragmentViewModelLazy.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Fragment> {
        public final /* synthetic */ Fragment $this_viewModels;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Fragment fragment) {
            super(0);
            this.$this_viewModels = fragment;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Fragment invoke() {
            return this.$this_viewModels;
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.FragmentViewModelLazyKt$viewModels$2, reason: invalid class name */
    /* JADX INFO: compiled from: FragmentViewModelLazy.kt */
    public static final class AnonymousClass2 extends Lambda implements Function0<ViewModelStore> {
        public final /* synthetic */ Function0 $ownerProducer;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Function0 function0) {
            super(0);
            this.$ownerProducer = function0;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ViewModelStore invoke() {
            ViewModelStore viewModelStore = ((ViewModelStoreOwner) this.$ownerProducer.invoke()).getViewModelStore();
            Intrinsics3.checkNotNullExpressionValue(viewModelStore, "ownerProducer().viewModelStore");
            return viewModelStore;
        }
    }

    @MainThread
    public static final /* synthetic */ <VM extends ViewModel> Lazy<VM> activityViewModels(Fragment fragment, Function0<? extends ViewModelProvider.Factory> function0) {
        Intrinsics3.checkNotNullParameter(fragment, "$this$activityViewModels");
        Intrinsics3.reifiedOperationMarker(4, "VM");
        KClass orCreateKotlinClass = Reflection2.getOrCreateKotlinClass(ViewModel.class);
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(fragment);
        if (function0 == null) {
            function0 = new AnonymousClass2(fragment);
        }
        return createViewModelLazy(fragment, orCreateKotlinClass, anonymousClass1, function0);
    }

    public static /* synthetic */ Lazy activityViewModels$default(Fragment fragment, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            function0 = null;
        }
        Intrinsics3.checkNotNullParameter(fragment, "$this$activityViewModels");
        Intrinsics3.reifiedOperationMarker(4, "VM");
        KClass orCreateKotlinClass = Reflection2.getOrCreateKotlinClass(ViewModel.class);
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(fragment);
        if (function0 == null) {
            function0 = new AnonymousClass2(fragment);
        }
        return createViewModelLazy(fragment, orCreateKotlinClass, anonymousClass1, function0);
    }

    @MainThread
    public static final <VM extends ViewModel> Lazy<VM> createViewModelLazy(Fragment fragment, KClass<VM> kClass, Function0<? extends ViewModelStore> function0, Function0<? extends ViewModelProvider.Factory> function1) {
        Intrinsics3.checkNotNullParameter(fragment, "$this$createViewModelLazy");
        Intrinsics3.checkNotNullParameter(kClass, "viewModelClass");
        Intrinsics3.checkNotNullParameter(function0, "storeProducer");
        if (function1 == null) {
            function1 = new FragmentViewModelLazyKt$createViewModelLazy$factoryPromise$1(fragment);
        }
        return new ViewModelProvider2(kClass, function0, function1);
    }

    public static /* synthetic */ Lazy createViewModelLazy$default(Fragment fragment, KClass kClass, Function0 function0, Function0 function1, int i, Object obj) {
        if ((i & 4) != 0) {
            function1 = null;
        }
        return createViewModelLazy(fragment, kClass, function0, function1);
    }

    @MainThread
    public static final /* synthetic */ <VM extends ViewModel> Lazy<VM> viewModels(Fragment fragment, Function0<? extends ViewModelStoreOwner> function0, Function0<? extends ViewModelProvider.Factory> function1) {
        Intrinsics3.checkNotNullParameter(fragment, "$this$viewModels");
        Intrinsics3.checkNotNullParameter(function0, "ownerProducer");
        Intrinsics3.reifiedOperationMarker(4, "VM");
        return createViewModelLazy(fragment, Reflection2.getOrCreateKotlinClass(ViewModel.class), new AnonymousClass2(function0), function1);
    }

    public static /* synthetic */ Lazy viewModels$default(Fragment fragment, Function0 function0, Function0 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            function0 = new AnonymousClass1(fragment);
        }
        if ((i & 2) != 0) {
            function1 = null;
        }
        Intrinsics3.checkNotNullParameter(fragment, "$this$viewModels");
        Intrinsics3.checkNotNullParameter(function0, "ownerProducer");
        Intrinsics3.reifiedOperationMarker(4, "VM");
        return createViewModelLazy(fragment, Reflection2.getOrCreateKotlinClass(ViewModel.class), new AnonymousClass2(function0), function1);
    }
}
