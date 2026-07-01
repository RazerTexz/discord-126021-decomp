package d0.e0.p.d.m0.p;

import b.d.b.a.outline;
import com.discord.widgets.chat.input.MentionUtils;
import d0.LazyJVM;
import d0.t.Maps6;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: d0.e0.p.d.m0.p.e, reason: use source file name */
/* JADX INFO: compiled from: JavaTypeEnhancementState.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class JavaTypeEnhancementState {
    public static final JavaTypeEnhancementState2 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final JavaTypeEnhancementState f3563b;
    public final JavaTypeEnhancementState2 c;
    public final JavaTypeEnhancementState2 d;
    public final Map<String, JavaTypeEnhancementState2> e;
    public final boolean f;
    public final JavaTypeEnhancementState2 g;
    public final Lazy h;
    public final boolean i;
    public final boolean j;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.p.e$a */
    /* JADX INFO: compiled from: JavaTypeEnhancementState.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.p.e$b */
    /* JADX INFO: compiled from: JavaTypeEnhancementState.kt */
    public static final class b extends Lambda implements Function0<String[]> {
        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final String[] invoke() {
            ArrayList arrayList = new ArrayList();
            arrayList.add(JavaTypeEnhancementState.this.getGlobalJsr305Level().getDescription());
            JavaTypeEnhancementState2 migrationLevelForJsr305 = JavaTypeEnhancementState.this.getMigrationLevelForJsr305();
            if (migrationLevelForJsr305 != null) {
                arrayList.add(Intrinsics3.stringPlus("under-migration:", migrationLevelForJsr305.getDescription()));
            }
            for (Map.Entry<String, JavaTypeEnhancementState2> entry : JavaTypeEnhancementState.this.getUserDefinedLevelForSpecificJsr305Annotation().entrySet()) {
                StringBuilder sbQ = outline.Q(MentionUtils.MENTIONS_CHAR);
                sbQ.append(entry.getKey());
                sbQ.append(MentionUtils.EMOJIS_AND_STICKERS_CHAR);
                sbQ.append(entry.getValue().getDescription());
                arrayList.add(sbQ.toString());
            }
            Object[] array = arrayList.toArray(new String[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            return (String[]) array;
        }
    }

    static {
        new a(null);
        JavaTypeEnhancementState2 javaTypeEnhancementState2 = JavaTypeEnhancementState2.WARN;
        a = javaTypeEnhancementState2;
        new JavaTypeEnhancementState(javaTypeEnhancementState2, null, Maps6.emptyMap(), false, null, 24, null);
        JavaTypeEnhancementState2 javaTypeEnhancementState3 = JavaTypeEnhancementState2.IGNORE;
        f3563b = new JavaTypeEnhancementState(javaTypeEnhancementState3, javaTypeEnhancementState3, Maps6.emptyMap(), false, null, 24, null);
        JavaTypeEnhancementState2 javaTypeEnhancementState4 = JavaTypeEnhancementState2.STRICT;
        new JavaTypeEnhancementState(javaTypeEnhancementState4, javaTypeEnhancementState4, Maps6.emptyMap(), false, null, 24, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public JavaTypeEnhancementState(JavaTypeEnhancementState2 javaTypeEnhancementState2, JavaTypeEnhancementState2 javaTypeEnhancementState3, Map<String, ? extends JavaTypeEnhancementState2> map, boolean z2, JavaTypeEnhancementState2 javaTypeEnhancementState4) {
        Intrinsics3.checkNotNullParameter(javaTypeEnhancementState2, "globalJsr305Level");
        Intrinsics3.checkNotNullParameter(map, "userDefinedLevelForSpecificJsr305Annotation");
        Intrinsics3.checkNotNullParameter(javaTypeEnhancementState4, "jspecifyReportLevel");
        this.c = javaTypeEnhancementState2;
        this.d = javaTypeEnhancementState3;
        this.e = map;
        this.f = z2;
        this.g = javaTypeEnhancementState4;
        this.h = LazyJVM.lazy(new b());
        JavaTypeEnhancementState2 javaTypeEnhancementState5 = JavaTypeEnhancementState2.IGNORE;
        boolean z3 = true;
        boolean z4 = javaTypeEnhancementState2 == javaTypeEnhancementState5 && javaTypeEnhancementState3 == javaTypeEnhancementState5 && map.isEmpty();
        this.i = z4;
        if (!z4 && javaTypeEnhancementState4 != javaTypeEnhancementState5) {
            z3 = false;
        }
        this.j = z3;
    }

    public final boolean getDisabledDefaultAnnotations() {
        return this.j;
    }

    public final boolean getDisabledJsr305() {
        return this.i;
    }

    public final boolean getEnableCompatqualCheckerFrameworkAnnotations() {
        return this.f;
    }

    public final JavaTypeEnhancementState2 getGlobalJsr305Level() {
        return this.c;
    }

    public final JavaTypeEnhancementState2 getJspecifyReportLevel() {
        return this.g;
    }

    public final JavaTypeEnhancementState2 getMigrationLevelForJsr305() {
        return this.d;
    }

    public final Map<String, JavaTypeEnhancementState2> getUserDefinedLevelForSpecificJsr305Annotation() {
        return this.e;
    }

    public /* synthetic */ JavaTypeEnhancementState(JavaTypeEnhancementState2 javaTypeEnhancementState2, JavaTypeEnhancementState2 javaTypeEnhancementState3, Map map, boolean z2, JavaTypeEnhancementState2 javaTypeEnhancementState4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(javaTypeEnhancementState2, javaTypeEnhancementState3, map, (i & 8) != 0 ? true : z2, (i & 16) != 0 ? a : javaTypeEnhancementState4);
    }
}
