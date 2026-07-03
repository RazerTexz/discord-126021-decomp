package p007b.p008a.p027k.p029f;

import android.text.SpannableStringBuilder;
import android.webkit.URLUtil;
import com.discord.i18n.Hook;
import com.discord.i18n.RenderContext;
import com.discord.simpleast.core.node.Node;
import java.util.Iterator;
import java.util.List;
import p007b.p008a.p027k.C1106a;
import p007b.p008a.p027k.p028e.C1110a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.a.k.f.c */
/* JADX INFO: compiled from: HookNode.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C1113c extends Node.C5655a<RenderContext> {

    /* JADX INFO: renamed from: a */
    public final String f1500a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1113c(String str) {
        super(new Node[0]);
        C12238m.checkNotNullParameter(str, "key");
        this.f1500a = str;
    }

    @Override // com.discord.simpleast.core.node.Node.C5655a, com.discord.simpleast.core.node.Node
    public void render(SpannableStringBuilder spannableStringBuilder, Object obj) {
        List<Object> list;
        RenderContext renderContext = (RenderContext) obj;
        C12238m.checkNotNullParameter(spannableStringBuilder, "builder");
        C12238m.checkNotNullParameter(renderContext, "renderContext");
        Hook hook = renderContext.hooks.get(this.f1500a);
        int length = spannableStringBuilder.length();
        super.render(spannableStringBuilder, renderContext);
        Hook.C5524a c5524a = null;
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
        Hook.C5524a c5524a2 = hook != null ? hook.clickHandler : null;
        if (c5524a2 != null) {
            c5524a = c5524a2;
        } else if (URLUtil.isValidUrl(this.f1500a)) {
            C1106a c1106a = C1106a.f1486d;
            c5524a = new Hook.C5524a(C1106a.f1484b.invoke(), C1106a.f1485c);
        }
        if (c5524a != null) {
            Integer numInvoke = c5524a.f18546a;
            if (numInvoke == null) {
                C1106a c1106a2 = C1106a.f1486d;
                numInvoke = C1106a.f1484b.invoke();
            }
            spannableStringBuilder.setSpan(new C1110a(new C1112b(this, c5524a), numInvoke), length, spannableStringBuilder.length(), 33);
            renderContext.hasClickables = true;
        }
    }
}
