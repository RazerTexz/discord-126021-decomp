package b.a.d;

import androidx.view.ViewModelProvider$Factory;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: AppViewModelDelegates.kt */
/* JADX INFO: loaded from: classes.dex */
public final class i0 extends d0.z.d.o implements Function0<ViewModelProvider$Factory> {
    public final /* synthetic */ Function0 $viewModelProducer;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i0(Function0 function0) {
        super(0);
        this.$viewModelProducer = function0;
    }

    @Override // kotlin.jvm.functions.Function0
    public ViewModelProvider$Factory invoke() {
        return new h0(this);
    }
}
