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
public final class l$b extends g$c<l, l$b> implements d0.e0.p.d.m0.i.o {
    public int m;
    public List<i> n = Collections.emptyList();
    public List<n> o = Collections.emptyList();
    public List<r> p = Collections.emptyList();
    public t q = t.getDefaultInstance();
    public w r = w.getDefaultInstance();

    @Override // d0.e0.p.d.m0.i.n$a
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.i.n build() {
        return build();
    }

    public l buildPartial() {
        l lVar = new l(this, null);
        int i = this.m;
        if ((i & 1) == 1) {
            this.n = Collections.unmodifiableList(this.n);
            this.m &= -2;
        }
        l.i(lVar, this.n);
        if ((this.m & 2) == 2) {
            this.o = Collections.unmodifiableList(this.o);
            this.m &= -3;
        }
        l.k(lVar, this.o);
        if ((this.m & 4) == 4) {
            this.p = Collections.unmodifiableList(this.p);
            this.m &= -5;
        }
        l.m(lVar, this.p);
        int i2 = (i & 8) != 8 ? 0 : 1;
        l.n(lVar, this.q);
        if ((i & 16) == 16) {
            i2 |= 2;
        }
        l.o(lVar, this.r);
        l.p(lVar, i2);
        return lVar;
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

    public l$b mergeTypeTable(t tVar) {
        if ((this.m & 8) != 8 || this.q == t.getDefaultInstance()) {
            this.q = tVar;
        } else {
            this.q = t.newBuilder(this.q).mergeFrom(tVar).buildPartial();
        }
        this.m |= 8;
        return this;
    }

    public l$b mergeVersionRequirementTable(w wVar) {
        if ((this.m & 16) != 16 || this.r == w.getDefaultInstance()) {
            this.r = wVar;
        } else {
            this.r = w.newBuilder(this.r).mergeFrom(wVar).buildPartial();
        }
        this.m |= 16;
        return this;
    }

    @Override // d0.e0.p.d.m0.i.n$a
    public l build() {
        l lVarBuildPartial = buildPartial();
        if (lVarBuildPartial.isInitialized()) {
            return lVarBuildPartial;
        }
        throw new UninitializedMessageException(lVarBuildPartial);
    }

    @Override // d0.e0.p.d.m0.i.g$b
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.i.g$b clone() {
        return clone();
    }

    @Override // d0.e0.p.d.m0.i.g$b
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.i.g$b mergeFrom(d0.e0.p.d.m0.i.g gVar) {
        return mergeFrom((l) gVar);
    }

    @Override // d0.e0.p.d.m0.i.g$b
    public l$b clone() {
        return new l$b().mergeFrom(buildPartial());
    }

    @Override // d0.e0.p.d.m0.i.a$a, d0.e0.p.d.m0.i.n$a
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.i.n$a mergeFrom(d0.e0.p.d.m0.i.d dVar, d0.e0.p.d.m0.i.e eVar) throws IOException {
        return mergeFrom(dVar, eVar);
    }

    public l$b mergeFrom(l lVar) {
        if (lVar == l.getDefaultInstance()) {
            return this;
        }
        if (!l.h(lVar).isEmpty()) {
            if (this.n.isEmpty()) {
                this.n = l.h(lVar);
                this.m &= -2;
            } else {
                if ((this.m & 1) != 1) {
                    this.n = new ArrayList(this.n);
                    this.m |= 1;
                }
                this.n.addAll(l.h(lVar));
            }
        }
        if (!l.j(lVar).isEmpty()) {
            if (this.o.isEmpty()) {
                this.o = l.j(lVar);
                this.m &= -3;
            } else {
                if ((this.m & 2) != 2) {
                    this.o = new ArrayList(this.o);
                    this.m |= 2;
                }
                this.o.addAll(l.j(lVar));
            }
        }
        if (!l.l(lVar).isEmpty()) {
            if (this.p.isEmpty()) {
                this.p = l.l(lVar);
                this.m &= -5;
            } else {
                if ((this.m & 4) != 4) {
                    this.p = new ArrayList(this.p);
                    this.m |= 4;
                }
                this.p.addAll(l.l(lVar));
            }
        }
        if (lVar.hasTypeTable()) {
            mergeTypeTable(lVar.getTypeTable());
        }
        if (lVar.hasVersionRequirementTable()) {
            mergeVersionRequirementTable(lVar.getVersionRequirementTable());
        }
        b(lVar);
        setUnknownFields(getUnknownFields().concat(l.q(lVar)));
        return this;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x001d  */
    @Override // d0.e0.p.d.m0.i.a$a, d0.e0.p.d.m0.i.n$a
    public l$b mergeFrom(d0.e0.p.d.m0.i.d dVar, d0.e0.p.d.m0.i.e eVar) throws Throwable {
        l lVar = null;
        try {
            try {
                l partialFrom = l.k.parsePartialFrom(dVar, eVar);
                if (partialFrom != null) {
                    mergeFrom(partialFrom);
                }
                return this;
            } catch (InvalidProtocolBufferException e) {
                l lVar2 = (l) e.getUnfinishedMessage();
                try {
                    throw e;
                } catch (Throwable th) {
                    th = th;
                    lVar = lVar2;
                    if (lVar != null) {
                        mergeFrom(lVar);
                    }
                    throw th;
                }
            }
        } catch (Throwable th2) {
            th = th2;
            if (lVar != null) {
                mergeFrom(lVar);
            }
            throw th;
        }
    }
}
