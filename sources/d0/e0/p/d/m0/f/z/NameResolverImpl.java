package d0.e0.p.d.m0.f.z;

import com.discord.widgets.chat.input.MentionUtils;
import com.discord.widgets.chat.input.autocomplete.AutocompleteViewModel;
import d0.e0.p.d.m0.f.o;
import d0.e0.p.d.m0.f.p;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import java.util.LinkedList;
import java.util.List;
import kotlin.Tuples3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.f.z.d, reason: use source file name */
/* JADX INFO: compiled from: NameResolverImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class NameResolverImpl implements NameResolver {
    public final p a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o f3418b;

    public NameResolverImpl(p pVar, o oVar) {
        Intrinsics3.checkNotNullParameter(pVar, "strings");
        Intrinsics3.checkNotNullParameter(oVar, "qualifiedNames");
        this.a = pVar;
        this.f3418b = oVar;
    }

    public final Tuples3<List<String>, List<String>, Boolean> a(int i) {
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        boolean z2 = false;
        while (i != -1) {
            o.c qualifiedName = this.f3418b.getQualifiedName(i);
            String string = this.a.getString(qualifiedName.getShortName());
            o.c.EnumC0398c kind = qualifiedName.getKind();
            Intrinsics3.checkNotNull(kind);
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
        return new Tuples3<>(linkedList, linkedList2, Boolean.valueOf(z2));
    }

    @Override // d0.e0.p.d.m0.f.z.NameResolver
    public String getQualifiedClassName(int i) {
        Tuples3<List<String>, List<String>, Boolean> tuples3A = a(i);
        List<String> listComponent1 = tuples3A.component1();
        String strJoinToString$default = _Collections.joinToString$default(tuples3A.component2(), ".", null, null, 0, null, null, 62, null);
        if (listComponent1.isEmpty()) {
            return strJoinToString$default;
        }
        return _Collections.joinToString$default(listComponent1, AutocompleteViewModel.COMMAND_DISCOVER_TOKEN, null, null, 0, null, null, 62, null) + MentionUtils.SLASH_CHAR + strJoinToString$default;
    }

    @Override // d0.e0.p.d.m0.f.z.NameResolver
    public String getString(int i) {
        String string = this.a.getString(i);
        Intrinsics3.checkNotNullExpressionValue(string, "strings.getString(index)");
        return string;
    }

    @Override // d0.e0.p.d.m0.f.z.NameResolver
    public boolean isLocalClassName(int i) {
        return a(i).getThird().booleanValue();
    }
}
