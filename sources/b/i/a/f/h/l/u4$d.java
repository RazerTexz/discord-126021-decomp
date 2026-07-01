package b.i.a.f.h.l;

import b.i.a.f.h.l.u4$d;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class u4$d<MessageType extends u4$d<MessageType, BuilderType>, BuilderType> extends u4<MessageType, BuilderType> implements d6 {
    public n4<u4$c> zzc = n4.a;

    public final n4<u4$c> u() {
        n4<u4$c> n4Var = this.zzc;
        if (n4Var.c) {
            this.zzc = (n4) n4Var.clone();
        }
        return this.zzc;
    }
}
