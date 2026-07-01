package b.i.c.w;

import com.google.firebase.messaging.FirebaseMessaging;

/* JADX INFO: compiled from: com.google.firebase:firebase-messaging@@21.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class h implements b.i.a.f.n.e {
    public final FirebaseMessaging a;

    public h(FirebaseMessaging firebaseMessaging) {
        this.a = firebaseMessaging;
    }

    @Override // b.i.a.f.n.e
    public final void onSuccess(Object obj) {
        boolean z2;
        y yVar = (y) obj;
        if (this.a.e.b()) {
            if (yVar.j.a() != null) {
                synchronized (yVar) {
                    z2 = yVar.i;
                }
                if (z2) {
                    return;
                }
                yVar.g(0L);
            }
        }
    }
}
