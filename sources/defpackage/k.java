package defpackage;

import androidx.view.ViewModelStore;
import androidx.view.ViewModelStoreOwner;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: kotlin-style lambda group */
/* JADX INFO: loaded from: classes2.dex */
public final class k extends Lambda implements Function0<ViewModelStore> {
    public final /* synthetic */ int j;
    public final /* synthetic */ Object k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(int i, Object obj) {
        super(0);
        this.j = i;
        this.k = obj;
    }

    @Override // kotlin.jvm.functions.Function0
    public final ViewModelStore invoke() {
        int i = this.j;
        if (i == 0) {
            ViewModelStore viewModelStore = ((ViewModelStoreOwner) ((Function0) this.k).invoke()).getViewModelStore();
            Intrinsics3.checkNotNullExpressionValue(viewModelStore, "ownerProducer().viewModelStore");
            return viewModelStore;
        }
        if (i == 1) {
            ViewModelStore viewModelStore2 = ((ViewModelStoreOwner) ((Function0) this.k).invoke()).getViewModelStore();
            Intrinsics3.checkNotNullExpressionValue(viewModelStore2, "ownerProducer().viewModelStore");
            return viewModelStore2;
        }
        if (i == 2) {
            ViewModelStore viewModelStore3 = ((ViewModelStoreOwner) ((Function0) this.k).invoke()).getViewModelStore();
            Intrinsics3.checkNotNullExpressionValue(viewModelStore3, "ownerProducer().viewModelStore");
            return viewModelStore3;
        }
        if (i == 3) {
            ViewModelStore viewModelStore4 = ((ViewModelStoreOwner) ((Function0) this.k).invoke()).getViewModelStore();
            Intrinsics3.checkNotNullExpressionValue(viewModelStore4, "ownerProducer().viewModelStore");
            return viewModelStore4;
        }
        if (i == 4) {
            ViewModelStore viewModelStore5 = ((ViewModelStoreOwner) ((Function0) this.k).invoke()).getViewModelStore();
            Intrinsics3.checkNotNullExpressionValue(viewModelStore5, "ownerProducer().viewModelStore");
            return viewModelStore5;
        }
        if (i != 5) {
            throw null;
        }
        ViewModelStore viewModelStore6 = ((ViewModelStoreOwner) ((Function0) this.k).invoke()).getViewModelStore();
        Intrinsics3.checkNotNullExpressionValue(viewModelStore6, "ownerProducer().viewModelStore");
        return viewModelStore6;
    }
}
