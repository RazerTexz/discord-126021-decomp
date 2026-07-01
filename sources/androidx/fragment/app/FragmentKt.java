package androidx.fragment.app;

import android.os.Bundle;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: Fragment.kt */
/* JADX INFO: loaded from: classes.dex */
public final class FragmentKt {
    public static final void clearFragmentResult(Fragment fragment, String str) {
        m.checkNotNullParameter(fragment, "$this$clearFragmentResult");
        m.checkNotNullParameter(str, "requestKey");
        fragment.getParentFragmentManager().clearFragmentResult(str);
    }

    public static final void clearFragmentResultListener(Fragment fragment, String str) {
        m.checkNotNullParameter(fragment, "$this$clearFragmentResultListener");
        m.checkNotNullParameter(str, "requestKey");
        fragment.getParentFragmentManager().clearFragmentResultListener(str);
    }

    public static final void setFragmentResult(Fragment fragment, String str, Bundle bundle) {
        m.checkNotNullParameter(fragment, "$this$setFragmentResult");
        m.checkNotNullParameter(str, "requestKey");
        m.checkNotNullParameter(bundle, "result");
        fragment.getParentFragmentManager().setFragmentResult(str, bundle);
    }

    public static final void setFragmentResultListener(Fragment fragment, String str, Function2<? super String, ? super Bundle, Unit> function2) {
        m.checkNotNullParameter(fragment, "$this$setFragmentResultListener");
        m.checkNotNullParameter(str, "requestKey");
        m.checkNotNullParameter(function2, "listener");
        fragment.getParentFragmentManager().setFragmentResultListener(str, fragment, new FragmentKt$sam$androidx_fragment_app_FragmentResultListener$0(function2));
    }
}
