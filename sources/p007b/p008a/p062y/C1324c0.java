package p007b.p008a.p062y;

import java.io.Serializable;
import org.objectweb.asm.Opcodes;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.a.y.c0 */
/* JADX INFO: compiled from: SelectorBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C1324c0 implements Serializable {
    private final CharSequence description;
    private final Integer iconRes;
    private final Integer iconTint;
    private final String iconUri;
    private final String title;
    private final Integer titleEndIcon;
    private final Integer titleTextColor;

    public C1324c0() {
        this(null, null, null, null, null, null, null, Opcodes.LAND);
    }

    public C1324c0(String str, CharSequence charSequence, Integer num, String str2, Integer num2, Integer num3, Integer num4, int i) {
        str = (i & 1) != 0 ? null : str;
        charSequence = (i & 2) != 0 ? null : charSequence;
        num = (i & 4) != 0 ? null : num;
        str2 = (i & 8) != 0 ? null : str2;
        int i2 = i & 16;
        num3 = (i & 32) != 0 ? null : num3;
        int i3 = i & 64;
        this.title = str;
        this.description = charSequence;
        this.iconRes = num;
        this.iconUri = str2;
        this.iconTint = null;
        this.titleTextColor = num3;
        this.titleEndIcon = null;
    }

    /* JADX INFO: renamed from: a */
    public final CharSequence m380a() {
        return this.description;
    }

    /* JADX INFO: renamed from: b */
    public final Integer m381b() {
        return this.iconRes;
    }

    /* JADX INFO: renamed from: c */
    public final Integer m382c() {
        return this.iconTint;
    }

    /* JADX INFO: renamed from: d */
    public final String m383d() {
        return this.iconUri;
    }

    /* JADX INFO: renamed from: e */
    public final String m384e() {
        return this.title;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1324c0)) {
            return false;
        }
        C1324c0 c1324c0 = (C1324c0) obj;
        return C12238m.areEqual(this.title, c1324c0.title) && C12238m.areEqual(this.description, c1324c0.description) && C12238m.areEqual(this.iconRes, c1324c0.iconRes) && C12238m.areEqual(this.iconUri, c1324c0.iconUri) && C12238m.areEqual(this.iconTint, c1324c0.iconTint) && C12238m.areEqual(this.titleTextColor, c1324c0.titleTextColor) && C12238m.areEqual(this.titleEndIcon, c1324c0.titleEndIcon);
    }

    /* JADX INFO: renamed from: f */
    public final Integer m385f() {
        return this.titleEndIcon;
    }

    /* JADX INFO: renamed from: g */
    public final Integer m386g() {
        return this.titleTextColor;
    }

    public int hashCode() {
        String str = this.title;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        CharSequence charSequence = this.description;
        int iHashCode2 = (iHashCode + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        Integer num = this.iconRes;
        int iHashCode3 = (iHashCode2 + (num != null ? num.hashCode() : 0)) * 31;
        String str2 = this.iconUri;
        int iHashCode4 = (iHashCode3 + (str2 != null ? str2.hashCode() : 0)) * 31;
        Integer num2 = this.iconTint;
        int iHashCode5 = (iHashCode4 + (num2 != null ? num2.hashCode() : 0)) * 31;
        Integer num3 = this.titleTextColor;
        int iHashCode6 = (iHashCode5 + (num3 != null ? num3.hashCode() : 0)) * 31;
        Integer num4 = this.titleEndIcon;
        return iHashCode6 + (num4 != null ? num4.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("SimpleBottomSheetItem(title=");
        sbM833U.append(this.title);
        sbM833U.append(", description=");
        sbM833U.append(this.description);
        sbM833U.append(", iconRes=");
        sbM833U.append(this.iconRes);
        sbM833U.append(", iconUri=");
        sbM833U.append(this.iconUri);
        sbM833U.append(", iconTint=");
        sbM833U.append(this.iconTint);
        sbM833U.append(", titleTextColor=");
        sbM833U.append(this.titleTextColor);
        sbM833U.append(", titleEndIcon=");
        return C1643a.m818F(sbM833U, this.titleEndIcon, ")");
    }
}
