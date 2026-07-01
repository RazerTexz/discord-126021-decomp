package d0.e0.p.d;

import d0.e0.p.d.m0.c.c1;
import d0.e0.p.d.m0.c.q0;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: KCallableImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class f$b extends d0.z.d.o implements Function0<ArrayList<d0.e0.f>> {
    public final /* synthetic */ f this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f$b(f fVar) {
        super(0);
        this.this$0 = fVar;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ ArrayList<d0.e0.f> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final ArrayList<d0.e0.f> invoke2() {
        int i;
        d0.e0.p.d.m0.c.b descriptor = this.this$0.getDescriptor();
        ArrayList<d0.e0.f> arrayList = new ArrayList<>();
        int i2 = 0;
        if (this.this$0.isBound()) {
            i = 0;
        } else {
            q0 instanceReceiverParameter = j0.getInstanceReceiverParameter(descriptor);
            if (instanceReceiverParameter != null) {
                arrayList.add(new o(this.this$0, 0, d0.e0.f$a.INSTANCE, new f$b$b(instanceReceiverParameter)));
                i = 1;
            } else {
                i = 0;
            }
            q0 extensionReceiverParameter = descriptor.getExtensionReceiverParameter();
            if (extensionReceiverParameter != null) {
                arrayList.add(new o(this.this$0, i, d0.e0.f$a.EXTENSION_RECEIVER, new f$b$c(extensionReceiverParameter)));
                i++;
            }
        }
        List<c1> valueParameters = descriptor.getValueParameters();
        d0.z.d.m.checkNotNullExpressionValue(valueParameters, "descriptor.valueParameters");
        int size = valueParameters.size();
        while (i2 < size) {
            arrayList.add(new o(this.this$0, i, d0.e0.f$a.VALUE, new f$b$d(descriptor, i2)));
            i2++;
            i++;
        }
        if (this.this$0.b() && (descriptor instanceof d0.e0.p.d.m0.e.a.h0.b) && arrayList.size() > 1) {
            d0.t.q.sortWith(arrayList, new f$b$a());
        }
        arrayList.trimToSize();
        return arrayList;
    }
}
