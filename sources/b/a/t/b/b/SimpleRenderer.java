package b.a.t.b.b;

import android.text.SpannableStringBuilder;
import com.discord.simpleast.core.node.Node;
import d0.z.d.Intrinsics3;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: renamed from: b.a.t.b.b.h, reason: use source file name */
/* JADX INFO: compiled from: SimpleRenderer.kt */
/* JADX INFO: loaded from: classes.dex */
public final class SimpleRenderer {
    public static final <T extends SpannableStringBuilder, R> T a(T t, Collection<? extends Node<R>> collection, R r) {
        Intrinsics3.checkNotNullParameter(t, "builder");
        Intrinsics3.checkNotNullParameter(collection, "ast");
        Iterator<? extends Node<R>> it = collection.iterator();
        while (it.hasNext()) {
            it.next().render(t, r);
        }
        return t;
    }
}
