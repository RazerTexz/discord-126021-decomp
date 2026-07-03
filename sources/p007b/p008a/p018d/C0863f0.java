package p007b.p008a.p018d;

import androidx.view.ViewModelProvider;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: renamed from: b.a.d.f0 */
/* JADX INFO: compiled from: AppViewModelDelegates.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C0863f0 extends AbstractC12240o implements Function0<ViewModelProvider.Factory> {
    public final /* synthetic */ Function0 $viewModelProducer;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0863f0(Function0 function0) {
        super(0);
        this.$viewModelProducer = function0;
    }

    @Override // kotlin.jvm.functions.Function0
    public ViewModelProvider.Factory invoke() {
        return new C0861e0(this);
    }
}
