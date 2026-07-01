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
public final class b$b$c$b extends d0.e0.p.d.m0.i.g$b<b$b$c, b$b$c$b> implements d0.e0.p.d.m0.i.o {
    public int k;
    public long m;
    public float n;
    public double o;
    public int p;
    public int q;
    public int r;
    public int u;
    public int v;
    public b$b$c$c l = b$b$c$c.BYTE;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public b f3391s = b.getDefaultInstance();
    public List<b$b$c> t = Collections.emptyList();

    @Override // d0.e0.p.d.m0.i.n$a
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.i.n build() {
        return build();
    }

    public b$b$c buildPartial() {
        b$b$c b_b_c = new b$b$c(this, null);
        int i = this.k;
        int i2 = (i & 1) != 1 ? 0 : 1;
        b$b$c.a(b_b_c, this.l);
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        b$b$c.b(b_b_c, this.m);
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        b$b$c.c(b_b_c, this.n);
        if ((i & 8) == 8) {
            i2 |= 8;
        }
        b$b$c.d(b_b_c, this.o);
        if ((i & 16) == 16) {
            i2 |= 16;
        }
        b$b$c.e(b_b_c, this.p);
        if ((i & 32) == 32) {
            i2 |= 32;
        }
        b$b$c.f(b_b_c, this.q);
        if ((i & 64) == 64) {
            i2 |= 64;
        }
        b$b$c.g(b_b_c, this.r);
        if ((i & 128) == 128) {
            i2 |= 128;
        }
        b$b$c.h(b_b_c, this.f3391s);
        if ((this.k & 256) == 256) {
            this.t = Collections.unmodifiableList(this.t);
            this.k &= -257;
        }
        b$b$c.j(b_b_c, this.t);
        if ((i & 512) == 512) {
            i2 |= 256;
        }
        b$b$c.k(b_b_c, this.u);
        if ((i & 1024) == 1024) {
            i2 |= 512;
        }
        b$b$c.l(b_b_c, this.v);
        b$b$c.m(b_b_c, i2);
        return b_b_c;
    }

    @Override // d0.e0.p.d.m0.i.g$b
    /* JADX INFO: renamed from: clone */
    public /* bridge */ /* synthetic */ Object mo88clone() throws CloneNotSupportedException {
        return clone();
    }

    public b$b$c$b mergeAnnotation(b bVar) {
        if ((this.k & 128) != 128 || this.f3391s == b.getDefaultInstance()) {
            this.f3391s = bVar;
        } else {
            this.f3391s = b.newBuilder(this.f3391s).mergeFrom(bVar).buildPartial();
        }
        this.k |= 128;
        return this;
    }

    @Override // d0.e0.p.d.m0.i.a$a, d0.e0.p.d.m0.i.n$a
    public /* bridge */ /* synthetic */ a$a mergeFrom(d0.e0.p.d.m0.i.d dVar, d0.e0.p.d.m0.i.e eVar) throws IOException {
        return mergeFrom(dVar, eVar);
    }

    public b$b$c$b setArrayDimensionCount(int i) {
        this.k |= 512;
        this.u = i;
        return this;
    }

    public b$b$c$b setClassId(int i) {
        this.k |= 32;
        this.q = i;
        return this;
    }

    public b$b$c$b setDoubleValue(double d) {
        this.k |= 8;
        this.o = d;
        return this;
    }

    public b$b$c$b setEnumValueId(int i) {
        this.k |= 64;
        this.r = i;
        return this;
    }

    public b$b$c$b setFlags(int i) {
        this.k |= 1024;
        this.v = i;
        return this;
    }

    public b$b$c$b setFloatValue(float f) {
        this.k |= 4;
        this.n = f;
        return this;
    }

    public b$b$c$b setIntValue(long j) {
        this.k |= 2;
        this.m = j;
        return this;
    }

    public b$b$c$b setStringValue(int i) {
        this.k |= 16;
        this.p = i;
        return this;
    }

    public b$b$c$b setType(b$b$c$c b_b_c_c) {
        Objects.requireNonNull(b_b_c_c);
        this.k |= 1;
        this.l = b_b_c_c;
        return this;
    }

