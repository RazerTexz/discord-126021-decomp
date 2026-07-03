package p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p540l0;

import androidx.exifinterface.media.ExifInterface;
import com.discord.models.domain.ModelAuditLogEntry;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.C12116o;
import p507d0.p512d0.C11226f;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.C11662w;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p560y.EnumC11840d;
import p507d0.p580t.C12134g0;
import p507d0.p580t.C12141k;
import p507d0.p580t.C12149o;
import p507d0.p580t.C12168z;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.l0.q */
/* JADX INFO: compiled from: predefinedEnhancementInfo.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11611q {

    /* JADX INFO: renamed from: a */
    public final Map<String, C11605k> f23492a = new LinkedHashMap();

    public final Map<String, C11605k> build() {
        return this.f23492a;
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.l0.q$a */
    /* JADX INFO: compiled from: predefinedEnhancementInfo.kt */
    public final class a {

        /* JADX INFO: renamed from: a */
        public final String f23493a;

        /* JADX INFO: renamed from: b */
        public final /* synthetic */ C11611q f23494b;

        public a(C11611q c11611q, String str) {
            C12238m.checkNotNullParameter(c11611q, "this$0");
            C12238m.checkNotNullParameter(str, "className");
            this.f23494b = c11611q;
            this.f23493a = str;
        }

        public final void function(String str, Function1<? super C13313a, Unit> function1) {
            C12238m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
            C12238m.checkNotNullParameter(function1, "block");
            Map map = this.f23494b.f23492a;
            C13313a c13313a = new C13313a(this, str);
            function1.invoke(c13313a);
            Pair<String, C11605k> pairBuild = c13313a.build();
            map.put(pairBuild.getFirst(), pairBuild.getSecond());
        }

        public final String getClassName() {
            return this.f23493a;
        }

        /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.l0.q$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: predefinedEnhancementInfo.kt */
        public final class C13313a {

            /* JADX INFO: renamed from: a */
            public final String f23495a;

            /* JADX INFO: renamed from: b */
            public final List<Pair<String, C11617w>> f23496b;

            /* JADX INFO: renamed from: c */
            public Pair<String, C11617w> f23497c;

            /* JADX INFO: renamed from: d */
            public final /* synthetic */ a f23498d;

            public C13313a(a aVar, String str) {
                C12238m.checkNotNullParameter(aVar, "this$0");
                C12238m.checkNotNullParameter(str, "functionName");
                this.f23498d = aVar;
                this.f23495a = str;
                this.f23496b = new ArrayList();
                this.f23497c = C12116o.m10073to(ExifInterface.GPS_MEASUREMENT_INTERRUPTED, null);
            }

            public final Pair<String, C11605k> build() {
                C11662w c11662w = C11662w.f23636a;
                String className = this.f23498d.getClassName();
                String functionName = getFunctionName();
                List<Pair<String, C11617w>> list = this.f23496b;
                ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(list, 10));
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add((String) ((Pair) it.next()).getFirst());
                }
                String strSignature = c11662w.signature(className, c11662w.jvmDescriptor(functionName, arrayList, this.f23497c.getFirst()));
                C11617w second = this.f23497c.getSecond();
                List<Pair<String, C11617w>> list2 = this.f23496b;
                ArrayList arrayList2 = new ArrayList(C12149o.collectionSizeOrDefault(list2, 10));
                Iterator<T> it2 = list2.iterator();
                while (it2.hasNext()) {
                    arrayList2.add((C11617w) ((Pair) it2.next()).getSecond());
                }
                return C12116o.m10073to(strSignature, new C11605k(second, arrayList2));
            }

            public final String getFunctionName() {
                return this.f23495a;
            }

            public final void parameter(String str, C11599e... c11599eArr) {
                C11617w c11617w;
                C12238m.checkNotNullParameter(str, "type");
                C12238m.checkNotNullParameter(c11599eArr, "qualifiers");
                List<Pair<String, C11617w>> list = this.f23496b;
                if (c11599eArr.length == 0) {
                    c11617w = null;
                } else {
                    Iterable<C12168z> iterableWithIndex = C12141k.withIndex(c11599eArr);
                    LinkedHashMap linkedHashMap = new LinkedHashMap(C11226f.coerceAtLeast(C12134g0.mapCapacity(C12149o.collectionSizeOrDefault(iterableWithIndex, 10)), 16));
                    for (C12168z c12168z : iterableWithIndex) {
                        linkedHashMap.put(Integer.valueOf(c12168z.getIndex()), (C11599e) c12168z.getValue());
                    }
                    c11617w = new C11617w(linkedHashMap);
                }
                list.add(C12116o.m10073to(str, c11617w));
            }

            public final void returns(String str, C11599e... c11599eArr) {
                C12238m.checkNotNullParameter(str, "type");
                C12238m.checkNotNullParameter(c11599eArr, "qualifiers");
                Iterable<C12168z> iterableWithIndex = C12141k.withIndex(c11599eArr);
                LinkedHashMap linkedHashMap = new LinkedHashMap(C11226f.coerceAtLeast(C12134g0.mapCapacity(C12149o.collectionSizeOrDefault(iterableWithIndex, 10)), 16));
                for (C12168z c12168z : iterableWithIndex) {
                    linkedHashMap.put(Integer.valueOf(c12168z.getIndex()), (C11599e) c12168z.getValue());
                }
                this.f23497c = C12116o.m10073to(str, new C11617w(linkedHashMap));
            }

            public final void returns(EnumC11840d enumC11840d) {
                C12238m.checkNotNullParameter(enumC11840d, "type");
                String desc = enumC11840d.getDesc();
                C12238m.checkNotNullExpressionValue(desc, "type.desc");
                this.f23497c = C12116o.m10073to(desc, null);
            }
        }
    }
}
