package d0.e0.p.d.m0.e.b;

import androidx.exifinterface.media.ExifInterface;
import com.discord.models.domain.ModelAuditLogEntry;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: AbstractBinaryClassAnnotationAndConstantLoader.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b implements p$d {
    public final /* synthetic */ a<A, C> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ HashMap<s, List<A>> f3364b;
    public final /* synthetic */ HashMap<s, C> c;

    public b(a<A, C> aVar, HashMap<s, List<A>> map, HashMap<s, C> map2) {
        this.a = aVar;
        this.f3364b = map;
        this.c = map2;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // d0.e0.p.d.m0.e.b.p$d
    public p$c visitField(d0.e0.p.d.m0.g.e eVar, String str, Object obj) {
        d0.z.d.m.checkNotNullParameter(eVar, ModelAuditLogEntry.CHANGE_KEY_NAME);
        d0.z.d.m.checkNotNullParameter(str, "desc");
        s$a s_a = s.a;
        String strAsString = eVar.asString();
        d0.z.d.m.checkNotNullExpressionValue(strAsString, "name.asString()");
        s sVarFromFieldNameAndDesc = s_a.fromFieldNameAndDesc(strAsString, str);
        if (obj != null) {
            Objects.requireNonNull((c) this.a);
            d0.z.d.m.checkNotNullParameter(str, "desc");
            d0.z.d.m.checkNotNullParameter(obj, "initializer");
            if (d0.g0.w.contains$default((CharSequence) "ZBCS", (CharSequence) str, false, 2, (Object) null)) {
                int iIntValue = ((Integer) obj).intValue();
                int iHashCode = str.hashCode();
                if (iHashCode == 66) {
                    if (str.equals("B")) {
                        obj = Byte.valueOf((byte) iIntValue);
                    }
                    throw new AssertionError(str);
                }
                if (iHashCode == 67) {
                    if (str.equals("C")) {
                        obj = Character.valueOf((char) iIntValue);
                    }
                    throw new AssertionError(str);
                }
                if (iHashCode == 83) {
                    if (str.equals(ExifInterface.LATITUDE_SOUTH)) {
                        obj = Short.valueOf((short) iIntValue);
                    }
                    throw new AssertionError(str);
                }
                if (iHashCode == 90 && str.equals("Z")) {
                    obj = Boolean.valueOf(iIntValue != 0);
                }
                throw new AssertionError(str);
            }
            Object objCreateConstantValue = d0.e0.p.d.m0.k.v.h.a.createConstantValue(obj);
            if (objCreateConstantValue != null) {
                this.c.put(sVarFromFieldNameAndDesc, (C) objCreateConstantValue);
            }
        }
        return new b$b(this, sVarFromFieldNameAndDesc);
    }

    @Override // d0.e0.p.d.m0.e.b.p$d
    public p$e visitMethod(d0.e0.p.d.m0.g.e eVar, String str) {
        d0.z.d.m.checkNotNullParameter(eVar, ModelAuditLogEntry.CHANGE_KEY_NAME);
        d0.z.d.m.checkNotNullParameter(str, "desc");
        s$a s_a = s.a;
        String strAsString = eVar.asString();
        d0.z.d.m.checkNotNullExpressionValue(strAsString, "name.asString()");
        return new b$a(this, s_a.fromMethodNameAndDesc(strAsString, str));
    }
}
