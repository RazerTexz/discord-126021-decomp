package d0.e0.p.d.m0.f.z;

import com.discord.widgets.chat.input.MentionUtilsKt;
import com.discord.widgets.chat.input.autocomplete.AutocompleteViewModel;
import d0.e0.p.d.m0.f.o;
import d0.e0.p.d.m0.f.o$c;
import d0.e0.p.d.m0.f.o$c$c;
import d0.e0.p.d.m0.f.p;
import d0.t.u;
import d0.z.d.m;
import java.util.LinkedList;
import java.util.List;
import kotlin.Triple;

/* JADX INFO: compiled from: NameResolverImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d implements c {
    public final p a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o f3418b;

    public d(p pVar, o oVar) {
        m.checkNotNullParameter(pVar, "strings");
        m.checkNotNullParameter(oVar, "qualifiedNames");
        this.a = pVar;
        this.f3418b = oVar;
    }

    public final Triple<List<String>, List<String>, Boolean> a(int i) {
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        boolean z2 = false;
        while (i != -1) {
            o$c qualifiedName = this.f3418b.getQualifiedName(i);
            String string = this.a.getString(qualifiedName.getShortName());
            o$c$c kind = qualifiedName.getKind();
            m.checkNotNull(kind);
            int iOrdinal = kind.ordinal();
            if (iOrdinal == 0) {
                linkedList2.addFirst(string);
            } else if (iOrdinal == 1) {
                linkedList.addFirst(string);
            } else if (iOrdinal == 2) {
                linkedList2.addFirst(string);
                z2 = true;
            }
            i = qualifiedName.getParentQualifiedName();
        }
        return new Triple<>(linkedList, linkedList2, Boolean.valueOf(z2));
    }

    @Override // d0.e0.p.d.m0.f.z.c
    public String getQualifiedClassName(int i) {
        Triple<List<String>, List<String>, Boolean> tripleA = a(i);
        List<String> listComponent1 = tripleA.component1();
        String strJoinToString$default = u.joinToString$default(tripleA.component2(), ".", null, null, 0, null, null, 62, null);
        if (listComponent1.isEmpty()) {
            return strJoinToString$default;
        }
        return u.joinToString$default(listComponent1, AutocompleteViewModel.COMMAND_DISCOVER_TOKEN, null, null, 0, null, null, 62, null) + MentionUtilsKt.SLASH_CHAR + strJoinToString$default;
    }

    @Override // d0.e0.p.d.m0.f.z.c
    public String getString(int i) {
        String string = this.a.getString(i);
        m.checkNotNullExpressionValue(string, "strings.getString(index)");
        return string;
    }

    @Override // d0.e0.p.d.m0.f.z.c
    public boolean isLocalClassName(int i) {
        return a(i).getThird().booleanValue();
    }
}
