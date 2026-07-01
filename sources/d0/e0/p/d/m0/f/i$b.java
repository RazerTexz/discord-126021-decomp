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
public final class i$b extends g$c<i, i$b> implements d0.e0.p.d.m0.i.o {
    public int m;
    public int p;
    public int r;
    public int u;
    public int n = 6;
    public int o = 6;
    public q q = q.getDefaultInstance();

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public List<s> f3397s = Collections.emptyList();
    public q t = q.getDefaultInstance();
    public List<u> v = Collections.emptyList();
    public t w = t.getDefaultInstance();

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public List<Integer> f3398x = Collections.emptyList();

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public e f3399y = e.getDefaultInstance();

    @Override // d0.e0.p.d.m0.i.n$a
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.i.n build() {
        return build();
    }

    public i buildPartial() {
        i iVar = new i(this, null);
        int i = this.m;
        int i2 = (i & 1) != 1 ? 0 : 1;
        i.h(iVar, this.n);
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        i.i(iVar, this.o);
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        i.j(iVar, this.p);
        if ((i & 8) == 8) {
            i2 |= 8;
        }
        i.k(iVar, this.q);
        if ((i & 16) == 16) {
            i2 |= 16;
        }
        i.l(iVar, this.r);
        if ((this.m & 32) == 32) {
            this.f3397s = Collections.unmodifiableList(this.f3397s);
            this.m &= -33;
        }
        i.n(iVar, this.f3397s);
        if ((i & 64) == 64) {
            i2 |= 32;
        }
        i.o(iVar, this.t);
        if ((i & 128) == 128) {
            i2 |= 64;
        }
        i.p(iVar, this.u);
        if ((this.m & 256) == 256) {
            this.v = Collections.unmodifiableList(this.v);
            this.m &= -257;
        }
        i.r(iVar, this.v);
        if ((i & 512) == 512) {
            i2 |= 128;
        }
        i.s(iVar, this.w);
        if ((this.m & 1024) == 1024) {
            this.f3398x = Collections.unmodifiableList(this.f3398x);
            this.m &= -1025;
        }
        i.u(iVar, this.f3398x);
        if ((i & 2048) == 2048) {
            i2 |= 256;
        }
        i.v(iVar, this.f3399y);
        i.w(iVar, i2);
        return iVar;
    }

    @Override // d0.e0.p.d.m0.i.g$b
    /* JADX INFO: renamed from: clone */
    public /* bridge */ /* synthetic */ Object mo88clone() throws CloneNotSupportedException {
        return clone();
    }

    public i$b mergeContract(e eVar) {
        if ((this.m & 2048) != 2048 || this.f3399y == e.getDefaultInstance()) {
            this.f3399y = eVar;
        } else {
            this.f3399y = e.newBuilder(this.f3399y).mergeFrom(eVar).buildPartial();
        }
        this.m |= 2048;
        return this;
    }

    @Override // d0.e0.p.d.m0.i.a$a, d0.e0.p.d.m0.i.n$a
    public /* bridge */ /* synthetic */ a$a mergeFrom(d0.e0.p.d.m0.i.d dVar, d0.e0.p.d.m0.i.e eVar) throws IOException {
        return mergeFrom(dVar, eVar);
    }

    public i$b mergeReceiverType(q qVar) {
        if ((this.m & 64) != 64 || this.t == q.getDefaultInstance()) {
            this.t = qVar;
        } else {
            this.t = q.newBuilder(this.t).mergeFrom(qVar).buildPartial();
        }
        this.m |= 64;
        return this;
    }

    public i$b mergeReturnType(q qVar) {
        if ((this.m & 8) != 8 || this.q == q.getDefaultInstance()) {
            this.q = qVar;
        } else {
            this.q = q.newBuilder(this.q).mergeFrom(qVar).buildPartial();
        }
        this.m |= 8;
        return this;
    }

    public i$b mergeTypeTable(t tVar) {
        if ((this.m & 512) != 512 || this.w == t.getDefaultInstance()) {
            this.w = tVar;
        } else {
            this.w = t.newBuilder(this.w).mergeFrom(tVar).buildPartial();
        }
        this.m |= 512;
        return this;
    }

    public i$b setFlags(int i) {
        this.m |= 1;
        this.n = i;
        return this;
    }

    public i$b setName(int i) {
        this.m |= 4;
        this.p = i;
        return this;
    }

    public i$b setOldFlags(int i) {
        this.m |= 2;
        this.o = i;
        return this;
    }

