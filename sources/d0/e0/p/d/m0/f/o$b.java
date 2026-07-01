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
public final class o$b extends d0.e0.p.d.m0.i.g$b<o, o$b> implements d0.e0.p.d.m0.i.o {
    public int k;
    public List<o$c> l = Collections.emptyList();

    @Override // d0.e0.p.d.m0.i.n$a
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.i.n build() {
        return build();
    }

    public o buildPartial() {
        o oVar = new o(this, null);
        if ((this.k & 1) == 1) {
            this.l = Collections.unmodifiableList(this.l);
            this.k &= -2;
        }
        o.b(oVar, this.l);
        return oVar;
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

    @Override // d0.e0.p.d.m0.i.n$a
    public o build() {
        o oVarBuildPartial = buildPartial();
        if (oVarBuildPartial.isInitialized()) {
            return oVarBuildPartial;
        }
        throw new UninitializedMessageException(oVarBuildPartial);
    }

    @Override // d0.e0.p.d.m0.i.g$b
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.i.g$b clone() {
        return clone();
    }

    @Override // d0.e0.p.d.m0.i.g$b
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.i.g$b mergeFrom(d0.e0.p.d.m0.i.g gVar) {
        return mergeFrom((o) gVar);
    }

    @Override // d0.e0.p.d.m0.i.g$b
    public o$b clone() {
        return new o$b().mergeFrom(buildPartial());
    }

    @Override // d0.e0.p.d.m0.i.a$a, d0.e0.p.d.m0.i.n$a
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.i.n$a mergeFrom(d0.e0.p.d.m0.i.d dVar, d0.e0.p.d.m0.i.e eVar) throws IOException {
        return mergeFrom(dVar, eVar);
    }

    public o$b mergeFrom(o oVar) {
        if (oVar == o.getDefaultInstance()) {
            return this;
        }
        if (!o.a(oVar).isEmpty()) {
            if (this.l.isEmpty()) {
                this.l = o.a(oVar);
                this.k &= -2;
            } else {
                if ((this.k & 1) != 1) {
                    this.l = new ArrayList(this.l);
                    this.k |= 1;
                }
                this.l.addAll(o.a(oVar));
            }
        }
        setUnknownFields(getUnknownFields().concat(o.c(oVar)));
        return this;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x001d  */
    @Override // d0.e0.p.d.m0.i.a$a, d0.e0.p.d.m0.i.n$a
    public o$b mergeFrom(d0.e0.p.d.m0.i.d dVar, d0.e0.p.d.m0.i.e eVar) throws Throwable {
        o oVar = null;
        try {
            try {
                o partialFrom = o.k.parsePartialFrom(dVar, eVar);
                if (partialFrom != null) {
                    mergeFrom(partialFrom);
                }
                return this;
            } catch (InvalidProtocolBufferException e) {
                o oVar2 = (o) e.getUnfinishedMessage();
                try {
                    throw e;
                } catch (Throwable th) {
                    th = th;
                    oVar = oVar2;
                    if (oVar != null) {
                        mergeFrom(oVar);
                    }
                    throw th;
                }
            }
        } catch (Throwable th2) {
            th = th2;
            if (oVar != null) {
                mergeFrom(oVar);
            }
            throw th;
        }
    }
}
