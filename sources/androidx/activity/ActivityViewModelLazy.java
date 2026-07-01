package androidx.activity;

import androidx.annotation.MainThread;
import androidx.view.ViewModel;
import androidx.view.ViewModelProvider;
import androidx.view.ViewModelProvider2;
import androidx.view.ViewModelStore;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: androidx.activity.ActivityViewModelLazyKt, reason: use source file name */
/* JADX INFO: compiled from: ActivityViewModelLazy.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ActivityViewModelLazy {

    /* JADX INFO: renamed from: androidx.activity.ActivityViewModelLazyKt$viewModels$1, reason: invalid class name */
    /* JADX INFO: compiled from: ActivityViewModelLazy.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<ViewModelStore> {
        public final /* synthetic */ ComponentActivity $this_viewModels;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ComponentActivity componentActivity) {
            super(0);
            this.$this_viewModels = componentActivity;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ViewModelStore invoke() {
            ViewModelStore viewModelStore = this.$this_viewModels.getViewModelStore();
            Intrinsics3.checkNotNullExpressionValue(viewModelStore, "viewModelStore");
            return viewModelStore;
        }
    }

    @MainThread
    public static final /* synthetic */ <VM extends ViewModel> Lazy<VM> viewModels(ComponentActivity componentActivity, Function0<? extends ViewModelProvider.Factory> function0) {
        Intrinsics3.checkNotNullParameter(componentActivity, "$this$viewModels");
        if (function0 == null) {
            function0 = new ActivityViewModelLazy2(componentActivity);
        }
        Intrinsics3.reifiedOperationMarker(4, "VM");
        return new ViewModelProvider2(Reflection2.getOrCreateKotlinClass(ViewModel.class), new AnonymousClass1(componentActivity), function0);
    }

    public static /* synthetic */ Lazy viewModels$default(ComponentActivity componentActivity, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            function0 = null;
        }
        Intrinsics3.checkNotNullParameter(componentActivity, "$this$viewModels");
        if (function0 == null) {
            function0 = new ActivityViewModelLazy2(componentActivity);
        }
        Intrinsics3.reifiedOperationMarker(4, "VM");
        return new ViewModelProvider2(Reflection2.getOrCreateKotlinClass(ViewModel.class), new AnonymousClass1(componentActivity), function0);
    }
}
