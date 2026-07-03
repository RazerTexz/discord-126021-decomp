package androidx.activity;

import androidx.annotation.MainThread;
import androidx.view.ViewModel;
import androidx.view.ViewModelLazy;
import androidx.view.ViewModelProvider;
import androidx.view.ViewModelStore;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: ActivityViewModelLazy.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ActivityViewModelLazyKt {

    /* JADX INFO: renamed from: androidx.activity.ActivityViewModelLazyKt$viewModels$1 */
    /* JADX INFO: compiled from: ActivityViewModelLazy.kt */
    public static final class C00321 extends AbstractC12240o implements Function0<ViewModelStore> {
        public final /* synthetic */ ComponentActivity $this_viewModels;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C00321(ComponentActivity componentActivity) {
            super(0);
            this.$this_viewModels = componentActivity;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ViewModelStore invoke() {
            ViewModelStore viewModelStore = this.$this_viewModels.getViewModelStore();
            C12238m.checkNotNullExpressionValue(viewModelStore, "viewModelStore");
            return viewModelStore;
        }
    }

    @MainThread
    public static final /* synthetic */ <VM extends ViewModel> Lazy<VM> viewModels(ComponentActivity componentActivity, Function0<? extends ViewModelProvider.Factory> function0) {
        C12238m.checkNotNullParameter(componentActivity, "$this$viewModels");
        if (function0 == null) {
            function0 = new ActivityViewModelLazyKt$viewModels$factoryPromise$1(componentActivity);
        }
        C12238m.reifiedOperationMarker(4, "VM");
        return new ViewModelLazy(C12216a0.getOrCreateKotlinClass(ViewModel.class), new C00321(componentActivity), function0);
    }

    public static /* synthetic */ Lazy viewModels$default(ComponentActivity componentActivity, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            function0 = null;
        }
        C12238m.checkNotNullParameter(componentActivity, "$this$viewModels");
        if (function0 == null) {
            function0 = new ActivityViewModelLazyKt$viewModels$factoryPromise$1(componentActivity);
        }
        C12238m.reifiedOperationMarker(4, "VM");
        return new ViewModelLazy(C12216a0.getOrCreateKotlinClass(ViewModel.class), new C00321(componentActivity), function0);
    }
}
