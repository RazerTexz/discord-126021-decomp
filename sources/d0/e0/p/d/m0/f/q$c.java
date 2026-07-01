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
public final class q$c extends g$c<q, q$c> implements d0.e0.p.d.m0.i.o {
    public int A;
    public int m;
    public boolean o;
    public int p;
    public int r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f3403s;
    public int t;
    public int u;
    public int v;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f3404x;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f3406z;
    public List<q$b> n = Collections.emptyList();
    public q q = q.getDefaultInstance();
    public q w = q.getDefaultInstance();

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public q f3405y = q.getDefaultInstance();

    @Override // d0.e0.p.d.m0.i.n$a
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.i.n build() {
        return build();
    }

    public q buildPartial() {
        q qVar = new q(this, null);
        int i = this.m;
        if ((i & 1) == 1) {
            this.n = Collections.unmodifiableList(this.n);
            this.m &= -2;
        }
        q.i(qVar, this.n);
        int i2 = (i & 2) != 2 ? 0 : 1;
        q.j(qVar, this.o);
        if ((i & 4) == 4) {
            i2 |= 2;
        }
        q.k(qVar, this.p);
        if ((i & 8) == 8) {
            i2 |= 4;
        }
        q.l(qVar, this.q);
        if ((i & 16) == 16) {
            i2 |= 8;
        }
        q.m(qVar, this.r);
        if ((i & 32) == 32) {
            i2 |= 16;
        }
        q.n(qVar, this.f3403s);
        if ((i & 64) == 64) {
            i2 |= 32;
        }
        q.o(qVar, this.t);
        if ((i & 128) == 128) {
            i2 |= 64;
        }
        q.p(qVar, this.u);
        if ((i & 256) == 256) {
            i2 |= 128;
        }
        q.q(qVar, this.v);
        if ((i & 512) == 512) {
            i2 |= 256;
        }
        q.r(qVar, this.w);
        if ((i & 1024) == 1024) {
            i2 |= 512;
        }
        q.s(qVar, this.f3404x);
        if ((i & 2048) == 2048) {
            i2 |= 1024;
        }
        q.t(qVar, this.f3405y);
        if ((i & 4096) == 4096) {
            i2 |= 2048;
        }
        q.u(qVar, this.f3406z);
        if ((i & 8192) == 8192) {
            i2 |= 4096;
        }
        q.v(qVar, this.A);
        q.w(qVar, i2);
        return qVar;
    }

    @Override // d0.e0.p.d.m0.i.g$b
    /* JADX INFO: renamed from: clone */
    public /* bridge */ /* synthetic */ Object mo88clone() throws CloneNotSupportedException {
        return clone();
    }

    public q$c mergeAbbreviatedType(q qVar) {
        if ((this.m & 2048) != 2048 || this.f3405y == q.getDefaultInstance()) {
            this.f3405y = qVar;
        } else {
            this.f3405y = q.newBuilder(this.f3405y).mergeFrom(qVar).buildPartial();
        }
        this.m |= 2048;
        return this;
    }

    public q$c mergeFlexibleUpperBound(q qVar) {
        if ((this.m & 8) != 8 || this.q == q.getDefaultInstance()) {
            this.q = qVar;
        } else {
            this.q = q.newBuilder(this.q).mergeFrom(qVar).buildPartial();
        }
        this.m |= 8;
        return this;
    }

    @Override // d0.e0.p.d.m0.i.a$a, d0.e0.p.d.m0.i.n$a
    public /* bridge */ /* synthetic */ a$a mergeFrom(d0.e0.p.d.m0.i.d dVar, d0.e0.p.d.m0.i.e eVar) throws IOException {
        return mergeFrom(dVar, eVar);
    }

    public q$c mergeOuterType(q qVar) {
        if ((this.m & 512) != 512 || this.w == q.getDefaultInstance()) {
            this.w = qVar;
        } else {
            this.w = q.newBuilder(this.w).mergeFrom(qVar).buildPartial();
        }
        this.m |= 512;
        return this;
    }

    public q$c setAbbreviatedTypeId(int i) {
        this.m |= 4096;
        this.f3406z = i;
        return this;
    }

    public q$c setClassName(int i) {
        this.m |= 32;
        this.f3403s = i;
        return this;
    }

    public q$c setFlags(int i) {
        this.m |= 8192;
        this.A = i;
        return this;
    }

    public q$c setFlexibleTypeCapabilitiesId(int i) {
        this.m |= 4;
        this.p = i;
        return this;
    }

    public q$c setFlexibleUpperBoundId(int i) {
        this.m |= 16;
        this.r = i;
        return this;
    }

    public q$c setNullable(boolean z2) {
        this.m |= 2;
        this.o = z2;
        return this;
    }

