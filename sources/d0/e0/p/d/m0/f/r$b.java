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
public final class r$b extends g$c<r, r$b> implements d0.e0.p.d.m0.i.o {
    public int m;
    public int o;
    public int r;
    public int t;
    public int n = 6;
    public List<s> p = Collections.emptyList();
    public q q = q.getDefaultInstance();

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public q f3407s = q.getDefaultInstance();
    public List<b> u = Collections.emptyList();
    public List<Integer> v = Collections.emptyList();

    @Override // d0.e0.p.d.m0.i.n$a
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.i.n build() {
        return build();
    }

    public r buildPartial() {
        r rVar = new r(this, null);
        int i = this.m;
        int i2 = (i & 1) != 1 ? 0 : 1;
        r.h(rVar, this.n);
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        r.i(rVar, this.o);
        if ((this.m & 4) == 4) {
            this.p = Collections.unmodifiableList(this.p);
            this.m &= -5;
        }
        r.k(rVar, this.p);
        if ((i & 8) == 8) {
            i2 |= 4;
        }
        r.l(rVar, this.q);
        if ((i & 16) == 16) {
            i2 |= 8;
        }
        r.m(rVar, this.r);
        if ((i & 32) == 32) {
            i2 |= 16;
        }
        r.n(rVar, this.f3407s);
        if ((i & 64) == 64) {
            i2 |= 32;
        }
        r.o(rVar, this.t);
        if ((this.m & 128) == 128) {
            this.u = Collections.unmodifiableList(this.u);
            this.m &= -129;
        }
        r.q(rVar, this.u);
        if ((this.m & 256) == 256) {
            this.v = Collections.unmodifiableList(this.v);
            this.m &= -257;
        }
        r.s(rVar, this.v);
        r.t(rVar, i2);
        return rVar;
    }

    @Override // d0.e0.p.d.m0.i.g$b
    /* JADX INFO: renamed from: clone */
    public /* bridge */ /* synthetic */ Object mo88clone() throws CloneNotSupportedException {
        return clone();
    }

    public r$b mergeExpandedType(q qVar) {
        if ((this.m & 32) != 32 || this.f3407s == q.getDefaultInstance()) {
            this.f3407s = qVar;
        } else {
            this.f3407s = q.newBuilder(this.f3407s).mergeFrom(qVar).buildPartial();
        }
        this.m |= 32;
        return this;
    }

    @Override // d0.e0.p.d.m0.i.a$a, d0.e0.p.d.m0.i.n$a
    public /* bridge */ /* synthetic */ a$a mergeFrom(d0.e0.p.d.m0.i.d dVar, d0.e0.p.d.m0.i.e eVar) throws IOException {
        return mergeFrom(dVar, eVar);
    }

    public r$b mergeUnderlyingType(q qVar) {
        if ((this.m & 8) != 8 || this.q == q.getDefaultInstance()) {
            this.q = qVar;
        } else {
            this.q = q.newBuilder(this.q).mergeFrom(qVar).buildPartial();
        }
        this.m |= 8;
        return this;
    }

    public r$b setExpandedTypeId(int i) {
        this.m |= 64;
        this.t = i;
        return this;
    }

    public r$b setFlags(int i) {
        this.m |= 1;
        this.n = i;
        return this;
    }

    public r$b setName(int i) {
        this.m |= 2;
        this.o = i;
        return this;
    }

    public r$b setUnderlyingTypeId(int i) {
        this.m |= 16;
        this.r = i;
        return this;
    }

    @Override // d0.e0.p.d.m0.i.n$a
    public r build() {
        r rVarBuildPartial = buildPartial();
        if (rVarBuildPartial.isInitialized()) {
            return rVarBuildPartial;
        }
        throw new UninitializedMessageException(rVarBuildPartial);
    }

    @Override // d0.e0.p.d.m0.i.g$b
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.i.g$b clone() {
        return clone();
    }

    @Override // d0.e0.p.d.m0.i.g$b
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.i.g$b mergeFrom(d0.e0.p.d.m0.i.g gVar) {
        return mergeFrom((r) gVar);
    }

    @Override // d0.e0.p.d.m0.i.g$b
    public r$b clone() {
        return new r$b().mergeFrom(buildPartial());
    }

    @Override // d0.e0.p.d.m0.i.a$a, d0.e0.p.d.m0.i.n$a
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.i.n$a mergeFrom(d0.e0.p.d.m0.i.d dVar, d0.e0.p.d.m0.i.e eVar) throws IOException {
        return mergeFrom(dVar, eVar);
    }

    public r$b mergeFrom(r rVar) {
        if (rVar == r.getDefaultInstance()) {
            return this;
        }
        if (rVar.hasFlags()) {
            setFlags(rVar.getFlags());
        }
        if (rVar.hasName()) {
            setName(rVar.getName());
        }
        if (!r.j(rVar).isEmpty()) {
            if (this.p.isEmpty()) {
                this.p = r.j(rVar);
                this.m &= -5;
            } else {
                if ((this.m & 4) != 4) {
                    this.p = new ArrayList(this.p);
                    this.m |= 4;
                }
                this.p.addAll(r.j(rVar));
            }
        }
        if (rVar.hasUnderlyingType()) {
            mergeUnderlyingType(rVar.getUnderlyingType());
        }
        if (rVar.hasUnderlyingTypeId()) {
            setUnderlyingTypeId(rVar.getUnderlyingTypeId());
        }
        if (rVar.hasExpandedType()) {
            mergeExpandedType(rVar.getExpandedType());
        }
        if (rVar.hasExpandedTypeId()) {
            setExpandedTypeId(rVar.getExpandedTypeId());
        }
        if (!r.p(rVar).isEmpty()) {
            if (this.u.isEmpty()) {
                this.u = r.p(rVar);
                this.m &= -129;
            } else {
                if ((this.m & 128) != 128) {
                    this.u = new ArrayList(this.u);
                    this.m |= 128;
                }
                this.u.addAll(r.p(rVar));
            }
        }
        if (!r.r(rVar).isEmpty()) {
            if (this.v.isEmpty()) {
                this.v = r.r(rVar);
                this.m &= -257;
            } else {
                if ((this.m & 256) != 256) {
                    this.v = new ArrayList(this.v);
                    this.m |= 256;
                }
                this.v.addAll(r.r(rVar));
            }
        }
        b(rVar);
        setUnknownFields(getUnknownFields().concat(r.u(rVar)));
        return this;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x001d  */
    @Override // d0.e0.p.d.m0.i.a$a, d0.e0.p.d.m0.i.n$a
    public r$b mergeFrom(d0.e0.p.d.m0.i.d dVar, d0.e0.p.d.m0.i.e eVar) throws Throwable {
        r rVar = null;
        try {
            try {
                r partialFrom = r.k.parsePartialFrom(dVar, eVar);
                if (partialFrom != null) {
                    mergeFrom(partialFrom);
                }
                return this;
            } catch (InvalidProtocolBufferException e) {
                r rVar2 = (r) e.getUnfinishedMessage();
                try {
                    throw e;
                } catch (Throwable th) {
                    th = th;
                    rVar = rVar2;
                    if (rVar != null) {
                        mergeFrom(rVar);
                    }
                    throw th;
                }
            }
        } catch (Throwable th2) {
            th = th2;
            if (rVar != null) {
                mergeFrom(rVar);
            }
            throw th;
        }
    }
}
