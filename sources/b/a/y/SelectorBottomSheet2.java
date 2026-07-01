package b.a.y;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import java.io.Serializable;
import org.objectweb.asm.Opcodes;

/* JADX INFO: renamed from: b.a.y.c0, reason: use source file name */
/* JADX INFO: compiled from: SelectorBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SelectorBottomSheet2 implements Serializable {
    private final CharSequence description;
    private final Integer iconRes;
    private final Integer iconTint;
    private final String iconUri;
    private final String title;
    private final Integer titleEndIcon;
    private final Integer titleTextColor;

    public SelectorBottomSheet2() {
        this(null, null, null, null, null, null, null, Opcodes.LAND);
    }

    public SelectorBottomSheet2(String str, CharSequence charSequence, Integer num, String str2, Integer num2, Integer num3, Integer num4, int i) {
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
        if (!(obj instanceof SelectorBottomSheet2)) {
            return false;
        }
        SelectorBottomSheet2 selectorBottomSheet2 = (SelectorBottomSheet2) obj;
        return Intrinsics3.areEqual(this.title, selectorBottomSheet2.title) && Intrinsics3.areEqual(this.description, selectorBottomSheet2.description) && Intrinsics3.areEqual(this.iconRes, selectorBottomSheet2.iconRes) && Intrinsics3.areEqual(this.iconUri, selectorBottomSheet2.iconUri) && Intrinsics3.areEqual(this.iconTint, selectorBottomSheet2.iconTint) && Intrinsics3.areEqual(this.titleTextColor, selectorBottomSheet2.titleTextColor) && Intrinsics3.areEqual(this.titleEndIcon, selectorBottomSheet2.titleEndIcon);
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
        StringBuilder sbU = outline.U("SimpleBottomSheetItem(title=");
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
        return outline.F(sbU, this.titleEndIcon, ")");
    }
}
