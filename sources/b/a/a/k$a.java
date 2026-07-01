package b.a.a;

import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: DatePickerDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class k$a {
    public k$a(DefaultConstructorMarker defaultConstructorMarker) {
    }

    public final k a(FragmentManager fragmentManager, CharSequence charSequence, long j, long j2) {
        d0.z.d.m.checkNotNullParameter(fragmentManager, "fragmentManager");
        d0.z.d.m.checkNotNullParameter(charSequence, "label");
        k kVar = new k();
        Bundle bundle = new Bundle();
        bundle.putCharSequence("label", charSequence);
        bundle.putLong("initial_date", j);
        bundle.putLong("max_date", j2);
        kVar.setArguments(bundle);
        kVar.show(fragmentManager, k.class.getName());
        return kVar;
    }
}
