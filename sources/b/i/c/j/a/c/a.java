package b.i.c.j.a.c;

import android.content.Context;
import android.os.Bundle;
import b.i.a.f.h.l.g;
import b.i.c.DataCollectionDefaultChange;
import b.i.c.FirebaseApp2;
import b.i.c.l.ComponentContainer;
import b.i.c.l.ComponentFactory;
import b.i.c.q.Subscriber2;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-api@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class a implements ComponentFactory {
    public static final ComponentFactory a = new a();

    @Override // b.i.c.l.ComponentFactory
    public final Object a(ComponentContainer componentContainer) {
        FirebaseApp2 firebaseApp2 = (FirebaseApp2) componentContainer.a(FirebaseApp2.class);
        Context context = (Context) componentContainer.a(Context.class);
        Subscriber2 subscriber2 = (Subscriber2) componentContainer.a(Subscriber2.class);
        Objects.requireNonNull(firebaseApp2, "null reference");
        Objects.requireNonNull(context, "null reference");
        Objects.requireNonNull(subscriber2, "null reference");
        Objects.requireNonNull(context.getApplicationContext(), "null reference");
        if (b.i.c.j.a.b.a == null) {
            synchronized (b.i.c.j.a.b.class) {
                if (b.i.c.j.a.b.a == null) {
                    Bundle bundle = new Bundle(1);
                    if (firebaseApp2.h()) {
                        subscriber2.b(DataCollectionDefaultChange.class, b.i.c.j.a.e.j, b.i.c.j.a.d.a);
                        bundle.putBoolean("dataCollectionDefaultEnabled", firebaseApp2.g());
                    }
                    b.i.c.j.a.b.a = new b.i.c.j.a.b(g.a(context, null, null, null, bundle).f);
                }
            }
        }
        return b.i.c.j.a.b.a;
    }
}
