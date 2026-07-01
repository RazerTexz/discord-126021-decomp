package b.a.a;

import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import d0.z.d.a0;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: SelectorDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class n$a {
    public n$a(DefaultConstructorMarker defaultConstructorMarker) {
    }

    public final n a(FragmentManager fragmentManager, CharSequence charSequence, CharSequence[] charSequenceArr, Function1<? super Integer, Unit> function1) {
        d0.z.d.m.checkNotNullParameter(fragmentManager, "fragmentManager");
        d0.z.d.m.checkNotNullParameter(charSequence, "title");
        d0.z.d.m.checkNotNullParameter(charSequenceArr, "options");
        d0.z.d.m.checkNotNullParameter(function1, "onSelectedListener");
        n nVar = new n();
        Bundle bundle = new Bundle();
        bundle.putCharSequence("INTENT_DIALOG_TITLE", charSequence);
        bundle.putCharSequenceArray("INTENT_DIALOG_OPTIONS", charSequenceArr);
        nVar.setArguments(bundle);
        nVar.onSelectedListener = function1;
        nVar.show(fragmentManager, a0.getOrCreateKotlinClass(n.class).toString());
        return nVar;
    }
}
