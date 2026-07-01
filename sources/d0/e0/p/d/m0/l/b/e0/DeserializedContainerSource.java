package d0.e0.p.d.m0.l.b.e0;

/* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.e0.e, reason: use source file name */
/* JADX INFO: compiled from: DeserializedContainerSource.kt */
/* JADX INFO: loaded from: classes3.dex */
public enum DeserializedContainerSource {
    STABLE,
    FIR_UNSTABLE,
    IR_UNSTABLE;

    /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
    public static DeserializedContainerSource[] valuesCustom() {
        DeserializedContainerSource[] deserializedContainerSourceArrValuesCustom = values();
        DeserializedContainerSource[] deserializedContainerSourceArr = new DeserializedContainerSource[deserializedContainerSourceArrValuesCustom.length];
        System.arraycopy(deserializedContainerSourceArrValuesCustom, 0, deserializedContainerSourceArr, 0, deserializedContainerSourceArrValuesCustom.length);
        return deserializedContainerSourceArr;
    }
}
