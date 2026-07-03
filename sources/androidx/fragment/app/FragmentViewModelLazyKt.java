package androidx.fragment.app;

import androidx.annotation.MainThread;
import androidx.view.ViewModel;
import androidx.view.ViewModelLazy;
import androidx.view.ViewModelProvider;
import androidx.view.ViewModelStore;
import androidx.view.ViewModelStoreOwner;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p513e0.InterfaceC11230c;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: FragmentViewModelLazy.kt */
/* JADX INFO: loaded from: classes.dex */
public final class FragmentViewModelLazyKt {

    /* JADX INFO: renamed from: androidx.fragment.app.FragmentViewModelLazyKt$activityViewModels$1 */
    /* JADX INFO: compiled from: FragmentViewModelLazy.kt */
    public static final class C04091 extends AbstractC12240o implements Function0<ViewModelStore> {
        public final /* synthetic */ Fragment $this_activityViewModels;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C04091(Fragment fragment) {
            super(0);
            this.$this_activityViewModels = fragment;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ViewModelStore invoke() {
            return C1643a.m870p0(this.$this_activityViewModels, "requireActivity()", "requireActivity().viewModelStore");
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.FragmentViewModelLazyKt$activityViewModels$2 */
    /* JADX INFO: compiled from: FragmentViewModelLazy.kt */
    public static final class C04102 extends AbstractC12240o implements Function0<ViewModelProvider.Factory> {
        public final /* synthetic */ Fragment $this_activityViewModels;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C04102(Fragment fragment) {
            super(0);
            this.$this_activityViewModels = fragment;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ViewModelProvider.Factory invoke() {
            return C1643a.m848e0(this.$this_activityViewModels, "requireActivity()");
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.FragmentViewModelLazyKt$viewModels$1 */
    /* JADX INFO: compiled from: FragmentViewModelLazy.kt */
    public static final class C04111 extends AbstractC12240o implements Function0<Fragment> {
        public final /* synthetic */ Fragment $this_viewModels;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C04111(Fragment fragment) {
            super(0);
            this.$this_viewModels = fragment;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Fragment invoke() {
            return this.$this_viewModels;
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.FragmentViewModelLazyKt$viewModels$2 */
    /* JADX INFO: compiled from: FragmentViewModelLazy.kt */
    public static final class C04122 extends AbstractC12240o implements Function0<ViewModelStore> {
        public final /* synthetic */ Function0 $ownerProducer;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C04122(Function0 function0) {
            super(0);
            this.$ownerProducer = function0;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ViewModelStore invoke() {
            ViewModelStore viewModelStore = ((ViewModelStoreOwner) this.$ownerProducer.invoke()).getViewModelStore();
            C12238m.checkNotNullExpressionValue(viewModelStore, "ownerProducer().viewModelStore");
            return viewModelStore;
        }
    }

    @MainThread
    public static final /* synthetic */ <VM extends ViewModel> Lazy<VM> activityViewModels(Fragment fragment, Function0<? extends ViewModelProvider.Factory> function0) {
        C12238m.checkNotNullParameter(fragment, "$this$activityViewModels");
        C12238m.reifiedOperationMarker(4, "VM");
        InterfaceC11230c orCreateKotlinClass = C12216a0.getOrCreateKotlinClass(ViewModel.class);
        C04091 c04091 = new C04091(fragment);
        if (function0 == null) {
            function0 = new C04102(fragment);
        }
        return createViewModelLazy(fragment, orCreateKotlinClass, c04091, function0);
    }

    public static /* synthetic */ Lazy activityViewModels$default(Fragment fragment, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            function0 = null;
        }
        C12238m.checkNotNullParameter(fragment, "$this$activityViewModels");
        C12238m.reifiedOperationMarker(4, "VM");
        InterfaceC11230c orCreateKotlinClass = C12216a0.getOrCreateKotlinClass(ViewModel.class);
        C04091 c04091 = new C04091(fragment);
        if (function0 == null) {
            function0 = new C04102(fragment);
        }
        return createViewModelLazy(fragment, orCreateKotlinClass, c04091, function0);
    }

    @MainThread
    public static final <VM extends ViewModel> Lazy<VM> createViewModelLazy(Fragment fragment, InterfaceC11230c<VM> interfaceC11230c, Function0<? extends ViewModelStore> function0, Function0<? extends ViewModelProvider.Factory> function1) {
        C12238m.checkNotNullParameter(fragment, "$this$createViewModelLazy");
        C12238m.checkNotNullParameter(interfaceC11230c, "viewModelClass");
        C12238m.checkNotNullParameter(function0, "storeProducer");
        if (function1 == null) {
            function1 = new FragmentViewModelLazyKt$createViewModelLazy$factoryPromise$1(fragment);
        }
        return new ViewModelLazy(interfaceC11230c, function0, function1);
    }

    public static /* synthetic */ Lazy createViewModelLazy$default(Fragment fragment, InterfaceC11230c interfaceC11230c, Function0 function0, Function0 function1, int i, Object obj) {
        if ((i & 4) != 0) {
            function1 = null;
        }
        return createViewModelLazy(fragment, interfaceC11230c, function0, function1);
    }

    @MainThread
    public static final /* synthetic */ <VM extends ViewModel> Lazy<VM> viewModels(Fragment fragment, Function0<? extends ViewModelStoreOwner> function0, Function0<? extends ViewModelProvider.Factory> function1) {
        C12238m.checkNotNullParameter(fragment, "$this$viewModels");
        C12238m.checkNotNullParameter(function0, "ownerProducer");
        C12238m.reifiedOperationMarker(4, "VM");
        return createViewModelLazy(fragment, C12216a0.getOrCreateKotlinClass(ViewModel.class), new C04122(function0), function1);
    }

    public static /* synthetic */ Lazy viewModels$default(Fragment fragment, Function0 function0, Function0 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            function0 = new C04111(fragment);
        }
        if ((i & 2) != 0) {
            function1 = null;
        }
        C12238m.checkNotNullParameter(fragment, "$this$viewModels");
        C12238m.checkNotNullParameter(function0, "ownerProducer");
        C12238m.reifiedOperationMarker(4, "VM");
        return createViewModelLazy(fragment, C12216a0.getOrCreateKotlinClass(ViewModel.class), new C04122(function0), function1);
    }
}
