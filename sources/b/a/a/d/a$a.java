package b.a.a.d;

import android.content.Context;
import android.view.View;
import android.view.View$OnClickListener;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: java-style lambda group */
/* JADX INFO: loaded from: classes.dex */
public final class a$a implements View$OnClickListener {
    public final /* synthetic */ int j;
    public final /* synthetic */ Object k;

    public a$a(int i, Object obj) {
        this.j = i;
        this.k = obj;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        int i = this.j;
        if (i == 0) {
            a aVar = (a) this.k;
            KProperty[] kPropertyArr = a.j;
            f fVarH = aVar.h();
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.addRelationship$default(fVarH.m, "User Profile", fVarH.l, 2, null, null, 24, null), false, 1, null), fVarH, null, 2, null), f.class, (Context) null, (Function1) null, new h(fVarH), (Function0) null, (Function0) null, new g(fVarH), 54, (Object) null);
            return;
        }
        if (i == 1) {
            a aVar2 = (a) this.k;
            KProperty[] kPropertyArr2 = a.j;
            aVar2.h().removeRelationship(2131896768);
        } else {
            if (i != 2) {
                throw null;
            }
            a aVar3 = (a) this.k;
            KProperty[] kPropertyArr3 = a.j;
            aVar3.h().removeRelationship(2131889442);
        }
    }
}
