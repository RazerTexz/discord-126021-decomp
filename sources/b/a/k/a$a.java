package b.a.k;

import androidx.core.view.ViewCompat;
import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: Format.kt */
/* JADX INFO: loaded from: classes.dex */
public final class a$a extends o implements Function0<Integer> {
    public static final a$a j = new a$a();

    public a$a() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Integer invoke() {
        return Integer.valueOf(ViewCompat.MEASURED_STATE_MASK);
    }
}
