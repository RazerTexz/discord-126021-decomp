package d0.e0.p.d.m0.f;

import d0.e0.p.d.m0.i.a$a;
import d0.e0.p.d.m0.i.g$c;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.UninitializedMessageException;

/* JADX INFO: compiled from: ProtoBuf.java */
/* JADX INFO: loaded from: classes3.dex */
public final class s$b extends g$c<s, s$b> implements d0.e0.p.d.m0.i.o {
    public int m;
    public int n;
    public int o;
    public boolean p;
    public s$c q = s$c.INV;
    public List<q> r = Collections.emptyList();

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public List<Integer> f3408s = Collections.emptyList();

    @Override // d0.e0.p.d.m0.i.n$a
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.i.n build() {
        return build();
    }

    public s buildPartial() {
        s sVar = new s(this, null);
        int i = this.m;
        int i2 = (i & 1) != 1 ? 0 : 1;
        s.h(sVar, this.n);
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        s.i(sVar, this.o);
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        s.j(sVar, this.p);
        if ((i & 8) == 8) {
            i2 |= 8;
        }
        s.k(sVar, this.q);
        if ((this.m & 16) == 16) {
            this.r = Collections.unmodifiableList(this.r);
            this.m &= -17;
        }
        s.m(sVar, this.r);
        if ((this.m & 32) == 32) {
            this.f3408s = Collections.unmodifiableList(this.f3408s);
            this.m &= -33;
        }
        s.o(sVar, this.f3408s);
        s.p(sVar, i2);
        return sVar;
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

    public s$b setId(int i) {
        this.m |= 1;
        this.n = i;
        return this;
    }

    public s$b setName(int i) {
        this.m |= 2;
        this.o = i;
        return this;
    }

    public s$b setReified(boolean z2) {
        this.m |= 4;
        this.p = z2;
        return this;
    }

    public s$b setVariance(s$c s_c) {
        Objects.requireNonNull(s_c);
        this.m |= 8;
        this.q = s_c;
        return this;
    }

    @Override // d0.e0.p.d.m0.i.n$a
    public s build() {
        s sVarBuildPartial = buildPartial();
        if (sVarBuildPartial.isInitialized()) {
            return sVarBuildPartial;
        }
        throw new UninitializedMessageException(sVarBuildPartial);
    }

    @Override // d0.e0.p.d.m0.i.g$b
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.i.g$b clone() {
        return clone();
    }

    @Override // d0.e0.p.d.m0.i.g$b
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.i.g$b mergeFrom(d0.e0.p.d.m0.i.g gVar) {
        return mergeFrom((s) gVar);
    }

    @Override // d0.e0.p.d.m0.i.g$b
    public s$b clone() {
        return new s$b().mergeFrom(buildPartial());
    }

    @Override // d0.e0.p.d.m0.i.a$a, d0.e0.p.d.m0.i.n$a
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.i.n$a mergeFrom(d0.e0.p.d.m0.i.d dVar, d0.e0.p.d.m0.i.e eVar) throws IOException {
        return mergeFrom(dVar, eVar);
    }

    public s$b mergeFrom(s sVar) {
        if (sVar == s.getDefaultInstance()) {
            return this;
        }
        if (sVar.hasId()) {
            setId(sVar.getId());
        }
        if (sVar.hasName()) {
            setName(sVar.getName());
        }
        if (sVar.hasReified()) {
            setReified(sVar.getReified());
        }
        if (sVar.hasVariance()) {
            setVariance(sVar.getVariance());
        }
        if (!s.l(sVar).isEmpty()) {
            if (this.r.isEmpty()) {
                this.r = s.l(sVar);
                this.m &= -17;
            } else {
                if ((this.m & 16) != 16) {
                    this.r = new ArrayList(this.r);
                    this.m |= 16;
                }
                this.r.addAll(s.l(sVar));
            }
        }
        if (!s.n(sVar).isEmpty()) {
            if (this.f3408s.isEmpty()) {
                this.f3408s = s.n(sVar);
                this.m &= -33;
            } else {
                if ((this.m & 32) != 32) {
                    this.f3408s = new ArrayList(this.f3408s);
                    this.m |= 32;
                }
                this.f3408s.addAll(s.n(sVar));
            }
        }
        b(sVar);
        setUnknownFields(getUnknownFields().concat(s.q(sVar)));
        return this;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x001d  */
    @Override // d0.e0.p.d.m0.i.a$a, d0.e0.p.d.m0.i.n$a
    public s$b mergeFrom(d0.e0.p.d.m0.i.d dVar, d0.e0.p.d.m0.i.e eVar) throws Throwable {
        s sVar = null;
        try {
            try {
                s partialFrom = s.k.parsePartialFrom(dVar, eVar);
                if (partialFrom != null) {
                    mergeFrom(partialFrom);
                }
                return this;
            } catch (InvalidProtocolBufferException e) {
                s sVar2 = (s) e.getUnfinishedMessage();
                try {
                    throw e;
                } catch (Throwable th) {
                    th = th;
                    sVar = sVar2;
                    if (sVar != null) {
                        mergeFrom(sVar);
                    }
                    throw th;
                }
            }
        } catch (Throwable th2) {
            th = th2;
            if (sVar != null) {
                mergeFrom(sVar);
            }
            throw th;
        }
    }
}