    public q$c setOuterTypeId(int i) {
        this.m |= 1024;
        this.f3404x = i;
        return this;
    }

    public q$c setTypeAliasName(int i) {
        this.m |= 256;
        this.v = i;
        return this;
    }

    public q$c setTypeParameter(int i) {
        this.m |= 64;
        this.t = i;
        return this;
    }

    public q$c setTypeParameterName(int i) {
        this.m |= 128;
        this.u = i;
        return this;
    }

    @Override // d0.e0.p.d.m0.i.n$a
    public q build() {
        q qVarBuildPartial = buildPartial();
        if (qVarBuildPartial.isInitialized()) {
            return qVarBuildPartial;
        }
        throw new UninitializedMessageException(qVarBuildPartial);
    }

    @Override // d0.e0.p.d.m0.i.g$b
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.i.g$b clone() {
        return clone();
    }

    @Override // d0.e0.p.d.m0.i.g$b
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.i.g$b mergeFrom(d0.e0.p.d.m0.i.g gVar) {
        return mergeFrom((q) gVar);
    }

    @Override // d0.e0.p.d.m0.i.g$b
    public q$c clone() {
        return new q$c().mergeFrom(buildPartial());
    }

    @Override // d0.e0.p.d.m0.i.a$a, d0.e0.p.d.m0.i.n$a
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.i.n$a mergeFrom(d0.e0.p.d.m0.i.d dVar, d0.e0.p.d.m0.i.e eVar) throws IOException {
        return mergeFrom(dVar, eVar);
    }

    public q$c mergeFrom(q qVar) {
        if (qVar == q.getDefaultInstance()) {
            return this;
        }
        if (!q.h(qVar).isEmpty()) {
            if (this.n.isEmpty()) {
                this.n = q.h(qVar);
                this.m &= -2;
            } else {
                if ((this.m & 1) != 1) {
                    this.n = new ArrayList(this.n);
                    this.m |= 1;
                }
                this.n.addAll(q.h(qVar));
            }
        }
        if (qVar.hasNullable()) {
            setNullable(qVar.getNullable());
        }
        if (qVar.hasFlexibleTypeCapabilitiesId()) {
            setFlexibleTypeCapabilitiesId(qVar.getFlexibleTypeCapabilitiesId());
        }
        if (qVar.hasFlexibleUpperBound()) {
            mergeFlexibleUpperBound(qVar.getFlexibleUpperBound());
        }
        if (qVar.hasFlexibleUpperBoundId()) {
            setFlexibleUpperBoundId(qVar.getFlexibleUpperBoundId());
        }
        if (qVar.hasClassName()) {
            setClassName(qVar.getClassName());
        }
        if (qVar.hasTypeParameter()) {
            setTypeParameter(qVar.getTypeParameter());
        }
        if (qVar.hasTypeParameterName()) {
            setTypeParameterName(qVar.getTypeParameterName());
        }
        if (qVar.hasTypeAliasName()) {
            setTypeAliasName(qVar.getTypeAliasName());
        }
        if (qVar.hasOuterType()) {
            mergeOuterType(qVar.getOuterType());
        }
        if (qVar.hasOuterTypeId()) {
            setOuterTypeId(qVar.getOuterTypeId());
        }
        if (qVar.hasAbbreviatedType()) {
            mergeAbbreviatedType(qVar.getAbbreviatedType());
        }
        if (qVar.hasAbbreviatedTypeId()) {
            setAbbreviatedTypeId(qVar.getAbbreviatedTypeId());
        }
        if (qVar.hasFlags()) {
            setFlags(qVar.getFlags());
        }
        b(qVar);
        setUnknownFields(getUnknownFields().concat(q.x(qVar)));
        return this;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x001d  */
    @Override // d0.e0.p.d.m0.i.a$a, d0.e0.p.d.m0.i.n$a
    public q$c mergeFrom(d0.e0.p.d.m0.i.d dVar, d0.e0.p.d.m0.i.e eVar) throws Throwable {
        q qVar = null;
        try {
            try {
                q partialFrom = q.k.parsePartialFrom(dVar, eVar);
                if (partialFrom != null) {
                    mergeFrom(partialFrom);
                }
                return this;
            } catch (InvalidProtocolBufferException e) {
                q qVar2 = (q) e.getUnfinishedMessage();
                try {
                    throw e;
                } catch (Throwable th) {
                    th = th;
                    qVar = qVar2;
                    if (qVar != null) {
                        mergeFrom(qVar);
                    }
                    throw th;
                }
            }
        } catch (Throwable th2) {
            th = th2;
            if (qVar != null) {
                mergeFrom(qVar);
            }
            throw th;
        }
    }
}
