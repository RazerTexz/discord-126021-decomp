package androidx.fragment.app;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: FragmentManager.kt */
/* JADX INFO: loaded from: classes.dex */
public final class FragmentManagerKt {
    public static final void commit(FragmentManager fragmentManager, boolean z2, Function1<? super FragmentTransaction, Unit> function1) {
        C12238m.checkNotNullParameter(fragmentManager, "$this$commit");
        C12238m.checkNotNullParameter(function1, "body");
        FragmentTransaction fragmentTransactionBeginTransaction = fragmentManager.beginTransaction();
        C12238m.checkNotNullExpressionValue(fragmentTransactionBeginTransaction, "beginTransaction()");
        function1.invoke(fragmentTransactionBeginTransaction);
        if (z2) {
            fragmentTransactionBeginTransaction.commitAllowingStateLoss();
        } else {
            fragmentTransactionBeginTransaction.commit();
        }
    }

    public static /* synthetic */ void commit$default(FragmentManager fragmentManager, boolean z2, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = false;
        }
        C12238m.checkNotNullParameter(fragmentManager, "$this$commit");
        C12238m.checkNotNullParameter(function1, "body");
        FragmentTransaction fragmentTransactionBeginTransaction = fragmentManager.beginTransaction();
        C12238m.checkNotNullExpressionValue(fragmentTransactionBeginTransaction, "beginTransaction()");
        function1.invoke(fragmentTransactionBeginTransaction);
        if (z2) {
            fragmentTransactionBeginTransaction.commitAllowingStateLoss();
        } else {
            fragmentTransactionBeginTransaction.commit();
        }
    }

    public static final void commitNow(FragmentManager fragmentManager, boolean z2, Function1<? super FragmentTransaction, Unit> function1) {
        C12238m.checkNotNullParameter(fragmentManager, "$this$commitNow");
        C12238m.checkNotNullParameter(function1, "body");
        FragmentTransaction fragmentTransactionBeginTransaction = fragmentManager.beginTransaction();
        C12238m.checkNotNullExpressionValue(fragmentTransactionBeginTransaction, "beginTransaction()");
        function1.invoke(fragmentTransactionBeginTransaction);
        if (z2) {
            fragmentTransactionBeginTransaction.commitNowAllowingStateLoss();
        } else {
            fragmentTransactionBeginTransaction.commitNow();
        }
    }

    public static /* synthetic */ void commitNow$default(FragmentManager fragmentManager, boolean z2, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = false;
        }
        C12238m.checkNotNullParameter(fragmentManager, "$this$commitNow");
        C12238m.checkNotNullParameter(function1, "body");
        FragmentTransaction fragmentTransactionBeginTransaction = fragmentManager.beginTransaction();
        C12238m.checkNotNullExpressionValue(fragmentTransactionBeginTransaction, "beginTransaction()");
        function1.invoke(fragmentTransactionBeginTransaction);
        if (z2) {
            fragmentTransactionBeginTransaction.commitNowAllowingStateLoss();
        } else {
            fragmentTransactionBeginTransaction.commitNow();
        }
    }

    public static final void transaction(FragmentManager fragmentManager, boolean z2, boolean z3, Function1<? super FragmentTransaction, Unit> function1) {
        C12238m.checkNotNullParameter(fragmentManager, "$this$transaction");
        C12238m.checkNotNullParameter(function1, "body");
        FragmentTransaction fragmentTransactionBeginTransaction = fragmentManager.beginTransaction();
        C12238m.checkNotNullExpressionValue(fragmentTransactionBeginTransaction, "beginTransaction()");
        function1.invoke(fragmentTransactionBeginTransaction);
        if (z2) {
            if (z3) {
                fragmentTransactionBeginTransaction.commitNowAllowingStateLoss();
                return;
            } else {
                fragmentTransactionBeginTransaction.commitNow();
                return;
            }
        }
        if (z3) {
            fragmentTransactionBeginTransaction.commitAllowingStateLoss();
        } else {
            fragmentTransactionBeginTransaction.commit();
        }
    }

    public static /* synthetic */ void transaction$default(FragmentManager fragmentManager, boolean z2, boolean z3, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = false;
        }
        if ((i & 2) != 0) {
            z3 = false;
        }
        C12238m.checkNotNullParameter(fragmentManager, "$this$transaction");
        C12238m.checkNotNullParameter(function1, "body");
        FragmentTransaction fragmentTransactionBeginTransaction = fragmentManager.beginTransaction();
        C12238m.checkNotNullExpressionValue(fragmentTransactionBeginTransaction, "beginTransaction()");
        function1.invoke(fragmentTransactionBeginTransaction);
        if (z2) {
            if (z3) {
                fragmentTransactionBeginTransaction.commitNowAllowingStateLoss();
                return;
            } else {
                fragmentTransactionBeginTransaction.commitNow();
                return;
            }
        }
        if (z3) {
            fragmentTransactionBeginTransaction.commitAllowingStateLoss();
        } else {
            fragmentTransactionBeginTransaction.commit();
        }
    }
}
