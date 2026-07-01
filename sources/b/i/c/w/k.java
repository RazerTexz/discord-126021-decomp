package b.i.c.w;

import com.google.firebase.messaging.FirebaseMessaging$a;

/* JADX INFO: compiled from: com.google.firebase:firebase-messaging@@21.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class k implements Runnable {
    public final FirebaseMessaging$a j;

    public k(FirebaseMessaging$a firebaseMessaging$a) {
        this.j = firebaseMessaging$a;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.j.e.d.i();
    }
}
