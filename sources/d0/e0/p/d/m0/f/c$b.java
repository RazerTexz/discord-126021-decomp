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
public final class c$b extends g$c<c, c$b> implements d0.e0.p.d.m0.i.o {
    public int m;
    public int o;
    public int p;
    public int n = 6;
    public List<s> q = Collections.emptyList();
    public List<q> r = Collections.emptyList();

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public List<Integer> f3393s = Collections.emptyList();
    public List<Integer> t = Collections.emptyList();
    public List<d> u = Collections.emptyList();
    public List<i> v = Collections.emptyList();
    public List<n> w = Collections.emptyList();

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public List<r> f3394x = Collections.emptyList();

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public List<g> f3395y = Collections.emptyList();

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public List<Integer> f3396z = Collections.emptyList();
    public t A = t.getDefaultInstance();
    public List<Integer> B = Collections.emptyList();
    public w C = w.getDefaultInstance();

    @Override // d0.e0.p.d.m0.i.n$a
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.i.n build() {
        return build();
    }

    public c buildPartial() {
        c cVar = new c(this, (a) null);
        int i = this.m;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c.r(cVar, this.n);
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c.s(cVar, this.o);
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        c.t(cVar, this.p);
        if ((this.m & 8) == 8) {
            this.q = Collections.unmodifiableList(this.q);
            this.m &= -9;
        }
        c.v(cVar, this.q);
        if ((this.m & 16) == 16) {
            this.r = Collections.unmodifiableList(this.r);
            this.m &= -17;
        }
        c.x(cVar, this.r);
        if ((this.m & 32) == 32) {
            this.f3393s = Collections.unmodifiableList(this.f3393s);
            this.m &= -33;
        }
        c.z(cVar, this.f3393s);
        if ((this.m & 64) == 64) {
            this.t = Collections.unmodifiableList(this.t);
            this.m &= -65;
        }
        c.B(cVar, this.t);
        if ((this.m & 128) == 128) {
            this.u = Collections.unmodifiableList(this.u);
            this.m &= -129;
        }
        c.D(cVar, this.u);
        if ((this.m & 256) == 256) {
            this.v = Collections.unmodifiableList(this.v);
            this.m &= -257;
        }
        c.F(cVar, this.v);
        if ((this.m & 512) == 512) {
            this.w = Collections.unmodifiableList(this.w);
            this.m &= -513;
        }
        c.H(cVar, this.w);
        if ((this.m & 1024) == 1024) {
            this.f3394x = Collections.unmodifiableList(this.f3394x);
            this.m &= -1025;
        }
        c.J(cVar, this.f3394x);
        if ((this.m & 2048) == 2048) {
            this.f3395y = Collections.unmodifiableList(this.f3395y);
            this.m &= -2049;
        }
        c.i(cVar, this.f3395y);
        if ((this.m & 4096) == 4096) {
            this.f3396z = Collections.unmodifiableList(this.f3396z);
            this.m &= -4097;
        }
        c.k(cVar, this.f3396z);
        if ((i & 8192) == 8192) {
            i2 |= 8;
        }
        c.l(cVar, this.A);
        if ((this.m & 16384) == 16384) {
            this.B = Collections.unmodifiableList(this.B);
            this.m &= -16385;
        }
        c.n(cVar, this.B);
        if ((i & 32768) == 32768) {
            i2 |= 16;
        }
        c.o(cVar, this.C);
        c.p(cVar, i2);
        return cVar;
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

    public c$b mergeTypeTable(t tVar) {
        if ((this.m & 8192) != 8192 || this.A == t.getDefaultInstance()) {
            this.A = tVar;
        } else {
            this.A = t.newBuilder(this.A).mergeFrom(tVar).buildPartial();
        }
        this.m |= 8192;
        return this;
    }

    public c$b mergeVersionRequirementTable(w wVar) {
        if ((this.m & 32768) != 32768 || this.C == w.getDefaultInstance()) {
            this.C = wVar;
        } else {
            this.C = w.newBuilder(this.C).mergeFrom(wVar).buildPartial();
        }
        this.m |= 32768;
        return this;
    }

    public c$b setCompanionObjectName(int i) {
        this.m |= 4;
        this.p = i;
        return this;
    }

    public c$b setFlags(int i) {
        this.m |= 1;
        this.n = i;
        return this;
    }

    public c$b setFqName(int i) {
        this.m |= 2;
        this.o = i;
        return this;
    }

    @Override // d0.e0.p.d.m0.i.n$a
    public c build() {
        c cVarBuildPartial = buildPartial();
        if (cVarBuildPartial.isInitialized()) {
            return cVarBuildPartial;
        }
        throw new UninitializedMessageException(cVarBuildPartial);
    }

    @Override // d0.e0.p.d.m0.i.g$b
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.i.g$b clone() {
        return clone();
    }

    @Override // d0.e0.p.d.m0.i.g$b
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.i.g$b mergeFrom(d0.e0.p.d.m0.i.g gVar) {
        return mergeFrom((c) gVar);
    }

    @Override // d0.e0.p.d.m0.i.g$b
    public c$b clone() {
        return new c$b().mergeFrom(buildPartial());
    }

    @Override // d0.e0.p.d.m0.i.a$a, d0.e0.p.d.m0.i.n$a
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.i.n$a mergeFrom(d0.e0.p.d.m0.i.d dVar, d0.e0.p.d.m0.i.e eVar) throws IOException {
        return mergeFrom(dVar, eVar);
    }

    public c$b mergeFrom(c cVar) {
        if (cVar == c.getDefaultInstance()) {
            return this;
        }
        if (cVar.hasFlags()) {
            setFlags(cVar.getFlags());
        }
        if (cVar.hasFqName()) {
            setFqName(cVar.getFqName());
        }
        if (cVar.hasCompanionObjectName()) {
            setCompanionObjectName(cVar.getCompanionObjectName());
        }
        if (!c.u(cVar).isEmpty()) {
            if (this.q.isEmpty()) {
                this.q = c.u(cVar);
                this.m &= -9;
            } else {
                if ((this.m & 8) != 8) {
                    this.q = new ArrayList(this.q);
                    this.m |= 8;
                }
                this.q.addAll(c.u(cVar));
            }
        }
        if (!c.w(cVar).isEmpty()) {
            if (this.r.isEmpty()) {
                this.r = c.w(cVar);
                this.m &= -17;
            } else {
                if ((this.m & 16) != 16) {
                    this.r = new ArrayList(this.r);
                    this.m |= 16;
                }
                this.r.addAll(c.w(cVar));
            }
        }
        if (!c.y(cVar).isEmpty()) {
            if (this.f3393s.isEmpty()) {
                this.f3393s = c.y(cVar);
                this.m &= -33;
            } else {
                if ((this.m & 32) != 32) {
                    this.f3393s = new ArrayList(this.f3393s);
                    this.m |= 32;
                }
                this.f3393s.addAll(c.y(cVar));
            }
        }
        if (!c.A(cVar).isEmpty()) {
            if (this.t.isEmpty()) {
                this.t = c.A(cVar);
                this.m &= -65;
            } else {
                if ((this.m & 64) != 64) {
                    this.t = new ArrayList(this.t);
                    this.m |= 64;
                }
                this.t.addAll(c.A(cVar));
            }
        }
        if (!c.C(cVar).isEmpty()) {
            if (this.u.isEmpty()) {
                this.u = c.C(cVar);
                this.m &= -129;
            } else {
                if ((this.m & 128) != 128) {
                    this.u = new ArrayList(this.u);
                    this.m |= 128;
                }
                this.u.addAll(c.C(cVar));
            }
        }
        if (!c.E(cVar).isEmpty()) {
            if (this.v.isEmpty()) {
                this.v = c.E(cVar);
                this.m &= -257;
            } else {
                if ((this.m & 256) != 256) {
                    this.v = new ArrayList(this.v);
                    this.m |= 256;
                }
                this.v.addAll(c.E(cVar));
            }
        }
        if (!c.G(cVar).isEmpty()) {
            if (this.w.isEmpty()) {
                this.w = c.G(cVar);
                this.m &= -513;
            } else {
                if ((this.m & 512) != 512) {
                    this.w = new ArrayList(this.w);
                    this.m |= 512;
                }
                this.w.addAll(c.G(cVar));
            }
        }
        if (!c.I(cVar).isEmpty()) {
            if (this.f3394x.isEmpty()) {
                this.f3394x = c.I(cVar);
                this.m &= -1025;
            } else {
                if ((this.m & 1024) != 1024) {
                    this.f3394x = new ArrayList(this.f3394x);
                    this.m |= 1024;
                }
                this.f3394x.addAll(c.I(cVar));
            }
        }
        if (!c.h(cVar).isEmpty()) {
            if (this.f3395y.isEmpty()) {
                this.f3395y = c.h(cVar);
                this.m &= -2049;
            } else {
                if ((this.m & 2048) != 2048) {
                    this.f3395y = new ArrayList(this.f3395y);
                    this.m |= 2048;
                }
                this.f3395y.addAll(c.h(cVar));
            }
        }
        if (!c.j(cVar).isEmpty()) {
            if (this.f3396z.isEmpty()) {
                this.f3396z = c.j(cVar);
                this.m &= -4097;
            } else {
                if ((this.m & 4096) != 4096) {
                    this.f3396z = new ArrayList(this.f3396z);
                    this.m |= 4096;
                }
                this.f3396z.addAll(c.j(cVar));
            }
        }
        if (cVar.hasTypeTable()) {
            mergeTypeTable(cVar.getTypeTable());
        }
        if (!c.m(cVar).isEmpty()) {
            if (this.B.isEmpty()) {
                this.B = c.m(cVar);
                this.m &= -16385;
            } else {
                if ((this.m & 16384) != 16384) {
                    this.B = new ArrayList(this.B);
                    this.m |= 16384;
                }
                this.B.addAll(c.m(cVar));
            }
        }
        if (cVar.hasVersionRequirementTable()) {
            mergeVersionRequirementTable(cVar.getVersionRequirementTable());
        }
        b(cVar);
        setUnknownFields(getUnknownFields().concat(c.q(cVar)));
        return this;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x001d  */
    @Override // d0.e0.p.d.m0.i.a$a, d0.e0.p.d.m0.i.n$a
    public c$b mergeFrom(d0.e0.p.d.m0.i.d dVar, d0.e0.p.d.m0.i.e eVar) throws Throwable {
        c cVar = null;
        try {
            try {
                c partialFrom = c.k.parsePartialFrom(dVar, eVar);
                if (partialFrom != null) {
                    mergeFrom(partialFrom);
                }
                return this;
            } catch (InvalidProtocolBufferException e) {
                c cVar2 = (c) e.getUnfinishedMessage();
                try {
                    throw e;
                } catch (Throwable th) {
                    th = th;
                    cVar = cVar2;
                    if (cVar != null) {
                        mergeFrom(cVar);
                    }
                    throw th;
                }
            }
        } catch (Throwable th2) {
            th = th2;
            if (cVar != null) {
                mergeFrom(cVar);
            }
            throw th;
        }
    }
}
