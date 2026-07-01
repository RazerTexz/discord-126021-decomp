package b.o.a.q;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'j' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:485)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:422)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:351)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:284)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:153)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: compiled from: GestureAction.java */
/* JADX INFO: loaded from: classes3.dex */
public final class b {
    public static final b j;
    public static final b k;
    public static final b l;
    public static final b m;
    public static final b n;
    public static final b o;
    public static final b p;
    public static final b q;
    public static final /* synthetic */ b[] r;
    private d type;
    private int value;

    static {
        d dVar = d.ONE_SHOT;
        b bVar = new b("NONE", 0, 0, dVar);
        j = bVar;
        b bVar2 = new b("AUTO_FOCUS", 1, 1, dVar);
        k = bVar2;
        b bVar3 = new b("TAKE_PICTURE", 2, 2, dVar);
        l = bVar3;
        b bVar4 = new b("TAKE_PICTURE_SNAPSHOT", 3, 3, dVar);
        m = bVar4;
        d dVar2 = d.CONTINUOUS;
        b bVar5 = new b("ZOOM", 4, 4, dVar2);
        n = bVar5;
        b bVar6 = new b("EXPOSURE_CORRECTION", 5, 5, dVar2);
        o = bVar6;
        b bVar7 = new b("FILTER_CONTROL_1", 6, 6, dVar2);
        p = bVar7;
        b bVar8 = new b("FILTER_CONTROL_2", 7, 7, dVar2);
        q = bVar8;
        r = new b[]{bVar, bVar2, bVar3, bVar4, bVar5, bVar6, bVar7, bVar8};
    }

    public b(String str, @NonNull int i, int i2, d dVar) {
        super(str, i);
        this.value = i2;
        this.type = dVar;
    }

    @Nullable
    public static b f(int i) {
        b[] bVarArrValues = values();
        for (int i2 = 0; i2 < 8; i2++) {
            b bVar = bVarArrValues[i2];
            if (bVar.value == i) {
                return bVar;
            }
        }
        return null;
    }

    public static b valueOf(String str) {
        return (b) Enum.valueOf(b.class, str);
    }

    public static b[] values() {
        return (b[]) r.clone();
    }

    @NonNull
    public d g() {
        return this.type;
    }

    public int h() {
        return this.value;
    }
}
