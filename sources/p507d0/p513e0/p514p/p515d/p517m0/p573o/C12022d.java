package p507d0.p513e0.p514p.p515d.p517m0.p573o;

import com.discord.models.domain.ModelAuditLogEntry;
import java.util.Collection;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.Regex;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11472x;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11716e;
import p507d0.p513e0.p514p.p515d.p517m0.p573o.AbstractC12021c;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.o.d */
/* JADX INFO: compiled from: modifierChecks.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12022d {

    /* JADX INFO: renamed from: a */
    public final C11716e f24903a;

    /* JADX INFO: renamed from: b */
    public final Regex f24904b;

    /* JADX INFO: renamed from: c */
    public final Collection<C11716e> f24905c;

    /* JADX INFO: renamed from: d */
    public final Function1<InterfaceC11472x, String> f24906d;

    /* JADX INFO: renamed from: e */
    public final InterfaceC12020b[] f24907e;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.o.d$a */
    /* JADX INFO: compiled from: modifierChecks.kt */
    public static final class a extends AbstractC12240o implements Function1 {

        /* JADX INFO: renamed from: j */
        public static final a f24908j = new a();

        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Void invoke(InterfaceC11472x interfaceC11472x) {
            C12238m.checkNotNullParameter(interfaceC11472x, "<this>");
            return null;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.o.d$b */
    /* JADX INFO: compiled from: modifierChecks.kt */
    public static final class b extends AbstractC12240o implements Function1 {

        /* JADX INFO: renamed from: j */
        public static final b f24909j = new b();

        public b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Void invoke(InterfaceC11472x interfaceC11472x) {
            C12238m.checkNotNullParameter(interfaceC11472x, "<this>");
            return null;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.o.d$c */
    /* JADX INFO: compiled from: modifierChecks.kt */
    public static final class c extends AbstractC12240o implements Function1 {

        /* JADX INFO: renamed from: j */
        public static final c f24910j = new c();

        public c() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Void invoke(InterfaceC11472x interfaceC11472x) {
            C12238m.checkNotNullParameter(interfaceC11472x, "<this>");
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C12022d(C11716e c11716e, Regex regex, Collection<C11716e> collection, Function1<? super InterfaceC11472x, String> function1, InterfaceC12020b... interfaceC12020bArr) {
        this.f24903a = null;
        this.f24904b = regex;
        this.f24905c = collection;
        this.f24906d = function1;
        this.f24907e = interfaceC12020bArr;
    }

    public final AbstractC12021c checkAll(InterfaceC11472x interfaceC11472x) {
        C12238m.checkNotNullParameter(interfaceC11472x, "functionDescriptor");
        InterfaceC12020b[] interfaceC12020bArr = this.f24907e;
        int length = interfaceC12020bArr.length;
        int i = 0;
        while (i < length) {
            InterfaceC12020b interfaceC12020b = interfaceC12020bArr[i];
            i++;
            String strInvoke = interfaceC12020b.invoke(interfaceC11472x);
            if (strInvoke != null) {
                return new AbstractC12021c.b(strInvoke);
            }
        }
        String strInvoke2 = this.f24906d.invoke(interfaceC11472x);
        return strInvoke2 != null ? new AbstractC12021c.b(strInvoke2) : AbstractC12021c.c.f24902b;
    }

    public final boolean isApplicable(InterfaceC11472x interfaceC11472x) {
        C12238m.checkNotNullParameter(interfaceC11472x, "functionDescriptor");
        if (this.f24903a != null && !C12238m.areEqual(interfaceC11472x.getName(), this.f24903a)) {
            return false;
        }
        if (this.f24904b != null) {
            String strAsString = interfaceC11472x.getName().asString();
            C12238m.checkNotNullExpressionValue(strAsString, "functionDescriptor.name.asString()");
            if (!this.f24904b.matches(strAsString)) {
                return false;
            }
        }
        Collection<C11716e> collection = this.f24905c;
        return collection == null || collection.contains(interfaceC11472x.getName());
    }

    public /* synthetic */ C12022d(C11716e c11716e, InterfaceC12020b[] interfaceC12020bArr, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(c11716e, interfaceC12020bArr, (Function1<? super InterfaceC11472x, String>) ((i & 4) != 0 ? a.f24908j : function1));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C12022d(C11716e c11716e, InterfaceC12020b[] interfaceC12020bArr, Function1<? super InterfaceC11472x, String> function1) {
        C12238m.checkNotNullParameter(c11716e, ModelAuditLogEntry.CHANGE_KEY_NAME);
        C12238m.checkNotNullParameter(interfaceC12020bArr, "checks");
        C12238m.checkNotNullParameter(function1, "additionalChecks");
        InterfaceC12020b[] interfaceC12020bArr2 = new InterfaceC12020b[interfaceC12020bArr.length];
        System.arraycopy(interfaceC12020bArr, 0, interfaceC12020bArr2, 0, interfaceC12020bArr.length);
        this.f24903a = c11716e;
        this.f24904b = null;
        this.f24905c = null;
        this.f24906d = function1;
        this.f24907e = interfaceC12020bArr2;
    }

    public /* synthetic */ C12022d(Regex regex, InterfaceC12020b[] interfaceC12020bArr, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(regex, interfaceC12020bArr, (Function1<? super InterfaceC11472x, String>) ((i & 4) != 0 ? b.f24909j : function1));
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public C12022d(Regex regex, InterfaceC12020b[] interfaceC12020bArr, Function1<? super InterfaceC11472x, String> function1) {
        C12238m.checkNotNullParameter(regex, "regex");
        C12238m.checkNotNullParameter(interfaceC12020bArr, "checks");
        C12238m.checkNotNullParameter(function1, "additionalChecks");
        InterfaceC12020b[] interfaceC12020bArr2 = new InterfaceC12020b[interfaceC12020bArr.length];
        System.arraycopy(interfaceC12020bArr, 0, interfaceC12020bArr2, 0, interfaceC12020bArr.length);
        this((C11716e) null, regex, (Collection<C11716e>) null, function1, interfaceC12020bArr2);
    }

    public /* synthetic */ C12022d(Collection collection, InterfaceC12020b[] interfaceC12020bArr, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((Collection<C11716e>) collection, interfaceC12020bArr, (Function1<? super InterfaceC11472x, String>) ((i & 4) != 0 ? c.f24910j : function1));
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public C12022d(Collection<C11716e> collection, InterfaceC12020b[] interfaceC12020bArr, Function1<? super InterfaceC11472x, String> function1) {
        C12238m.checkNotNullParameter(collection, "nameList");
        C12238m.checkNotNullParameter(interfaceC12020bArr, "checks");
        C12238m.checkNotNullParameter(function1, "additionalChecks");
        InterfaceC12020b[] interfaceC12020bArr2 = new InterfaceC12020b[interfaceC12020bArr.length];
        System.arraycopy(interfaceC12020bArr, 0, interfaceC12020bArr2, 0, interfaceC12020bArr.length);
        this((C11716e) null, (Regex) null, collection, function1, interfaceC12020bArr2);
    }
}
