package androidx.activity;

import androidx.view.ViewModelProvider;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: compiled from: ActivityViewModelLazy.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ActivityViewModelLazyKt$viewModels$factoryPromise$1 extends AbstractC12240o implements Function0<ViewModelProvider.Factory> {
    public final /* synthetic */ ComponentActivity $this_viewModels;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ActivityViewModelLazyKt$viewModels$factoryPromise$1(ComponentActivity componentActivity) {
        super(0);
        this.$this_viewModels = componentActivity;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ViewModelProvider.Factory invoke() {
        return this.$this_viewModels.getDefaultViewModelProviderFactory();
    }
}
