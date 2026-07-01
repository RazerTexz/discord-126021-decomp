package d0.e0.p.d.m0.i;

import d0.e0.p.d.m0.i.g;
import d0.e0.p.d.m0.i.g$b;

/* JADX INFO: compiled from: GeneratedMessageLite.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class g$b<MessageType extends g, BuilderType extends g$b> extends a$a<BuilderType> {
    public c j = c.j;

    /* JADX INFO: renamed from: clone */
    public /* bridge */ /* synthetic */ Object mo88clone() throws CloneNotSupportedException {
        return clone();
    }

    public final c getUnknownFields() {
        return this.j;
    }

    public abstract BuilderType mergeFrom(MessageType messagetype);

    public final BuilderType setUnknownFields(c cVar) {
        this.j = cVar;
        return this;
    }

    public BuilderType clone() {
        throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
    }
}
