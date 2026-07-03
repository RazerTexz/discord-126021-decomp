package p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z;

import com.discord.models.domain.ModelAuditLogEntry;
import java.util.ArrayList;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.objectweb.asm.Opcodes;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.EnumC11209a;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11678c;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11679d;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11684i;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11689n;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11693r;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11697v;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11734n;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.f.z.h */
/* JADX INFO: compiled from: VersionRequirement.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11709h {

    /* JADX INFO: renamed from: a */
    public static final a f24062a = new a(null);

    /* JADX INFO: renamed from: b */
    public final b f24063b;

    /* JADX INFO: renamed from: c */
    public final C11697v.d f24064c;

    /* JADX INFO: renamed from: d */
    public final EnumC11209a f24065d;

    /* JADX INFO: renamed from: e */
    public final Integer f24066e;

    /* JADX INFO: renamed from: f */
    public final String f24067f;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.f.z.h$b */
    /* JADX INFO: compiled from: VersionRequirement.kt */
    public static final class b {

        /* JADX INFO: renamed from: a */
        public static final a f24068a = new a(null);

        /* JADX INFO: renamed from: b */
        public static final b f24069b = new b(256, 256, 256);

        /* JADX INFO: renamed from: c */
        public final int f24070c;

        /* JADX INFO: renamed from: d */
        public final int f24071d;

        /* JADX INFO: renamed from: e */
        public final int f24072e;

        /* JADX INFO: renamed from: d0.e0.p.d.m0.f.z.h$b$a */
        /* JADX INFO: compiled from: VersionRequirement.kt */
        public static final class a {
            public a(DefaultConstructorMarker defaultConstructorMarker) {
            }

            public final b decode(Integer num, Integer num2) {
                if (num2 != null) {
                    return new b(num2.intValue() & 255, (num2.intValue() >> 8) & 255, (num2.intValue() >> 16) & 255);
                }
                return num != null ? new b(num.intValue() & 7, (num.intValue() >> 3) & 15, (num.intValue() >> 7) & Opcodes.LAND) : b.f24069b;
            }
        }

        public b(int i, int i2, int i3) {
            this.f24070c = i;
            this.f24071d = i2;
            this.f24072e = i3;
        }

        public final String asString() {
            StringBuilder sb;
            int i;
            if (this.f24072e == 0) {
                sb = new StringBuilder();
                sb.append(this.f24070c);
                sb.append('.');
                i = this.f24071d;
            } else {
                sb = new StringBuilder();
                sb.append(this.f24070c);
                sb.append('.');
                sb.append(this.f24071d);
                sb.append('.');
                i = this.f24072e;
            }
            sb.append(i);
            return sb.toString();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.f24070c == bVar.f24070c && this.f24071d == bVar.f24071d && this.f24072e == bVar.f24072e;
        }

        public int hashCode() {
            return (((this.f24070c * 31) + this.f24071d) * 31) + this.f24072e;
        }

        public String toString() {
            return asString();
        }

        public /* synthetic */ b(int i, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, i2, (i4 & 4) != 0 ? 0 : i3);
        }
    }

    public C11709h(b bVar, C11697v.d dVar, EnumC11209a enumC11209a, Integer num, String str) {
        C12238m.checkNotNullParameter(bVar, "version");
        C12238m.checkNotNullParameter(dVar, "kind");
        C12238m.checkNotNullParameter(enumC11209a, "level");
        this.f24063b = bVar;
        this.f24064c = dVar;
        this.f24065d = enumC11209a;
        this.f24066e = num;
        this.f24067f = str;
    }

    public final C11697v.d getKind() {
        return this.f24064c;
    }

    public final b getVersion() {
        return this.f24063b;
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("since ");
        sbM833U.append(this.f24063b);
        sbM833U.append(' ');
        sbM833U.append(this.f24065d);
        Integer num = this.f24066e;
        sbM833U.append(num != null ? C12238m.stringPlus(" error ", num) : "");
        String str = this.f24067f;
        sbM833U.append(str != null ? C12238m.stringPlus(": ", str) : "");
        return sbM833U.toString();
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.f.z.h$a */
    /* JADX INFO: compiled from: VersionRequirement.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final List<C11709h> create(InterfaceC11734n interfaceC11734n, InterfaceC11704c interfaceC11704c, C11710i c11710i) {
            List<Integer> versionRequirementList;
            C12238m.checkNotNullParameter(interfaceC11734n, "proto");
            C12238m.checkNotNullParameter(interfaceC11704c, "nameResolver");
            C12238m.checkNotNullParameter(c11710i, "table");
            if (interfaceC11734n instanceof C11678c) {
                versionRequirementList = ((C11678c) interfaceC11734n).getVersionRequirementList();
            } else if (interfaceC11734n instanceof C11679d) {
                versionRequirementList = ((C11679d) interfaceC11734n).getVersionRequirementList();
            } else if (interfaceC11734n instanceof C11684i) {
                versionRequirementList = ((C11684i) interfaceC11734n).getVersionRequirementList();
            } else if (interfaceC11734n instanceof C11689n) {
                versionRequirementList = ((C11689n) interfaceC11734n).getVersionRequirementList();
            } else {
                if (!(interfaceC11734n instanceof C11693r)) {
                    throw new IllegalStateException(C12238m.stringPlus("Unexpected declaration: ", interfaceC11734n.getClass()));
                }
                versionRequirementList = ((C11693r) interfaceC11734n).getVersionRequirementList();
            }
            ArrayList arrayListM840a0 = C1643a.m840a0(versionRequirementList, "ids");
            for (Integer num : versionRequirementList) {
                C12238m.checkNotNullExpressionValue(num, ModelAuditLogEntry.CHANGE_KEY_ID);
                C11709h c11709hCreate = create(num.intValue(), interfaceC11704c, c11710i);
                if (c11709hCreate != null) {
                    arrayListM840a0.add(c11709hCreate);
                }
            }
            return arrayListM840a0;
        }

        public final C11709h create(int i, InterfaceC11704c interfaceC11704c, C11710i c11710i) {
            EnumC11209a enumC11209a;
            C12238m.checkNotNullParameter(interfaceC11704c, "nameResolver");
            C12238m.checkNotNullParameter(c11710i, "table");
            C11697v c11697v = c11710i.get(i);
            if (c11697v == null) {
                return null;
            }
            b bVarDecode = b.f24068a.decode(c11697v.hasVersion() ? Integer.valueOf(c11697v.getVersion()) : null, c11697v.hasVersionFull() ? Integer.valueOf(c11697v.getVersionFull()) : null);
            C11697v.c level = c11697v.getLevel();
            C12238m.checkNotNull(level);
            int iOrdinal = level.ordinal();
            if (iOrdinal == 0) {
                enumC11209a = EnumC11209a.WARNING;
            } else if (iOrdinal == 1) {
                enumC11209a = EnumC11209a.ERROR;
            } else {
                if (iOrdinal != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                enumC11209a = EnumC11209a.HIDDEN;
            }
            EnumC11209a enumC11209a2 = enumC11209a;
            Integer numValueOf = c11697v.hasErrorCode() ? Integer.valueOf(c11697v.getErrorCode()) : null;
            String string = c11697v.hasMessage() ? interfaceC11704c.getString(c11697v.getMessage()) : null;
            C11697v.d versionKind = c11697v.getVersionKind();
            C12238m.checkNotNullExpressionValue(versionKind, "info.versionKind");
            return new C11709h(bVarDecode, versionKind, enumC11209a2, numValueOf, string);
        }
    }
}
