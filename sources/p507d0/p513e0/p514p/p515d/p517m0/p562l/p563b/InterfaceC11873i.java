package p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b;

import kotlin.Pair;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11318a;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11472x;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11684i;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.C11708g;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.i */
/* JADX INFO: compiled from: ContractDeserializer.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface InterfaceC11873i {

    /* JADX INFO: renamed from: a */
    public static final a f24635a = a.f24636a;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.i$a */
    /* JADX INFO: compiled from: ContractDeserializer.kt */
    public static final class a {

        /* JADX INFO: renamed from: a */
        public static final /* synthetic */ a f24636a = new a();

        /* JADX INFO: renamed from: b */
        public static final InterfaceC11873i f24637b = new C13334a();

        /* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.i$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ContractDeserializer.kt */
        public static final class C13334a implements InterfaceC11873i {
            @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.InterfaceC11873i
            public Pair deserializeContractFromFunction(C11684i c11684i, InterfaceC11472x interfaceC11472x, C11708g c11708g, C11849c0 c11849c0) {
                C12238m.checkNotNullParameter(c11684i, "proto");
                C12238m.checkNotNullParameter(interfaceC11472x, "ownerFunction");
                C12238m.checkNotNullParameter(c11708g, "typeTable");
                C12238m.checkNotNullParameter(c11849c0, "typeDeserializer");
                return null;
            }
        }

        public final InterfaceC11873i getDEFAULT() {
            return f24637b;
        }
    }

    Pair<InterfaceC11318a.a<?>, Object> deserializeContractFromFunction(C11684i c11684i, InterfaceC11472x interfaceC11472x, C11708g c11708g, C11849c0 c11849c0);
}
