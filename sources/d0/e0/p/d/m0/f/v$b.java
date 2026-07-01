package d0.e0.p.d.m0.f;

import d0.e0.p.d.m0.i.a$a;
import java.io.IOException;
import java.util.Objects;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.UninitializedMessageException;

/* JADX INFO: compiled from: ProtoBuf.java */
/* JADX INFO: loaded from: classes3.dex */
public final class v$b extends d0.e0.p.d.m0.i.g$b<v, v$b> implements d0.e0.p.d.m0.i.o {
    public int k;
    public int l;
    public int m;
    public int o;
    public int p;
    public v$c n = v$c.ERROR;
    public v$d q = v$d.LANGUAGE_VERSION;

    @Override // d0.e0.p.d.m0.i.n$a
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.i.n build() {
        return build();
    }

    public v buildPartial() {
        v vVar = new v(this, null);
        int i = this.k;
        int i2 = (i & 1) != 1 ? 0 : 1;
        v.a(vVar, this.l);
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        v.b(vVar, this.m);
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        v.c(vVar, this.n);
        if ((i & 8) == 8) {
            i2 |= 8;
        }
        v.d(vVar, this.o);
        if ((i & 16) == 16) {
            i2 |= 16;
        }
        v.e(vVar, this.p);
        if ((i & 32) == 32) {
            i2 |= 32;
        }
        v.f(vVar, this.q);
        v.g(vVar, i2);
        return vVar;
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

    public v$b setErrorCode(int i) {
        this.k |= 8;
        this.o = i;
        return this;
    }

    public v$b setLevel(v$c v_c) {
        Objects.requireNonNull(v_c);
        this.k |= 4;
        this.n = v_c;
        return this;
    }

    public v$b setMessage(int i) {
        this.k |= 16;
        this.p = i;
        return this;
    }

    public v$b setVersion(int i) {
        this.k |= 1;
        this.l = i;
        return this;
    }

    public v$b setVersionFull(int i) {
        this.k |= 2;
        this.m = i;
        return this;
    }

    public v$b setVersionKind(v$d v_d) {
        Objects.requireNonNull(v_d);
        this.k |= 32;
        this.q = v_d;
        return this;
    }

    @Override // d0.e0.p.d.m0.i.n$a
    public v build() {
        v vVarBuildPartial = buildPartial();
        if (vVarBuildPartial.isInitialized()) {
            return vVarBuildPartial;
        }
        throw new UninitializedMessageException(vVarBuildPartial);
    }

    @Override // d0.e0.p.d.m0.i.g$b
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.i.g$b clone() {
        return clone();
    }

    @Override // d0.e0.p.d.m0.i.g$b
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.i.g$b mergeFrom(d0.e0.p.d.m0.i.g gVar) {
        return mergeFrom((v) gVar);
    }

    @Override // d0.e0.p.d.m0.i.g$b
    public v$b clone() {
        return new v$b().mergeFrom(buildPartial());
    }

    @Override // d0.e0.p.d.m0.i.a$a, d0.e0.p.d.m0.i.n$a
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.i.n$a mergeFrom(d0.e0.p.d.m0.i.d dVar, d0.e0.p.d.m0.i.e eVar) throws IOException {
        return mergeFrom(dVar, eVar);
    }

    public v$b mergeFrom(v vVar) {
        if (vVar == v.getDefaultInstance()) {
            return this;
        }
        if (vVar.hasVersion()) {
            setVersion(vVar.getVersion());
        }
        if (vVar.hasVersionFull()) {
            setVersionFull(vVar.getVersionFull());
        }
        if (vVar.hasLevel()) {
            setLevel(vVar.getLevel());
        }
        if (vVar.hasErrorCode()) {
            setErrorCode(vVar.getErrorCode());
        }
        if (vVar.hasMessage()) {
            setMessage(vVar.getMessage());
        }
        if (vVar.hasVersionKind()) {
            setVersionKind(vVar.getVersionKind());
        }
        setUnknownFields(getUnknownFields().concat(v.h(vVar)));
        return this;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x001d  */
    @Override // d0.e0.p.d.m0.i.a$a, d0.e0.p.d.m0.i.n$a
    public v$b mergeFrom(d0.e0.p.d.m0.i.d dVar, d0.e0.p.d.m0.i.e eVar) throws Throwable {
        v vVar = null;
        try {
            try {
                v partialFrom = v.k.parsePartialFrom(dVar, eVar);
                if (partialFrom != null) {
                    mergeFrom(partialFrom);
                }
                return this;
            } catch (InvalidProtocolBufferException e) {
                v vVar2 = (v) e.getUnfinishedMessage();
                try {
                    throw e;
                } catch (Throwable th) {
                    th = th;
                    vVar = vVar2;
                    if (vVar != null) {
                        mergeFrom(vVar);
                    }
                    throw th;
                }
            }
        } catch (Throwable th2) {
            th = th2;
            if (vVar != null) {
                mergeFrom(vVar);
            }
            throw th;
        }
    }
}
