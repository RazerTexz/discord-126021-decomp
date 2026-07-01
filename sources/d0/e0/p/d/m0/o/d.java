package d0.e0.p.d.m0.o;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.p.d.m0.c.FunctionDescriptor;
import d0.e0.p.d.m0.g.Name;
import d0.e0.p.d.m0.o.c;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Collection;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.Regex;

/* JADX INFO: compiled from: modifierChecks.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d {
    public final Name a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Regex f3547b;
    public final Collection<Name> c;
    public final Function1<FunctionDescriptor, String> d;
    public final d0.e0.p.d.m0.o.b[] e;

    /* JADX INFO: compiled from: modifierChecks.kt */
    public static final class a extends Lambda implements Function1 {
        public static final a j = new a();

        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Void invoke(FunctionDescriptor functionDescriptor) {
            Intrinsics3.checkNotNullParameter(functionDescriptor, "<this>");
            return null;
        }
    }

    /* JADX INFO: compiled from: modifierChecks.kt */
    public static final class b extends Lambda implements Function1 {
        public static final b j = new b();

        public b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Void invoke(FunctionDescriptor functionDescriptor) {
            Intrinsics3.checkNotNullParameter(functionDescriptor, "<this>");
            return null;
        }
    }

    /* JADX INFO: compiled from: modifierChecks.kt */
    public static final class c extends Lambda implements Function1 {
        public static final c j = new c();

        public c() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Void invoke(FunctionDescriptor functionDescriptor) {
            Intrinsics3.checkNotNullParameter(functionDescriptor, "<this>");
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d(Name name, Regex regex, Collection<Name> collection, Function1<? super FunctionDescriptor, String> function1, d0.e0.p.d.m0.o.b... bVarArr) {
        this.a = null;
        this.f3547b = regex;
        this.c = collection;
        this.d = function1;
        this.e = bVarArr;
    }

    public final d0.e0.p.d.m0.o.c checkAll(FunctionDescriptor functionDescriptor) {
        Intrinsics3.checkNotNullParameter(functionDescriptor, "functionDescriptor");
        d0.e0.p.d.m0.o.b[] bVarArr = this.e;
        int length = bVarArr.length;
        int i = 0;
        while (i < length) {
            d0.e0.p.d.m0.o.b bVar = bVarArr[i];
            i++;
            String strInvoke = bVar.invoke(functionDescriptor);
            if (strInvoke != null) {
                return new c.b(strInvoke);
            }
        }
        String strInvoke2 = this.d.invoke(functionDescriptor);
        return strInvoke2 != null ? new c.b(strInvoke2) : c.C0416c.f3546b;
    }

    public final boolean isApplicable(FunctionDescriptor functionDescriptor) {
        Intrinsics3.checkNotNullParameter(functionDescriptor, "functionDescriptor");
        if (this.a != null && !Intrinsics3.areEqual(functionDescriptor.getName(), this.a)) {
            return false;
        }
        if (this.f3547b != null) {
            String strAsString = functionDescriptor.getName().asString();
            Intrinsics3.checkNotNullExpressionValue(strAsString, "functionDescriptor.name.asString()");
            if (!this.f3547b.matches(strAsString)) {
                return false;
            }
        }
        Collection<Name> collection = this.c;
        return collection == null || collection.contains(functionDescriptor.getName());
    }

    public /* synthetic */ d(Name name, d0.e0.p.d.m0.o.b[] bVarArr, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(name, bVarArr, (Function1<? super FunctionDescriptor, String>) ((i & 4) != 0 ? a.j : function1));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d(Name name, d0.e0.p.d.m0.o.b[] bVarArr, Function1<? super FunctionDescriptor, String> function1) {
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(bVarArr, "checks");
        Intrinsics3.checkNotNullParameter(function1, "additionalChecks");
        d0.e0.p.d.m0.o.b[] bVarArr2 = new d0.e0.p.d.m0.o.b[bVarArr.length];
        System.arraycopy(bVarArr, 0, bVarArr2, 0, bVarArr.length);
        this.a = name;
        this.f3547b = null;
        this.c = null;
        this.d = function1;
        this.e = bVarArr2;
    }

    public /* synthetic */ d(Regex regex, d0.e0.p.d.m0.o.b[] bVarArr, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(regex, bVarArr, (Function1<? super FunctionDescriptor, String>) ((i & 4) != 0 ? b.j : function1));
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public d(Regex regex, d0.e0.p.d.m0.o.b[] bVarArr, Function1<? super FunctionDescriptor, String> function1) {
        Intrinsics3.checkNotNullParameter(regex, "regex");
        Intrinsics3.checkNotNullParameter(bVarArr, "checks");
        Intrinsics3.checkNotNullParameter(function1, "additionalChecks");
        d0.e0.p.d.m0.o.b[] bVarArr2 = new d0.e0.p.d.m0.o.b[bVarArr.length];
        System.arraycopy(bVarArr, 0, bVarArr2, 0, bVarArr.length);
        this((Name) null, regex, (Collection<Name>) null, function1, bVarArr2);
    }

    public /* synthetic */ d(Collection collection, d0.e0.p.d.m0.o.b[] bVarArr, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((Collection<Name>) collection, bVarArr, (Function1<? super FunctionDescriptor, String>) ((i & 4) != 0 ? c.j : function1));
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public d(Collection<Name> collection, d0.e0.p.d.m0.o.b[] bVarArr, Function1<? super FunctionDescriptor, String> function1) {
        Intrinsics3.checkNotNullParameter(collection, "nameList");
        Intrinsics3.checkNotNullParameter(bVarArr, "checks");
        Intrinsics3.checkNotNullParameter(function1, "additionalChecks");
        d0.e0.p.d.m0.o.b[] bVarArr2 = new d0.e0.p.d.m0.o.b[bVarArr.length];
        System.arraycopy(bVarArr, 0, bVarArr2, 0, bVarArr.length);
        this((Name) null, (Regex) null, collection, function1, bVarArr2);
    }
}
