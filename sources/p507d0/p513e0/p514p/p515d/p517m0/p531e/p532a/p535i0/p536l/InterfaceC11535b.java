package p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p536l;

import com.discord.models.domain.ModelAuditLogEntry;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11581n;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11585r;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11590w;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11716e;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12148n0;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.l.b */
/* JADX INFO: compiled from: DeclaredMemberIndex.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface InterfaceC11535b {

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.l.b$a */
    /* JADX INFO: compiled from: DeclaredMemberIndex.kt */
    public static final class a implements InterfaceC11535b {

        /* JADX INFO: renamed from: a */
        public static final a f23328a = new a();

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p536l.InterfaceC11535b
        public InterfaceC11581n findFieldByName(C11716e c11716e) {
            C12238m.checkNotNullParameter(c11716e, ModelAuditLogEntry.CHANGE_KEY_NAME);
            return null;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p536l.InterfaceC11535b
        public InterfaceC11590w findRecordComponentByName(C11716e c11716e) {
            C12238m.checkNotNullParameter(c11716e, ModelAuditLogEntry.CHANGE_KEY_NAME);
            return null;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p536l.InterfaceC11535b
        public Set<C11716e> getFieldNames() {
            return C12148n0.emptySet();
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p536l.InterfaceC11535b
        public Set<C11716e> getMethodNames() {
            return C12148n0.emptySet();
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p536l.InterfaceC11535b
        public Set<C11716e> getRecordComponentNames() {
            return C12148n0.emptySet();
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p536l.InterfaceC11535b
        public List<InterfaceC11585r> findMethodsByName(C11716e c11716e) {
            C12238m.checkNotNullParameter(c11716e, ModelAuditLogEntry.CHANGE_KEY_NAME);
            return C12147n.emptyList();
        }
    }

    InterfaceC11581n findFieldByName(C11716e c11716e);

    Collection<InterfaceC11585r> findMethodsByName(C11716e c11716e);

    InterfaceC11590w findRecordComponentByName(C11716e c11716e);

    Set<C11716e> getFieldNames();

    Set<C11716e> getMethodNames();

    Set<C11716e> getRecordComponentNames();
}
