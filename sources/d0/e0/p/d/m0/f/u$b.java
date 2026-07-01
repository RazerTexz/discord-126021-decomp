package d0.e0.p.d.m0.f;

import d0.e0.p.d.m0.i.a$a;
import d0.e0.p.d.m0.i.g$c;
import java.io.IOException;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.UninitializedMessageException;

/* JADX INFO: compiled from: ProtoBuf.java */
/* JADX INFO: loaded from: classes3.dex */
public final class u$b extends g$c<u, u$b> implements d0.e0.p.d.m0.i.o {
    public int m;
    public int n;
    public int o;
    public int q;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f3409s;
    public q p = q.getDefaultInstance();
    public q r = q.getDefaultInstance();

    @Override // d0.e0.p.d.m0.i.n$a
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.i.n build() {
        return build();
    }

    public u buildPartial() {
        u uVar = new u(this, null);
        int i = this.m;
        int i2 = (i & 1) != 1 ? 0 : 1;
        u.h(uVar, this.n);
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        u.i(uVar, this.o);
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        u.j(uVar, this.p);
        if ((i & 8) == 8) {
            i2 |= 8;
        }
        u.k(uVar, this.q);
        if ((i & 16) == 16) {
            i2 |= 16;
        }
        u.l(uVar, this.r);
        if ((i & 32) == 32) {
            i2 |= 32;
        }
        u.m(uVar, this.f3409s);
        u.n(uVar, i2);
        return uVar;
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

    public u$b mergeType(q qVar) {
        if ((this.m & 4) != 4 || this.p == q.getDefaultInstance()) {
            this.p = qVar;
        } else {
            this.p = q.newBuilder(this.p).mergeFrom(qVar).buildPartial();
        }
        this.m |= 4;
        return this;
    }

    public u$b mergeVarargElementType(q qVar) {
        if ((this.m & 16) != 16 || this.r == q.getDefaultInstance()) {
            this.r = qVar;
        } else {
            this.r = q.newBuilder(this.r).mergeFrom(qVar).buildPartial();
        }
        this.m |= 16;
        return this;
    }

    public u$b setFlags(int i) {
        this.m |= 1;
        this.n = i;
        return this;
    }

    public u$b setName(int i) {
        this.m |= 2;
        this.o = i;
        return this;
    }

    public u$b setTypeId(int i) {
        this.m |= 8;
        this.q = i;
        return this;
    }

    public u$b setVarargElementTypeId(int i) {
        this.m |= 32;
        this.f3409s = i;
        return this;
    }

    @Override // d0.e0.p.d.m0.i.n$a
    public u build() {
        u uVarBuildPartial = buildPartial();
        if (uVarBuildPartial.isInitialized()) {
            return uVarBuildPartial;
        }
        throw new UninitializedMessageException(uVarBuildPartial);
    }

    @Override // d0.e0.p.d.m0.i.g$b
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.i.g$b clone() {
        return clone();
    }

    @Override // d0.e0.p.d.m0.i.g$b
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.i.g$b mergeFrom(d0.e0.p.d.m0.i.g gVar) {
        return mergeFrom((u) gVar);
    }

    @Override // d0.e0.p.d.m0.i.g$b
    public u$b clone() {
        return new u$b().mergeFrom(buildPartial());
    }

    @Override // d0.e0.p.d.m0.i.a$a, d0.e0.p.d.m0.i.n$a
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.i.n$a mergeFrom(d0.e0.p.d.m0.i.d dVar, d0.e0.p.d.m0.i.e eVar) throws IOException {
        return mergeFrom(dVar, eVar);
    }

    public u$b mergeFrom(u uVar) {
        if (uVar == u.getDefaultInstance()) {
            return this;
        }
        if (uVar.hasFlags()) {
            setFlags(uVar.getFlags());
        }
        if (uVar.hasName()) {
            setName(uVar.getName());
        }
        if (uVar.hasType()) {
            mergeType(uVar.getType());
        }
        if (uVar.hasTypeId()) {
            setTypeId(uVar.getTypeId());
        }
        if (uVar.hasVarargElementType()) {
            mergeVarargElementType(uVar.getVarargElementType());
        }
        if (uVar.hasVarargElementTypeId()) {
            setVarargElementTypeId(uVar.getVarargElementTypeId());
        }
        b(uVar);
        setUnknownFields(getUnknownFields().concat(u.o(uVar)));
        return this;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x001d  */
    @Override // d0.e0.p.d.m0.i.a$a, d0.e0.p.d.m0.i.n$a
    public u$b mergeFrom(d0.e0.p.d.m0.i.d dVar, d0.e0.p.d.m0.i.e eVar) throws Throwable {
        u uVar = null;
        try {
            try {
                u partialFrom = u.k.parsePartialFrom(dVar, eVar);
                if (partialFrom != null) {
                    mergeFrom(partialFrom);
                }
                return this;
            } catch (InvalidProtocolBufferException e) {
                u uVar2 = (u) e.getUnfinishedMessage();
                try {
                    throw e;
                } catch (Throwable th) {
                    th = th;
                    uVar = uVar2;
                    if (uVar != null) {
                        mergeFrom(uVar);
                    }
                    throw th;
                }
            }
        } catch (Throwable th2) {
            th = th2;
            if (uVar != null) {
                mergeFrom(uVar);
            }
            throw th;
        }
    }
}
