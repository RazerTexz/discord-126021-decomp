package d0.e0.p.d.m0.e.a.i0.l;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.p.d.m0.e.a.k0.w;
import d0.e0.p.d.m0.g.Name;
import d0.t.Collections2;
import d0.t.Sets5;
import d0.z.d.Intrinsics3;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.l.b, reason: use source file name */
/* JADX INFO: compiled from: DeclaredMemberIndex.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface DeclaredMemberIndex2 {

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.l.b$a */
    /* JADX INFO: compiled from: DeclaredMemberIndex.kt */
    public static final class a implements DeclaredMemberIndex2 {
        public static final a a = new a();

        @Override // d0.e0.p.d.m0.e.a.i0.l.DeclaredMemberIndex2
        public d0.e0.p.d.m0.e.a.k0.n findFieldByName(Name name) {
            Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
            return null;
        }

        @Override // d0.e0.p.d.m0.e.a.i0.l.DeclaredMemberIndex2
        public w findRecordComponentByName(Name name) {
            Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
            return null;
        }

        @Override // d0.e0.p.d.m0.e.a.i0.l.DeclaredMemberIndex2
        public Set<Name> getFieldNames() {
            return Sets5.emptySet();
        }

        @Override // d0.e0.p.d.m0.e.a.i0.l.DeclaredMemberIndex2
        public Set<Name> getMethodNames() {
            return Sets5.emptySet();
        }

        @Override // d0.e0.p.d.m0.e.a.i0.l.DeclaredMemberIndex2
        public Set<Name> getRecordComponentNames() {
            return Sets5.emptySet();
        }

        @Override // d0.e0.p.d.m0.e.a.i0.l.DeclaredMemberIndex2
        public List<d0.e0.p.d.m0.e.a.k0.r> findMethodsByName(Name name) {
            Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
            return Collections2.emptyList();
        }
    }

    d0.e0.p.d.m0.e.a.k0.n findFieldByName(Name name);

    Collection<d0.e0.p.d.m0.e.a.k0.r> findMethodsByName(Name name);

    w findRecordComponentByName(Name name);

    Set<Name> getFieldNames();

    Set<Name> getMethodNames();

    Set<Name> getRecordComponentNames();
}
