package d0.e0.p.d.m0.f;

import d0.e0.p.d.m0.i.a$a;
import java.io.IOException;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.UninitializedMessageException;

/* JADX INFO: compiled from: ProtoBuf.java */
/* JADX INFO: loaded from: classes3.dex */
public final class b$b$b extends d0.e0.p.d.m0.i.g$b<b$b, b$b$b> implements d0.e0.p.d.m0.i.o {
    public int k;
    public int l;
    public b$b$c m = b$b$c.getDefaultInstance();

    @Override // d0.e0.p.d.m0.i.n$a
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.i.n build() {
        return build();
    }

    public b$b buildPartial() {
        b$b b_b = new b$b(this, null);
        int i = this.k;
        int i2 = (i & 1) != 1 ? 0 : 1;
        b$b.a(b_b, this.l);
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        b$b.b(b_b, this.m);
        b$b.c(b_b, i2);
        return b_b;
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

    public b$b$b mergeValue(b$b$c b_b_c) {
        if ((this.k & 2) != 2 || this.m == b$b$c.getDefaultInstance()) {
            this.m = b_b_c;
        } else {
            this.m = b$b$c.newBuilder(this.m).mergeFrom(b_b_c).buildPartial();
        }
        this.k |= 2;
        return this;
    }

    public b$b$b setNameId(int i) {
        this.k |= 1;
        this.l = i;
        return this;
    }

    @Override // d0.e0.p.d.m0.i.n$a
    public b$b build() {
        b$b b_bBuildPartial = buildPartial();
        if (b_bBuildPartial.isInitialized()) {
            return b_bBuildPartial;
        }
        throw new UninitializedMessageException(b_bBuildPartial);
    }

    @Override // d0.e0.p.d.m0.i.g$b
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.i.g$b clone() {
        return clone();
    }

    @Override // d0.e0.p.d.m0.i.g$b
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.i.g$b mergeFrom(d0.e0.p.d.m0.i.g gVar) {
        return mergeFrom((b$b) gVar);
    }

    @Override // d0.e0.p.d.m0.i.g$b
    public b$b$b clone() {
        return new b$b$b().mergeFrom(buildPartial());
    }

    @Override // d0.e0.p.d.m0.i.a$a, d0.e0.p.d.m0.i.n$a
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.i.n$a mergeFrom(d0.e0.p.d.m0.i.d dVar, d0.e0.p.d.m0.i.e eVar) throws IOException {
        return mergeFrom(dVar, eVar);
    }

    public b$b$b mergeFrom(b$b b_b) {
        if (b_b == b$b.getDefaultInstance()) {
            return this;
        }
        if (b_b.hasNameId()) {
            setNameId(b_b.getNameId());
        }
        if (b_b.hasValue()) {
            mergeValue(b_b.getValue());
        }
        setUnknownFields(getUnknownFields().concat(b$b.d(b_b)));
        return this;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x001d  */
    @Override // d0.e0.p.d.m0.i.a$a, d0.e0.p.d.m0.i.n$a
    public b$b$b mergeFrom(d0.e0.p.d.m0.i.d dVar, d0.e0.p.d.m0.i.e eVar) throws Throwable {
        b$b b_b = null;
        try {
            try {
                b$b partialFrom = b$b.k.parsePartialFrom(dVar, eVar);
                if (partialFrom != null) {
                    mergeFrom(partialFrom);
                }
                return this;
            } catch (InvalidProtocolBufferException e) {
                b$b b_b2 = (b$b) e.getUnfinishedMessage();
                try {
                    throw e;
                } catch (Throwable th) {
                    th = th;
                    b_b = b_b2;
                    if (b_b != null) {
                        mergeFrom(b_b);
                    }
                    throw th;
                }
            }
        } catch (Throwable th2) {
            th = th2;
            if (b_b != null) {
                mergeFrom(b_b);
            }
            throw th;
        }
    }
}
