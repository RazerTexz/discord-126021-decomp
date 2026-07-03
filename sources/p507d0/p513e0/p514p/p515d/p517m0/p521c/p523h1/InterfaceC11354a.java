package p507d0.p513e0.p514p.p515d.p517m0.p521c.p523h1;

import com.discord.models.domain.ModelAuditLogEntry;
import java.util.Collection;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11327d;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11465t0;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11716e;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0;
import p507d0.p580t.C12147n;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.h1.a */
/* JADX INFO: compiled from: AdditionalClassPartsProvider.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface InterfaceC11354a {

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.h1.a$a */
    /* JADX INFO: compiled from: AdditionalClassPartsProvider.kt */
    public static final class a implements InterfaceC11354a {

        /* JADX INFO: renamed from: a */
        public static final a f22796a = new a();

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p523h1.InterfaceC11354a
        public Collection<InterfaceC11327d> getConstructors(InterfaceC11330e interfaceC11330e) {
            C12238m.checkNotNullParameter(interfaceC11330e, "classDescriptor");
            return C12147n.emptyList();
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p523h1.InterfaceC11354a
        public Collection<InterfaceC11465t0> getFunctions(C11716e c11716e, InterfaceC11330e interfaceC11330e) {
            C12238m.checkNotNullParameter(c11716e, ModelAuditLogEntry.CHANGE_KEY_NAME);
            C12238m.checkNotNullParameter(interfaceC11330e, "classDescriptor");
            return C12147n.emptyList();
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p523h1.InterfaceC11354a
        public Collection<C11716e> getFunctionsNames(InterfaceC11330e interfaceC11330e) {
            C12238m.checkNotNullParameter(interfaceC11330e, "classDescriptor");
            return C12147n.emptyList();
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p523h1.InterfaceC11354a
        public Collection<AbstractC11913c0> getSupertypes(InterfaceC11330e interfaceC11330e) {
            C12238m.checkNotNullParameter(interfaceC11330e, "classDescriptor");
            return C12147n.emptyList();
        }
    }

    Collection<InterfaceC11327d> getConstructors(InterfaceC11330e interfaceC11330e);

    Collection<InterfaceC11465t0> getFunctions(C11716e c11716e, InterfaceC11330e interfaceC11330e);

    Collection<C11716e> getFunctionsNames(InterfaceC11330e interfaceC11330e);

    Collection<AbstractC11913c0> getSupertypes(InterfaceC11330e interfaceC11330e);
}
