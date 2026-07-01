package d0.g0;

/* JADX INFO: compiled from: Regex.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class g$a extends d0.t.c<String> {
    public final /* synthetic */ g k;

    public g$a(g gVar) {
        this.k = gVar;
    }

    @Override // d0.t.a, java.util.Collection, java.util.List
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof String) {
            return contains((String) obj);
        }
        return false;
    }

    @Override // d0.t.c, java.util.List
    public /* bridge */ /* synthetic */ Object get(int i) {
        return get(i);
    }

    @Override // d0.t.a
    public int getSize() {
        return g.access$getMatchResult$p(this.k).groupCount() + 1;
    }

    @Override // d0.t.c, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof String) {
            return indexOf((String) obj);
        }
        return -1;
    }

    @Override // d0.t.c, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof String) {
            return lastIndexOf((String) obj);
        }
        return -1;
    }

    public /* bridge */ boolean contains(String str) {
        return super.contains((Object) str);
    }

    @Override // d0.t.c, java.util.List
    public String get(int i) {
        String strGroup = g.access$getMatchResult$p(this.k).group(i);
        return strGroup != null ? strGroup : "";
    }

    public /* bridge */ int indexOf(String str) {
        return super.indexOf((Object) str);
    }

    public /* bridge */ int lastIndexOf(String str) {
        return super.lastIndexOf((Object) str);
    }
}
