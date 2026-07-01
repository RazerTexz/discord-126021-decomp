package b.a.t.a;

import com.discord.simpleast.core.node.StyleNode$a;
import kotlin.jvm.functions.Function1;

/* JADX INFO: Add missing generic type declarations: [RC] */
/* JADX INFO: compiled from: Xml.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class v$a$a<RC> extends d0.z.d.k implements Function1<RC, Iterable<?>> {
    public v$a$a(StyleNode$a styleNode$a) {
        super(1, styleNode$a, StyleNode$a.class, "get", "get(Ljava/lang/Object;)Ljava/lang/Iterable;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public Iterable<?> invoke(Object obj) {
        return ((StyleNode$a) this.receiver).get(obj);
    }
}
