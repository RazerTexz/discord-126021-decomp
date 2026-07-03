package p507d0.p579g0;

import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.IntRange;
import kotlin.text.MatchResult;
import p507d0.p512d0.C11226f;
import p507d0.p578f0.C12078q;
import p507d0.p580t.AbstractC12121a;
import p507d0.p580t.AbstractC12125c;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.g0.g */
/* JADX INFO: compiled from: Regex.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12090g implements MatchResult {

    /* JADX INFO: renamed from: a */
    public final InterfaceC12089f f25152a;

    /* JADX INFO: renamed from: b */
    public List<String> f25153b;

    /* JADX INFO: renamed from: c */
    public final Matcher f25154c;

    /* JADX INFO: renamed from: d */
    public final CharSequence f25155d;

    /* JADX INFO: renamed from: d0.g0.g$a */
    /* JADX INFO: compiled from: Regex.kt */
    public static final class a extends AbstractC12125c<String> {
        public a() {
        }

        @Override // p507d0.p580t.AbstractC12121a, java.util.Collection, java.util.List
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof String) {
                return contains((String) obj);
            }
            return false;
        }

        @Override // p507d0.p580t.AbstractC12121a
        public int getSize() {
            return C12090g.this.f25154c.groupCount() + 1;
        }

        @Override // p507d0.p580t.AbstractC12125c, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof String) {
                return indexOf((String) obj);
            }
            return -1;
        }

        @Override // p507d0.p580t.AbstractC12125c, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof String) {
                return lastIndexOf((String) obj);
            }
            return -1;
        }

        public /* bridge */ boolean contains(String str) {
            return super.contains((Object) str);
        }

        @Override // p507d0.p580t.AbstractC12125c, java.util.List
        public String get(int i) {
            String strGroup = C12090g.this.f25154c.group(i);
            return strGroup != null ? strGroup : "";
        }

        public /* bridge */ int indexOf(String str) {
            return super.indexOf((Object) str);
        }

        public /* bridge */ int lastIndexOf(String str) {
            return super.lastIndexOf((Object) str);
        }
    }

    /* JADX INFO: renamed from: d0.g0.g$b */
    /* JADX INFO: compiled from: Regex.kt */
    public static final class b extends AbstractC12121a<C12088e> implements InterfaceC12089f {

        /* JADX INFO: renamed from: d0.g0.g$b$a */
        /* JADX INFO: compiled from: Regex.kt */
        public static final class a extends AbstractC12240o implements Function1<Integer, C12088e> {
            public a() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ C12088e invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final C12088e invoke(int i) {
                return b.this.get(i);
            }
        }

        public b() {
        }

        @Override // p507d0.p580t.AbstractC12121a, java.util.Collection, java.util.List
        public final /* bridge */ boolean contains(Object obj) {
            if (obj != null ? obj instanceof C12088e : true) {
                return contains((C12088e) obj);
            }
            return false;
        }

        public C12088e get(int i) {
            java.util.regex.MatchResult matchResult = C12090g.this.f25154c;
            IntRange intRangeUntil = C11226f.until(matchResult.start(i), matchResult.end(i));
            if (intRangeUntil.getStart().intValue() < 0) {
                return null;
            }
            String strGroup = C12090g.this.f25154c.group(i);
            C12238m.checkNotNullExpressionValue(strGroup, "matchResult.group(index)");
            return new C12088e(strGroup, intRangeUntil);
        }

        @Override // p507d0.p580t.AbstractC12121a
        public int getSize() {
            return C12090g.this.f25154c.groupCount() + 1;
        }

        @Override // p507d0.p580t.AbstractC12121a, java.util.Collection
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Iterator<C12088e> iterator() {
            return C12078q.map(C12163u.asSequence(C12147n.getIndices(this)), new a()).iterator();
        }

        public /* bridge */ boolean contains(C12088e c12088e) {
            return super.contains((Object) c12088e);
        }
    }

    public C12090g(Matcher matcher, CharSequence charSequence) {
        C12238m.checkNotNullParameter(matcher, "matcher");
        C12238m.checkNotNullParameter(charSequence, "input");
        this.f25154c = matcher;
        this.f25155d = charSequence;
        this.f25152a = new b();
    }

    @Override // kotlin.text.MatchResult
    public MatchResult.C12798b getDestructured() {
        return MatchResult.C12797a.getDestructured(this);
    }

    @Override // kotlin.text.MatchResult
    public List<String> getGroupValues() {
        if (this.f25153b == null) {
            this.f25153b = new a();
        }
        List<String> list = this.f25153b;
        C12238m.checkNotNull(list);
        return list;
    }

    @Override // kotlin.text.MatchResult
    public InterfaceC12089f getGroups() {
        return this.f25152a;
    }

    @Override // kotlin.text.MatchResult
    public IntRange getRange() {
        Matcher matcher = this.f25154c;
        return C11226f.until(matcher.start(), matcher.end());
    }

    @Override // kotlin.text.MatchResult
    public String getValue() {
        String strGroup = this.f25154c.group();
        C12238m.checkNotNullExpressionValue(strGroup, "matchResult.group()");
        return strGroup;
    }

    @Override // kotlin.text.MatchResult
    public MatchResult next() {
        int iEnd = this.f25154c.end() + (this.f25154c.end() == this.f25154c.start() ? 1 : 0);
        if (iEnd > this.f25155d.length()) {
            return null;
        }
        Matcher matcher = this.f25154c.pattern().matcher(this.f25155d);
        C12238m.checkNotNullExpressionValue(matcher, "matcher.pattern().matcher(input)");
        return C12091h.access$findNext(matcher, iEnd, this.f25155d);
    }
}
