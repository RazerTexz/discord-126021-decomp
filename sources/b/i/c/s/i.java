package b.i.c.s;

import com.google.android.gms.tasks.Task;
import com.google.firebase.iid.FirebaseInstanceId;

/* JADX INFO: compiled from: com.google.firebase:firebase-iid@@21.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class i implements b.i.a.f.n.a {
    public final FirebaseInstanceId a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1767b;
    public final String c;

    public i(FirebaseInstanceId firebaseInstanceId, String str, String str2) {
        this.a = firebaseInstanceId;
        this.f1767b = str;
        this.c = str2;
    }

    @Override // b.i.a.f.n.a
    public final Object a(Task task) {
        return this.a.m(this.f1767b, this.c);
    }
}
