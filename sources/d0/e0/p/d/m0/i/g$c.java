package d0.e0.p.d.m0.i;

import d0.e0.p.d.m0.i.g$c;
import d0.e0.p.d.m0.i.g$d;

/* JADX INFO: compiled from: GeneratedMessageLite.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class g$c<MessageType extends g$d<MessageType>, BuilderType extends g$c<MessageType, BuilderType>> extends g$b<MessageType, BuilderType> implements o {
    public f<g$e> k = f.emptySet();
    public boolean l;

    public final void b(MessageType messagetype) {
        if (!this.l) {
            this.k = this.k.clone();
            this.l = true;
        }
        this.k.mergeFrom(g$d.a(messagetype));
    }
}
