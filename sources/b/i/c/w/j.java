package b.i.c.w;

import com.google.firebase.messaging.FirebaseMessaging$a;

/* JADX INFO: compiled from: com.google.firebase:firebase-messaging@@21.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class j implements b.i.c.q.b {
    public final FirebaseMessaging$a a;

    public j(FirebaseMessaging$a firebaseMessaging$a) {
        this.a = firebaseMessaging$a;
    }

    @Override // b.i.c.q.b
    public final void a(b.i.c.q.a aVar) {
        FirebaseMessaging$a firebaseMessaging$a = this.a;
        if (firebaseMessaging$a.b()) {
            firebaseMessaging$a.e.f.execute(new k(firebaseMessaging$a));
        }
    }
}
