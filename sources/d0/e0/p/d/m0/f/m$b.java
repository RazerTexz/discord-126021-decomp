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
public final class m$b extends g$c<m, m$b> implements d0.e0.p.d.m0.i.o {
    public int m;
    public p n = p.getDefaultInstance();
    public o o = o.getDefaultInstance();
    public l p = l.getDefaultInstance();
    public List<c> q = Collections.emptyList();

    @Override // d0.e0.p.d.m0.i.n$a
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.i.n build() {
        return build();
    }

    public m buildPartial() {
        m mVar = new m(this, null);
        int i = this.m;
        int i2 = (i & 1) != 1 ? 0 : 1;
        m.h(mVar, this.n);
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        m.i(mVar, this.o);
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        m.j(mVar, this.p);
        if ((this.m & 8) == 8) {
            this.q = Collections.unmodifiableList(this.q);
            this.m &= -9;
        }
        m.l(mVar, this.q);
        m.m(mVar, i2);
        return mVar;
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

    public m$b mergePackage(l lVar) {
        if ((this.m & 4) != 4 || this.p == l.getDefaultInstance()) {
            this.p = lVar;
        } else {
            this.p = l.newBuilder(this.p).mergeFrom(lVar).buildPartial();
        }
        this.m |= 4;
        return this;
    }

    public m$b mergeQualifiedNames(o oVar) {
        if ((this.m & 2) != 2 || this.o == o.getDefaultInstance()) {
            this.o = oVar;
        } else {
            this.o = o.newBuilder(this.o).mergeFrom(oVar).buildPartial();
        }
        this.m |= 2;
        return this;
    }

    public m$b mergeStrings(p pVar) {
        if ((this.m & 1) != 1 || this.n == p.getDefaultInstance()) {
            this.n = pVar;
        } else {
            this.n = p.newBuilder(this.n).mergeFrom(pVar).buildPartial();
        }
        this.m |= 1;
        return this;
    }

    @Override // d0.e0.p.d.m0.i.n$a
    public m build() {
        m mVarBuildPartial = buildPartial();
        if (mVarBuildPartial.isInitialized()) {
            return mVarBuildPartial;
        }
        throw new UninitializedMessageException(mVarBuildPartial);
    }

    @Override // d0.e0.p.d.m0.i.g$b
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.i.g$b clone() {
        return clone();
    }

    @Override // d0.e0.p.d.m0.i.g$b
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.i.g$b mergeFrom(d0.e0.p.d.m0.i.g gVar) {
        return mergeFrom((m) gVar);
    }

    @Override // d0.e0.p.d.m0.i.g$b
    public m$b clone() {
        return new m$b().mergeFrom(buildPartial());
    }

    @Override // d0.e0.p.d.m0.i.a$a, d0.e0.p.d.m0.i.n$a
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.i.n$a mergeFrom(d0.e0.p.d.m0.i.d dVar, d0.e0.p.d.m0.i.e eVar) throws IOException {
        return mergeFrom(dVar, eVar);
    }

    public m$b mergeFrom(m mVar) {
        if (mVar == m.getDefaultInstance()) {
            return this;
        }
        if (mVar.hasStrings()) {
            mergeStrings(mVar.getStrings());
        }
        if (mVar.hasQualifiedNames()) {
            mergeQualifiedNames(mVar.getQualifiedNames());
        }
        if (mVar.hasPackage()) {
            mergePackage(mVar.getPackage());
        }
        if (!m.k(mVar).isEmpty()) {
            if (this.q.isEmpty()) {
                this.q = m.k(mVar);
                this.m &= -9;
            } else {
                if ((this.m & 8) != 8) {
                    this.q = new ArrayList(this.q);
                    this.m |= 8;
                }
                this.q.addAll(m.k(mVar));
            }
        }
        b(mVar);
        setUnknownFields(getUnknownFields().concat(m.n(mVar)));
        return this;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x001d  */
    @Override // d0.e0.p.d.m0.i.a$a, d0.e0.p.d.m0.i.n$a
    public m$b mergeFrom(d0.e0.p.d.m0.i.d dVar, d0.e0.p.d.m0.i.e eVar) throws Throwable {
        m mVar = null;
        try {
            try {
                m partialFrom = m.k.parsePartialFrom(dVar, eVar);
                if (partialFrom != null) {
                    mergeFrom(partialFrom);
                }
                return this;
            } catch (InvalidProtocolBufferException e) {
                m mVar2 = (m) e.getUnfinishedMessage();
                try {
                    throw e;
                } catch (Throwable th) {
                    th = th;
                    mVar = mVar2;
                    if (mVar != null) {
                        mergeFrom(mVar);
                    }
                    throw th;
                }
            }
        } catch (Throwable th2) {
            th = th2;
            if (mVar != null) {
                mergeFrom(mVar);
            }
            throw th;
        }
    }
}
