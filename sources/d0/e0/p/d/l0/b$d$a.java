package d0.e0.p.d.l0;

import d0.z.d.m;
import d0.z.d.o;
import java.util.Arrays;
import java.util.Map$Entry;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: AnnotationConstructorCaller.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b$d$a extends o implements Function1<Map$Entry<? extends String, ? extends Object>, CharSequence> {
    public static final b$d$a j = new b$d$a();

    public b$d$a() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final CharSequence invoke2(Map$Entry<String, ? extends Object> map$Entry) {
        String string;
        m.checkNotNullParameter(map$Entry, "entry");
        String key = map$Entry.getKey();
        Object value = map$Entry.getValue();
        if (value instanceof boolean[]) {
            string = Arrays.toString((boolean[]) value);
        } else if (value instanceof char[]) {
            string = Arrays.toString((char[]) value);
        } else if (value instanceof byte[]) {
            string = Arrays.toString((byte[]) value);
        } else if (value instanceof short[]) {
            string = Arrays.toString((short[]) value);
        } else if (value instanceof int[]) {
            string = Arrays.toString((int[]) value);
        } else if (value instanceof float[]) {
            string = Arrays.toString((float[]) value);
        } else if (value instanceof long[]) {
            string = Arrays.toString((long[]) value);
        } else if (value instanceof double[]) {
            string = Arrays.toString((double[]) value);
        } else {
            string = value instanceof Object[] ? Arrays.toString((Object[]) value) : value.toString();
        }
        return key + '=' + string;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ CharSequence invoke(Map$Entry<? extends String, ? extends Object> map$Entry) {
        return invoke2((Map$Entry<String, ? extends Object>) map$Entry);
    }
}
