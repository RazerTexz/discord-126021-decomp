package b.i.a.g.k;

import android.text.InputFilter;
import android.text.Spanned;

/* JADX INFO: renamed from: b.i.a.g.k.d, reason: use source file name */
/* JADX INFO: compiled from: MaxInputValidator.java */
/* JADX INFO: loaded from: classes3.dex */
public class MaxInputValidator implements InputFilter {
    public int a;

    public MaxInputValidator(int i) {
        this.a = i;
    }

    @Override // android.text.InputFilter
    public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        try {
            StringBuilder sb = new StringBuilder(spanned);
            sb.replace(i3, i4, charSequence.subSequence(i, i2).toString());
            if (Integer.parseInt(sb.toString()) <= this.a) {
                return null;
            }
            return "";
        } catch (NumberFormatException unused) {
            return "";
        }
    }
}
