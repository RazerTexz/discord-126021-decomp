package b.a.k.f;

import android.text.SpannableStringBuilder;
import android.webkit.URLUtil;
import b.a.k.Format;
import b.a.k.e.ClickableSpan2;
import com.discord.i18n.Hook;
import com.discord.i18n.RenderContext;
import com.discord.simpleast.core.node.Node;
import d0.z.d.Intrinsics3;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: renamed from: b.a.k.f.c, reason: use source file name */
/* JADX INFO: compiled from: HookNode.kt */
/* JADX INFO: loaded from: classes.dex */
public final class HookNode2 extends Node.a<RenderContext> {
    public final String a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HookNode2(String str) {
        super(new Node[0]);
        Intrinsics3.checkNotNullParameter(str, "key");
        this.a = str;
    }

    @Override // com.discord.simpleast.core.node.Node.a, com.discord.simpleast.core.node.Node
    public void render(SpannableStringBuilder spannableStringBuilder, Object obj) {
        List<Object> list;
        RenderContext renderContext = (RenderContext) obj;
        Intrinsics3.checkNotNullParameter(spannableStringBuilder, "builder");
        Intrinsics3.checkNotNullParameter(renderContext, "renderContext");
        Hook hook = renderContext.hooks.get(this.a);
        int length = spannableStringBuilder.length();
        super.render(spannableStringBuilder, renderContext);
        Hook.a aVar = null;
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
        Hook.a aVar2 = hook != null ? hook.clickHandler : null;
        if (aVar2 != null) {
            aVar = aVar2;
        } else if (URLUtil.isValidUrl(this.a)) {
            Format format = Format.d;
            aVar = new Hook.a(Format.f245b.invoke(), Format.c);
        }
        if (aVar != null) {
            Integer numInvoke = aVar.a;
            if (numInvoke == null) {
                Format format2 = Format.d;
                numInvoke = Format.f245b.invoke();
            }
            spannableStringBuilder.setSpan(new ClickableSpan2(new HookNode(this, aVar), numInvoke), length, spannableStringBuilder.length(), 33);
            renderContext.hasClickables = true;
        }
    }
}
