package d0.e0.p.d.l0;

import com.discord.widgets.chat.input.MentionUtilsKt;
import d0.t.u;
import d0.z.d.m;
import d0.z.d.o;
import java.util.Map;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: AnnotationConstructorCaller.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b$d extends o implements Function0<String> {
    public final /* synthetic */ Class $annotationClass;
    public final /* synthetic */ Map $values;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b$d(Class cls, Map map) {
        super(0);
        this.$annotationClass = cls;
        this.$values = map;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ String invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final String invoke2() {
        StringBuilder sbQ = b.d.b.a.a.Q(MentionUtilsKt.MENTIONS_CHAR);
        sbQ.append(this.$annotationClass.getCanonicalName());
        u.joinTo$default(this.$values.entrySet(), sbQ, ", ", "(", ")", 0, null, b$d$a.j, 48, null);
        String string = sbQ.toString();
        m.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }
}
