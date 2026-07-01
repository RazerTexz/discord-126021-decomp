package b.a.k.f;

import android.text.SpannableStringBuilder;
import android.webkit.URLUtil;
import com.discord.i18n.Hook;
import com.discord.i18n.Hook$a;
import com.discord.i18n.RenderContext;
import com.discord.simpleast.core.node.Node;
import com.discord.simpleast.core.node.Node$a;
import d0.z.d.m;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: HookNode.kt */
/* JADX INFO: loaded from: classes.dex */
public final class c extends Node$a<RenderContext> {
    public final String a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(String str) {
        super(new Node[0]);
        m.checkNotNullParameter(str, "key");
        this.a = str;
    }

    @Override // com.discord.simpleast.core.node.Node$a, com.discord.simpleast.core.node.Node
    public void render(SpannableStringBuilder spannableStringBuilder, Object obj) {
        List<Object> list;
        RenderContext renderContext = (RenderContext) obj;
        m.checkNotNullParameter(spannableStringBuilder, "builder");
        m.checkNotNullParameter(renderContext, "renderContext");
        Hook hook = renderContext.hooks.get(this.a);
        int length = spannableStringBuilder.length();
        super.render(spannableStringBuilder, renderContext);
        Hook$a hook$a = null;
        CharSequence charSequence = hook != null ? hook.replacementText : null;
        if (charSequence != null) {
            spannableStringBuilder.replace(length, spannableStringBuilder.length(), charSequence);
        }
        if (hook != null && (list = hook.styles) != null) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                spannableStringBuilder.setSpan(it.next(), length, spannableStringBuilder.length(), 33);
            }
        }
        Hook$a hook$a2 = hook != null ? hook.clickHandler : null;
        if (hook$a2 != null) {
            hook$a = hook$a2;
        } else if (URLUtil.isValidUrl(this.a)) {
            b.a.k.a aVar = b.a.k.a.d;
            hook$a = new Hook$a(b.a.k.a.f245b.invoke(), b.a.k.a.c);
        }
        if (hook$a != null) {
            Integer numInvoke = hook$a.a;
            if (numInvoke == null) {
                b.a.k.a aVar2 = b.a.k.a.d;
                numInvoke = b.a.k.a.f245b.invoke();
            }
            spannableStringBuilder.setSpan(new b.a.k.e.a(new b(this, hook$a), numInvoke), length, spannableStringBuilder.length(), 33);
            renderContext.hasClickables = true;
        }
    }
}
