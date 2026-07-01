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
public final class d$b extends g$c<d, d$b> implements d0.e0.p.d.m0.i.o {
    public int m;
    public int n = 6;
    public List<u> o = Collections.emptyList();
    public List<Integer> p = Collections.emptyList();

    @Override // d0.e0.p.d.m0.i.n$a
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.i.n build() {
        return build();
    }

    public d buildPartial() {
        d dVar = new d(this, null);
        int i = (this.m & 1) != 1 ? 0 : 1;
        d.h(dVar, this.n);
        if ((this.m & 2) == 2) {
            this.o = Collections.unmodifiableList(this.o);
            this.m &= -3;
        }
        d.j(dVar, this.o);
        if ((this.m & 4) == 4) {
            this.p = Collections.unmodifiableList(this.p);
            this.m &= -5;
        }
        d.l(dVar, this.p);
        d.m(dVar, i);
        return dVar;
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

    public d$b setFlags(int i) {
        this.m |= 1;
        this.n = i;
        return this;
    }

    @Override // d0.e0.p.d.m0.i.n$a
    public d build() {
        d dVarBuildPartial = buildPartial();
        if (dVarBuildPartial.isInitialized()) {
            return dVarBuildPartial;
        }
        throw new UninitializedMessageException(dVarBuildPartial);
    }

    @Override // d0.e0.p.d.m0.i.g$b
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.i.g$b clone() {
        return clone();
    }

    @Override // d0.e0.p.d.m0.i.g$b
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.i.g$b mergeFrom(d0.e0.p.d.m0.i.g gVar) {
        return mergeFrom((d) gVar);
    }

    @Override // d0.e0.p.d.m0.i.g$b
    public d$b clone() {
        return new d$b().mergeFrom(buildPartial());
    }

    @Override // d0.e0.p.d.m0.i.a$a, d0.e0.p.d.m0.i.n$a
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.i.n$a mergeFrom(d0.e0.p.d.m0.i.d dVar, d0.e0.p.d.m0.i.e eVar) throws IOException {
        return mergeFrom(dVar, eVar);
    }

    public d$b mergeFrom(d dVar) {
        if (dVar == d.getDefaultInstance()) {
            return this;
        }
        if (dVar.hasFlags()) {
            setFlags(dVar.getFlags());
        }
        if (!d.i(dVar).isEmpty()) {
            if (this.o.isEmpty()) {
                this.o = d.i(dVar);
                this.m &= -3;
            } else {
                if ((this.m & 2) != 2) {
                    this.o = new ArrayList(this.o);
                    this.m |= 2;
                }
                this.o.addAll(d.i(dVar));
            }
        }
        if (!d.k(dVar).isEmpty()) {
            if (this.p.isEmpty()) {
                this.p = d.k(dVar);
                this.m &= -5;
            } else {
                if ((this.m & 4) != 4) {
                    this.p = new ArrayList(this.p);
                    this.m |= 4;
                }
                this.p.addAll(d.k(dVar));
            }
        }
        b(dVar);
        setUnknownFields(getUnknownFields().concat(d.n(dVar)));
        return this;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x001d  */
    @Override // d0.e0.p.d.m0.i.a$a, d0.e0.p.d.m0.i.n$a
    public d$b mergeFrom(d0.e0.p.d.m0.i.d dVar, d0.e0.p.d.m0.i.e eVar) throws Throwable {
        d dVar2 = null;
        try {
            try {
                d partialFrom = d.k.parsePartialFrom(dVar, eVar);
                if (partialFrom != null) {
                    mergeFrom(partialFrom);
                }
                return this;
            } catch (InvalidProtocolBufferException e) {
                d dVar3 = (d) e.getUnfinishedMessage();
                try {
                    throw e;
                } catch (Throwable th) {
                    th = th;
                    dVar2 = dVar3;
                    if (dVar2 != null) {
                        mergeFrom(dVar2);
                    }
                    throw th;
                }
            }
        } catch (Throwable th2) {
            th = th2;
            if (dVar2 != null) {
                mergeFrom(dVar2);
            }
            throw th;
        }
    }
}
