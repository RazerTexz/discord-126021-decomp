package b.a.a.d;

import d0.z.d.k;
import d0.z.d.m;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: UserActionsDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a$g extends k implements Function1<f$b, Unit> {
    public a$g(a aVar) {
        super(1, aVar, a.class, "handleEvent", "handleEvent(Lcom/discord/dialogs/useractions/UserActionsDialogViewModel$Event;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(f$b f_b) {
        f$b f_b2 = f_b;
        m.checkNotNullParameter(f_b2, "p1");
        a aVar = (a) this.receiver;
        KProperty[] kPropertyArr = a.j;
        Objects.requireNonNull(aVar);
        if (f_b2 instanceof f$b$b) {
            b.a.d.m.i(aVar, ((f$b$b) f_b2).a, 0, 4);
            aVar.dismiss();
        } else if (f_b2 instanceof f$b$a) {
            b.a.d.m.i(aVar, ((f$b$a) f_b2).a, 0, 4);
            aVar.dismiss();
        }
        return Unit.a;
    }
}
