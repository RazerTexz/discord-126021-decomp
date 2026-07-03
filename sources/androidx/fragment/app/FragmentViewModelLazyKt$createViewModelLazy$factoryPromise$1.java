package androidx.fragment.app;

import androidx.view.ViewModelProvider;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: compiled from: FragmentViewModelLazy.kt */
/* JADX INFO: loaded from: classes.dex */
public final class FragmentViewModelLazyKt$createViewModelLazy$factoryPromise$1 extends AbstractC12240o implements Function0<ViewModelProvider.Factory> {
    public final /* synthetic */ Fragment $this_createViewModelLazy;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FragmentViewModelLazyKt$createViewModelLazy$factoryPromise$1(Fragment fragment) {
        super(0);
        this.$this_createViewModelLazy = fragment;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ViewModelProvider.Factory invoke() {
        return this.$this_createViewModelLazy.getDefaultViewModelProviderFactory();
    }
}
