package d0.e0.p.d.m0.f;

import d0.e0.p.d.m0.i.a$a;
import java.io.IOException;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.UninitializedMessageException;

/* JADX INFO: compiled from: ProtoBuf.java */
/* JADX INFO: loaded from: classes3.dex */
public final class p$b extends d0.e0.p.d.m0.i.g$b<p, p$b> implements d0.e0.p.d.m0.i.o {
    public int k;
    public d0.e0.p.d.m0.i.l l = d0.e0.p.d.m0.i.k.j;

    @Override // d0.e0.p.d.m0.i.n$a
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.i.n build() {
        return build();
    }

    public p buildPartial() {
        p pVar = new p(this, null);
        if ((this.k & 1) == 1) {
            this.l = this.l.getUnmodifiableView();
            this.k &= -2;
        }
        p.b(pVar, this.l);
        return pVar;
    }

    @Override // d0.e0.p.d.m0.i.g$b
    /* JADX INFO: renamed from: clone */
    public /* bridge */ /* synthetic */ Object mo88clone() throws CloneNotSupportedException {
        return clone();
    }

    @Override // d0.e0.p.d.m0.i.a$a, d0.e0.p.d.m0.i.n$a
    public /* bridge */ /* synthetic */ a$a mergeFrom(d0.e0.p.d.m0.i.d dVar, d0.e0.p.d.m0.i.e eVar) throws IOException {
        return mergeFrom(dVar, eVar);
    }

    @Override // d0.e0.p.d.m0.i.n$a
    public p build() {
        p pVarBuildPartial = buildPartial();
        if (pVarBuildPartial.isInitialized()) {
            return pVarBuildPartial;
        }
        throw new UninitializedMessageException(pVarBuildPartial);
    }

    @Override // d0.e0.p.d.m0.i.g$b
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.i.g$b clone() {
        return clone();
    }

    @Override // d0.e0.p.d.m0.i.g$b
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.i.g$b mergeFrom(d0.e0.p.d.m0.i.g gVar) {
        return mergeFrom((p) gVar);
    }

    @Override // d0.e0.p.d.m0.i.g$b
    public p$b clone() {
        return new p$b().mergeFrom(buildPartial());
    }

    @Override // d0.e0.p.d.m0.i.a$a, d0.e0.p.d.m0.i.n$a
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.i.n$a mergeFrom(d0.e0.p.d.m0.i.d dVar, d0.e0.p.d.m0.i.e eVar) throws IOException {
        return mergeFrom(dVar, eVar);
    }

    public p$b mergeFrom(p pVar) {
        if (pVar == p.getDefaultInstance()) {
            return this;
        }
        if (!p.a(pVar).isEmpty()) {
            if (this.l.isEmpty()) {
                this.l = p.a(pVar);
                this.k &= -2;
            } else {
                if ((this.k & 1) != 1) {
                    this.l = new d0.e0.p.d.m0.i.k(this.l);
                    this.k |= 1;
                }
                this.l.addAll(p.a(pVar));
            }
        }
        setUnknownFields(getUnknownFields().concat(p.c(pVar)));
        return this;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x001d  */
    @Override // d0.e0.p.d.m0.i.a$a, d0.e0.p.d.m0.i.n$a
    public p$b mergeFrom(d0.e0.p.d.m0.i.d dVar, d0.e0.p.d.m0.i.e eVar) throws Throwable {
        p pVar = null;
        try {
            try {
                p partialFrom = p.k.parsePartialFrom(dVar, eVar);
                if (partialFrom != null) {
                    mergeFrom(partialFrom);
                }
                return this;
            } catch (InvalidProtocolBufferException e) {
                p pVar2 = (p) e.getUnfinishedMessage();
                try {
                    throw e;
                } catch (Throwable th) {
                    th = th;
                    pVar = pVar2;
                    if (pVar != null) {
                        mergeFrom(pVar);
                    }
                    throw th;
                }
            }
        } catch (Throwable th2) {
            th = th2;
            if (pVar != null) {
                mergeFrom(pVar);
            }
            throw th;
        }
    }
}