    @Override // d0.e0.p.d.m0.i.n$a
    public b$b$c build() {
        b$b$c b_b_cBuildPartial = buildPartial();
        if (b_b_cBuildPartial.isInitialized()) {
            return b_b_cBuildPartial;
        }
        throw new UninitializedMessageException(b_b_cBuildPartial);
    }

    @Override // d0.e0.p.d.m0.i.g$b
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.i.g$b clone() {
        return clone();
    }

    @Override // d0.e0.p.d.m0.i.g$b
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.i.g$b mergeFrom(d0.e0.p.d.m0.i.g gVar) {
        return mergeFrom((b$b$c) gVar);
    }

    @Override // d0.e0.p.d.m0.i.g$b
    public b$b$c$b clone() {
        return new b$b$c$b().mergeFrom(buildPartial());
    }

    @Override // d0.e0.p.d.m0.i.a$a, d0.e0.p.d.m0.i.n$a
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.i.n$a mergeFrom(d0.e0.p.d.m0.i.d dVar, d0.e0.p.d.m0.i.e eVar) throws IOException {
        return mergeFrom(dVar, eVar);
    }

    public b$b$c$b mergeFrom(b$b$c b_b_c) {
        if (b_b_c == b$b$c.getDefaultInstance()) {
            return this;
        }
        if (b_b_c.hasType()) {
            setType(b_b_c.getType());
        }
        if (b_b_c.hasIntValue()) {
            setIntValue(b_b_c.getIntValue());
        }
        if (b_b_c.hasFloatValue()) {
            setFloatValue(b_b_c.getFloatValue());
        }
        if (b_b_c.hasDoubleValue()) {
            setDoubleValue(b_b_c.getDoubleValue());
        }
        if (b_b_c.hasStringValue()) {
            setStringValue(b_b_c.getStringValue());
        }
        if (b_b_c.hasClassId()) {
            setClassId(b_b_c.getClassId());
        }
        if (b_b_c.hasEnumValueId()) {
            setEnumValueId(b_b_c.getEnumValueId());
        }
        if (b_b_c.hasAnnotation()) {
            mergeAnnotation(b_b_c.getAnnotation());
        }
        if (!b$b$c.i(b_b_c).isEmpty()) {
            if (this.t.isEmpty()) {
                this.t = b$b$c.i(b_b_c);
                this.k &= -257;
            } else {
                if ((this.k & 256) != 256) {
                    this.t = new ArrayList(this.t);
                    this.k |= 256;
                }
                this.t.addAll(b$b$c.i(b_b_c));
            }
        }
        if (b_b_c.hasArrayDimensionCount()) {
            setArrayDimensionCount(b_b_c.getArrayDimensionCount());
        }
        if (b_b_c.hasFlags()) {
            setFlags(b_b_c.getFlags());
        }
        setUnknownFields(getUnknownFields().concat(b$b$c.n(b_b_c)));
        return this;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x001d  */
    @Override // d0.e0.p.d.m0.i.a$a, d0.e0.p.d.m0.i.n$a
    public b$b$c$b mergeFrom(d0.e0.p.d.m0.i.d dVar, d0.e0.p.d.m0.i.e eVar) throws Throwable {
        b$b$c b_b_c = null;
        try {
            try {
                b$b$c partialFrom = b$b$c.k.parsePartialFrom(dVar, eVar);
                if (partialFrom != null) {
                    mergeFrom(partialFrom);
                }
                return this;
            } catch (InvalidProtocolBufferException e) {
                b$b$c b_b_c2 = (b$b$c) e.getUnfinishedMessage();
                try {
                    throw e;
                } catch (Throwable th) {
                    th = th;
                    b_b_c = b_b_c2;
                    if (b_b_c != null) {
                        mergeFrom(b_b_c);
                    }
                    throw th;
                }
            }
        } catch (Throwable th2) {
            th = th2;
            if (b_b_c != null) {
                mergeFrom(b_b_c);
            }
            throw th;
        }
    }
}
