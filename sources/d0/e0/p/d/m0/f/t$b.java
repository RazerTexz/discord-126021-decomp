package d0.e0.p.d.m0.f;

import d0.e0.p.d.m0.i.a$a;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.UninitializedMessageException;

/* JADX INFO: compiled from: ProtoBuf.java */
/* JADX INFO: loaded from: classes3.dex */
public final class t$b extends d0.e0.p.d.m0.i.g$b<t, t$b> implements d0.e0.p.d.m0.i.o {
    public int k;
    public List<q> l = Collections.emptyList();
    public int m = -1;

    @Override // d0.e0.p.d.m0.i.n$a
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.i.n build() {
        return build();
    }

    public t buildPartial() {
        t tVar = new t(this, null);
        int i = this.k;
        if ((i & 1) == 1) {
            this.l = Collections.unmodifiableList(this.l);
            this.k &= -2;
        }
        t.b(tVar, this.l);
        int i2 = (i & 2) != 2 ? 0 : 1;
        t.c(tVar, this.m);
        t.d(tVar, i2);
        return tVar;
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

    public t$b setFirstNullable(int i) {
        this.k |= 2;
        this.m = i;
        return this;
    }

    @Override // d0.e0.p.d.m0.i.n$a
    public t build() {
        t tVarBuildPartial = buildPartial();
        if (tVarBuildPartial.isInitialized()) {
            return tVarBuildPartial;
        }
        throw new UninitializedMessageException(tVarBuildPartial);
    }

    @Override // d0.e0.p.d.m0.i.g$b
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.i.g$b clone() {
        return clone();
    }

    @Override // d0.e0.p.d.m0.i.g$b
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.i.g$b mergeFrom(d0.e0.p.d.m0.i.g gVar) {
        return mergeFrom((t) gVar);
    }

    @Override // d0.e0.p.d.m0.i.g$b
    public t$b clone() {
        return new t$b().mergeFrom(buildPartial());
    }

    @Override // d0.e0.p.d.m0.i.a$a, d0.e0.p.d.m0.i.n$a
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.i.n$a mergeFrom(d0.e0.p.d.m0.i.d dVar, d0.e0.p.d.m0.i.e eVar) throws IOException {
        return mergeFrom(dVar, eVar);
    }

    public t$b mergeFrom(t tVar) {
        if (tVar == t.getDefaultInstance()) {
            return this;
        }
        if (!t.a(tVar).isEmpty()) {
            if (this.l.isEmpty()) {
                this.l = t.a(tVar);
                this.k &= -2;
            } else {
                if ((this.k & 1) != 1) {
                    this.l = new ArrayList(this.l);
                    this.k |= 1;
                }
                this.l.addAll(t.a(tVar));
            }
        }
        if (tVar.hasFirstNullable()) {
            setFirstNullable(tVar.getFirstNullable());
        }
        setUnknownFields(getUnknownFields().concat(t.e(tVar)));
        return this;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x001d  */
    @Override // d0.e0.p.d.m0.i.a$a, d0.e0.p.d.m0.i.n$a
    public t$b mergeFrom(d0.e0.p.d.m0.i.d dVar, d0.e0.p.d.m0.i.e eVar) throws Throwable {
        t tVar = null;
        try {
            try {
                t partialFrom = t.k.parsePartialFrom(dVar, eVar);
                if (partialFrom != null) {
                    mergeFrom(partialFrom);
                }
                return this;
            } catch (InvalidProtocolBufferException e) {
                t tVar2 = (t) e.getUnfinishedMessage();
                try {
                    throw e;
                } catch (Throwable th) {
                    th = th;
                    tVar = tVar2;
                    if (tVar != null) {
                        mergeFrom(tVar);
                    }
                    throw th;
                }
            }
        } catch (Throwable th2) {
            th = th2;
            if (tVar != null) {
                mergeFrom(tVar);
            }
            throw th;
        }
    }
}
