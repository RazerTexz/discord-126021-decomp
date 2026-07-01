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
public final class f$b extends d0.e0.p.d.m0.i.g$b<f, f$b> implements d0.e0.p.d.m0.i.o {
    public int k;
    public f$c l = f$c.RETURNS_CONSTANT;
    public List<h> m = Collections.emptyList();
    public h n = h.getDefaultInstance();
    public f$d o = f$d.AT_MOST_ONCE;

    @Override // d0.e0.p.d.m0.i.n$a
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.i.n build() {
        return build();
    }

    public f buildPartial() {
        f fVar = new f(this, null);
        int i = this.k;
        int i2 = (i & 1) != 1 ? 0 : 1;
        f.a(fVar, this.l);
        if ((this.k & 2) == 2) {
            this.m = Collections.unmodifiableList(this.m);
            this.k &= -3;
        }
        f.c(fVar, this.m);
        if ((i & 4) == 4) {
            i2 |= 2;
        }
        f.d(fVar, this.n);
        if ((i & 8) == 8) {
            i2 |= 4;
        }
        f.e(fVar, this.o);
        f.f(fVar, i2);
        return fVar;
    }

    @Override // d0.e0.p.d.m0.i.g$b
    /* JADX INFO: renamed from: clone */
    public /* bridge */ /* synthetic */ Object mo88clone() throws CloneNotSupportedException {
        return clone();
    }

    public f$b mergeConclusionOfConditionalEffect(h hVar) {
        if ((this.k & 4) != 4 || this.n == h.getDefaultInstance()) {
            this.n = hVar;
        } else {
            this.n = h.newBuilder(this.n).mergeFrom(hVar).buildPartial();
        }
        this.k |= 4;
        return this;
    }

    @Override // d0.e0.p.d.m0.i.a$a, d0.e0.p.d.m0.i.n$a
    public /* bridge */ /* synthetic */ a$a mergeFrom(d0.e0.p.d.m0.i.d dVar, d0.e0.p.d.m0.i.e eVar) throws IOException {
        return mergeFrom(dVar, eVar);
    }

    public f$b setEffectType(f$c f_c) {
        Objects.requireNonNull(f_c);
        this.k |= 1;
        this.l = f_c;
        return this;
    }

    public f$b setKind(f$d f_d) {
        Objects.requireNonNull(f_d);
        this.k |= 8;
        this.o = f_d;
        return this;
    }

    @Override // d0.e0.p.d.m0.i.n$a
    public f build() {
        f fVarBuildPartial = buildPartial();
        if (fVarBuildPartial.isInitialized()) {
            return fVarBuildPartial;
        }
        throw new UninitializedMessageException(fVarBuildPartial);
    }

    @Override // d0.e0.p.d.m0.i.g$b
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.i.g$b clone() {
        return clone();
    }

    @Override // d0.e0.p.d.m0.i.g$b
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.i.g$b mergeFrom(d0.e0.p.d.m0.i.g gVar) {
        return mergeFrom((f) gVar);
    }

    @Override // d0.e0.p.d.m0.i.g$b
    public f$b clone() {
        return new f$b().mergeFrom(buildPartial());
    }

    @Override // d0.e0.p.d.m0.i.a$a, d0.e0.p.d.m0.i.n$a
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.i.n$a mergeFrom(d0.e0.p.d.m0.i.d dVar, d0.e0.p.d.m0.i.e eVar) throws IOException {
        return mergeFrom(dVar, eVar);
    }

    public f$b mergeFrom(f fVar) {
        if (fVar == f.getDefaultInstance()) {
            return this;
        }
        if (fVar.hasEffectType()) {
            setEffectType(fVar.getEffectType());
        }
        if (!f.b(fVar).isEmpty()) {
            if (this.m.isEmpty()) {
                this.m = f.b(fVar);
                this.k &= -3;
            } else {
                if ((this.k & 2) != 2) {
                    this.m = new ArrayList(this.m);
                    this.k |= 2;
                }
                this.m.addAll(f.b(fVar));
            }
        }
        if (fVar.hasConclusionOfConditionalEffect()) {
            mergeConclusionOfConditionalEffect(fVar.getConclusionOfConditionalEffect());
        }
        if (fVar.hasKind()) {
            setKind(fVar.getKind());
        }
        setUnknownFields(getUnknownFields().concat(f.g(fVar)));
        return this;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x001d  */
    @Override // d0.e0.p.d.m0.i.a$a, d0.e0.p.d.m0.i.n$a
    public f$b mergeFrom(d0.e0.p.d.m0.i.d dVar, d0.e0.p.d.m0.i.e eVar) throws Throwable {
        f fVar = null;
        try {
            try {
                f partialFrom = f.k.parsePartialFrom(dVar, eVar);
                if (partialFrom != null) {
                    mergeFrom(partialFrom);
                }
                return this;
            } catch (InvalidProtocolBufferException e) {
                f fVar2 = (f) e.getUnfinishedMessage();
                try {
                    throw e;
                } catch (Throwable th) {
                    th = th;
                    fVar = fVar2;
                    if (fVar != null) {
                        mergeFrom(fVar);
                    }
                    throw th;
                }
            }
        } catch (Throwable th2) {
            th = th2;
            if (fVar != null) {
                mergeFrom(fVar);
            }
            throw th;
        }
    }
}
