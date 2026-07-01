package b.i.c.u;

import b.i.c.u.o.c$a;
import com.google.firebase.installations.FirebaseInstallationsException;
import com.google.firebase.installations.FirebaseInstallationsException$a;
import java.io.IOException;
import java.util.Objects;

/* JADX INFO: compiled from: FirebaseInstallations.java */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class e implements Runnable {
    public final f j;
    public final boolean k;

    public e(f fVar, boolean z2) {
        this.j = fVar;
        this.k = z2;
    }

    @Override // java.lang.Runnable
    public void run() {
        b.i.c.u.o.d dVarB;
        b.i.c.u.o.d dVarJ;
        f fVar = this.j;
        boolean z2 = this.k;
        Object obj = f.a;
        Objects.requireNonNull(fVar);
        Object obj2 = f.a;
        synchronized (obj2) {
            b.i.c.c cVar = fVar.c;
            cVar.a();
            b bVarA = b.a(cVar.d, "generatefid.lock");
            try {
                dVarB = fVar.e.b();
                if (bVarA != null) {
                    bVarA.b();
                }
            } catch (Throwable th) {
                if (bVarA != null) {
                    bVarA.b();
                }
                throw th;
            }
        }
        try {
            if (dVarB.h()) {
                dVarJ = fVar.j(dVarB);
            } else {
                if (dVarB.f() == c$a.UNREGISTERED) {
                    dVarJ = fVar.j(dVarB);
                } else if (!z2 && !fVar.f.d(dVarB)) {
                    return;
                } else {
                    dVarJ = fVar.c(dVarB);
                }
            }
            synchronized (obj2) {
                b.i.c.c cVar2 = fVar.c;
                cVar2.a();
                b bVarA2 = b.a(cVar2.d, "generatefid.lock");
                try {
                    fVar.e.a(dVarJ);
                    if (bVarA2 != null) {
                        bVarA2.b();
                    }
                } catch (Throwable th2) {
                    if (bVarA2 != null) {
                        bVarA2.b();
                    }
                    throw th2;
                }
            }
            if (dVarJ.j()) {
                String str = ((b.i.c.u.o.a) dVarJ).f1784b;
                synchronized (fVar) {
                    fVar.l = str;
                }
            }
            if (dVarJ.h()) {
                fVar.k(new FirebaseInstallationsException(FirebaseInstallationsException$a.BAD_CONFIG));
            } else if (dVarJ.i()) {
                fVar.k(new IOException("Installation ID could not be validated with the Firebase servers (maybe it was deleted). Firebase Installations will need to create a new Installation ID and auth token. Please retry your last request."));
            } else {
                fVar.l(dVarJ);
            }
        } catch (FirebaseInstallationsException e) {
            fVar.k(e);
        }
    }
}
