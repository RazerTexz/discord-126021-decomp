package androidx.fragment.app;

import android.os.Bundle;
import androidx.annotation.NonNull;
import d0.z.d.m;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: Fragment.kt */
/* JADX INFO: loaded from: classes.dex */
public final class FragmentKt$sam$androidx_fragment_app_FragmentResultListener$0 implements FragmentResultListener {
    private final /* synthetic */ Function2 function;

    public FragmentKt$sam$androidx_fragment_app_FragmentResultListener$0(Function2 function2) {
        this.function = function2;
    }

    @Override // androidx.fragment.app.FragmentResultListener
    public final /* synthetic */ void onFragmentResult(@NonNull String str, @NonNull Bundle bundle) {
        m.checkNotNullParameter(str, "p0");
        m.checkNotNullParameter(bundle, "p1");
        m.checkNotNullExpressionValue(this.function.invoke(str, bundle), "invoke(...)");
    }
}
