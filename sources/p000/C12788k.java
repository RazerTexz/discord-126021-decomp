package p000;

import androidx.view.ViewModelStore;
import androidx.view.ViewModelStoreOwner;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: k */
/* JADX INFO: compiled from: kotlin-style lambda group */
/* JADX INFO: loaded from: classes2.dex */
public final class C12788k extends AbstractC12240o implements Function0<ViewModelStore> {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ int f27423j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ Object f27424k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C12788k(int i, Object obj) {
        super(0);
        this.f27423j = i;
        this.f27424k = obj;
    }

    @Override // kotlin.jvm.functions.Function0
    public final ViewModelStore invoke() {
        int i = this.f27423j;
        if (i == 0) {
            ViewModelStore viewModelStore = ((ViewModelStoreOwner) ((Function0) this.f27424k).invoke()).getViewModelStore();
            C12238m.checkNotNullExpressionValue(viewModelStore, "ownerProducer().viewModelStore");
            return viewModelStore;
        }
        if (i == 1) {
            ViewModelStore viewModelStore2 = ((ViewModelStoreOwner) ((Function0) this.f27424k).invoke()).getViewModelStore();
            C12238m.checkNotNullExpressionValue(viewModelStore2, "ownerProducer().viewModelStore");
            return viewModelStore2;
        }
        if (i == 2) {
            ViewModelStore viewModelStore3 = ((ViewModelStoreOwner) ((Function0) this.f27424k).invoke()).getViewModelStore();
            C12238m.checkNotNullExpressionValue(viewModelStore3, "ownerProducer().viewModelStore");
            return viewModelStore3;
        }
        if (i == 3) {
            ViewModelStore viewModelStore4 = ((ViewModelStoreOwner) ((Function0) this.f27424k).invoke()).getViewModelStore();
            C12238m.checkNotNullExpressionValue(viewModelStore4, "ownerProducer().viewModelStore");
            return viewModelStore4;
        }
        if (i == 4) {
            ViewModelStore viewModelStore5 = ((ViewModelStoreOwner) ((Function0) this.f27424k).invoke()).getViewModelStore();
            C12238m.checkNotNullExpressionValue(viewModelStore5, "ownerProducer().viewModelStore");
            return viewModelStore5;
        }
        if (i != 5) {
            throw null;
        }
        ViewModelStore viewModelStore6 = ((ViewModelStoreOwner) ((Function0) this.f27424k).invoke()).getViewModelStore();
        C12238m.checkNotNullExpressionValue(viewModelStore6, "ownerProducer().viewModelStore");
        return viewModelStore6;
    }
}
