package b.i.a.f.j.b.e;

import android.os.RemoteException;
import com.google.android.gms.nearby.messages.Message;
import com.google.android.gms.nearby.messages.PublishOptions;
import com.google.android.gms.nearby.messages.internal.zzaf;
import com.google.android.gms.nearby.messages.internal.zzbz;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class j implements a0 {
    public final i a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Message f1584b;
    public final b0 c;
    public final PublishOptions d;

    public j(i iVar, Message message, b0 b0Var, PublishOptions publishOptions) {
        this.a = iVar;
        this.f1584b = message;
        this.c = b0Var;
        this.d = publishOptions;
    }

    @Override // b.i.a.f.j.b.e.a0
    public final void a(f fVar, b.i.a.f.e.h.j.k kVar) throws RemoteException {
        i iVar = this.a;
        Message message = this.f1584b;
        b0 b0Var = this.c;
        PublishOptions publishOptions = this.d;
        Objects.requireNonNull(iVar);
        zzaf zzafVar = new zzaf(1, message);
        int i = iVar.m;
        Objects.requireNonNull(fVar);
        ((u0) fVar.w()).n(new zzbz(2, zzafVar, publishOptions.a, new b.i.a.f.h.m.j(kVar), null, null, false, b0Var, false, null, i));
    }
}
