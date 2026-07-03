package androidx.fragment.app;

import android.os.Bundle;
import androidx.annotation.NonNull;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: Fragment.kt */
/* JADX INFO: loaded from: classes.dex */
public final class FragmentKt {
    public static final void clearFragmentResult(Fragment fragment, String str) {
        C12238m.checkNotNullParameter(fragment, "$this$clearFragmentResult");
        C12238m.checkNotNullParameter(str, "requestKey");
        fragment.getParentFragmentManager().clearFragmentResult(str);
    }

    public static final void clearFragmentResultListener(Fragment fragment, String str) {
        C12238m.checkNotNullParameter(fragment, "$this$clearFragmentResultListener");
        C12238m.checkNotNullParameter(str, "requestKey");
        fragment.getParentFragmentManager().clearFragmentResultListener(str);
    }

    public static final void setFragmentResult(Fragment fragment, String str, Bundle bundle) {
        C12238m.checkNotNullParameter(fragment, "$this$setFragmentResult");
        C12238m.checkNotNullParameter(str, "requestKey");
        C12238m.checkNotNullParameter(bundle, "result");
        fragment.getParentFragmentManager().setFragmentResult(str, bundle);
    }

    public static final void setFragmentResultListener(Fragment fragment, String str, final Function2<? super String, ? super Bundle, Unit> function2) {
        C12238m.checkNotNullParameter(fragment, "$this$setFragmentResultListener");
        C12238m.checkNotNullParameter(str, "requestKey");
        C12238m.checkNotNullParameter(function2, "listener");
        fragment.getParentFragmentManager().setFragmentResultListener(str, fragment, new FragmentResultListener() { // from class: androidx.fragment.app.FragmentKt$sam$androidx_fragment_app_FragmentResultListener$0
            @Override // androidx.fragment.app.FragmentResultListener
            public final /* synthetic */ void onFragmentResult(@NonNull String str2, @NonNull Bundle bundle) {
                C12238m.checkNotNullParameter(str2, "p0");
                C12238m.checkNotNullParameter(bundle, "p1");
                C12238m.checkNotNullExpressionValue(function2.invoke(str2, bundle), "invoke(...)");
            }
        });
    }
}
