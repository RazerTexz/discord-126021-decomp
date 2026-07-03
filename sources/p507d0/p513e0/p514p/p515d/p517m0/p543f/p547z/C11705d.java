package p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z;

import com.discord.widgets.chat.input.MentionUtilsKt;
import com.discord.widgets.chat.input.autocomplete.AutocompleteViewModel;
import java.util.LinkedList;
import java.util.List;
import kotlin.Triple;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11690o;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11691p;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.f.z.d */
/* JADX INFO: compiled from: NameResolverImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11705d implements InterfaceC11704c {

    /* JADX INFO: renamed from: a */
    public final C11691p f24059a;

    /* JADX INFO: renamed from: b */
    public final C11690o f24060b;

    public C11705d(C11691p c11691p, C11690o c11690o) {
        C12238m.checkNotNullParameter(c11691p, "strings");
        C12238m.checkNotNullParameter(c11690o, "qualifiedNames");
        this.f24059a = c11691p;
        this.f24060b = c11690o;
    }

    /* JADX INFO: renamed from: a */
    public final Triple<List<String>, List<String>, Boolean> m9815a(int i) {
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        boolean z2 = false;
        while (i != -1) {
            C11690o.c qualifiedName = this.f24060b.getQualifiedName(i);
            String string = this.f24059a.getString(qualifiedName.getShortName());
            C11690o.c.EnumC13322c kind = qualifiedName.getKind();
            C12238m.checkNotNull(kind);
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

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.InterfaceC11704c
    public String getQualifiedClassName(int i) {
        Triple<List<String>, List<String>, Boolean> tripleM9815a = m9815a(i);
        List<String> listComponent1 = tripleM9815a.component1();
        String strJoinToString$default = C12163u.joinToString$default(tripleM9815a.component2(), ".", null, null, 0, null, null, 62, null);
        if (listComponent1.isEmpty()) {
            return strJoinToString$default;
        }
        return C12163u.joinToString$default(listComponent1, AutocompleteViewModel.COMMAND_DISCOVER_TOKEN, null, null, 0, null, null, 62, null) + MentionUtilsKt.SLASH_CHAR + strJoinToString$default;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.InterfaceC11704c
    public String getString(int i) {
        String string = this.f24059a.getString(i);
        C12238m.checkNotNullExpressionValue(string, "strings.getString(index)");
        return string;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.InterfaceC11704c
    public boolean isLocalClassName(int i) {
        return m9815a(i).getThird().booleanValue();
    }
}
