package d0.e0.p.d.m0.f;

import d0.e0.p.d.m0.i.a$a;
import d0.e0.p.d.m0.i.g$c;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.UninitializedMessageException;

/* JADX INFO: compiled from: ProtoBuf.java */
/* JADX INFO: loaded from: classes3.dex */
public final class n$b extends g$c<n, n$b> implements d0.e0.p.d.m0.i.o {
    public int m;
    public int p;
    public int r;
    public int u;
    public int w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f3401x;
    public int n = 518;
    public int o = 2054;
    public q q = q.getDefaultInstance();

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public List<s> f3400s = Collections.emptyList();
    public q t = q.getDefaultInstance();
    public u v = u.getDefaultInstance();

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public List<Integer> f3402y = Collections.emptyList();

    @Override // d0.e0.p.d.m0.i.n$a
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.i.n build() {
        return build();
    }

    public n buildPartial() {
        n nVar = new n(this, null);
        int i = this.m;
        int i2 = (i & 1) != 1 ? 0 : 1;
        n.h(nVar, this.n);
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        n.i(nVar, this.o);
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        n.j(nVar, this.p);
        if ((i & 8) == 8) {
            i2 |= 8;
        }
        n.k(nVar, this.q);
        if ((i & 16) == 16) {
            i2 |= 16;
        }
        n.l(nVar, this.r);
        if ((this.m & 32) == 32) {
            this.f3400s = Collections.unmodifiableList(this.f3400s);
            this.m &= -33;
        }
        n.n(nVar, this.f3400s);
        if ((i & 64) == 64) {
            i2 |= 32;
        }
        n.o(nVar, this.t);
        if ((i & 128) == 128) {
            i2 |= 64;
        }
        n.p(nVar, this.u);
        if ((i & 256) == 256) {
            i2 |= 128;
        }
        n.q(nVar, this.v);
        if ((i & 512) == 512) {
            i2 |= 256;
        }
        n.r(nVar, this.w);
        if ((i & 1024) == 1024) {
            i2 |= 512;
        }
        n.s(nVar, this.f3401x);
        if ((this.m & 2048) == 2048) {
            this.f3402y = Collections.unmodifiableList(this.f3402y);
            this.m &= -2049;
        }
        n.u(nVar, this.f3402y);
        n.v(nVar, i2);
        return nVar;
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

    public n$b mergeReceiverType(q qVar) {
        if ((this.m & 64) != 64 || this.t == q.getDefaultInstance()) {
            this.t = qVar;
        } else {
            this.t = q.newBuilder(this.t).mergeFrom(qVar).buildPartial();
        }
        this.m |= 64;
        return this;
    }

    public n$b mergeReturnType(q qVar) {
        if ((this.m & 8) != 8 || this.q == q.getDefaultInstance()) {
            this.q = qVar;
        } else {
            this.q = q.newBuilder(this.q).mergeFrom(qVar).buildPartial();
        }
        this.m |= 8;
        return this;
    }

    public n$b mergeSetterValueParameter(u uVar) {
        if ((this.m & 256) != 256 || this.v == u.getDefaultInstance()) {
            this.v = uVar;
        } else {
            this.v = u.newBuilder(this.v).mergeFrom(uVar).buildPartial();
        }
        this.m |= 256;
        return this;
    }

    public n$b setFlags(int i) {
        this.m |= 1;
        this.n = i;
        return this;
    }

    public n$b setGetterFlags(int i) {
        this.m |= 512;
        this.w = i;
        return this;
    }

    public n$b setName(int i) {
        this.m |= 4;
        this.p = i;
        return this;
    }

    public n$b setOldFlags(int i) {
        this.m |= 2;
        this.o = i;
        return this;
    }

    public n$b setReceiverTypeId(int i) {
        this.m |= 128;
        this.u = i;
        return this;
    }

    public n$b setReturnTypeId(int i) {
        this.m |= 16;
        this.r = i;
        return this;
    }

    public n$b setSetterFlags(int i) {
        this.m |= 1024;
        this.f3401x = i;
        return this;
    }

    @Override // d0.e0.p.d.m0.i.n$a
    public n build() {
        n nVarBuildPartial = buildPartial();
        if (nVarBuildPartial.isInitialized()) {
            return nVarBuildPartial;
        }
        throw new UninitializedMessageException(nVarBuildPartial);
    }

    @Override // d0.e0.p.d.m0.i.g$b
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.i.g$b clone() {
        return clone();
    }

    @Override // d0.e0.p.d.m0.i.g$b
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.i.g$b mergeFrom(d0.e0.p.d.m0.i.g gVar) {
        return mergeFrom((n) gVar);
    }

    @Override // d0.e0.p.d.m0.i.g$b
    public n$b clone() {
        return new n$b().mergeFrom(buildPartial());
    }

    @Override // d0.e0.p.d.m0.i.a$a, d0.e0.p.d.m0.i.n$a
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.i.n$a mergeFrom(d0.e0.p.d.m0.i.d dVar, d0.e0.p.d.m0.i.e eVar) throws IOException {
        return mergeFrom(dVar, eVar);
    }

    public n$b mergeFrom(n nVar) {
        if (nVar == n.getDefaultInstance()) {
            return this;
        }
        if (nVar.hasFlags()) {
            setFlags(nVar.getFlags());
        }
        if (nVar.hasOldFlags()) {
            setOldFlags(nVar.getOldFlags());
        }
        if (nVar.hasName()) {
            setName(nVar.getName());
        }
        if (nVar.hasReturnType()) {
            mergeReturnType(nVar.getReturnType());
        }
        if (nVar.hasReturnTypeId()) {
            setReturnTypeId(nVar.getReturnTypeId());
        }
        if (!n.m(nVar).isEmpty()) {
            if (this.f3400s.isEmpty()) {
                this.f3400s = n.m(nVar);
                this.m &= -33;
            } else {
                if ((this.m & 32) != 32) {
                    this.f3400s = new ArrayList(this.f3400s);
                    this.m |= 32;
                }
                this.f3400s.addAll(n.m(nVar));
            }
        }
        if (nVar.hasReceiverType()) {
            mergeReceiverType(nVar.getReceiverType());
        }
        if (nVar.hasReceiverTypeId()) {
            setReceiverTypeId(nVar.getReceiverTypeId());
        }
        if (nVar.hasSetterValueParameter()) {
            mergeSetterValueParameter(nVar.getSetterValueParameter());
        }
        if (nVar.hasGetterFlags()) {
            setGetterFlags(nVar.getGetterFlags());
        }
        if (nVar.hasSetterFlags()) {
            setSetterFlags(nVar.getSetterFlags());
        }
        if (!n.t(nVar).isEmpty()) {
            if (this.f3402y.isEmpty()) {
                this.f3402y = n.t(nVar);
                this.m &= -2049;
            } else {
                if ((this.m & 2048) != 2048) {
                    this.f3402y = new ArrayList(this.f3402y);
                    this.m |= 2048;
                }
                this.f3402y.addAll(n.t(nVar));
            }
        }
        b(nVar);
        setUnknownFields(getUnknownFields().concat(n.w(nVar)));
        return this;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x001d  */
    @Override // d0.e0.p.d.m0.i.a$a, d0.e0.p.d.m0.i.n$a
    public n$b mergeFrom(d0.e0.p.d.m0.i.d dVar, d0.e0.p.d.m0.i.e eVar) throws Throwable {
        n nVar = null;
        try {
            try {
                n partialFrom = n.k.parsePartialFrom(dVar, eVar);
                if (partialFrom != null) {
                    mergeFrom(partialFrom);
                }
                return this;
            } catch (InvalidProtocolBufferException e) {
                n nVar2 = (n) e.getUnfinishedMessage();
                try {
                    throw e;
                } catch (Throwable th) {
                    th = th;
                    nVar = nVar2;
                    if (nVar != null) {
                        mergeFrom(nVar);
                    }
                    throw th;
                }
            }
        } catch (Throwable th2) {
            th = th2;
            if (nVar != null) {
                mergeFrom(nVar);
            }
            throw th;
        }
    }
}
