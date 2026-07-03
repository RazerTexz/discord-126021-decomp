package p007b.p008a.p050t.p052b.p054b;

import android.text.SpannableStringBuilder;
import com.discord.simpleast.core.node.Node;
import java.util.Collection;
import java.util.Iterator;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.a.t.b.b.h */
/* JADX INFO: compiled from: SimpleRenderer.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C1306h {
    /* JADX INFO: renamed from: a */
    public static final <T extends SpannableStringBuilder, R> T m375a(T t, Collection<? extends Node<R>> collection, R r) {
        C12238m.checkNotNullParameter(t, "builder");
        C12238m.checkNotNullParameter(collection, "ast");
        Iterator<? extends Node<R>> it = collection.iterator();
        while (it.hasNext()) {
            it.next().render(t, r);
        }
        return t;
    }
}
