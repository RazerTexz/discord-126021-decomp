package d0.e0.p.d.m0.f;

import d0.e0.p.d.m0.i.a$a;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.UninitializedMessageException;

/* JADX INFO: compiled from: ProtoBuf.java */
/* JADX INFO: loaded from: classes3.dex */
public final class h$b extends d0.e0.p.d.m0.i.g$b<h, h$b> implements d0.e0.p.d.m0.i.o {
    public int k;
    public int l;
    public int m;
    public int p;
    public h$c n = h$c.TRUE;
    public q o = q.getDefaultInstance();
    public List<h> q = Collections.emptyList();
    public List<h> r = Collections.emptyList();

    @Override // d0.e0.p.d.m0.i.n$a
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.i.n build() {
        return build();
    }

    public h buildPartial() {
        h hVar = new h(this, null);
        int i = this.k;
        int i2 = (i & 1) != 1 ? 0 : 1;
        h.a(hVar, this.l);
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        h.b(hVar, this.m);
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        h.c(hVar, this.n);
        if ((i & 8) == 8) {
            i2 |= 8;
        }
        h.d(hVar, this.o);
        if ((i & 16) == 16) {
            i2 |= 16;
        }
        h.e(hVar, this.p);
        if ((this.k & 32) == 32) {
            this.q = Collections.unmodifiableList(this.q);
            this.k &= -33;
        }
        h.g(hVar, this.q);
        if ((this.k & 64) == 64) {
            this.r = Collections.unmodifiableList(this.r);
            this.k &= -65;
        }
        h.i(hVar, this.r);
        h.j(hVar, i2);
        return hVar;
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

    public h$b mergeIsInstanceType(q qVar) {
        if ((this.k & 8) != 8 || this.o == q.getDefaultInstance()) {
            this.o = qVar;
        } else {
            this.o = q.newBuilder(this.o).mergeFrom(qVar).buildPartial();
        }
        this.k |= 8;
        return this;
    }

    public h$b setConstantValue(h$c h_c) {
        Objects.requireNonNull(h_c);
        this.k |= 4;
        this.n = h_c;
        return this;
    }

    public h$b setFlags(int i) {
        this.k |= 1;
        this.l = i;
        return this;
    }

    public h$b setIsInstanceTypeId(int i) {
        this.k |= 16;
        this.p = i;
        return this;
    }

    public h$b setValueParameterReference(int i) {
        this.k |= 2;
        this.m = i;
        return this;
    }

    @Override // d0.e0.p.d.m0.i.n$a
    public h build() {
        h hVarBuildPartial = buildPartial();
        if (hVarBuildPartial.isInitialized()) {
            return hVarBuildPartial;
        }
        throw new UninitializedMessageException(hVarBuildPartial);
    }

    @Override // d0.e0.p.d.m0.i.g$b
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.i.g$b clone() {
        return clone();
    }

    @Override // d0.e0.p.d.m0.i.g$b
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.i.g$b mergeFrom(d0.e0.p.d.m0.i.g gVar) {
        return mergeFrom((h) gVar);
    }

    @Override // d0.e0.p.d.m0.i.g$b
    public h$b clone() {
        return new h$b().mergeFrom(buildPartial());
    }

    @Override // d0.e0.p.d.m0.i.a$a, d0.e0.p.d.m0.i.n$a
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.i.n$a mergeFrom(d0.e0.p.d.m0.i.d dVar, d0.e0.p.d.m0.i.e eVar) throws IOException {
        return mergeFrom(dVar, eVar);
    }

    public h$b mergeFrom(h hVar) {
        if (hVar == h.getDefaultInstance()) {
            return this;
        }
        if (hVar.hasFlags()) {
            setFlags(hVar.getFlags());
        }
        if (hVar.hasValueParameterReference()) {
            setValueParameterReference(hVar.getValueParameterReference());
        }
        if (hVar.hasConstantValue()) {
            setConstantValue(hVar.getConstantValue());
        }
        if (hVar.hasIsInstanceType()) {
            mergeIsInstanceType(hVar.getIsInstanceType());
        }
        if (hVar.hasIsInstanceTypeId()) {
            setIsInstanceTypeId(hVar.getIsInstanceTypeId());
        }
        if (!h.f(hVar).isEmpty()) {
            if (this.q.isEmpty()) {
                this.q = h.f(hVar);
                this.k &= -33;
            } else {
                if ((this.k & 32) != 32) {
                    this.q = new ArrayList(this.q);
                    this.k |= 32;
                }
                this.q.addAll(h.f(hVar));
            }
        }
        if (!h.h(hVar).isEmpty()) {
            if (this.r.isEmpty()) {
                this.r = h.h(hVar);
                this.k &= -65;
            } else {
                if ((this.k & 64) != 64) {
                    this.r = new ArrayList(this.r);
                    this.k |= 64;
                }
                this.r.addAll(h.h(hVar));
            }
        }
        setUnknownFields(getUnknownFields().concat(h.k(hVar)));
        return this;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x001d  */
    @Override // d0.e0.p.d.m0.i.a$a, d0.e0.p.d.m0.i.n$a
    public h$b mergeFrom(d0.e0.p.d.m0.i.d dVar, d0.e0.p.d.m0.i.e eVar) throws Throwable {
        h hVar = null;
        try {
            try {
                h partialFrom = h.k.parsePartialFrom(dVar, eVar);
                if (partialFrom != null) {
                    mergeFrom(partialFrom);
                }
                return this;
            } catch (InvalidProtocolBufferException e) {
                h hVar2 = (h) e.getUnfinishedMessage();
                try {
                    throw e;
                } catch (Throwable th) {
                    th = th;
                    hVar = hVar2;
                    if (hVar != null) {
                        mergeFrom(hVar);
                    }
                    throw th;
                }
            }
        } catch (Throwable th2) {
            th = th2;
            if (hVar != null) {
                mergeFrom(hVar);
            }
            throw th;
        }
    }
}
