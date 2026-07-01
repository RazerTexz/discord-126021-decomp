package d0.e0.p.d.m0.e.a.l0;

import androidx.exifinterface.media.ExifInterface;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.Tuples;
import d0.d0._Ranges;
import d0.e0.p.d.m0.e.b.SignatureBuildingComponents;
import d0.e0.p.d.m0.k.y.JvmPrimitiveType;
import d0.t.IndexedValue;
import d0.t.Iterables2;
import d0.t.MapsJVM;
import d0.t._Arrays;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Tuples2;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.l0.q, reason: use source file name */
/* JADX INFO: compiled from: predefinedEnhancementInfo.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class predefinedEnhancementInfo3 {
    public final Map<String, predefinedEnhancementInfo2> a = new LinkedHashMap();

    public final Map<String, predefinedEnhancementInfo2> build() {
        return this.a;
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.l0.q$a */
    /* JADX INFO: compiled from: predefinedEnhancementInfo.kt */
    public final class a {
        public final String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ predefinedEnhancementInfo3 f3351b;

        public a(predefinedEnhancementInfo3 predefinedenhancementinfo3, String str) {
            Intrinsics3.checkNotNullParameter(predefinedenhancementinfo3, "this$0");
            Intrinsics3.checkNotNullParameter(str, "className");
            this.f3351b = predefinedenhancementinfo3;
            this.a = str;
        }

        public final void function(String str, Function1<? super C0387a, Unit> function1) {
            Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
            Intrinsics3.checkNotNullParameter(function1, "block");
            Map map = this.f3351b.a;
            C0387a c0387a = new C0387a(this, str);
            function1.invoke(c0387a);
            Tuples2<String, predefinedEnhancementInfo2> tuples2Build = c0387a.build();
            map.put(tuples2Build.getFirst(), tuples2Build.getSecond());
        }

        public final String getClassName() {
            return this.a;
        }

        /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.l0.q$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: predefinedEnhancementInfo.kt */
        public final class C0387a {
            public final String a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final List<Tuples2<String, predefinedEnhancementInfo4>> f3352b;
            public Tuples2<String, predefinedEnhancementInfo4> c;
            public final /* synthetic */ a d;

            public C0387a(a aVar, String str) {
                Intrinsics3.checkNotNullParameter(aVar, "this$0");
                Intrinsics3.checkNotNullParameter(str, "functionName");
                this.d = aVar;
                this.a = str;
                this.f3352b = new ArrayList();
                this.c = Tuples.to(ExifInterface.GPS_MEASUREMENT_INTERRUPTED, null);
            }

            public final Tuples2<String, predefinedEnhancementInfo2> build() {
                SignatureBuildingComponents signatureBuildingComponents = SignatureBuildingComponents.a;
                String className = this.d.getClassName();
                String functionName = getFunctionName();
                List<Tuples2<String, predefinedEnhancementInfo4>> list = this.f3352b;
                ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(list, 10));
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add((String) ((Tuples2) it.next()).getFirst());
                }
                String strSignature = signatureBuildingComponents.signature(className, signatureBuildingComponents.jvmDescriptor(functionName, arrayList, this.c.getFirst()));
                predefinedEnhancementInfo4 second = this.c.getSecond();
                List<Tuples2<String, predefinedEnhancementInfo4>> list2 = this.f3352b;
                ArrayList arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(list2, 10));
                Iterator<T> it2 = list2.iterator();
                while (it2.hasNext()) {
                    arrayList2.add((predefinedEnhancementInfo4) ((Tuples2) it2.next()).getSecond());
                }
                return Tuples.to(strSignature, new predefinedEnhancementInfo2(second, arrayList2));
            }

            public final String getFunctionName() {
                return this.a;
            }

            public final void parameter(String str, typeQualifiers... typequalifiersArr) {
                predefinedEnhancementInfo4 predefinedenhancementinfo4;
                Intrinsics3.checkNotNullParameter(str, "type");
                Intrinsics3.checkNotNullParameter(typequalifiersArr, "qualifiers");
                List<Tuples2<String, predefinedEnhancementInfo4>> list = this.f3352b;
                if (typequalifiersArr.length == 0) {
                    predefinedenhancementinfo4 = null;
                } else {
                    Iterable<IndexedValue> iterableWithIndex = _Arrays.withIndex(typequalifiersArr);
                    LinkedHashMap linkedHashMap = new LinkedHashMap(_Ranges.coerceAtLeast(MapsJVM.mapCapacity(Iterables2.collectionSizeOrDefault(iterableWithIndex, 10)), 16));
                    for (IndexedValue indexedValue : iterableWithIndex) {
                        linkedHashMap.put(Integer.valueOf(indexedValue.getIndex()), (typeQualifiers) indexedValue.getValue());
                    }
                    predefinedenhancementinfo4 = new predefinedEnhancementInfo4(linkedHashMap);
                }
                list.add(Tuples.to(str, predefinedenhancementinfo4));
            }

            public final void returns(String str, typeQualifiers... typequalifiersArr) {
                Intrinsics3.checkNotNullParameter(str, "type");
                Intrinsics3.checkNotNullParameter(typequalifiersArr, "qualifiers");
                Iterable<IndexedValue> iterableWithIndex = _Arrays.withIndex(typequalifiersArr);
                LinkedHashMap linkedHashMap = new LinkedHashMap(_Ranges.coerceAtLeast(MapsJVM.mapCapacity(Iterables2.collectionSizeOrDefault(iterableWithIndex, 10)), 16));
                for (IndexedValue indexedValue : iterableWithIndex) {
                    linkedHashMap.put(Integer.valueOf(indexedValue.getIndex()), (typeQualifiers) indexedValue.getValue());
                }
                this.c = Tuples.to(str, new predefinedEnhancementInfo4(linkedHashMap));
            }

            public final void returns(JvmPrimitiveType jvmPrimitiveType) {
                Intrinsics3.checkNotNullParameter(jvmPrimitiveType, "type");
                String desc = jvmPrimitiveType.getDesc();
                Intrinsics3.checkNotNullExpressionValue(desc, "type.desc");
                this.c = Tuples.to(desc, null);
            }
        }
    }
}
