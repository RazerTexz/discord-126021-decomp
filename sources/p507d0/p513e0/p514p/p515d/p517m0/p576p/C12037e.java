package p507d0.p513e0.p514p.p515d.p517m0.p576p;

import com.discord.widgets.chat.input.MentionUtilsKt;
import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.C12083g;
import p507d0.p580t.C12136h0;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.p.e */
/* JADX INFO: compiled from: JavaTypeEnhancementState.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12037e {

    /* JADX INFO: renamed from: a */
    public static final EnumC12040h f24981a;

    /* JADX INFO: renamed from: b */
    public static final C12037e f24982b;

    /* JADX INFO: renamed from: c */
    public final EnumC12040h f24983c;

    /* JADX INFO: renamed from: d */
    public final EnumC12040h f24984d;

    /* JADX INFO: renamed from: e */
    public final Map<String, EnumC12040h> f24985e;

    /* JADX INFO: renamed from: f */
    public final boolean f24986f;

    /* JADX INFO: renamed from: g */
    public final EnumC12040h f24987g;

    /* JADX INFO: renamed from: h */
    public final Lazy f24988h;

    /* JADX INFO: renamed from: i */
    public final boolean f24989i;

    /* JADX INFO: renamed from: j */
    public final boolean f24990j;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.p.e$a */
    /* JADX INFO: compiled from: JavaTypeEnhancementState.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.p.e$b */
    /* JADX INFO: compiled from: JavaTypeEnhancementState.kt */
    public static final class b extends AbstractC12240o implements Function0<String[]> {
        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final String[] invoke() {
            ArrayList arrayList = new ArrayList();
            arrayList.add(C12037e.this.getGlobalJsr305Level().getDescription());
            EnumC12040h migrationLevelForJsr305 = C12037e.this.getMigrationLevelForJsr305();
            if (migrationLevelForJsr305 != null) {
                arrayList.add(C12238m.stringPlus("under-migration:", migrationLevelForJsr305.getDescription()));
            }
            for (Map.Entry<String, EnumC12040h> entry : C12037e.this.getUserDefinedLevelForSpecificJsr305Annotation().entrySet()) {
                StringBuilder sbM829Q = C1643a.m829Q(MentionUtilsKt.MENTIONS_CHAR);
                sbM829Q.append(entry.getKey());
                sbM829Q.append(MentionUtilsKt.EMOJIS_AND_STICKERS_CHAR);
                sbM829Q.append(entry.getValue().getDescription());
                arrayList.add(sbM829Q.toString());
            }
            Object[] array = arrayList.toArray(new String[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            return (String[]) array;
        }
    }

    static {
        new a(null);
        EnumC12040h enumC12040h = EnumC12040h.WARN;
        f24981a = enumC12040h;
        new C12037e(enumC12040h, null, C12136h0.emptyMap(), false, null, 24, null);
        EnumC12040h enumC12040h2 = EnumC12040h.IGNORE;
        f24982b = new C12037e(enumC12040h2, enumC12040h2, C12136h0.emptyMap(), false, null, 24, null);
        EnumC12040h enumC12040h3 = EnumC12040h.STRICT;
        new C12037e(enumC12040h3, enumC12040h3, C12136h0.emptyMap(), false, null, 24, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C12037e(EnumC12040h enumC12040h, EnumC12040h enumC12040h2, Map<String, ? extends EnumC12040h> map, boolean z2, EnumC12040h enumC12040h3) {
        C12238m.checkNotNullParameter(enumC12040h, "globalJsr305Level");
        C12238m.checkNotNullParameter(map, "userDefinedLevelForSpecificJsr305Annotation");
        C12238m.checkNotNullParameter(enumC12040h3, "jspecifyReportLevel");
        this.f24983c = enumC12040h;
        this.f24984d = enumC12040h2;
        this.f24985e = map;
        this.f24986f = z2;
        this.f24987g = enumC12040h3;
        this.f24988h = C12083g.lazy(new b());
        EnumC12040h enumC12040h4 = EnumC12040h.IGNORE;
        boolean z3 = true;
        boolean z4 = enumC12040h == enumC12040h4 && enumC12040h2 == enumC12040h4 && map.isEmpty();
        this.f24989i = z4;
        if (!z4 && enumC12040h3 != enumC12040h4) {
            z3 = false;
        }
        this.f24990j = z3;
    }

    public final boolean getDisabledDefaultAnnotations() {
        return this.f24990j;
    }

    public final boolean getDisabledJsr305() {
        return this.f24989i;
    }

    public final boolean getEnableCompatqualCheckerFrameworkAnnotations() {
        return this.f24986f;
    }

    public final EnumC12040h getGlobalJsr305Level() {
        return this.f24983c;
    }

    public final EnumC12040h getJspecifyReportLevel() {
        return this.f24987g;
    }

    public final EnumC12040h getMigrationLevelForJsr305() {
        return this.f24984d;
    }

    public final Map<String, EnumC12040h> getUserDefinedLevelForSpecificJsr305Annotation() {
        return this.f24985e;
    }

    public /* synthetic */ C12037e(EnumC12040h enumC12040h, EnumC12040h enumC12040h2, Map map, boolean z2, EnumC12040h enumC12040h3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(enumC12040h, enumC12040h2, map, (i & 8) != 0 ? true : z2, (i & 16) != 0 ? f24981a : enumC12040h3);
    }
}
