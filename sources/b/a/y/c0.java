package b.a.y;

import java.io.Serializable;
import org.objectweb.asm.Opcodes;

/* JADX INFO: compiled from: SelectorBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class c0 implements Serializable {
    private final CharSequence description;
    private final Integer iconRes;
    private final Integer iconTint;
    private final String iconUri;
    private final String title;
    private final Integer titleEndIcon;
    private final Integer titleTextColor;

    public c0() {
        this(null, null, null, null, null, null, null, Opcodes.LAND);
    }

    public c0(String str, CharSequence charSequence, Integer num, String str2, Integer num2, Integer num3, Integer num4, int i) {
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

    public final CharSequence a() {
        return this.description;
    }

    public final Integer b() {
        return this.iconRes;
    }

    public final Integer c() {
        return this.iconTint;
    }

    public final String d() {
        return this.iconUri;
    }

    public final String e() {
        return this.title;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c0)) {
            return false;
        }
        c0 c0Var = (c0) obj;
        return d0.z.d.m.areEqual(this.title, c0Var.title) && d0.z.d.m.areEqual(this.description, c0Var.description) && d0.z.d.m.areEqual(this.iconRes, c0Var.iconRes) && d0.z.d.m.areEqual(this.iconUri, c0Var.iconUri) && d0.z.d.m.areEqual(this.iconTint, c0Var.iconTint) && d0.z.d.m.areEqual(this.titleTextColor, c0Var.titleTextColor) && d0.z.d.m.areEqual(this.titleEndIcon, c0Var.titleEndIcon);
    }

    public final Integer f() {
        return this.titleEndIcon;
    }

    public final Integer g() {
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
        StringBuilder sbU = b.d.b.a.a.U("SimpleBottomSheetItem(title=");
        sbU.append(this.title);
        sbU.append(", description=");
        sbU.append(this.description);
        sbU.append(", iconRes=");
        sbU.append(this.iconRes);
        sbU.append(", iconUri=");
        sbU.append(this.iconUri);
        sbU.append(", iconTint=");
        sbU.append(this.iconTint);
        sbU.append(", titleTextColor=");
        sbU.append(this.titleTextColor);
        sbU.append(", titleEndIcon=");
        return b.d.b.a.a.F(sbU, this.titleEndIcon, ")");
    }
}