    public i$b setReceiverTypeId(int i) {
        this.m |= 128;
        this.u = i;
        return this;
    }

    public i$b setReturnTypeId(int i) {
        this.m |= 16;
        this.r = i;
        return this;
    }

    @Override // d0.e0.p.d.m0.i.n$a
    public i build() {
        i iVarBuildPartial = buildPartial();
        if (iVarBuildPartial.isInitialized()) {
            return iVarBuildPartial;
        }
        throw new UninitializedMessageException(iVarBuildPartial);
    }

    @Override // d0.e0.p.d.m0.i.g$b
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.i.g$b clone() {
        return clone();
    }

    @Override // d0.e0.p.d.m0.i.g$b
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.i.g$b mergeFrom(d0.e0.p.d.m0.i.g gVar) {
        return mergeFrom((i) gVar);
    }

    @Override // d0.e0.p.d.m0.i.g$b
    public i$b clone() {
        return new i$b().mergeFrom(buildPartial());
    }

    @Override // d0.e0.p.d.m0.i.a$a, d0.e0.p.d.m0.i.n$a
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.i.n$a mergeFrom(d0.e0.p.d.m0.i.d dVar, d0.e0.p.d.m0.i.e eVar) throws IOException {
        return mergeFrom(dVar, eVar);
    }

    public i$b mergeFrom(i iVar) {
        if (iVar == i.getDefaultInstance()) {
            return this;
        }
        if (iVar.hasFlags()) {
            setFlags(iVar.getFlags());
        }
        if (iVar.hasOldFlags()) {
            setOldFlags(iVar.getOldFlags());
        }
        if (iVar.hasName()) {
            setName(iVar.getName());
        }
        if (iVar.hasReturnType()) {
            mergeReturnType(iVar.getReturnType());
        }
        if (iVar.hasReturnTypeId()) {
            setReturnTypeId(iVar.getReturnTypeId());
        }
        if (!i.m(iVar).isEmpty()) {
            if (this.f3397s.isEmpty()) {
                this.f3397s = i.m(iVar);
                this.m &= -33;
            } else {
                if ((this.m & 32) != 32) {
                    this.f3397s = new ArrayList(this.f3397s);
                    this.m |= 32;
                }
                this.f3397s.addAll(i.m(iVar));
            }
        }
        if (iVar.hasReceiverType()) {
            mergeReceiverType(iVar.getReceiverType());
        }
        if (iVar.hasReceiverTypeId()) {
            setReceiverTypeId(iVar.getReceiverTypeId());
        }
        if (!i.q(iVar).isEmpty()) {
            if (this.v.isEmpty()) {
                this.v = i.q(iVar);
                this.m &= -257;
            } else {
                if ((this.m & 256) != 256) {
                    this.v = new ArrayList(this.v);
                    this.m |= 256;
                }
                this.v.addAll(i.q(iVar));
            }
        }
        if (iVar.hasTypeTable()) {
            mergeTypeTable(iVar.getTypeTable());
        }
        if (!i.t(iVar).isEmpty()) {
            if (this.f3398x.isEmpty()) {
                this.f3398x = i.t(iVar);
                this.m &= -1025;
            } else {
                if ((this.m & 1024) != 1024) {
                    this.f3398x = new ArrayList(this.f3398x);
                    this.m |= 1024;
                }
                this.f3398x.addAll(i.t(iVar));
            }
        }
        if (iVar.hasContract()) {
            mergeContract(iVar.getContract());
        }
        b(iVar);
        setUnknownFields(getUnknownFields().concat(i.x(iVar)));
        return this;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x001d  */
    @Override // d0.e0.p.d.m0.i.a$a, d0.e0.p.d.m0.i.n$a
    public i$b mergeFrom(d0.e0.p.d.m0.i.d dVar, d0.e0.p.d.m0.i.e eVar) throws Throwable {
        i iVar = null;
        try {
            try {
                i partialFrom = i.k.parsePartialFrom(dVar, eVar);
                if (partialFrom != null) {
                    mergeFrom(partialFrom);
                }
                return this;
            } catch (InvalidProtocolBufferException e) {
                i iVar2 = (i) e.getUnfinishedMessage();
                try {
                    throw e;
                } catch (Throwable th) {
                    th = th;
                    iVar = iVar2;
                    if (iVar != null) {
                        mergeFrom(iVar);
                    }
                    throw th;
                }
            }
        } catch (Throwable th2) {
            th = th2;
            if (iVar != null) {
                mergeFrom(iVar);
            }
            throw th;
        }
    }
}
