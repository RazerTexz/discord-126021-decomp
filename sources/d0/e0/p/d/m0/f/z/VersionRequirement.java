package d0.e0.p.d.m0.f.z;

import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.Annotations2;
import d0.e0.p.d.m0.f.n;
import d0.e0.p.d.m0.f.r;
import d0.e0.p.d.m0.f.v;
import d0.e0.p.d.m0.i.MessageLite;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.objectweb.asm.Opcodes;

/* JADX INFO: renamed from: d0.e0.p.d.m0.f.z.h, reason: use source file name */
/* JADX INFO: compiled from: VersionRequirement.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class VersionRequirement {
    public static final a a = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f3419b;
    public final v.d c;
    public final Annotations2 d;
    public final Integer e;
    public final String f;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.f.z.h$b */
    /* JADX INFO: compiled from: VersionRequirement.kt */
    public static final class b {
        public static final a a = new a(null);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f3420b = new b(256, 256, 256);
        public final int c;
        public final int d;
        public final int e;

        /* JADX INFO: renamed from: d0.e0.p.d.m0.f.z.h$b$a */
        /* JADX INFO: compiled from: VersionRequirement.kt */
        public static final class a {
            public a(DefaultConstructorMarker defaultConstructorMarker) {
            }

            public final b decode(Integer num, Integer num2) {
                if (num2 != null) {
                    return new b(num2.intValue() & 255, (num2.intValue() >> 8) & 255, (num2.intValue() >> 16) & 255);
                }
                return num != null ? new b(num.intValue() & 7, (num.intValue() >> 3) & 15, (num.intValue() >> 7) & Opcodes.LAND) : b.f3420b;
            }
        }

        public b(int i, int i2, int i3) {
            this.c = i;
            this.d = i2;
            this.e = i3;
        }

        public final String asString() {
            StringBuilder sb;
            int i;
            if (this.e == 0) {
                sb = new StringBuilder();
                sb.append(this.c);
                sb.append('.');
                i = this.d;
            } else {
                sb = new StringBuilder();
                sb.append(this.c);
                sb.append('.');
                sb.append(this.d);
                sb.append('.');
                i = this.e;
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
            return this.c == bVar.c && this.d == bVar.d && this.e == bVar.e;
        }

        public int hashCode() {
            return (((this.c * 31) + this.d) * 31) + this.e;
        }

        public String toString() {
            return asString();
        }

        public /* synthetic */ b(int i, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, i2, (i4 & 4) != 0 ? 0 : i3);
        }
    }

    public VersionRequirement(b bVar, v.d dVar, Annotations2 annotations2, Integer num, String str) {
        Intrinsics3.checkNotNullParameter(bVar, "version");
        Intrinsics3.checkNotNullParameter(dVar, "kind");
        Intrinsics3.checkNotNullParameter(annotations2, "level");
        this.f3419b = bVar;
        this.c = dVar;
        this.d = annotations2;
        this.e = num;
        this.f = str;
    }

    public final v.d getKind() {
        return this.c;
    }

    public final b getVersion() {
        return this.f3419b;
    }

    public String toString() {
        StringBuilder sbU = outline.U("since ");
        sbU.append(this.f3419b);
        sbU.append(' ');
        sbU.append(this.d);
        Integer num = this.e;
        sbU.append(num != null ? Intrinsics3.stringPlus(" error ", num) : "");
        String str = this.f;
        sbU.append(str != null ? Intrinsics3.stringPlus(": ", str) : "");
        return sbU.toString();
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.f.z.h$a */
    /* JADX INFO: compiled from: VersionRequirement.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final List<VersionRequirement> create(MessageLite messageLite, NameResolver nameResolver, VersionRequirement2 versionRequirement2) {
            List<Integer> versionRequirementList;
            Intrinsics3.checkNotNullParameter(messageLite, "proto");
            Intrinsics3.checkNotNullParameter(nameResolver, "nameResolver");
            Intrinsics3.checkNotNullParameter(versionRequirement2, "table");
            if (messageLite instanceof d0.e0.p.d.m0.f.c) {
                versionRequirementList = ((d0.e0.p.d.m0.f.c) messageLite).getVersionRequirementList();
            } else if (messageLite instanceof d0.e0.p.d.m0.f.d) {
                versionRequirementList = ((d0.e0.p.d.m0.f.d) messageLite).getVersionRequirementList();
            } else if (messageLite instanceof d0.e0.p.d.m0.f.i) {
                versionRequirementList = ((d0.e0.p.d.m0.f.i) messageLite).getVersionRequirementList();
            } else if (messageLite instanceof n) {
                versionRequirementList = ((n) messageLite).getVersionRequirementList();
            } else {
                if (!(messageLite instanceof r)) {
                    throw new IllegalStateException(Intrinsics3.stringPlus("Unexpected declaration: ", messageLite.getClass()));
                }
                versionRequirementList = ((r) messageLite).getVersionRequirementList();
            }
            ArrayList arrayListA0 = outline.a0(versionRequirementList, "ids");
            for (Integer num : versionRequirementList) {
                Intrinsics3.checkNotNullExpressionValue(num, ModelAuditLogEntry.CHANGE_KEY_ID);
                VersionRequirement versionRequirementCreate = create(num.intValue(), nameResolver, versionRequirement2);
                if (versionRequirementCreate != null) {
                    arrayListA0.add(versionRequirementCreate);
                }
            }
            return arrayListA0;
        }

        public final VersionRequirement create(int i, NameResolver nameResolver, VersionRequirement2 versionRequirement2) {
            Annotations2 annotations2;
            Intrinsics3.checkNotNullParameter(nameResolver, "nameResolver");
            Intrinsics3.checkNotNullParameter(versionRequirement2, "table");
            v vVar = versionRequirement2.get(i);
            if (vVar == null) {
                return null;
            }
            b bVarDecode = b.a.decode(vVar.hasVersion() ? Integer.valueOf(vVar.getVersion()) : null, vVar.hasVersionFull() ? Integer.valueOf(vVar.getVersionFull()) : null);
            v.c level = vVar.getLevel();
            Intrinsics3.checkNotNull(level);
            int iOrdinal = level.ordinal();
            if (iOrdinal == 0) {
                annotations2 = Annotations2.WARNING;
            } else if (iOrdinal == 1) {
                annotations2 = Annotations2.ERROR;
            } else {
                if (iOrdinal != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                annotations2 = Annotations2.HIDDEN;
            }
            Annotations2 annotations3 = annotations2;
            Integer numValueOf = vVar.hasErrorCode() ? Integer.valueOf(vVar.getErrorCode()) : null;
            String string = vVar.hasMessage() ? nameResolver.getString(vVar.getMessage()) : null;
            v.d versionKind = vVar.getVersionKind();
            Intrinsics3.checkNotNullExpressionValue(versionKind, "info.versionKind");
            return new VersionRequirement(bVarDecode, versionKind, annotations3, numValueOf, string);
        }
    }
}
