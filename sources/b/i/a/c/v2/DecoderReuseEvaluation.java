package b.i.a.c.v2;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import b.c.a.a0.AnimatableValueParser;
import b.d.b.a.outline;
import b.i.a.c.Format2;
import java.util.Objects;

/* JADX INFO: renamed from: b.i.a.c.v2.g, reason: use source file name */
/* JADX INFO: compiled from: DecoderReuseEvaluation.java */
/* JADX INFO: loaded from: classes3.dex */
public final class DecoderReuseEvaluation {
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Format2 f1144b;
    public final Format2 c;
    public final int d;
    public final int e;

    public DecoderReuseEvaluation(String str, Format2 format2, Format2 format3, int i, int i2) {
        AnimatableValueParser.j(i == 0 || i2 == 0);
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException();
        }
        this.a = str;
        Objects.requireNonNull(format2);
        this.f1144b = format2;
        this.c = format3;
        this.d = i;
        this.e = i2;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || DecoderReuseEvaluation.class != obj.getClass()) {
            return false;
        }
        DecoderReuseEvaluation decoderReuseEvaluation = (DecoderReuseEvaluation) obj;
        return this.d == decoderReuseEvaluation.d && this.e == decoderReuseEvaluation.e && this.a.equals(decoderReuseEvaluation.a) && this.f1144b.equals(decoderReuseEvaluation.f1144b) && this.c.equals(decoderReuseEvaluation.c);
    }

    public int hashCode() {
        return this.c.hashCode() + ((this.f1144b.hashCode() + outline.m(this.a, (((this.d + 527) * 31) + this.e) * 31, 31)) * 31);
    }
}
