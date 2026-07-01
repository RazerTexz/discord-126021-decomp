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
public final class b$c extends d0.e0.p.d.m0.i.g$b<b, b$c> implements d0.e0.p.d.m0.i.o {
    public int k;
    public int l;
    public List<b$b> m = Collections.emptyList();

    @Override // d0.e0.p.d.m0.i.n$a
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.i.n build() {
        return build();
    }

    public b buildPartial() {
        b bVar = new b(this, null);
        int i = (this.k & 1) != 1 ? 0 : 1;
        b.a(bVar, this.l);
        if ((this.k & 2) == 2) {
            this.m = Collections.unmodifiableList(this.m);
            this.k &= -3;
        }
        b.c(bVar, this.m);
        b.d(bVar, i);
        return bVar;
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

    public b$c setId(int i) {
        this.k |= 1;
        this.l = i;
        return this;
    }

    @Override // d0.e0.p.d.m0.i.n$a
    public b build() {
        b bVarBuildPartial = buildPartial();
        if (bVarBuildPartial.isInitialized()) {
            return bVarBuildPartial;
        }
        throw new UninitializedMessageException(bVarBuildPartial);
    }

    @Override // d0.e0.p.d.m0.i.g$b
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.i.g$b clone() {
        return clone();
    }

    @Override // d0.e0.p.d.m0.i.g$b
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.i.g$b mergeFrom(d0.e0.p.d.m0.i.g gVar) {
        return mergeFrom((b) gVar);
    }

    @Override // d0.e0.p.d.m0.i.g$b
    public b$c clone() {
        return new b$c().mergeFrom(buildPartial());
    }

    @Override // d0.e0.p.d.m0.i.a$a, d0.e0.p.d.m0.i.n$a
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.i.n$a mergeFrom(d0.e0.p.d.m0.i.d dVar, d0.e0.p.d.m0.i.e eVar) throws IOException {
        return mergeFrom(dVar, eVar);
    }

    public b$c mergeFrom(b bVar) {
        if (bVar == b.getDefaultInstance()) {
            return this;
        }
        if (bVar.hasId()) {
            setId(bVar.getId());
        }
        if (!b.b(bVar).isEmpty()) {
            if (this.m.isEmpty()) {
                this.m = b.b(bVar);
                this.k &= -3;
            } else {
                if ((this.k & 2) != 2) {
                    this.m = new ArrayList(this.m);
                    this.k |= 2;
                }
                this.m.addAll(b.b(bVar));
            }
        }
        setUnknownFields(getUnknownFields().concat(b.e(bVar)));
        return this;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x001d  */
    @Override // d0.e0.p.d.m0.i.a$a, d0.e0.p.d.m0.i.n$a
    public b$c mergeFrom(d0.e0.p.d.m0.i.d dVar, d0.e0.p.d.m0.i.e eVar) throws Throwable {
        b bVar = null;
        try {
            try {
                b partialFrom = b.k.parsePartialFrom(dVar, eVar);
                if (partialFrom != null) {
                    mergeFrom(partialFrom);
                }
                return this;
            } catch (InvalidProtocolBufferException e) {
                b bVar2 = (b) e.getUnfinishedMessage();
                try {
                    throw e;
                } catch (Throwable th) {
                    th = th;
                    bVar = bVar2;
                    if (bVar != null) {
                        mergeFrom(bVar);
                    }
                    throw th;
                }
            }
        } catch (Throwable th2) {
            th = th2;
            if (bVar != null) {
                mergeFrom(bVar);
            }
            throw th;
        }
    }
}
