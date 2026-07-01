package b.i.c.w;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessaging;

/* JADX INFO: compiled from: com.google.firebase:firebase-messaging@@21.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class g implements Runnable {
    public final FirebaseMessaging j;
    public final FirebaseInstanceId k;

    public g(FirebaseMessaging firebaseMessaging, FirebaseInstanceId firebaseInstanceId) {
        this.j = firebaseMessaging;
        this.k = firebaseInstanceId;
    }

    @Override // java.lang.Runnable
    public final void run() {
        FirebaseMessaging firebaseMessaging = this.j;
        FirebaseInstanceId firebaseInstanceId = this.k;
        if (firebaseMessaging.e.b()) {
            firebaseInstanceId.i();
        }
    }
}
