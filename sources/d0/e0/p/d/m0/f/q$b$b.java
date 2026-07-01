package d0.e0.p.d.m0.f;

import d0.e0.p.d.m0.i.a$a;
import java.io.IOException;
import java.util.Objects;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.UninitializedMessageException;

/* JADX INFO: compiled from: ProtoBuf.java */
/* JADX INFO: loaded from: classes3.dex */
public final class q$b$b extends d0.e0.p.d.m0.i.g$b<q$b, q$b$b> implements d0.e0.p.d.m0.i.o {
    public int k;
    public q$b$c l = q$b$c.INV;
    public q m = q.getDefaultInstance();
    public int n;

    @Override // d0.e0.p.d.m0.i.n$a
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.i.n build() {
        return build();
    }

    public q$b buildPartial() {
        q$b q_b = new q$b(this, null);
        int i = this.k;
        int i2 = (i & 1) != 1 ? 0 : 1;
        q$b.a(q_b, this.l);
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        q$b.b(q_b, this.m);
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        q$b.c(q_b, this.n);
        q$b.d(q_b, i2);
        return q_b;
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

    public q$b$b mergeType(q qVar) {
        if ((this.k & 2) != 2 || this.m == q.getDefaultInstance()) {
            this.m = qVar;
        } else {
            this.m = q.newBuilder(this.m).mergeFrom(qVar).buildPartial();
        }
        this.k |= 2;
        return this;
    }

    public q$b$b setProjection(q$b$c q_b_c) {
        Objects.requireNonNull(q_b_c);
        this.k |= 1;
        this.l = q_b_c;
        return this;
    }

    public q$b$b setTypeId(int i) {
        this.k |= 4;
        this.n = i;
        return this;
    }

    @Override // d0.e0.p.d.m0.i.n$a
    public q$b build() {
        q$b q_bBuildPartial = buildPartial();
        if (q_bBuildPartial.isInitialized()) {
            return q_bBuildPartial;
        }
        throw new UninitializedMessageException(q_bBuildPartial);
    }

    @Override // d0.e0.p.d.m0.i.g$b
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.i.g$b clone() {
        return clone();
    }

    @Override // d0.e0.p.d.m0.i.g$b
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.i.g$b mergeFrom(d0.e0.p.d.m0.i.g gVar) {
        return mergeFrom((q$b) gVar);
    }

    @Override // d0.e0.p.d.m0.i.g$b
    public q$b$b clone() {
        return new q$b$b().mergeFrom(buildPartial());
    }

    @Override // d0.e0.p.d.m0.i.a$a, d0.e0.p.d.m0.i.n$a
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.i.n$a mergeFrom(d0.e0.p.d.m0.i.d dVar, d0.e0.p.d.m0.i.e eVar) throws IOException {
        return mergeFrom(dVar, eVar);
    }

    public q$b$b mergeFrom(q$b q_b) {
        if (q_b == q$b.getDefaultInstance()) {
            return this;
        }
        if (q_b.hasProjection()) {
            setProjection(q_b.getProjection());
        }
        if (q_b.hasType()) {
            mergeType(q_b.getType());
        }
        if (q_b.hasTypeId()) {
            setTypeId(q_b.getTypeId());
        }
        setUnknownFields(getUnknownFields().concat(q$b.e(q_b)));
        return this;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x001d  */
    @Override // d0.e0.p.d.m0.i.a$a, d0.e0.p.d.m0.i.n$a
    public q$b$b mergeFrom(d0.e0.p.d.m0.i.d dVar, d0.e0.p.d.m0.i.e eVar) throws Throwable {
        q$b q_b = null;
        try {
            try {
                q$b partialFrom = q$b.k.parsePartialFrom(dVar, eVar);
                if (partialFrom != null) {
                    mergeFrom(partialFrom);
                }
                return this;
            } catch (InvalidProtocolBufferException e) {
                q$b q_b2 = (q$b) e.getUnfinishedMessage();
                try {
                    throw e;
                } catch (Throwable th) {
                    th = th;
                    q_b = q_b2;
                    if (q_b != null) {
                        mergeFrom(q_b);
                    }
                    throw th;
                }
            }
        } catch (Throwable th2) {
            th = th2;
            if (q_b != null) {
                mergeFrom(q_b);
            }
            throw th;
        }
    }
}
