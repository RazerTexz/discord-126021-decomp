package androidx.fragment.app;

import android.os.Bundle;
import androidx.annotation.IdRes;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: FragmentTransaction.kt */
/* JADX INFO: loaded from: classes.dex */
public final class FragmentTransactionKt {
    public static final /* synthetic */ <F extends Fragment> FragmentTransaction add(FragmentTransaction fragmentTransaction, @IdRes int i, String str, Bundle bundle) {
        C12238m.checkNotNullParameter(fragmentTransaction, "$this$add");
        C12238m.reifiedOperationMarker(4, "F");
        FragmentTransaction fragmentTransactionAdd = fragmentTransaction.add(i, Fragment.class, bundle, str);
        C12238m.checkNotNullExpressionValue(fragmentTransactionAdd, "add(containerViewId, F::class.java, args, tag)");
        return fragmentTransactionAdd;
    }

    public static /* synthetic */ FragmentTransaction add$default(FragmentTransaction fragmentTransaction, int i, String str, Bundle bundle, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str = null;
        }
        if ((i2 & 4) != 0) {
            bundle = null;
        }
        C12238m.checkNotNullParameter(fragmentTransaction, "$this$add");
        C12238m.reifiedOperationMarker(4, "F");
        FragmentTransaction fragmentTransactionAdd = fragmentTransaction.add(i, Fragment.class, bundle, str);
        C12238m.checkNotNullExpressionValue(fragmentTransactionAdd, "add(containerViewId, F::class.java, args, tag)");
        return fragmentTransactionAdd;
    }

    public static final /* synthetic */ <F extends Fragment> FragmentTransaction replace(FragmentTransaction fragmentTransaction, @IdRes int i, String str, Bundle bundle) {
        C12238m.checkNotNullParameter(fragmentTransaction, "$this$replace");
        C12238m.reifiedOperationMarker(4, "F");
        FragmentTransaction fragmentTransactionReplace = fragmentTransaction.replace(i, Fragment.class, bundle, str);
        C12238m.checkNotNullExpressionValue(fragmentTransactionReplace, "replace(containerViewId, F::class.java, args, tag)");
        return fragmentTransactionReplace;
    }

    public static /* synthetic */ FragmentTransaction replace$default(FragmentTransaction fragmentTransaction, int i, String str, Bundle bundle, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str = null;
        }
        if ((i2 & 4) != 0) {
            bundle = null;
        }
        C12238m.checkNotNullParameter(fragmentTransaction, "$this$replace");
        C12238m.reifiedOperationMarker(4, "F");
        FragmentTransaction fragmentTransactionReplace = fragmentTransaction.replace(i, Fragment.class, bundle, str);
        C12238m.checkNotNullExpressionValue(fragmentTransactionReplace, "replace(containerViewId, F::class.java, args, tag)");
        return fragmentTransactionReplace;
    }

    public static final /* synthetic */ <F extends Fragment> FragmentTransaction add(FragmentTransaction fragmentTransaction, String str, Bundle bundle) {
        C12238m.checkNotNullParameter(fragmentTransaction, "$this$add");
        C12238m.checkNotNullParameter(str, "tag");
        C12238m.reifiedOperationMarker(4, "F");
        FragmentTransaction fragmentTransactionAdd = fragmentTransaction.add(Fragment.class, bundle, str);
        C12238m.checkNotNullExpressionValue(fragmentTransactionAdd, "add(F::class.java, args, tag)");
        return fragmentTransactionAdd;
    }

    public static /* synthetic */ FragmentTransaction add$default(FragmentTransaction fragmentTransaction, String str, Bundle bundle, int i, Object obj) {
        if ((i & 2) != 0) {
            bundle = null;
        }
        C12238m.checkNotNullParameter(fragmentTransaction, "$this$add");
        C12238m.checkNotNullParameter(str, "tag");
        C12238m.reifiedOperationMarker(4, "F");
        FragmentTransaction fragmentTransactionAdd = fragmentTransaction.add(Fragment.class, bundle, str);
        C12238m.checkNotNullExpressionValue(fragmentTransactionAdd, "add(F::class.java, args, tag)");
        return fragmentTransactionAdd;
    }
}
