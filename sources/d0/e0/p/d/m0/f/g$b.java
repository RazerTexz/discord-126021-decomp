package d0.e0.p.d.m0.f;

import d0.e0.p.d.m0.i.a$a;
import d0.e0.p.d.m0.i.g$c;
import java.io.IOException;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.UninitializedMessageException;

/* JADX INFO: compiled from: ProtoBuf.java */
/* JADX INFO: loaded from: classes3.dex */
public final class g$b extends g$c<g, g$b> implements d0.e0.p.d.m0.i.o {
    public int m;
    public int n;

    @Override // d0.e0.p.d.m0.i.n$a
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.i.n build() {
        return build();
    }

    public g buildPartial() {
        g gVar = new g(this, null);
        int i = (this.m & 1) != 1 ? 0 : 1;
        g.h(gVar, this.n);
        g.i(gVar, i);
        return gVar;
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

    public g$b setName(int i) {
        this.m |= 1;
        this.n = i;
        return this;
    }

    @Override // d0.e0.p.d.m0.i.n$a
    public g build() {
        g gVarBuildPartial = buildPartial();
        if (gVarBuildPartial.isInitialized()) {
            return gVarBuildPartial;
        }
        throw new UninitializedMessageException(gVarBuildPartial);
    }

    @Override // d0.e0.p.d.m0.i.g$b
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.i.g$b clone() {
        return clone();
    }

    @Override // d0.e0.p.d.m0.i.g$b
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.i.g$b mergeFrom(d0.e0.p.d.m0.i.g gVar) {
        return mergeFrom((g) gVar);
    }

    @Override // d0.e0.p.d.m0.i.g$b
    public g$b clone() {
        return new g$b().mergeFrom(buildPartial());
    }

    @Override // d0.e0.p.d.m0.i.a$a, d0.e0.p.d.m0.i.n$a
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.i.n$a mergeFrom(d0.e0.p.d.m0.i.d dVar, d0.e0.p.d.m0.i.e eVar) throws IOException {
        return mergeFrom(dVar, eVar);
    }

    public g$b mergeFrom(g gVar) {
        if (gVar == g.getDefaultInstance()) {
            return this;
        }
        if (gVar.hasName()) {
            setName(gVar.getName());
        }
        b(gVar);
        setUnknownFields(getUnknownFields().concat(g.j(gVar)));
        return this;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x001d  */
    @Override // d0.e0.p.d.m0.i.a$a, d0.e0.p.d.m0.i.n$a
    public g$b mergeFrom(d0.e0.p.d.m0.i.d dVar, d0.e0.p.d.m0.i.e eVar) throws Throwable {
        g gVar = null;
        try {
            try {
                g partialFrom = g.k.parsePartialFrom(dVar, eVar);
                if (partialFrom != null) {
                    mergeFrom(partialFrom);
                }
                return this;
            } catch (InvalidProtocolBufferException e) {
                g gVar2 = (g) e.getUnfinishedMessage();
                try {
                    throw e;
                } catch (Throwable th) {
                    th = th;
                    gVar = gVar2;
                    if (gVar != null) {
                        mergeFrom(gVar);
                    }
                    throw th;
                }
            }
        } catch (Throwable th2) {
            th = th2;
            if (gVar != null) {
                mergeFrom(gVar);
            }
            throw th;
        }
    }
}
